use radix_engine::types::*;

/// A type holding its key internally.
/// In the paging use-cases, we list items (e.g. `{id: 7, name: John}`), but we identify a point in
/// the listing by some item's key (e.g. `7`).
///
/// A trivial - and sometimes actually feasible - implementation of keying is to simply use the
/// entire item (see below).
pub trait HasKey<K> {
    /// Returns the key.
    fn as_key(&self) -> K;
}

/// A sequence of deterministically-ordered elements, which knows how to efficiently start iteration
/// from an arbitrarily requested item.
pub trait RandomAccessIterable {
    /// Each [`Item`]'s key type.
    type Key;

    /// Item's type.
    type Item: HasKey<Self::Key>;

    /// Started iterator's type.
    type Iterator: Iterator<Item = Self::Item>;

    /// Type of error that might occur on starting the iteration.
    type Error;

    /// Turns itself into an iterator which:
    /// - either starts at the beginning of the sequence (if `from.is_none()`),
    /// - or starts at the given `from` element (if it is actually exists in the sequence),
    /// - or at the first actually-existing element after the given `from` (if the from was to be
    ///   inserted).
    ///
    /// In the "paging" scenario, the element mentioned in the last point above may no longer exist:
    /// - either because it was deleted from the sequence between requested pages,
    /// - or because it never existed (e.g. because it was a successor key generated by a [`Pager`]
    ///   itself only for continuation token's purposes).
    ///
    /// In general, this trait can be thought of as an expansion to the well-known `.iter()`
    /// convention, which simply supports an optional starting point.
    fn into_iter_from(self, from: Option<&Self::Key>) -> Result<Self::Iterator, Self::Error>;
}

/// A convenience wrapper that allows any `|from| some_lister.start_listing(from)` closure to be a
/// [`RandomAccessIterable`].
///
/// Note: in theory, this type could be replaced with just an `impl<T, F: FnOnce(Option<&T>) ->
/// Result<I, E>, I: Iterator<Item = T>, E> RandomAccessIterable for F`. However, due to a compiler
/// quirk, the lifetime of `&T` would not be properly generalized without the awkward explicit type
/// annotation - which additionally results in a pretty confusing compilation error message.
/// The `FnIterable::wrap(|from| ...)` syntax seems easier.
pub struct FnIterable<
    K,
    T: HasKey<K>,
    I: Iterator<Item = T>,
    F: FnOnce(Option<&K>) -> Result<I, E>,
    E,
> {
    function: F,
    type_parameter_phantom: PhantomData<(K, T, I, E)>,
}

impl<K, T: HasKey<K>, I: Iterator<Item = T>, F: FnOnce(Option<&K>) -> Result<I, E>, E>
    FnIterable<K, T, I, F, E>
{
    /// Wraps the given function into a [`RandomAccessIterable`].
    pub fn wrap(function: F) -> Self {
        Self {
            function,
            type_parameter_phantom: PhantomData,
        }
    }
}

impl<K, T: HasKey<K>, I: Iterator<Item = T>, F: FnOnce(Option<&K>) -> Result<I, E>, E>
    RandomAccessIterable for FnIterable<K, T, I, F, E>
{
    type Key = K;
    type Item = T;
    type Iterator = I;
    type Error = E;

    fn into_iter_from(self, from: Option<&Self::Key>) -> Result<Self::Iterator, Self::Error> {
        (self.function)(from)
    }
}

/// A policy for deciding how many items should fit on a page.
/// Each page requires a new instance of [`PagingPolicy`].
pub trait PagingPolicy<I> {
    /// Returns `true` if the scoped page allows to add yet another (given) item.
    ///
    /// After returning `false`, further calls to the same policy (even with different items) are
    /// allowed, but pointless - the policy must keep returning `false`.
    ///
    /// A policy also must always allow the first offered element, since a page with 0 items does
    /// not progress paging (and may only confuse the end-user, who sees an empty page followed by
    /// a continuation token).
    fn still_allows(&mut self, item: &I) -> bool;
}

/// A page of items.
pub struct Page<K, T: HasKey<K>> {
    /// Items on this page.
    pub items: Vec<T>,
    /// The next continuation token (only present if there are more pages after this one).
    pub continuation_token: Option<ContinuationToken<K>>,
}

impl<K, T: HasKey<K>> Page<K, T> {
    /// Creates a page of the given items; not continued by default.
    fn of(items: Vec<T>) -> Self {
        Self {
            items,
            continuation_token: None,
        }
    }

    /// Adds a continuation token to this page.
    fn continued(self, continuation_token: ContinuationToken<K>) -> Self {
        Self {
            items: self.items,
            continuation_token: Some(continuation_token),
        }
    }
}

/// A pager capable of extracting a single page from a [`RandomAccessIterable`] and handle both
/// the input and output continuation tokens.
pub trait Pager<I: RandomAccessIterable> {
    /// Reads from the given [`RandomAccessIterable`], starting from the point marked by the given
    /// continuation token, until reaching the *maximum* number of items allowed by the given
    /// [`PagingPolicy`].
    fn get_page(
        iterable: I,
        policy: impl PagingPolicy<I::Item>,
        token: Option<ContinuationToken<I::Key>>,
    ) -> Result<Page<I::Key, I::Item>, I::Error>;
}

/// A [`Pager`] implementation suitable for items whose order is deterministic, but not known at
/// this level of abstraction.
///
/// In such case, a pager is not capable of generating a successor key. Instead, it resumes
/// iteration from the last returned item, and ignores it on the next returned page. Since every
/// pager also has to load one more item (to know whether there are more pages), this particular
/// implementation "wastes" 2 unnecessarily-loaded items per page.
pub struct OrderAgnosticPager;

impl<I: RandomAccessIterable> Pager<I> for OrderAgnosticPager
where
    I::Key: PartialEq + Clone,
{
    fn get_page(
        iterable: I,
        policy: impl PagingPolicy<I::Item>,
        token: Option<ContinuationToken<I::Key>>,
    ) -> Result<Page<I::Key, I::Item>, I::Error> {
        // prepare the inputs and outputs:
        let last_previously_listed_key = token.map(|token| token.last_listed_item);
        let mut policy = policy;
        let mut items = Vec::new();

        // start the actual iteration from the previous page's last listed item (inclusive!):
        let mut item_iter = iterable.into_iter_from(last_previously_listed_key.as_ref())?;
        let mut opt_next_item = item_iter.next();

        if let Some(last_previously_listed_key) = last_previously_listed_key {
            let Some(first_item) = &opt_next_item else {
                // all items of the last page were deleted; we must return an empty page and no continuation:
                return Ok(Page::of(Vec::new()));
            };
            if first_item.as_key() == last_previously_listed_key {
                // very much expected (but not guaranteed, since the last previously listed item may have been deleted)
                opt_next_item = item_iter.next();
            }
        }

        // the continuation token (if any) was handled, so let's enter the page-collecting loop:
        loop {
            let Some(next_item) = opt_next_item else {
                // a genuine end of the sequence; we return this last page and no continuation:
                return Ok(Page::of(items));
            };
            if !policy.still_allows(&next_item) {
                // the policy stopped us...
                let Some(last_currently_listed_item) = items.last() else {
                    // ... but it did *not* accept any item!
                    panic!("broken contract: paging policy produced a 0-length page")
                };
                // ... so we advance the continuation token:
                let last_currently_listed_key = last_currently_listed_item.as_key().clone();
                return Ok(Page::of(items).continued(ContinuationToken::after(last_currently_listed_key)))
            }
            // the policy allowed this next element, so let's collect it and advance the iteration:
            items.push(next_item);
            opt_next_item = item_iter.next();
        }
    }
}

/// An opaque structure marking the point from which to resume the iteration.
/// Its only responsibility is to be transferred out of a [`Pager`], and then back in (presumably
/// using the SBOR encoding, which it supports).
#[derive(Sbor)]
pub struct ContinuationToken<T> {
    last_listed_item: T,
}

impl<T> ContinuationToken<T> {
    /// Creates a token which is supposed to continue with elements immediately after the given one.
    fn after(last_listed_item: T) -> Self {
        Self {
            last_listed_item,
        }
    }
}

/// A [`PagingPolicy`] allowing some maximum item count.
pub struct MaxItemCountPolicy {
    remaining_item_count: usize,
}

impl MaxItemCountPolicy {
    /// Creates a policy allowing at most the given number of items.
    /// Note: the less-specific return type here is deliberate - referencing `<I>` allows for more
    /// convenient type inference.
    #[allow(clippy::new_ret_no_self)]
    pub fn new<I>(max_item_count: usize) -> impl PagingPolicy<I> {
        Self {
            remaining_item_count: max_item_count,
        }
    }
}

impl<I> PagingPolicy<I> for MaxItemCountPolicy {
    fn still_allows(&mut self, _item: &I) -> bool {
        if self.remaining_item_count == 0 {
            return false;
        }
        self.remaining_item_count -= 1;
        true
    }
}

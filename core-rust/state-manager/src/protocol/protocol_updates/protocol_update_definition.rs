use crate::prelude::*;

/// A protocol update definition.
///
/// Note:
/// Currently, protocol updates are only interested in modifying the current ledger state.
/// Consecutive transaction batches to be executed and individually committed are defined by
/// [`Self::create_batch_generator()`].
/// Future protocol updates may additionally want to e.g. modify the configuration of some
/// services (like transaction validation rules). Such customizable parts will have to be
/// represented as other methods on this trait.
pub trait ProtocolUpdateDefinition {
    /// Additional (static) config which can be used to re-configure the updater.
    type Overrides: ScryptoDecode;

    fn resolve_ledger_state_identifiers(
        context: ProtocolUpdateContext,
    ) -> (Epoch, i64, StateVersion) {
        let db = context.database.lock();
        let latest_header = db
            .get_latest_proof()
            .expect("Should be a latest proof")
            .ledger_header;
        let latest_epoch_header = db
            .get_latest_epoch_proof()
            .expect("Should be a latest epoch proof")
            .ledger_header;
        (
            latest_epoch_header.epoch,
            latest_header.proposer_timestamp_ms,
            latest_header.state_version,
        )
    }

    /// Can be overriden for more efficient validation
    fn config_hash(
        &self,
        context: ProtocolUpdateContext,
        overrides_hash: Option<Hash>,
        overrides: Option<Self::Overrides>,
    ) -> Hash {
        self.create_batch_generator(context, overrides_hash, overrides)
            .config_hash()
    }

    /// Returns a provider of on-ledger actions to be executed as part of this protocol update.
    fn create_batch_generator(
        &self,
        context: ProtocolUpdateContext,
        overrides_hash: Option<Hash>,
        overrides: Option<Self::Overrides>,
    ) -> Box<dyn ProtocolUpdateNodeBatchGenerator>;
}

#[derive(Copy, Clone)]
pub struct ProtocolUpdateContext<'a> {
    pub network: &'a NetworkDefinition,
    pub database: &'a Arc<DbLock<ActualStateManagerDatabase>>,
    pub genesis_data_resolver: &'a Arc<dyn ResolveGenesisData>,
    pub scenario_config: &'a ScenariosExecutionConfig,
}

/// A convenience trait for easier validation/parsing of [`ProtocolUpdateDefinition::Overrides`],
/// automatically implemented for all [`ProtocolUpdateDefinition`].
pub trait ConfigurableProtocolUpdateDefinition {
    /// Resolves the configured config hash. This is used for a validation on boot-up.
    fn resolve_config_hash(
        &self,
        context: ProtocolUpdateContext,
        raw_overrides: Option<&[u8]>,
    ) -> Hash;

    /// Parses the given raw overrides and passes them to
    /// [`ProtocolUpdateDefinition::create_batch_generator`].
    /// Panics on any [`DecodeError`] from [`Self::validate_overrides()`].
    fn create_batch_generator_raw(
        &self,
        context: ProtocolUpdateContext,
        raw_overrides: Option<&[u8]>,
    ) -> Box<dyn ProtocolUpdateNodeBatchGenerator>;

    /// Checks that the given raw overrides can be parsed.
    fn validate_raw_overrides(&self, raw_overrides: &[u8]) -> Result<(), DecodeError>;
}

impl<T: ProtocolUpdateDefinition> ConfigurableProtocolUpdateDefinition for T {
    fn resolve_config_hash(
        &self,
        context: ProtocolUpdateContext,
        raw_overrides: Option<&[u8]>,
    ) -> Hash {
        let overrides = raw_overrides
            .map(scrypto_decode::<<Self as ProtocolUpdateDefinition>::Overrides>)
            .transpose()
            .expect("Raw overrides should have been validated before being passed to this method");

        let overrides_hash = raw_overrides.map(hash);

        self.config_hash(context, overrides_hash, overrides)
    }

    fn create_batch_generator_raw(
        &self,
        context: ProtocolUpdateContext,
        raw_overrides: Option<&[u8]>,
    ) -> Box<dyn ProtocolUpdateNodeBatchGenerator> {
        let overrides = raw_overrides
            .map(scrypto_decode::<<Self as ProtocolUpdateDefinition>::Overrides>)
            .transpose()
            .expect("Raw overrides should have been validated before being passed to this method");

        let overrides_hash = raw_overrides.map(hash);

        self.create_batch_generator(context, overrides_hash, overrides)
    }

    fn validate_raw_overrides(&self, raw_overrides: &[u8]) -> Result<(), DecodeError> {
        scrypto_decode::<<Self as ProtocolUpdateDefinition>::Overrides>(raw_overrides).map(|_| ())
    }
}

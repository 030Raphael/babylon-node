package com.radixdlt.tempo.epics;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Streams;
import com.radixdlt.common.AID;
import com.radixdlt.tempo.AtomStoreView;
import com.radixdlt.tempo.TempoFlow;
import com.radixdlt.tempo.reactive.TempoAction;
import com.radixdlt.tempo.reactive.TempoEpic;
import com.radixdlt.tempo.reactive.TempoState;
import com.radixdlt.tempo.actions.OnAtomDeliveryFailedAction;
import com.radixdlt.tempo.actions.ReceiveAtomAction;
import com.radixdlt.tempo.actions.messaging.ReceiveDeliveryRequestAction;
import com.radixdlt.tempo.actions.messaging.ReceiveDeliveryResponseAction;
import com.radixdlt.tempo.actions.RequestDeliveryAction;
import com.radixdlt.tempo.actions.messaging.SendDeliveryRequestAction;
import com.radixdlt.tempo.actions.messaging.SendDeliveryResponseAction;
import com.radixdlt.tempo.actions.TimeoutDeliveryRequestAction;
import com.radixdlt.tempo.state.AtomDeliveryState;
import org.radix.logging.Logger;
import org.radix.logging.Logging;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public final class AtomDeliveryEpic implements TempoEpic {
	private static final int DELIVERY_REQUEST_TIMEOUT_SECONDS = 5;
	private static final int DEFER_DELIVERY_REQUEST_TIMEOUT_SECONDS = 5;

	private static final Logger logger = Logging.getLogger("Sync");

	private final AtomStoreView store;

	private AtomDeliveryEpic(AtomStoreView store) {
		this.store = store;
	}

	@Override
	public Set<Class<? extends TempoState>> requiredState() {
		return ImmutableSet.of(AtomDeliveryState.class);
	}

	@Override
	public Stream<TempoAction> epic(TempoFlow flow) {
		Stream<SendDeliveryResponseAction> sendResponses =
			flow.of(ReceiveDeliveryRequestAction.class)
			.flatMap(request -> request.getAids().stream()
				.map(store::get)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.map(atom -> new SendDeliveryResponseAction(atom, request.getPeer()))
			);
		Stream<TempoAction> receiveResponses = flow.of(ReceiveDeliveryResponseAction.class)
			.map(response -> new ReceiveAtomAction(response.getAtom()));

		// TODO cleanup
		Stream<TempoAction> handleRequests = flow.ofStateful(RequestDeliveryAction.class, AtomDeliveryState.class)
			.flatMap(requestWithState -> {
				// check if any requested deliveries have not arrived in the meantime
				RequestDeliveryAction request = requestWithState.getAction();
				AtomDeliveryState deliveryState = requestWithState.getBundle().get(AtomDeliveryState.class);
				ImmutableList<AID> missingAids = request.getAids().stream()
					.filter(aid -> !store.contains(aid))
					.collect(ImmutableList.toImmutableList());

				// if a subset of deliveries is missing, figure out which ones to request and defer
				if (!missingAids.isEmpty()) {
					// TODO potential concurrency problems here?
					ImmutableList<AID> ongoingAids = missingAids.stream()
						.filter(deliveryState::isPendingDelivery)
						.collect(ImmutableList.toImmutableList());
					ImmutableList<AID> unrequestedAids = missingAids.stream()
						.filter(aid -> !deliveryState.isPendingDelivery(aid))
						.collect(ImmutableList.toImmutableList());

					// defer already ongoing deliveries until later (in case the ongoing ones fail)
					Stream<TempoAction> deferred;
					if (!ongoingAids.isEmpty()) {
						deferred = Stream.of(new RequestDeliveryAction(ongoingAids, request.getPeer())
							.delay(DEFER_DELIVERY_REQUEST_TIMEOUT_SECONDS, TimeUnit.SECONDS));
					} else {
						deferred = Stream.empty();
					}

					// request delivery of all aids that are not currently being delivered
					Stream<TempoAction> requested;
					if (!unrequestedAids.isEmpty()) {
						SendDeliveryRequestAction sendAction = new SendDeliveryRequestAction(unrequestedAids, request.getPeer());
						logger.info("Requesting delivery of " + unrequestedAids.size() + " aids from " + request.getPeer());
						// schedule timeout after which deliveries will be checked
						TimeoutDeliveryRequestAction timeoutAction = new TimeoutDeliveryRequestAction(sendAction.getAids(), sendAction.getPeer());
						requested = Stream.of(sendAction, timeoutAction.delay(DELIVERY_REQUEST_TIMEOUT_SECONDS, TimeUnit.SECONDS));
					} else {
						requested = Stream.empty();
					}

					return Stream.concat(deferred, requested);
				}
				return Stream.empty();
			});

		Stream<TempoAction> handleTimeouts = flow.ofStateful(TimeoutDeliveryRequestAction.class, AtomDeliveryState.class)
			.flatMap(requestWithState -> {
				// once the timeout has elapsed, check if the deliveries were received
				TimeoutDeliveryRequestAction timeout = requestWithState.getAction();
				AtomDeliveryState deliveryState = requestWithState.getBundle().get(AtomDeliveryState.class);
				ImmutableList<AID> missingAids = timeout.getAids().stream()
					.filter(deliveryState::isPendingDelivery)
					.collect(ImmutableList.toImmutableList());
				// if the deliveries weren't received, raise a failed delivery action for the requestor
				if (!missingAids.isEmpty()) {
					// TODO consider re-requesting from the same peer once (add TTL counter to timeout action)
					logger.warn("Delivery of " + missingAids.size() + " aids from " + timeout.getPeer() + " has timed out");
					// TODO handle / log this somewhere?
					return Stream.of(new OnAtomDeliveryFailedAction(missingAids, timeout.getPeer()));
				}
				return Stream.empty();
			});

		return Streams.concat(
			sendResponses,
			receiveResponses,
			handleRequests,
			handleTimeouts
		);
	}


	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private AtomStoreView storeView;

		private Builder() {
		}

		public Builder storeView(AtomStoreView view) {
			this.storeView = view;
			return this;
		}

		public AtomDeliveryEpic build() {
			Objects.requireNonNull(this.storeView, "storeView is required");

			return new AtomDeliveryEpic(this.storeView);
		}
	}
}

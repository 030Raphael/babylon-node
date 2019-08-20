package com.radixdlt.tempo;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.radixdlt.common.EUID;
import com.radixdlt.serialization.DsonOutput;
import com.radixdlt.serialization.Serialization;
import com.radixdlt.tempo.actions.AcceptAtomAction;
import com.radixdlt.tempo.actions.OnConflictResolvedAction;
import com.radixdlt.tempo.actions.RaiseConflictAction;
import com.radixdlt.tempo.actions.ReceiveAtomAction;
import com.radixdlt.tempo.actions.RefreshLivePeersAction;
import com.radixdlt.tempo.actions.ReselectPassivePeersAction;
import com.radixdlt.tempo.actions.ResetAction;
import com.radixdlt.tempo.actions.control.RepeatScheduleAction;
import com.radixdlt.tempo.actions.control.ScheduleAction;
import com.radixdlt.tempo.actions.messaging.ReceiveDeliveryRequestAction;
import com.radixdlt.tempo.actions.messaging.ReceiveDeliveryResponseAction;
import com.radixdlt.tempo.actions.messaging.ReceiveCursorDiscoveryRequestAction;
import com.radixdlt.tempo.actions.messaging.ReceiveCursorDiscoveryResponseAction;
import com.radixdlt.tempo.actions.messaging.ReceivePositionDiscoveryRequestAction;
import com.radixdlt.tempo.actions.messaging.ReceivePositionDiscoveryResponseAction;
import com.radixdlt.tempo.actions.messaging.ReceivePushAction;
import com.radixdlt.tempo.actions.messaging.ReceiveSampleRequestAction;
import com.radixdlt.tempo.actions.messaging.ReceiveSampleResponseAction;
import com.radixdlt.tempo.actions.messaging.SendDeliveryRequestAction;
import com.radixdlt.tempo.actions.messaging.SendDeliveryResponseAction;
import com.radixdlt.tempo.actions.messaging.SendCursorDiscoveryRequestAction;
import com.radixdlt.tempo.actions.messaging.SendCursorDiscoveryResponseAction;
import com.radixdlt.tempo.actions.messaging.SendPositionDiscoveryRequestAction;
import com.radixdlt.tempo.actions.messaging.SendPositionDiscoveryResponseAction;
import com.radixdlt.tempo.actions.messaging.SendPushAction;
import com.radixdlt.tempo.actions.messaging.SendSampleRequestAction;
import com.radixdlt.tempo.actions.messaging.SendSampleResponseAction;
import com.radixdlt.tempo.epics.ActiveSyncEpic;
import com.radixdlt.tempo.epics.AtomDeliveryEpic;
import com.radixdlt.tempo.epics.IterativeDiscoveryEpic;
import com.radixdlt.tempo.epics.LocalResolverEpic;
import com.radixdlt.tempo.epics.MessagingEpic;
import com.radixdlt.tempo.epics.MomentumResolverEpic;
import com.radixdlt.tempo.epics.SampleCollectorEpic;
import com.radixdlt.tempo.messages.DeliveryRequestMessage;
import com.radixdlt.tempo.messages.DeliveryResponseMessage;
import com.radixdlt.tempo.messages.CursorDiscoveryRequestMessage;
import com.radixdlt.tempo.messages.CursorDiscoveryResponseMessage;
import com.radixdlt.tempo.messages.PositionDiscoveryRequestMessage;
import com.radixdlt.tempo.messages.PositionDiscoveryResponseMessage;
import com.radixdlt.tempo.messages.PushMessage;
import com.radixdlt.tempo.messages.SampleRequestMessage;
import com.radixdlt.tempo.messages.SampleResponseMessage;
import com.radixdlt.tempo.reactive.TempoFlowSource;
import com.radixdlt.tempo.reactive.TempoFlowSource.TempoFlowInjector;
import com.radixdlt.tempo.reducers.AtomDeliveryReducer;
import com.radixdlt.tempo.reducers.ConflictsStateReducer;
import com.radixdlt.tempo.reducers.CursorDiscoveryReducer;
import com.radixdlt.tempo.reducers.LivePeersReducer;
import com.radixdlt.tempo.reducers.PassivePeersReducer;
import com.radixdlt.tempo.reducers.PositionDiscoveryReducer;
import com.radixdlt.tempo.reducers.SampleCollectorReducer;
import com.radixdlt.tempo.reactive.TempoAction;
import com.radixdlt.tempo.reactive.TempoEpic;
import com.radixdlt.tempo.reactive.TempoReducer;
import com.radixdlt.tempo.reactive.TempoState;
import com.radixdlt.tempo.state.AtomDeliveryState;
import com.radixdlt.tempo.state.ConflictsState;
import com.radixdlt.tempo.state.CursorDiscoveryState;
import com.radixdlt.tempo.state.LivePeersState;
import com.radixdlt.tempo.state.PassivePeersState;
import com.radixdlt.tempo.state.SampleCollectorState;
import com.radixdlt.tempo.store.CommitmentStore;
import com.radixdlt.tempo.store.LogicalClockCursorStore;
import com.radixdlt.tempo.store.SampleStore;
import org.json.JSONObject;
import org.radix.database.DatabaseEnvironment;
import org.radix.logging.Logger;
import org.radix.logging.Logging;
import org.radix.modules.Modules;
import org.radix.network.messaging.Messaging;
import org.radix.network.peers.PeerHandler;
import org.radix.properties.RuntimeProperties;
import org.radix.universe.system.LocalSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class TempoController {
	private static final Logger logger = Logging.getLogger("Tempo");

	private static final int FULL_INBOUND_QUEUE_RESCHEDULE_TIME_SECONDS = 1;
	private static final int TEMPO_EXECUTOR_POOL_COUNT = 4;
	private static final boolean RUN_EPICS_ASYNCHRONOUSLY = true;

	private final BlockingQueue<TempoAtom> inboundAtoms;
	private final BlockingQueue<TempoAction> actions;
	private final List<TempoReducer> reducers;
	private final TempoFlowInjector flowInjector;
	private final ScheduledExecutorService executor;

	private final ConcurrentMap<EUID, CompletableFuture<TempoAtom>> pendingConflictFutures;
	private final TempoStateBundleGenerator stateStore;

	private TempoController(int inboundQueueCapacity,
	                        int actionsQueueCapacity,
	                        List<TempoReducer> reducers,
	                        List<TempoEpic> epics,
	                        List<Function<ImmediateDispatcher, TempoEpic>> epicBuilders,
	                        List<TempoAction> initialActions) {
		this.inboundAtoms = new LinkedBlockingQueue<>(inboundQueueCapacity);
		this.actions = new LinkedBlockingQueue<>(actionsQueueCapacity);
		this.executor = Executors.newScheduledThreadPool(TEMPO_EXECUTOR_POOL_COUNT, this::createTempoExecutorThread);
		this.stateStore = new TempoStateBundleGenerator();
		this.pendingConflictFutures = new ConcurrentHashMap<>();

		this.reducers = reducers;
		TempoFlowSource flowSource = new TempoFlowSource();
		List<TempoEpic> allEpics = ImmutableList.<TempoEpic>builder()
			.addAll(epics)
			// TODO get rid of epicBuilders
			.addAll(epicBuilders.stream()
				.map(epicBuilder -> epicBuilder.apply(this::dispatch))
				.collect(Collectors.toList()))
			.build();
		// connect flow and epics
		allEpics.stream()
			.flatMap(epic -> epic.epic(flowSource))
			.forEach(flow -> flow.forEach(this::dispatch));
		this.flowInjector = flowSource.toInjector();

		// dispatch initial actions
		Stream.concat(initialActions.stream(), allEpics.stream()
			.flatMap(TempoEpic::initialActions))
			.forEach(this::dispatch);

		Thread tempoDaemon = new Thread(this::run);
		tempoDaemon.setName("Tempo Core");
		tempoDaemon.setDaemon(true);
		tempoDaemon.start();
	}

	private Thread createTempoExecutorThread(Runnable runnable) {
		Thread thread = new Thread(null, runnable, "Tempo Executor");
		thread.setDaemon(true);
		return thread;
	}

	// TODO this is a spartanic approach to reactive streams, should be replaced down the line
	private void run() {
		// put initial state in store
		reducers.forEach(reducer -> stateStore.put(reducer.stateClass(), reducer.initialState()));

		while (true) {
			try {
				TempoAction action = actions.take();
				if (logger.hasLevel(Logging.DEBUG)) {
					logger.debug("Executing " + action.getClass().getSimpleName());
				}

				// run reducers synchronously to update state
				reducers.forEach(reducer -> {
					TempoState nextState = executeReducer(reducer, action, stateStore);
					stateStore.put(reducer.stateClass(), nextState);
				});

				internalEpic(action);
				// TODO run in multiple threads
				executeEpics(action, stateStore);
			} catch (InterruptedException e) {
				// exit if interrupted
				Thread.currentThread().interrupt();
				break;
			}
		}
	}

	private void executeEpics(TempoAction action, TempoStateBundleGenerator stateStore) {
		try {
			flowInjector.inject(action, stateStore::bundleFor);
		} catch (Exception e) {
			logger.error(String.format("Error while executing '%s': '%s'", action.getClass().getSimpleName(), e.toString()));
		}
	}

	private TempoState executeReducer(TempoReducer reducer, TempoAction action, TempoStateBundleGenerator stateStore) {
		TempoState prevState = stateStore.get(reducer.stateClass());
		try {
			TempoStateBundle bundle = stateStore.bundleFor(reducer.requiredState());
			return reducer.reduce(prevState, bundle, action);
		} catch (Exception e) {
			logger.error(String.format("Error while executing %s in %s: '%s'",
				action.getClass().getSimpleName(), reducer.getClass().getSimpleName(), e.toString()), e);
			return prevState;
		}
	}

	public interface ImmediateDispatcher {
		void dispatch(TempoAction action);
	}

	private void delay(TempoAction action, long delay, TimeUnit unit) {
		// TODO consider cancellation when shutdown/reset
		this.executor.schedule(() -> dispatch(action), delay, unit);
	}

	private void repeatSchedule(TempoAction action, long initialDelay, long recurrentDelay, TimeUnit unit, BooleanSupplier terminationCondition) {
		// TODO consider cancellation when shutdown/reset
		// TODO there must be a nicer way to do cancellation
		ScheduledFuture[] futureHolder = new ScheduledFuture[1];
		ScheduledFuture<?> future = this.executor.scheduleAtFixedRate(() -> {
			if (terminationCondition.getAsBoolean()) {
				futureHolder[0].cancel(false);
			} else {
				dispatch(action);
			}
		}, initialDelay, recurrentDelay, unit);
		futureHolder[0] = future;
	}

	private void dispatch(TempoAction action) {
		if (!this.actions.add(action)) {
			// TODO handle full action queue better
			throw new IllegalStateException("Action queue full");
		}
	}

	private void internalEpic(TempoAction action) {
		if (action instanceof ReceiveAtomAction) {
			// try to add to inbound queue
			TempoAtom atom = ((ReceiveAtomAction) action).getAtom();
			if (!inboundAtoms.add(atom)) {
				// reschedule
				delay(action, FULL_INBOUND_QUEUE_RESCHEDULE_TIME_SECONDS, TimeUnit.SECONDS);
			}
		} else if (action instanceof OnConflictResolvedAction) {
			OnConflictResolvedAction resolution = (OnConflictResolvedAction) action;
			EUID tag = resolution.getTag();
			CompletableFuture<TempoAtom> future = pendingConflictFutures.remove(tag);
			if (future == null) {
				logger.warn("There is no pending future for conflict with tag '" + tag + "'");
			} else {
				future.complete(resolution.getWinner());
			}
		} else if (action instanceof ScheduleAction) {
			ScheduleAction schedule = (ScheduleAction) action;
			delay(schedule.getAction(), schedule.getDelay(), schedule.getUnit());
		} else if (action instanceof RepeatScheduleAction) {
			RepeatScheduleAction schedule = (RepeatScheduleAction) action;
			repeatSchedule(schedule.getAction(), schedule.getInitialDelay(), schedule.getRecurrentDelay(), schedule.getUnit(), schedule::checkShouldTerminate);
		}
	}

	public CompletableFuture<TempoAtom> resolve(TempoAtom atom, Collection<TempoAtom> conflictingAtoms) {
		CompletableFuture<TempoAtom> winnerFuture = new CompletableFuture<>();
		RaiseConflictAction conflict = new RaiseConflictAction(atom, conflictingAtoms);
		pendingConflictFutures.put(conflict.getTag(), winnerFuture);
		this.dispatch(conflict);

		return winnerFuture;
	}

	public void accept(TempoAtom atom) {
		this.dispatch(new AcceptAtomAction(atom));
	}

	public void queue(TempoAtom atom) {
		this.dispatch(new ReceiveAtomAction(atom));
	}

	public TempoAtom receive() throws InterruptedException {
		return this.inboundAtoms.take();
	}

	int getInboundQueueSize() {
		return this.inboundAtoms.size();
	}

	int getActionQueueSize() {
		return this.actions.size();
	}

	// TODO figure out nicer way to reset
	void reset() {
		this.inboundAtoms.clear();
		this.actions.clear();
		ResetAction reset = new ResetAction();
		this.flowInjector.inject(reset, stateStore::bundleFor);
	}

	// TODO temporary hack for debugging, revisit or remove later
	private static final Map<String, Class<? extends TempoState>> exposedStateClassMap = ImmutableMap.<String, Class<? extends TempoState>>builder()
		.put("atomDelivery", AtomDeliveryState.class)
		.put("conflicts", ConflictsState.class)
		.put("iterativeDiscovery", CursorDiscoveryState.class)
		.put("livePeers", LivePeersState.class)
		.put("passivePeers", PassivePeersState.class)
		.put("sampleCollector", SampleCollectorState.class)
		.build();

	public JSONObject getJsonRepresentation(String stateClassName) {
		Class<? extends TempoState> stateClass = exposedStateClassMap.get(stateClassName);
		TempoState state = stateStore.get(stateClass);
		if (state == null) {
			JSONObject error = new JSONObject();
			error.put("error", "<unavailable>");
			return error;
		}

		Serialization serialization = Serialization.getDefault();
		return serialization.toJsonObject(state.getDebugRepresentation(), DsonOutput.Output.ALL);
	}

	public JSONObject getJsonRepresentation() {
		ImmutableMap.Builder<String, Object> states = ImmutableMap.builder();
		exposedStateClassMap.forEach((name, cls) -> {
			TempoState state = stateStore.get(cls);
			if (state != null) {
				states.put(name, state.getDebugRepresentation());
			} else {
				states.put(name, "<unavailable>");
			}
		});
		Serialization serialization = Serialization.getDefault();
		return serialization.toJsonObject(states.build(), DsonOutput.Output.ALL);
	}

	public static Builder defaultBuilder(AtomStoreView storeView) {
		LocalSystem localSystem = LocalSystem.getInstance();
		PeerSupplier peerSupplier = new PeerSupplierAdapter(() -> Modules.get(PeerHandler.class));
		Supplier<DatabaseEnvironment> dbEnv = () -> Modules.get(DatabaseEnvironment.class);
		Serialization serialization = Serialization.getDefault();
		Builder builder = builder()
			.addEpic(AtomDeliveryEpic.builder()
				.storeView(storeView)
				.build())
			.addEpicBuilder(controller -> MessagingEpic.builder()
				.messager(Messaging.getInstance())
				.addInbound("tempo.sync.delivery.request", DeliveryRequestMessage.class, ReceiveDeliveryRequestAction::from)
				.addOutbound(SendDeliveryRequestAction.class, SendDeliveryRequestAction::toMessage, SendDeliveryRequestAction::getPeer)
				.addInbound("tempo.sync.delivery.response", DeliveryResponseMessage.class, ReceiveDeliveryResponseAction::from)
				.addOutbound(SendDeliveryResponseAction.class, SendDeliveryResponseAction::toMessage, SendDeliveryResponseAction::getPeer)
				.addInbound("tempo.sync.discovery.cursor.request", CursorDiscoveryRequestMessage.class, ReceiveCursorDiscoveryRequestAction::from)
				.addOutbound(SendCursorDiscoveryRequestAction.class, SendCursorDiscoveryRequestAction::toMessage, SendCursorDiscoveryRequestAction::getPeer)
				.addInbound("tempo.sync.discovery.cursor.response", CursorDiscoveryResponseMessage.class, ReceiveCursorDiscoveryResponseAction::from)
				.addOutbound(SendCursorDiscoveryResponseAction.class, SendCursorDiscoveryResponseAction::toMessage, SendCursorDiscoveryResponseAction::getPeer)
				.addInbound("tempo.sync.discovery.position.request", PositionDiscoveryRequestMessage.class, ReceivePositionDiscoveryRequestAction::from)
				.addOutbound(SendPositionDiscoveryRequestAction.class, SendPositionDiscoveryRequestAction::toMessage, SendPositionDiscoveryRequestAction::getPeer)
				.addInbound("tempo.sync.discovery.position.response", PositionDiscoveryResponseMessage.class, ReceivePositionDiscoveryResponseAction::from)
				.addOutbound(SendPositionDiscoveryResponseAction.class, SendPositionDiscoveryResponseAction::toMessage, SendPositionDiscoveryResponseAction::getPeer)
				.addInbound("tempo.sync.push", PushMessage.class, ReceivePushAction::from)
				.addOutbound(SendPushAction.class, SendPushAction::toMessage, SendPushAction::getPeer)
				.addInbound("tempo.sample.request", SampleRequestMessage.class, ReceiveSampleRequestAction::from)
				.addOutbound(SendSampleRequestAction.class, SendSampleRequestAction::toMessage, SendSampleRequestAction::getPeer)
				.addInbound("tempo.sample.response", SampleResponseMessage.class, ReceiveSampleResponseAction::from)
				.addOutbound(SendSampleResponseAction.class, SendSampleResponseAction::toMessage, SendSampleResponseAction::getPeer)
				.build(controller))
			.addReducer(new LivePeersReducer(peerSupplier))
			.addReducer(new PassivePeersReducer(16))
			.addReducer(new AtomDeliveryReducer())
			.addInitialAction(new RefreshLivePeersAction().repeat(10, 5, TimeUnit.SECONDS))
			.addInitialAction(new ReselectPassivePeersAction().repeat(10, 20, TimeUnit.SECONDS));

		// TODO improve config parsing
		RuntimeProperties properties = Modules.get(RuntimeProperties.class);
		String[] syncFeatures = properties.get("tempo2.sync", "active,iterative").split(",");
		String resolver = properties.get("tempo2.resolver", "local");
		logger.info(String.format("Creating Tempo controller with sync='%s' and resolver='%s'",
			Arrays.toString(syncFeatures), resolver));
		if (Arrays.stream(syncFeatures).anyMatch("active"::equalsIgnoreCase)) {
			builder.addEpic(new ActiveSyncEpic(localSystem.getNID()));
		}
		if (Arrays.stream(syncFeatures).anyMatch("iterative"::equalsIgnoreCase)) {
			LogicalClockCursorStore cursorStore = new LogicalClockCursorStore(dbEnv);
			cursorStore.open();
			CommitmentStore commitmentStore = new CommitmentStore(dbEnv);
			commitmentStore.open();
			builder.addEpic(IterativeDiscoveryEpic.builder()
				.self(localSystem.getNID())
				.shardSpaceSupplier(localSystem::getShards)
				.storeView(storeView)
				.cursorStore(cursorStore)
				.commitmentStore(commitmentStore)
				.build());
			builder.addReducer(new CursorDiscoveryReducer());
			builder.addReducer(new PositionDiscoveryReducer());
		}
		if (resolver.equalsIgnoreCase("local")) {
			builder.addEpic(new LocalResolverEpic(localSystem.getNID()));
		} else if (resolver.equalsIgnoreCase("momentum")) {
			SampleSelector sampleSelector = new SimpleSampleSelector(localSystem.getNID());
			SampleStore store = new SampleStore(dbEnv, serialization);
			store.open();
			builder.addEpic(new MomentumResolverEpic(sampleSelector));
			builder.addEpic(new SampleCollectorEpic(localSystem.getNID(), store));
			builder.addReducer(new ConflictsStateReducer());
			builder.addReducer(new SampleCollectorReducer());
		} else {
			throw new TempoException("No conflict resolver selected: '" + resolver + "'");
		}

		return builder;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private int inboundQueueCapacity = 1 << 14;
		private int syncActionsQueueCapacity = 1 << 16;
		private final List<TempoEpic> epics = new ArrayList<>();
		private final List<TempoReducer> reducers = new ArrayList<>();
		private final List<Function<ImmediateDispatcher, TempoEpic>> epicBuilders = new ArrayList<>();
		private final List<TempoAction> initialActions = new ArrayList<>();

		private Builder() {
		}

		public Builder inboundQueueCapacity(int capacity) {
			this.inboundQueueCapacity = capacity;
			return this;
		}

		public Builder actionQueueCapacity(int capacity) {
			this.syncActionsQueueCapacity = capacity;
			return this;
		}

		public Builder addEpic(TempoEpic epic) {
			Objects.requireNonNull(epic, "epic is required");
			this.epics.add(epic);
			return this;
		}

		public Builder addEpicBuilder(Function<ImmediateDispatcher, TempoEpic> epicBuilder) {
			Objects.requireNonNull(epicBuilder, "epicBuilder is required");
			this.epicBuilders.add(epicBuilder);
			return this;
		}

		public Builder addReducer(TempoReducer reducer) {
			Objects.requireNonNull(reducer, "reducer is required");
			this.reducers.add(reducer);
			return this;
		}

		public Builder addInitialAction(TempoAction initialAction) {
			Objects.requireNonNull(initialAction, "initialAction is required");
			this.initialActions.add(initialAction);
			return this;
		}

		public TempoController build() {
			return new TempoController(
				inboundQueueCapacity,
				syncActionsQueueCapacity,
				reducers,
				epics,
				epicBuilders,
				initialActions
			);
		}
	}
}

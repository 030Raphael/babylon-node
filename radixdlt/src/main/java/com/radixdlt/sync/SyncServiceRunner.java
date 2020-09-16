/*
 * (C) Copyright 2020 Radix DLT Ltd
 *
 * Radix DLT Ltd licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the License.
 */

package com.radixdlt.sync;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.radixdlt.ModuleRunner;
import com.radixdlt.ledger.LedgerUpdate;
import com.radixdlt.sync.BaseLocalSyncServiceProcessor.SyncInProgress;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.radixdlt.utils.ThreadFactories;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Manages thread safety and is the runner for the Sync Service Processor.
 */
@Singleton
public final class SyncServiceRunner<T extends LedgerUpdate> implements ModuleRunner {
	private static final Logger log = LogManager.getLogger();

	public interface LocalSyncRequestsRx {
		Observable<LocalSyncRequest> localSyncRequests();
	}

	public interface SyncTimeoutsRx {
		Observable<SyncInProgress> timeouts();
	}

	private final StateSyncNetwork stateSyncNetwork;
	private final Scheduler singleThreadScheduler;
	private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(ThreadFactories.daemonThreads("SyncManager"));
	private final LocalSyncServiceProcessor<T> localSyncServiceProcessor;
	private final RemoteSyncServiceProcessor remoteSyncServiceProcessor;
	private final SyncTimeoutsRx syncTimeoutsRx;
	private final LocalSyncRequestsRx localSyncRequestsRx;
	private final Observable<T> ledgerUpdates;
	private final Object lock = new Object();
	private CompositeDisposable compositeDisposable;

	@Inject
	public SyncServiceRunner(
		LocalSyncRequestsRx localSyncRequestsRx,
		SyncTimeoutsRx syncTimeoutsRx,
		Observable<T> ledgerUpdates,
		StateSyncNetwork stateSyncNetwork,
		LocalSyncServiceProcessor<T> localSyncServiceProcessor,
		RemoteSyncServiceProcessor remoteSyncServiceProcessor
	) {
		this.localSyncRequestsRx = Objects.requireNonNull(localSyncRequestsRx);
		this.syncTimeoutsRx = Objects.requireNonNull(syncTimeoutsRx);
		this.ledgerUpdates = Objects.requireNonNull(ledgerUpdates);
		this.localSyncServiceProcessor = Objects.requireNonNull(localSyncServiceProcessor);
		this.stateSyncNetwork = Objects.requireNonNull(stateSyncNetwork);
		this.singleThreadScheduler = Schedulers.from(this.executorService);
		this.remoteSyncServiceProcessor = Objects.requireNonNull(remoteSyncServiceProcessor);

	}

	/**
	 * Start the service
	 */
	@Override
	public void start() {
		synchronized (lock) {
			if (compositeDisposable != null) {
				return;
			}

			Disposable d0 = stateSyncNetwork.syncRequests()
				.observeOn(singleThreadScheduler)
				.subscribe(remoteSyncServiceProcessor::processRemoteSyncRequest);

			Disposable d1 = stateSyncNetwork.syncResponses()
				.observeOn(singleThreadScheduler)
				.subscribe(localSyncServiceProcessor::processSyncResponse);

			Disposable d2 = localSyncRequestsRx.localSyncRequests()
				.observeOn(singleThreadScheduler)
				.subscribe(localSyncServiceProcessor::processLocalSyncRequest);

			Disposable d3 = syncTimeoutsRx.timeouts()
				.observeOn(singleThreadScheduler)
				.subscribe(localSyncServiceProcessor::processSyncTimeout);

			Disposable d4 = ledgerUpdates
				.observeOn(singleThreadScheduler)
				.subscribe(localSyncServiceProcessor::processLedgerUpdate);

			compositeDisposable = new CompositeDisposable(d0, d1, d2, d3, d4);
		}

		log.info("Sync started");
	}

	/**
	 * Stop the service and cleanup resources
	 */
	@Override
	public void stop() {
		synchronized (lock) {
			if (compositeDisposable != null) {
				compositeDisposable.dispose();
				compositeDisposable = null;
			}
		}
	}
}
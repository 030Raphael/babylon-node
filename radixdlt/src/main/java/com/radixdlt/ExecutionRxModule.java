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

package com.radixdlt;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import com.radixdlt.api.DeserializationFailure;
import com.radixdlt.api.LedgerRx;
import com.radixdlt.api.SubmissionErrorsRx;
import com.radixdlt.api.SubmissionFailure;
import com.radixdlt.atommodel.Atom;
import com.radixdlt.consensus.CommittedStateSync;
import com.radixdlt.consensus.CommittedStateSyncRx;
import com.radixdlt.engine.RadixEngineException;
import com.radixdlt.mempool.SubmissionControlImpl.SubmissionControlSender;
import com.radixdlt.middleware2.ClientAtom;
import com.radixdlt.middleware2.converters.AtomConversionException;
import com.radixdlt.syncer.LocalSyncRequest;
import com.radixdlt.syncer.SyncExecutor.CommittedSender;
import com.radixdlt.syncer.SyncExecutor.CommittedCommandWithResult;
import com.radixdlt.syncer.SyncServiceProcessor.SyncInProgress;
import com.radixdlt.syncer.SyncServiceProcessor.SyncTimeoutScheduler;
import com.radixdlt.syncer.SyncServiceRunner.LocalSyncRequestsRx;
import com.radixdlt.syncer.SyncServiceRunner.SyncTimeoutsRx;
import com.radixdlt.syncer.SyncExecutor.CommittedStateSyncSender;
import com.radixdlt.syncer.SyncExecutor.SyncService;
import com.radixdlt.utils.ScheduledSenderToRx;
import com.radixdlt.utils.SenderToRx;
import com.radixdlt.utils.ThreadFactories;
import com.radixdlt.utils.TwoSenderToRx;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Module which manages messages from Syncer
 */
public final class ExecutionRxModule extends AbstractModule {

	@Override
	protected void configure() {
		Multibinder<CommittedSender> committedSenderBinder = Multibinder.newSetBinder(binder(), CommittedSender.class);
		SenderToRx<CommittedCommandWithResult, CommittedCommandWithResult> committed = new SenderToRx<>(c -> c);
		committedSenderBinder.addBinding().toInstance(committed::send);
		bind(LedgerRx.class).toInstance(committed::rx);

		TwoSenderToRx<Atom, AtomConversionException, DeserializationFailure> deserializationFailures
			= new TwoSenderToRx<>(DeserializationFailure::new);
		TwoSenderToRx<ClientAtom, RadixEngineException, SubmissionFailure> submissionFailures
			= new TwoSenderToRx<>(SubmissionFailure::new);
		SubmissionControlSender submissionControlSender = new SubmissionControlSender() {
			@Override
			public void sendDeserializeFailure(Atom rawAtom, AtomConversionException e) {
				deserializationFailures.send(rawAtom, e);
			}

			@Override
			public void sendRadixEngineFailure(ClientAtom clientAtom, RadixEngineException e) {
				submissionFailures.send(clientAtom, e);
			}
		};
		SubmissionErrorsRx submissionErrorsRx = new SubmissionErrorsRx() {
			@Override
			public Observable<SubmissionFailure> submissionFailures() {
				return submissionFailures.rx();
			}

			@Override
			public Observable<DeserializationFailure> deserializationFailures() {
				return deserializationFailures.rx();
			}
		};
		bind(SubmissionControlSender.class).toInstance(submissionControlSender);
		bind(SubmissionErrorsRx.class).toInstance(submissionErrorsRx);

		TwoSenderToRx<Long, Object, CommittedStateSync> committedStateSyncTwoSenderToRx = new TwoSenderToRx<>(CommittedStateSync::new);
		bind(CommittedStateSyncRx.class).toInstance(committedStateSyncTwoSenderToRx::rx);
		bind(CommittedStateSyncSender.class).toInstance(committedStateSyncTwoSenderToRx::send);

		Multibinder<SyncService> syncServiceMultibinder = Multibinder.newSetBinder(binder(), SyncService.class);
		SenderToRx<LocalSyncRequest, LocalSyncRequest> localSyncRequests = new SenderToRx<>(r -> r);
		syncServiceMultibinder.addBinding().toInstance(localSyncRequests::send);
		bind(LocalSyncRequestsRx.class).toInstance(localSyncRequests::rx);

		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor(ThreadFactories.daemonThreads("SyncTimeoutSender"));
		ScheduledSenderToRx<SyncInProgress> syncsInProgress = new ScheduledSenderToRx<>(ses);
		bind(SyncTimeoutScheduler.class).toInstance(syncsInProgress::scheduleSend);
		bind(SyncTimeoutsRx.class).toInstance(syncsInProgress::messages);
	}
}

/*
 * (C) Copyright 2020 Radix DLT Ltd
 *
 * Radix DLT Ltd licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the
 * License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the License.
 */

package com.radixdlt;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Named;
import com.radixdlt.consensus.BFTConfiguration;
import com.radixdlt.consensus.BFTEventProcessor;
import com.radixdlt.consensus.BFTFactory;
import com.radixdlt.consensus.HashSigner;
import com.radixdlt.consensus.HashVerifier;
import com.radixdlt.consensus.Hasher;
import com.radixdlt.consensus.Ledger;
import com.radixdlt.consensus.LedgerHeader;
import com.radixdlt.consensus.PendingVotes;
import com.radixdlt.consensus.bft.BFTBuilder;
import com.radixdlt.consensus.QuorumCertificate;
import com.radixdlt.consensus.bft.BFTCommittedUpdate;
import com.radixdlt.consensus.liveness.ExponentialTimeoutPacemaker.PacemakerInfoSender;
import com.radixdlt.consensus.safety.SafetyRules;
import com.radixdlt.consensus.safety.SafetyState;
import com.radixdlt.consensus.bft.BFTNode;
import com.radixdlt.consensus.bft.BFTSyncRequestProcessor;
import com.radixdlt.consensus.bft.BFTValidatorSet;
import com.radixdlt.consensus.bft.VertexStore.BFTUpdateSender;
import com.radixdlt.consensus.liveness.ProposalBroadcaster;
import com.radixdlt.consensus.liveness.ExponentialTimeoutPacemaker;
import com.radixdlt.consensus.liveness.NextCommandGenerator;
import com.radixdlt.consensus.liveness.Pacemaker;
import com.radixdlt.consensus.liveness.ProposerElection;
import com.radixdlt.consensus.sync.BFTSync;
import com.radixdlt.consensus.sync.BFTSync.SyncVerticesRequestSender;
import com.radixdlt.consensus.sync.VertexStoreBFTSyncRequestProcessor;
import com.radixdlt.consensus.sync.VertexStoreBFTSyncRequestProcessor.SyncVerticesResponseSender;
import com.radixdlt.consensus.bft.VertexStore;
import com.radixdlt.consensus.bft.VertexStore.VertexStoreEventSender;
import com.radixdlt.consensus.sync.SyncLedgerRequestSender;
import com.radixdlt.consensus.liveness.PacemakerTimeoutSender;
import com.radixdlt.consensus.liveness.PendingViewTimeouts;
import com.radixdlt.consensus.liveness.ProceedToViewSender;
import com.radixdlt.consensus.liveness.WeightedRotatingLeaders;
import com.radixdlt.counters.SystemCounters;
import com.radixdlt.network.TimeSupplier;
import java.util.Comparator;
import java.util.Set;

/**
 * Module responsible for running BFT validator logic
 */
public final class ConsensusModule extends AbstractModule {
	private static final int ROTATING_WEIGHTED_LEADERS_CACHE_SIZE = 10;
	private final long pacemakerTimeout;
	private final double pacemakerRate;
	private final int pacemakerMaxExponent;

	public ConsensusModule(long pacemakerTimeout, double pacemakerRate, int pacemakerMaxExponent) {
		this.pacemakerTimeout = pacemakerTimeout;
		this.pacemakerRate = pacemakerRate;
		this.pacemakerMaxExponent = pacemakerMaxExponent;
	}

	@Override
	public void configure() {
		Multibinder.newSetBinder(binder(), VertexStoreEventSender.class);
	}

	@Provides
	private VertexStoreEventSender sender(Set<VertexStoreEventSender> senders) {
		return new VertexStoreEventSender() {
			@Override
			public void sendCommitted(BFTCommittedUpdate committedUpdate) {
				senders.forEach(s -> s.sendCommitted(committedUpdate));
			}

			@Override
			public void highQC(QuorumCertificate qc) {
				senders.forEach(s -> s.highQC(qc));
			}
		};
	}

	@Provides
	private BFTFactory bftFactory(
		Hasher hasher,
		HashVerifier verifier
	) {
		return (
			self,
			pacemaker,
			vertexStore,
			vertexStoreSync,
			proposerElection,
			validatorSet
		) ->
			BFTBuilder.create()
				.self(self)
				.hasher(hasher)
				.verifier(verifier)
				.pacemaker(pacemaker)
				.vertexStore(vertexStore)
				.bftSyncer(vertexStoreSync)
				.proposerElection(proposerElection)
				.validatorSet(validatorSet)
				.build();
	}

	@Provides
	@Singleton
	public BFTEventProcessor eventProcessor(
		@Named("self") BFTNode self,
		BFTConfiguration config,
		BFTFactory bftFactory,
		Pacemaker pacemaker,
		VertexStore vertexStore,
		BFTSync vertexStoreSync,
		ProposerElection proposerElection
	) {
		return bftFactory.create(
			self,
			pacemaker,
			vertexStore,
			vertexStoreSync,
			proposerElection,
			config.getValidatorSet()
		);
	}

	@Provides
	private ProposerElection proposerElection(BFTConfiguration configuration) {
		return new WeightedRotatingLeaders(
			configuration.getValidatorSet(),
			Comparator.comparing(v -> v.getNode().getKey().euid()),
			ROTATING_WEIGHTED_LEADERS_CACHE_SIZE
		);
	}

	@Provides
	@Singleton
	private Pacemaker pacemaker(
		@Named("self") BFTNode self,
		SystemCounters counters,
		BFTConfiguration configuration,
		VertexStore vertexStore,
		ProposerElection proposerElection,
		NextCommandGenerator nextCommandGenerator,
		TimeSupplier timeSupplier,
		Hasher hasher,
		HashSigner signer,
		ProposalBroadcaster proposalBroadcaster,
		ProceedToViewSender proceedToViewSender,
		PacemakerTimeoutSender timeoutSender,
		PacemakerInfoSender infoSender
	) {
		PendingVotes pendingVotes = new PendingVotes(hasher);
		PendingViewTimeouts pendingViewTimeouts = new PendingViewTimeouts();
		BFTValidatorSet validatorSet = configuration.getValidatorSet();
		SafetyRules safetyRules = new SafetyRules(self, SafetyState.initialState(), hasher, signer);
		return new ExponentialTimeoutPacemaker(
			this.pacemakerTimeout,
			this.pacemakerRate,
			this.pacemakerMaxExponent,

			self,
			counters,

			pendingVotes,
			pendingViewTimeouts,
			validatorSet,
			vertexStore,
			proposerElection,
			safetyRules,
			nextCommandGenerator,
			timeSupplier,
			hasher,

			proposalBroadcaster,
			proceedToViewSender,
			timeoutSender,
			infoSender
		);
	}

	@Provides
	private BFTSyncRequestProcessor bftSyncRequestProcessor(
		VertexStore vertexStore,
		SyncVerticesResponseSender responseSender
	) {
		return new VertexStoreBFTSyncRequestProcessor(vertexStore, responseSender);
	}

	@Provides
	@Singleton
	private BFTSync bftSync(
		VertexStore vertexStore,
		Pacemaker pacemaker,
		SyncVerticesRequestSender requestSender,
		SyncLedgerRequestSender syncLedgerRequestSender,
		BFTConfiguration configuration
	) {
		return new BFTSync(
			vertexStore,
			pacemaker,
			Comparator.comparingLong((LedgerHeader h) -> h.getAccumulatorState().getStateVersion()),
			requestSender,
			syncLedgerRequestSender,
			configuration.getGenesisHeader()
		);
	}

	@Provides
	@Singleton
	private VertexStore vertexStore(
		VertexStoreEventSender vertexStoreEventSender,
		BFTUpdateSender updateSender,
		BFTConfiguration bftConfiguration,
		SystemCounters counters,
		Ledger ledger
	) {
		return new VertexStore(
			bftConfiguration.getGenesisVertex(),
			bftConfiguration.getGenesisQC(),
			ledger,
			updateSender,
			vertexStoreEventSender,
			counters
		);
	}
}

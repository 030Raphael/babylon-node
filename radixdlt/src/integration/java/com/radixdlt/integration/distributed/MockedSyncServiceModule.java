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

package com.radixdlt.integration.distributed;

import com.google.common.collect.ImmutableList;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.multibindings.ProvidesIntoSet;
import com.radixdlt.consensus.Command;
import com.radixdlt.consensus.Ledger;
import com.radixdlt.consensus.VerifiedLedgerHeaderAndProof;
import com.radixdlt.consensus.sync.SyncRequestSender;
import com.radixdlt.ledger.VerifiedCommandsAndProof;
import com.radixdlt.ledger.StateComputerLedger.LedgerUpdateSender;
import com.radixdlt.sync.LocalSyncRequest;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.LongStream;

public class MockedSyncServiceModule extends AbstractModule {
	private final ConcurrentMap<Long, Command> sharedCommittedCommands;

	public MockedSyncServiceModule() {
		this.sharedCommittedCommands = new ConcurrentHashMap<>();
	}

	@ProvidesIntoSet
	private LedgerUpdateSender sync() {
		return update -> {
			final VerifiedLedgerHeaderAndProof headerAndProof = update.getTail();
			long stateVersion = headerAndProof.getAccumulatorState().getStateVersion();
			long firstVersion = stateVersion - update.getNewCommands().size() + 1;
			for (int i = 0; i < update.getNewCommands().size(); i++) {
				sharedCommittedCommands.put(firstVersion + i, update.getNewCommands().get(i));
			}
		};
	}

	@Provides
	@Singleton
	SyncRequestSender syncRequestSender(
		Ledger ledger
	) {
		return new SyncRequestSender() {
			long currentVersion = 0;

			@Override
			public void sendLocalSyncRequest(LocalSyncRequest request) {
				final long targetVersion = request.getTarget().getStateVersion();
				ImmutableList<Command> commands = LongStream.range(currentVersion + 1, targetVersion + 1)
					.mapToObj(sharedCommittedCommands::get)
					.collect(ImmutableList.toImmutableList());
				ledger.commit(new VerifiedCommandsAndProof(commands, request.getTarget()));
				currentVersion = targetVersion;
			}
		};
	}
}

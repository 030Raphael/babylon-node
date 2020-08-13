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

package com.radixdlt.integration.distributed.deterministic.tests.consensus;

import com.radixdlt.consensus.NewView;
import com.radixdlt.consensus.Proposal;
import com.radixdlt.consensus.Vote;
import com.radixdlt.integration.distributed.deterministic.DeterministicTest;
import org.junit.Test;

public class OneSlowNodeTest {

	/**
	 * TODO: Convert this into a steady state test
	 */
	@Test
	public void when_three_fast_nodes_and_one_slow_node_two_cycles__then_missing_parent_should_not_cause_sync_exception() {
		final DeterministicTest test = DeterministicTest.createSingleEpochAlwaysSyncedTest(4);

		test.start();

		for (int curLeader = 1; curLeader <= 2; curLeader++) {
			test.processNextMsg(curLeader, 1, NewView.class);
			test.processNextMsg(curLeader, 2, NewView.class);
			test.processNextMsg(curLeader, 3, NewView.class);

			test.processNextMsg(1, curLeader, Proposal.class);
			test.processNextMsg(2, curLeader, Proposal.class);
			test.processNextMsg(3, curLeader, Proposal.class);

			test.processNextMsg(curLeader, 1, Vote.class);
			test.processNextMsg(curLeader, 2, Vote.class);
			test.processNextMsg(curLeader, 3, Vote.class);
		}

		test.processNextMsg(0, 2, Proposal.class);
	}
}

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

package com.radixdlt.integration.distributed.simulation.tests.consensus;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.google.inject.AbstractModule;
import com.radixdlt.consensus.sync.BFTSync.SyncVerticesRequestSender;
import com.radixdlt.integration.distributed.simulation.NetworkDroppers;
import com.radixdlt.integration.distributed.simulation.NetworkLatencies;
import com.radixdlt.integration.distributed.simulation.NetworkOrdering;
import com.radixdlt.integration.distributed.simulation.SimulationTest.TestResults;
import com.radixdlt.integration.distributed.simulation.SimulationTest;
import com.radixdlt.integration.distributed.simulation.SimulationTest.Builder;
import java.util.Arrays;
import java.util.Collection;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Simulation with a communication adversary which drops a random proposal message in every
 * round.
 *
 * Dropped proposals implies that validators will need to retrieve the information
 * originally in this proposals via syncing with other nodes.
 */
@RunWith(Parameterized.class)
public class FProposalsPerViewDropperTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{4}, {50}
		});
	}

	private final Builder bftTestBuilder;

	public FProposalsPerViewDropperTest(int numNodes) {
		 bftTestBuilder = SimulationTest.builder()
			.numNodes(numNodes)
			.networkModules(
				NetworkOrdering.inOrder(),
				NetworkLatencies.fixed(),
				NetworkDroppers.fRandomProposalsPerViewDropped()
			)
			.pacemakerTimeout(5000)
			.checkConsensusSafety("safety")
			.checkConsensusNoTimeouts("noTimeouts");
	}

	/**
	 * Tests a configuration of 4 nodes with a dropping proposal adversary
	 * Test should fail with GetVertices RPC disabled
	 */
	@Test
	public void given_incorrect_module_where_vertex_sync_is_disabled__then_test_should_fail_against_drop_proposal_adversary() {
		SimulationTest test = bftTestBuilder
			.overrideWithIncorrectModule(new AbstractModule() {
				@Override
				protected void configure() {
					bind(SyncVerticesRequestSender.class).toInstance((node, hash, count) -> { });
				}
			})
			.build();

		TestResults results = test.run();
		assertThat(results.getCheckResults()).hasEntrySatisfying("noTimeouts", error -> assertThat(error).isPresent());
	}

	/**
	 * Tests a configuration of 4 nodes with a dropping proposal adversary
	 * Test should fail with GetVertices RPC disabled
	 */
	@Test
	public void given_get_vertices_enabled__then_test_should_succeed_against_drop_proposal_adversary() {
		SimulationTest test = bftTestBuilder.build();
		TestResults results = test.run();
		assertThat(results.getCheckResults()).allSatisfy((name, error) -> assertThat(error).isNotPresent());
	}

	@Test
	@Ignore("Remove ignore once sync retries are implemented")
	public void dropping_sync_adversary_should_cause_no_timeouts_because_of_sync_retries() {
		SimulationTest test = bftTestBuilder
			.addNetworkModule(NetworkDroppers.bftSyncMessagesDropped(0.1))
			.build();
		TestResults results = test.run();
		assertThat(results.getCheckResults()).allSatisfy((name, error) -> AssertionsForClassTypes.assertThat(error).isNotPresent());
	}
}

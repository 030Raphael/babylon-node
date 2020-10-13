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

import com.radixdlt.crypto.Hash;
import com.radixdlt.integration.distributed.MockedBFTConfigurationModule;
import com.radixdlt.integration.distributed.simulation.SimulationTest;
import com.radixdlt.integration.distributed.simulation.SimulationTest.TestResults;
import java.util.concurrent.TimeUnit;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Test;

/**
 * Tests that progress cannot be made if nodes do not form a quorum on the
 * genesis hash.
 */
public class OneByzantineGenesisTest {
	SimulationTest.Builder bftTestBuilder = SimulationTest.builder()
		.pacemakerTimeout(1000)
		.defaultLatency()
		.checkConsensusSafety("safety");

	@Test
	public void given_2_correct_bfts_and_1_byzantine__then_should_never_make_progress() {
		SimulationTest bftTest = bftTestBuilder
			.numNodes(3)
			.addSingleByzantineModule(new MockedBFTConfigurationModule(Hash.random()))
			.checkConsensusNoneCommitted("noneCommitted")
			.build();

		TestResults results = bftTest.run();
		assertThat(results.getCheckResults()).allSatisfy((name, err) -> AssertionsForClassTypes.assertThat(err).isEmpty());
	}

	@Test
	public void given_3_correct_bfts__then_none_committed_invariant_should_fail() {
		SimulationTest bftTest = bftTestBuilder
			.numNodes(3)
			.checkConsensusNoneCommitted("noneCommitted")
			.build();

		TestResults results = bftTest.run();
		assertThat(results.getCheckResults()).hasEntrySatisfying("noneCommitted", error -> assertThat(error).isPresent());
	}

	@Test
	public void given_3_correct_bfts_and_1_byzantine__then_should_make_progress() {
		SimulationTest bftTest = bftTestBuilder
			.numNodes(4)
			.addSingleByzantineModule(new MockedBFTConfigurationModule(Hash.random()))
			.checkConsensusLiveness("liveness", 5, TimeUnit.SECONDS)
			.build();

		TestResults results = bftTest.run();
		assertThat(results.getCheckResults()).allSatisfy((name, err) -> AssertionsForClassTypes.assertThat(err).isEmpty());
	}

}

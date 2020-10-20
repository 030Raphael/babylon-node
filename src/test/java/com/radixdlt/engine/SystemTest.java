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

package com.radixdlt.engine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.radixdlt.atommodel.system.SystemConstraintScrypt;
import com.radixdlt.atommodel.system.SystemParticle;
import com.radixdlt.atomos.CMAtomOS;
import com.radixdlt.constraintmachine.CMErrorCode;
import com.radixdlt.constraintmachine.CMInstruction;
import com.radixdlt.constraintmachine.CMMicroInstruction;
import com.radixdlt.constraintmachine.ConstraintMachine;
import com.radixdlt.constraintmachine.PermissionLevel;
import com.radixdlt.constraintmachine.Spin;
import com.radixdlt.crypto.Hash;
import com.radixdlt.store.EngineStore;
import com.radixdlt.store.InMemoryEngineStore;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests BFT System verification logic
 */
public class SystemTest {
	private RadixEngine<RadixEngineAtom> engine;
	private EngineStore<RadixEngineAtom> store;

	@Before
	public void setup() {
		CMAtomOS cmAtomOS = new CMAtomOS();
		cmAtomOS.load(new SystemConstraintScrypt(10));
		ConstraintMachine cm = new ConstraintMachine.Builder()
			.setParticleStaticCheck(cmAtomOS.buildParticleStaticCheck())
			.setParticleTransitionProcedures(cmAtomOS.buildTransitionProcedures())
			.build();
		this.store = new InMemoryEngineStore<>();
		this.engine = new RadixEngine<>(
			cm,
			cmAtomOS.buildVirtualLayer(),
			store
		);
	}

	@Test
	public void executing_system_update_without_permissions_should_fail() {
		// Arrange
		SystemParticle systemParticle = new SystemParticle(0, 0, 0);
		SystemParticle nextSystemParticle = new SystemParticle(0, 1, 1);
		ImmutableList<CMMicroInstruction> instructions = ImmutableList.of(
			CMMicroInstruction.checkSpinAndPush(systemParticle, Spin.UP),
			CMMicroInstruction.checkSpinAndPush(nextSystemParticle, Spin.NEUTRAL),
			CMMicroInstruction.particleGroup()
		);
		CMInstruction instruction = new CMInstruction(
			instructions,
			ImmutableMap.of()
		);

		// Act
		// Assert
		assertThatThrownBy(() -> this.engine.checkAndStore(new BaseAtom(instruction, Hash.ZERO_HASH)))
			.isInstanceOf(RadixEngineException.class)
			.extracting(e -> ((RadixEngineException) e).getCmError().getErrorCode())
			.isEqualTo(CMErrorCode.INVALID_EXECUTION_PERMISSION);
	}

	@Test
	public void executing_system_update_with_correct_permissions_should_succeed() throws RadixEngineException {
		// Arrange
		SystemParticle systemParticle = new SystemParticle(0, 0, 0);
		SystemParticle nextSystemParticle = new SystemParticle(0, 1, 1);
		ImmutableList<CMMicroInstruction> instructions = ImmutableList.of(
			CMMicroInstruction.checkSpinAndPush(systemParticle, Spin.UP),
			CMMicroInstruction.checkSpinAndPush(nextSystemParticle, Spin.NEUTRAL),
			CMMicroInstruction.particleGroup()
		);
		CMInstruction instruction = new CMInstruction(
			instructions,
			ImmutableMap.of()
		);

		// Act
		this.engine.checkAndStore(new BaseAtom(instruction, Hash.ZERO_HASH), PermissionLevel.SUPER_USER);

		// Assert
		assertThat(this.store.getSpin(nextSystemParticle)).isEqualTo(Spin.UP);
	}

	@Test
	public void executing_system_update_with_view_ceiling_should_fail() {
		// Arrange
		SystemParticle systemParticle = new SystemParticle(0, 0, 0);
		SystemParticle nextSystemParticle = new SystemParticle(0, 10, 1);
		ImmutableList<CMMicroInstruction> instructions = ImmutableList.of(
			CMMicroInstruction.checkSpinAndPush(systemParticle, Spin.UP),
			CMMicroInstruction.checkSpinAndPush(nextSystemParticle, Spin.NEUTRAL),
			CMMicroInstruction.particleGroup()
		);
		CMInstruction instruction = new CMInstruction(
			instructions,
			ImmutableMap.of()
		);

		// Act
		// Assert
		assertThatThrownBy(() -> this.engine.checkAndStore(new BaseAtom(instruction, Hash.ZERO_HASH), PermissionLevel.SUPER_USER))
			.isInstanceOf(RadixEngineException.class)
			.extracting(e -> ((RadixEngineException) e).getCmError().getErrorCode())
			.isEqualTo(CMErrorCode.INVALID_PARTICLE);
	}
}

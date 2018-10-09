package com.radixdlt.client.core.atoms;

import static org.junit.Assert.assertEquals;

import com.radixdlt.client.core.atoms.particles.DataParticle.DataParticleBuilder;
import org.junit.Test;

public class AtomBuilderTest {
	@Test
	public void testMultipleAtomPayloadBuildsShouldCreateSameAtom() {
		AtomBuilder atomBuilder = new AtomBuilder()
			.addParticle(new DataParticleBuilder().payload(new Payload("Hello".getBytes())).build());

		UnsignedAtom atom1 = atomBuilder.build(0);
		UnsignedAtom atom2 = atomBuilder.build(0);

		assertEquals(atom1.getHash(), atom2.getHash());
	}
}
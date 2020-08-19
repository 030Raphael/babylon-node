
package com.radix.regression;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.radixdlt.client.application.RadixApplicationAPI;
import com.radixdlt.client.application.identity.RadixIdentities;
import com.radixdlt.client.application.identity.RadixIdentity;
import com.radixdlt.client.application.translate.FeeMapper;
import com.radixdlt.client.application.translate.PowFeeMapper;
import com.radixdlt.client.atommodel.validators.RegisteredValidatorParticle;
import com.radixdlt.client.atommodel.validators.UnregisteredValidatorParticle;
import com.radixdlt.client.core.RadixEnv;
import com.radixdlt.client.core.RadixUniverse;
import com.radixdlt.client.core.atoms.Atom;
import com.radixdlt.client.core.atoms.AtomStatus;
import com.radixdlt.client.core.atoms.AtomStatusEvent;
import com.radixdlt.client.core.atoms.ParticleGroup;
import com.radixdlt.client.core.atoms.particles.SpunParticle;
import com.radixdlt.client.core.network.HttpClients;
import com.radixdlt.client.core.network.RadixNode;
import com.radixdlt.client.core.network.jsonrpc.RadixJsonRpcClient;
import com.radixdlt.client.core.network.websocket.WebSocketClient;
import com.radixdlt.client.core.network.websocket.WebSocketStatus;
import com.radixdlt.client.core.pow.ProofOfWorkBuilder;
import com.radixdlt.identifiers.RadixAddress;
import io.reactivex.observers.BaseTestConsumer.TestWaitStrategy;
import io.reactivex.observers.TestObserver;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ValidatorRegistrationTest {
	private RadixUniverse universe = RadixUniverse.create(RadixEnv.getBootstrapConfig());
	private RadixIdentity identity;
	private RadixAddress address;
	private FeeMapper feeMapper = new PowFeeMapper(Atom::getHash, new ProofOfWorkBuilder());
	private RadixJsonRpcClient jsonRpcClient;
	private WebSocketClient webSocketClient;

	@Before
	public void setUp() {
		this.identity = RadixIdentities.createNew();
		this.address = universe.getAddressFrom(this.identity.getPublicKey());
		RadixApplicationAPI api = RadixApplicationAPI.create(RadixEnv.getBootstrapConfig(), this.identity);
		api.discoverNodes();
		RadixNode node = api.getNetworkState()
			.filter(state -> !state.getNodes().isEmpty())
			.map(state -> state.getNodes().iterator().next())
			.blockingFirst();

		this.webSocketClient = new WebSocketClient(listener ->
			HttpClients.getSslAllTrustingClient().newWebSocket(node.getWebSocketEndpoint(), listener)
		);
		webSocketClient.connect();
		webSocketClient.getState()
			.filter(WebSocketStatus.CONNECTED::equals)
			.blockingFirst();
		this.jsonRpcClient = new RadixJsonRpcClient(webSocketClient);
	}

	@After
	public void tearDown() {
		this.webSocketClient.close();
	}

	@Test
	public void when_registering_unregistering_and_reregistering_validator__then_validator_is_registererd() {
		// create a new public key identity
		final RadixIdentity radixIdentity = RadixIdentities.createNew();

		// initialize api layer
		RadixApplicationAPI api1 = RadixApplicationAPI.create(RadixEnv.getBootstrapConfig(), radixIdentity);

		// register for the first time
		ImmutableSet<RadixAddress> allowedDelegators = ImmutableSet.of(api1.getAddress());
		String url = "https://www.radixdlt.com";
		api1.registerValidator(api1.getAddress(), allowedDelegators, url).blockUntilComplete();

		// check the validator state was stored properly
		RadixApplicationAPI api2 = RadixApplicationAPI.create(RadixEnv.getBootstrapConfig(), radixIdentity);
		api2.pullOnce(api1.getAddress()).blockingAwait();
		RegisteredValidatorParticle storedParticle = api2.getAtomStore().getUpParticles(api1.getAddress(), null)
			.filter(RegisteredValidatorParticle.class::isInstance)
			.map(RegisteredValidatorParticle.class::cast)
			.findFirst()
			.orElseThrow(() -> new IllegalStateException("no RegisteredValidatorParticle found"));
		Assertions.assertThat(storedParticle.getUrl()).isEqualTo(url);
		Assertions.assertThat(storedParticle.getAllowedDelegators()).isEqualTo(allowedDelegators);

		// unregister
		api1.unregisterValidator(api1.getAddress()).blockUntilComplete();

		// and re-register
		api1.registerValidator(api1.getAddress(), ImmutableSet.of()).blockUntilComplete();
	}

	@Test
	public void when_registering_twice__then_second_registration_fails() {
		TestObserver<AtomStatusEvent> observer = submitAtom(
			SpunParticle.down(new UnregisteredValidatorParticle(address, 0)),
			SpunParticle.down(new RegisteredValidatorParticle(address, 1)),
			SpunParticle.down(new RegisteredValidatorParticle(address, 2))
		);

		observer.awaitCount(1, TestWaitStrategy.SLEEP_10MS, 10000);
		observer.assertValue(n -> n.getAtomStatus() == AtomStatus.EVICTED_FAILED_CM_VERIFICATION);
		observer.dispose();
	}

	@Test
	public void when_unregistering_twice__then_second_registration_fails() {
		TestObserver<AtomStatusEvent> observer = submitAtom(
			SpunParticle.down(new UnregisteredValidatorParticle(address, 0)),
			SpunParticle.down(new UnregisteredValidatorParticle(address, 1))
		);

		observer.awaitCount(1, TestWaitStrategy.SLEEP_10MS, 10000);
		observer.assertValue(n -> n.getAtomStatus() == AtomStatus.EVICTED_FAILED_CM_VERIFICATION);
		observer.dispose();
	}

	private TestObserver<AtomStatusEvent> submitAtom(SpunParticle<?>... spunParticles) {
		return submitAtom(ImmutableMap.of(), true, Long.toString(System.currentTimeMillis()), spunParticles);
	}

	private TestObserver<AtomStatusEvent> submitAtom(
		Map<String, String> metaData,
		boolean addFee,
		String timestamp,
		SpunParticle<?>... spunParticles
	) {
		List<ParticleGroup> particleGroups = new ArrayList<>();
		particleGroups.add(ParticleGroup.of(ImmutableList.copyOf(spunParticles), metaData));

		Map<String, String> atomMetaData = new HashMap<>();
		atomMetaData.putAll(metaData);
		atomMetaData.put("timestamp", timestamp);

		if (addFee) {
			atomMetaData.putAll(feeMapper.map(Atom.create(particleGroups, atomMetaData), universe, this.identity.getPublicKey()).getFirst());
		}

		Atom unsignedAtom = Atom.create(particleGroups, atomMetaData);
		// Sign and submit
		Atom signedAtom = this.identity.addSignature(unsignedAtom).blockingGet();

		TestObserver<AtomStatusEvent> observer = TestObserver.create(Util.loggingObserver("Submission"));

		final String subscriberId = UUID.randomUUID().toString();
		this.jsonRpcClient.observeAtomStatusNotifications(subscriberId)
			.doOnNext(n -> {
				if (n.getType() == RadixJsonRpcClient.NotificationType.START) {
					this.jsonRpcClient.sendGetAtomStatusNotifications(subscriberId, signedAtom.getAid()).blockingAwait();
					this.jsonRpcClient.pushAtom(signedAtom).blockingAwait();
				}
			})
			.filter(n -> n.getType().equals(RadixJsonRpcClient.NotificationType.EVENT))
			.map(RadixJsonRpcClient.Notification::getEvent)
			.subscribe(observer);

		return observer;
	}
}

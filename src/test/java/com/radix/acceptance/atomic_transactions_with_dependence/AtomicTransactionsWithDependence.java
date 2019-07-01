package com.radix.acceptance.atomic_transactions_with_dependence;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.radix.TestEnv;
import com.radix.acceptance.SpecificProperties;
import com.radixdlt.client.application.RadixApplicationAPI;
import com.radixdlt.client.application.RadixApplicationAPI.Transaction;
import com.radixdlt.client.application.identity.RadixIdentities;
import com.radixdlt.client.application.identity.RadixIdentity;
import com.radixdlt.client.application.translate.tokens.AtomToTokenTransfersMapper;
import com.radixdlt.client.application.translate.tokens.CreateTokenAction;
import com.radixdlt.client.application.translate.tokens.CreateTokenToParticleGroupsMapper;
import com.radixdlt.client.application.translate.tokens.MintTokensAction;
import com.radixdlt.client.application.translate.tokens.TokenBalanceReducer;
import com.radixdlt.client.application.translate.tokens.TokenDefinitionsReducer;
import com.radixdlt.client.application.translate.tokens.TokenUnitConversions;
import com.radixdlt.client.application.translate.tokens.TransferTokensAction;
import com.radixdlt.client.application.translate.tokens.TransferTokensToParticleGroupsMapper;
import com.radixdlt.client.atommodel.accounts.RadixAddress;
import com.radixdlt.client.core.RadixUniverse;
import com.radixdlt.client.core.atoms.AtomStatus;
import com.radixdlt.client.core.atoms.ParticleGroup;
import com.radixdlt.client.core.atoms.ParticleGroup.ParticleGroupBuilder;
import com.radixdlt.client.core.atoms.particles.Particle;
import com.radixdlt.client.core.atoms.particles.RRI;
import com.radixdlt.client.core.atoms.particles.Spin;
import com.radixdlt.client.core.network.actions.SubmitAtomRequestAction;
import com.radixdlt.client.core.network.actions.SubmitAtomStatusAction;
import com.radixdlt.client.core.network.actions.SubmitAtomSendAction;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.reactivex.observers.TestObserver;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * See <a href="https://radixdlt.atlassian.net/browse/RLAU-645">RLAU-645</a>.
 */
public class AtomicTransactionsWithDependence {
	private static final String NAME = "name";
	private static final String SYMBOL = "symbol";
	private static final String DESCRIPTION = "description";
	private static final String INITIAL_SUPPLY = "initialSupply";
	private static final String NEW_SUPPLY = "newSupply";
	private static final String GRANULARITY = "granularity";

	private static final long TIMEOUT_MS = 10_000L; // Timeout in milliseconds

	private final SpecificProperties properties = SpecificProperties.of(
		NAME,           "RLAU-40 Test token",
		SYMBOL,			"RLAU",
		DESCRIPTION,	"RLAU-40 Test token",
		INITIAL_SUPPLY,	scaledToUnscaled(1000000000),
		NEW_SUPPLY,		scaledToUnscaled(1000000000),
		GRANULARITY,	"1"
	);
	private final List<TestObserver<Object>> observers = Lists.newArrayList();

	@Given("^I have access to a suitable Radix network$")
	public void i_have_access_to_a_suitable_Radix_network() {
		// Reset data
		this.properties.clear();
		this.observers.clear();
	}

	private void mintAndTransferTokensWith(MintAndTransferTokensActionMapper actionMapper) {
		RadixApplicationAPI api = new RadixApplicationAPI.RadixApplicationAPIBuilder()
			.defaultFeeMapper()
			.universe(RadixUniverse.create(TestEnv.getBootstrapConfig()))
			.addStatelessParticlesMapper(CreateTokenAction.class, new CreateTokenToParticleGroupsMapper())
			.addStatefulParticlesMapper(MintAndTransferTokensAction.class, actionMapper)
			.addStatefulParticlesMapper(TransferTokensAction.class, new TransferTokensToParticleGroupsMapper())
			.addReducer(new TokenDefinitionsReducer())
			.addReducer(new TokenBalanceReducer())
			.addAtomMapper(new AtomToTokenTransfersMapper())
			.identity(RadixIdentities.createNew())
			.build();

		this.properties.put(SYMBOL, "TEST0");
		createToken(CreateTokenAction.TokenSupplyType.MUTABLE, api);
		i_can_observe_atom_being_accepted(1);
		this.observers.clear();

		RadixIdentity toIdentity = RadixIdentities.createNew();
		RadixAddress toAddress = api.getAddress(toIdentity.getPublicKey());
		TestObserver<Object> observer = new TestObserver<>();
		api.execute(new MintAndTransferTokensAction(RRI.of(api.getAddress(), "TEST0"), BigDecimal.valueOf(7), toAddress))
			.toObservable()
			.subscribe(observer);
		observers.add(observer);
	}

	@When("^I submit a particle group spending a consumable that was created in a group with a lower index$")
	public void iSubmitAParticleGroupSpendingAConsumableThatWasCreatedInAGroupWithALowerIndex() throws Exception {
		RadixApplicationAPI api = RadixApplicationAPI.defaultBuilder()
			.universe(RadixUniverse.create(TestEnv.getBootstrapConfig()))
			.identity(RadixIdentities.createNew())
			.build();

		this.properties.put(SYMBOL, "TEST0");
		createToken(CreateTokenAction.TokenSupplyType.MUTABLE, api);
		i_can_observe_atom_being_accepted(1);
		TimeUnit.SECONDS.sleep(5);
		this.observers.clear();

		RadixIdentity toIdentity = RadixIdentities.createNew();
		RadixAddress toAddress = api.getAddress(toIdentity.getPublicKey());
		TestObserver<Object> observer = new TestObserver<>();
		Transaction transaction = api.createTransaction();
		transaction.stage(MintTokensAction.create(RRI.of(api.getAddress(), "TEST0"), api.getAddress(), BigDecimal.valueOf(7)));
		transaction.stage(TransferTokensAction.create(RRI.of(api.getAddress(), "TEST0"), api.getAddress(), toAddress, BigDecimal.valueOf(7)));
		transaction.commitAndPush()
			.toObservable()
			.doOnNext(System.out::println)
			.subscribe(observer);
		observers.add(observer);
	}

	@When("^I submit a particle group spending a consumable that was created in same group$")
	public void iSubmitAParticleGroupSpendingAConsumableThatWasCreatedInSameGroup() {
		mintAndTransferTokensWith(new MintAndTransferTokensActionMapper((mintTransition, transferTransition) -> {

			ParticleGroupBuilder groupBuilder = ParticleGroup.builder();
			mintTransition.getRemoved().stream().map(t -> (Particle) t).forEach(p -> groupBuilder.addParticle(p, Spin.DOWN));
			mintTransition.getMigrated().stream().map(t -> (Particle) t).forEach(p -> groupBuilder.addParticle(p, Spin.UP));
			mintTransition.getTransitioned().stream().map(t -> (Particle) t).forEach(p -> groupBuilder.addParticle(p, Spin.UP));
			transferTransition.getRemoved().stream().map(t -> (Particle) t).forEach(p -> groupBuilder.addParticle(p, Spin.DOWN));
			transferTransition.getMigrated().stream().map(t -> (Particle) t).forEach(p -> groupBuilder.addParticle(p, Spin.UP));
			transferTransition.getTransitioned().stream().map(t -> (Particle) t).forEach(p -> groupBuilder.addParticle(p, Spin.UP));

			return Collections.singletonList(groupBuilder.build());
		}));
	}

	@When("^I submit a particle group spending a consumable that was created in a group with a higher index$")
	public void iSubmitAParticleGroupSpendingAConsumableThatWasCreatedInAGroupWithAHigherIndex() {
		mintAndTransferTokensWith(new MintAndTransferTokensActionMapper((mint, transfer) -> {
			ParticleGroupBuilder mintParticleGroupBuilder = ParticleGroup.builder();
			mint.getRemoved().stream().map(t -> (Particle) t).forEach(p -> mintParticleGroupBuilder.addParticle(p, Spin.DOWN));
			mint.getMigrated().stream().map(t -> (Particle) t).forEach(p -> mintParticleGroupBuilder.addParticle(p, Spin.UP));
			mint.getTransitioned().stream().map(t -> (Particle) t).forEach(p -> mintParticleGroupBuilder.addParticle(p, Spin.UP));

			ParticleGroupBuilder transferParticleGroupBuilder = ParticleGroup.builder();
			transfer.getRemoved().stream().map(t -> (Particle) t).forEach(p -> transferParticleGroupBuilder.addParticle(p, Spin.DOWN));
			transfer.getMigrated().stream().map(t -> (Particle) t).forEach(p -> transferParticleGroupBuilder.addParticle(p, Spin.UP));
			transfer.getTransitioned().stream().map(t -> (Particle) t).forEach(p -> transferParticleGroupBuilder.addParticle(p, Spin.UP));

			return Arrays.asList(
				transferParticleGroupBuilder.build(),
				mintParticleGroupBuilder.build()
			);
		}));
	}

	@Then("^I can observe atom (\\d+) being accepted$")
	public void i_can_observe_atom_being_accepted(int atomNumber) {
		awaitAtomStatus(atomNumber, AtomStatus.STORED);
	}

	@Then("^I can observe the atom being rejected with a validation error$")
	public void i_can_observe_the_atom_being_rejected_as_a_validation_error() {
		// "the atom" = most recent atom
		i_can_observe_atom_being_rejected_as_a_validation_error(observers.size());
	}

	@Then("^I can observe atom (\\d+) being rejected with a validation error$")
	public void i_can_observe_atom_being_rejected_as_a_validation_error(int atomNumber) {
		awaitAtomStatus(atomNumber, AtomStatus.EVICTED_FAILED_CM_VERIFICATION);
	}

	private void createToken(CreateTokenAction.TokenSupplyType tokenCreateSupplyType, RadixApplicationAPI api) {
		TestObserver<Object> observer = new TestObserver<>();
		api.createToken(
				RRI.of(api.getAddress(), this.properties.get(SYMBOL)),
				this.properties.get(NAME),
				this.properties.get(DESCRIPTION),
				new BigDecimal(this.properties.get(INITIAL_SUPPLY)),
				new BigDecimal(this.properties.get(GRANULARITY)),
				tokenCreateSupplyType)
			.toObservable()
			.doOnNext(System.out::println)
			.subscribe(observer);
		observers.add(observer);
	}

	private void awaitAtomStatus(int atomNumber, AtomStatus... finalStates) {
		ImmutableSet<AtomStatus> finalStatesSet = ImmutableSet.<AtomStatus>builder()
			.addAll(Arrays.asList(finalStates))
			.build();

		TestObserver<Object> testObserver = this.observers.get(atomNumber - 1);
		testObserver.awaitTerminalEvent();
		testObserver.assertNoErrors();
		testObserver.assertNoTimeout();
		List<Object> events = testObserver.values();
		assertThat(events).extracting(o -> o.getClass().toString())
			.startsWith(
				SubmitAtomRequestAction.class.toString(),
				SubmitAtomSendAction.class.toString()
			);
		assertThat(events).last()
			.isInstanceOf(SubmitAtomStatusAction.class)
			.<AtomStatus>extracting(o -> SubmitAtomStatusAction.class.cast(o).getStatusNotification().getAtomStatus())
			.isIn(finalStatesSet);
	}

	private static String scaledToUnscaled(int amount) {
		return TokenUnitConversions.unitsToSubunits(amount).toString();
	}
}

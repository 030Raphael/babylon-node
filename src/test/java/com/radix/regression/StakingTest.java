package com.radix.regression;

import com.google.common.collect.ImmutableSet;
import com.radixdlt.client.application.RadixApplicationAPI;
import com.radixdlt.client.application.RadixApplicationAPI.Result;
import com.radixdlt.client.application.identity.RadixIdentities;
import com.radixdlt.client.application.translate.tokens.CreateTokenAction;
import com.radixdlt.client.application.translate.tokens.CreateTokenAction.TokenSupplyType;
import com.radixdlt.client.application.translate.tokens.TokenUnitConversions;
import com.radixdlt.client.core.RadixEnv;
import com.radixdlt.client.core.network.RadixNetworkState;
import com.radixdlt.client.core.network.RadixNode;
import com.radixdlt.identifiers.RRI;
import com.radixdlt.utils.UInt256;
import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;

public class StakingTest {
	@Test
	@Ignore("Doesn't currently work RPNV1-676")
	public void given_a_registered_validator__then_staking_against_it_should_only_work_if_permitted() {
		BigDecimal stakedAmount = BigDecimal.valueOf(10000.0);
		RadixApplicationAPI delegate = RadixApplicationAPI.create(RadixEnv.getBootstrapConfig(), RadixIdentities.createNew());
		RadixApplicationAPI delegator1 = RadixApplicationAPI.create(RadixEnv.getBootstrapConfig(), RadixIdentities.createNew());
		RadixApplicationAPI delegator2 = RadixApplicationAPI.create(RadixEnv.getBootstrapConfig(), RadixIdentities.createNew());

		delegate.discoverNodes();
		delegator1.discoverNodes();
		delegator2.discoverNodes();

		RRI token = RRI.of(delegate.getAddress(), "COOKIE");
		RadixNode originNode = delegate.getNetworkState()
			.map(RadixNetworkState::getNodes)
			.filter(s -> !s.isEmpty())
			.map(s -> s.iterator().next())
			.firstOrError()
			.blockingGet();
		// Create the token
		waitUntilComplete(delegate, CreateTokenAction.create(
			token,
			"Cookie Token",
			"Cookiemonster approved",
			BigDecimal.valueOf(1000000.0),
			TokenUnitConversions.subunitsToUnits(UInt256.ONE),
			TokenSupplyType.MUTABLE
		), originNode);

		// Distribute the token
		waitUntilComplete(delegate.sendTokens(token, delegator1.getAddress(), stakedAmount));
		waitUntilComplete(delegate.sendTokens(token, delegator2.getAddress(), stakedAmount));

		// Register as a validator
		waitUntilComplete(delegate.registerValidator(delegate.getAddress(), ImmutableSet.of(delegator1.getAddress())));

		// Stake tokens as allowed delegator
		delegator1.pullOnce(delegate.getAddress()).blockingAwait();
		waitUntilComplete(delegator1.stakeTokens(stakedAmount, token, delegate.getAddress()));

		// Stake tokens as not allowed delegator
		delegator2.pullOnce(delegate.getAddress()).blockingAwait();
		Assertions.assertThatThrownBy(()
			-> waitUntilComplete(delegator2.stakeTokens(stakedAmount, token, delegate.getAddress())))
			.hasMessageContaining("does not allow");
	}

	private void waitUntilComplete(RadixApplicationAPI api, CreateTokenAction action, RadixNode originNode) {
		Result result = api.execute(action, originNode);
		waitUntilComplete(result);
	}

	private void waitUntilComplete(Result result) {
		result.toObservable().subscribe(System.out::println);
		result.blockUntilComplete();
	}
}

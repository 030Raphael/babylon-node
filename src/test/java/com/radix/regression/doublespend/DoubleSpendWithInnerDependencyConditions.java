package com.radix.regression.doublespend;

import com.radixdlt.client.application.translate.ShardedAppStateId;
import com.radixdlt.client.application.translate.tokens.CreateTokenAction;
import com.radixdlt.client.application.translate.tokens.CreateTokenAction.TokenSupplyType;
import com.radixdlt.client.application.translate.tokens.TokenBalanceState;
import com.radixdlt.client.application.translate.tokens.TransferTokensAction;
import com.radixdlt.client.atommodel.accounts.RadixAddress;
import com.radixdlt.client.core.atoms.particles.RRI;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Condition;
import org.radix.common.tuples.Pair;

class DoubleSpendWithInnerDependencyConditions implements DoubleSpendTestConditions {
	private final RadixAddress apiAddress;
	private final RRI tokenRef;

	DoubleSpendWithInnerDependencyConditions(RadixAddress apiAddress) {
		this.tokenRef = RRI.of(apiAddress,"JOSH");
		this.apiAddress = apiAddress;
	}

	@Override
	public List<BatchedActions> initialActions() {
		return Collections.singletonList(
			new BatchedActions(
				CreateTokenAction.create(
					this.tokenRef,
					"Joshy Token",
					"Cool Token",
					BigDecimal.ONE,
					BigDecimal.ONE,
					TokenSupplyType.FIXED
				)
			)
		);
	}

	@Override
	public List<List<BatchedActions>> conflictingActions() {
		return Arrays.asList(
			Collections.singletonList(
				new BatchedActions(
					TransferTokensAction.create(tokenRef, apiAddress, apiAddress, BigDecimal.ONE),
					TransferTokensAction.create(tokenRef, apiAddress, apiAddress, BigDecimal.ONE)
				)
			),
			Collections.singletonList(
				new BatchedActions(
					TransferTokensAction.create(tokenRef, apiAddress, apiAddress, BigDecimal.ONE),
					TransferTokensAction.create(tokenRef, apiAddress, apiAddress, BigDecimal.ONE)
				)
			)
		);
	}

	@Override
	public PostConsensusCondition postConsensusCondition() {
		Set<Pair<String, ShardedAppStateId>> stateRequired = new HashSet<>();
		stateRequired.add(Pair.of("Balance", ShardedAppStateId.of(TokenBalanceState.class, apiAddress)));

		return new PostConsensusCondition(
			stateRequired,
			new Condition<>(map -> {
				TokenBalanceState balanceState = (TokenBalanceState) map.get(ShardedAppStateId.of(TokenBalanceState.class, apiAddress));
				return balanceState.getBalance().get(tokenRef).compareTo(BigDecimal.ONE) == 0;
			}, "1 JOSH in account")
		);
	}
}

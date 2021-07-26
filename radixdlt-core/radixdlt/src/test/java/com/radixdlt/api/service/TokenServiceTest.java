/* Copyright 2021 Radix Publishing Ltd incorporated in Jersey (Channel Islands).
 *
 * Licensed under the Radix License, Version 1.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at:
 *
 * radixfoundation.org/licenses/LICENSE-v1
 *
 * The Licensor hereby grants permission for the Canonical version of the Work to be
 * published, distributed and used under or by reference to the Licensor’s trademark
 * Radix ® and use of any unregistered trade names, logos or get-up.
 *
 * The Licensor provides the Work (and each Contributor provides its Contributions) on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT,
 * MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Whilst the Work is capable of being deployed, used and adopted (instantiated) to create
 * a distributed ledger it is your responsibility to test and validate the code, together
 * with all logic and performance of that code under all foreseeable scenarios.
 *
 * The Licensor does not make or purport to make and hereby excludes liability for all
 * and any representation, warranty or undertaking in any form whatsoever, whether express
 * or implied, to any entity or person, including any representation, warranty or
 * undertaking, as to the functionality security use, value or other characteristics of
 * any distributed ledger nor in respect the functioning or value of any tokens which may
 * be created stored or transferred using the Work. The Licensor does not warrant that the
 * Work or any use of the Work complies with any law or regulation in any territory where
 * it may be implemented or used or that it will be appropriate for any specific purpose.
 *
 * Neither the licensor nor any current or former employees, officers, directors, partners,
 * trustees, representatives, agents, advisors, contractors, or volunteers of the Licensor
 * shall be liable for any direct or indirect, special, incidental, consequential or other
 * losses of any kind, in tort, contract or otherwise (including but not limited to loss
 * of revenue, income or profits, or loss of use or data, or loss of reputation, or loss
 * of any economic or other opportunity of whatsoever nature or howsoever arising), arising
 * out of or in connection with (without limitation of any use, misuse, of any ledger system
 * or use made or its functionality or any performance or operation of any code or protocol
 * caused by bugs or programming or logic errors or otherwise);
 *
 * A. any offer, purchase, holding, use, sale, exchange or transmission of any
 * cryptographic keys, tokens or assets created, exchanged, stored or arising from any
 * interaction with the Work;
 *
 * B. any failure in a transmission or loss of any token or assets keys or other digital
 * artefacts due to errors in transmission;
 *
 * C. bugs, hacks, logic errors or faults in the Work or any communication;
 *
 * D. system software or apparatus including but not limited to losses caused by errors
 * in holding or transmitting tokens by any third-party;
 *
 * E. breaches or failure of security including hacker attacks, loss or disclosure of
 * password, loss of private key, unauthorised use or misuse of such passwords or keys;
 *
 * F. any losses including loss of anticipated savings or other benefits resulting from
 * use of the Work or any changes to the Work (however implemented).
 *
 * You are solely responsible for; testing, validating and evaluation of all operation
 * logic, functionality, security and appropriateness of using the Work for any commercial
 * or non-commercial purpose and for any reproduction or redistribution by You of the
 * Work. You assume all risks associated with Your use of the Work and the exercise of
 * permissions under this License.
 */
package com.radixdlt.api.service;

import com.radixdlt.networks.Addressing;
import com.radixdlt.networks.Network;
import org.junit.Assert;
import org.junit.Test;

import com.radixdlt.api.store.ClientApiStore;
import com.radixdlt.api.store.TokenDefinitionRecord;
import com.radixdlt.atom.actions.CreateMutableToken;
import com.radixdlt.crypto.ECKeyPair;
import com.radixdlt.crypto.ECPublicKey;
import com.radixdlt.identifiers.REAddr;
import com.radixdlt.utils.UInt384;
import com.radixdlt.utils.functional.Result;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TokenServiceTest {
	private static final ECPublicKey TOKEN_KEY = ECKeyPair.generateNew().getPublicKey();

	private final ClientApiStore clientApiStore = mock(ClientApiStore.class);
	private final Addressing addressing = Addressing.ofNetwork(Network.LOCALNET);
	private final TokenService tokenService = new TokenService(clientApiStore, addressing);

	@Test
	public void testGetNativeTokenDescription() {
		var token = REAddr.ofHashedKey(TOKEN_KEY, "xrd");
		var definition = TokenDefinitionRecord.from(TOKEN_KEY, mutableTokenDef("xrd"));

		when(clientApiStore.getTokenDefinition(eq(REAddr.ofNativeToken())))
			.thenReturn(Result.ok(definition));
		when(clientApiStore.getTokenSupply(any()))
			.thenReturn(Result.ok(UInt384.EIGHT));

		tokenService.getNativeTokenDescription()
			.onSuccess(description -> assertEquals(token, description.addr()))
			.onSuccess(description -> assertEquals(UInt384.EIGHT, description.currentSupply()))
			.onFailureDo(Assert::fail);
	}

	@Test
	public void testGetTokenDescription() {
		var token = REAddr.ofHashedKey(TOKEN_KEY, "fff");
		var definition = TokenDefinitionRecord.from(TOKEN_KEY, mutableTokenDef("fff"));

		when(clientApiStore.parseRri(any()))
			.thenReturn(Result.ok(token));
		when(clientApiStore.getTokenDefinition(eq(token)))
			.thenReturn(Result.ok(definition));
		when(clientApiStore.getTokenSupply(any()))
			.thenReturn(Result.ok(UInt384.NINE));

		var rri = addressing.forResources().of("fff", token);
		tokenService.getTokenDescription(rri)
			.onSuccess(description -> assertEquals(token, description.addr()))
			.onSuccess(description -> assertEquals(UInt384.NINE, description.currentSupply()))
			.onFailureDo(Assert::fail);
	}

	private CreateMutableToken mutableTokenDef(String symbol) {
		return new CreateMutableToken(
			TOKEN_KEY,
			symbol,
			symbol,
			description(symbol),
			iconUrl(symbol),
			homeUrl(symbol)
		);
	}

	private String description(String symbol) {
		return "Token with symbol " + symbol;
	}

	private String iconUrl(String symbol) {
		return "https://" + symbol.toLowerCase(Locale.US) + ".coin.com/icon";
	}

	private String homeUrl(String symbol) {
		return "https://" + symbol.toLowerCase(Locale.US) + ".coin.com/home";
	}
}
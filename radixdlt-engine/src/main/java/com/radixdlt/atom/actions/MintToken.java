/*
 * (C) Copyright 2021 Radix DLT Ltd
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
 *
 */

package com.radixdlt.atom.actions;

import com.radixdlt.atom.TxAction;
import com.radixdlt.atom.TxBuilder;
import com.radixdlt.atom.TxBuilderException;
import com.radixdlt.atommodel.tokens.TokensParticle;
import com.radixdlt.crypto.ECPublicKey;
import com.radixdlt.identifiers.REAddr;
import com.radixdlt.identifiers.RadixAddress;
import com.radixdlt.utils.UInt256;

public final class MintToken implements TxAction {
	private final REAddr rri;
	private final ECPublicKey to;
	private final UInt256 amount;

	public MintToken(REAddr rri, ECPublicKey to, UInt256 amount) {
		this.rri = rri;
		this.to = to;
		this.amount = amount;
	}

	public REAddr rri() {
		return rri;
	}

	public ECPublicKey to() {
		return to;
	}

	public UInt256 amount() {
		return amount;
	}

	@Override
	public void execute(TxBuilder txBuilder) throws TxBuilderException {
		txBuilder.up(new TokensParticle(to, amount, rri));
	}
}

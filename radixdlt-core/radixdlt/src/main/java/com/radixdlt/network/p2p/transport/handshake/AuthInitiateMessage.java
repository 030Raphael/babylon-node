/* Copyright 2021 Radix DLT Ltd incorporated in England.
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

package com.radixdlt.network.p2p.transport.handshake;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.hash.HashCode;
import com.radixdlt.crypto.ECDSASignature;
import com.radixdlt.serialization.DsonOutput;
import com.radixdlt.serialization.SerializerConstants;
import com.radixdlt.serialization.SerializerDummy;
import com.radixdlt.serialization.SerializerId2;

import java.util.Objects;
import java.util.Optional;

@SerializerId2("message.handshake.auth_initiate")
public final class AuthInitiateMessage {

	@JsonProperty(SerializerConstants.SERIALIZER_NAME)
	@DsonOutput(DsonOutput.Output.ALL)
	private SerializerDummy serializer = SerializerDummy.DUMMY;

	@JsonProperty("signature")
	@DsonOutput(DsonOutput.Output.ALL)
	private final ECDSASignature signature;

	@JsonProperty("publicKey")
	@DsonOutput(DsonOutput.Output.ALL)
	private final HashCode publicKey;

	@JsonProperty("nonce")
	@DsonOutput(DsonOutput.Output.ALL)
	private final HashCode nonce;

	@JsonProperty("networkId")
	@DsonOutput(DsonOutput.Output.ALL)
	private final int networkId;

	private final Optional<HashCode> latestKnownForkHash;

	@JsonCreator
	public static AuthInitiateMessage deserialize(
		@JsonProperty("signature") ECDSASignature signature,
		@JsonProperty("publicKey") HashCode publicKey,
		@JsonProperty("nonce") HashCode nonce,
		@JsonProperty("networkId") int networkId,
		@JsonProperty("latestKnownForkHash") HashCode rawLatestKnownForkHash
	) {
		final var latestKnownForkHash = rawLatestKnownForkHash == null
			? Optional.<HashCode>empty()
			: Optional.of(rawLatestKnownForkHash);
		return new AuthInitiateMessage(signature, publicKey, nonce, networkId, latestKnownForkHash);
	}

	public AuthInitiateMessage(ECDSASignature signature, HashCode publicKey, HashCode nonce, int networkId, Optional<HashCode> latestKnownForkHash) {
		this.signature = signature;
		this.publicKey = publicKey;
		this.nonce = nonce;
		this.networkId = networkId;
		this.latestKnownForkHash = latestKnownForkHash;
	}

	public ECDSASignature getSignature() {
		return signature;
	}

	public HashCode getPublicKey() {
		return publicKey;
	}

	public HashCode getNonce() {
		return nonce;
	}

	public int getNetworkId() {
		return networkId;
	}

	public Optional<HashCode> getLatestKnownForkHash() {
		return latestKnownForkHash;
	}

	@JsonProperty("latestKnownForkHash")
	@DsonOutput(DsonOutput.Output.ALL)
	public HashCode rawLatestKnownForkHash() {
		return this.latestKnownForkHash.orElse(null);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final var that = (AuthInitiateMessage) o;
		return Objects.equals(signature, that.signature)
			&& Objects.equals(publicKey, that.publicKey)
			&& Objects.equals(nonce, that.nonce)
			&& networkId == that.networkId
			&& Objects.equals(latestKnownForkHash, that.latestKnownForkHash);
	}

	@Override
	public int hashCode() {
		return Objects.hash(signature, publicKey, nonce, networkId, latestKnownForkHash);
	}
}

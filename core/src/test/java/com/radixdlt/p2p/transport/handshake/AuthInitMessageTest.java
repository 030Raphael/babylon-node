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

package com.radixdlt.p2p.transport.handshake;

import static org.junit.Assert.*;

import com.radixdlt.crypto.ECDSASecp256k1Signature;
import com.radixdlt.crypto.HashUtils;
import com.radixdlt.networks.Network;
import com.radixdlt.p2p.capability.Capabilities;
import com.radixdlt.p2p.capability.LedgerSyncCapability;
import com.radixdlt.p2p.capability.RemotePeerCapability;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class AuthInitMessageTest {

  @Test
  public void
      when_remote_peer_capabilities_is_null_then_it_is_equivalent_to_the_ledger_sync_capability() {
    AuthInitiateMessage initiateMessage = getAuthInitiateMessage(null);

    Assert.assertEquals(
        Set.of(new RemotePeerCapability(LedgerSyncCapability.NAME, Map.of())),
        initiateMessage.capabilities);
  }

  @Test
  public void
      when_number_of_remote_peer_capabilities_is_bigger_than_allowed_then_an_exception_is_thrown() {

    var remotePeerCapabilities = new HashSet<RemotePeerCapability>();
    for (var lc = 0; lc < Capabilities.MAX_NUMBER_OF_CAPABILITIES_ACCEPTED + 1; lc++) {
      remotePeerCapabilities.add(new RemotePeerCapability("DUMMY_CAPABILITY" + lc, Map.of()));
    }

    InvalidHandshakeMessageException invalidHandshakeMessageException =
        assertThrows(
            InvalidHandshakeMessageException.class,
            () -> getAuthInitiateMessage(remotePeerCapabilities));

    assertEquals(
        String.format(
            Capabilities.MAX_NUMBER_OF_CAPABILITIES_ACCEPTED_ERROR_MSG,
            remotePeerCapabilities.size(),
            Capabilities.MAX_NUMBER_OF_CAPABILITIES_ACCEPTED),
        invalidHandshakeMessageException.getMessage());
  }

  @Test
  public void when_remote_peer_capabilities_is_bigger_than_allowed_then_an_exception_is_thrown() {

    var configMap = new HashMap<String, String>();
    for (var lc = 0; lc < RemotePeerCapability.CONFIGURATION_MAP_MAX_SIZE + 1; lc++) {
      configMap.put("Config" + lc, "Value" + lc);
    }

    Set<RemotePeerCapability> remotePeerCapabilities =
        Set.of(new RemotePeerCapability(LedgerSyncCapability.NAME, configMap));

    InvalidHandshakeMessageException invalidHandshakeMessageException =
        assertThrows(
            InvalidHandshakeMessageException.class,
            () -> getAuthInitiateMessage(remotePeerCapabilities));

    Throwable cause = invalidHandshakeMessageException.getCause();
    assertTrue(cause instanceof IllegalArgumentException);
    assertEquals(
        String.format(
            RemotePeerCapability.MAP_MAX_SIZE_ERROR_MSG,
            RemotePeerCapability.CONFIGURATION_MAP_MAX_SIZE),
        cause.getMessage());
  }

  @Test
  public void
      when_remote_peer_capabilities_config_name_is_bigger_than_allowed_then_an_exception_is_thrown() {

    var configName = "N".repeat(RemotePeerCapability.CONFIGURATION_MAX_NAME_SIZE + 1);

    Set<RemotePeerCapability> remotePeerCapabilities =
        Set.of(
            new RemotePeerCapability(
                LedgerSyncCapability.NAME, Map.of(configName, "configValue1")));

    InvalidHandshakeMessageException invalidHandshakeMessageException =
        assertThrows(
            InvalidHandshakeMessageException.class,
            () -> getAuthInitiateMessage(remotePeerCapabilities));

    Throwable cause = invalidHandshakeMessageException.getCause();
    assertTrue(cause instanceof IllegalArgumentException);
    assertEquals(
        String.format(
            RemotePeerCapability.CONFIGURATION_NAME_MAX_SIZE_ERROR_MSG,
            configName,
            RemotePeerCapability.CONFIGURATION_MAX_NAME_SIZE),
        cause.getMessage());
  }

  @Test
  public void
      when_remote_peer_capabilities_config_value_is_bigger_than_allowed_then_an_exception_is_thrown() {

    var configName = "config1";
    var configValue = "V".repeat(RemotePeerCapability.CONFIGURATION_MAX_VALUE_SIZE + 1);

    Set<RemotePeerCapability> remotePeerCapabilities =
        Set.of(
            new RemotePeerCapability(LedgerSyncCapability.NAME, Map.of(configName, configValue)));

    InvalidHandshakeMessageException invalidHandshakeMessageException =
        assertThrows(
            InvalidHandshakeMessageException.class,
            () -> getAuthInitiateMessage(remotePeerCapabilities));

    Throwable cause = invalidHandshakeMessageException.getCause();
    assertTrue(cause instanceof IllegalArgumentException);
    assertEquals(
        String.format(
            RemotePeerCapability.CONFIGURATION_VALUE_MAX_SIZE_ERROR_MSG,
            configName,
            configValue,
            RemotePeerCapability.CONFIGURATION_MAX_VALUE_SIZE),
        cause.getMessage());
  }

  private AuthInitiateMessage getAuthInitiateMessage(
      Set<RemotePeerCapability> remotePeerCapabilities) {
    return new AuthInitiateMessage(
        ECDSASecp256k1Signature.zeroSignature(),
        HashUtils.random256(),
        HashUtils.random256(),
        Network.INTEGRATIONTESTNET.getId(),
        "fork",
        remotePeerCapabilities);
  }
}

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

package com.radixdlt.logger;

import static org.apache.logging.log4j.Level.*;

import com.google.common.util.concurrent.RateLimiter;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.multibindings.ProvidesIntoSet;
import com.radixdlt.application.tokens.Amount;
import com.radixdlt.consensus.ConsensusByzantineEvent;
import com.radixdlt.consensus.bft.BFTValidatorId;
import com.radixdlt.consensus.bft.Self;
import com.radixdlt.consensus.bft.SelfValidatorInfo;
import com.radixdlt.consensus.epoch.EpochChange;
import com.radixdlt.consensus.epoch.EpochRoundUpdate;
import com.radixdlt.consensus.liveness.EpochLocalTimeoutOccurrence;
import com.radixdlt.constraintmachine.REEvent;
import com.radixdlt.constraintmachine.REEvent.ValidatorBFTDataEvent;
import com.radixdlt.constraintmachine.REEvent.ValidatorMissedProposalsEvent;
import com.radixdlt.crypto.ECDSASecp256k1PublicKey;
import com.radixdlt.environment.EventProcessorOnDispatch;
import com.radixdlt.ledger.LedgerUpdate;
import com.radixdlt.utils.Bytes;
import java.util.function.Function;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class EventLoggerModule extends AbstractModule {
  private static final Logger logger = LogManager.getLogger();

  private final EventLoggerConfig eventLoggerConfig;

  public EventLoggerModule(EventLoggerConfig eventLoggerConfig) {
    this.eventLoggerConfig = eventLoggerConfig;
  }

  @Override
  public void configure() {
    bind(EventLoggerConfig.class).toInstance(eventLoggerConfig);
  }

  @Provides
  @Singleton
  Function<ECDSASecp256k1PublicKey, String> nodeKeyToStringFn(EventLoggerConfig eventLoggerConfig) {
    return eventLoggerConfig.nodeKeyToString();
  }

  @Provides
  @Self
  String name(
      Function<ECDSASecp256k1PublicKey, String> nodeToString, @Self ECDSASecp256k1PublicKey key) {
    return nodeToString.apply(key);
  }

  @ProvidesIntoSet
  EventProcessorOnDispatch<?> logByzantineEvents(Function<BFTValidatorId, String> nodeString) {
    return new EventProcessorOnDispatch<>(
        ConsensusByzantineEvent.class,
        event -> logger.warn("Byzantine Behavior detected: {}", event));
  }

  @Provides
  Function<BFTValidatorId, String> loggingFormatterForNode(
      Function<ECDSASecp256k1PublicKey, String> loggingFormatterForNodePublicKey) {
    return n -> loggingFormatterForNodePublicKey.apply(n.getKey());
  }

  /* BAB-TODO: Add something equivalent back in
  @ProvidesIntoSet
  EventProcessorOnDispatch<?> invalidProposedTxn(Function<ECPublicKey, String> nodeString) {
    return new EventProcessorOnDispatch<>(
        InvalidProposedTxn.class,
        i -> logger.warn("eng_badprp{proposer={}}", nodeString.apply(i.getProposer())));
  }
  */

  @ProvidesIntoSet
  EventProcessorOnDispatch<?> logTimeouts(Function<BFTValidatorId, String> nodeString) {
    return new EventProcessorOnDispatch<>(
        EpochLocalTimeoutOccurrence.class,
        t ->
            logger.warn(
                "bft_timeout{epoch={} round={} leader={} nextLeader={} count={}}",
                t.getEpochRound().getEpoch(),
                t.getEpochRound().getRound().number(),
                nodeString.apply(t.getLeader()),
                nodeString.apply(t.getNextLeader()),
                t.getBase().timeout().count()));
  }

  @ProvidesIntoSet
  @SuppressWarnings("UnstableApiUsage")
  EventProcessorOnDispatch<?> logRounds(Function<BFTValidatorId, String> nodeString) {
    final var logLimiter = RateLimiter.create(1.0);
    return new EventProcessorOnDispatch<>(
        EpochRoundUpdate.class,
        u -> {
          var logLevel = logLimiter.tryAcquire() ? INFO : TRACE;
          logger.log(
              logLevel,
              "bft_nxtrnd{epoch={} round={} leader={} nextLeader={}}",
              u.getEpoch(),
              u.getEpochRound().getRound().number(),
              nodeString.apply(u.getRoundUpdate().getLeader()),
              nodeString.apply(u.getRoundUpdate().getNextLeader()));
        });
  }

  @ProvidesIntoSet
  @Singleton
  @SuppressWarnings("UnstableApiUsage")
  EventProcessorOnDispatch<?> ledgerUpdate(
      // The `Provider` indirection is needed here to break an unexpected circular dependency.
      @Self Provider<SelfValidatorInfo> self,
      Function<ECDSASecp256k1PublicKey, String> nodeString) {
    final var logLimiter = RateLimiter.create(1.0);
    return new EventProcessorOnDispatch<>(
        LedgerUpdate.class,
        ledgerUpdate -> processLedgerUpdate(self.get(), nodeString, logLimiter, ledgerUpdate));
  }

  @SuppressWarnings("UnstableApiUsage")
  private static void processLedgerUpdate(
      SelfValidatorInfo self,
      Function<ECDSASecp256k1PublicKey, String> nodeString,
      RateLimiter logLimiter,
      LedgerUpdate ledgerUpdate) {

    /* BAB-TODO: Add something equivalent back in
     var output = ledgerUpdate.getStateComputerOutput().getInstance(REOutput.class);
    */
    var epochChange = ledgerUpdate.getStateComputerOutput().getInstance(EpochChange.class);

    /* BAB-TODO: Add something equivalent back in
     logLedgerUpdate(
         ledgerUpdate, countUserTxns(output), calculateLoggingLevel(logLimiter, epochChange));
    */
    long fakeUserTransactionCount = 0;
    logLedgerUpdate(
        ledgerUpdate, fakeUserTransactionCount, calculateLoggingLevel(logLimiter, epochChange));

    if (epochChange != null) {
      logEpochChange(self, epochChange);
    }

    /* BAB-TODO: Add something equivalent back in
     if (output == null) {
       return;
     }

     output.getProcessedTxns().stream()
         .flatMap(t -> t.getEvents().stream())
         .forEach(e -> logValidatorEvents(self, nodeString, e));
    */
  }

  private static void logEpochChange(SelfValidatorInfo self, EpochChange epochChange) {
    var validatorSet = epochChange.getBFTConfiguration().getValidatorSet();
    final var included = self.bftValidatorId().stream().anyMatch(validatorSet::containsValidator);
    logger.info(
        "lgr_nepoch{epoch={} included={} num_validators={} total_stake={}}",
        epochChange.getNextEpoch(),
        included,
        validatorSet.getValidators().size(),
        Amount.ofSubunits(validatorSet.getTotalPower()));
  }

  /* BAB-TODO: Add something equivalent back in
  private static long countUserTxns(REOutput output) {
    return output != null
        ? output.getProcessedTxns().stream().filter(t -> !t.isSystemOnly()).count()
        : 0;
  }
  */

  private static void logLedgerUpdate(
      LedgerUpdate ledgerUpdate, long userTransactionsCount, Level logLevel) {
    if (!logger.isEnabled(logLevel)) {
      return;
    }

    var proof = ledgerUpdate.getTail();
    logger.log(
        logLevel,
        "lgr_commit{epoch={} round={} version={} txn_root={} user_txns={}}",
        proof.getEpoch(),
        proof.getRound().number(),
        proof.getStateVersion(),
        Bytes.toHexString(proof.getLedgerHashes().getTransactionRoot().asBytes()).substring(0, 16),
        userTransactionsCount);
  }

  @SuppressWarnings("UnstableApiUsage")
  private static Level calculateLoggingLevel(RateLimiter logLimiter, EpochChange epochChange) {
    return (epochChange != null || logLimiter.tryAcquire()) ? INFO : TRACE;
  }

  private static void logValidatorEvents(
      BFTValidatorId self, Function<ECDSASecp256k1PublicKey, String> nodeString, REEvent e) {
    if (e instanceof ValidatorBFTDataEvent event) {
      var level = event.missedProposals() > 0 ? WARN : INFO;

      if (!logger.isEnabled(level)) {
        return;
      }

      logger.log(
          level,
          "vdr_epochr{validator={} completed_proposals={} missed_proposals={}}",
          nodeString.apply(event.validatorKey()),
          event.completedProposals(),
          event.missedProposals());
    } else if (e instanceof ValidatorMissedProposalsEvent event) {
      var you = event.validatorKey().equals(self.getKey());
      var level = you ? ERROR : WARN;

      if (!logger.isEnabled(level)) {
        return;
      }

      logger.log(
          level,
          "{}_failed{validator={} missed_proposals={}}",
          you ? "you" : "vdr",
          nodeString.apply(event.validatorKey()),
          event.missedProposals());
    }
  }
}

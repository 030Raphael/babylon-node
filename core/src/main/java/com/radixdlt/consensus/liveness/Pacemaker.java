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

package com.radixdlt.consensus.liveness;

import com.google.common.hash.HashCode;
import com.radixdlt.consensus.*;
import com.radixdlt.consensus.bft.*;
import com.radixdlt.consensus.bft.Round;
import com.radixdlt.consensus.safety.SafetyRules;
import com.radixdlt.consensus.sync.VertexStoreAdapter;
import com.radixdlt.crypto.Hasher;
import com.radixdlt.environment.EventDispatcher;
import com.radixdlt.environment.RemoteEventDispatcher;
import com.radixdlt.environment.ScheduledEventDispatcher;
import com.radixdlt.modules.init.ConsensusBootstrapProvider;
import com.radixdlt.monitoring.SystemCounters;
import com.radixdlt.monitoring.SystemCounters.CounterType;
import com.radixdlt.transactions.Transaction;
import com.radixdlt.utils.TimeSupplier;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Manages the pacemaker driver. */
public final class Pacemaker {
  private static final Logger log = LogManager.getLogger();

  private final BFTNode self;
  private final SystemCounters counters;
  private BFTValidatorSet validatorSet;
  private final VertexStoreAdapter vertexStore;
  private final SafetyRules safetyRules;
  private final ScheduledEventDispatcher<ScheduledLocalTimeout> timeoutSender;
  private final PacemakerTimeoutCalculator timeoutCalculator;
  private final ProposalGenerator proposalGenerator;
  private final Hasher hasher;
  private final RemoteEventDispatcher<Proposal> proposalDispatcher;
  private final RemoteEventDispatcher<Vote> voteDispatcher;
  private final EventDispatcher<LocalTimeoutOccurrence> timeoutDispatcher;
  private final TimeSupplier timeSupplier;
  private final SystemCounters systemCounters;

  private RoundUpdate latestRoundUpdate;
  private boolean isRoundTimedOut = false;
  private Optional<HashCode> timeoutVoteVertexId = Optional.empty();

  private ConsensusBootstrapProvider consensusBootstrapProvider;

  public Pacemaker(
      BFTNode self,
      SystemCounters counters,
      VertexStoreAdapter vertexStore,
      SafetyRules safetyRules,
      EventDispatcher<LocalTimeoutOccurrence> timeoutDispatcher,
      ScheduledEventDispatcher<ScheduledLocalTimeout> timeoutSender,
      PacemakerTimeoutCalculator timeoutCalculator,
      ProposalGenerator proposalGenerator,
      RemoteEventDispatcher<Proposal> proposalDispatcher,
      RemoteEventDispatcher<Vote> voteDispatcher,
      Hasher hasher,
      TimeSupplier timeSupplier,
      SystemCounters systemCounters,
      ConsensusBootstrapProvider consensusBootstrapProvider) {
    this.self = Objects.requireNonNull(self);
    this.counters = Objects.requireNonNull(counters);
    this.vertexStore = Objects.requireNonNull(vertexStore);
    this.safetyRules = Objects.requireNonNull(safetyRules);
    this.timeoutSender = Objects.requireNonNull(timeoutSender);
    this.timeoutDispatcher = Objects.requireNonNull(timeoutDispatcher);
    this.timeoutCalculator = Objects.requireNonNull(timeoutCalculator);
    this.proposalGenerator = Objects.requireNonNull(proposalGenerator);
    this.proposalDispatcher = Objects.requireNonNull(proposalDispatcher);
    this.hasher = Objects.requireNonNull(hasher);
    this.voteDispatcher = Objects.requireNonNull(voteDispatcher);
    this.timeSupplier = Objects.requireNonNull(timeSupplier);
    this.systemCounters = Objects.requireNonNull(systemCounters);
    this.consensusBootstrapProvider = Objects.requireNonNull(consensusBootstrapProvider);
  }

  public Pacemaker(
      BFTNode self,
      SystemCounters counters,
      BFTValidatorSet validatorSet,
      VertexStoreAdapter vertexStore,
      SafetyRules safetyRules,
      EventDispatcher<LocalTimeoutOccurrence> timeoutDispatcher,
      ScheduledEventDispatcher<ScheduledLocalTimeout> timeoutSender,
      PacemakerTimeoutCalculator timeoutCalculator,
      ProposalGenerator proposalGenerator,
      RemoteEventDispatcher<Proposal> proposalDispatcher,
      RemoteEventDispatcher<Vote> voteDispatcher,
      Hasher hasher,
      TimeSupplier timeSupplier,
      RoundUpdate initialRoundUpdate,
      SystemCounters systemCounters) {
    this(
        self,
        counters,
        vertexStore,
        safetyRules,
        timeoutDispatcher,
        timeoutSender,
        timeoutCalculator,
        proposalGenerator,
        proposalDispatcher,
        voteDispatcher,
        hasher,
        timeSupplier,
        systemCounters);
    this.validatorSet = Objects.requireNonNull(validatorSet);
    this.latestRoundUpdate = Objects.requireNonNull(initialRoundUpdate);
  }

  public Pacemaker(
      BFTNode self,
      SystemCounters counters,
      VertexStoreAdapter vertexStore,
      SafetyRules safetyRules,
      EventDispatcher<LocalTimeoutOccurrence> timeoutDispatcher,
      ScheduledEventDispatcher<ScheduledLocalTimeout> timeoutSender,
      PacemakerTimeoutCalculator timeoutCalculator,
      ProposalGenerator proposalGenerator,
      RemoteEventDispatcher<Proposal> proposalDispatcher,
      RemoteEventDispatcher<Vote> voteDispatcher,
      Hasher hasher,
      TimeSupplier timeSupplier,
      SystemCounters systemCounters) {
    this.self = Objects.requireNonNull(self);
    this.counters = Objects.requireNonNull(counters);
    this.vertexStore = Objects.requireNonNull(vertexStore);
    this.safetyRules = Objects.requireNonNull(safetyRules);
    this.timeoutSender = Objects.requireNonNull(timeoutSender);
    this.timeoutDispatcher = Objects.requireNonNull(timeoutDispatcher);
    this.timeoutCalculator = Objects.requireNonNull(timeoutCalculator);
    this.proposalGenerator = Objects.requireNonNull(proposalGenerator);
    this.proposalDispatcher = Objects.requireNonNull(proposalDispatcher);
    this.hasher = Objects.requireNonNull(hasher);
    this.voteDispatcher = Objects.requireNonNull(voteDispatcher);
    this.timeSupplier = Objects.requireNonNull(timeSupplier);
    this.systemCounters = Objects.requireNonNull(systemCounters);
  }

  public void start() {
    log.info("Pacemaker Start: {}", this.getLatestRoundUpdate());
    this.startRound();
  }

  /** Processes a local round update message * */
  public void processRoundUpdate(RoundUpdate roundUpdate) {
    log.trace("Round Update: {}", roundUpdate);

    final var previousRound = this.getLatestRoundUpdate().getCurrentRound();
    if (roundUpdate.getCurrentRound().lte(previousRound)) {
      return;
    }
    this.latestRoundUpdate = roundUpdate;
    this.systemCounters.set(
        CounterType.BFT_PACEMAKER_ROUND, roundUpdate.getCurrentRound().number());

    this.startRound();
  }

  /** Processes a local BFTInsertUpdate message */
  public void processBFTUpdate(BFTInsertUpdate update) {
    /* we only process the insertion of an empty vertex used for timeout vote (see: processLocalTimeout) */
    if (!this.isRoundTimedOut
        || this.timeoutVoteVertexId
            .filter(update.getInserted().getVertexHash()::equals)
            .isEmpty()) {
      return;
    }

    this.createAndSendTimeoutVote(update.getInserted());
  }

  private void startRound() {
    this.isRoundTimedOut = false;
    this.timeoutVoteVertexId = Optional.empty();

    final var timeoutMs =
        timeoutCalculator.calculateTimeoutMs(
            this.getLatestRoundUpdate().consecutiveUncommittedRoundsCount());
    final var timeoutEvent = ScheduledLocalTimeout.create(this.getLatestRoundUpdate(), timeoutMs);
    this.timeoutSender.dispatch(timeoutEvent, timeoutMs);

    final var currentRoundProposer = this.getLatestRoundUpdate().getLeader();
    if (this.self.equals(currentRoundProposer)) {
      Optional<Proposal> proposalMaybe =
          generateProposal(this.getLatestRoundUpdate().getCurrentRound());
      proposalMaybe.ifPresent(
          proposal -> {
            log.trace("Broadcasting proposal: {}", proposal);
            this.proposalDispatcher.dispatch(this.getValidatorSet().nodes(), proposal);
            this.counters.increment(CounterType.BFT_PACEMAKER_PROPOSALS_SENT);
          });
    }
  }

  private Optional<Proposal> generateProposal(Round round) {
    final var highQC = this.getLatestRoundUpdate().getHighQC();
    final var highestQC = highQC.highestQC();

    final var nextTransactions = getTransactionsForProposal(round, highestQC);

    final var proposedVertex =
        Vertex.create(highestQC, round, nextTransactions, self).withId(hasher);
    return safetyRules.signProposal(
        proposedVertex, highQC.highestCommittedQC(), highQC.highestTC());
  }

  private List<Transaction> getTransactionsForProposal(Round round, QuorumCertificate highestQC) {
    // If we're at the end of an epoch, we need to generate an empty proposal
    // - these transactions will get ignored at vertex preparation time anyway
    // TODO: Remove isEndOfEpoch knowledge from consensus
    if (highestQC.getProposedHeader().getLedgerHeader().isEndOfEpoch()) {
      return List.of();
    }

    final var alreadyExecutedVertices =
        vertexStore.getPathFromRoot(highestQC.getProposedHeader().getVertexId());
    final var nextTransactions =
        proposalGenerator.getTransactionsForProposal(round, alreadyExecutedVertices);
    systemCounters.add(CounterType.BFT_PACEMAKER_PROPOSED_TRANSACTIONS, nextTransactions.size());
    return nextTransactions;
  }

  /**
   * Processes a local timeout, causing the pacemaker to either broadcast previously sent vote to
   * all nodes or broadcast a new vote for a "null" proposal. In either case, the sent vote includes
   * a timeout signature, which can later be used to form a timeout certificate.
   */
  public void processLocalTimeout(ScheduledLocalTimeout scheduledTimeout) {
    final var round = scheduledTimeout.round();

    if (!round.equals(this.getLatestRoundUpdate().getCurrentRound())) {
      log.trace(
          "LocalTimeout: Ignoring timeout {}, current is {}",
          scheduledTimeout,
          this.getLatestRoundUpdate().getCurrentRound());
      return;
    }

    log.trace("LocalTimeout: {}", scheduledTimeout);

    this.isRoundTimedOut = true;

    updateTimeoutCounters(scheduledTimeout);

    this.safetyRules
        .getLastVote(round)
        .map(this.safetyRules::timeoutVote)
        .ifPresentOrElse(
            /* if there is a previously sent vote, we time it out and broadcast to all nodes */
            vote -> this.voteDispatcher.dispatch(this.getValidatorSet().nodes(), vote),
            /* otherwise, we asynchronously insert an empty vertex and, when done,
            we send a timeout vote on it (see processBFTUpdate) */
            () -> createTimeoutVertexAndSendVote(scheduledTimeout.roundUpdate()));

    rescheduleTimeout(scheduledTimeout);
  }

  public BFTValidatorSet getValidatorSet() {
    if (this.validatorSet == null) {
      this.validatorSet = this.consensusBootstrapProvider.currentKnownValidatorSet();
    }
    return this.validatorSet;
  }

  public RoundUpdate getLatestRoundUpdate() {
    if (this.latestRoundUpdate == null) {
      this.latestRoundUpdate = this.consensusBootstrapProvider.currentKnownRoundUpdate();
    }
    return this.latestRoundUpdate;
  }

  private void createTimeoutVertexAndSendVote(RoundUpdate roundUpdate) {
    if (this.timeoutVoteVertexId.isPresent()) {
      return; // vertex for a timeout vote for this round is already inserted
    }

    final var highQC = this.getLatestRoundUpdate().getHighQC();
    final var vertex =
        Vertex.createTimeout(
                highQC.highestQC(), roundUpdate.getCurrentRound(), roundUpdate.getLeader())
            .withId(hasher);
    this.timeoutVoteVertexId = Optional.of(vertex.getHash());

    // TODO: reimplement in async way
    this.vertexStore
        .getExecutedVertex(vertex.getHash())
        .ifPresentOrElse(
            this::createAndSendTimeoutVote, // if vertex is already there, send the vote immediately
            () -> maybeInsertVertex(vertex) // otherwise insert and wait for async bft update msg
            );
  }

  // FIXME: This is a temporary fix so that we can continue
  // if the vertex store is too far ahead of the pacemaker
  private void maybeInsertVertex(VertexWithHash vertexWithHash) {
    try {
      this.vertexStore.insertVertex(vertexWithHash);
    } catch (MissingParentException e) {
      log.debug("Could not insert timeout vertex: {}", e.getMessage());
    }
  }

  private void createAndSendTimeoutVote(ExecutedVertex executedVertex) {
    final var bftHeader =
        new BFTHeader(
            executedVertex.getRound(),
            executedVertex.getVertexHash(),
            executedVertex.getLedgerHeader());

    final var baseVote =
        this.safetyRules.createVote(
            executedVertex.getVertex(),
            bftHeader,
            this.timeSupplier.currentTime(),
            this.getLatestRoundUpdate().getHighQC());

    final var timeoutVote = this.safetyRules.timeoutVote(baseVote);

    this.voteDispatcher.dispatch(this.getValidatorSet().nodes(), timeoutVote);
  }

  private void updateTimeoutCounters(ScheduledLocalTimeout scheduledTimeout) {
    if (scheduledTimeout.count() == 0) {
      counters.increment(CounterType.BFT_PACEMAKER_TIMED_OUT_ROUNDS);
    }
    counters.increment(CounterType.BFT_PACEMAKER_TIMEOUTS_SENT);
  }

  private void rescheduleTimeout(ScheduledLocalTimeout scheduledTimeout) {
    final var localTimeoutOccurrence = new LocalTimeoutOccurrence(scheduledTimeout);
    this.timeoutDispatcher.dispatch(localTimeoutOccurrence);

    final var timeout =
        timeoutCalculator.calculateTimeoutMs(
            this.getLatestRoundUpdate().consecutiveUncommittedRoundsCount());
    final var nextTimeout = scheduledTimeout.nextRetry(timeout);
    this.timeoutSender.dispatch(nextTimeout, timeout);
  }
}

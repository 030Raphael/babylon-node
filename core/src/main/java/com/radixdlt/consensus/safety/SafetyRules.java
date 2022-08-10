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

package com.radixdlt.consensus.safety;

import com.google.common.hash.HashCode;
import com.google.inject.Inject;
import com.radixdlt.consensus.*;
import com.radixdlt.consensus.bft.*;
import com.radixdlt.consensus.bft.Round;
import com.radixdlt.consensus.liveness.VoteTimeout;
import com.radixdlt.consensus.safety.SafetyState.Builder;
import com.radixdlt.crypto.ECDSASignature;
import com.radixdlt.crypto.Hasher;
import com.radixdlt.modules.init.ConsensusBootstrapProvider;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Manages safety of the protocol. */
public final class SafetyRules {
  private static final Logger logger = LogManager.getLogger();

  private static final int VERIFIED_CERTIFICATES_CACHE_MAX_SIZE = 1000;

  private final BFTNode self;
  private final Hasher hasher;
  private final HashSigner signer;
  private final HashVerifier hashVerifier;
  private BFTValidatorSet validatorSet;
  private final PersistentSafetyStateStore persistentSafetyStateStore;

  private SafetyState safetyState;
  private final Set<HashCode> verifiedCertificatesCache = new LinkedHashSet<>();

  private ConsensusBootstrapProvider consensusBootstrapProvider;

  @Inject
  public SafetyRules(
      @Self BFTNode self,
      PersistentSafetyStateStore persistentSafetyStateStore,
      Hasher hasher,
      HashSigner signer,
      HashVerifier hashVerifier,
      ConsensusBootstrapProvider consensusBootstrapProvider) {
    this.self = self;
    this.persistentSafetyStateStore = Objects.requireNonNull(persistentSafetyStateStore);
    this.hasher = Objects.requireNonNull(hasher);
    this.signer = Objects.requireNonNull(signer);
    this.hashVerifier = Objects.requireNonNull(hashVerifier);
    this.consensusBootstrapProvider = consensusBootstrapProvider;
  }

  public SafetyRules(
      @Self BFTNode self,
      SafetyState initialState,
      PersistentSafetyStateStore persistentSafetyStateStore,
      Hasher hasher,
      HashSigner signer,
      HashVerifier hashVerifier,
      BFTValidatorSet validatorSet) {
    this.self = self;
    this.safetyState = Objects.requireNonNull(initialState);
    this.persistentSafetyStateStore = Objects.requireNonNull(persistentSafetyStateStore);
    this.hasher = Objects.requireNonNull(hasher);
    this.signer = Objects.requireNonNull(signer);
    this.hashVerifier = Objects.requireNonNull(hashVerifier);
    this.validatorSet = Objects.requireNonNull(validatorSet);
  }

  private boolean checkLastVoted(VertexWithHash proposedVertex) {
    // ensure vertex does not violate earlier votes
    if (proposedVertex.getRound().lte(this.getSafetyState().getLastVotedRound())) {
      logger.warn(
          "Safety warning: Vertex {} violates earlier vote at round {}",
          proposedVertex,
          this.getSafetyState().getLastVotedRound());
      return false;
    } else {
      return true;
    }
  }

  private boolean checkLocked(VertexWithHash proposedVertex, Builder nextStateBuilder) {
    if (proposedVertex.getParentHeader().getRound().lt(this.getSafetyState().getLockedRound())) {
      logger.warn(
          "Safety warning: Vertex {} does not respect locked round {}",
          proposedVertex,
          this.getSafetyState().getLockedRound());
      return false;
    }

    // pre-commit phase on consecutive qc's proposed vertex
    if (proposedVertex
            .getGrandParentHeader()
            .getRound()
            .compareTo(this.getSafetyState().getLockedRound())
        > 0) {
      nextStateBuilder.lockedRound(proposedVertex.getGrandParentHeader().getRound());
    }
    return true;
  }

  /**
   * Create a signed proposal from a vertex
   *
   * @param proposedVertex vertex to sign
   * @param highestCommittedQC highest known committed QC
   * @param highestTC highest known TC
   * @return signed proposal object for consensus
   */
  public Optional<Proposal> signProposal(
      VertexWithHash proposedVertex,
      QuorumCertificate highestCommittedQC,
      Optional<TimeoutCertificate> highestTC) {
    final Builder safetyStateBuilder = this.getSafetyState().toBuilder();
    if (!checkLocked(proposedVertex, safetyStateBuilder)) {
      return Optional.empty();
    }

    this.safetyState = safetyStateBuilder.build();

    final ECDSASignature signature = this.signer.sign(proposedVertex.getHash());
    return Optional.of(
        new Proposal(proposedVertex.toSerializable(), highestCommittedQC, signature, highestTC));
  }

  private static VoteData constructVoteData(
      VertexWithHash proposedVertex, BFTHeader proposedHeader) {
    final BFTHeader parent = proposedVertex.getParentHeader();

    // Add a vertex to commit if creating a quorum for the proposed vertex would
    // create three consecutive qcs.
    final BFTHeader toCommit;
    if (proposedVertex.touchesGenesis()
        || !proposedVertex.hasDirectParent()
        || !proposedVertex.parentHasDirectParent()) {
      toCommit = null;
    } else {
      toCommit = proposedVertex.getGrandParentHeader();
    }

    return new VoteData(proposedHeader, parent, toCommit);
  }

  /**
   * Vote for a proposed vertex while ensuring that safety invariants are upheld.
   *
   * @param proposedVertex The proposed vertex
   * @param proposedHeader results of vertex execution
   * @param timestamp timestamp to use for the vote in milliseconds since epoch
   * @param highQC our current sync state
   * @return A vote result containing the vote and any committed vertices
   */
  public Optional<Vote> voteFor(
      VertexWithHash proposedVertex, BFTHeader proposedHeader, long timestamp, HighQC highQC) {
    Builder safetyStateBuilder = this.getSafetyState().toBuilder();

    if (!checkLastVoted(proposedVertex)) {
      return Optional.empty();
    }

    if (!checkLocked(proposedVertex, safetyStateBuilder)) {
      return Optional.empty();
    }

    final Vote vote = createVote(proposedVertex, proposedHeader, timestamp, highQC);

    safetyStateBuilder.lastVote(vote);

    this.safetyState = safetyStateBuilder.build();
    this.persistentSafetyStateStore.commitState(this.getSafetyState());

    return Optional.of(vote);
  }

  public Vote timeoutVote(Vote vote) {
    if (vote.isTimeout()) { // vote is already timed out
      return vote;
    }

    final VoteTimeout voteTimeout = VoteTimeout.of(vote);
    final HashCode voteTimeoutHash = hasher.hashDsonEncoded(voteTimeout);

    final ECDSASignature timeoutSignature = this.signer.sign(voteTimeoutHash);
    final Vote timeoutVote = vote.withTimeoutSignature(timeoutSignature);

    this.safetyState = this.getSafetyState().toBuilder().lastVote(timeoutVote).build();
    this.persistentSafetyStateStore.commitState(this.getSafetyState());

    return timeoutVote;
  }

  public Vote createVote(
      VertexWithHash proposedVertex, BFTHeader proposedHeader, long timestamp, HighQC highQC) {
    final VoteData voteData = constructVoteData(proposedVertex, proposedHeader);
    final var voteHash = Vote.getHashOfData(hasher, voteData, timestamp);

    // TODO make signing more robust by including author in signed hash
    final ECDSASignature signature = this.signer.sign(voteHash);
    return new Vote(this.self, voteData, timestamp, signature, highQC, Optional.empty());
  }

  public Optional<Vote> getLastVote(Round round) {
    return this.getSafetyState()
        .getLastVote()
        .filter(lastVote -> lastVote.getRound().equals(round));
  }

  public boolean verifyHighQcAgainstTheValidatorSet(HighQC highQC) {
    return verifyQcAgainstTheValidatorSet(highQC.highestQC())
        && verifyQcAgainstTheValidatorSet(highQC.highestCommittedQC())
        && highQC.highestTC().stream().allMatch(this::verifyTcAgainstTheValidatorSet);
  }

  public boolean verifyQcAgainstTheValidatorSet(QuorumCertificate qc) {
    final var qcHash = hasher.hashDsonEncoded(qc);

    if (verifiedCertificatesCache.contains(qcHash)) {
      return true;
    }

    if (isGenesisQc(qc)) {
      // A genesis QC doesn't require any signatures
      return true;
    }

    if (!areAllQcTimestampedSignaturesValid(qc)) {
      logger.warn("QC {} contains invalid signatures", qc);
      return false;
    }

    final var validationState = ValidationState.forValidatorSet(this.getValidatorSet());

    final var allSignaturesAddedSuccessfully =
        qc.getTimestampedSignatures().getSignatures().entrySet().stream()
            .allMatch(
                e ->
                    validationState.addSignature(
                        e.getKey(), e.getValue().timestamp(), e.getValue().signature()));

    final var isQcValid = allSignaturesAddedSuccessfully && validationState.complete();

    if (isQcValid) {
      addVerifiedCertificateToCache(qcHash);
    }

    return isQcValid;
  }

  private void addVerifiedCertificateToCache(HashCode certificateHash) {
    if (verifiedCertificatesCache.size() >= VERIFIED_CERTIFICATES_CACHE_MAX_SIZE) {
      final var iter = verifiedCertificatesCache.iterator();
      iter.next();
      iter.remove();
    }
    verifiedCertificatesCache.add(certificateHash);
  }

  private boolean isGenesisQc(QuorumCertificate qc) {
    final var committedAndParentAndProposedAreTheSame =
        qc.getCommittedHeader()
            .map(
                committed ->
                    qc.getProposedHeader().equals(committed)
                        && qc.getParentHeader().equals(committed))
            .orElse(false);

    final var isGenesisRound = qc.getProposedHeader().getRound().isGenesis();

    return committedAndParentAndProposedAreTheSame && isGenesisRound;
  }

  private boolean areAllQcTimestampedSignaturesValid(QuorumCertificate qc) {
    final var voteData = qc.getVoteData();
    return qc.getTimestampedSignatures().getSignatures().entrySet().parallelStream()
        .allMatch(
            e -> {
              final var nodePublicKey = e.getKey().getKey();
              final var voteHash = Vote.getHashOfData(hasher, voteData, e.getValue().timestamp());
              return hashVerifier.verify(nodePublicKey, voteHash, e.getValue().signature());
            });
  }

  public boolean verifyTcAgainstTheValidatorSet(TimeoutCertificate tc) {
    final var tcHash = hasher.hashDsonEncoded(tc);

    if (verifiedCertificatesCache.contains(tcHash)) {
      return true;
    }

    final var isTcValid =
        tc.getSigners().allMatch(this.getValidatorSet()::containsNode)
            && areAllTcTimestampedSignaturesValid(tc);

    if (isTcValid) {
      addVerifiedCertificateToCache(tcHash);
    }

    return isTcValid;
  }

  private boolean areAllTcTimestampedSignaturesValid(TimeoutCertificate tc) {
    final var voteTimeout = new VoteTimeout(tc.getRound(), tc.getEpoch());
    final var voteTimeoutHash = hasher.hashDsonEncoded(voteTimeout);
    return tc.getTimestampedSignatures().getSignatures().entrySet().parallelStream()
        .allMatch(
            e -> {
              final var nodePublicKey = e.getKey().getKey();
              return hashVerifier.verify(nodePublicKey, voteTimeoutHash, e.getValue().signature());
            });
  }

  public BFTValidatorSet getValidatorSet() {
    if (this.validatorSet == null) {
      this.validatorSet = this.consensusBootstrapProvider.currentKnownValidatorSet();
    }
    return validatorSet;
  }

  public SafetyState getSafetyState() {
    if (this.safetyState == null) {
      this.safetyState = this.consensusBootstrapProvider.initialSafetyState();
    }
    return safetyState;
  }
}

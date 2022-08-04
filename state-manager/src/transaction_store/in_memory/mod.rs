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

use crate::transaction_store::*;

mod in_memory_proofdb;
mod in_memory_transactiondb;

use in_memory_proofdb::*;
use in_memory_transactiondb::*;

pub struct InMemoryTransactionStore {
    transaction_db: InMemoryTransactionDatabase,
    proof_db: InMemoryProofDatabase,
    vertex_state: Option<Vec<u8>>,
}

impl InMemoryTransactionStore {
    pub fn new(config: TransactionStoreConfig) -> InMemoryTransactionStore {
        InMemoryTransactionStore {
            transaction_db: InMemoryTransactionDatabase::new(),
            proof_db: InMemoryProofDatabase::new(config.minimum_block_size),
            vertex_state: None,
        }
    }
}

impl TransactionStore for InMemoryTransactionStore {
    fn store_begin(&mut self) {
        // Nop in memory store.
    }

    fn store_transaction(
        &mut self,
        transaction: Transaction,
    ) -> Result<TransactionStateVersion, TransactionStoreStoreError> {
        self.transaction_db.store(transaction)
    }

    fn store_proof(&mut self, proof: LedgerProof) -> Result<(), StoreProofError> {
        let last_version: TransactionStateVersion = match self.transaction_db.last_version() {
            Some(version) => version,
            None => {
                return Err(StoreProofError::NoTransactionBeforeProof);
            }
        };

        let proof_version = proof.state_version();

        if last_version != proof_version {
            return Err(StoreProofError::ProofStateVersionMismatch(
                proof_version,
                last_version,
            ));
        }

        self.proof_db.store(proof);
        Ok(())
    }

    fn store_vertex_state(&mut self, vertex_state: Vec<u8>) {
        self.vertex_state = Some(vertex_state);
    }

    fn store_commit(&mut self) {
        // Nop in memory store.
    }

    fn epoch_proof(&self, epoch: EpochId) -> Result<LedgerProof, EpochProofError> {
        self.proof_db
            .epoch_proof(epoch)
            .ok_or(EpochProofError::EpochProofNotFound(epoch))
    }

    fn last_proof(&self) -> Result<LedgerProof, LastProofError> {
        self.proof_db
            .last_proof()
            .ok_or(LastProofError::ProofNotFound)
    }

    fn first_proved_transactions(
        &self,
    ) -> Result<ProvedTransactions, FirstProvedTransactionsError> {
        let first_proof = self
            .proof_db
            .first_proof()
            .ok_or(FirstProvedTransactionsError::FirstProofNotFound)?;

        let mut transactions = Vec::new();
        for i in 0..=first_proof.state_version {
            let t = self
                .transaction_db
                .get(i)
                .ok_or(FirstProvedTransactionsError::TransactionNotFound(i))?;
            transactions.push(t);
        }

        Ok(ProvedTransactions::new(first_proof, transactions))
    }

    fn next_proved_transactions(
        &self,
        state_version: TransactionStateVersion,
    ) -> Result<ProvedTransactions, NextProvedTransactionsError> {
        let next_proof = self.proof_db.next_proof(state_version)?;

        let mut transactions = Vec::new();
        for i in state_version + 1..=next_proof.state_version {
            let t = self
                .transaction_db
                .get(i)
                .ok_or(NextProvedTransactionsError::TransactionNotFound(i))?;
            transactions.push(t);
        }

        Ok(ProvedTransactions::new(next_proof, transactions))
    }

    fn vertex_state(&self) -> Result<Vec<u8>, VertexStateError> {
        self.vertex_state
            .clone()
            .ok_or(VertexStateError::VertexStateNotFound)
    }
}

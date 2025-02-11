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

use std::cmp::Ordering;
use std::iter::Peekable;

use crate::prelude::*;
use crate::staging::StateTreeDiff;
pub use commit::*;
pub use extensions::*;
pub use gc::*;
pub use indices::*;
pub use measurement::*;
pub use proofs::*;
pub use scenario::*;
pub use substate::*;
pub use transactions::*;
pub use vertex::*;

#[derive(Debug, Clone)]
pub enum DatabaseConfigValidationError {
    AccountChangeIndexRequiresLocalTransactionExecutionIndex,
    LocalTransactionExecutionIndexChanged,
}

/// Database flags required for initialization built from config file and environment variables.
#[derive(Debug, Clone, Sbor)]
pub struct DatabaseConfig {
    pub enable_local_transaction_execution_index: bool,
    pub enable_account_change_index: bool,
    pub enable_historical_substate_values: bool,
    pub enable_entity_listing_indices: bool,
}

impl Default for DatabaseConfig {
    fn default() -> Self {
        DatabaseConfig {
            enable_local_transaction_execution_index: true,
            enable_account_change_index: true,
            enable_historical_substate_values: false,
            enable_entity_listing_indices: true,
        }
    }
}

/// Current state of database configuration. We need Option<T> for
/// fields that are missing. Missing fields usually mean the database is
/// just being initialized (when all of the fields are None) but also
/// when new configurations are added - this is a cheap work around to
/// limit future needed ledger wipes until we have a better solution.
pub struct DatabaseConfigState {
    pub local_transaction_execution_index_enabled: Option<bool>,
    pub account_change_index_enabled: Option<bool>,
}

impl DatabaseConfig {
    pub fn validate(
        &self,
        current_database_config: &DatabaseConfigState,
    ) -> Result<(), DatabaseConfigValidationError> {
        if !self.enable_local_transaction_execution_index && self.enable_account_change_index {
            return Err(DatabaseConfigValidationError::AccountChangeIndexRequiresLocalTransactionExecutionIndex);
        }
        if let Some(local_transaction_execution_index_enabled) =
            current_database_config.local_transaction_execution_index_enabled
        {
            if self.enable_local_transaction_execution_index
                != local_transaction_execution_index_enabled
            {
                return Err(DatabaseConfigValidationError::LocalTransactionExecutionIndexChanged);
            }
        }
        Ok(())
    }
}

pub trait ConfigurableDatabase {
    fn is_account_change_index_enabled(&self) -> bool;

    fn is_local_transaction_execution_index_enabled(&self) -> bool;

    fn are_entity_listing_indices_enabled(&self) -> bool;

    /// Returns [`true`] if the Node should be storing historical Substate values (and if it can
    /// handle historical state requests).
    ///
    /// The exact [`StateVersion`] from which the history is available can be obtained from
    /// [`Self::get_first_stored_historical_state_version()`].
    fn is_state_history_enabled(&self) -> bool;

    /// Returns the first [`StateVersion`]s for which *historical* Substate values are currently
    /// available in the database.
    ///
    /// This method assumes that [`Self::is_state_history_enabled()`] returned [`true`] and *panics*
    /// otherwise.
    fn get_first_stored_historical_state_version(&self) -> StateVersion;
}

#[derive(Debug, Clone)]
pub struct CommittedTransactionBundle {
    pub state_version: StateVersion,
    pub raw: RawLedgerTransaction,
    pub receipt: LocalTransactionReceipt,
    pub identifiers: CommittedTransactionIdentifiers,
}

#[derive(Debug, Clone)]
pub struct LeafSubstateKeyAssociation {
    pub tree_node_key: StoredTreeNodeKey,
    pub substate_value: Vec<u8>,
}

pub mod vertex {
    use super::*;

    pub trait RecoverableVertexStore {
        fn get_vertex_store(&self) -> Option<VertexStoreBlob>;
    }

    pub trait WriteableVertexStore {
        fn save_vertex_store(&self, blob: VertexStoreBlob);
    }

    define_single_versioned! {
        #[derive(Debug, Clone, ScryptoSbor)]
        pub VersionedVertexStoreBlob(VertexStoreBlobVersions) => VertexStoreBlob = VertexStoreBlobV1,
        outer_attributes: [
            #[derive(ScryptoSborAssertion)]
            #[sbor_assert(backwards_compatible(
                cuttlefish = "FILE:CF_SCHEMA_versioned_vertex_store_blob_cuttlefish.bin"
            ))]
        ]
    }

    #[derive(Debug, Clone, ScryptoSbor)]
    pub struct VertexStoreBlobV1(pub Vec<u8>);
}

pub mod substate {
    use super::*;

    /// A low-level storage of [`SubstateNodeAncestryRecord`].
    ///
    /// API note: this trait defines a simple "get by ID" method, and also a performance-driven
    /// batch method. Both provide default implementations (which mutually reduce one problem to the
    /// other). The implementer must choose to implement at least one of the methods, based on its
    /// nature (though implementing both rarely makes sense).
    /// When in doubt, implementing the batch method should be the default.
    pub trait SubstateNodeAncestryStore {
        /// Returns the [`SubstateNodeAncestryRecord`] for the given [`NodeId`], or [`None`] if:
        /// - the `node_id` happens to be a root Node (since they do not have "ancestry");
        /// - or the `node_id` does not exist yet.
        fn get_ancestry(&self, node_id: &NodeId) -> Option<SubstateNodeAncestryRecord> {
            let records = self.batch_get_ancestry([node_id]);
            if records.len() != 1 {
                panic!(
                    "trait contract violated: expected a single result for {:?}, got {:?}",
                    node_id, records
                )
            }
            records.into_iter().next().unwrap()
        }

        /// A batch counterpart of the [`get_ancestry()`].
        /// The results are returned in the same order as the input `node_ids`.
        fn batch_get_ancestry<'a>(
            &self,
            node_ids: impl IntoIterator<Item = &'a NodeId>,
        ) -> Vec<Option<SubstateNodeAncestryRecord>> {
            node_ids
                .into_iter()
                .map(|node_id| self.get_ancestry(node_id))
                .collect()
        }
    }

    define_single_versioned! {
        #[derive(Debug, Clone, Eq, PartialEq, ScryptoSbor)]
        pub VersionedSubstateNodeAncestryRecord(SubstateNodeAncestryRecordVersions) => SubstateNodeAncestryRecord = SubstateNodeAncestryRecordV1,
        outer_attributes: [
            #[derive(ScryptoSborAssertion)]
            #[sbor_assert(backwards_compatible(
                cuttlefish = "FILE:CF_SCHEMA_versioned_substate_node_ancestry_record_cuttlefish.bin"
            ))]
        ]
    }

    /// Ancestry information of a RE Node.
    #[derive(Debug, Clone, Eq, PartialEq, ScryptoSbor)]
    pub struct SubstateNodeAncestryRecordV1 {
        /// A substate owning the Node (i.e. its immediate parent).
        /// Note: this will always be present, since we do not need ancestry of root RE Nodes.
        pub parent: SubstateReference,
        /// A root ancestor of the Node's tree (i.e. the top of its parent chain).
        /// Note: the returned reference is guaranteed to resolve to a [`GlobalAddress`].
        pub root: SubstateReference,
    }

    /// A [`SubstateNodeAncestryRecord`] accompanied by a set of sibling [`NodeId`]s (which of
    /// course share the same parent).
    pub type KeyedSubstateNodeAncestryRecord = (Vec<NodeId>, SubstateNodeAncestryRecord);

    /// A store of historical substate values associated with state hash tree's leaves.
    /// See [`WriteableTreeStore::associate_substate_value()`].
    ///
    /// Note: this is *not* a "historical values" store, but only its lower-level source of values.
    pub trait LeafSubstateValueStore {
        /// Returns a value associated with the given leaf, or [`None`] if the leaf does not exist
        /// or the historical state feature was not enabled during creation of the leaf.
        fn get_associated_value(&self, global_key: &StoredTreeNodeKey) -> Option<DbSubstateValue>;
    }
}

pub mod transactions {
    use super::*;

    pub trait IterableTransactionStore {
        fn get_committed_transaction_bundle_iter(
            &self,
            from_state_version: StateVersion,
        ) -> Box<dyn Iterator<Item = CommittedTransactionBundle> + '_>;
    }

    pub trait QueryableTransactionStore {
        fn get_committed_transaction(
            &self,
            state_version: StateVersion,
        ) -> Option<RawLedgerTransaction>;

        fn get_committed_transaction_identifiers(
            &self,
            state_version: StateVersion,
        ) -> Option<CommittedTransactionIdentifiers>;

        fn get_committed_ledger_transaction_receipt(
            &self,
            state_version: StateVersion,
        ) -> Option<LedgerTransactionReceipt>;

        fn get_committed_local_transaction_execution(
            &self,
            state_version: StateVersion,
        ) -> Option<LocalTransactionExecution>;

        fn get_committed_local_transaction_receipt(
            &self,
            state_version: StateVersion,
        ) -> Option<LocalTransactionReceipt>;

        fn get_committed_ledger_hashes(&self, state_version: StateVersion) -> Option<LedgerHashes> {
            self.get_committed_transaction_identifiers(state_version)
                .map(|ids| ids.resultant_ledger_hashes)
        }
    }

    pub trait TransactionIndex<T>: QueryableTransactionStore {
        fn get_txn_state_version_by_identifier(&self, identifier: T) -> Option<StateVersion>;
    }
}

pub mod proofs {

    use super::*;

    pub trait IterableProofStore {
        fn get_proof_iter(
            &self,
            from_state_version: StateVersion,
        ) -> Box<dyn Iterator<Item = LedgerProof> + '_>;

        fn get_next_epoch_proof_iter(
            &self,
            from_epoch: Epoch,
        ) -> Box<dyn Iterator<Item = LedgerProof> + '_>;

        fn get_protocol_update_init_proof_iter(
            &self,
            from_state_version: StateVersion,
        ) -> Box<dyn Iterator<Item = LedgerProof> + '_>;

        fn get_protocol_update_execution_proof_iter(
            &self,
            from_state_version: StateVersion,
        ) -> Box<dyn Iterator<Item = LedgerProof> + '_>;
    }

    pub trait QueryableProofStore {
        fn max_state_version(&self) -> StateVersion;
        fn max_completed_epoch(&self) -> Option<Epoch> {
            self.get_latest_epoch_proof()
                .map(|proof| proof.ledger_header.epoch)
        }
        fn get_syncable_txns_and_proof(
            &self,
            start_state_version_inclusive: StateVersion,
            max_number_of_txns_if_more_than_one_proof: u32,
            max_payload_size_in_bytes: u32,
        ) -> Result<TxnsAndProof, GetSyncableTxnsAndProofError>;
        fn get_first_proof(&self) -> Option<LedgerProof>;
        fn get_proof(&self, state_version: StateVersion) -> Option<LedgerProof>;
        fn get_post_genesis_epoch_proof(&self) -> Option<LedgerProof>;
        fn get_epoch_proof(&self, epoch: Epoch) -> Option<LedgerProof>;
        fn get_latest_proof(&self) -> Option<LedgerProof>;
        fn get_latest_epoch_proof(&self) -> Option<LedgerProof>;
        fn get_closest_epoch_proof_on_or_before(
            &self,
            state_version: StateVersion,
        ) -> Option<LedgerProof>;
        fn get_latest_protocol_update_init_proof(&self) -> Option<LedgerProof>;
        fn get_latest_protocol_update_execution_proof(&self) -> Option<LedgerProof>;
    }

    #[derive(Clone, Debug, ScryptoSbor)]
    pub struct TxnsAndProof {
        pub txns: Vec<RawLedgerTransaction>,
        pub proof: LedgerProof,
    }

    #[derive(Clone, Debug, ScryptoSbor)]
    pub enum GetSyncableTxnsAndProofError {
        RefusedToServeProtocolUpdate { refused_proof: Box<LedgerProof> },
        NothingToServeAtTheGivenStateVersion,
        FailedToPrepareAResponseWithinLimits,
    }
}

pub mod commit {
    use super::*;

    pub struct CommitBundle {
        pub transactions: Vec<CommittedTransactionBundle>,
        pub proof: LedgerProof,
        pub substate_store_update: SubstateStoreUpdate,
        pub vertex_store: Option<VertexStoreBlob>,
        pub state_tree_update: StateTreeUpdate,
        pub transaction_tree_slice: TransactionAccuTreeSlice,
        pub receipt_tree_slice: ReceiptAccuTreeSlice,
        pub new_substate_node_ancestry_records: Vec<KeyedSubstateNodeAncestryRecord>,
        pub new_leaf_substate_keys: Vec<LeafSubstateKeyAssociation>,
    }

    pub struct SubstateStoreUpdate {
        pub updates: DatabaseUpdates,
    }

    impl SubstateStoreUpdate {
        pub fn new() -> Self {
            Self {
                updates: DatabaseUpdates::default(),
            }
        }

        pub fn from_single(database_updates: DatabaseUpdates) -> Self {
            Self {
                updates: database_updates,
            }
        }

        pub fn apply(&mut self, database_updates: DatabaseUpdates) {
            if self.updates.node_updates.is_empty() {
                self.updates = database_updates;
                return;
            }
            for (node_key, node_updates) in database_updates.node_updates {
                Self::merge_in_node_updates(
                    self.updates.node_updates.entry(node_key).or_default(),
                    node_updates,
                );
            }
        }

        pub fn get_upserted_value(&self, key: &DbSubstateKey) -> Option<&DbSubstateValue> {
            let (
                DbPartitionKey {
                    node_key,
                    partition_num,
                },
                sort_key,
            ) = key;
            self.updates
                .node_updates
                .get(node_key)
                .and_then(|node_update| node_update.partition_updates.get(partition_num))
                .and_then(|partition_update| match partition_update {
                    PartitionDatabaseUpdates::Delta { substate_updates } => substate_updates
                        .get(sort_key)
                        .and_then(|update| match update {
                            DatabaseUpdate::Set(value) => Some(value),
                            DatabaseUpdate::Delete => None,
                        }),
                    PartitionDatabaseUpdates::Reset {
                        new_substate_values,
                    } => new_substate_values.get(sort_key),
                })
        }

        fn merge_in_node_updates(target: &mut NodeDatabaseUpdates, source: NodeDatabaseUpdates) {
            for (partition_num, partition_updates) in source.partition_updates {
                Self::merge_in_partition_updates(
                    target.partition_updates.entry(partition_num).or_default(),
                    partition_updates,
                );
            }
        }

        fn merge_in_partition_updates(
            target: &mut PartitionDatabaseUpdates,
            source: PartitionDatabaseUpdates,
        ) {
            match source {
                PartitionDatabaseUpdates::Delta {
                    substate_updates: source_updates,
                } => match target {
                    PartitionDatabaseUpdates::Delta {
                        substate_updates: target_updates,
                    } => {
                        target_updates.extend(source_updates);
                    }
                    PartitionDatabaseUpdates::Reset {
                        new_substate_values: target_values,
                    } => {
                        for (sort_key, update) in source_updates {
                            match update {
                                DatabaseUpdate::Set(value) => {
                                    target_values.insert(sort_key, value);
                                }
                                DatabaseUpdate::Delete => {
                                    let existed = target_values.swap_remove(&sort_key).is_some();
                                    if !existed {
                                        panic!("broken invariant: deleting non-existent substate");
                                    }
                                }
                            }
                        }
                    }
                },
                PartitionDatabaseUpdates::Reset { .. } => {
                    *target = source;
                }
            }
        }
    }

    impl Default for SubstateStoreUpdate {
        fn default() -> Self {
            Self::new()
        }
    }

    define_single_versioned! {
        #[derive(Debug, Clone, ScryptoSbor)]
        pub VersionedStaleTreeParts(StaleTreePartsVersions) => StaleTreeParts = StaleTreePartsV1,
        outer_attributes: [
            #[derive(ScryptoSborAssertion)]
            #[sbor_assert(backwards_compatible(
                cuttlefish = "FILE:CF_SCHEMA_versioned_stale_tree_parts_cuttlefish.bin"
            ))]
        ]
    }

    #[derive(Debug, Clone, ScryptoSbor)]
    pub struct StaleTreePartsV1(pub Vec<StaleTreePart>);

    pub struct StateTreeUpdate {
        pub new_nodes: Vec<(StoredTreeNodeKey, TreeNode)>,
        pub stale_tree_parts_at_state_version: Vec<(StateVersion, StaleTreeParts)>,
    }

    impl StateTreeUpdate {
        pub fn new() -> Self {
            Self {
                new_nodes: Vec::new(),
                stale_tree_parts_at_state_version: Vec::new(),
            }
        }

        pub fn from_single(at_state_version: StateVersion, diff: StateTreeDiff) -> Self {
            Self {
                new_nodes: diff.new_nodes,
                stale_tree_parts_at_state_version: vec![(
                    at_state_version,
                    StaleTreePartsV1(diff.stale_tree_parts),
                )],
            }
        }

        pub fn add(&mut self, at_state_version: StateVersion, diff: StateTreeDiff) {
            self.new_nodes.extend(diff.new_nodes);
            self.stale_tree_parts_at_state_version
                .push((at_state_version, StaleTreePartsV1(diff.stale_tree_parts)));
        }
    }

    impl Default for StateTreeUpdate {
        fn default() -> Self {
            Self::new()
        }
    }

    define_single_versioned! {
        #[derive(Debug, Clone, ScryptoSbor)]
        pub VersionedTransactionAccuTreeSlice(TransactionAccuTreeSliceVersions) => TransactionAccuTreeSlice = TransactionAccuTreeSliceV1,
        outer_attributes: [
            #[derive(ScryptoSborAssertion)]
            #[sbor_assert(backwards_compatible(
                cuttlefish = "FILE:CF_SCHEMA_versioned_transaction_accu_tree_slice_cuttlefish.bin"
            ))]
        ]
    }

    #[derive(Debug, Clone, ScryptoSbor)]
    pub struct TransactionAccuTreeSliceV1(pub TreeSlice<TransactionTreeHash>);

    define_single_versioned! {
        #[derive(Debug, Clone, ScryptoSbor)]
        pub VersionedReceiptAccuTreeSlice(ReceiptAccuTreeSliceVersions) => ReceiptAccuTreeSlice = ReceiptAccuTreeSliceV1,
        outer_attributes: [
            #[derive(ScryptoSborAssertion)]
            #[sbor_assert(backwards_compatible(
                cuttlefish = "FILE:CF_SCHEMA_versioned_receipt_accu_tree_slice_cuttlefish.bin"
            ))]
        ]
    }

    #[derive(Debug, Clone, ScryptoSbor)]
    pub struct ReceiptAccuTreeSliceV1(pub TreeSlice<ReceiptTreeHash>);

    pub trait CommitStore {
        fn commit(&self, commit_bundle: CommitBundle);
    }
}

pub mod scenario {
    use super::*;

    pub type ScenarioSequenceNumber = u32;

    define_single_versioned! {
        #[derive(Debug, Clone, Sbor)]
        pub VersionedExecutedScenario(ExecutedScenarioVersions) => ExecutedScenario = ExecutedScenarioV1,
        outer_attributes: [
            #[derive(ScryptoSborAssertion)]
            #[sbor_assert(backwards_compatible(
                cuttlefish = "FILE:CF_SCHEMA_versioned_executed_scenario_cuttlefish.bin"
            ))]
        ]
    }

    #[derive(Debug, Clone, Sbor)]
    pub struct ExecutedScenarioV1 {
        pub logical_name: String,
        pub committed_transactions: Vec<ExecutedScenarioTransaction>,
        pub addresses: Vec<DescribedAddressRendering>,
    }

    #[derive(Debug, Clone, Sbor)]
    pub struct DescribedAddressRendering {
        pub logical_name: String,
        pub rendered_address: String, // we store it pre-rendered, since `GlobalAddress` has no SBOR coding
    }

    #[derive(Debug, Clone, Sbor)]
    pub struct ExecutedScenarioTransaction {
        pub logical_name: String,
        pub state_version: StateVersion,
        pub transaction_intent_hash: TransactionIntentHash,
    }

    /// A store of testing-specific [`ExecutedScenario`], meant to be as separated as possible from
    /// the production stores (e.g. the writes happening outside of the regular commit batch write).
    pub trait ExecutedScenarioStore {
        /// Writes the given Scenario under the next sequence number (auto-incremented).
        fn put_next_scenario(&self, scenario: ExecutedScenario);

        /// Returns all Scenarios written so far, ordered by their sequence numbers.
        /// Performance note: this method assumes a small number of Scenarios.
        fn list_all_scenarios(&self) -> Vec<(ScenarioSequenceNumber, ExecutedScenario)>;
    }
}

pub mod extensions {
    use super::*;

    pub trait AccountChangeIndexExtension {
        fn account_change_index_last_processed_state_version(&self) -> StateVersion;

        fn catchup_account_change_index(&self);
    }

    pub trait RestoreDecember2023LostSubstates {
        fn restore_december_2023_lost_substates(&self, network: &NetworkDefinition);
    }

    pub trait IterableAccountChangeIndex {
        fn get_state_versions_for_account_iter(
            &self,
            account: GlobalAddress,
            from_state_version: StateVersion,
        ) -> Box<dyn Iterator<Item = StateVersion> + '_>;
    }

    define_single_versioned! {
        #[derive(Debug, Clone, Sbor)]
        pub VersionedStateTreeAssociatedValuesStatus(StateTreeAssociatedValuesStatusVersions) => StateTreeAssociatedValuesStatus = StateTreeAssociatedValuesStatusV1
    }

    #[derive(Debug, Clone, Sbor)]
    pub struct StateTreeAssociatedValuesStatusV1 {
        /// The (inclusive) [`StateVersion`] from which the past Substate values are currently
        /// present in the dedicated "historical" table.
        ///
        /// This value is initialized after the "state history" feature gets enabled (and finishes
        /// its successful backfill). Then, every subsequent "state tree GC" run progresses it
        /// forward appropriately.
        pub historical_substate_values_available_from: StateVersion,
    }
}

pub mod indices {
    use super::*;
    use std::ops::Range;

    pub trait EntityListingIndex {
        fn get_created_entity_iter(
            &self,
            entity_type: EntityType,
            from_creation_id: Option<&CreationId>,
        ) -> Box<dyn Iterator<Item = (CreationId, EntityBlueprintId)> + '_>;

        fn get_blueprint_entity_iter(
            &self,
            blueprint_id: &BlueprintId,
            from_creation_id: Option<&CreationId>,
        ) -> Box<dyn Iterator<Item = (CreationId, EntityBlueprintId)> + '_>;
    }

    /// A unique ID of an Entity, based on creation order.
    #[derive(Debug, Clone, PartialEq, Eq, PartialOrd, Ord, Sbor)]
    pub struct CreationId {
        /// State version of the transaction which created the Entity (i.e. which created the first
        /// Substate under this Entity).
        pub state_version: StateVersion,

        /// An index in a list of Entities created by a single transaction.
        pub index_within_txn: u32,
    }

    impl CreationId {
        /// Creates the least possible instance.
        pub fn zero() -> Self {
            Self {
                state_version: StateVersion::pre_genesis(),
                index_within_txn: 0,
            }
        }

        /// Creates an ID, ensuring that the given index fits within `u32`.
        pub fn new(state_version: StateVersion, index_within_txn: usize) -> Self {
            Self {
                state_version,
                index_within_txn: index_within_txn.try_into().expect("unexpected index"),
            }
        }

        /// Returns a [`Range`] guaranteed to cover all practically-occurring [`CreationId`]s.
        pub fn full_range() -> Range<Self> {
            // we need an exclusive upper bound, so:
            let above_max = CreationId {
                state_version: StateVersion::of(u64::MAX), // even if version that large is possible...
                index_within_txn: u32::MAX, // ... then there is a limit on maximum entities created by a transaction
            };
            Self::zero()..above_max
        }
    }

    define_single_versioned! {
        #[derive(Debug, Clone, ScryptoSbor)]
        pub VersionedEntityBlueprintId(EntityBlueprintIdVersions) => EntityBlueprintId = EntityBlueprintIdV1,
        outer_attributes: [
            #[derive(ScryptoSborAssertion)]
            #[sbor_assert(backwards_compatible(
                cuttlefish = "FILE:CF_SCHEMA_versioned_entity_blueprint_id_cuttlefish.bin"
            ))]
        ]
    }

    /// An entity's ID and its blueprint reference.
    /// This is a "technical" structure stored in one of the Entity-listing indices.
    #[derive(Debug, Clone, ScryptoSbor)]
    pub struct EntityBlueprintIdV1 {
        /// Node ID.
        pub node_id: NodeId,

        /// Blueprint reference, present only for "Object" entities.
        pub blueprint_id: Option<BlueprintId>,
    }

    impl EntityBlueprintIdV1 {
        /// Creates an instance representing an entity of "Object" type.
        pub fn of_object(object_node_id: NodeId, blueprint_id: BlueprintId) -> Self {
            Self {
                node_id: object_node_id,
                blueprint_id: Some(blueprint_id),
            }
        }

        /// Creates an instance representing an entity of "Key-Value Store" type.
        pub fn of_kv_store(kv_store_node_id: NodeId) -> Self {
            Self {
                node_id: kv_store_node_id,
                blueprint_id: None,
            }
        }
    }

    define_single_versioned! {
        #[derive(Debug, Clone, ScryptoSbor)]
        pub VersionedObjectBlueprintName(ObjectBlueprintNameVersions) => ObjectBlueprintName = ObjectBlueprintNameV1,
        outer_attributes: [
            #[derive(ScryptoSborAssertion)]
            #[sbor_assert(backwards_compatible(
                cuttlefish = "FILE:CF_SCHEMA_versioned_object_blueprint_name_cuttlefish.bin"
            ))]
        ]
    }

    /// An Object's ID and its blueprint name.
    /// This is a "technical" structure stored in one of the Entity-listing indices.
    #[derive(Debug, Clone, ScryptoSbor)]
    pub struct ObjectBlueprintNameV1 {
        /// Node ID - guaranteed to *not* be a Key-Value Store.
        pub node_id: NodeId,

        /// The name alone of the Object's blueprint.
        /// Package address is not needed here, since it is stored on the key's side of the index.
        pub blueprint_name: String,
    }
}

pub mod measurement {

    use std::cmp::max;

    /// A database capable of returning some metrics describing itself.
    pub trait MeasurableDatabase {
        /// Gets approximate data volume statistics per table/map/cf (i.e. a category of persisted
        /// items, however it is called by the specific database implementation).
        fn get_data_volume_statistics(&self) -> Vec<CategoryDbVolumeStatistic>;

        /// Gets a number of entries stored in the given category.
        ///
        /// Note: this is an extremely inefficient method, meant only for test purposes.
        fn count_entries(&self, category_name: &str) -> usize;
    }

    /// An approximate data volume statistic of a given category of persisted items.
    pub struct CategoryDbVolumeStatistic {
        /// Name of the table/map/cf.
        pub category_name: String,
        /// A sum of live entries across SSTs (not accounting for their compaction).
        pub live_count: u64,
        /// A sum of tombstone entries across SSTs (not accounting for their compaction).
        pub tombstone_count: u64,
        /// An estimate of the persisted total size of this category, in bytes.
        /// This should be measured after applying any database overheads (e.g. uncompacted levels)
        /// and/or optimizations (e.g. compression).
        pub size_bytes: usize,
        /// A number of SSTs used for the category.
        pub sst_count: usize,
        /// A maximum SST level.
        pub max_level: i32,
    }

    impl CategoryDbVolumeStatistic {
        /// Creates a zero statistic of the given category of items.
        pub fn zero(category_name: String) -> Self {
            Self {
                category_name,
                live_count: 0,
                tombstone_count: 0,
                size_bytes: 0,
                sst_count: 0,
                max_level: 0,
            }
        }

        /// Accumulates the given SST summary into this instance.
        /// This leaks the detail about our Level-like DB usage.
        pub fn add_sst_summary(
            &mut self,
            live_count: u64,
            tombstone_count: u64,
            size_bytes: usize,
            level: i32,
        ) {
            self.live_count += live_count;
            self.tombstone_count += tombstone_count;
            self.size_bytes += size_bytes;
            self.sst_count += 1;
            self.max_level = max(self.max_level, level);
        }
    }
}

pub mod gc {
    use super::*;

    /// A storage API tailored for the [`StateTreeGc`].
    pub trait StateTreeGcStore {
        /// Returns an iterator of stale hash tree parts, ordered by the state version at which
        /// they became stale, ascending.
        fn get_stale_tree_parts_iter(
            &self,
        ) -> Box<dyn Iterator<Item = (StateVersion, StaleTreeParts)> + '_>;

        /// Updates the metadata of the state history feature - but only if the given `available_from`
        /// version is actually greater than the currently stored one.
        fn progress_historical_substate_values_availability(&self, available_from: StateVersion);

        /// Deletes a batch of state hash tree nodes.
        fn batch_delete_node<'a>(&self, keys: impl IntoIterator<Item = &'a StoredTreeNodeKey>);

        /// Deletes all stale hash tree parts' records up to the given state version, *exclusive*.
        fn delete_stale_tree_parts_up_to_version(&self, state_version: StateVersion);
    }

    /// A storage API tailored for the [`LedgerProofsGc`].
    pub trait LedgerProofsGcStore {
        /// Returns the current state of the GC's progress.
        fn get_progress(&self) -> Option<LedgerProofsGcProgress>;

        /// Updates the progress.
        fn set_progress(&self, progress: LedgerProofsGcProgress);

        /// Deletes the given range (from inclusive, to exclusive) of ledger proofs.
        fn delete_ledger_proofs_range(&self, from: StateVersion, to: StateVersion);
    }

    define_single_versioned! {
        #[derive(Debug, Clone, ScryptoSbor)]
        pub VersionedLedgerProofsGcProgress(LedgerProofsGcProgressVersions) => LedgerProofsGcProgress = LedgerProofsGcProgressV1,
        outer_attributes: [
            #[derive(ScryptoSborAssertion)]
            #[sbor_assert(backwards_compatible(
                cuttlefish = "FILE:CF_SCHEMA_versioned_ledger_proofs_gc_progress_cuttlefish.bin"
            ))]
        ]
    }

    /// A state of the GC's progress.
    #[derive(Debug, Clone, ScryptoSbor)]
    pub struct LedgerProofsGcProgressV1 {
        /// The last epoch pruned by the GC. The next run should start from the beginning of the
        /// next epoch.
        pub last_pruned_epoch: Epoch,

        /// The state version at which the epoch proof of the [`last_pruned_epoch`] was persisted.
        /// This field simply holds a cached value (which could be read from the DB based on the
        /// epoch).
        pub epoch_proof_state_version: StateVersion,
    }

    impl LedgerProofsGcProgressV1 {
        /// Initializes the very first progress, which skips over the genesis.
        pub fn new(post_genesis_ledger_header: LedgerHeader) -> Self {
            Self {
                last_pruned_epoch: post_genesis_ledger_header.epoch,
                epoch_proof_state_version: post_genesis_ledger_header.state_version,
            }
        }
    }
}

pub struct TransactionAndProofIterator<'a> {
    committed_transaction_bundle:
        Peekable<Box<dyn Iterator<Item = CommittedTransactionBundle> + 'a>>,
    ledger_proof: Peekable<Box<dyn Iterator<Item = LedgerProof> + 'a>>,
}

impl<'a> TransactionAndProofIterator<'a> {
    pub fn new(
        committed_transaction_bundle: Box<dyn Iterator<Item = CommittedTransactionBundle> + 'a>,
        ledger_proof: Box<dyn Iterator<Item = LedgerProof> + 'a>,
    ) -> Self {
        Self {
            committed_transaction_bundle: committed_transaction_bundle.peekable(),
            ledger_proof: ledger_proof.peekable(),
        }
    }
}

impl<'a> Iterator for TransactionAndProofIterator<'a> {
    type Item = (CommittedTransactionBundle, Option<LedgerProof>);

    fn next(&mut self) -> Option<Self::Item> {
        match (
            self.committed_transaction_bundle.peek(),
            self.ledger_proof.peek(),
        ) {
            (Some(transaction), Some(proof)) => {
                match proof
                    .ledger_header
                    .state_version
                    .cmp(&transaction.state_version)
                {
                    Ordering::Greater => {
                        Some((self.committed_transaction_bundle.next().unwrap(), None))
                    }
                    _ => Some((
                        self.committed_transaction_bundle.next().unwrap(),
                        Some(self.ledger_proof.next().unwrap()),
                    )),
                }
            }
            (None, Some(_)) => {
                panic!("Invalid state: proof without transaction");
            }
            (Some(_), None) => Some((self.committed_transaction_bundle.next().unwrap(), None)),
            (None, None) => None,
        }
    }
}

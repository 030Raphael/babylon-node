use crate::engine_prelude::*;
use node_common::locks::{DbLock, RwLock};
use std::ops::{Deref, Range};
use std::sync::Arc;

use crate::query::StateManagerSubstateQueries;

use crate::store::traits::QueryableProofStore;
use crate::transaction::*;
use crate::{
    ActualStateManagerDatabase, GlobalBalanceSummary, LedgerHeader, LedgerStateChanges,
    PreviewRequest, ProcessedCommitResult,
};

/// A transaction preview runner.
pub struct TransactionPreviewer {
    database: Arc<DbLock<ActualStateManagerDatabase>>,
    execution_configurator: Arc<RwLock<ExecutionConfigurator>>,
    validation_config: ValidationConfig,
}

pub struct ProcessedPreviewResult {
    pub base_ledger_header: LedgerHeader,
    pub receipt: TransactionReceipt,
    pub state_changes: LedgerStateChanges,
    pub global_balance_summary: GlobalBalanceSummary,
}

impl TransactionPreviewer {
    pub fn new(
        database: Arc<DbLock<ActualStateManagerDatabase>>,
        execution_configurator: Arc<RwLock<ExecutionConfigurator>>,
        validation_config: ValidationConfig,
    ) -> Self {
        Self {
            database,
            execution_configurator,
            validation_config,
        }
    }
}

impl TransactionPreviewer {
    /// Executes the transaction compiled from the given request in a preview mode.
    pub fn preview(
        &self,
        preview_request: PreviewRequest,
    ) -> Result<ProcessedPreviewResult, PreviewError> {
        let database = self.database.snapshot();
        let intent = self.create_intent(preview_request, database.deref());

        let validator = NotarizedTransactionValidator::new(self.validation_config);
        let validated = validator
            .validate_preview_intent_v1(intent)
            .map_err(PreviewError::TransactionValidationError)?;
        let read_execution_configurator = self.execution_configurator.read();
        let transaction_logic = read_execution_configurator.wrap_preview_transaction(&validated);

        let receipt = transaction_logic.execute_on(database.deref());
        let (state_changes, global_balance_summary) = match &receipt.result {
            TransactionResult::Commit(commit) => {
                let state_changes = ProcessedCommitResult::compute_ledger_state_changes::<
                    _,
                    SpreadPrefixKeyMapper,
                >(database.deref(), &commit.state_updates);
                let global_balance_update = ProcessedCommitResult::compute_global_balance_update(
                    database.deref(),
                    &state_changes,
                    &commit.state_update_summary.vault_balance_changes,
                );
                (state_changes, global_balance_update.global_balance_summary)
            }
            _ => (
                LedgerStateChanges::default(),
                GlobalBalanceSummary::default(),
            ),
        };

        let base_ledger_header = database
            .get_latest_proof()
            .expect("proof for preview's base state")
            .ledger_header;

        Ok(ProcessedPreviewResult {
            base_ledger_header,
            receipt,
            state_changes,
            global_balance_summary,
        })
    }

    fn create_intent<S: StateManagerSubstateQueries>(
        &self,
        preview_request: PreviewRequest,
        store: &S,
    ) -> PreviewIntentV1 {
        let notary = preview_request.notary_public_key.unwrap_or_else(|| {
            PublicKey::Secp256k1(Secp256k1PrivateKey::from_u64(2).unwrap().public_key())
        });
        let effective_epoch_range = preview_request.explicit_epoch_range.unwrap_or_else(|| {
            let current_epoch = store.get_epoch();
            Range {
                start: current_epoch,
                end: current_epoch
                    .after(self.validation_config.max_epoch_range)
                    .expect("currently calculated max end epoch is outside of valid range"),
            }
        });
        let (instructions, blobs) = preview_request.manifest.for_intent();
        PreviewIntentV1 {
            intent: IntentV1 {
                header: TransactionHeaderV1 {
                    network_id: self.validation_config.network_id,
                    start_epoch_inclusive: effective_epoch_range.start,
                    end_epoch_exclusive: effective_epoch_range.end,
                    nonce: preview_request.nonce,
                    notary_public_key: notary,
                    notary_is_signatory: preview_request.notary_is_signatory,
                    tip_percentage: preview_request.tip_percentage,
                },
                instructions,
                blobs,
                message: preview_request.message,
            },
            signer_public_keys: preview_request.signer_public_keys,
            flags: preview_request.flags,
        }
    }
}

#[cfg(test)]
mod tests {

    use crate::engine_prelude::*;
    use crate::{PreviewRequest, StateManager, StateManagerConfig};
    use node_common::locks::LockFactory;
    use node_common::scheduler::Scheduler;
    use prometheus::Registry;

    #[test]
    fn test_preview_processed_substate_changes() {
        let tmp = tempfile::tempdir().unwrap();
        let lock_factory = LockFactory::new("testing");
        let metrics_registry = Registry::new();
        let state_manager = StateManager::new(
            StateManagerConfig::new_for_testing(tmp.path().to_str().unwrap()),
            None,
            &lock_factory,
            &metrics_registry,
            &Scheduler::new("testing"),
        );

        state_manager
            .state_computer
            .execute_genesis_for_unit_tests_with_default_config();

        let preview_manifest = ManifestBuilder::new().lock_fee_from_faucet().build();

        let preview_response = state_manager
            .transaction_previewer
            .read()
            .preview(PreviewRequest {
                manifest: preview_manifest,
                explicit_epoch_range: None,
                notary_public_key: None,
                notary_is_signatory: true,
                tip_percentage: 0,
                nonce: 0,
                signer_public_keys: vec![],
                flags: PreviewFlags {
                    use_free_credit: true,
                    assume_all_signature_proofs: true,
                    skip_epoch_check: false,
                },
                message: MessageV1::None,
            });

        // just checking that we're getting some processed substate changes back in the response
        assert!(!preview_response.unwrap().state_changes.is_empty());
    }
}

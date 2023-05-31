use crate::core_api::*;

use radix_engine::types::hash;

use state_manager::store::traits::*;
use state_manager::transaction::{LedgerTransaction, ValidatorTransaction};
use state_manager::{
    CommittedTransactionIdentifiers, IntentHash, LocalTransactionReceipt, SignaturesHash,
    UserPayloadHash,
};

use radix_engine_interface::blueprints::epoch_manager::ValidatorIndex;
use radix_engine_interface::data::manifest::manifest_encode;
use std::collections::HashMap;
use transaction::manifest;
use transaction::model::{
    NotarizedTransaction, SignedTransactionIntent, SystemTransaction, TransactionIntent,
    TransactionManifest,
};

#[tracing::instrument(skip(state))]
pub(crate) async fn handle_stream_transactions(
    state: State<CoreApiState>,
    Json(request): Json<models::StreamTransactionsRequest>,
) -> Result<Json<models::StreamTransactionsResponse>, ResponseError<()>> {
    assert_matching_network(&request.network, &state.network)?;
    let mapping_context = MappingContext::new(&state.network)
        .with_sbor_formats(&request.sbor_format_options)
        .with_transaction_formats(&request.transaction_format_options)
        .with_substate_formats(&request.substate_format_options);

    let from_state_version: u64 = extract_api_state_version(request.from_state_version)
        .map_err(|err| err.into_response_error("from_state_version"))?;

    let limit: u64 = request
        .limit
        .try_into()
        .map_err(|_| client_error("limit cannot be negative"))?;

    if limit == 0 {
        return Err(client_error("limit must be positive"));
    }

    if limit > MAX_STREAM_COUNT_PER_REQUEST.into() {
        return Err(client_error(format!(
            "limit must <= {MAX_STREAM_COUNT_PER_REQUEST}"
        )));
    }

    let limit = limit.try_into().expect("limit out of usize bounds");

    let database = state.database.read();

    if !database.is_local_transaction_execution_index_enabled() {
        return Err(client_error(
            "This endpoint requires that the LocalTransactionExecutionIndex is enabled on the node. \
            To use this endpoint, you will need to enable the index in the config, wipe ledger and restart. \
            Please note the resync will take awhile.",
        ));
    }

    let max_state_version = database.max_state_version();

    let mut response = models::StreamTransactionsResponse {
        from_state_version: to_api_state_version(from_state_version)?,
        count: MAX_STREAM_COUNT_PER_REQUEST as i32, // placeholder to get a better size aproximation for the header
        max_ledger_state_version: to_api_state_version(max_state_version)?,
        transactions: Vec::new(),
    };

    // Reserve enough for the "header" fields
    let mut current_total_size = response.get_json_size();
    for (ledger_transaction, receipt, identifiers) in database
        .get_committed_transaction_bundle_iter(from_state_version)
        .take(limit)
    {
        let committed_transaction = to_api_committed_transaction(
            &mapping_context,
            ledger_transaction,
            receipt,
            identifiers,
        )?;

        let committed_transaction_size = committed_transaction.get_json_size();
        current_total_size += committed_transaction_size;

        response.transactions.push(committed_transaction);

        if current_total_size > CAP_STREAM_RESPONSE_WHEN_ABOVE_BYTES {
            break;
        }
    }

    let count: i32 = {
        let transaction_count = response.transactions.len();
        if transaction_count > MAX_STREAM_COUNT_PER_REQUEST.into() {
            return Err(server_error("Too many transactions were loaded somehow"));
        }
        transaction_count
            .try_into()
            .map_err(|_| server_error("Unexpected error mapping small usize to i32"))?
    };

    response.count = count;

    Ok(response).map(Json)
}

#[tracing::instrument(skip_all)]
pub fn to_api_committed_transaction(
    context: &MappingContext,
    ledger_transaction: LedgerTransaction,
    receipt: LocalTransactionReceipt,
    identifiers: CommittedTransactionIdentifiers,
) -> Result<models::CommittedTransaction, MappingError> {
    let receipt = to_api_receipt(context, receipt)?;

    Ok(models::CommittedTransaction {
        state_version: to_api_state_version(identifiers.state_version)?,
        accumulator_hash: to_api_accumulator_hash(&identifiers.accumulator_hash),
        ledger_transaction: Some(to_api_ledger_transaction(context, &ledger_transaction)?),
        receipt: Box::new(receipt),
    })
}

#[tracing::instrument(skip_all)]
pub fn to_api_ledger_transaction(
    context: &MappingContext,
    ledger_transaction: &LedgerTransaction,
) -> Result<models::LedgerTransaction, MappingError> {
    let payload_hex = if context.transaction_options.include_raw_ledger {
        Some(to_hex(ledger_transaction.create_payload().map_err(
            |err| MappingError::SborEncodeError {
                encode_error: err,
                message: "Error encoding ledger payload sbor".to_string(),
            },
        )?))
    } else {
        None
    };

    Ok(match ledger_transaction {
        LedgerTransaction::UserV1(tx) => models::LedgerTransaction::UserLedgerTransaction {
            payload_hex,
            notarized_transaction: Box::new(to_api_notarized_transaction(context, tx)?),
        },
        LedgerTransaction::RoundUpdateV1(tx) => {
            models::LedgerTransaction::ValidatorLedgerTransaction {
                payload_hex,
                validator_transaction: Box::new(to_api_validator_transaction(context, tx)?),
            }
        }
        LedgerTransaction::Genesis(tx) => models::LedgerTransaction::SystemLedgerTransaction {
            payload_hex,
            system_transaction: Box::new(to_api_system_transaction(context, tx)?),
        },
    })
}

#[tracing::instrument(skip_all)]
pub fn to_api_notarized_transaction(
    context: &MappingContext,
    tx: &NotarizedTransaction,
) -> Result<models::NotarizedTransaction, MappingError> {
    let payload_hex = if context.transaction_options.include_raw_notarized {
        Some(to_hex(tx.to_bytes().map_err(|err| {
            MappingError::SborEncodeError {
                encode_error: err,
                message: "Error encoding user payload sbor".to_string(),
            }
        })?))
    } else {
        None
    };
    let payload_hash = UserPayloadHash::for_transaction(tx);

    Ok(models::NotarizedTransaction {
        hash: to_api_notarized_transaction_hash(&payload_hash),
        payload_hex,
        signed_intent: Box::new(to_api_signed_intent(context, &tx.signed_intent)?),
        notary_signature: Some(to_api_signature(&tx.notary_signature)),
    })
}

#[tracing::instrument(skip_all)]
pub fn to_api_signed_intent(
    context: &MappingContext,
    signed_intent: &SignedTransactionIntent,
) -> Result<models::SignedTransactionIntent, MappingError> {
    let signed_intent_hash = SignaturesHash::for_signed_intent(signed_intent);

    Ok(models::SignedTransactionIntent {
        hash: to_api_signed_intent_hash(&signed_intent_hash),
        intent: Box::new(to_api_intent(context, &signed_intent.intent)?),
        intent_signatures: signed_intent
            .intent_signatures
            .iter()
            .map(to_api_signature_with_public_key)
            .collect(),
    })
}

#[tracing::instrument(skip_all)]
pub fn to_api_intent(
    context: &MappingContext,
    intent: &TransactionIntent,
) -> Result<models::TransactionIntent, MappingError> {
    let intent_hash = IntentHash::for_intent(intent);
    let header = &intent.header;

    Ok(models::TransactionIntent {
        hash: to_api_intent_hash(&intent_hash),
        header: Box::new(models::TransactionHeader {
            version: header.version.into(),
            network_id: header.network_id.into(),
            start_epoch_inclusive: to_api_epoch(context, header.start_epoch_inclusive)?,
            end_epoch_exclusive: to_api_epoch(context, header.end_epoch_exclusive)?,
            nonce: to_api_u64_as_string(header.nonce),
            notary_public_key: Some(to_api_public_key(&header.notary_public_key)),
            notary_as_signatory: header.notary_as_signatory,
            cost_unit_limit: to_api_u32_as_i64(header.cost_unit_limit),
            tip_percentage: to_api_u16_as_i32(header.tip_percentage),
        }),
        manifest: Box::new(to_api_manifest(context, &intent.manifest)?),
    })
}

#[tracing::instrument(skip_all)]
pub fn to_api_manifest(
    context: &MappingContext,
    manifest: &TransactionManifest,
) -> Result<models::TransactionManifest, MappingError> {
    let instructions = if context.transaction_options.include_manifest {
        Some(
            manifest::decompile(&manifest.instructions, &context.network_definition).map_err(
                |err| MappingError::InvalidManifest {
                    message: format!(
                        "Failed to decompile a transaction manifest: {err:?}, instructions: {:?}",
                        &manifest.instructions
                    ),
                },
            )?,
        )
    } else {
        None
    };

    let blobs_hex = if context.transaction_options.include_blobs {
        Some(
            manifest
                .blobs
                .iter()
                .map(|blob| (to_hex(hash(blob)), to_hex(blob)))
                .collect::<HashMap<String, String>>(),
        )
    } else {
        None
    };

    Ok(models::TransactionManifest {
        instructions,
        blobs_hex,
    })
}

pub fn to_api_validator_transaction(
    context: &MappingContext,
    validator_transaction: &ValidatorTransaction,
) -> Result<models::ValidatorTransaction, MappingError> {
    Ok(match validator_transaction {
        ValidatorTransaction::RoundUpdateV1 {
            proposer_timestamp_ms,
            epoch,
            round,
            leader_proposal_history,
        } => models::ValidatorTransaction::RoundUpdateValidatorTransaction {
            proposer_timestamp: Box::new(to_api_instant_from_safe_timestamp(
                *proposer_timestamp_ms,
            )?),
            consensus_epoch: to_api_epoch(context, *epoch)?,
            round_in_epoch: to_api_round(*round)?,
            leader_proposal_history: Box::new(models::LeaderProposalHistory {
                gap_round_leaders: leader_proposal_history
                    .gap_round_leaders
                    .iter()
                    .map(|leader| to_api_active_validator_index(*leader))
                    .collect(),
                current_leader: Box::new(to_api_active_validator_index(
                    leader_proposal_history.current_leader,
                )),
                is_fallback: leader_proposal_history.is_fallback,
            }),
        },
    })
}

fn to_api_active_validator_index(index: ValidatorIndex) -> models::ActiveValidatorIndex {
    models::ActiveValidatorIndex {
        index: index as i32,
    }
}

pub fn to_api_system_transaction(
    context: &MappingContext,
    system_transaction: &SystemTransaction,
) -> Result<models::SystemTransaction, MappingError> {
    let payload_hex = if context.transaction_options.include_raw_system {
        Some(to_hex(manifest_encode(system_transaction).map_err(
            |err| MappingError::SborEncodeError {
                encode_error: err,
                message: "Error encoding system transaction sbor".to_string(),
            },
        )?))
    } else {
        None
    };
    Ok(models::SystemTransaction { payload_hex })
}

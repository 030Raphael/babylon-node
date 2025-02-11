use crate::prelude::*;

#[tracing::instrument(skip(state))]
pub(crate) async fn handle_transaction_status(
    state: State<CoreApiState>,
    Json(request): Json<models::TransactionStatusRequest>,
) -> Result<Json<models::TransactionStatusResponse>, ResponseError<()>> {
    assert_matching_network(&request.network, &state.network)?;

    let mapping_context = MappingContext::new_for_uncommitted_data(&state.network);
    let extraction_context = ExtractionContext::new(&state.network);

    let intent_hash = extract_transaction_intent_hash(&extraction_context, request.intent_hash)
        .map_err(|err| err.into_response_error("intent_hash"))?;

    let mut known_pending_payloads = state
        .state_manager
        .mempool_manager
        .all_known_pending_payloads_for_intent(&intent_hash);

    let database = state.state_manager.database.snapshot();

    if !database.is_local_transaction_execution_index_enabled() {
        return Err(client_error(
            "This endpoint requires that the LocalTransactionExecutionIndex is enabled on the node. \
            To use this endpoint, you will need to enable the index in the config, wipe ledger and restart. \
            Please note the resync will take a while.",
        ));
    }

    let txn_state_version_opt = database.get_txn_state_version_by_identifier(&intent_hash);
    let current_epoch = database.get_epoch_and_round().0;

    let invalid_from_epoch = known_pending_payloads
        .iter()
        .filter_map(|p| p.1.intent_invalid_from_epoch)
        .next();

    let intent_is_permanently_rejected = invalid_from_epoch.map_or(false, |invalid_from_epoch| {
        current_epoch >= invalid_from_epoch
    }) || known_pending_payloads.iter().any(|p| {
        p.1.earliest_permanent_rejection
            .as_ref()
            .map_or(false, |r| r.marks_permanent_rejection_for_intent())
    });

    if let Some(txn_state_version) = txn_state_version_opt {
        let hashes = database
            .get_committed_transaction_identifiers(txn_state_version)
            .expect("Txn identifiers are missing")
            .transaction_hashes;

        let local_detailed_outcome = database
            .get_committed_local_transaction_execution(txn_state_version)
            .expect("Txn local execution is missing")
            .outcome;
        drop(database);

        let user_hashes = hashes
            .as_user()
            .expect("Only user transactions should be able to be looked up by intent hash");
        let notarized_transaction_hash = user_hashes.notarized_transaction_hash;

        // Remove the committed payload from the rejection list if it's present
        known_pending_payloads.remove(&notarized_transaction_hash);

        let (intent_status, payload_status, outcome, error_message) = match local_detailed_outcome {
            DetailedTransactionOutcome::Success(_) => (
                models::TransactionIntentStatus::CommittedSuccess,
                models::TransactionPayloadStatus::CommittedSuccess,
                "SUCCESS",
                None,
            ),
            DetailedTransactionOutcome::Failure(error) => (
                models::TransactionIntentStatus::CommittedFailure,
                models::TransactionPayloadStatus::CommittedFailure,
                "FAILURE",
                Some(error.to_string(&mapping_context)),
            ),
        };

        let committed_payload = models::TransactionPayloadDetails {
            payload_hash: to_api_notarized_transaction_hash(
                &user_hashes.notarized_transaction_hash,
            ),
            payload_hash_bech32m: to_api_hash_bech32m(
                &mapping_context,
                &user_hashes.notarized_transaction_hash,
            )?,
            state_version: Some(to_api_state_version(txn_state_version)?),
            status: payload_status,
            error_message,
        };

        let mut known_payloads = vec![committed_payload];
        known_payloads.append(&mut map_rejected_payloads_due_to_known_commit(
            &mapping_context,
            known_pending_payloads,
            txn_state_version,
            &notarized_transaction_hash,
        )?);

        return Ok(Json(models::TransactionStatusResponse {
            intent_status,
            status_description: format!("The transaction has been committed to the ledger, with an outcome of {outcome}. For more information, use the /transaction/receipt endpoint."),
            invalid_from_epoch: None,
            known_payloads,
        }));
    }

    let mempool_payload_hashes = state
        .state_manager
        .mempool_manager
        .get_mempool_payload_hashes_for_intent(&intent_hash);

    if !mempool_payload_hashes.is_empty() {
        let mempool_payloads = mempool_payload_hashes
            .iter()
            .map(|payload_hash| {
                Ok(models::TransactionPayloadDetails {
                    payload_hash: to_api_notarized_transaction_hash(payload_hash),
                    payload_hash_bech32m: to_api_hash_bech32m(&mapping_context, payload_hash)?,
                    state_version: None,
                    status: models::TransactionPayloadStatus::InMempool,
                    error_message: None,
                })
            })
            .collect::<Result<Vec<_>, MappingError>>()?;

        let mempool_payloads_hashes: HashSet<_> = mempool_payload_hashes.into_iter().collect();

        let known_payloads_not_in_mempool = known_pending_payloads
            .into_iter()
            .filter(|p| !mempool_payloads_hashes.contains(&p.0))
            .collect();

        let mut known_payloads = mempool_payloads;
        known_payloads.append(&mut map_pending_payloads_not_in_mempool(
            &mapping_context,
            known_payloads_not_in_mempool,
        )?);

        return Ok(Json(models::TransactionStatusResponse {
            intent_status: models::TransactionIntentStatus::InMempool,
            status_description: "At least one payload for the intent is in this node's mempool. This node believes it's possible the intent might be able to be committed. Whilst the transaction continues to live in the mempool, you can use the /mempool/transaction endpoint to read its payload.".to_owned(),
            invalid_from_epoch: invalid_from_epoch.map(|epoch| to_api_epoch(&mapping_context, epoch)).transpose()?,
            known_payloads,
        }));
    }

    let known_payloads =
        map_pending_payloads_not_in_mempool(&mapping_context, known_pending_payloads)?;

    let response = if intent_is_permanently_rejected {
        models::TransactionStatusResponse {
            intent_status: models::TransactionIntentStatus::PermanentRejection,
            status_description: "Based on the results from executing a payload for this intent, the node believes the intent is permanently rejected - this means that any transaction payload containing the intent should never be able to be committed.".to_owned(),
            invalid_from_epoch: None,
            known_payloads,
        }
    } else {
        let (status, description) = if known_payloads.is_empty() {
            (
                models::TransactionIntentStatus::NotSeen,
                "No payloads for this intent have been seen recently by this node.",
            )
        } else {
            let any_payloads_not_rejected = known_payloads
                .iter()
                .any(|p| p.status == models::TransactionPayloadStatus::NotInMempool);
            if any_payloads_not_rejected {
                (
                    models::TransactionIntentStatus::FateUncertain,
                    "At least one payload for this intent was not rejected at its last execution, it's unknown whether it will be committed or not."
                )
            } else {
                (
                    models::TransactionIntentStatus::FateUncertainButLikelyRejection,
                    "All known payloads were rejected at their last execution. But none of these rejections implied that the intent itself is permanently rejected. It may still be possible for the intent to be committed."
                )
            }
        };
        models::TransactionStatusResponse {
            intent_status: status,
            status_description: description.to_owned(),
            invalid_from_epoch: invalid_from_epoch
                .map(|epoch| to_api_epoch(&mapping_context, epoch))
                .transpose()?,
            known_payloads,
        }
    };

    Ok(Json(response))
}

fn map_rejected_payloads_due_to_known_commit(
    context: &MappingContext,
    known_rejected_payloads: HashMap<NotarizedTransactionHash, PendingTransactionRecord>,
    committed_state_version: StateVersion,
    committed_notarized_transaction_hash: &NotarizedTransactionHash,
) -> Result<Vec<models::TransactionPayloadDetails>, MappingError> {
    known_rejected_payloads
        .into_iter()
        .map(|(notarized_transaction_hash, transaction_record)| {
            let error_string_to_use = transaction_record
                .most_applicable_rejection()
                .map(|reason| reason.to_string(context))
                // Note: in theory, we should not see the "no rejection" for any transaction here,
                // since we only enter this method after seeing their intent hash committed by a
                // different payload. However, the cache update happens asynchronously after the
                // commit, and we may see a "not-yet-updated" entry - luckily, in such case, we can
                // precisely tell the transaction's status ourselves:
                .unwrap_or_else(|| {
                    MempoolRejectionReason::TransactionIntentAlreadyCommitted(
                        AlreadyCommittedError {
                            committed_state_version,
                            committed_notarized_transaction_hash:
                                *committed_notarized_transaction_hash,
                        },
                    )
                    .to_string(context)
                });
            Ok(models::TransactionPayloadDetails {
                payload_hash: to_api_notarized_transaction_hash(&notarized_transaction_hash),
                payload_hash_bech32m: to_api_hash_bech32m(context, &notarized_transaction_hash)?,
                state_version: None,
                status: models::TransactionPayloadStatus::PermanentlyRejected,
                error_message: Some(error_string_to_use),
            })
        })
        .collect::<Result<Vec<_>, _>>()
}

fn map_pending_payloads_not_in_mempool(
    context: &MappingContext,
    known_payloads_not_in_mempool: HashMap<NotarizedTransactionHash, PendingTransactionRecord>,
) -> Result<Vec<models::TransactionPayloadDetails>, MappingError> {
    known_payloads_not_in_mempool
        .into_iter()
        .map(|(payload_hash, transaction_record)| {
            let attempt = transaction_record.most_applicable_status();
            Ok(match attempt.rejection.as_ref() {
                Some(reason) => models::TransactionPayloadDetails {
                    payload_hash: to_api_notarized_transaction_hash(&payload_hash),
                    payload_hash_bech32m: to_api_hash_bech32m(context, &payload_hash)?,
                    state_version: None,
                    status: if attempt.marks_permanent_rejection_for_payload() {
                        models::TransactionPayloadStatus::PermanentlyRejected
                    } else {
                        models::TransactionPayloadStatus::TransientlyRejected
                    },
                    error_message: Some(reason.to_string(context)),
                },
                None => models::TransactionPayloadDetails {
                    payload_hash: to_api_notarized_transaction_hash(&payload_hash),
                    payload_hash_bech32m: to_api_hash_bech32m(context, &payload_hash)?,
                    state_version: None,
                    status: models::TransactionPayloadStatus::NotInMempool,
                    error_message: None,
                },
            })
        })
        .collect::<Result<Vec<_>, _>>()
}

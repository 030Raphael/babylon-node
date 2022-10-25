use crate::core_api::*;
use models::parsed_notarized_transaction_all_of_identifiers::ParsedNotarizedTransactionAllOfIdentifiers;
use models::parsed_signed_transaction_intent_all_of_identifiers::ParsedSignedTransactionIntentAllOfIdentifiers;
use models::transaction_parse_request::{ParseMode, ResponseMode, ValidationMode};
use models::transaction_parse_response::TransactionParseResponse;
use scrypto::prelude::*;
use state_manager::jni::state_manager::ActualStateManager;
use state_manager::mempool::transaction_rejection_cache::RejectionReason;
use state_manager::transaction::{LedgerTransaction, UserTransactionValidator};
use state_manager::{HasIntentHash, HasLedgerPayloadHash, HasSignaturesHash, HasUserPayloadHash};

use transaction::model::{
    NotarizedTransaction, SignedTransactionIntent, TransactionIntent, TransactionManifest,
};

use super::{
    to_api_intent, to_api_ledger_transaction, to_api_manifest, to_api_notarized_transaction,
    to_api_signed_intent,
};

pub(crate) async fn handle_transaction_parse(
    state: Extension<CoreApiState>,
    request: Json<models::TransactionParseRequest>,
) -> Result<Json<models::TransactionParseResponse>, RequestHandlingError> {
    // TODO: For full validation, we require &mut so that TransactionExecutor can get a &mut
    //       When this is fixed, we can make this a read handler
    core_api_handler(state, request, handle_transaction_parse_internal)
}

pub struct ParseContext<'a> {
    response_mode: ResponseMode,
    validation_mode: ValidationMode,
    epoch: u64,
    state_manager: &'a mut ActualStateManager,
}

fn handle_transaction_parse_internal(
    state_manager: &mut ActualStateManager,
    request: models::TransactionParseRequest,
) -> Result<models::TransactionParseResponse, RequestHandlingError> {
    assert_matching_network(&request.network, &state_manager.network)?;

    let bytes =
        from_hex(request.payload_hex).map_err(|err| err.into_response_error("payload_hex"))?;

    // TODO - fix this to not be &mut when a TransactionExecutor no longer needs a &mut substate store
    let mut context = ParseContext {
        response_mode: request.response_mode.unwrap_or(ResponseMode::Full),
        validation_mode: request.validation_mode.unwrap_or(ValidationMode::_Static),
        epoch: state_manager.get_epoch(),
        state_manager,
    };

    let parse_mode = request.parse_mode.unwrap_or(ParseMode::Any);

    let parsed = match parse_mode {
        ParseMode::Any => {
            attempt_parsing_as_any_payload_type_and_map_for_api(&mut context, &bytes)?
        }
        ParseMode::Notarized => attempt_parsing_as_notarized_transaction(&mut context, &bytes)
            .map(|parsed| to_api_parsed_notarized_transaction(&context, parsed))
            .ok_or_else(|| client_error("The payload isn't a notarized transaction"))??,
        ParseMode::Signed => attempt_parsing_as_signed_intent(&bytes)
            .map(|parsed| to_api_parsed_signed_intent(&context, parsed))
            .ok_or_else(|| client_error("The payload isn't a signed transaction intent"))??,
        ParseMode::Unsigned => attempt_parsing_as_intent(&bytes)
            .map(|parsed| to_api_parsed_intent(&context, parsed))
            .ok_or_else(|| client_error("The payload isn't an unsigned transaction intent"))??,
        ParseMode::Manifest => attempt_parsing_as_manifest(&bytes)
            .map(|parsed| to_api_parsed_manifest(&context, parsed))
            .ok_or_else(|| client_error("The payload isn't a transaction manifest"))??,
        ParseMode::Ledger => attempt_parsing_as_ledger_transaction(&bytes)
            .map(|parsed| to_api_parsed_ledger_transaction(&context, parsed))
            .ok_or_else(|| client_error("The payload isn't a ledger transaction"))??,
    };

    Ok(TransactionParseResponse {
        parsed: Some(parsed),
    })
}

fn attempt_parsing_as_any_payload_type_and_map_for_api(
    context: &mut ParseContext,
    bytes: &[u8],
) -> Result<models::ParsedTransaction, RequestHandlingError> {
    // Attempt 1 - Try parsing as NotarizedTransaction
    let notarized_parse_option = attempt_parsing_as_notarized_transaction(context, bytes);

    if let Some(parsed) = notarized_parse_option {
        return to_api_parsed_notarized_transaction(context, parsed);
    }

    // Attempt 2 - Try parsing as SignedTransactionIntent
    let signed_intent_parse_option = attempt_parsing_as_signed_intent(bytes);

    if let Some(parsed) = signed_intent_parse_option {
        return to_api_parsed_signed_intent(context, parsed);
    }

    // Attempt 3 - Try parsing as (unsigned) TransactionIntent
    let intent_parse_option = attempt_parsing_as_intent(bytes);

    if let Some(parsed) = intent_parse_option {
        return to_api_parsed_intent(context, parsed);
    }

    // Attempt 4 - Try parsing as a manifest
    let intent_parse_option = attempt_parsing_as_manifest(bytes);

    if let Some(parsed) = intent_parse_option {
        return to_api_parsed_manifest(context, parsed);
    }

    // Attempt 5 - Try parsing as a ledger transaction payload
    let ledger_parse_option = attempt_parsing_as_ledger_transaction(bytes);

    if let Some(parsed) = ledger_parse_option {
        return to_api_parsed_ledger_transaction(context, parsed);
    }

    Err(client_error("The payload isn't a valid notarized transaction, signed transaction intent, unsigned transaction intent, transaction manifest or ledger transaction payload."))
}

struct ParsedNotarizedTransaction {
    transaction: NotarizedTransaction,
    validation: Option<Result<(), RejectionReason>>,
}

fn attempt_parsing_as_notarized_transaction(
    context: &mut ParseContext,
    bytes: &[u8],
) -> Option<ParsedNotarizedTransaction> {
    let notarized_parse_result =
        UserTransactionValidator::parse_unvalidated_user_transaction_from_slice(bytes);
    let parsed = match notarized_parse_result {
        Ok(notarized_transaction) => notarized_transaction,
        Err(_) => return None,
    };

    Some(match context.validation_mode {
        ValidationMode::None => ParsedNotarizedTransaction {
            transaction: parsed,
            validation: None,
        },
        ValidationMode::_Static => ParsedNotarizedTransaction {
            transaction: parsed.clone(),
            validation: Some(
                context
                    .state_manager
                    .user_transaction_validator
                    .validate_user_transaction(context.epoch, parsed)
                    .map(|_| ())
                    .map_err(RejectionReason::ValidationError),
            ),
        },
        ValidationMode::Full => ParsedNotarizedTransaction {
            transaction: parsed.clone(),
            validation: Some(
                context
                    .state_manager
                    .check_for_rejection_with_caching(&parsed),
            ),
        },
    })
}

fn to_api_parsed_notarized_transaction(
    context: &ParseContext,
    parsed: ParsedNotarizedTransaction,
) -> Result<models::ParsedTransaction, RequestHandlingError> {
    let model = match context.response_mode {
        ResponseMode::Basic => None,
        ResponseMode::Full => Some(Box::new(to_api_notarized_transaction(
            &parsed.transaction,
            &context.state_manager.network,
        )?)),
    };

    let (validation_error, is_error_permanent) = parsed
        .validation
        .and_then(|result| result.err())
        .map(|error| (Some(format!("{:?}", error)), Some(error.is_permanent())))
        .unwrap_or((None, None));

    Ok(models::ParsedTransaction::ParsedNotarizedTransaction {
        notarized_transaction: model,
        identifiers: Box::new(ParsedNotarizedTransactionAllOfIdentifiers {
            intent_hash: to_api_intent_hash(&parsed.transaction.intent_hash()),
            signatures_hash: to_api_signed_intent_hash(&parsed.transaction.signatures_hash()),
            payload_hash: to_api_payload_hash(&parsed.transaction.user_payload_hash()),
            ledger_hash: to_api_ledger_hash(&parsed.transaction.ledger_payload_hash()),
        }),
        validation_error,
        validation_error_is_permanent: is_error_permanent,
    })
}

fn attempt_parsing_as_signed_intent(bytes: &[u8]) -> Option<SignedTransactionIntent> {
    match scrypto_decode::<SignedTransactionIntent>(bytes) {
        Ok(signed_intent) => Some(signed_intent),
        Err(_) => None,
    }
}

fn to_api_parsed_signed_intent(
    context: &ParseContext,
    parsed: SignedTransactionIntent,
) -> Result<models::ParsedTransaction, RequestHandlingError> {
    let model = match context.response_mode {
        ResponseMode::Basic => None,
        ResponseMode::Full => Some(Box::new(to_api_signed_intent(
            &parsed,
            &context.state_manager.network,
        )?)),
    };
    Ok(models::ParsedTransaction::ParsedSignedTransactionIntent {
        signed_intent: model,
        identifiers: Box::new(ParsedSignedTransactionIntentAllOfIdentifiers {
            intent_hash: to_api_intent_hash(&parsed.intent_hash()),
            signatures_hash: to_api_signed_intent_hash(&parsed.signatures_hash()),
        }),
    })
}

fn attempt_parsing_as_intent(bytes: &[u8]) -> Option<TransactionIntent> {
    match scrypto_decode::<TransactionIntent>(bytes) {
        Ok(intent) => Some(intent),
        Err(_) => None,
    }
}

fn to_api_parsed_intent(
    context: &ParseContext,
    parsed: TransactionIntent,
) -> Result<models::ParsedTransaction, RequestHandlingError> {
    let model = match context.response_mode {
        ResponseMode::Basic => None,
        ResponseMode::Full => Some(Box::new(to_api_intent(
            &parsed,
            &context.state_manager.network,
        )?)),
    };
    Ok(models::ParsedTransaction::ParsedTransactionIntent {
        intent: model,
        identifiers: Box::new(models::ParsedTransactionIntentAllOfIdentifiers {
            intent_hash: to_api_intent_hash(&parsed.intent_hash()),
        }),
    })
}

fn attempt_parsing_as_manifest(bytes: &[u8]) -> Option<TransactionManifest> {
    match scrypto_decode::<TransactionManifest>(bytes) {
        Ok(manifest) => Some(manifest),
        Err(_) => None,
    }
}

fn to_api_parsed_manifest(
    context: &ParseContext,
    parsed: TransactionManifest,
) -> Result<models::ParsedTransaction, RequestHandlingError> {
    let model = match context.response_mode {
        ResponseMode::Basic => None,
        ResponseMode::Full => Some(Box::new(to_api_manifest(
            &parsed,
            &context.state_manager.network,
        )?)),
    };
    Ok(models::ParsedTransaction::ParsedTransactionManifest { manifest: model })
}

fn attempt_parsing_as_ledger_transaction(bytes: &[u8]) -> Option<LedgerTransaction> {
    match LedgerTransaction::from_slice(bytes) {
        Ok(ledger_transaction) => Some(ledger_transaction),
        Err(_) => None,
    }
}

fn to_api_parsed_ledger_transaction(
    context: &ParseContext,
    parsed: LedgerTransaction,
) -> Result<models::ParsedTransaction, RequestHandlingError> {
    let model = match context.response_mode {
        ResponseMode::Basic => None,
        ResponseMode::Full => Some(Box::new(to_api_ledger_transaction(
            &parsed,
            &context.state_manager.network,
        )?)),
    };
    let notarized = parsed.user();
    Ok(models::ParsedTransaction::ParsedLedgerTransaction {
        ledger_transaction: model,
        identifiers: Box::new(models::ParsedLedgerTransactionAllOfIdentifiers {
            intent_hash: notarized.map(|tx| to_api_intent_hash(&tx.intent_hash())),
            signatures_hash: notarized.map(|tx| to_api_signed_intent_hash(&tx.signatures_hash())),
            payload_hash: notarized.map(|tx| to_api_payload_hash(&tx.user_payload_hash())),
            ledger_hash: to_api_ledger_hash(&parsed.ledger_payload_hash()),
        }),
    })
}

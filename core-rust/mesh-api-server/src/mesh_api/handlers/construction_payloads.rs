use super::ConstructionMetadata;
use crate::prelude::*;
use models::{AccountIdentifier, SignatureType, SigningPayload};
use radix_transactions::prelude::ManifestBuilder;

pub(crate) async fn handle_construction_payloads(
    state: State<MeshApiState>,
    Json(request): Json<models::ConstructionPayloadsRequest>,
) -> Result<Json<models::ConstructionPayloadsResponse>, ResponseError> {
    assert_matching_network(&request.network_identifier, &state.network)?;

    let public_key = if let Some(public_keys) = request.public_keys {
        if public_keys.len() == 1 {
            extract_public_key(&public_keys[0])?
        } else {
            return Err(client_error(
                format!("Expected 1 public key, but received {}", public_keys.len()),
                false,
            ));
        }
    } else {
        return Err(client_error("Missing public_keys", false));
    };
    let address = state.public_key_to_address(public_key);

    let metadata: ConstructionMetadata = serde_json::from_value(
        request
            .metadata
            .ok_or(client_error("Missing metadata", false))?,
    )
    .map_err(|_| client_error("Invalid metadata", false))?;

    let extraction_context = ExtractionContext::new(&state.network);
    let mut builder = ManifestBuilder::new();
    for operation in request.operations {
        match operation._type.as_str() {
            "LockFee" => {
                let account = extract_account_from_option(&extraction_context, operation.account)?;
                let (address, quantity) =
                    extract_amount_from_option(&extraction_context, operation.amount.clone())?;
                if address != XRD {
                    return Err(client_error(
                        format!("LockFee only supports XRD: actual = {:?}", operation.amount),
                        false,
                    ));
                }
                builder = builder.lock_fee(account, quantity);
            }
            "Withdraw" => {
                let account = extract_account_from_option(&extraction_context, operation.account)?;
                let (address, quantity) =
                    extract_amount_from_option(&extraction_context, operation.amount)?;
                builder = builder.withdraw_from_account(account, address, quantity);
            }
            "Deposit" => {
                let account = extract_account_from_option(&extraction_context, operation.account)?;
                let (address, quantity) =
                    extract_amount_from_option(&extraction_context, operation.amount)?;
                let bucket = builder.generate_bucket_name("bucket");
                builder = builder.take_from_worktop(address, quantity, &bucket);
                builder = builder.try_deposit_or_abort(account, None, bucket);
            }
            _ => {
                return Err(ResponseError::from(ApiError::InvalidRequest)
                    .with_details(format!("Invalid operation: {}", operation._type)))
            }
        }
    }
    let manifest = builder.build();

    let intent = IntentV1 {
        header: TransactionHeaderV1 {
            network_id: state.network.id,
            start_epoch_inclusive: Epoch::of(metadata.start_epoch_inclusive),
            end_epoch_exclusive: Epoch::of(metadata.end_epoch_exclusive),
            nonce: metadata.nonce,
            notary_public_key: public_key,
            notary_is_signatory: true,
            tip_percentage: 0,
        },
        instructions: InstructionsV1(manifest.instructions),
        blobs: BlobsV1 {
            blobs: Default::default(),
        },
        message: MessageV1::None,
    };

    let intent_bytes = intent.to_raw().unwrap();
    let prepared_intent =
        PreparedIntentV1::prepare(&intent_bytes, &PreparationSettings::latest()).unwrap();
    let intent_hash = prepared_intent.transaction_intent_hash();
    let intent_signatures_hash = hash_encoded_sbor_value(&IntentSignaturesV1 {
        signatures: Default::default(),
    });
    let signed_intent_hash = SignedTransactionIntentHash::from_hash(hash(
        [
            [
                TRANSACTION_HASHABLE_PAYLOAD_PREFIX,
                TransactionDiscriminator::V1SignedIntent as u8,
            ]
            .as_slice(),
            intent_hash.0.as_slice(),
            intent_signatures_hash.0.as_slice(),
        ]
        .concat(),
    ));

    // See https://docs.cdp.coinbase.com/mesh/docs/models#constructionpayloadsresponse for field
    // definitions
    Ok(Json(models::ConstructionPayloadsResponse {
        unsigned_transaction: intent_bytes.to_hex(),
        payloads: vec![SigningPayload {
            address: None, // deprecated
            account_identifier: Some(Box::new(AccountIdentifier {
                address,
                sub_account: None,
                metadata: None,
            })),
            hex_bytes: hex::encode(signed_intent_hash.as_bytes()),
            signature_type: Some(SignatureType::Ecdsa),
        }],
    }))
}

fn hash_encoded_sbor_value<T: ManifestEncode>(value: T) -> Hash {
    // Ignore the version byte
    hash(&manifest_encode(&value).unwrap()[1..])
}

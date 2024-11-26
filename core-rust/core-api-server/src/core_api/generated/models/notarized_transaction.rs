/*
 * Radix Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.3.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct NotarizedTransaction {
    /// The hex-encoded notarized transaction hash for a user transaction. This hash identifies the full submittable notarized transaction - ie the signed intent, plus the notary signature. 
    #[serde(rename = "hash")]
    pub hash: String,
    /// The Bech32m-encoded human readable `NotarizedTransactionHash`.
    #[serde(rename = "hash_bech32m")]
    pub hash_bech32m: String,
    /// The hex-encoded full notarized transaction payload. Returning this can be disabled in TransactionFormatOptions on your request (default true).
    #[serde(rename = "payload_hex", skip_serializing_if = "Option::is_none")]
    pub payload_hex: Option<String>,
    #[serde(rename = "signed_intent")]
    pub signed_intent: Box<crate::core_api::generated::models::SignedTransactionIntent>,
    #[serde(rename = "notary_signature")]
    pub notary_signature: Option<crate::core_api::generated::models::Signature>, // Using Option permits Default trait; Will always be Some in normal use
}

impl NotarizedTransaction {
    pub fn new(hash: String, hash_bech32m: String, signed_intent: crate::core_api::generated::models::SignedTransactionIntent, notary_signature: crate::core_api::generated::models::Signature) -> NotarizedTransaction {
        NotarizedTransaction {
            hash,
            hash_bech32m,
            payload_hex: None,
            signed_intent: Box::new(signed_intent),
            notary_signature: Option::Some(notary_signature),
        }
    }
}



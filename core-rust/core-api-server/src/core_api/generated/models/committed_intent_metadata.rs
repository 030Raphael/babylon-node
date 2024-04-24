/*
 * Radix Core API - Babylon (Bottlenose)
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct CommittedIntentMetadata {
    #[serde(rename = "state_version")]
    pub state_version: i64,
    /// The hex-encoded notarized transaction hash for a user transaction. This hash identifies the full submittable notarized transaction - ie the signed intent, plus the notary signature. 
    #[serde(rename = "payload_hash")]
    pub payload_hash: String,
    /// The Bech32m-encoded human readable `NotarizedTransactionHash`.
    #[serde(rename = "payload_hash_bech32m")]
    pub payload_hash_bech32m: String,
    /// Whether the intent was committed in a transaction with the same payload. This is a convenience field, which can also be computed using `payload_hash` by a client knowing the payload of the submitted transaction. 
    #[serde(rename = "is_same_transaction")]
    pub is_same_transaction: bool,
}

impl CommittedIntentMetadata {
    pub fn new(state_version: i64, payload_hash: String, payload_hash_bech32m: String, is_same_transaction: bool) -> CommittedIntentMetadata {
        CommittedIntentMetadata {
            state_version,
            payload_hash,
            payload_hash_bech32m,
            is_same_transaction,
        }
    }
}



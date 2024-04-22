/*
 * Radix Core API - Babylon (Anemone)
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.1.3
 * 
 * Generated by: https://openapi-generator.tech
 */

/// TransactionFormatOptions : Requested transaction formats to include in the response



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct TransactionFormatOptions {
    /// Whether to return the raw manifest (default true)
    #[serde(rename = "manifest", skip_serializing_if = "Option::is_none")]
    pub manifest: Option<bool>,
    /// Whether to return the hex-encoded blobs (default false)
    #[serde(rename = "blobs", skip_serializing_if = "Option::is_none")]
    pub blobs: Option<bool>,
    /// Whether to return the transaction message (default true)
    #[serde(rename = "message", skip_serializing_if = "Option::is_none")]
    pub message: Option<bool>,
    /// Whether to return the transaction balance changes (default false)
    #[serde(rename = "balance_changes", skip_serializing_if = "Option::is_none")]
    pub balance_changes: Option<bool>,
    /// Whether to return the raw hex-encoded system transaction bytes (default false)
    #[serde(rename = "raw_system_transaction", skip_serializing_if = "Option::is_none")]
    pub raw_system_transaction: Option<bool>,
    /// Whether to return the raw hex-encoded notarized transaction bytes (default true)
    #[serde(rename = "raw_notarized_transaction", skip_serializing_if = "Option::is_none")]
    pub raw_notarized_transaction: Option<bool>,
    /// Whether to return the raw hex-encoded ledger transaction bytes (default false)
    #[serde(rename = "raw_ledger_transaction", skip_serializing_if = "Option::is_none")]
    pub raw_ledger_transaction: Option<bool>,
}

impl TransactionFormatOptions {
    /// Requested transaction formats to include in the response
    pub fn new() -> TransactionFormatOptions {
        TransactionFormatOptions {
            manifest: None,
            blobs: None,
            message: None,
            balance_changes: None,
            raw_system_transaction: None,
            raw_notarized_transaction: None,
            raw_ledger_transaction: None,
        }
    }
}



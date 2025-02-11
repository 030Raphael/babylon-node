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
pub struct TransactionPreviewV2Response {
    #[serde(rename = "at_ledger_state")]
    pub at_ledger_state: Box<crate::core_api::generated::models::LedgerStateSummary>,
    #[serde(rename = "receipt", skip_serializing_if = "Option::is_none")]
    pub receipt: Option<Box<crate::core_api::generated::models::TransactionReceipt>>,
    /// An optional field which is only provided if the `radix_engine_toolkit_receipt` flag is set to true in the `options` property of the request.  This receipt is primarily intended for use with the toolkit and may contain information  that is already available in the receipt provided in the `receipt` field of this  response.  A typical client of this API is not expected to use this receipt. The primary clients  this receipt is intended for is the Radix wallet or any client that needs to perform  execution summaries on their transactions. 
    #[serde(rename = "radix_engine_toolkit_receipt", skip_serializing_if = "Option::is_none")]
    pub radix_engine_toolkit_receipt: Option<serde_json::Value>,
    /// An optional field which is only provided if the `logs` flag is set to true in the `options` property of the request.  If present, it gives the emitted logs from the transaction execution. 
    #[serde(rename = "logs", skip_serializing_if = "Option::is_none")]
    pub logs: Option<Vec<crate::core_api::generated::models::TransactionPreviewResponseLogsInner>>,
}

impl TransactionPreviewV2Response {
    pub fn new(at_ledger_state: crate::core_api::generated::models::LedgerStateSummary) -> TransactionPreviewV2Response {
        TransactionPreviewV2Response {
            at_ledger_state: Box::new(at_ledger_state),
            receipt: None,
            radix_engine_toolkit_receipt: None,
            logs: None,
        }
    }
}



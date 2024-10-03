/*
 * Radix Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.4
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct LtsStateAccountDepositBehaviourResponse {
    #[serde(rename = "state_version")]
    pub state_version: i64,
    #[serde(rename = "ledger_header_summary")]
    pub ledger_header_summary: Box<crate::core_api::generated::models::LedgerHeaderSummary>,
    #[serde(rename = "default_deposit_rule")]
    pub default_deposit_rule: crate::core_api::generated::models::DefaultDepositRule,
    /// Whether the input `badge` belongs to the account's set of authorized depositors. This field will only be present if any badge was passed in the request. 
    #[serde(rename = "is_badge_authorized_depositor", skip_serializing_if = "Option::is_none")]
    pub is_badge_authorized_depositor: Option<bool>,
    /// A map from one of the input `resource_addresses` to its specific deposit behavior configured for this account. This field will only be present if an array of specific resource addresses was passed in the request (even if empty). 
    #[serde(rename = "resource_specific_behaviours", skip_serializing_if = "Option::is_none")]
    pub resource_specific_behaviours: Option<::radix_rust::prelude::IndexMap<String, crate::core_api::generated::models::ResourceSpecificDepositBehaviour>>,
}

impl LtsStateAccountDepositBehaviourResponse {
    pub fn new(state_version: i64, ledger_header_summary: crate::core_api::generated::models::LedgerHeaderSummary, default_deposit_rule: crate::core_api::generated::models::DefaultDepositRule) -> LtsStateAccountDepositBehaviourResponse {
        LtsStateAccountDepositBehaviourResponse {
            state_version,
            ledger_header_summary: Box::new(ledger_header_summary),
            default_deposit_rule,
            is_badge_authorized_depositor: None,
            resource_specific_behaviours: None,
        }
    }
}



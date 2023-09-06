/*
 * Babylon Core API - RCnet v3
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
 * 
 * Generated by: https://openapi-generator.tech
 */

/// StreamTransactionsRequest : A request to retrieve a sublist of committed transactions from the ledger. 



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct StreamTransactionsRequest {
    /// The logical name of the network
    #[serde(rename = "network")]
    pub network: String,
    #[serde(rename = "from_state_version")]
    pub from_state_version: i64,
    /// The maximum number of transactions that will be returned.
    #[serde(rename = "limit")]
    pub limit: i32,
    #[serde(rename = "sbor_format_options", skip_serializing_if = "Option::is_none")]
    pub sbor_format_options: Option<Box<crate::core_api::generated::models::SborFormatOptions>>,
    #[serde(rename = "transaction_format_options", skip_serializing_if = "Option::is_none")]
    pub transaction_format_options: Option<Box<crate::core_api::generated::models::TransactionFormatOptions>>,
    #[serde(rename = "substate_format_options", skip_serializing_if = "Option::is_none")]
    pub substate_format_options: Option<Box<crate::core_api::generated::models::SubstateFormatOptions>>,
    /// Whether to include LedgerProofs (default false)
    #[serde(rename = "include_proofs", skip_serializing_if = "Option::is_none")]
    pub include_proofs: Option<bool>,
}

impl StreamTransactionsRequest {
    /// A request to retrieve a sublist of committed transactions from the ledger. 
    pub fn new(network: String, from_state_version: i64, limit: i32) -> StreamTransactionsRequest {
        StreamTransactionsRequest {
            network,
            from_state_version,
            limit,
            sbor_format_options: None,
            transaction_format_options: None,
            substate_format_options: None,
            include_proofs: None,
        }
    }
}



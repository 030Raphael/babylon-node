/*
 * Babylon Core API - RCnet v3
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct LtsEntityFungibleBalanceChanges {
    /// The Bech32m-encoded human readable version of the entity's address
    #[serde(rename = "entity_address")]
    pub entity_address: String,
    #[serde(rename = "fee_balance_change", skip_serializing_if = "Option::is_none")]
    pub fee_balance_change: Option<Box<crate::core_api::generated::models::LtsFungibleResourceBalanceChange>>,
    /// If present, this field indicates fee-related balance changes, for example:  - Payment of the fee (including tip and royalty) - Distribution of royalties - Distribution of the fee and tip to the consensus-manager, for distributing to the relevant   validator/s at end of epoch  See https://www.radixdlt.com/blog/how-fees-work-in-babylon for further information on how fee payment works at Babylon. 
    #[serde(rename = "fee_balance_changes")]
    pub fee_balance_changes: Vec<crate::core_api::generated::models::LtsFeeFungibleResourceBalanceChange>,
    #[serde(rename = "non_fee_balance_changes")]
    pub non_fee_balance_changes: Vec<crate::core_api::generated::models::LtsFungibleResourceBalanceChange>,
}

impl LtsEntityFungibleBalanceChanges {
    pub fn new(entity_address: String, fee_balance_changes: Vec<crate::core_api::generated::models::LtsFeeFungibleResourceBalanceChange>, non_fee_balance_changes: Vec<crate::core_api::generated::models::LtsFungibleResourceBalanceChange>) -> LtsEntityFungibleBalanceChanges {
        LtsEntityFungibleBalanceChanges {
            entity_address,
            fee_balance_change: None,
            fee_balance_changes,
            non_fee_balance_changes,
        }
    }
}



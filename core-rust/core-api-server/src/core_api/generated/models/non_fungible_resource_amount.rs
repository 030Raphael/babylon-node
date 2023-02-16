/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.3.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct NonFungibleResourceAmount {
    #[serde(rename = "resource_type")]
    pub resource_type: crate::core_api::generated::models::ResourceType,
    /// The Bech32m-encoded human readable version of the resource address
    #[serde(rename = "resource_address")]
    pub resource_address: String,
    #[serde(rename = "non_fungible_ids")]
    pub non_fungible_ids: Vec<crate::core_api::generated::models::NonFungibleId>,
}

impl NonFungibleResourceAmount {
    pub fn new(resource_type: crate::core_api::generated::models::ResourceType, resource_address: String, non_fungible_ids: Vec<crate::core_api::generated::models::NonFungibleId>) -> NonFungibleResourceAmount {
        NonFungibleResourceAmount {
            resource_type,
            resource_address,
            non_fungible_ids,
        }
    }
}



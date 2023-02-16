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
pub struct GlobalEntityReference {
    #[serde(rename = "entity_type")]
    pub entity_type: crate::core_api::generated::models::EntityType,
    /// The hex-encoded bytes of the entity's global address
    #[serde(rename = "global_address_hex")]
    pub global_address_hex: String,
    /// The Bech32m-encoded human readable version of the entity's global address
    #[serde(rename = "global_address")]
    pub global_address: String,
}

impl GlobalEntityReference {
    pub fn new(entity_type: crate::core_api::generated::models::EntityType, global_address_hex: String, global_address: String) -> GlobalEntityReference {
        GlobalEntityReference {
            entity_type,
            global_address_hex,
            global_address,
        }
    }
}



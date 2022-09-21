/*
 * Babylon Core API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct NonFungibleSubstate {
    #[serde(rename = "entity_type")]
    pub entity_type: crate::core_api::generated::models::EntityType,
    #[serde(rename = "substate_type")]
    pub substate_type: crate::core_api::generated::models::SubstateType,
    /// The hex-encoded bytes of its non-fungible id
    #[serde(rename = "nf_id_hex")]
    pub nf_id_hex: String,
    #[serde(rename = "is_deleted")]
    pub is_deleted: bool,
    #[serde(rename = "non_fungible_data", skip_serializing_if = "Option::is_none")]
    pub non_fungible_data: Option<Box<crate::core_api::generated::models::NonFungibleData>>,
}

impl NonFungibleSubstate {
    pub fn new(entity_type: crate::core_api::generated::models::EntityType, substate_type: crate::core_api::generated::models::SubstateType, nf_id_hex: String, is_deleted: bool) -> NonFungibleSubstate {
        NonFungibleSubstate {
            entity_type,
            substate_type,
            nf_id_hex,
            is_deleted,
            non_fungible_data: None,
        }
    }
}



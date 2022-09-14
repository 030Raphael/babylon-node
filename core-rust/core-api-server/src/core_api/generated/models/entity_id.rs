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
pub struct EntityId {
    #[serde(rename = "entity_type")]
    pub entity_type: crate::core_api::generated::models::EntityType,
    /// The hex-encoded bytes of the entity address
    #[serde(rename = "entity_address")]
    pub entity_address: String,
}

impl EntityId {
    pub fn new(entity_type: crate::core_api::generated::models::EntityType, entity_address: String) -> EntityId {
        EntityId {
            entity_type,
            entity_address,
        }
    }
}



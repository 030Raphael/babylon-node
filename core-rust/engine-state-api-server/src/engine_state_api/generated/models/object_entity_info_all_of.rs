/*
 * Engine State API - Babylon (Anemone)
 *
 * **This API is currently in Beta**  This specification may experience breaking changes as part of Babylon Node releases. Such changes will be clearly mentioned in the [babylon-node release notes](https://github.com/radixdlt/babylon-node/releases). We advise against using this API for business-critical integrations before the `version` indicated above becomes stable, which is expected in Q4 of 2024.  This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v0.1-beta
 * 
 * Generated by: https://openapi-generator.tech
 */

/// ObjectEntityInfoAllOf : Information available when the entity is an Object.



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct ObjectEntityInfoAllOf {
    #[serde(rename = "entity_type")]
    pub entity_type: crate::engine_state_api::generated::models::EntityType,
    /// Whether the object is a top-level root, or a child of some other entity.
    #[serde(rename = "is_global")]
    pub is_global: bool,
    /// Whether the object's state is already physically persisted on ledger.
    #[serde(rename = "is_instantiated")]
    pub is_instantiated: bool,
    #[serde(rename = "main_module_state")]
    pub main_module_state: Box<crate::engine_state_api::generated::models::ObjectModuleStateInfo>,
    /// Information about the other modules attached to the object (possibly empty, even when `is_global`). 
    #[serde(rename = "attached_modules")]
    pub attached_modules: Vec<crate::engine_state_api::generated::models::ObjectEntityInfoAllOfAttachedModules>,
    #[serde(rename = "blueprint_reference")]
    pub blueprint_reference: Box<crate::engine_state_api::generated::models::BlueprintReference>,
    #[serde(rename = "instance_info")]
    pub instance_info: Box<crate::engine_state_api::generated::models::ObjectInstanceInfo>,
}

impl ObjectEntityInfoAllOf {
    /// Information available when the entity is an Object.
    pub fn new(entity_type: crate::engine_state_api::generated::models::EntityType, is_global: bool, is_instantiated: bool, main_module_state: crate::engine_state_api::generated::models::ObjectModuleStateInfo, attached_modules: Vec<crate::engine_state_api::generated::models::ObjectEntityInfoAllOfAttachedModules>, blueprint_reference: crate::engine_state_api::generated::models::BlueprintReference, instance_info: crate::engine_state_api::generated::models::ObjectInstanceInfo) -> ObjectEntityInfoAllOf {
        ObjectEntityInfoAllOf {
            entity_type,
            is_global,
            is_instantiated,
            main_module_state: Box::new(main_module_state),
            attached_modules,
            blueprint_reference: Box::new(blueprint_reference),
            instance_info: Box::new(instance_info),
        }
    }
}



/*
 * Engine State API - Babylon (Anemone)
 *
 * **This API is currently in Beta**  This specification may experience breaking changes as part of Babylon Node releases. Such changes will be clearly mentioned in the [babylon-node release notes](https://github.com/radixdlt/babylon-node/releases). We advise against using this API for business-critical integrations before the `version` indicated above becomes stable, which is expected in Q4 of 2024.  This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v0.1-beta
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct DetailedBlueprintInfo {
    /// A name of the outer blueprint within the same package. Only present if this one is an inner blueprint. 
    #[serde(rename = "outer_blueprint_name", skip_serializing_if = "Option::is_none")]
    pub outer_blueprint_name: Option<String>,
    /// If true, an instantiation of this blueprint cannot be persisted (e.g. buckets and proofs are transient).
    #[serde(rename = "is_transient")]
    pub is_transient: bool,
    /// Generic type parameters which need to be substituted by an object (when instantiating this blueprint). See `ObjectInstanceInfo.substituted_generic_types`. 
    #[serde(rename = "generic_type_parameters")]
    pub generic_type_parameters: Vec<crate::engine_state_api::generated::models::GenericTypeParameter>,
    /// Names of the features that can be enabled for an object (when instantiating this blueprint). See `ObjectInstanceInfo.enabled_features`. 
    #[serde(rename = "available_features")]
    pub available_features: Vec<String>,
    /// Fields defined by this blueprint.
    #[serde(rename = "fields")]
    pub fields: Vec<crate::engine_state_api::generated::models::BlueprintFieldInfo>,
    /// Collections defined by this blueprint.
    #[serde(rename = "collections")]
    pub collections: Vec<crate::engine_state_api::generated::models::BlueprintCollectionInfo>,
    /// Functions defined by this blueprint.
    #[serde(rename = "functions")]
    pub functions: Vec<crate::engine_state_api::generated::models::BlueprintFunctionInfo>,
    /// Methods defined by this blueprint.
    #[serde(rename = "methods")]
    pub methods: Vec<crate::engine_state_api::generated::models::BlueprintMethodInfo>,
    #[serde(rename = "roles")]
    pub roles: Option<crate::engine_state_api::generated::models::BlueprintRolesDefinition>, // Using Option permits Default trait; Will always be Some in normal use
    /// Events defined by this blueprint.
    #[serde(rename = "events")]
    pub events: Vec<crate::engine_state_api::generated::models::BlueprintEventInfo>,
    /// Named types defined by this blueprint.
    #[serde(rename = "named_types")]
    pub named_types: Vec<crate::engine_state_api::generated::models::BlueprintNamedTypeInfo>,
}

impl DetailedBlueprintInfo {
    pub fn new(is_transient: bool, generic_type_parameters: Vec<crate::engine_state_api::generated::models::GenericTypeParameter>, available_features: Vec<String>, fields: Vec<crate::engine_state_api::generated::models::BlueprintFieldInfo>, collections: Vec<crate::engine_state_api::generated::models::BlueprintCollectionInfo>, functions: Vec<crate::engine_state_api::generated::models::BlueprintFunctionInfo>, methods: Vec<crate::engine_state_api::generated::models::BlueprintMethodInfo>, roles: crate::engine_state_api::generated::models::BlueprintRolesDefinition, events: Vec<crate::engine_state_api::generated::models::BlueprintEventInfo>, named_types: Vec<crate::engine_state_api::generated::models::BlueprintNamedTypeInfo>) -> DetailedBlueprintInfo {
        DetailedBlueprintInfo {
            outer_blueprint_name: None,
            is_transient,
            generic_type_parameters,
            available_features,
            fields,
            collections,
            functions,
            methods,
            roles: Option::Some(roles),
            events,
            named_types,
        }
    }
}



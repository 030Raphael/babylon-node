/*
 * Browse API
 *
 * This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v0.0.1
 * 
 * Generated by: https://openapi-generator.tech
 */

/// ObjectInstanceInfo : Object's metadata details defined on a per-instance basis (i.e. not in blueprint). Please note that even uninstantiated objects do have instance info (i.e. a default one). 



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct ObjectInstanceInfo {
    /// A Bech32m-encoded, human readable rendering of any global Entity's address.
    #[serde(rename = "outer_object_address", skip_serializing_if = "Option::is_none")]
    pub outer_object_address: Option<String>,
    /// Names of the features enabled for this instance.
    #[serde(rename = "enabled_features")]
    pub enabled_features: Vec<String>,
    /// The actual types used for generics defined by the blueprint.
    #[serde(rename = "substituted_generic_types")]
    pub substituted_generic_types: Vec<crate::browse_api::generated::models::ResolvedTypeReference>,
}

impl ObjectInstanceInfo {
    /// Object's metadata details defined on a per-instance basis (i.e. not in blueprint). Please note that even uninstantiated objects do have instance info (i.e. a default one). 
    pub fn new(enabled_features: Vec<String>, substituted_generic_types: Vec<crate::browse_api::generated::models::ResolvedTypeReference>) -> ObjectInstanceInfo {
        ObjectInstanceInfo {
            outer_object_address: None,
            enabled_features,
            substituted_generic_types,
        }
    }
}



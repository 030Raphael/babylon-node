/*
 * Browse API
 *
 * This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v0.0.1
 * 
 * Generated by: https://openapi-generator.tech
 */

/// BlueprintRolesDefinition : Blueprint's definition of authorization roles.


#[derive(Clone, Debug, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(tag = "type")]
pub enum BlueprintRolesDefinition {
    #[serde(rename="Local")]
    LocalBlueprintRolesDefinition {
        #[serde(rename = "definitions")]
        definitions: Vec<crate::browse_api::generated::models::BlueprintRoleInfo>,
    },
    #[serde(rename="Outer")]
    OuterBlueprintRolesDefinition {
    },
}





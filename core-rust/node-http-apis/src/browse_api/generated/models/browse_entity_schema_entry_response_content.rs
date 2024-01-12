/*
 * Browse API
 *
 * This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v0.0.1
 * 
 * Generated by: https://openapi-generator.tech
 */

/// BrowseEntitySchemaEntryResponseContent : The requested schema's value.



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct BrowseEntitySchemaEntryResponseContent {
    #[serde(rename = "programmatic_json")]
    pub programmatic_json: serde_json::Value,
}

impl BrowseEntitySchemaEntryResponseContent {
    /// The requested schema's value.
    pub fn new(programmatic_json: serde_json::Value) -> BrowseEntitySchemaEntryResponseContent {
        BrowseEntitySchemaEntryResponseContent {
            programmatic_json,
        }
    }
}



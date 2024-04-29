/*
 * Engine State API - Babylon (Anemone)
 *
 * This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v0.0.1
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct SortedIndexEntryKeyAllOf {
    /// The hex-encoded bytes of the sorted part of the key.
    #[serde(rename = "sort_prefix_hex")]
    pub sort_prefix_hex: String,
    #[serde(rename = "key")]
    pub key: Box<crate::engine_state_api::generated::models::SborData>,
}

impl SortedIndexEntryKeyAllOf {
    pub fn new(sort_prefix_hex: String, key: crate::engine_state_api::generated::models::SborData) -> SortedIndexEntryKeyAllOf {
        SortedIndexEntryKeyAllOf {
            sort_prefix_hex,
            key: Box::new(key),
        }
    }
}



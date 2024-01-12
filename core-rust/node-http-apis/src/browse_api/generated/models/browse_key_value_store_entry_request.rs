/*
 * Browse API
 *
 * This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v0.0.1
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct BrowseKeyValueStoreEntryRequest {
    /// A Bech32m-encoded, human readable rendering of an arbitrary Entity's address.
    #[serde(rename = "entity_address")]
    pub entity_address: String,
    #[serde(rename = "key")]
    pub key: Box<crate::browse_api::generated::models::KeyValueStoreMapKey>,
}

impl BrowseKeyValueStoreEntryRequest {
    pub fn new(entity_address: String, key: crate::browse_api::generated::models::KeyValueStoreMapKey) -> BrowseKeyValueStoreEntryRequest {
        BrowseKeyValueStoreEntryRequest {
            entity_address,
            key: Box::new(key),
        }
    }
}



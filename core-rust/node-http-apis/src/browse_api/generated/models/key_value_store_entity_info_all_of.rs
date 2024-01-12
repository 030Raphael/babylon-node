/*
 * Browse API
 *
 * This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v0.0.1
 * 
 * Generated by: https://openapi-generator.tech
 */

/// KeyValueStoreEntityInfoAllOf : Information available when the entity is a Key-Value Store.



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct KeyValueStoreEntityInfoAllOf {
    #[serde(rename = "key_type_reference")]
    pub key_type_reference: Option<crate::browse_api::generated::models::ResolvedTypeReference>, // Using Option permits Default trait; Will always be Some in normal use
    #[serde(rename = "value_type_reference")]
    pub value_type_reference: Option<crate::browse_api::generated::models::ResolvedTypeReference>, // Using Option permits Default trait; Will always be Some in normal use
}

impl KeyValueStoreEntityInfoAllOf {
    /// Information available when the entity is a Key-Value Store.
    pub fn new(key_type_reference: crate::browse_api::generated::models::ResolvedTypeReference, value_type_reference: crate::browse_api::generated::models::ResolvedTypeReference) -> KeyValueStoreEntityInfoAllOf {
        KeyValueStoreEntityInfoAllOf {
            key_type_reference: Option::Some(key_type_reference),
            value_type_reference: Option::Some(value_type_reference),
        }
    }
}



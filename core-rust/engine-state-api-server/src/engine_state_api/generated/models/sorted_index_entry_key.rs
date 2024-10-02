/*
 * Engine State API (Beta)
 *
 * **This API is currently in Beta**  This specification may experience breaking changes as part of Babylon Node releases. Such changes will be clearly mentioned in the [babylon-node release notes](https://github.com/radixdlt/babylon-node/releases). We advise against using this API for business-critical integrations before the `version` indicated above becomes stable, which is expected in Q4 of 2024.  This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v1.2.3
 * 
 * Generated by: https://openapi-generator.tech
 */

/// SortedIndexEntryKey : Key within an Object's Sorted Index collection.



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct SortedIndexEntryKey {
    #[serde(rename = "kind")]
    pub kind: crate::engine_state_api::generated::models::ObjectCollectionKind,
    /// The hex-encoded bytes of the sorted part of the key.
    #[serde(rename = "sort_prefix_hex")]
    pub sort_prefix_hex: String,
    #[serde(rename = "key")]
    pub key: Box<crate::engine_state_api::generated::models::SborData>,
}

impl SortedIndexEntryKey {
    /// Key within an Object's Sorted Index collection.
    pub fn new(kind: crate::engine_state_api::generated::models::ObjectCollectionKind, sort_prefix_hex: String, key: crate::engine_state_api::generated::models::SborData) -> SortedIndexEntryKey {
        SortedIndexEntryKey {
            kind,
            sort_prefix_hex,
            key: Box::new(key),
        }
    }
}



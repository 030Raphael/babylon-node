/*
 * Engine State API (Beta)
 *
 * **This API is currently in Beta**  This specification may experience breaking changes as part of Babylon Node releases. Such changes will be clearly mentioned in the [babylon-node release notes](https://github.com/radixdlt/babylon-node/releases). We advise against using this API for business-critical integrations before the `version` indicated above becomes stable, which is expected in Q4 of 2024.  This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v1.2.3
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct ObjectCollectionIteratorRequest {
    /// A Bech32m-encoded, human readable rendering of an arbitrary Entity's address.
    #[serde(rename = "entity_address")]
    pub entity_address: String,
    #[serde(rename = "attached_module_id", skip_serializing_if = "Option::is_none")]
    pub attached_module_id: Option<crate::engine_state_api::generated::models::AttachedModuleId>,
    /// Name of the collection to read. Either this or `collection_index` is required. Note: getting a collection by name is only a convenience feature, meant for manual, ad-hoc requests (i.e. allowing a human to use the human-readable `DerivedName` when available). In general, a collection's primary identifier is its index, and any production-grade integration should use it. 
    #[serde(rename = "collection_name", skip_serializing_if = "Option::is_none")]
    pub collection_name: Option<String>,
    /// Index of the collection to read. Either this or `collection_name` is required.
    #[serde(rename = "collection_index", skip_serializing_if = "Option::is_none")]
    pub collection_index: Option<i32>,
    #[serde(rename = "sbor_format_options", skip_serializing_if = "Option::is_none")]
    pub sbor_format_options: Option<Box<crate::engine_state_api::generated::models::SborFormatOptions>>,
    /// A maximum number of items to be included in the paged listing response.
    #[serde(rename = "max_page_size", skip_serializing_if = "Option::is_none")]
    pub max_page_size: Option<i32>,
    /// An opaque string conveying the information on where the next page of results starts. It is returned in every paged listing response (except for the last page), and it can be passed in every paged listing request (in order to begin listing from where the previous response ended). 
    #[serde(rename = "continuation_token", skip_serializing_if = "Option::is_none")]
    pub continuation_token: Option<String>,
    #[serde(rename = "at_ledger_state", skip_serializing_if = "Option::is_none")]
    pub at_ledger_state: Option<Box<crate::engine_state_api::generated::models::LedgerStateSelector>>,
}

impl ObjectCollectionIteratorRequest {
    pub fn new(entity_address: String) -> ObjectCollectionIteratorRequest {
        ObjectCollectionIteratorRequest {
            entity_address,
            attached_module_id: None,
            collection_name: None,
            collection_index: None,
            sbor_format_options: None,
            max_page_size: None,
            continuation_token: None,
            at_ledger_state: None,
        }
    }
}



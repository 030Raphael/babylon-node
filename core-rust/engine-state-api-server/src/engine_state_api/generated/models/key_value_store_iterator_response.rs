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
pub struct KeyValueStoreIteratorResponse {
    #[serde(rename = "at_ledger_state")]
    pub at_ledger_state: Box<crate::engine_state_api::generated::models::LedgerStateSummary>,
    /// A page of map keys. If this page is the last one, the `continuation_token` will be not be included.
    #[serde(rename = "page")]
    pub page: Vec<crate::engine_state_api::generated::models::KeyValueStoreMapKey>,
    /// An opaque string conveying the information on where the next page of results starts. It is returned in every paged listing response (except for the last page), and it can be passed in every paged listing request (in order to begin listing from where the previous response ended). 
    #[serde(rename = "continuation_token", skip_serializing_if = "Option::is_none")]
    pub continuation_token: Option<String>,
}

impl KeyValueStoreIteratorResponse {
    pub fn new(at_ledger_state: crate::engine_state_api::generated::models::LedgerStateSummary, page: Vec<crate::engine_state_api::generated::models::KeyValueStoreMapKey>) -> KeyValueStoreIteratorResponse {
        KeyValueStoreIteratorResponse {
            at_ledger_state: Box::new(at_ledger_state),
            page,
            continuation_token: None,
        }
    }
}



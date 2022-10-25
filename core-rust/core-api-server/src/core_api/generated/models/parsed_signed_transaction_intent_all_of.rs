/*
 * Babylon Core API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct ParsedSignedTransactionIntentAllOf {
    #[serde(rename = "signed_intent", skip_serializing_if = "Option::is_none")]
    pub signed_intent: Option<Box<crate::core_api::generated::models::SignedTransactionIntent>>,
    #[serde(rename = "identifiers")]
    pub identifiers: Box<crate::core_api::generated::models::ParsedSignedTransactionIntentAllOfIdentifiers>,
}

impl ParsedSignedTransactionIntentAllOf {
    pub fn new(identifiers: crate::core_api::generated::models::ParsedSignedTransactionIntentAllOfIdentifiers) -> ParsedSignedTransactionIntentAllOf {
        ParsedSignedTransactionIntentAllOf {
            signed_intent: None,
            identifiers: Box::new(identifiers),
        }
    }
}



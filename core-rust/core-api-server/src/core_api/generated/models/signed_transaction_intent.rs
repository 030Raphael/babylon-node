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
pub struct SignedTransactionIntent {
    /// The hex-encoded double-SHA256 hash of the signed transaction intent.
    #[serde(rename = "hash")]
    pub hash: String,
    #[serde(rename = "intent")]
    pub intent: Box<crate::core_api::generated::models::TransactionIntent>,
    #[serde(rename = "intent_signatures")]
    pub intent_signatures: Vec<crate::core_api::generated::models::SignatureWithPublicKey>,
}

impl SignedTransactionIntent {
    pub fn new(hash: String, intent: crate::core_api::generated::models::TransactionIntent, intent_signatures: Vec<crate::core_api::generated::models::SignatureWithPublicKey>) -> SignedTransactionIntent {
        SignedTransactionIntent {
            hash,
            intent: Box::new(intent),
            intent_signatures,
        }
    }
}



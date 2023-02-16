/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.3.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct SignedTransactionIntent {
    /// The hex-encoded signed transaction hash. This is known as the Signed Transaction Hash or Signatures Hash. This is the hash which is signed as part of notarization. This hash is `SHA256(SHA256(compiled_signed_transaction))`
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



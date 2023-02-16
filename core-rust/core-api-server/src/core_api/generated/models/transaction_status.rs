/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.3.0
 * 
 * Generated by: https://openapi-generator.tech
 */

/// TransactionStatus : The status of the transaction

/// The status of the transaction
#[derive(Clone, Copy, Debug, Eq, PartialEq, Ord, PartialOrd, Hash, serde::Serialize, serde::Deserialize)]
pub enum TransactionStatus {
    #[serde(rename = "Succeeded")]
    Succeeded,
    #[serde(rename = "Failed")]
    Failed,
    #[serde(rename = "Rejected")]
    Rejected,

}

impl ToString for TransactionStatus {
    fn to_string(&self) -> String {
        match self {
            Self::Succeeded => String::from("Succeeded"),
            Self::Failed => String::from("Failed"),
            Self::Rejected => String::from("Rejected"),
        }
    }
}

impl Default for TransactionStatus {
    fn default() -> TransactionStatus {
        Self::Succeeded
    }
}





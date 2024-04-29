/*
 * Engine State API - Babylon (Anemone)
 *
 * This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v0.0.1
 * 
 * Generated by: https://openapi-generator.tech
 */


/// 
#[derive(Clone, Copy, Debug, Eq, PartialEq, Ord, PartialOrd, Hash, serde::Serialize, serde::Deserialize)]
pub enum ErrorType {
    #[serde(rename = "RequestedItemNotFound")]
    RequestedItemNotFound,
    #[serde(rename = "RequestedItemInvalid")]
    RequestedItemInvalid,
    #[serde(rename = "StateVersionInTooDistantPast")]
    StateVersionInTooDistantPast,
    #[serde(rename = "StateVersionInFuture")]
    StateVersionInFuture,

}

impl ToString for ErrorType {
    fn to_string(&self) -> String {
        match self {
            Self::RequestedItemNotFound => String::from("RequestedItemNotFound"),
            Self::RequestedItemInvalid => String::from("RequestedItemInvalid"),
            Self::StateVersionInTooDistantPast => String::from("StateVersionInTooDistantPast"),
            Self::StateVersionInFuture => String::from("StateVersionInFuture"),
        }
    }
}

impl Default for ErrorType {
    fn default() -> ErrorType {
        Self::RequestedItemNotFound
    }
}





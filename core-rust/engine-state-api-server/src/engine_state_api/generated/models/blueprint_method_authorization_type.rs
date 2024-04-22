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
pub enum BlueprintMethodAuthorizationType {
    #[serde(rename = "Public")]
    Public,
    #[serde(rename = "ByRoles")]
    ByRoles,
    #[serde(rename = "OuterObjectOnly")]
    OuterObjectOnly,
    #[serde(rename = "OwnPackageOnly")]
    OwnPackageOnly,

}

impl ToString for BlueprintMethodAuthorizationType {
    fn to_string(&self) -> String {
        match self {
            Self::Public => String::from("Public"),
            Self::ByRoles => String::from("ByRoles"),
            Self::OuterObjectOnly => String::from("OuterObjectOnly"),
            Self::OwnPackageOnly => String::from("OwnPackageOnly"),
        }
    }
}

impl Default for BlueprintMethodAuthorizationType {
    fn default() -> BlueprintMethodAuthorizationType {
        Self::Public
    }
}





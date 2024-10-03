/*
 * Engine State API (Beta)
 *
 * **This API is currently in Beta**  This specification may experience breaking changes as part of Babylon Node releases. Such changes will be clearly mentioned in the [babylon-node release notes](https://github.com/radixdlt/babylon-node/releases). We advise against using this API for business-critical integrations before the `version` indicated above becomes stable, which is expected in Q4 of 2024.  This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v1.2.4
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct BlueprintReference {
    /// A Bech32m-encoded, human readable rendering of a Package address.
    #[serde(rename = "package_address")]
    pub package_address: String,
    #[serde(rename = "blueprint_name")]
    pub blueprint_name: String,
    /// A string of format `Major.Minor.Patch` (all parts being `u32`).
    #[serde(rename = "blueprint_version")]
    pub blueprint_version: String,
}

impl BlueprintReference {
    pub fn new(package_address: String, blueprint_name: String, blueprint_version: String) -> BlueprintReference {
        BlueprintReference {
            package_address,
            blueprint_name,
            blueprint_version,
        }
    }
}



/*
 * Babylon Core API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */



#[derive(Clone, Debug, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(tag = "resource_type")]
pub enum ResourceAmount {
    #[serde(rename="Fungible")]
    FungibleResourceAmount {
        /// The Bech32m-encoded human readable version of the resource address
        #[serde(rename = "resource_address")]
        resource_address: String,
        /// The string-encoded decimal subunits of the amount (10^-18) in a signed 256-bit integer. This is string-encoded as it doesn't fit well into common numeric types. 
        #[serde(rename = "amount_attos")]
        amount_attos: String,
    },
    #[serde(rename="NonFungible")]
    NonFungibleResourceAmount {
        /// The Bech32m-encoded human readable version of the resource address
        #[serde(rename = "resource_address")]
        resource_address: String,
        #[serde(rename = "nf_ids")]
        nf_ids: Vec<String>,
    },
}





/*
 * Radix Core API - Babylon (Anemone)
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.1.3
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct NetworkConfigurationResponse {
    #[serde(rename = "version")]
    pub version: Box<crate::core_api::generated::models::NetworkConfigurationResponseVersion>,
    /// The logical name of the network
    #[serde(rename = "network")]
    pub network: String,
    /// The logical id of the network
    #[serde(rename = "network_id")]
    pub network_id: i32,
    /// The network suffix used for Bech32m HRPs used for addressing.
    #[serde(rename = "network_hrp_suffix")]
    pub network_hrp_suffix: String,
    /// The current value of the protocol-based USD/XRD multiplier (i.e. an amount of XRDs to be paid for 1 USD). A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`. 
    #[serde(rename = "usd_price_in_xrd")]
    pub usd_price_in_xrd: String,
    #[serde(rename = "address_types")]
    pub address_types: Vec<crate::core_api::generated::models::AddressType>,
    #[serde(rename = "well_known_addresses")]
    pub well_known_addresses: Box<crate::core_api::generated::models::NetworkConfigurationResponseWellKnownAddresses>,
}

impl NetworkConfigurationResponse {
    pub fn new(version: crate::core_api::generated::models::NetworkConfigurationResponseVersion, network: String, network_id: i32, network_hrp_suffix: String, usd_price_in_xrd: String, address_types: Vec<crate::core_api::generated::models::AddressType>, well_known_addresses: crate::core_api::generated::models::NetworkConfigurationResponseWellKnownAddresses) -> NetworkConfigurationResponse {
        NetworkConfigurationResponse {
            version: Box::new(version),
            network,
            network_id,
            network_hrp_suffix,
            usd_price_in_xrd,
            address_types,
            well_known_addresses: Box::new(well_known_addresses),
        }
    }
}



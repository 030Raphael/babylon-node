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
pub struct TransactionParseRequest {
    /// The logical name of the network
    #[serde(rename = "network")]
    pub network: String,
    /// A hex-encoded payload of a full transaction or a partial transaction - either a notarized transaction, a signed transaction intent an unsigned transaction intent, or a ledger payload. 
    #[serde(rename = "payload_hex")]
    pub payload_hex: String,
    /// The type of transaction payload that should be assumed. If omitted, \"Any\" is used - where the payload is attempted to be parsed as each of the following in turn: Notarized, Signed, Unsigned, Ledger. 
    #[serde(rename = "parse_mode", skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// The type of validation that should be performed, if the payload correctly decompiles as a Notarized Transaction. This is only relevant for Notarized payloads. If omitted, \"Static\" is used. 
    #[serde(rename = "validation_mode", skip_serializing_if = "Option::is_none")]
    pub validation_mode: Option<ValidationMode>,
    /// The amount of information to return in the response. \"Basic\" includes the type, validity information, and any relevant identifiers. \"Full\" also includes the fully parsed information. If omitted, \"Full\" is used. 
    #[serde(rename = "response_mode", skip_serializing_if = "Option::is_none")]
    pub response_mode: Option<ResponseMode>,
    #[serde(rename = "transaction_format_options", skip_serializing_if = "Option::is_none")]
    pub transaction_format_options: Option<Box<crate::core_api::generated::models::TransactionFormatOptions>>,
}

impl TransactionParseRequest {
    pub fn new(network: String, payload_hex: String) -> TransactionParseRequest {
        TransactionParseRequest {
            network,
            payload_hex,
            parse_mode: None,
            validation_mode: None,
            response_mode: None,
            transaction_format_options: None,
        }
    }
}

/// The type of transaction payload that should be assumed. If omitted, \"Any\" is used - where the payload is attempted to be parsed as each of the following in turn: Notarized, Signed, Unsigned, Ledger. 
#[derive(Clone, Copy, Debug, Eq, PartialEq, Ord, PartialOrd, Hash, serde::Serialize, serde::Deserialize)]
pub enum ParseMode {
    #[serde(rename = "Any")]
    Any,
    #[serde(rename = "Notarized")]
    Notarized,
    #[serde(rename = "Signed")]
    Signed,
    #[serde(rename = "Unsigned")]
    Unsigned,
    #[serde(rename = "Ledger")]
    Ledger,
}

impl Default for ParseMode {
    fn default() -> ParseMode {
        Self::Any
    }
}
/// The type of validation that should be performed, if the payload correctly decompiles as a Notarized Transaction. This is only relevant for Notarized payloads. If omitted, \"Static\" is used. 
#[derive(Clone, Copy, Debug, Eq, PartialEq, Ord, PartialOrd, Hash, serde::Serialize, serde::Deserialize)]
pub enum ValidationMode {
    #[serde(rename = "None")]
    None,
    #[serde(rename = "Static")]
    _Static,
    #[serde(rename = "Full")]
    Full,
}

impl Default for ValidationMode {
    fn default() -> ValidationMode {
        Self::None
    }
}
/// The amount of information to return in the response. \"Basic\" includes the type, validity information, and any relevant identifiers. \"Full\" also includes the fully parsed information. If omitted, \"Full\" is used. 
#[derive(Clone, Copy, Debug, Eq, PartialEq, Ord, PartialOrd, Hash, serde::Serialize, serde::Deserialize)]
pub enum ResponseMode {
    #[serde(rename = "Basic")]
    Basic,
    #[serde(rename = "Full")]
    Full,
}

impl Default for ResponseMode {
    fn default() -> ResponseMode {
        Self::Basic
    }
}


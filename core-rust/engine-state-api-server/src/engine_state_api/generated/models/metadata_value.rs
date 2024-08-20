/*
 * Engine State API (Beta)
 *
 * **This API is currently in Beta**  This specification may experience breaking changes as part of Babylon Node releases. Such changes will be clearly mentioned in the [babylon-node release notes](https://github.com/radixdlt/babylon-node/releases). We advise against using this API for business-critical integrations before the `version` indicated above becomes stable, which is expected in Q4 of 2024.  This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v1.2.2
 * 
 * Generated by: https://openapi-generator.tech
 */



#[derive(Clone, Debug, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(tag = "type")]
pub enum MetadataValue {
    #[serde(rename="Bool")]
    BoolMetadataValue {
        #[serde(rename = "value")]
        value: bool,
    },
    #[serde(rename="BoolArray")]
    BoolArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<bool>,
    },
    #[serde(rename="Decimal")]
    DecimalMetadataValue {
        /// A string-encoded fixed-precision decimal to 18 decimal places.
        #[serde(rename = "value")]
        value: String,
    },
    #[serde(rename="DecimalArray")]
    DecimalArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<String>,
    },
    #[serde(rename="GlobalAddress")]
    GlobalAddressMetadataValue {
        /// A Bech32m-encoded, human readable rendering of any global Entity's address.
        #[serde(rename = "value")]
        value: String,
    },
    #[serde(rename="GlobalAddressArray")]
    GlobalAddressArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<String>,
    },
    #[serde(rename="I32")]
    I32MetadataValue {
        #[serde(rename = "value")]
        value: i64,
    },
    #[serde(rename="I32Array")]
    I32ArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<i64>,
    },
    #[serde(rename="I64")]
    I64MetadataValue {
        /// A signed 64-bit integer, encoded as a string (because of JSON limitations).
        #[serde(rename = "value")]
        value: String,
    },
    #[serde(rename="I64Array")]
    I64ArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<String>,
    },
    #[serde(rename="Instant")]
    InstantMetadataValue {
        #[serde(rename = "value")]
        value: Box<crate::engine_state_api::generated::models::ScryptoInstant>,
    },
    #[serde(rename="InstantArray")]
    InstantArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<crate::engine_state_api::generated::models::ScryptoInstant>,
    },
    #[serde(rename="NonFungibleGlobalId")]
    NonFungibleGlobalIdMetadataValue {
        #[serde(rename = "value")]
        value: Box<crate::engine_state_api::generated::models::NonFungibleGlobalId>,
    },
    #[serde(rename="NonFungibleGlobalIdArray")]
    NonFungibleGlobalIdArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<crate::engine_state_api::generated::models::NonFungibleGlobalId>,
    },
    #[serde(rename="NonFungibleLocalId")]
    NonFungibleLocalIdMetadataValue {
        /// A simple string representation of a non-fungible local ID, with a type-dependent formatting: * For string ids, this is `<the-string-id>` * For integer ids, this is `#the-integer-id#` * For bytes ids, this is `[the-lower-case-hex-representation]` * For RUID ids, this is `{...-...-...-...}` where `...` are each 16 hex characters. 
        #[serde(rename = "value")]
        value: String,
    },
    #[serde(rename="NonFungibleLocalIdArray")]
    NonFungibleLocalIdArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<String>,
    },
    #[serde(rename="Origin")]
    OriginMetadataValue {
        #[serde(rename = "value")]
        value: String,
    },
    #[serde(rename="OriginArray")]
    OriginArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<String>,
    },
    #[serde(rename="PublicKey")]
    PublicKeyMetadataValue {
        #[serde(rename = "value")]
        value: Box<crate::engine_state_api::generated::models::PublicKey>,
    },
    #[serde(rename="PublicKeyArray")]
    PublicKeyArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<crate::engine_state_api::generated::models::PublicKey>,
    },
    #[serde(rename="PublicKeyHash")]
    PublicKeyHashMetadataValue {
        #[serde(rename = "value")]
        value: Box<crate::engine_state_api::generated::models::PublicKeyHash>,
    },
    #[serde(rename="PublicKeyHashArray")]
    PublicKeyHashArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<crate::engine_state_api::generated::models::PublicKeyHash>,
    },
    #[serde(rename="String")]
    StringMetadataValue {
        #[serde(rename = "value")]
        value: String,
    },
    #[serde(rename="StringArray")]
    StringArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<String>,
    },
    #[serde(rename="U32")]
    U32MetadataValue {
        #[serde(rename = "value")]
        value: i64,
    },
    #[serde(rename="U32Array")]
    U32ArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<i64>,
    },
    #[serde(rename="U64")]
    U64MetadataValue {
        /// An unsigned 64-bit integer, encoded as a string (because of JSON limitations).
        #[serde(rename = "value")]
        value: String,
    },
    #[serde(rename="U64Array")]
    U64ArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<String>,
    },
    #[serde(rename="U8")]
    U8MetadataValue {
        #[serde(rename = "value")]
        value: i32,
    },
    #[serde(rename="U8Array")]
    U8ArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<i32>,
    },
    #[serde(rename="Url")]
    UrlMetadataValue {
        #[serde(rename = "value")]
        value: String,
    },
    #[serde(rename="UrlArray")]
    UrlArrayMetadataValue {
        #[serde(rename = "value")]
        value: Vec<String>,
    },
}





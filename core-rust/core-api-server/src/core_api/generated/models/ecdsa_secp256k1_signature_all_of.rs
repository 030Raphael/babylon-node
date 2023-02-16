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
pub struct EcdsaSecp256k1SignatureAllOf {
    /// A hex-encoded recoverable ECDSA Secp256k1 signature (65 bytes). The first byte is the recovery id, the remaining 64 bytes are the compact signature, ie `CONCAT(R, s)` where `R` and `s` are each 32-bytes in padded big-endian format.
    #[serde(rename = "signature_hex")]
    pub signature_hex: String,
}

impl EcdsaSecp256k1SignatureAllOf {
    pub fn new(signature_hex: String) -> EcdsaSecp256k1SignatureAllOf {
        EcdsaSecp256k1SignatureAllOf {
            signature_hex,
        }
    }
}



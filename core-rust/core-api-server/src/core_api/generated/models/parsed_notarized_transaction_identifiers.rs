/*
 * Babylon Core API - RCnet v3
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct ParsedNotarizedTransactionIdentifiers {
    /// The hex-encoded intent hash for a user transaction, also known as the transaction id. This hash identifies the core content \"intent\" of the transaction. Each intent can only be committed once. This hash gets signed by any signatories on the transaction, to create the signed intent. 
    #[serde(rename = "intent_hash")]
    pub intent_hash: String,
    /// The hex-encoded signed intent hash for a user transaction. This hash identifies the transaction intent, plus additional signatures. This hash is signed by the notary, to create the submittable NotarizedTransaction. 
    #[serde(rename = "signed_intent_hash")]
    pub signed_intent_hash: String,
    /// The hex-encoded notarized transaction hash for a user transaction. This hash identifies the full submittable notarized transaction - ie the signed intent, plus the notary signature. 
    #[serde(rename = "payload_hash")]
    pub payload_hash: String,
    /// The hex-encoded ledger payload transaction hash. This is a wrapper for both user transactions, and system transactions such as genesis and round changes. 
    #[serde(rename = "ledger_hash")]
    pub ledger_hash: String,
}

impl ParsedNotarizedTransactionIdentifiers {
    pub fn new(intent_hash: String, signed_intent_hash: String, payload_hash: String, ledger_hash: String) -> ParsedNotarizedTransactionIdentifiers {
        ParsedNotarizedTransactionIdentifiers {
            intent_hash,
            signed_intent_hash,
            payload_hash,
            ledger_hash,
        }
    }
}



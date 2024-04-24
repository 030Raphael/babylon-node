/*
 * Radix Core API - Babylon (Bottlenose)
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct LedgerHeader {
    /// An integer between `0` and `10^10`, marking the epoch.
    #[serde(rename = "epoch")]
    pub epoch: i64,
    /// An integer between `0` and `10^10`, marking the current round in an epoch
    #[serde(rename = "round")]
    pub round: i64,
    #[serde(rename = "state_version")]
    pub state_version: i64,
    #[serde(rename = "hashes")]
    pub hashes: Box<crate::core_api::generated::models::LedgerHashes>,
    /// An integer between `0` and `10^14`, marking the consensus parent round timestamp in ms.
    #[serde(rename = "consensus_parent_round_timestamp_ms")]
    pub consensus_parent_round_timestamp_ms: i64,
    /// An integer between `0` and `10^14`, marking the proposer timestamp in ms.
    #[serde(rename = "proposer_timestamp_ms")]
    pub proposer_timestamp_ms: i64,
    #[serde(rename = "next_epoch", skip_serializing_if = "Option::is_none")]
    pub next_epoch: Option<Box<crate::core_api::generated::models::NextEpoch>>,
    /// If present, indicates that this proof triggers the enactment of the given protocol version.
    #[serde(rename = "next_protocol_version", skip_serializing_if = "Option::is_none")]
    pub next_protocol_version: Option<String>,
}

impl LedgerHeader {
    pub fn new(epoch: i64, round: i64, state_version: i64, hashes: crate::core_api::generated::models::LedgerHashes, consensus_parent_round_timestamp_ms: i64, proposer_timestamp_ms: i64) -> LedgerHeader {
        LedgerHeader {
            epoch,
            round,
            state_version,
            hashes: Box::new(hashes),
            consensus_parent_round_timestamp_ms,
            proposer_timestamp_ms,
            next_epoch: None,
            next_protocol_version: None,
        }
    }
}



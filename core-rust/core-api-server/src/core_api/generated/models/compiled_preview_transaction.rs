/*
 * Radix Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.3
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct CompiledPreviewTransaction {
    #[serde(rename = "type")]
    pub _type: crate::core_api::generated::models::PreviewTransactionType,
    /// A hex-encoded, compiled `RawPreviewTransaction`.  As of Cuttlefish, only `PreviewTransactionV2` is supported.  A `PreviewTransactionV2` can be created with a v2 transaction builder: * If using Rust, it can be created with a `TransactionV2Builder` using `build_preview_transaction()`   and then converted to hex with `preview_transaction.to_raw().unwrap().to_hex()` * If using the toolkit, you can create this using the v2 transaction builder.  Some subtleties: * Partial transactions can't be previewed. Instead, they must be wrapped inside a   transaction wrapper, so that the engine knows how to yield to them appropriately. * Currently the builder assumes that the signed partial transactions have real signatures.   This isn't strictly required, and we may create a builder in future which allows providing   public keys when building partial transactions for use in preview. * If you don't have signatures to hand, you can simply not sign the partial transactions,   and then use the `assume_all_signature_proofs` preview flag, although be advised that   this may result in the fee estimate being slightly lower during preview. * We may create more ergonomic builders for PreviewTransactions which allow use of   public keys to denote the signers of subintents. Let us know if this is important   for your use case. 
    #[serde(rename = "preview_transaction_hex")]
    pub preview_transaction_hex: String,
}

impl CompiledPreviewTransaction {
    pub fn new(_type: crate::core_api::generated::models::PreviewTransactionType, preview_transaction_hex: String) -> CompiledPreviewTransaction {
        CompiledPreviewTransaction {
            _type,
            preview_transaction_hex,
        }
    }
}



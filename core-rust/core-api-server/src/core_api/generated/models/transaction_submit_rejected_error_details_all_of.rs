/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.2.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct TransactionSubmitRejectedErrorDetailsAllOf {
    /// An explanation of the error
    #[serde(rename = "error_message")]
    pub error_message: String,
    /// Whether (true) this rejected status has just been calculated fresh, or (false) the status is from the pending transaction result cache. 
    #[serde(rename = "is_fresh")]
    pub is_fresh: bool,
    /// Whether the rejection of this payload is known to be permanent. 
    #[serde(rename = "is_payload_rejection_permanent")]
    pub is_payload_rejection_permanent: bool,
    /// Whether the rejection of this intent is known to be permanent - this is a stronger statement than the payload rejection being permanent, as it implies any payloads containing the intent will also be permanently rejected. 
    #[serde(rename = "is_intent_rejection_permanent")]
    pub is_intent_rejection_permanent: bool,
    /// Whether the cached rejection of this intent is due to the intent already having been committed. If so, see the /transaction/receipt endpoint for further information. 
    #[serde(rename = "is_rejected_because_intent_already_committed")]
    pub is_rejected_because_intent_already_committed: bool,
    /// An integer between `0` and `10^14`, marking the unix timestamp in milliseconds after which the node will consider recalculating the validity of the transaction. Only present if the rejection isn't permanent. 
    #[serde(rename = "recalculation_due", skip_serializing_if = "Option::is_none")]
    pub recalculation_due: Option<i64>,
    /// An integer between `0` and `10^10`, marking the epoch from which the transaction will no longer be valid, and be permanently rejected. Only present if the rejection isn't permanent. 
    #[serde(rename = "invalid_from_epoch", skip_serializing_if = "Option::is_none")]
    pub invalid_from_epoch: Option<i64>,
}

impl TransactionSubmitRejectedErrorDetailsAllOf {
    pub fn new(error_message: String, is_fresh: bool, is_payload_rejection_permanent: bool, is_intent_rejection_permanent: bool, is_rejected_because_intent_already_committed: bool) -> TransactionSubmitRejectedErrorDetailsAllOf {
        TransactionSubmitRejectedErrorDetailsAllOf {
            error_message,
            is_fresh,
            is_payload_rejection_permanent,
            is_intent_rejection_permanent,
            is_rejected_because_intent_already_committed,
            recalculation_due: None,
            invalid_from_epoch: None,
        }
    }
}



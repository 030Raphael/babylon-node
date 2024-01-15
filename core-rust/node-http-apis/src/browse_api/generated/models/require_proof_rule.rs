/*
 * Browse API
 *
 * This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v0.0.1
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct RequireProofRule {
    #[serde(rename = "type")]
    pub _type: crate::browse_api::generated::models::ProofRuleType,
    #[serde(rename = "requirement")]
    pub requirement: Option<crate::browse_api::generated::models::Requirement>, // Using Option permits Default trait; Will always be Some in normal use
}

impl RequireProofRule {
    pub fn new(_type: crate::browse_api::generated::models::ProofRuleType, requirement: crate::browse_api::generated::models::Requirement) -> RequireProofRule {
        RequireProofRule {
            _type,
            requirement: Option::Some(requirement),
        }
    }
}



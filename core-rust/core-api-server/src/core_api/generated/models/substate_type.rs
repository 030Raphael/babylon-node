/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.3.0
 * 
 * Generated by: https://openapi-generator.tech
 */


/// 
#[derive(Clone, Copy, Debug, Eq, PartialEq, Ord, PartialOrd, Hash, serde::Serialize, serde::Deserialize)]
pub enum SubstateType {
    #[serde(rename = "Metadata")]
    Metadata,
    #[serde(rename = "AccessRulesChain")]
    AccessRulesChain,
    #[serde(rename = "GlobalAddress")]
    GlobalAddress,
    #[serde(rename = "ComponentInfo")]
    ComponentInfo,
    #[serde(rename = "ComponentState")]
    ComponentState,
    #[serde(rename = "ComponentRoyaltyConfig")]
    ComponentRoyaltyConfig,
    #[serde(rename = "ComponentRoyaltyAccumulator")]
    ComponentRoyaltyAccumulator,
    #[serde(rename = "PackageInfo")]
    PackageInfo,
    #[serde(rename = "PackageRoyaltyConfig")]
    PackageRoyaltyConfig,
    #[serde(rename = "PackageRoyaltyAccumulator")]
    PackageRoyaltyAccumulator,
    #[serde(rename = "ResourceManager")]
    ResourceManager,
    #[serde(rename = "EpochManager")]
    EpochManager,
    #[serde(rename = "ValidatorSet")]
    ValidatorSet,
    #[serde(rename = "Validator")]
    Validator,
    #[serde(rename = "ClockCurrentMinute")]
    ClockCurrentMinute,
    #[serde(rename = "KeyValueStoreEntry")]
    KeyValueStoreEntry,
    #[serde(rename = "NonFungibleStoreEntry")]
    NonFungibleStoreEntry,
    #[serde(rename = "Vault")]
    Vault,
    #[serde(rename = "AccessController")]
    AccessController,
    #[serde(rename = "Account")]
    Account,

}

impl ToString for SubstateType {
    fn to_string(&self) -> String {
        match self {
            Self::Metadata => String::from("Metadata"),
            Self::AccessRulesChain => String::from("AccessRulesChain"),
            Self::GlobalAddress => String::from("GlobalAddress"),
            Self::ComponentInfo => String::from("ComponentInfo"),
            Self::ComponentState => String::from("ComponentState"),
            Self::ComponentRoyaltyConfig => String::from("ComponentRoyaltyConfig"),
            Self::ComponentRoyaltyAccumulator => String::from("ComponentRoyaltyAccumulator"),
            Self::PackageInfo => String::from("PackageInfo"),
            Self::PackageRoyaltyConfig => String::from("PackageRoyaltyConfig"),
            Self::PackageRoyaltyAccumulator => String::from("PackageRoyaltyAccumulator"),
            Self::ResourceManager => String::from("ResourceManager"),
            Self::EpochManager => String::from("EpochManager"),
            Self::ValidatorSet => String::from("ValidatorSet"),
            Self::Validator => String::from("Validator"),
            Self::ClockCurrentMinute => String::from("ClockCurrentMinute"),
            Self::KeyValueStoreEntry => String::from("KeyValueStoreEntry"),
            Self::NonFungibleStoreEntry => String::from("NonFungibleStoreEntry"),
            Self::Vault => String::from("Vault"),
            Self::AccessController => String::from("AccessController"),
            Self::Account => String::from("Account"),
        }
    }
}

impl Default for SubstateType {
    fn default() -> SubstateType {
        Self::Metadata
    }
}





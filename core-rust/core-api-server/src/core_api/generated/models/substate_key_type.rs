/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.3.0
 * 
 * Generated by: https://openapi-generator.tech
 */

/// SubstateKeyType : Slightly different to the SubstateType - some entities have two of the same substate (eg ResouceManager AccessRules) 

/// Slightly different to the SubstateType - some entities have two of the same substate (eg ResouceManager AccessRules) 
#[derive(Clone, Copy, Debug, Eq, PartialEq, Ord, PartialOrd, Hash, serde::Serialize, serde::Deserialize)]
pub enum SubstateKeyType {
    #[serde(rename = "MetadataEntry")]
    MetadataEntry,
    #[serde(rename = "AccessRules")]
    AccessRules,
    #[serde(rename = "FunctionAccessRules")]
    FunctionAccessRules,
    #[serde(rename = "TypeInfo")]
    TypeInfo,
    #[serde(rename = "ComponentState")]
    ComponentState,
    #[serde(rename = "ComponentRoyaltyConfig")]
    ComponentRoyaltyConfig,
    #[serde(rename = "ComponentRoyaltyAccumulator")]
    ComponentRoyaltyAccumulator,
    #[serde(rename = "PackageInfo")]
    PackageInfo,
    #[serde(rename = "PackageCode")]
    PackageCode,
    #[serde(rename = "PackageCodeType")]
    PackageCodeType,
    #[serde(rename = "PackageRoyaltyConfig")]
    PackageRoyaltyConfig,
    #[serde(rename = "PackageRoyaltyAccumulator")]
    PackageRoyaltyAccumulator,
    #[serde(rename = "ResourceManager")]
    ResourceManager,
    #[serde(rename = "EpochManager")]
    EpochManager,
    #[serde(rename = "CurrentValidatorSet")]
    CurrentValidatorSet,
    #[serde(rename = "PreparingValidatorSet")]
    PreparingValidatorSet,
    #[serde(rename = "Validator")]
    Validator,
    #[serde(rename = "ClockCurrentMinute")]
    ClockCurrentMinute,
    #[serde(rename = "KeyValueStoreEntry")]
    KeyValueStoreEntry,
    #[serde(rename = "NonFungibleStoreEntry")]
    NonFungibleStoreEntry,
    #[serde(rename = "VaultInfo")]
    VaultInfo,
    #[serde(rename = "VaultFungible")]
    VaultFungible,
    #[serde(rename = "VaultNonFungible")]
    VaultNonFungible,
    #[serde(rename = "VaultLockedFungible")]
    VaultLockedFungible,
    #[serde(rename = "VaultLockedNonFungible")]
    VaultLockedNonFungible,
    #[serde(rename = "AccessController")]
    AccessController,
    #[serde(rename = "Account")]
    Account,
    #[serde(rename = "PackageEventSchema")]
    PackageEventSchema,

}

impl ToString for SubstateKeyType {
    fn to_string(&self) -> String {
        match self {
            Self::MetadataEntry => String::from("MetadataEntry"),
            Self::AccessRules => String::from("AccessRules"),
            Self::FunctionAccessRules => String::from("FunctionAccessRules"),
            Self::TypeInfo => String::from("TypeInfo"),
            Self::ComponentState => String::from("ComponentState"),
            Self::ComponentRoyaltyConfig => String::from("ComponentRoyaltyConfig"),
            Self::ComponentRoyaltyAccumulator => String::from("ComponentRoyaltyAccumulator"),
            Self::PackageInfo => String::from("PackageInfo"),
            Self::PackageCode => String::from("PackageCode"),
            Self::PackageCodeType => String::from("PackageCodeType"),
            Self::PackageRoyaltyConfig => String::from("PackageRoyaltyConfig"),
            Self::PackageRoyaltyAccumulator => String::from("PackageRoyaltyAccumulator"),
            Self::ResourceManager => String::from("ResourceManager"),
            Self::EpochManager => String::from("EpochManager"),
            Self::CurrentValidatorSet => String::from("CurrentValidatorSet"),
            Self::PreparingValidatorSet => String::from("PreparingValidatorSet"),
            Self::Validator => String::from("Validator"),
            Self::ClockCurrentMinute => String::from("ClockCurrentMinute"),
            Self::KeyValueStoreEntry => String::from("KeyValueStoreEntry"),
            Self::NonFungibleStoreEntry => String::from("NonFungibleStoreEntry"),
            Self::VaultInfo => String::from("VaultInfo"),
            Self::VaultFungible => String::from("VaultFungible"),
            Self::VaultNonFungible => String::from("VaultNonFungible"),
            Self::VaultLockedFungible => String::from("VaultLockedFungible"),
            Self::VaultLockedNonFungible => String::from("VaultLockedNonFungible"),
            Self::AccessController => String::from("AccessController"),
            Self::Account => String::from("Account"),
            Self::PackageEventSchema => String::from("PackageEventSchema"),
        }
    }
}

impl Default for SubstateKeyType {
    fn default() -> SubstateKeyType {
        Self::MetadataEntry
    }
}





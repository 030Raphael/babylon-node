/*
 * Radix Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.3
 * 
 * Generated by: https://openapi-generator.tech
 */



#[derive(Clone, Debug, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(tag = "substate_type")]
pub enum Substate {
    #[serde(rename="AccessControllerFieldState")]
    AccessControllerFieldStateSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::AccessControllerFieldStateValue>,
    },
    #[serde(rename="AccountAuthorizedDepositorEntry")]
    AccountAuthorizedDepositorEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::AuthorizedDepositorKey>,
        #[serde(rename = "value", skip_serializing_if = "Option::is_none")]
        value: Option<Box<crate::core_api::generated::models::AccountAuthorizedDepositorEntryValue>>,
    },
    #[serde(rename="AccountFieldState")]
    AccountFieldStateSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::AccountFieldStateValue>,
    },
    #[serde(rename="AccountLockerAccountClaimsEntry")]
    AccountLockerAccountClaimsEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::AccountAddressKey>,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::AccountLockerAccountClaimsEntryValue>,
    },
    #[serde(rename="AccountResourcePreferenceEntry")]
    AccountResourcePreferenceEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::ResourceKey>,
        #[serde(rename = "value", skip_serializing_if = "Option::is_none")]
        value: Option<Box<crate::core_api::generated::models::AccountResourcePreferenceEntryValue>>,
    },
    #[serde(rename="AccountVaultEntry")]
    AccountVaultEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::ResourceKey>,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::AccountVaultEntryValue>,
    },
    #[serde(rename="BootLoaderModuleFieldKernelBoot")]
    BootLoaderModuleFieldKernelBootSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: serde_json::Value,
    },
    #[serde(rename="BootLoaderModuleFieldSystemBoot")]
    BootLoaderModuleFieldSystemBootSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::BootLoaderModuleFieldSystemBootValue>,
    },
    #[serde(rename="BootLoaderModuleFieldVmBoot")]
    BootLoaderModuleFieldVmBootSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::BootLoaderModuleFieldVmBootValue>,
    },
    #[serde(rename="ConsensusManagerFieldConfig")]
    ConsensusManagerFieldConfigSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::ConsensusManagerFieldConfigValue>,
    },
    #[serde(rename="ConsensusManagerFieldCurrentProposalStatistic")]
    ConsensusManagerFieldCurrentProposalStatisticSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::ConsensusManagerFieldCurrentProposalStatisticValue>,
    },
    #[serde(rename="ConsensusManagerFieldCurrentTime")]
    ConsensusManagerFieldCurrentTimeSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::ConsensusManagerFieldCurrentTimeValue>,
    },
    #[serde(rename="ConsensusManagerFieldCurrentTimeRoundedToMinutes")]
    ConsensusManagerFieldCurrentTimeRoundedToMinutesSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::ConsensusManagerFieldCurrentTimeRoundedToMinutesValue>,
    },
    #[serde(rename="ConsensusManagerFieldCurrentValidatorSet")]
    ConsensusManagerFieldCurrentValidatorSetSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::ConsensusManagerFieldCurrentValidatorSetValue>,
    },
    #[serde(rename="ConsensusManagerFieldState")]
    ConsensusManagerFieldStateSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::ConsensusManagerFieldStateValue>,
    },
    #[serde(rename="ConsensusManagerFieldValidatorRewards")]
    ConsensusManagerFieldValidatorRewardsSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::ConsensusManagerFieldValidatorRewardsValue>,
    },
    #[serde(rename="ConsensusManagerRegisteredValidatorsByStakeIndexEntry")]
    ConsensusManagerRegisteredValidatorsByStakeIndexEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::ActiveValidatorKey>,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::ConsensusManagerRegisteredValidatorsByStakeIndexEntryValue>,
    },
    #[serde(rename="FungibleResourceManagerFieldDivisibility")]
    FungibleResourceManagerFieldDivisibilitySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::FungibleResourceManagerFieldDivisibilityValue>,
    },
    #[serde(rename="FungibleResourceManagerFieldTotalSupply")]
    FungibleResourceManagerFieldTotalSupplySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::FungibleResourceManagerFieldTotalSupplyValue>,
    },
    #[serde(rename="FungibleVaultFieldBalance")]
    FungibleVaultFieldBalanceSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::FungibleVaultFieldBalanceValue>,
    },
    #[serde(rename="FungibleVaultFieldFrozenStatus")]
    FungibleVaultFieldFrozenStatusSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::FungibleVaultFieldFrozenStatusValue>,
    },
    #[serde(rename="GenericKeyValueStoreEntry")]
    GenericKeyValueStoreEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::GenericKey>,
        #[serde(rename = "value", skip_serializing_if = "Option::is_none")]
        value: Option<Box<crate::core_api::generated::models::GenericKeyValueStoreEntryValue>>,
    },
    #[serde(rename="GenericScryptoComponentFieldState")]
    GenericScryptoComponentFieldStateSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::GenericScryptoComponentFieldStateValue>,
    },
    #[serde(rename="MetadataModuleEntry")]
    MetadataModuleEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::MetadataKey>,
        #[serde(rename = "value", skip_serializing_if = "Option::is_none")]
        value: Option<Box<crate::core_api::generated::models::MetadataModuleEntryValue>>,
    },
    #[serde(rename="MultiResourcePoolFieldState")]
    MultiResourcePoolFieldStateSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::MultiResourcePoolFieldStateValue>,
    },
    #[serde(rename="NonFungibleResourceManagerDataEntry")]
    NonFungibleResourceManagerDataEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::LocalNonFungibleKey>,
        #[serde(rename = "value", skip_serializing_if = "Option::is_none")]
        value: Option<Box<crate::core_api::generated::models::NonFungibleResourceManagerDataEntryValue>>,
    },
    #[serde(rename="NonFungibleResourceManagerFieldIdType")]
    NonFungibleResourceManagerFieldIdTypeSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::NonFungibleResourceManagerFieldIdTypeValue>,
    },
    #[serde(rename="NonFungibleResourceManagerFieldMutableFields")]
    NonFungibleResourceManagerFieldMutableFieldsSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::NonFungibleResourceManagerFieldMutableFieldsValue>,
    },
    #[serde(rename="NonFungibleResourceManagerFieldTotalSupply")]
    NonFungibleResourceManagerFieldTotalSupplySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::NonFungibleResourceManagerFieldTotalSupplyValue>,
    },
    #[serde(rename="NonFungibleVaultContentsIndexEntry")]
    NonFungibleVaultContentsIndexEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::LocalNonFungibleKey>,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::NonFungibleVaultContentsIndexEntryValue>,
    },
    #[serde(rename="NonFungibleVaultFieldBalance")]
    NonFungibleVaultFieldBalanceSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::NonFungibleVaultFieldBalanceValue>,
    },
    #[serde(rename="NonFungibleVaultFieldFrozenStatus")]
    NonFungibleVaultFieldFrozenStatusSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::NonFungibleVaultFieldFrozenStatusValue>,
    },
    #[serde(rename="OneResourcePoolFieldState")]
    OneResourcePoolFieldStateSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::OneResourcePoolFieldStateValue>,
    },
    #[serde(rename="PackageBlueprintAuthTemplateEntry")]
    PackageBlueprintAuthTemplateEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::BlueprintVersionKey>,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::PackageBlueprintAuthTemplateEntryValue>,
    },
    #[serde(rename="PackageBlueprintDefinitionEntry")]
    PackageBlueprintDefinitionEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::BlueprintVersionKey>,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::PackageBlueprintDefinitionEntryValue>,
    },
    #[serde(rename="PackageBlueprintDependenciesEntry")]
    PackageBlueprintDependenciesEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::BlueprintVersionKey>,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::PackageBlueprintDependenciesEntryValue>,
    },
    #[serde(rename="PackageBlueprintRoyaltyEntry")]
    PackageBlueprintRoyaltyEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::BlueprintVersionKey>,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::PackageBlueprintRoyaltyEntryValue>,
    },
    #[serde(rename="PackageCodeInstrumentedCodeEntry")]
    PackageCodeInstrumentedCodeEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::PackageCodeKey>,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::PackageCodeInstrumentedCodeEntryValue>,
    },
    #[serde(rename="PackageCodeOriginalCodeEntry")]
    PackageCodeOriginalCodeEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::PackageCodeKey>,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::PackageCodeOriginalCodeEntryValue>,
    },
    #[serde(rename="PackageCodeVmTypeEntry")]
    PackageCodeVmTypeEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::PackageCodeKey>,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::PackageCodeVmTypeEntryValue>,
    },
    #[serde(rename="PackageFieldRoyaltyAccumulator")]
    PackageFieldRoyaltyAccumulatorSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::PackageFieldRoyaltyAccumulatorValue>,
    },
    #[serde(rename="RoleAssignmentModuleFieldOwnerRole")]
    RoleAssignmentModuleFieldOwnerRoleSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::RoleAssignmentModuleFieldOwnerRoleValue>,
    },
    #[serde(rename="RoleAssignmentModuleRuleEntry")]
    RoleAssignmentModuleRuleEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::ObjectRoleKey>,
        #[serde(rename = "value", skip_serializing_if = "Option::is_none")]
        value: Option<Box<crate::core_api::generated::models::RoleAssignmentModuleRuleEntryValue>>,
    },
    #[serde(rename="RoyaltyModuleFieldState")]
    RoyaltyModuleFieldStateSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::RoyaltyModuleFieldStateValue>,
    },
    #[serde(rename="RoyaltyModuleMethodRoyaltyEntry")]
    RoyaltyModuleMethodRoyaltyEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::MainMethodKey>,
        #[serde(rename = "value", skip_serializing_if = "Option::is_none")]
        value: Option<Box<crate::core_api::generated::models::RoyaltyModuleMethodRoyaltyEntryValue>>,
    },
    #[serde(rename="SchemaEntry")]
    SchemaEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::SchemaKey>,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::SchemaEntryValue>,
    },
    #[serde(rename="TransactionTrackerCollectionEntry")]
    TransactionTrackerCollectionEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "key")]
        key: Box<crate::core_api::generated::models::TransactionIdKey>,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::TransactionTrackerCollectionEntryValue>,
    },
    #[serde(rename="TransactionTrackerFieldState")]
    TransactionTrackerFieldStateSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::TransactionTrackerFieldStateValue>,
    },
    #[serde(rename="TwoResourcePoolFieldState")]
    TwoResourcePoolFieldStateSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::TwoResourcePoolFieldStateValue>,
    },
    #[serde(rename="TypeInfoModuleFieldTypeInfo")]
    TypeInfoModuleFieldTypeInfoSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::TypeInfoModuleFieldTypeInfoValue>,
    },
    #[serde(rename="ValidatorFieldProtocolUpdateReadinessSignal")]
    ValidatorFieldProtocolUpdateReadinessSignalSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::ValidatorFieldProtocolUpdateReadinessSignalValue>,
    },
    #[serde(rename="ValidatorFieldState")]
    ValidatorFieldStateSubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::ValidatorFieldStateValue>,
    },
}





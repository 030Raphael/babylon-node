/*
 * Babylon Core API - RCnet V2
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
 * 
 * Generated by: https://openapi-generator.tech
 */



#[derive(Clone, Debug, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(tag = "substate_type")]
pub enum Substate {
    #[serde(rename="AccessControllerFieldState")]
    AccessControllerFieldStateSubstate {
        #[serde(rename = "data_struct")]
        data_struct: Box<crate::core_api::generated::models::DataStruct>,
    },
    #[serde(rename="AccessRulesModuleFieldOwnerRole")]
    AccessRulesModuleFieldOwnerRoleSubstate {
        #[serde(rename = "owner_role")]
        owner_role: Box<crate::core_api::generated::models::OwnerRole>,
    },
    #[serde(rename="AccessRulesModuleMutabilityEntry")]
    AccessRulesModuleMutabilityEntrySubstate {
        #[serde(rename = "object_module_id")]
        object_module_id: crate::core_api::generated::models::ObjectModuleId,
        #[serde(rename = "role_key")]
        role_key: String,
        #[serde(rename = "mutable_role_keys", skip_serializing_if = "Option::is_none")]
        mutable_role_keys: Option<Vec<String>>,
    },
    #[serde(rename="AccessRulesModuleRuleEntry")]
    AccessRulesModuleRuleEntrySubstate {
        #[serde(rename = "object_module_id")]
        object_module_id: crate::core_api::generated::models::ObjectModuleId,
        #[serde(rename = "role_key")]
        role_key: String,
        #[serde(rename = "access_rule", skip_serializing_if = "Option::is_none")]
        access_rule: Option<Box<crate::core_api::generated::models::AccessRule>>,
    },
    #[serde(rename="AccountDepositRuleIndexEntry")]
    AccountDepositRuleIndexEntrySubstate {
        /// The Bech32m-encoded human readable version of the resource address
        #[serde(rename = "resource_address")]
        resource_address: String,
        #[serde(rename = "deposit_rule", skip_serializing_if = "Option::is_none")]
        deposit_rule: Option<crate::core_api::generated::models::DepositRule>,
        #[serde(rename = "is_locked")]
        is_locked: bool,
    },
    #[serde(rename="AccountFieldState")]
    AccountFieldStateSubstate {
        #[serde(rename = "default_deposit_rule")]
        default_deposit_rule: crate::core_api::generated::models::DefaultDepositRule,
    },
    #[serde(rename="AccountVaultIndexEntry")]
    AccountVaultIndexEntrySubstate {
        /// The Bech32m-encoded human readable version of the resource address
        #[serde(rename = "resource_address")]
        resource_address: String,
        #[serde(rename = "vault", skip_serializing_if = "Option::is_none")]
        vault: Option<Box<crate::core_api::generated::models::EntityReference>>,
    },
    #[serde(rename="ConsensusManagerFieldConfig")]
    ConsensusManagerFieldConfigSubstate {
        /// An integer between `0` and `10^10`, specifying the maximum number of validators in the active validator set. 
        #[serde(rename = "max_validators")]
        max_validators: i64,
        #[serde(rename = "epoch_change_condition")]
        epoch_change_condition: Box<crate::core_api::generated::models::EpochChangeCondition>,
        /// An integer between `0` and `10^10`, specifying the minimum number of epochs before an unstaker can withdraw their XRD. 
        #[serde(rename = "num_unstake_epochs")]
        num_unstake_epochs: i64,
        /// A string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
        #[serde(rename = "total_emission_xrd_per_epoch")]
        total_emission_xrd_per_epoch: String,
        /// A string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
        #[serde(rename = "min_validator_reliability")]
        min_validator_reliability: String,
        /// An integer between `0` and `10^10`, specifying the minimum number of epochs before an owner can take their stake units after attempting to withdraw them. 
        #[serde(rename = "num_owner_stake_units_unlock_epochs")]
        num_owner_stake_units_unlock_epochs: i64,
        /// An integer between `0` and `10^10`, specifying the minimum number of epochs before a fee increase takes effect. 
        #[serde(rename = "num_fee_increase_delay_epochs")]
        num_fee_increase_delay_epochs: i64,
    },
    #[serde(rename="ConsensusManagerFieldCurrentProposalStatistic")]
    ConsensusManagerFieldCurrentProposalStatisticSubstate {
        /// The number of successfully completed proposals this epoch for each validator, indexed by the validator order in the active set.
        #[serde(rename = "completed")]
        completed: Vec<i64>,
        /// The number of missed proposals this epoch for each validator, indexed by the validator order in the active set.
        #[serde(rename = "missed")]
        missed: Vec<i64>,
    },
    #[serde(rename="ConsensusManagerFieldCurrentTime")]
    ConsensusManagerFieldCurrentTimeSubstate {
        #[serde(rename = "proposer_timestamp")]
        proposer_timestamp: Box<crate::core_api::generated::models::Instant>,
    },
    #[serde(rename="ConsensusManagerFieldCurrentTimeRoundedToMinutes")]
    ConsensusManagerFieldCurrentTimeRoundedToMinutesSubstate {
        #[serde(rename = "proposer_timestamp_rounded_down_to_minute")]
        proposer_timestamp_rounded_down_to_minute: Box<crate::core_api::generated::models::Instant>,
    },
    #[serde(rename="ConsensusManagerFieldCurrentValidatorSet")]
    ConsensusManagerFieldCurrentValidatorSetSubstate {
        #[serde(rename = "validator_set")]
        validator_set: Vec<crate::core_api::generated::models::ActiveValidator>,
    },
    #[serde(rename="ConsensusManagerFieldState")]
    ConsensusManagerFieldStateSubstate {
        /// An integer between `0` and `10^10`, marking the current epoch
        #[serde(rename = "epoch")]
        epoch: i64,
        /// An integer between `0` and `10^10`, marking the current round in an epoch
        #[serde(rename = "round")]
        round: i64,
        #[serde(rename = "epoch_start")]
        epoch_start: Box<crate::core_api::generated::models::Instant>,
        #[serde(rename = "current_leader", skip_serializing_if = "Option::is_none")]
        current_leader: Option<Box<crate::core_api::generated::models::ActiveValidatorIndex>>,
    },
    #[serde(rename="ConsensusManagerFieldValidatorRewards")]
    ConsensusManagerFieldValidatorRewardsSubstate {
        #[serde(rename = "proposer_rewards")]
        proposer_rewards: Vec<crate::core_api::generated::models::ProposerReward>,
        #[serde(rename = "rewards_vault")]
        rewards_vault: Box<crate::core_api::generated::models::EntityReference>,
    },
    #[serde(rename="ConsensusManagerRegisteredValidatorsByStakeIndexEntry")]
    ConsensusManagerRegisteredValidatorsByStakeIndexEntrySubstate {
        #[serde(rename = "active_validator")]
        active_validator: Box<crate::core_api::generated::models::ActiveValidator>,
    },
    #[serde(rename="FungibleResourceManagerFieldDivisibility")]
    FungibleResourceManagerFieldDivisibilitySubstate {
        #[serde(rename = "divisibility")]
        divisibility: i32,
    },
    #[serde(rename="FungibleResourceManagerFieldTotalSupply")]
    FungibleResourceManagerFieldTotalSupplySubstate {
        /// The string-encoded decimal representing the total supply of this resource. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
        #[serde(rename = "total_supply")]
        total_supply: String,
    },
    #[serde(rename="FungibleVaultFieldBalance")]
    FungibleVaultFieldBalanceSubstate {
        /// The string-encoded decimal representing the token amount in the vault. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
        #[serde(rename = "amount")]
        amount: String,
    },
    #[serde(rename="GenericKeyValueStoreEntry")]
    GenericKeyValueStoreEntrySubstate {
        #[serde(rename = "is_deleted")]
        is_deleted: bool,
        #[serde(rename = "data_struct", skip_serializing_if = "Option::is_none")]
        data_struct: Option<Box<crate::core_api::generated::models::DataStruct>>,
        #[serde(rename = "is_locked")]
        is_locked: bool,
    },
    #[serde(rename="GenericScryptoComponentFieldState")]
    GenericScryptoComponentFieldStateSubstate {
        #[serde(rename = "data_struct")]
        data_struct: Box<crate::core_api::generated::models::DataStruct>,
    },
    #[serde(rename="MetadataModuleEntry")]
    MetadataModuleEntrySubstate {
        #[serde(rename = "field_name")]
        field_name: String,
        #[serde(rename = "is_deleted")]
        is_deleted: bool,
        #[serde(rename = "data_struct", skip_serializing_if = "Option::is_none")]
        data_struct: Option<Box<crate::core_api::generated::models::DataStruct>>,
        #[serde(rename = "is_locked")]
        is_locked: bool,
    },
    #[serde(rename="MultiResourcePoolFieldState")]
    MultiResourcePoolFieldStateSubstate {
        #[serde(rename = "vaults")]
        vaults: Vec<crate::core_api::generated::models::PoolVault>,
        /// The Bech32m-encoded human readable version of the resource address
        #[serde(rename = "pool_unit_resource_address")]
        pool_unit_resource_address: String,
    },
    #[serde(rename="NonFungibleResourceManagerDataEntry")]
    NonFungibleResourceManagerDataEntrySubstate {
        #[serde(rename = "is_deleted")]
        is_deleted: bool,
        #[serde(rename = "data_struct", skip_serializing_if = "Option::is_none")]
        data_struct: Option<Box<crate::core_api::generated::models::DataStruct>>,
        #[serde(rename = "is_locked")]
        is_locked: bool,
    },
    #[serde(rename="NonFungibleResourceManagerFieldIdType")]
    NonFungibleResourceManagerFieldIdTypeSubstate {
        #[serde(rename = "non_fungible_id_type")]
        non_fungible_id_type: crate::core_api::generated::models::NonFungibleIdType,
    },
    #[serde(rename="NonFungibleResourceManagerFieldMutableFields")]
    NonFungibleResourceManagerFieldMutableFieldsSubstate {
        /// The field names of the NF Metadata which are mutable. 
        #[serde(rename = "mutable_fields")]
        mutable_fields: Vec<String>,
    },
    #[serde(rename="NonFungibleResourceManagerFieldTotalSupply")]
    NonFungibleResourceManagerFieldTotalSupplySubstate {
        /// The string-encoded decimal representing the total supply of this resource. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
        #[serde(rename = "total_supply")]
        total_supply: String,
    },
    #[serde(rename="NonFungibleVaultContentsIndexEntry")]
    NonFungibleVaultContentsIndexEntrySubstate {
        #[serde(rename = "non_fungible_local_id")]
        non_fungible_local_id: Box<crate::core_api::generated::models::NonFungibleLocalId>,
    },
    #[serde(rename="NonFungibleVaultFieldBalance")]
    NonFungibleVaultFieldBalanceSubstate {
        /// The string-encoded decimal representing the token amount in the vault. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
        #[serde(rename = "amount")]
        amount: String,
    },
    #[serde(rename="OneResourcePoolFieldState")]
    OneResourcePoolFieldStateSubstate {
        #[serde(rename = "vault")]
        vault: Box<crate::core_api::generated::models::EntityReference>,
        /// The Bech32m-encoded human readable version of the resource address
        #[serde(rename = "pool_unit_resource_address")]
        pool_unit_resource_address: String,
    },
    #[serde(rename="PackageAuthTemplateEntry")]
    PackageAuthTemplateEntrySubstate {
        #[serde(rename = "name")]
        name: String,
        #[serde(rename = "version")]
        version: String,
        #[serde(rename = "auth_config", skip_serializing_if = "Option::is_none")]
        auth_config: Option<Box<crate::core_api::generated::models::AuthConfig>>,
    },
    #[serde(rename="PackageBlueprintDependenciesEntry")]
    PackageBlueprintDependenciesEntrySubstate {
        #[serde(rename = "name")]
        name: String,
        #[serde(rename = "version")]
        version: String,
        #[serde(rename = "dependencies", skip_serializing_if = "Option::is_none")]
        dependencies: Option<Box<crate::core_api::generated::models::BlueprintDependencies>>,
    },
    #[serde(rename="PackageBlueprintEntry")]
    PackageBlueprintEntrySubstate {
        #[serde(rename = "name")]
        name: String,
        #[serde(rename = "version")]
        version: String,
        #[serde(rename = "definition", skip_serializing_if = "Option::is_none")]
        definition: Option<Box<crate::core_api::generated::models::BlueprintDefinition>>,
    },
    #[serde(rename="PackageCodeEntry")]
    PackageCodeEntrySubstate {
        /// The hex-encoded code hash, capturing the vm-type and the code itself.
        #[serde(rename = "code_hash")]
        code_hash: String,
        #[serde(rename = "vm_type")]
        vm_type: crate::core_api::generated::models::VmType,
        /// Either the hex-encoded WASM package code (if Scrypto), or the native package identifier. 
        #[serde(rename = "code_hex")]
        code_hex: String,
    },
    #[serde(rename="PackageFieldRoyaltyAccumulator")]
    PackageFieldRoyaltyAccumulatorSubstate {
        #[serde(rename = "vault_entity", skip_serializing_if = "Option::is_none")]
        vault_entity: Option<Box<crate::core_api::generated::models::EntityReference>>,
    },
    #[serde(rename="PackageRoyaltyEntry")]
    PackageRoyaltyEntrySubstate {
        #[serde(rename = "name")]
        name: String,
        #[serde(rename = "version")]
        version: String,
        #[serde(rename = "royalty_config", skip_serializing_if = "Option::is_none")]
        royalty_config: Option<Box<crate::core_api::generated::models::RoyaltyConfig>>,
    },
    #[serde(rename="PackageSchemaEntry")]
    PackageSchemaEntrySubstate {
        /// The hex-encoded schema hash, capturing the identity of an SBOR schema.
        #[serde(rename = "schema_hash")]
        schema_hash: String,
        #[serde(rename = "schema", skip_serializing_if = "Option::is_none")]
        schema: Option<Box<crate::core_api::generated::models::ScryptoSchema>>,
    },
    #[serde(rename="RoyaltyModuleFieldAccumulator")]
    RoyaltyModuleFieldAccumulatorSubstate {
        #[serde(rename = "vault_entity")]
        vault_entity: Box<crate::core_api::generated::models::EntityReference>,
    },
    #[serde(rename="RoyaltyModuleMethodConfigEntry")]
    RoyaltyModuleMethodConfigEntrySubstate {
        #[serde(rename = "is_locked")]
        is_locked: bool,
        #[serde(rename = "method_name")]
        method_name: String,
        #[serde(rename = "royalty_amount", skip_serializing_if = "Option::is_none")]
        royalty_amount: Option<Box<crate::core_api::generated::models::RoyaltyAmount>>,
    },
    #[serde(rename="TransactionTrackerCollectionEntry")]
    TransactionTrackerCollectionEntrySubstate {
        /// The hex-encoded intent hash for a user transaction, also known as the transaction id. This hash identifies the core content \"intent\" of the transaction. Each intent can only be committed once. This hash gets signed by any signatories on the transaction, to create the signed intent. 
        #[serde(rename = "intent_hash")]
        intent_hash: String,
        #[serde(rename = "status", skip_serializing_if = "Option::is_none")]
        status: Option<crate::core_api::generated::models::TransactionTrackerTransactionStatus>,
    },
    #[serde(rename="TransactionTrackerFieldState")]
    TransactionTrackerFieldStateSubstate {
        #[serde(rename = "start_epoch")]
        start_epoch: i64,
        #[serde(rename = "start_partition")]
        start_partition: i32,
        #[serde(rename = "partition_range_start_inclusive")]
        partition_range_start_inclusive: i32,
        #[serde(rename = "partition_range_end_inclusive")]
        partition_range_end_inclusive: i32,
        #[serde(rename = "epochs_per_partition")]
        epochs_per_partition: i64,
    },
    #[serde(rename="TwoResourcePoolFieldState")]
    TwoResourcePoolFieldStateSubstate {
        #[serde(rename = "vaults")]
        vaults: Vec<crate::core_api::generated::models::PoolVault>,
        /// The Bech32m-encoded human readable version of the resource address
        #[serde(rename = "pool_unit_resource_address")]
        pool_unit_resource_address: String,
    },
    #[serde(rename="TypeInfoModuleFieldTypeInfo")]
    TypeInfoModuleFieldTypeInfoSubstate {
        #[serde(rename = "details")]
        details: Box<crate::core_api::generated::models::TypeInfoDetails>,
    },
    #[serde(rename="ValidatorFieldState")]
    ValidatorFieldStateSubstate {
        #[serde(rename = "sorted_key", skip_serializing_if = "Option::is_none")]
        sorted_key: Option<Box<crate::core_api::generated::models::SubstateKey>>,
        #[serde(rename = "public_key")]
        public_key: Box<crate::core_api::generated::models::EcdsaSecp256k1PublicKey>,
        #[serde(rename = "is_registered")]
        is_registered: bool,
        /// A string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
        #[serde(rename = "validator_fee_factor")]
        validator_fee_factor: String,
        #[serde(rename = "validator_fee_change_request", skip_serializing_if = "Option::is_none")]
        validator_fee_change_request: Option<Box<crate::core_api::generated::models::ValidatorFeeChangeRequest>>,
        /// The Bech32m-encoded human readable version of the resource address
        #[serde(rename = "stake_unit_resource_address")]
        stake_unit_resource_address: String,
        #[serde(rename = "stake_xrd_vault")]
        stake_xrd_vault: Box<crate::core_api::generated::models::EntityReference>,
        /// The Bech32m-encoded human readable version of the resource address
        #[serde(rename = "unstake_claim_token_resource_address")]
        unstake_claim_token_resource_address: String,
        #[serde(rename = "pending_xrd_withdraw_vault")]
        pending_xrd_withdraw_vault: Box<crate::core_api::generated::models::EntityReference>,
        #[serde(rename = "locked_owner_stake_unit_vault")]
        locked_owner_stake_unit_vault: Box<crate::core_api::generated::models::EntityReference>,
        #[serde(rename = "pending_owner_stake_unit_unlock_vault")]
        pending_owner_stake_unit_unlock_vault: Box<crate::core_api::generated::models::EntityReference>,
        #[serde(rename = "pending_owner_stake_unit_withdrawals")]
        pending_owner_stake_unit_withdrawals: Vec<crate::core_api::generated::models::PendingOwnerStakeWithdrawal>,
        /// A string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
        #[serde(rename = "already_unlocked_owner_stake_unit_amount")]
        already_unlocked_owner_stake_unit_amount: String,
    },
}





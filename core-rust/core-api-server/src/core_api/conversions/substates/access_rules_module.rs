use super::super::*;
use super::*;
use crate::core_api::models;
use crate::engine_prelude::*;

pub fn to_api_owner_role_substate(
    context: &MappingContext,
    substate: &RoleAssignmentOwnerFieldSubstate,
) -> Result<models::Substate, MappingError> {
    Ok(field_substate_single_versioned!(
        substate,
        RoleAssignmentModuleFieldOwnerRole,
        OwnerRoleSubstate { owner_role_entry },
        Value {
            owner_role: Some(models::OwnerRole {
                rule: Some(to_api_access_rule(context, &owner_role_entry.rule)?),
                updater: match owner_role_entry.updater {
                    OwnerRoleUpdater::None => models::OwnerRoleUpdater::None,
                    OwnerRoleUpdater::Owner => models::OwnerRoleUpdater::Owner,
                    OwnerRoleUpdater::Object => models::OwnerRoleUpdater::Object,
                },
            }),
        }
    ))
}

pub fn to_api_access_rule_entry(
    context: &MappingContext,
    typed_key: &TypedSubstateKey,
    substate: &KeyValueEntrySubstate<RoleAssignmentAccessRuleEntryPayload>,
) -> Result<models::Substate, MappingError> {
    assert_key_type!(
        typed_key,
        TypedSubstateKey::RoleAssignmentModule(TypedRoleAssignmentSubstateKey::Rule(
            ModuleRoleKey { module, key }
        ))
    );
    Ok(key_value_store_optional_substate_single_versioned!(
        substate,
        RoleAssignmentModuleRuleEntry,
        models::ObjectRoleKey {
            object_module_id: to_api_module_id(module),
            role_key: key.key.to_string(),
        },
        value => {
            access_rule: Some(to_api_access_rule(context, value)?),
        }
    ))
}

pub fn to_api_access_rule(
    context: &MappingContext,
    access_rule: &AccessRule,
) -> Result<models::AccessRule, MappingError> {
    Ok(match access_rule {
        AccessRule::Protected(access_rule_node) => models::AccessRule::ProtectedAccessRule {
            access_rule: Box::new(to_api_access_rule_node(context, access_rule_node)?),
        },
        AccessRule::AllowAll => models::AccessRule::AllowAllAccessRule {},
        AccessRule::DenyAll => models::AccessRule::DenyAllAccessRule {},
    })
}

pub fn to_api_access_rule_node(
    context: &MappingContext,
    composite_requirement: &CompositeRequirement,
) -> Result<models::CompositeRequirement, MappingError> {
    Ok(match composite_requirement {
        CompositeRequirement::BasicRequirement(requirement) => {
            models::CompositeRequirement::ProofRuleCompositeRequirement {
                proof_rule: Box::new(to_api_proof_rule(context, requirement)?),
            }
        }
        CompositeRequirement::AnyOf(requirements) => {
            models::CompositeRequirement::AnyOfCompositeRequirement {
                access_rules: requirements
                    .iter()
                    .map(|ar| to_api_access_rule_node(context, ar))
                    .collect::<Result<_, _>>()?,
            }
        }
        CompositeRequirement::AllOf(requirements) => {
            models::CompositeRequirement::AllOfCompositeRequirement {
                access_rules: requirements
                    .iter()
                    .map(|ar| to_api_access_rule_node(context, ar))
                    .collect::<Result<_, _>>()?,
            }
        }
    })
}

pub fn to_api_proof_rule(
    context: &MappingContext,
    requirement: &BasicRequirement,
) -> Result<models::BasicRequirement, MappingError> {
    Ok(match requirement {
        BasicRequirement::Require(resource_or_non_fungible) => {
            models::BasicRequirement::RequireBasicRequirement {
                requirement: Box::new(to_api_requirement(context, resource_or_non_fungible)?),
            }
        }
        BasicRequirement::AmountOf(amount, resource) => {
            models::BasicRequirement::AmountOfBasicRequirement {
                amount: to_api_decimal(amount),
                resource: to_api_resource_address(context, resource)?,
            }
        }
        BasicRequirement::AllOf(resource_or_non_fungible_list) => {
            models::BasicRequirement::AllOfBasicRequirement {
                list: to_api_resource_or_non_fungible_list(context, resource_or_non_fungible_list)?,
            }
        }
        BasicRequirement::AnyOf(resource_or_non_fungible_list) => {
            models::BasicRequirement::AnyOfBasicRequirement {
                list: to_api_resource_or_non_fungible_list(context, resource_or_non_fungible_list)?,
            }
        }
        BasicRequirement::CountOf(count, resource_or_non_fungible_list) => {
            models::BasicRequirement::CountOfBasicRequirement {
                count: *count as i32,
                list: to_api_resource_or_non_fungible_list(context, resource_or_non_fungible_list)?,
            }
        }
    })
}

pub fn to_api_resource_or_non_fungible_list(
    context: &MappingContext,
    requirement_list: &[ResourceOrNonFungible],
) -> Result<Vec<models::Requirement>, MappingError> {
    let mut res = Vec::new();
    for resource_or_non_fungible in requirement_list.iter() {
        res.push(to_api_requirement(context, resource_or_non_fungible)?);
    }
    Ok(res)
}

pub fn to_api_requirement(
    context: &MappingContext,
    requirement: &ResourceOrNonFungible,
) -> Result<models::Requirement, MappingError> {
    Ok(match requirement {
        ResourceOrNonFungible::Resource(resource_address) => {
            models::Requirement::ResourceRequirement {
                resource: to_api_resource_address(context, resource_address)?,
            }
        }
        ResourceOrNonFungible::NonFungible(non_fungible_global_id) => {
            models::Requirement::NonFungibleRequirement {
                non_fungible: Box::new(to_api_non_fungible_global_id(
                    context,
                    non_fungible_global_id,
                )?),
            }
        }
    })
}

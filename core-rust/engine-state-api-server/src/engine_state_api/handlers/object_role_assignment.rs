use crate::prelude::*;

pub(crate) async fn handle_object_role_assignment(
    state: State<EngineStateApiState>,
    Json(request): Json<models::ObjectRoleAssignmentRequest>,
) -> Result<Json<models::ObjectRoleAssignmentResponse>, ResponseError> {
    let mapping_context = MappingContext::new(&state.network);
    let extraction_context = ExtractionContext::new(&state.network);

    let node_id = extract_address_as_node_id(&extraction_context, &request.entity_address)
        .map_err(|err| err.into_response_error("entity_address"))?;

    let requested_state_version =
        extract_opt_ledger_state_selector(request.at_ledger_state.as_deref())
            .map_err(|err| err.into_response_error("at_ledger_state"))?;

    let database = state
        .state_manager
        .database
        .snapshot()
        .scoped_at(requested_state_version)?;

    let loader_factory = EngineStateLoaderFactory::new(state.network.clone(), &database)
        .ensure_instantiated(&node_id);

    let ObjectRoleAssignment {
        owner_role_entry,
        main_module_roles,
        attached_modules,
    } = loader_factory
        .create_object_role_assignment_loader()
        .load_role_assignment(&node_id)?;

    let ledger_state = database.at_ledger_state();

    Ok(Json(models::ObjectRoleAssignmentResponse {
        at_ledger_state: Box::new(to_api_ledger_state_summary(
            &mapping_context,
            &ledger_state,
        )?),
        owner: Box::new(to_api_owner_role_entry(&mapping_context, owner_role_entry)?),
        main_module_roles: to_api_module_roles(&mapping_context, main_module_roles)?,
        attached_modules: attached_modules
            .into_iter()
            .map(|(attached_module_id, module_roles)| {
                Ok::<_, MappingError>(models::ObjectRoleAssignmentResponseAttachedModulesInner {
                    attached_module_id: to_api_attached_module_id(&attached_module_id),
                    roles: to_api_module_roles(&mapping_context, module_roles)?,
                })
            })
            .collect::<Result<Vec<_>, _>>()?,
    }))
}

fn to_api_owner_role_entry(
    context: &MappingContext,
    owner_role_entry: OwnerRoleEntry,
) -> Result<models::OwnerRoleEntry, MappingError> {
    Ok(models::OwnerRoleEntry {
        rule: Some(to_api_access_rule(context, &owner_role_entry.rule)?),
        updater: match owner_role_entry.updater {
            OwnerRoleUpdater::None => models::OwnerRoleUpdater::None,
            OwnerRoleUpdater::Owner => models::OwnerRoleUpdater::Owner,
            OwnerRoleUpdater::Object => models::OwnerRoleUpdater::Object,
        },
    })
}

fn to_api_module_roles(
    context: &MappingContext,
    module_roles: ModuleRoles,
) -> Result<Vec<models::RoleAssignmentEntry>, MappingError> {
    module_roles
        .into_iter()
        .map(|(RoleKey { key }, assignment)| {
            Ok(models::RoleAssignmentEntry {
                key,
                assignment: Some(to_api_assignment(context, assignment)?),
            })
        })
        .collect::<Result<Vec<_>, _>>()
}

fn to_api_assignment(
    context: &MappingContext,
    assignment: Assignment,
) -> Result<models::Assignment, MappingError> {
    Ok(match assignment {
        Assignment::Owner => models::Assignment::OwnerAssignment {},
        Assignment::Explicit(rule) => models::Assignment::ExplicitAssignment {
            rule: Box::new(to_api_access_rule(context, &rule)?),
        },
    })
}

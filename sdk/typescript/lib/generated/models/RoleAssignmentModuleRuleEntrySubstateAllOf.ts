/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon (Bottlenose)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { ObjectRoleKey } from './ObjectRoleKey';
import {
    ObjectRoleKeyFromJSON,
    ObjectRoleKeyFromJSONTyped,
    ObjectRoleKeyToJSON,
} from './ObjectRoleKey';
import type { RoleAssignmentModuleRuleEntryValue } from './RoleAssignmentModuleRuleEntryValue';
import {
    RoleAssignmentModuleRuleEntryValueFromJSON,
    RoleAssignmentModuleRuleEntryValueFromJSONTyped,
    RoleAssignmentModuleRuleEntryValueToJSON,
} from './RoleAssignmentModuleRuleEntryValue';

/**
 * 
 * @export
 * @interface RoleAssignmentModuleRuleEntrySubstateAllOf
 */
export interface RoleAssignmentModuleRuleEntrySubstateAllOf {
    /**
     * 
     * @type {ObjectRoleKey}
     * @memberof RoleAssignmentModuleRuleEntrySubstateAllOf
     */
    key: ObjectRoleKey;
    /**
     * 
     * @type {RoleAssignmentModuleRuleEntryValue}
     * @memberof RoleAssignmentModuleRuleEntrySubstateAllOf
     */
    value?: RoleAssignmentModuleRuleEntryValue;
    /**
     * 
     * @type {string}
     * @memberof RoleAssignmentModuleRuleEntrySubstateAllOf
     */
    substate_type?: RoleAssignmentModuleRuleEntrySubstateAllOfSubstateTypeEnum;
}


/**
 * @export
 */
export const RoleAssignmentModuleRuleEntrySubstateAllOfSubstateTypeEnum = {
    RoleAssignmentModuleRuleEntry: 'RoleAssignmentModuleRuleEntry'
} as const;
export type RoleAssignmentModuleRuleEntrySubstateAllOfSubstateTypeEnum = typeof RoleAssignmentModuleRuleEntrySubstateAllOfSubstateTypeEnum[keyof typeof RoleAssignmentModuleRuleEntrySubstateAllOfSubstateTypeEnum];


/**
 * Check if a given object implements the RoleAssignmentModuleRuleEntrySubstateAllOf interface.
 */
export function instanceOfRoleAssignmentModuleRuleEntrySubstateAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "key" in value;

    return isInstance;
}

export function RoleAssignmentModuleRuleEntrySubstateAllOfFromJSON(json: any): RoleAssignmentModuleRuleEntrySubstateAllOf {
    return RoleAssignmentModuleRuleEntrySubstateAllOfFromJSONTyped(json, false);
}

export function RoleAssignmentModuleRuleEntrySubstateAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): RoleAssignmentModuleRuleEntrySubstateAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'key': ObjectRoleKeyFromJSON(json['key']),
        'value': !exists(json, 'value') ? undefined : RoleAssignmentModuleRuleEntryValueFromJSON(json['value']),
        'substate_type': !exists(json, 'substate_type') ? undefined : json['substate_type'],
    };
}

export function RoleAssignmentModuleRuleEntrySubstateAllOfToJSON(value?: RoleAssignmentModuleRuleEntrySubstateAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'key': ObjectRoleKeyToJSON(value.key),
        'value': RoleAssignmentModuleRuleEntryValueToJSON(value.value),
        'substate_type': value.substate_type,
    };
}


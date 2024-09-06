/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { ResourcePreference } from './ResourcePreference';
import {
    ResourcePreferenceFromJSON,
    ResourcePreferenceFromJSONTyped,
    ResourcePreferenceToJSON,
} from './ResourcePreference';

/**
 * 
 * @export
 * @interface ResourceSpecificDepositBehaviour
 */
export interface ResourceSpecificDepositBehaviour {
    /**
     * 
     * @type {ResourcePreference}
     * @memberof ResourceSpecificDepositBehaviour
     */
    resource_preference?: ResourcePreference;
    /**
     * Whether the account contains a vault for the resource (even if 0 balance).
     * This plays a role when `DefaultDepositRule` is `AllowExisting`.
     * @type {boolean}
     * @memberof ResourceSpecificDepositBehaviour
     */
    vault_exists: boolean;
    /**
     * Whether the resource represents the native XRD fungible.
     * XRD is a special case which does not require `vault_exists = true` to satisfy the `AllowExisting` rule.
     * @type {boolean}
     * @memberof ResourceSpecificDepositBehaviour
     */
    is_xrd: boolean;
    /**
     * The fully resolved `try_deposit_*` ability of this resource (which takes all the inputs
     * into account, including the authorized depositor badge, the default deposit rule and
     * the above resource-specific circumstances).
     * @type {boolean}
     * @memberof ResourceSpecificDepositBehaviour
     */
    allows_try_deposit: boolean;
}

/**
 * Check if a given object implements the ResourceSpecificDepositBehaviour interface.
 */
export function instanceOfResourceSpecificDepositBehaviour(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "vault_exists" in value;
    isInstance = isInstance && "is_xrd" in value;
    isInstance = isInstance && "allows_try_deposit" in value;

    return isInstance;
}

export function ResourceSpecificDepositBehaviourFromJSON(json: any): ResourceSpecificDepositBehaviour {
    return ResourceSpecificDepositBehaviourFromJSONTyped(json, false);
}

export function ResourceSpecificDepositBehaviourFromJSONTyped(json: any, ignoreDiscriminator: boolean): ResourceSpecificDepositBehaviour {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'resource_preference': !exists(json, 'resource_preference') ? undefined : ResourcePreferenceFromJSON(json['resource_preference']),
        'vault_exists': json['vault_exists'],
        'is_xrd': json['is_xrd'],
        'allows_try_deposit': json['allows_try_deposit'],
    };
}

export function ResourceSpecificDepositBehaviourToJSON(value?: ResourceSpecificDepositBehaviour | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'resource_preference': ResourcePreferenceToJSON(value.resource_preference),
        'vault_exists': value.vault_exists,
        'is_xrd': value.is_xrd,
        'allows_try_deposit': value.allows_try_deposit,
    };
}


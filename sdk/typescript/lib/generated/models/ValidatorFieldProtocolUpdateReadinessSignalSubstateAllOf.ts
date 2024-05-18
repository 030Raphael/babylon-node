/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon (Bottlenose)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { ValidatorFieldProtocolUpdateReadinessSignalValue } from './ValidatorFieldProtocolUpdateReadinessSignalValue';
import {
    ValidatorFieldProtocolUpdateReadinessSignalValueFromJSON,
    ValidatorFieldProtocolUpdateReadinessSignalValueFromJSONTyped,
    ValidatorFieldProtocolUpdateReadinessSignalValueToJSON,
} from './ValidatorFieldProtocolUpdateReadinessSignalValue';

/**
 * 
 * @export
 * @interface ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOf
 */
export interface ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOf {
    /**
     * 
     * @type {ValidatorFieldProtocolUpdateReadinessSignalValue}
     * @memberof ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOf
     */
    value: ValidatorFieldProtocolUpdateReadinessSignalValue;
    /**
     * 
     * @type {string}
     * @memberof ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOf
     */
    substate_type?: ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOfSubstateTypeEnum;
}


/**
 * @export
 */
export const ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOfSubstateTypeEnum = {
    ValidatorFieldProtocolUpdateReadinessSignal: 'ValidatorFieldProtocolUpdateReadinessSignal'
} as const;
export type ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOfSubstateTypeEnum = typeof ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOfSubstateTypeEnum[keyof typeof ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOfSubstateTypeEnum];


/**
 * Check if a given object implements the ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOf interface.
 */
export function instanceOfValidatorFieldProtocolUpdateReadinessSignalSubstateAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "value" in value;

    return isInstance;
}

export function ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOfFromJSON(json: any): ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOf {
    return ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOfFromJSONTyped(json, false);
}

export function ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'value': ValidatorFieldProtocolUpdateReadinessSignalValueFromJSON(json['value']),
        'substate_type': !exists(json, 'substate_type') ? undefined : json['substate_type'],
    };
}

export function ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOfToJSON(value?: ValidatorFieldProtocolUpdateReadinessSignalSubstateAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'value': ValidatorFieldProtocolUpdateReadinessSignalValueToJSON(value.value),
        'substate_type': value.substate_type,
    };
}


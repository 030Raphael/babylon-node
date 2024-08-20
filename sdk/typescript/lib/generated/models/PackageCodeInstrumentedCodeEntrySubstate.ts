/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.2
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { PackageCodeInstrumentedCodeEntryValue } from './PackageCodeInstrumentedCodeEntryValue';
import {
    PackageCodeInstrumentedCodeEntryValueFromJSON,
    PackageCodeInstrumentedCodeEntryValueFromJSONTyped,
    PackageCodeInstrumentedCodeEntryValueToJSON,
} from './PackageCodeInstrumentedCodeEntryValue';
import type { PackageCodeKey } from './PackageCodeKey';
import {
    PackageCodeKeyFromJSON,
    PackageCodeKeyFromJSONTyped,
    PackageCodeKeyToJSON,
} from './PackageCodeKey';

/**
 * 
 * @export
 * @interface PackageCodeInstrumentedCodeEntrySubstate
 */
export interface PackageCodeInstrumentedCodeEntrySubstate {
    /**
     * 
     * @type {string}
     * @memberof PackageCodeInstrumentedCodeEntrySubstate
     */
    substate_type: PackageCodeInstrumentedCodeEntrySubstateSubstateTypeEnum;
    /**
     * 
     * @type {boolean}
     * @memberof PackageCodeInstrumentedCodeEntrySubstate
     */
    is_locked: boolean;
    /**
     * 
     * @type {PackageCodeKey}
     * @memberof PackageCodeInstrumentedCodeEntrySubstate
     */
    key: PackageCodeKey;
    /**
     * 
     * @type {PackageCodeInstrumentedCodeEntryValue}
     * @memberof PackageCodeInstrumentedCodeEntrySubstate
     */
    value: PackageCodeInstrumentedCodeEntryValue;
}


/**
 * @export
 */
export const PackageCodeInstrumentedCodeEntrySubstateSubstateTypeEnum = {
    PackageCodeInstrumentedCodeEntry: 'PackageCodeInstrumentedCodeEntry'
} as const;
export type PackageCodeInstrumentedCodeEntrySubstateSubstateTypeEnum = typeof PackageCodeInstrumentedCodeEntrySubstateSubstateTypeEnum[keyof typeof PackageCodeInstrumentedCodeEntrySubstateSubstateTypeEnum];


/**
 * Check if a given object implements the PackageCodeInstrumentedCodeEntrySubstate interface.
 */
export function instanceOfPackageCodeInstrumentedCodeEntrySubstate(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "substate_type" in value;
    isInstance = isInstance && "is_locked" in value;
    isInstance = isInstance && "key" in value;
    isInstance = isInstance && "value" in value;

    return isInstance;
}

export function PackageCodeInstrumentedCodeEntrySubstateFromJSON(json: any): PackageCodeInstrumentedCodeEntrySubstate {
    return PackageCodeInstrumentedCodeEntrySubstateFromJSONTyped(json, false);
}

export function PackageCodeInstrumentedCodeEntrySubstateFromJSONTyped(json: any, ignoreDiscriminator: boolean): PackageCodeInstrumentedCodeEntrySubstate {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'substate_type': json['substate_type'],
        'is_locked': json['is_locked'],
        'key': PackageCodeKeyFromJSON(json['key']),
        'value': PackageCodeInstrumentedCodeEntryValueFromJSON(json['value']),
    };
}

export function PackageCodeInstrumentedCodeEntrySubstateToJSON(value?: PackageCodeInstrumentedCodeEntrySubstate | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'substate_type': value.substate_type,
        'is_locked': value.is_locked,
        'key': PackageCodeKeyToJSON(value.key),
        'value': PackageCodeInstrumentedCodeEntryValueToJSON(value.value),
    };
}


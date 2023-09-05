/* tslint:disable */
/* eslint-disable */
/**
 * Babylon Core API - RCnet v3
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { FullyScopedTypeId } from './FullyScopedTypeId';
import {
    FullyScopedTypeIdFromJSON,
    FullyScopedTypeIdFromJSONTyped,
    FullyScopedTypeIdToJSON,
} from './FullyScopedTypeId';

/**
 * 
 * @export
 * @interface ObjectInstanceTypeReferenceAllOf
 */
export interface ObjectInstanceTypeReferenceAllOf {
    /**
     * 
     * @type {FullyScopedTypeId}
     * @memberof ObjectInstanceTypeReferenceAllOf
     */
    resolved_full_type_id: FullyScopedTypeId;
    /**
     * The index of the generic parameter in the instance definition.
     * Was called the `instance_type_index`.
     * @type {number}
     * @memberof ObjectInstanceTypeReferenceAllOf
     */
    generic_index: number;
    /**
     * 
     * @type {string}
     * @memberof ObjectInstanceTypeReferenceAllOf
     */
    type?: ObjectInstanceTypeReferenceAllOfTypeEnum;
}


/**
 * @export
 */
export const ObjectInstanceTypeReferenceAllOfTypeEnum = {
    ObjectInstance: 'ObjectInstance'
} as const;
export type ObjectInstanceTypeReferenceAllOfTypeEnum = typeof ObjectInstanceTypeReferenceAllOfTypeEnum[keyof typeof ObjectInstanceTypeReferenceAllOfTypeEnum];


/**
 * Check if a given object implements the ObjectInstanceTypeReferenceAllOf interface.
 */
export function instanceOfObjectInstanceTypeReferenceAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "resolved_full_type_id" in value;
    isInstance = isInstance && "generic_index" in value;

    return isInstance;
}

export function ObjectInstanceTypeReferenceAllOfFromJSON(json: any): ObjectInstanceTypeReferenceAllOf {
    return ObjectInstanceTypeReferenceAllOfFromJSONTyped(json, false);
}

export function ObjectInstanceTypeReferenceAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): ObjectInstanceTypeReferenceAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'resolved_full_type_id': FullyScopedTypeIdFromJSON(json['resolved_full_type_id']),
        'generic_index': json['generic_index'],
        'type': !exists(json, 'type') ? undefined : json['type'],
    };
}

export function ObjectInstanceTypeReferenceAllOfToJSON(value?: ObjectInstanceTypeReferenceAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'resolved_full_type_id': FullyScopedTypeIdToJSON(value.resolved_full_type_id),
        'generic_index': value.generic_index,
        'type': value.type,
    };
}


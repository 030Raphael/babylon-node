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
import type { LocalTypeId } from './LocalTypeId';
import {
    LocalTypeIdFromJSON,
    LocalTypeIdFromJSONTyped,
    LocalTypeIdToJSON,
} from './LocalTypeId';

/**
 * 
 * @export
 * @interface BlueprintSchemaBlueprintTypeReference
 */
export interface BlueprintSchemaBlueprintTypeReference {
    /**
     * 
     * @type {string}
     * @memberof BlueprintSchemaBlueprintTypeReference
     */
    type: BlueprintSchemaBlueprintTypeReferenceTypeEnum;
    /**
     * 
     * @type {LocalTypeId}
     * @memberof BlueprintSchemaBlueprintTypeReference
     */
    local_type_id: LocalTypeId;
}


/**
 * @export
 */
export const BlueprintSchemaBlueprintTypeReferenceTypeEnum = {
    BlueprintSchema: 'BlueprintSchema'
} as const;
export type BlueprintSchemaBlueprintTypeReferenceTypeEnum = typeof BlueprintSchemaBlueprintTypeReferenceTypeEnum[keyof typeof BlueprintSchemaBlueprintTypeReferenceTypeEnum];


/**
 * Check if a given object implements the BlueprintSchemaBlueprintTypeReference interface.
 */
export function instanceOfBlueprintSchemaBlueprintTypeReference(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "type" in value;
    isInstance = isInstance && "local_type_id" in value;

    return isInstance;
}

export function BlueprintSchemaBlueprintTypeReferenceFromJSON(json: any): BlueprintSchemaBlueprintTypeReference {
    return BlueprintSchemaBlueprintTypeReferenceFromJSONTyped(json, false);
}

export function BlueprintSchemaBlueprintTypeReferenceFromJSONTyped(json: any, ignoreDiscriminator: boolean): BlueprintSchemaBlueprintTypeReference {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'type': json['type'],
        'local_type_id': LocalTypeIdFromJSON(json['local_type_id']),
    };
}

export function BlueprintSchemaBlueprintTypeReferenceToJSON(value?: BlueprintSchemaBlueprintTypeReference | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'type': value.type,
        'local_type_id': LocalTypeIdToJSON(value.local_type_id),
    };
}


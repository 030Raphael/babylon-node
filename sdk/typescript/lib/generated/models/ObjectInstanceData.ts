/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.0.4
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { ResolvedTypeReference } from './ResolvedTypeReference';
import {
    ResolvedTypeReferenceFromJSON,
    ResolvedTypeReferenceFromJSONTyped,
    ResolvedTypeReferenceToJSON,
} from './ResolvedTypeReference';

/**
 * Object's details defined on a per-instance basis (i.e. not in blueprint).
 * Please note that even uninstantiated objects do have instance data (i.e. a default one).
 * @export
 * @interface ObjectInstanceData
 */
export interface ObjectInstanceData {
    /**
     * The Bech32m-encoded human readable version of any global address
     * @type {string}
     * @memberof ObjectInstanceData
     */
    outer_object_address?: string;
    /**
     * Names of the features enabled for this instance.
     * @type {Array<string>}
     * @memberof ObjectInstanceData
     */
    enabled_features: Array<string>;
    /**
     * The actual types used for generics defined by the blueprint.
     * @type {Array<ResolvedTypeReference>}
     * @memberof ObjectInstanceData
     */
    substituted_generic_types: Array<ResolvedTypeReference>;
}

/**
 * Check if a given object implements the ObjectInstanceData interface.
 */
export function instanceOfObjectInstanceData(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "enabled_features" in value;
    isInstance = isInstance && "substituted_generic_types" in value;

    return isInstance;
}

export function ObjectInstanceDataFromJSON(json: any): ObjectInstanceData {
    return ObjectInstanceDataFromJSONTyped(json, false);
}

export function ObjectInstanceDataFromJSONTyped(json: any, ignoreDiscriminator: boolean): ObjectInstanceData {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'outer_object_address': !exists(json, 'outer_object_address') ? undefined : json['outer_object_address'],
        'enabled_features': json['enabled_features'],
        'substituted_generic_types': ((json['substituted_generic_types'] as Array<any>).map(ResolvedTypeReferenceFromJSON)),
    };
}

export function ObjectInstanceDataToJSON(value?: ObjectInstanceData | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'outer_object_address': value.outer_object_address,
        'enabled_features': value.enabled_features,
        'substituted_generic_types': ((value.substituted_generic_types as Array<any>).map(ResolvedTypeReferenceToJSON)),
    };
}


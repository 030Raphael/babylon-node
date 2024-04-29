/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon (Anemone)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.1.3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
/**
 * 
 * @export
 * @interface FunctionEventEmitterIdentifierAllOf
 */
export interface FunctionEventEmitterIdentifierAllOf {
    /**
     * The Bech32m-encoded human readable version of the package address
     * @type {string}
     * @memberof FunctionEventEmitterIdentifierAllOf
     */
    package_address: string;
    /**
     * The blueprint under the package which emitted the event.
     * @type {string}
     * @memberof FunctionEventEmitterIdentifierAllOf
     */
    blueprint_name: string;
    /**
     * 
     * @type {string}
     * @memberof FunctionEventEmitterIdentifierAllOf
     */
    type?: FunctionEventEmitterIdentifierAllOfTypeEnum;
}


/**
 * @export
 */
export const FunctionEventEmitterIdentifierAllOfTypeEnum = {
    Function: 'Function'
} as const;
export type FunctionEventEmitterIdentifierAllOfTypeEnum = typeof FunctionEventEmitterIdentifierAllOfTypeEnum[keyof typeof FunctionEventEmitterIdentifierAllOfTypeEnum];


/**
 * Check if a given object implements the FunctionEventEmitterIdentifierAllOf interface.
 */
export function instanceOfFunctionEventEmitterIdentifierAllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "package_address" in value;
    isInstance = isInstance && "blueprint_name" in value;

    return isInstance;
}

export function FunctionEventEmitterIdentifierAllOfFromJSON(json: any): FunctionEventEmitterIdentifierAllOf {
    return FunctionEventEmitterIdentifierAllOfFromJSONTyped(json, false);
}

export function FunctionEventEmitterIdentifierAllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): FunctionEventEmitterIdentifierAllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'package_address': json['package_address'],
        'blueprint_name': json['blueprint_name'],
        'type': !exists(json, 'type') ? undefined : json['type'],
    };
}

export function FunctionEventEmitterIdentifierAllOfToJSON(value?: FunctionEventEmitterIdentifierAllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'package_address': value.package_address,
        'blueprint_name': value.blueprint_name,
        'type': value.type,
    };
}


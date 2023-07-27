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
/**
 * 
 * @export
 * @interface StateNonFungibleRequest
 */
export interface StateNonFungibleRequest {
    /**
     * The logical name of the network
     * @type {string}
     * @memberof StateNonFungibleRequest
     */
    network: string;
    /**
     * The Bech32m-encoded human readable version of the resource's global address
     * @type {string}
     * @memberof StateNonFungibleRequest
     */
    resource_address: string;
    /**
     * The simple string representation of the non-fungible id.
     * For string id types, this is simply the string itself; for integer types, this is the integer as a decimal; and for the bytes id type, this is the lower case hex representation.
     * A non-fungible resource has a fixed `NonFungibleIdType`, so this representation uniquely identifies this non-fungible
     * under the given resource address.
     * @type {string}
     * @memberof StateNonFungibleRequest
     */
    non_fungible_id: string;
}

/**
 * Check if a given object implements the StateNonFungibleRequest interface.
 */
export function instanceOfStateNonFungibleRequest(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "network" in value;
    isInstance = isInstance && "resource_address" in value;
    isInstance = isInstance && "non_fungible_id" in value;

    return isInstance;
}

export function StateNonFungibleRequestFromJSON(json: any): StateNonFungibleRequest {
    return StateNonFungibleRequestFromJSONTyped(json, false);
}

export function StateNonFungibleRequestFromJSONTyped(json: any, ignoreDiscriminator: boolean): StateNonFungibleRequest {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'network': json['network'],
        'resource_address': json['resource_address'],
        'non_fungible_id': json['non_fungible_id'],
    };
}

export function StateNonFungibleRequestToJSON(value?: StateNonFungibleRequest | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'network': value.network,
        'resource_address': value.resource_address,
        'non_fungible_id': value.non_fungible_id,
    };
}


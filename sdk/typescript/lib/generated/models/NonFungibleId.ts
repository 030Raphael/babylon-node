/* tslint:disable */
/* eslint-disable */
/**
 * Babylon Core API - RCnet V1
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.3.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { NonFungibleIdType } from './NonFungibleIdType';
import {
    NonFungibleIdTypeFromJSON,
    NonFungibleIdTypeFromJSONTyped,
    NonFungibleIdTypeToJSON,
} from './NonFungibleIdType';

/**
 * 
 * @export
 * @interface NonFungibleId
 */
export interface NonFungibleId {
    /**
     * The simple string representation of the non-fungible id.
     * For string id types, this is simply the string itself; for integer types, this is the integer as a decimal; and for the bytes id type, this is the lower case hex representation.
     * A non-fungible resource has a fixed `NonFungibleIdType`, so this representation uniquely identifies this non-fungible
     * under the given resource address.
     * @type {string}
     * @memberof NonFungibleId
     */
    simple_rep: string;
    /**
     * 
     * @type {NonFungibleIdType}
     * @memberof NonFungibleId
     */
    id_type: NonFungibleIdType;
    /**
     * The hex-encoded SBOR-encoded bytes of its non-fungible id
     * @type {string}
     * @memberof NonFungibleId
     */
    sbor_hex: string;
}

/**
 * Check if a given object implements the NonFungibleId interface.
 */
export function instanceOfNonFungibleId(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "simple_rep" in value;
    isInstance = isInstance && "id_type" in value;
    isInstance = isInstance && "sbor_hex" in value;

    return isInstance;
}

export function NonFungibleIdFromJSON(json: any): NonFungibleId {
    return NonFungibleIdFromJSONTyped(json, false);
}

export function NonFungibleIdFromJSONTyped(json: any, ignoreDiscriminator: boolean): NonFungibleId {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'simple_rep': json['simple_rep'],
        'id_type': NonFungibleIdTypeFromJSON(json['id_type']),
        'sbor_hex': json['sbor_hex'],
    };
}

export function NonFungibleIdToJSON(value?: NonFungibleId | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'simple_rep': value.simple_rep,
        'id_type': NonFungibleIdTypeToJSON(value.id_type),
        'sbor_hex': value.sbor_hex,
    };
}


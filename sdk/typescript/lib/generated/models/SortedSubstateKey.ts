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
/**
 * 
 * @export
 * @interface SortedSubstateKey
 */
export interface SortedSubstateKey {
    /**
     * 
     * @type {string}
     * @memberof SortedSubstateKey
     */
    key_type: SortedSubstateKeyKeyTypeEnum;
    /**
     * The hex-encoded bytes of the partially-hashed DB sort key, under the given entity partition
     * @type {string}
     * @memberof SortedSubstateKey
     */
    db_sort_key_hex: string;
    /**
     * The hex-encoded bytes of the sorted part of the key
     * @type {string}
     * @memberof SortedSubstateKey
     */
    sort_prefix_hex: string;
    /**
     * The hex-encoded remaining bytes of the key
     * @type {string}
     * @memberof SortedSubstateKey
     */
    key_hex: string;
}


/**
 * @export
 */
export const SortedSubstateKeyKeyTypeEnum = {
    Sorted: 'Sorted'
} as const;
export type SortedSubstateKeyKeyTypeEnum = typeof SortedSubstateKeyKeyTypeEnum[keyof typeof SortedSubstateKeyKeyTypeEnum];


/**
 * Check if a given object implements the SortedSubstateKey interface.
 */
export function instanceOfSortedSubstateKey(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "key_type" in value;
    isInstance = isInstance && "db_sort_key_hex" in value;
    isInstance = isInstance && "sort_prefix_hex" in value;
    isInstance = isInstance && "key_hex" in value;

    return isInstance;
}

export function SortedSubstateKeyFromJSON(json: any): SortedSubstateKey {
    return SortedSubstateKeyFromJSONTyped(json, false);
}

export function SortedSubstateKeyFromJSONTyped(json: any, ignoreDiscriminator: boolean): SortedSubstateKey {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'key_type': json['key_type'],
        'db_sort_key_hex': json['db_sort_key_hex'],
        'sort_prefix_hex': json['sort_prefix_hex'],
        'key_hex': json['key_hex'],
    };
}

export function SortedSubstateKeyToJSON(value?: SortedSubstateKey | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'key_type': value.key_type,
        'db_sort_key_hex': value.db_sort_key_hex,
        'sort_prefix_hex': value.sort_prefix_hex,
        'key_hex': value.key_hex,
    };
}


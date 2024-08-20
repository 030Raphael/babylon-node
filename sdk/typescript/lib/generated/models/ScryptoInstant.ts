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
 * @interface ScryptoInstant
 */
export interface ScryptoInstant {
    /**
     * A decimal string-encoded 64-bit signed integer, marking the unix timestamp in seconds.
     * 
     * Note: this field accurately represents the full range of possible on-ledger values (i.e.
     * `-2^63 <= seconds < 2^63`). This is contrary to the `InstantMs` type used in other
     * places of this API.
     * @type {string}
     * @memberof ScryptoInstant
     */
    unix_timestamp_seconds: string;
    /**
     * The RFC 3339 / ISO 8601 string representation of the timestamp. Will always use "Z"
     * (denoting UTC) and a second-precision (i.e. *skipping* the `.000` milliseconds part).
     * E.g.: `2023-01-26T18:30:09Z`.
     * 
     * Note: This field will *not* be present if the actual on-ledger `unix_timestamp_seconds`
     * value is outside the basic range supported by the RFC 3339 / ISO 8601 standard, which
     * starts at year 1583 (i.e. the beginning of the Gregorian calendar) and ends at year
     * 9999 (inclusive).
     * @type {string}
     * @memberof ScryptoInstant
     */
    date_time?: string;
}

/**
 * Check if a given object implements the ScryptoInstant interface.
 */
export function instanceOfScryptoInstant(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "unix_timestamp_seconds" in value;

    return isInstance;
}

export function ScryptoInstantFromJSON(json: any): ScryptoInstant {
    return ScryptoInstantFromJSONTyped(json, false);
}

export function ScryptoInstantFromJSONTyped(json: any, ignoreDiscriminator: boolean): ScryptoInstant {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'unix_timestamp_seconds': json['unix_timestamp_seconds'],
        'date_time': !exists(json, 'date_time') ? undefined : json['date_time'],
    };
}

export function ScryptoInstantToJSON(value?: ScryptoInstant | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'unix_timestamp_seconds': value.unix_timestamp_seconds,
        'date_time': value.date_time,
    };
}


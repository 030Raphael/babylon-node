/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.3.0
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
 * @interface MempoolTransactionResponsePayloadsInner
 */
export interface MempoolTransactionResponsePayloadsInner {
    /**
     * The hex-encoded notarized transaction hash for a user transaction.
     * This hash identifies the full submittable notarized transaction - ie the signed intent, plus the notary signature.
     * @type {string}
     * @memberof MempoolTransactionResponsePayloadsInner
     */
    hash: string;
    /**
     * The Bech32m-encoded human readable `NotarizedTransactionHash`.
     * @type {string}
     * @memberof MempoolTransactionResponsePayloadsInner
     */
    hash_bech32m: string;
    /**
     * The hex-encoded full notarized transaction payload - returned only if found in mempool.
     * @type {string}
     * @memberof MempoolTransactionResponsePayloadsInner
     */
    hex?: string;
    /**
     * Error message why `hex` field is missing: the transaction was not found in the mempool or the provided hash is invalid.
     * @type {string}
     * @memberof MempoolTransactionResponsePayloadsInner
     */
    error?: string;
}

/**
 * Check if a given object implements the MempoolTransactionResponsePayloadsInner interface.
 */
export function instanceOfMempoolTransactionResponsePayloadsInner(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "hash" in value;
    isInstance = isInstance && "hash_bech32m" in value;

    return isInstance;
}

export function MempoolTransactionResponsePayloadsInnerFromJSON(json: any): MempoolTransactionResponsePayloadsInner {
    return MempoolTransactionResponsePayloadsInnerFromJSONTyped(json, false);
}

export function MempoolTransactionResponsePayloadsInnerFromJSONTyped(json: any, ignoreDiscriminator: boolean): MempoolTransactionResponsePayloadsInner {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'hash': json['hash'],
        'hash_bech32m': json['hash_bech32m'],
        'hex': !exists(json, 'hex') ? undefined : json['hex'],
        'error': !exists(json, 'error') ? undefined : json['error'],
    };
}

export function MempoolTransactionResponsePayloadsInnerToJSON(value?: MempoolTransactionResponsePayloadsInner | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'hash': value.hash,
        'hash_bech32m': value.hash_bech32m,
        'hex': value.hex,
        'error': value.error,
    };
}


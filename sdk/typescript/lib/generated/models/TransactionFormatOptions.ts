/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
/**
 * Requested transaction formats to include in the response
 * @export
 * @interface TransactionFormatOptions
 */
export interface TransactionFormatOptions {
    /**
     * Whether to return the raw manifest (default true)
     * @type {boolean}
     * @memberof TransactionFormatOptions
     */
    manifest?: boolean;
    /**
     * Whether to return the hex-encoded blobs (default false)
     * @type {boolean}
     * @memberof TransactionFormatOptions
     */
    blobs?: boolean;
    /**
     * Whether to return the transaction message (default true)
     * @type {boolean}
     * @memberof TransactionFormatOptions
     */
    message?: boolean;
    /**
     * Whether to return the transaction balance changes (default false)
     * @type {boolean}
     * @memberof TransactionFormatOptions
     */
    balance_changes?: boolean;
    /**
     * Whether to return the raw hex-encoded system transaction bytes (default false)
     * @type {boolean}
     * @memberof TransactionFormatOptions
     */
    raw_system_transaction?: boolean;
    /**
     * Whether to return the raw hex-encoded notarized transaction bytes (default true)
     * @type {boolean}
     * @memberof TransactionFormatOptions
     */
    raw_notarized_transaction?: boolean;
    /**
     * Whether to return the raw hex-encoded ledger transaction bytes (default false)
     * @type {boolean}
     * @memberof TransactionFormatOptions
     */
    raw_ledger_transaction?: boolean;
}

/**
 * Check if a given object implements the TransactionFormatOptions interface.
 */
export function instanceOfTransactionFormatOptions(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function TransactionFormatOptionsFromJSON(json: any): TransactionFormatOptions {
    return TransactionFormatOptionsFromJSONTyped(json, false);
}

export function TransactionFormatOptionsFromJSONTyped(json: any, ignoreDiscriminator: boolean): TransactionFormatOptions {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'manifest': !exists(json, 'manifest') ? undefined : json['manifest'],
        'blobs': !exists(json, 'blobs') ? undefined : json['blobs'],
        'message': !exists(json, 'message') ? undefined : json['message'],
        'balance_changes': !exists(json, 'balance_changes') ? undefined : json['balance_changes'],
        'raw_system_transaction': !exists(json, 'raw_system_transaction') ? undefined : json['raw_system_transaction'],
        'raw_notarized_transaction': !exists(json, 'raw_notarized_transaction') ? undefined : json['raw_notarized_transaction'],
        'raw_ledger_transaction': !exists(json, 'raw_ledger_transaction') ? undefined : json['raw_ledger_transaction'],
    };
}

export function TransactionFormatOptionsToJSON(value?: TransactionFormatOptions | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'manifest': value.manifest,
        'blobs': value.blobs,
        'message': value.message,
        'balance_changes': value.balance_changes,
        'raw_system_transaction': value.raw_system_transaction,
        'raw_notarized_transaction': value.raw_notarized_transaction,
        'raw_ledger_transaction': value.raw_ledger_transaction,
    };
}


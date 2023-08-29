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
import type { TransactionPayloadStatus } from './TransactionPayloadStatus';
import {
    TransactionPayloadStatusFromJSON,
    TransactionPayloadStatusFromJSONTyped,
    TransactionPayloadStatusToJSON,
} from './TransactionPayloadStatus';

/**
 * 
 * @export
 * @interface TransactionPayloadDetails
 */
export interface TransactionPayloadDetails {
    /**
     * The hex-encoded notarized transaction hash for a user transaction.
     * This hash identifies the full submittable notarized transaction - ie the signed intent, plus the notary signature.
     * @type {string}
     * @memberof TransactionPayloadDetails
     */
    payload_hash: string;
    /**
     * The Bech32m-encoded human readable `NotarizedTransactionHash`.
     * @type {string}
     * @memberof TransactionPayloadDetails
     */
    payload_hash_bech32m: string;
    /**
     * 
     * @type {number}
     * @memberof TransactionPayloadDetails
     */
    state_version?: number;
    /**
     * 
     * @type {TransactionPayloadStatus}
     * @memberof TransactionPayloadDetails
     */
    status: TransactionPayloadStatus;
    /**
     * An explanation for the error, if failed or rejected
     * @type {string}
     * @memberof TransactionPayloadDetails
     */
    error_message?: string;
}

/**
 * Check if a given object implements the TransactionPayloadDetails interface.
 */
export function instanceOfTransactionPayloadDetails(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "payload_hash" in value;
    isInstance = isInstance && "payload_hash_bech32m" in value;
    isInstance = isInstance && "status" in value;

    return isInstance;
}

export function TransactionPayloadDetailsFromJSON(json: any): TransactionPayloadDetails {
    return TransactionPayloadDetailsFromJSONTyped(json, false);
}

export function TransactionPayloadDetailsFromJSONTyped(json: any, ignoreDiscriminator: boolean): TransactionPayloadDetails {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'payload_hash': json['payload_hash'],
        'payload_hash_bech32m': json['payload_hash_bech32m'],
        'state_version': !exists(json, 'state_version') ? undefined : json['state_version'],
        'status': TransactionPayloadStatusFromJSON(json['status']),
        'error_message': !exists(json, 'error_message') ? undefined : json['error_message'],
    };
}

export function TransactionPayloadDetailsToJSON(value?: TransactionPayloadDetails | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'payload_hash': value.payload_hash,
        'payload_hash_bech32m': value.payload_hash_bech32m,
        'state_version': value.state_version,
        'status': TransactionPayloadStatusToJSON(value.status),
        'error_message': value.error_message,
    };
}


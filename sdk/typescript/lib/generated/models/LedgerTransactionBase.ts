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
import type { LedgerTransactionType } from './LedgerTransactionType';
import {
    LedgerTransactionTypeFromJSON,
    LedgerTransactionTypeFromJSONTyped,
    LedgerTransactionTypeToJSON,
} from './LedgerTransactionType';

/**
 * 
 * @export
 * @interface LedgerTransactionBase
 */
export interface LedgerTransactionBase {
    /**
     * 
     * @type {LedgerTransactionType}
     * @memberof LedgerTransactionBase
     */
    type: LedgerTransactionType;
    /**
     * The hex-encoded full ledger transaction payload
     * @type {string}
     * @memberof LedgerTransactionBase
     */
    payload_hex: string;
}

/**
 * Check if a given object implements the LedgerTransactionBase interface.
 */
export function instanceOfLedgerTransactionBase(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "type" in value;
    isInstance = isInstance && "payload_hex" in value;

    return isInstance;
}

export function LedgerTransactionBaseFromJSON(json: any): LedgerTransactionBase {
    return LedgerTransactionBaseFromJSONTyped(json, false);
}

export function LedgerTransactionBaseFromJSONTyped(json: any, ignoreDiscriminator: boolean): LedgerTransactionBase {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'type': LedgerTransactionTypeFromJSON(json['type']),
        'payload_hex': json['payload_hex'],
    };
}

export function LedgerTransactionBaseToJSON(value?: LedgerTransactionBase | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'type': LedgerTransactionTypeToJSON(value.type),
        'payload_hex': value.payload_hex,
    };
}


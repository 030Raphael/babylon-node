/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon (Bottlenose)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.0
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
 * @interface StreamProofsErrorDetailsRequestedEpochOutOfBounds
 */
export interface StreamProofsErrorDetailsRequestedEpochOutOfBounds {
    /**
     * 
     * @type {string}
     * @memberof StreamProofsErrorDetailsRequestedEpochOutOfBounds
     */
    type: StreamProofsErrorDetailsRequestedEpochOutOfBoundsTypeEnum;
    /**
     * The maximum completed epoch committed to this node's ledger.
     * *Note on the bounds:* the requested `from_epoch` cannot be greater than
     * `max_ledger_epoch + 1`. Any greater requested value triggers this error.
     * @type {number}
     * @memberof StreamProofsErrorDetailsRequestedEpochOutOfBounds
     */
    max_ledger_epoch: number;
}


/**
 * @export
 */
export const StreamProofsErrorDetailsRequestedEpochOutOfBoundsTypeEnum = {
    RequestedEpochOutOfBounds: 'RequestedEpochOutOfBounds'
} as const;
export type StreamProofsErrorDetailsRequestedEpochOutOfBoundsTypeEnum = typeof StreamProofsErrorDetailsRequestedEpochOutOfBoundsTypeEnum[keyof typeof StreamProofsErrorDetailsRequestedEpochOutOfBoundsTypeEnum];


/**
 * Check if a given object implements the StreamProofsErrorDetailsRequestedEpochOutOfBounds interface.
 */
export function instanceOfStreamProofsErrorDetailsRequestedEpochOutOfBounds(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "type" in value;
    isInstance = isInstance && "max_ledger_epoch" in value;

    return isInstance;
}

export function StreamProofsErrorDetailsRequestedEpochOutOfBoundsFromJSON(json: any): StreamProofsErrorDetailsRequestedEpochOutOfBounds {
    return StreamProofsErrorDetailsRequestedEpochOutOfBoundsFromJSONTyped(json, false);
}

export function StreamProofsErrorDetailsRequestedEpochOutOfBoundsFromJSONTyped(json: any, ignoreDiscriminator: boolean): StreamProofsErrorDetailsRequestedEpochOutOfBounds {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'type': json['type'],
        'max_ledger_epoch': json['max_ledger_epoch'],
    };
}

export function StreamProofsErrorDetailsRequestedEpochOutOfBoundsToJSON(value?: StreamProofsErrorDetailsRequestedEpochOutOfBounds | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'type': value.type,
        'max_ledger_epoch': value.max_ledger_epoch,
    };
}


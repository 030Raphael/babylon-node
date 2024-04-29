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
import type { InstantMs } from './InstantMs';
import {
    InstantMsFromJSON,
    InstantMsFromJSONTyped,
    InstantMsToJSON,
} from './InstantMs';

/**
 * 
 * @export
 * @interface LtsTransactionConstructionResponse
 */
export interface LtsTransactionConstructionResponse {
    /**
     * An integer between `0` and `10^10`, marking the current epoch
     * @type {number}
     * @memberof LtsTransactionConstructionResponse
     */
    current_epoch: number;
    /**
     * 
     * @type {InstantMs}
     * @memberof LtsTransactionConstructionResponse
     */
    ledger_clock: InstantMs;
}

/**
 * Check if a given object implements the LtsTransactionConstructionResponse interface.
 */
export function instanceOfLtsTransactionConstructionResponse(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "current_epoch" in value;
    isInstance = isInstance && "ledger_clock" in value;

    return isInstance;
}

export function LtsTransactionConstructionResponseFromJSON(json: any): LtsTransactionConstructionResponse {
    return LtsTransactionConstructionResponseFromJSONTyped(json, false);
}

export function LtsTransactionConstructionResponseFromJSONTyped(json: any, ignoreDiscriminator: boolean): LtsTransactionConstructionResponse {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'current_epoch': json['current_epoch'],
        'ledger_clock': InstantMsFromJSON(json['ledger_clock']),
    };
}

export function LtsTransactionConstructionResponseToJSON(value?: LtsTransactionConstructionResponse | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'current_epoch': value.current_epoch,
        'ledger_clock': InstantMsToJSON(value.ledger_clock),
    };
}


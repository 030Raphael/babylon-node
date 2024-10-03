/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.4
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { LtsCommittedTransactionOutcome } from './LtsCommittedTransactionOutcome';
import {
    LtsCommittedTransactionOutcomeFromJSON,
    LtsCommittedTransactionOutcomeFromJSONTyped,
    LtsCommittedTransactionOutcomeToJSON,
} from './LtsCommittedTransactionOutcome';

/**
 * 
 * @export
 * @interface LtsStreamAccountTransactionOutcomesResponse
 */
export interface LtsStreamAccountTransactionOutcomesResponse {
    /**
     * 
     * @type {number}
     * @memberof LtsStreamAccountTransactionOutcomesResponse
     */
    from_state_version: number;
    /**
     * An integer between `0` and `10000`, giving the total count of transactions in the returned response
     * @type {number}
     * @memberof LtsStreamAccountTransactionOutcomesResponse
     */
    count: number;
    /**
     * 
     * @type {number}
     * @memberof LtsStreamAccountTransactionOutcomesResponse
     */
    max_ledger_state_version: number;
    /**
     * A committed transaction outcomes list starting from the `from_state_version` (inclusive).
     * @type {Array<LtsCommittedTransactionOutcome>}
     * @memberof LtsStreamAccountTransactionOutcomesResponse
     */
    committed_transaction_outcomes: Array<LtsCommittedTransactionOutcome>;
}

/**
 * Check if a given object implements the LtsStreamAccountTransactionOutcomesResponse interface.
 */
export function instanceOfLtsStreamAccountTransactionOutcomesResponse(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "from_state_version" in value;
    isInstance = isInstance && "count" in value;
    isInstance = isInstance && "max_ledger_state_version" in value;
    isInstance = isInstance && "committed_transaction_outcomes" in value;

    return isInstance;
}

export function LtsStreamAccountTransactionOutcomesResponseFromJSON(json: any): LtsStreamAccountTransactionOutcomesResponse {
    return LtsStreamAccountTransactionOutcomesResponseFromJSONTyped(json, false);
}

export function LtsStreamAccountTransactionOutcomesResponseFromJSONTyped(json: any, ignoreDiscriminator: boolean): LtsStreamAccountTransactionOutcomesResponse {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'from_state_version': json['from_state_version'],
        'count': json['count'],
        'max_ledger_state_version': json['max_ledger_state_version'],
        'committed_transaction_outcomes': ((json['committed_transaction_outcomes'] as Array<any>).map(LtsCommittedTransactionOutcomeFromJSON)),
    };
}

export function LtsStreamAccountTransactionOutcomesResponseToJSON(value?: LtsStreamAccountTransactionOutcomesResponse | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'from_state_version': value.from_state_version,
        'count': value.count,
        'max_ledger_state_version': value.max_ledger_state_version,
        'committed_transaction_outcomes': ((value.committed_transaction_outcomes as Array<any>).map(LtsCommittedTransactionOutcomeToJSON)),
    };
}


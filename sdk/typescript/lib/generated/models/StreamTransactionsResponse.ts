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
import type { CommittedStateIdentifier } from './CommittedStateIdentifier';
import {
    CommittedStateIdentifierFromJSON,
    CommittedStateIdentifierFromJSONTyped,
    CommittedStateIdentifierToJSON,
} from './CommittedStateIdentifier';
import type { CommittedTransaction } from './CommittedTransaction';
import {
    CommittedTransactionFromJSON,
    CommittedTransactionFromJSONTyped,
    CommittedTransactionToJSON,
} from './CommittedTransaction';
import type { LedgerProof } from './LedgerProof';
import {
    LedgerProofFromJSON,
    LedgerProofFromJSONTyped,
    LedgerProofToJSON,
} from './LedgerProof';

/**
 * 
 * @export
 * @interface StreamTransactionsResponse
 */
export interface StreamTransactionsResponse {
    /**
     * 
     * @type {CommittedStateIdentifier}
     * @memberof StreamTransactionsResponse
     */
    previous_state_identifiers?: CommittedStateIdentifier;
    /**
     * 
     * @type {number}
     * @memberof StreamTransactionsResponse
     */
    from_state_version: number;
    /**
     * An integer between `0` and `10000`, giving the total count of transactions in the returned response
     * @type {number}
     * @memberof StreamTransactionsResponse
     */
    count: number;
    /**
     * 
     * @type {number}
     * @memberof StreamTransactionsResponse
     */
    max_ledger_state_version: number;
    /**
     * A committed transactions list starting from the `from_state_version` (inclusive).
     * @type {Array<CommittedTransaction>}
     * @memberof StreamTransactionsResponse
     */
    transactions: Array<CommittedTransaction>;
    /**
     * A ledger proof list starting from `from_state_version` (inclusive) stored by this node.
     * @type {Array<LedgerProof>}
     * @memberof StreamTransactionsResponse
     */
    proofs?: Array<LedgerProof>;
}

/**
 * Check if a given object implements the StreamTransactionsResponse interface.
 */
export function instanceOfStreamTransactionsResponse(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "from_state_version" in value;
    isInstance = isInstance && "count" in value;
    isInstance = isInstance && "max_ledger_state_version" in value;
    isInstance = isInstance && "transactions" in value;

    return isInstance;
}

export function StreamTransactionsResponseFromJSON(json: any): StreamTransactionsResponse {
    return StreamTransactionsResponseFromJSONTyped(json, false);
}

export function StreamTransactionsResponseFromJSONTyped(json: any, ignoreDiscriminator: boolean): StreamTransactionsResponse {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'previous_state_identifiers': !exists(json, 'previous_state_identifiers') ? undefined : CommittedStateIdentifierFromJSON(json['previous_state_identifiers']),
        'from_state_version': json['from_state_version'],
        'count': json['count'],
        'max_ledger_state_version': json['max_ledger_state_version'],
        'transactions': ((json['transactions'] as Array<any>).map(CommittedTransactionFromJSON)),
        'proofs': !exists(json, 'proofs') ? undefined : ((json['proofs'] as Array<any>).map(LedgerProofFromJSON)),
    };
}

export function StreamTransactionsResponseToJSON(value?: StreamTransactionsResponse | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'previous_state_identifiers': CommittedStateIdentifierToJSON(value.previous_state_identifiers),
        'from_state_version': value.from_state_version,
        'count': value.count,
        'max_ledger_state_version': value.max_ledger_state_version,
        'transactions': ((value.transactions as Array<any>).map(CommittedTransactionToJSON)),
        'proofs': value.proofs === undefined ? undefined : ((value.proofs as Array<any>).map(LedgerProofToJSON)),
    };
}


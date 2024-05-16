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
import type { CommittedTransactionBalanceChanges } from './CommittedTransactionBalanceChanges';
import {
    CommittedTransactionBalanceChangesFromJSON,
    CommittedTransactionBalanceChangesFromJSONTyped,
    CommittedTransactionBalanceChangesToJSON,
} from './CommittedTransactionBalanceChanges';
import type { LedgerTransaction } from './LedgerTransaction';
import {
    LedgerTransactionFromJSON,
    LedgerTransactionFromJSONTyped,
    LedgerTransactionToJSON,
} from './LedgerTransaction';
import type { TransactionReceipt } from './TransactionReceipt';
import {
    TransactionReceiptFromJSON,
    TransactionReceiptFromJSONTyped,
    TransactionReceiptToJSON,
} from './TransactionReceipt';

/**
 * 
 * @export
 * @interface CommittedTransaction
 */
export interface CommittedTransaction {
    /**
     * 
     * @type {CommittedStateIdentifier}
     * @memberof CommittedTransaction
     */
    resultant_state_identifiers: CommittedStateIdentifier;
    /**
     * 
     * @type {LedgerTransaction}
     * @memberof CommittedTransaction
     */
    ledger_transaction: LedgerTransaction;
    /**
     * 
     * @type {TransactionReceipt}
     * @memberof CommittedTransaction
     */
    receipt: TransactionReceipt;
    /**
     * 
     * @type {CommittedTransactionBalanceChanges}
     * @memberof CommittedTransaction
     */
    balance_changes?: CommittedTransactionBalanceChanges;
    /**
     * An integer between `0` and `10^14`, marking the proposer timestamp in ms.
     * @type {number}
     * @memberof CommittedTransaction
     */
    proposer_timestamp_ms: number;
}

/**
 * Check if a given object implements the CommittedTransaction interface.
 */
export function instanceOfCommittedTransaction(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "resultant_state_identifiers" in value;
    isInstance = isInstance && "ledger_transaction" in value;
    isInstance = isInstance && "receipt" in value;
    isInstance = isInstance && "proposer_timestamp_ms" in value;

    return isInstance;
}

export function CommittedTransactionFromJSON(json: any): CommittedTransaction {
    return CommittedTransactionFromJSONTyped(json, false);
}

export function CommittedTransactionFromJSONTyped(json: any, ignoreDiscriminator: boolean): CommittedTransaction {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'resultant_state_identifiers': CommittedStateIdentifierFromJSON(json['resultant_state_identifiers']),
        'ledger_transaction': LedgerTransactionFromJSON(json['ledger_transaction']),
        'receipt': TransactionReceiptFromJSON(json['receipt']),
        'balance_changes': !exists(json, 'balance_changes') ? undefined : CommittedTransactionBalanceChangesFromJSON(json['balance_changes']),
        'proposer_timestamp_ms': json['proposer_timestamp_ms'],
    };
}

export function CommittedTransactionToJSON(value?: CommittedTransaction | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'resultant_state_identifiers': CommittedStateIdentifierToJSON(value.resultant_state_identifiers),
        'ledger_transaction': LedgerTransactionToJSON(value.ledger_transaction),
        'receipt': TransactionReceiptToJSON(value.receipt),
        'balance_changes': CommittedTransactionBalanceChangesToJSON(value.balance_changes),
        'proposer_timestamp_ms': value.proposer_timestamp_ms,
    };
}


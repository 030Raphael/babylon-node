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
import type { InstructionResourceChanges } from './InstructionResourceChanges';
import {
    InstructionResourceChangesFromJSON,
    InstructionResourceChangesFromJSONTyped,
    InstructionResourceChangesToJSON,
} from './InstructionResourceChanges';
import type { LedgerStateSummary } from './LedgerStateSummary';
import {
    LedgerStateSummaryFromJSON,
    LedgerStateSummaryFromJSONTyped,
    LedgerStateSummaryToJSON,
} from './LedgerStateSummary';
import type { TransactionPreviewResponseLogsInner } from './TransactionPreviewResponseLogsInner';
import {
    TransactionPreviewResponseLogsInnerFromJSON,
    TransactionPreviewResponseLogsInnerFromJSONTyped,
    TransactionPreviewResponseLogsInnerToJSON,
} from './TransactionPreviewResponseLogsInner';
import type { TransactionReceipt } from './TransactionReceipt';
import {
    TransactionReceiptFromJSON,
    TransactionReceiptFromJSONTyped,
    TransactionReceiptToJSON,
} from './TransactionReceipt';

/**
 * 
 * @export
 * @interface TransactionPreviewResponse
 */
export interface TransactionPreviewResponse {
    /**
     * 
     * @type {LedgerStateSummary}
     * @memberof TransactionPreviewResponse
     */
    at_ledger_state: LedgerStateSummary;
    /**
     * The hex-sbor-encoded receipt.
     * 
     * This field is deprecated and will be removed from the API with the release of the next 
     * protocol update, cuttlefish. This field was provided primarily for use with the Radix 
     * Engine Toolkit and its execution summary functionality. If you still wish to use this 
     * functionality update your Radix Engine Toolkit and use the receipt provided in the 
     * `radix_engine_toolkit_receipt` field of this response.
     * @type {string}
     * @memberof TransactionPreviewResponse
     * @deprecated
     */
    encoded_receipt: string;
    /**
     * 
     * @type {TransactionReceipt}
     * @memberof TransactionPreviewResponse
     */
    receipt: TransactionReceipt;
    /**
     * An optional field which is only provided if the `radix_engine_toolkit_receipt`
     * flag is set to true when requesting a transaction preview from the API.
     * 
     * This receipt is primarily intended for use with the toolkit and may contain information 
     * that is already available in the receipt provided in the `receipt` field of this 
     * response.
     * 
     * A typical client of this API is not expected to use this receipt. The primary clients 
     * this receipt is intended for is the Radix wallet or any client that needs to perform 
     * execution summaries on their transactions.
     * @type {object}
     * @memberof TransactionPreviewResponse
     */
    radix_engine_toolkit_receipt?: object;
    /**
     * 
     * @type {Array<InstructionResourceChanges>}
     * @memberof TransactionPreviewResponse
     */
    instruction_resource_changes: Array<InstructionResourceChanges>;
    /**
     * 
     * @type {Array<TransactionPreviewResponseLogsInner>}
     * @memberof TransactionPreviewResponse
     */
    logs: Array<TransactionPreviewResponseLogsInner>;
}

/**
 * Check if a given object implements the TransactionPreviewResponse interface.
 */
export function instanceOfTransactionPreviewResponse(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "at_ledger_state" in value;
    isInstance = isInstance && "encoded_receipt" in value;
    isInstance = isInstance && "receipt" in value;
    isInstance = isInstance && "instruction_resource_changes" in value;
    isInstance = isInstance && "logs" in value;

    return isInstance;
}

export function TransactionPreviewResponseFromJSON(json: any): TransactionPreviewResponse {
    return TransactionPreviewResponseFromJSONTyped(json, false);
}

export function TransactionPreviewResponseFromJSONTyped(json: any, ignoreDiscriminator: boolean): TransactionPreviewResponse {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'at_ledger_state': LedgerStateSummaryFromJSON(json['at_ledger_state']),
        'encoded_receipt': json['encoded_receipt'],
        'receipt': TransactionReceiptFromJSON(json['receipt']),
        'radix_engine_toolkit_receipt': !exists(json, 'radix_engine_toolkit_receipt') ? undefined : json['radix_engine_toolkit_receipt'],
        'instruction_resource_changes': ((json['instruction_resource_changes'] as Array<any>).map(InstructionResourceChangesFromJSON)),
        'logs': ((json['logs'] as Array<any>).map(TransactionPreviewResponseLogsInnerFromJSON)),
    };
}

export function TransactionPreviewResponseToJSON(value?: TransactionPreviewResponse | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'at_ledger_state': LedgerStateSummaryToJSON(value.at_ledger_state),
        'encoded_receipt': value.encoded_receipt,
        'receipt': TransactionReceiptToJSON(value.receipt),
        'radix_engine_toolkit_receipt': value.radix_engine_toolkit_receipt,
        'instruction_resource_changes': ((value.instruction_resource_changes as Array<any>).map(InstructionResourceChangesToJSON)),
        'logs': ((value.logs as Array<any>).map(TransactionPreviewResponseLogsInnerToJSON)),
    };
}


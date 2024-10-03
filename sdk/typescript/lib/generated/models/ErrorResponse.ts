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

import {
    BasicErrorResponse,
    instanceOfBasicErrorResponse,
    BasicErrorResponseFromJSON,
    BasicErrorResponseFromJSONTyped,
    BasicErrorResponseToJSON,
} from './BasicErrorResponse';
import {
    LtsTransactionSubmitErrorResponse,
    instanceOfLtsTransactionSubmitErrorResponse,
    LtsTransactionSubmitErrorResponseFromJSON,
    LtsTransactionSubmitErrorResponseFromJSONTyped,
    LtsTransactionSubmitErrorResponseToJSON,
} from './LtsTransactionSubmitErrorResponse';
import {
    StreamProofsErrorResponse,
    instanceOfStreamProofsErrorResponse,
    StreamProofsErrorResponseFromJSON,
    StreamProofsErrorResponseFromJSONTyped,
    StreamProofsErrorResponseToJSON,
} from './StreamProofsErrorResponse';
import {
    StreamTransactionsErrorResponse,
    instanceOfStreamTransactionsErrorResponse,
    StreamTransactionsErrorResponseFromJSON,
    StreamTransactionsErrorResponseFromJSONTyped,
    StreamTransactionsErrorResponseToJSON,
} from './StreamTransactionsErrorResponse';
import {
    TransactionSubmitErrorResponse,
    instanceOfTransactionSubmitErrorResponse,
    TransactionSubmitErrorResponseFromJSON,
    TransactionSubmitErrorResponseFromJSONTyped,
    TransactionSubmitErrorResponseToJSON,
} from './TransactionSubmitErrorResponse';

/**
 * @type ErrorResponse
 * 
 * @export
 */
export type ErrorResponse = { error_type: 'Basic' } & BasicErrorResponse | { error_type: 'LtsTransactionSubmit' } & LtsTransactionSubmitErrorResponse | { error_type: 'StreamProofs' } & StreamProofsErrorResponse | { error_type: 'StreamTransactions' } & StreamTransactionsErrorResponse | { error_type: 'TransactionSubmit' } & TransactionSubmitErrorResponse;

export function ErrorResponseFromJSON(json: any): ErrorResponse {
    return ErrorResponseFromJSONTyped(json, false);
}

export function ErrorResponseFromJSONTyped(json: any, ignoreDiscriminator: boolean): ErrorResponse {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    switch (json['error_type']) {
        case 'Basic':
            return {...BasicErrorResponseFromJSONTyped(json, true), error_type: 'Basic'};
        case 'LtsTransactionSubmit':
            return {...LtsTransactionSubmitErrorResponseFromJSONTyped(json, true), error_type: 'LtsTransactionSubmit'};
        case 'StreamProofs':
            return {...StreamProofsErrorResponseFromJSONTyped(json, true), error_type: 'StreamProofs'};
        case 'StreamTransactions':
            return {...StreamTransactionsErrorResponseFromJSONTyped(json, true), error_type: 'StreamTransactions'};
        case 'TransactionSubmit':
            return {...TransactionSubmitErrorResponseFromJSONTyped(json, true), error_type: 'TransactionSubmit'};
        default:
            throw new Error(`No variant of ErrorResponse exists with 'error_type=${json['error_type']}'`);
    }
}

export function ErrorResponseToJSON(value?: ErrorResponse | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    switch (value['error_type']) {
        case 'Basic':
            return BasicErrorResponseToJSON(value);
        case 'LtsTransactionSubmit':
            return LtsTransactionSubmitErrorResponseToJSON(value);
        case 'StreamProofs':
            return StreamProofsErrorResponseToJSON(value);
        case 'StreamTransactions':
            return StreamTransactionsErrorResponseToJSON(value);
        case 'TransactionSubmit':
            return TransactionSubmitErrorResponseToJSON(value);
        default:
            throw new Error(`No variant of ErrorResponse exists with 'error_type=${value['error_type']}'`);
    }

}


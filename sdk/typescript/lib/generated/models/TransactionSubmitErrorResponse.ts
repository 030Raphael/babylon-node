/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon (Anemone)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { TransactionSubmitErrorDetails } from './TransactionSubmitErrorDetails';
import {
    TransactionSubmitErrorDetailsFromJSON,
    TransactionSubmitErrorDetailsFromJSONTyped,
    TransactionSubmitErrorDetailsToJSON,
} from './TransactionSubmitErrorDetails';

/**
 * 
 * @export
 * @interface TransactionSubmitErrorResponse
 */
export interface TransactionSubmitErrorResponse {
    /**
     * 
     * @type {string}
     * @memberof TransactionSubmitErrorResponse
     */
    error_type: TransactionSubmitErrorResponseErrorTypeEnum;
    /**
     * A numeric code corresponding to the given HTTP error code.
     * @type {number}
     * @memberof TransactionSubmitErrorResponse
     */
    code: number;
    /**
     * A human-readable error message.
     * @type {string}
     * @memberof TransactionSubmitErrorResponse
     */
    message: string;
    /**
     * A GUID to be used when reporting errors, to allow correlation with the Core API's error logs, in the case where the Core API details are hidden.
     * @type {string}
     * @memberof TransactionSubmitErrorResponse
     */
    trace_id?: string;
    /**
     * 
     * @type {TransactionSubmitErrorDetails}
     * @memberof TransactionSubmitErrorResponse
     */
    details?: TransactionSubmitErrorDetails;
}


/**
 * @export
 */
export const TransactionSubmitErrorResponseErrorTypeEnum = {
    TransactionSubmit: 'TransactionSubmit'
} as const;
export type TransactionSubmitErrorResponseErrorTypeEnum = typeof TransactionSubmitErrorResponseErrorTypeEnum[keyof typeof TransactionSubmitErrorResponseErrorTypeEnum];


/**
 * Check if a given object implements the TransactionSubmitErrorResponse interface.
 */
export function instanceOfTransactionSubmitErrorResponse(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "error_type" in value;
    isInstance = isInstance && "code" in value;
    isInstance = isInstance && "message" in value;

    return isInstance;
}

export function TransactionSubmitErrorResponseFromJSON(json: any): TransactionSubmitErrorResponse {
    return TransactionSubmitErrorResponseFromJSONTyped(json, false);
}

export function TransactionSubmitErrorResponseFromJSONTyped(json: any, ignoreDiscriminator: boolean): TransactionSubmitErrorResponse {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'error_type': json['error_type'],
        'code': json['code'],
        'message': json['message'],
        'trace_id': !exists(json, 'trace_id') ? undefined : json['trace_id'],
        'details': !exists(json, 'details') ? undefined : TransactionSubmitErrorDetailsFromJSON(json['details']),
    };
}

export function TransactionSubmitErrorResponseToJSON(value?: TransactionSubmitErrorResponse | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'error_type': value.error_type,
        'code': value.code,
        'message': value.message,
        'trace_id': value.trace_id,
        'details': TransactionSubmitErrorDetailsToJSON(value.details),
    };
}


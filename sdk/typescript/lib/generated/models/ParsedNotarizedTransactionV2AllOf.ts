/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.3.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { NotarizedTransactionV2 } from './NotarizedTransactionV2';
import {
    NotarizedTransactionV2FromJSON,
    NotarizedTransactionV2FromJSONTyped,
    NotarizedTransactionV2ToJSON,
} from './NotarizedTransactionV2';
import type { ParsedNotarizedTransactionAllOfValidationError } from './ParsedNotarizedTransactionAllOfValidationError';
import {
    ParsedNotarizedTransactionAllOfValidationErrorFromJSON,
    ParsedNotarizedTransactionAllOfValidationErrorFromJSONTyped,
    ParsedNotarizedTransactionAllOfValidationErrorToJSON,
} from './ParsedNotarizedTransactionAllOfValidationError';
import type { ParsedNotarizedTransactionIdentifiers } from './ParsedNotarizedTransactionIdentifiers';
import {
    ParsedNotarizedTransactionIdentifiersFromJSON,
    ParsedNotarizedTransactionIdentifiersFromJSONTyped,
    ParsedNotarizedTransactionIdentifiersToJSON,
} from './ParsedNotarizedTransactionIdentifiers';

/**
 * 
 * @export
 * @interface ParsedNotarizedTransactionV2AllOf
 */
export interface ParsedNotarizedTransactionV2AllOf {
    /**
     * 
     * @type {NotarizedTransactionV2}
     * @memberof ParsedNotarizedTransactionV2AllOf
     */
    notarized_transaction?: NotarizedTransactionV2;
    /**
     * 
     * @type {ParsedNotarizedTransactionIdentifiers}
     * @memberof ParsedNotarizedTransactionV2AllOf
     */
    identifiers: ParsedNotarizedTransactionIdentifiers;
    /**
     * 
     * @type {ParsedNotarizedTransactionAllOfValidationError}
     * @memberof ParsedNotarizedTransactionV2AllOf
     */
    validation_error?: ParsedNotarizedTransactionAllOfValidationError;
    /**
     * 
     * @type {string}
     * @memberof ParsedNotarizedTransactionV2AllOf
     */
    type?: ParsedNotarizedTransactionV2AllOfTypeEnum;
}


/**
 * @export
 */
export const ParsedNotarizedTransactionV2AllOfTypeEnum = {
    NotarizedTransactionV2: 'NotarizedTransactionV2'
} as const;
export type ParsedNotarizedTransactionV2AllOfTypeEnum = typeof ParsedNotarizedTransactionV2AllOfTypeEnum[keyof typeof ParsedNotarizedTransactionV2AllOfTypeEnum];


/**
 * Check if a given object implements the ParsedNotarizedTransactionV2AllOf interface.
 */
export function instanceOfParsedNotarizedTransactionV2AllOf(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "identifiers" in value;

    return isInstance;
}

export function ParsedNotarizedTransactionV2AllOfFromJSON(json: any): ParsedNotarizedTransactionV2AllOf {
    return ParsedNotarizedTransactionV2AllOfFromJSONTyped(json, false);
}

export function ParsedNotarizedTransactionV2AllOfFromJSONTyped(json: any, ignoreDiscriminator: boolean): ParsedNotarizedTransactionV2AllOf {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'notarized_transaction': !exists(json, 'notarized_transaction') ? undefined : NotarizedTransactionV2FromJSON(json['notarized_transaction']),
        'identifiers': ParsedNotarizedTransactionIdentifiersFromJSON(json['identifiers']),
        'validation_error': !exists(json, 'validation_error') ? undefined : ParsedNotarizedTransactionAllOfValidationErrorFromJSON(json['validation_error']),
        'type': !exists(json, 'type') ? undefined : json['type'],
    };
}

export function ParsedNotarizedTransactionV2AllOfToJSON(value?: ParsedNotarizedTransactionV2AllOf | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'notarized_transaction': NotarizedTransactionV2ToJSON(value.notarized_transaction),
        'identifiers': ParsedNotarizedTransactionIdentifiersToJSON(value.identifiers),
        'validation_error': ParsedNotarizedTransactionAllOfValidationErrorToJSON(value.validation_error),
        'type': value.type,
    };
}


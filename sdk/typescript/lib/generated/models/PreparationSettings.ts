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
/**
 * 
 * @export
 * @interface PreparationSettings
 */
export interface PreparationSettings {
    /**
     * 
     * @type {boolean}
     * @memberof PreparationSettings
     */
    v2_transactions_permitted: boolean;
    /**
     * 
     * @type {string}
     * @memberof PreparationSettings
     */
    max_user_payload_length: string;
    /**
     * 
     * @type {string}
     * @memberof PreparationSettings
     */
    max_ledger_payload_length: string;
    /**
     * 
     * @type {string}
     * @memberof PreparationSettings
     */
    max_child_subintents_per_intent: string;
    /**
     * 
     * @type {string}
     * @memberof PreparationSettings
     */
    max_subintents_per_transaction: string;
    /**
     * 
     * @type {string}
     * @memberof PreparationSettings
     */
    max_blobs: string;
}

/**
 * Check if a given object implements the PreparationSettings interface.
 */
export function instanceOfPreparationSettings(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "v2_transactions_permitted" in value;
    isInstance = isInstance && "max_user_payload_length" in value;
    isInstance = isInstance && "max_ledger_payload_length" in value;
    isInstance = isInstance && "max_child_subintents_per_intent" in value;
    isInstance = isInstance && "max_subintents_per_transaction" in value;
    isInstance = isInstance && "max_blobs" in value;

    return isInstance;
}

export function PreparationSettingsFromJSON(json: any): PreparationSettings {
    return PreparationSettingsFromJSONTyped(json, false);
}

export function PreparationSettingsFromJSONTyped(json: any, ignoreDiscriminator: boolean): PreparationSettings {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'v2_transactions_permitted': json['v2_transactions_permitted'],
        'max_user_payload_length': json['max_user_payload_length'],
        'max_ledger_payload_length': json['max_ledger_payload_length'],
        'max_child_subintents_per_intent': json['max_child_subintents_per_intent'],
        'max_subintents_per_transaction': json['max_subintents_per_transaction'],
        'max_blobs': json['max_blobs'],
    };
}

export function PreparationSettingsToJSON(value?: PreparationSettings | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'v2_transactions_permitted': value.v2_transactions_permitted,
        'max_user_payload_length': value.max_user_payload_length,
        'max_ledger_payload_length': value.max_ledger_payload_length,
        'max_child_subintents_per_intent': value.max_child_subintents_per_intent,
        'max_subintents_per_transaction': value.max_subintents_per_transaction,
        'max_blobs': value.max_blobs,
    };
}


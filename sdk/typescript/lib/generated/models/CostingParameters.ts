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
/**
 * 
 * @export
 * @interface CostingParameters
 */
export interface CostingParameters {
    /**
     * The string-encoded decimal representing the XRD price of a single cost unit of transaction execution.
     * A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`.
     * @type {string}
     * @memberof CostingParameters
     */
    execution_cost_unit_price: string;
    /**
     * An integer between `0` and `2^32 - 1`, representing the maximum amount of cost units available for the transaction execution.
     * @type {number}
     * @memberof CostingParameters
     */
    execution_cost_unit_limit: number;
    /**
     * An integer between `0` and `2^32 - 1`, representing the maximum number of cost units which can be used before fee is locked from a vault.
     * @type {number}
     * @memberof CostingParameters
     */
    execution_cost_unit_loan: number;
    /**
     * The string-encoded decimal representing the XRD price of a single cost unit of transaction finalization.
     * A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`.
     * @type {string}
     * @memberof CostingParameters
     */
    finalization_cost_unit_price: string;
    /**
     * An integer between `0` and `2^32 - 1`, representing the maximum amount of cost units available for the transaction finalization.
     * @type {number}
     * @memberof CostingParameters
     */
    finalization_cost_unit_limit: number;
    /**
     * The string-encoded decimal representing what amount of XRD is consumed by a Royalty of 1 USD.
     * This is fixed for a given protocol version, so is not an accurate representation of the XRD price.
     * A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`.
     * @type {string}
     * @memberof CostingParameters
     */
    xrd_usd_price: string;
    /**
     * The string-encoded decimal representing the price of 1 byte of state storage, expressed in XRD.
     * A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`.
     * @type {string}
     * @memberof CostingParameters
     */
    xrd_storage_price: string;
    /**
     * The string-encoded decimal representing the price of 1 byte of archive storage, expressed in XRD.
     * A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`.
     * @type {string}
     * @memberof CostingParameters
     */
    xrd_archive_storage_price: string;
    /**
     * An integer between `0` and `65535`, giving the validator tip as a percentage amount. A value of `1` corresponds to 1% of the fee.
     * @type {number}
     * @memberof CostingParameters
     */
    tip_percentage: number;
}

/**
 * Check if a given object implements the CostingParameters interface.
 */
export function instanceOfCostingParameters(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "execution_cost_unit_price" in value;
    isInstance = isInstance && "execution_cost_unit_limit" in value;
    isInstance = isInstance && "execution_cost_unit_loan" in value;
    isInstance = isInstance && "finalization_cost_unit_price" in value;
    isInstance = isInstance && "finalization_cost_unit_limit" in value;
    isInstance = isInstance && "xrd_usd_price" in value;
    isInstance = isInstance && "xrd_storage_price" in value;
    isInstance = isInstance && "xrd_archive_storage_price" in value;
    isInstance = isInstance && "tip_percentage" in value;

    return isInstance;
}

export function CostingParametersFromJSON(json: any): CostingParameters {
    return CostingParametersFromJSONTyped(json, false);
}

export function CostingParametersFromJSONTyped(json: any, ignoreDiscriminator: boolean): CostingParameters {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'execution_cost_unit_price': json['execution_cost_unit_price'],
        'execution_cost_unit_limit': json['execution_cost_unit_limit'],
        'execution_cost_unit_loan': json['execution_cost_unit_loan'],
        'finalization_cost_unit_price': json['finalization_cost_unit_price'],
        'finalization_cost_unit_limit': json['finalization_cost_unit_limit'],
        'xrd_usd_price': json['xrd_usd_price'],
        'xrd_storage_price': json['xrd_storage_price'],
        'xrd_archive_storage_price': json['xrd_archive_storage_price'],
        'tip_percentage': json['tip_percentage'],
    };
}

export function CostingParametersToJSON(value?: CostingParameters | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'execution_cost_unit_price': value.execution_cost_unit_price,
        'execution_cost_unit_limit': value.execution_cost_unit_limit,
        'execution_cost_unit_loan': value.execution_cost_unit_loan,
        'finalization_cost_unit_price': value.finalization_cost_unit_price,
        'finalization_cost_unit_limit': value.finalization_cost_unit_limit,
        'xrd_usd_price': value.xrd_usd_price,
        'xrd_storage_price': value.xrd_storage_price,
        'xrd_archive_storage_price': value.xrd_archive_storage_price,
        'tip_percentage': value.tip_percentage,
    };
}


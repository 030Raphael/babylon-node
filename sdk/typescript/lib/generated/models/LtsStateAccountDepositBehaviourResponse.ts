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
import type { DefaultDepositRule } from './DefaultDepositRule';
import {
    DefaultDepositRuleFromJSON,
    DefaultDepositRuleFromJSONTyped,
    DefaultDepositRuleToJSON,
} from './DefaultDepositRule';
import type { LedgerHeaderSummary } from './LedgerHeaderSummary';
import {
    LedgerHeaderSummaryFromJSON,
    LedgerHeaderSummaryFromJSONTyped,
    LedgerHeaderSummaryToJSON,
} from './LedgerHeaderSummary';
import type { ResourceSpecificDepositBehaviour } from './ResourceSpecificDepositBehaviour';
import {
    ResourceSpecificDepositBehaviourFromJSON,
    ResourceSpecificDepositBehaviourFromJSONTyped,
    ResourceSpecificDepositBehaviourToJSON,
} from './ResourceSpecificDepositBehaviour';

/**
 * 
 * @export
 * @interface LtsStateAccountDepositBehaviourResponse
 */
export interface LtsStateAccountDepositBehaviourResponse {
    /**
     * 
     * @type {number}
     * @memberof LtsStateAccountDepositBehaviourResponse
     */
    state_version: number;
    /**
     * 
     * @type {LedgerHeaderSummary}
     * @memberof LtsStateAccountDepositBehaviourResponse
     */
    ledger_header_summary: LedgerHeaderSummary;
    /**
     * 
     * @type {DefaultDepositRule}
     * @memberof LtsStateAccountDepositBehaviourResponse
     */
    default_deposit_rule: DefaultDepositRule;
    /**
     * Whether the input `badge` belongs to the account's set of authorized depositors.
     * This field will only be present if any badge was passed in the request.
     * @type {boolean}
     * @memberof LtsStateAccountDepositBehaviourResponse
     */
    is_badge_authorized_depositor?: boolean;
    /**
     * A map from one of the input `resource_addresses` to its specific deposit behavior configured for this account.
     * This field will only be present if an array of specific resource addresses was passed in the request (even if empty).
     * @type {{ [key: string]: ResourceSpecificDepositBehaviour; }}
     * @memberof LtsStateAccountDepositBehaviourResponse
     */
    resource_specific_behaviours?: { [key: string]: ResourceSpecificDepositBehaviour; };
}

/**
 * Check if a given object implements the LtsStateAccountDepositBehaviourResponse interface.
 */
export function instanceOfLtsStateAccountDepositBehaviourResponse(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "state_version" in value;
    isInstance = isInstance && "ledger_header_summary" in value;
    isInstance = isInstance && "default_deposit_rule" in value;

    return isInstance;
}

export function LtsStateAccountDepositBehaviourResponseFromJSON(json: any): LtsStateAccountDepositBehaviourResponse {
    return LtsStateAccountDepositBehaviourResponseFromJSONTyped(json, false);
}

export function LtsStateAccountDepositBehaviourResponseFromJSONTyped(json: any, ignoreDiscriminator: boolean): LtsStateAccountDepositBehaviourResponse {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'state_version': json['state_version'],
        'ledger_header_summary': LedgerHeaderSummaryFromJSON(json['ledger_header_summary']),
        'default_deposit_rule': DefaultDepositRuleFromJSON(json['default_deposit_rule']),
        'is_badge_authorized_depositor': !exists(json, 'is_badge_authorized_depositor') ? undefined : json['is_badge_authorized_depositor'],
        'resource_specific_behaviours': !exists(json, 'resource_specific_behaviours') ? undefined : (mapValues(json['resource_specific_behaviours'], ResourceSpecificDepositBehaviourFromJSON)),
    };
}

export function LtsStateAccountDepositBehaviourResponseToJSON(value?: LtsStateAccountDepositBehaviourResponse | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'state_version': value.state_version,
        'ledger_header_summary': LedgerHeaderSummaryToJSON(value.ledger_header_summary),
        'default_deposit_rule': DefaultDepositRuleToJSON(value.default_deposit_rule),
        'is_badge_authorized_depositor': value.is_badge_authorized_depositor,
        'resource_specific_behaviours': value.resource_specific_behaviours === undefined ? undefined : (mapValues(value.resource_specific_behaviours, ResourceSpecificDepositBehaviourToJSON)),
    };
}


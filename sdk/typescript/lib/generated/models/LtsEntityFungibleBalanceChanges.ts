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
import type { LtsFeeFungibleResourceBalanceChange } from './LtsFeeFungibleResourceBalanceChange';
import {
    LtsFeeFungibleResourceBalanceChangeFromJSON,
    LtsFeeFungibleResourceBalanceChangeFromJSONTyped,
    LtsFeeFungibleResourceBalanceChangeToJSON,
} from './LtsFeeFungibleResourceBalanceChange';
import type { LtsFungibleResourceBalanceChange } from './LtsFungibleResourceBalanceChange';
import {
    LtsFungibleResourceBalanceChangeFromJSON,
    LtsFungibleResourceBalanceChangeFromJSONTyped,
    LtsFungibleResourceBalanceChangeToJSON,
} from './LtsFungibleResourceBalanceChange';

/**
 * 
 * @export
 * @interface LtsEntityFungibleBalanceChanges
 */
export interface LtsEntityFungibleBalanceChanges {
    /**
     * The Bech32m-encoded human readable version of the entity's address
     * @type {string}
     * @memberof LtsEntityFungibleBalanceChanges
     */
    entity_address: string;
    /**
     * 
     * @type {LtsFungibleResourceBalanceChange}
     * @memberof LtsEntityFungibleBalanceChanges
     */
    fee_balance_change?: LtsFungibleResourceBalanceChange;
    /**
     * If present, this field indicates fee-related balance changes, for example:
     * 
     * - Payment of the fee (including tip and royalty)
     * - Distribution of royalties
     * - Distribution of the fee and tip to the consensus-manager, for distributing to the relevant
     *   validator/s at end of epoch
     * 
     * See https://www.radixdlt.com/blog/how-fees-work-in-babylon for further information on how
     * fee payment works at Babylon.
     * @type {Array<LtsFeeFungibleResourceBalanceChange>}
     * @memberof LtsEntityFungibleBalanceChanges
     */
    fee_balance_changes: Array<LtsFeeFungibleResourceBalanceChange>;
    /**
     * 
     * @type {Array<LtsFungibleResourceBalanceChange>}
     * @memberof LtsEntityFungibleBalanceChanges
     */
    non_fee_balance_changes: Array<LtsFungibleResourceBalanceChange>;
}

/**
 * Check if a given object implements the LtsEntityFungibleBalanceChanges interface.
 */
export function instanceOfLtsEntityFungibleBalanceChanges(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "entity_address" in value;
    isInstance = isInstance && "fee_balance_changes" in value;
    isInstance = isInstance && "non_fee_balance_changes" in value;

    return isInstance;
}

export function LtsEntityFungibleBalanceChangesFromJSON(json: any): LtsEntityFungibleBalanceChanges {
    return LtsEntityFungibleBalanceChangesFromJSONTyped(json, false);
}

export function LtsEntityFungibleBalanceChangesFromJSONTyped(json: any, ignoreDiscriminator: boolean): LtsEntityFungibleBalanceChanges {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'entity_address': json['entity_address'],
        'fee_balance_change': !exists(json, 'fee_balance_change') ? undefined : LtsFungibleResourceBalanceChangeFromJSON(json['fee_balance_change']),
        'fee_balance_changes': ((json['fee_balance_changes'] as Array<any>).map(LtsFeeFungibleResourceBalanceChangeFromJSON)),
        'non_fee_balance_changes': ((json['non_fee_balance_changes'] as Array<any>).map(LtsFungibleResourceBalanceChangeFromJSON)),
    };
}

export function LtsEntityFungibleBalanceChangesToJSON(value?: LtsEntityFungibleBalanceChanges | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'entity_address': value.entity_address,
        'fee_balance_change': LtsFungibleResourceBalanceChangeToJSON(value.fee_balance_change),
        'fee_balance_changes': ((value.fee_balance_changes as Array<any>).map(LtsFeeFungibleResourceBalanceChangeToJSON)),
        'non_fee_balance_changes': ((value.non_fee_balance_changes as Array<any>).map(LtsFungibleResourceBalanceChangeToJSON)),
    };
}


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

import {
    FieldSubstateKey,
    instanceOfFieldSubstateKey,
    FieldSubstateKeyFromJSON,
    FieldSubstateKeyFromJSONTyped,
    FieldSubstateKeyToJSON,
} from './FieldSubstateKey';
import {
    MapSubstateKey,
    instanceOfMapSubstateKey,
    MapSubstateKeyFromJSON,
    MapSubstateKeyFromJSONTyped,
    MapSubstateKeyToJSON,
} from './MapSubstateKey';
import {
    SortedSubstateKey,
    instanceOfSortedSubstateKey,
    SortedSubstateKeyFromJSON,
    SortedSubstateKeyFromJSONTyped,
    SortedSubstateKeyToJSON,
} from './SortedSubstateKey';

/**
 * @type SubstateKey
 * 
 * @export
 */
export type SubstateKey = { key_type: 'Field' } & FieldSubstateKey | { key_type: 'Map' } & MapSubstateKey | { key_type: 'Sorted' } & SortedSubstateKey;

export function SubstateKeyFromJSON(json: any): SubstateKey {
    return SubstateKeyFromJSONTyped(json, false);
}

export function SubstateKeyFromJSONTyped(json: any, ignoreDiscriminator: boolean): SubstateKey {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    switch (json['key_type']) {
        case 'Field':
            return {...FieldSubstateKeyFromJSONTyped(json, true), key_type: 'Field'};
        case 'Map':
            return {...MapSubstateKeyFromJSONTyped(json, true), key_type: 'Map'};
        case 'Sorted':
            return {...SortedSubstateKeyFromJSONTyped(json, true), key_type: 'Sorted'};
        default:
            throw new Error(`No variant of SubstateKey exists with 'key_type=${json['key_type']}'`);
    }
}

export function SubstateKeyToJSON(value?: SubstateKey | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    switch (value['key_type']) {
        case 'Field':
            return FieldSubstateKeyToJSON(value);
        case 'Map':
            return MapSubstateKeyToJSON(value);
        case 'Sorted':
            return SortedSubstateKeyToJSON(value);
        default:
            throw new Error(`No variant of SubstateKey exists with 'key_type=${value['key_type']}'`);
    }

}


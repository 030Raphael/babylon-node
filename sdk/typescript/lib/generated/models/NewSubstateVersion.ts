/* tslint:disable */
/* eslint-disable */
/**
 * Babylon Core API - RCnet V1
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.3.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { Substate } from './Substate';
import {
    SubstateFromJSON,
    SubstateFromJSONTyped,
    SubstateToJSON,
} from './Substate';
import type { SubstateId } from './SubstateId';
import {
    SubstateIdFromJSON,
    SubstateIdFromJSONTyped,
    SubstateIdToJSON,
} from './SubstateId';

/**
 * 
 * @export
 * @interface NewSubstateVersion
 */
export interface NewSubstateVersion {
    /**
     * 
     * @type {SubstateId}
     * @memberof NewSubstateVersion
     */
    substate_id: SubstateId;
    /**
     * An integer between `0` and `10^13`, counting the number of times the substate was updated
     * @type {number}
     * @memberof NewSubstateVersion
     */
    version: number;
    /**
     * The hex-encoded, SBOR-encoded substate data bytes
     * @type {string}
     * @memberof NewSubstateVersion
     */
    substate_hex: string;
    /**
     * The hex-encoded Blake2b-256 hash of the substate data bytes
     * @type {string}
     * @memberof NewSubstateVersion
     */
    substate_data_hash: string;
    /**
     * 
     * @type {Substate}
     * @memberof NewSubstateVersion
     */
    substate_data: Substate;
}

/**
 * Check if a given object implements the NewSubstateVersion interface.
 */
export function instanceOfNewSubstateVersion(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "substate_id" in value;
    isInstance = isInstance && "version" in value;
    isInstance = isInstance && "substate_hex" in value;
    isInstance = isInstance && "substate_data_hash" in value;
    isInstance = isInstance && "substate_data" in value;

    return isInstance;
}

export function NewSubstateVersionFromJSON(json: any): NewSubstateVersion {
    return NewSubstateVersionFromJSONTyped(json, false);
}

export function NewSubstateVersionFromJSONTyped(json: any, ignoreDiscriminator: boolean): NewSubstateVersion {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'substate_id': SubstateIdFromJSON(json['substate_id']),
        'version': json['version'],
        'substate_hex': json['substate_hex'],
        'substate_data_hash': json['substate_data_hash'],
        'substate_data': SubstateFromJSON(json['substate_data']),
    };
}

export function NewSubstateVersionToJSON(value?: NewSubstateVersion | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'substate_id': SubstateIdToJSON(value.substate_id),
        'version': value.version,
        'substate_hex': value.substate_hex,
        'substate_data_hash': value.substate_data_hash,
        'substate_data': SubstateToJSON(value.substate_data),
    };
}


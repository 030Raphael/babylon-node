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
import type { EntityType } from './EntityType';
import {
    EntityTypeFromJSON,
    EntityTypeFromJSONTyped,
    EntityTypeToJSON,
} from './EntityType';
import type { ModuleType } from './ModuleType';
import {
    ModuleTypeFromJSON,
    ModuleTypeFromJSONTyped,
    ModuleTypeToJSON,
} from './ModuleType';
import type { SubstateKeyType } from './SubstateKeyType';
import {
    SubstateKeyTypeFromJSON,
    SubstateKeyTypeFromJSONTyped,
    SubstateKeyTypeToJSON,
} from './SubstateKeyType';
import type { SubstateType } from './SubstateType';
import {
    SubstateTypeFromJSON,
    SubstateTypeFromJSONTyped,
    SubstateTypeToJSON,
} from './SubstateType';

/**
 * 
 * @export
 * @interface SubstateId
 */
export interface SubstateId {
    /**
     * 
     * @type {EntityType}
     * @memberof SubstateId
     */
    entity_type: EntityType;
    /**
     * The hex-encoded bytes of the entity id.
     * @type {string}
     * @memberof SubstateId
     */
    entity_id_hex: string;
    /**
     * 
     * @type {ModuleType}
     * @memberof SubstateId
     */
    module_type: ModuleType;
    /**
     * 
     * @type {SubstateType}
     * @memberof SubstateId
     */
    substate_type: SubstateType;
    /**
     * 
     * @type {SubstateKeyType}
     * @memberof SubstateId
     */
    substate_key_type: SubstateKeyType;
    /**
     * The hex-encoded bytes of the substate key, under the entity
     * @type {string}
     * @memberof SubstateId
     */
    substate_key_hex: string;
}

/**
 * Check if a given object implements the SubstateId interface.
 */
export function instanceOfSubstateId(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "entity_type" in value;
    isInstance = isInstance && "entity_id_hex" in value;
    isInstance = isInstance && "module_type" in value;
    isInstance = isInstance && "substate_type" in value;
    isInstance = isInstance && "substate_key_type" in value;
    isInstance = isInstance && "substate_key_hex" in value;

    return isInstance;
}

export function SubstateIdFromJSON(json: any): SubstateId {
    return SubstateIdFromJSONTyped(json, false);
}

export function SubstateIdFromJSONTyped(json: any, ignoreDiscriminator: boolean): SubstateId {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'entity_type': EntityTypeFromJSON(json['entity_type']),
        'entity_id_hex': json['entity_id_hex'],
        'module_type': ModuleTypeFromJSON(json['module_type']),
        'substate_type': SubstateTypeFromJSON(json['substate_type']),
        'substate_key_type': SubstateKeyTypeFromJSON(json['substate_key_type']),
        'substate_key_hex': json['substate_key_hex'],
    };
}

export function SubstateIdToJSON(value?: SubstateId | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'entity_type': EntityTypeToJSON(value.entity_type),
        'entity_id_hex': value.entity_id_hex,
        'module_type': ModuleTypeToJSON(value.module_type),
        'substate_type': SubstateTypeToJSON(value.substate_type),
        'substate_key_type': SubstateKeyTypeToJSON(value.substate_key_type),
        'substate_key_hex': value.substate_key_hex,
    };
}


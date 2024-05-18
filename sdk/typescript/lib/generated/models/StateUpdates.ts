/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon (Bottlenose)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { CreatedSubstate } from './CreatedSubstate';
import {
    CreatedSubstateFromJSON,
    CreatedSubstateFromJSONTyped,
    CreatedSubstateToJSON,
} from './CreatedSubstate';
import type { DeletedSubstate } from './DeletedSubstate';
import {
    DeletedSubstateFromJSON,
    DeletedSubstateFromJSONTyped,
    DeletedSubstateToJSON,
} from './DeletedSubstate';
import type { EntityReference } from './EntityReference';
import {
    EntityReferenceFromJSON,
    EntityReferenceFromJSONTyped,
    EntityReferenceToJSON,
} from './EntityReference';
import type { PartitionId } from './PartitionId';
import {
    PartitionIdFromJSON,
    PartitionIdFromJSONTyped,
    PartitionIdToJSON,
} from './PartitionId';
import type { UpdatedSubstate } from './UpdatedSubstate';
import {
    UpdatedSubstateFromJSON,
    UpdatedSubstateFromJSONTyped,
    UpdatedSubstateToJSON,
} from './UpdatedSubstate';

/**
 * Transaction state updates (only present if status is Succeeded or Failed)
 * @export
 * @interface StateUpdates
 */
export interface StateUpdates {
    /**
     * 
     * @type {Array<PartitionId>}
     * @memberof StateUpdates
     */
    deleted_partitions: Array<PartitionId>;
    /**
     * 
     * @type {Array<CreatedSubstate>}
     * @memberof StateUpdates
     */
    created_substates: Array<CreatedSubstate>;
    /**
     * 
     * @type {Array<UpdatedSubstate>}
     * @memberof StateUpdates
     */
    updated_substates: Array<UpdatedSubstate>;
    /**
     * 
     * @type {Array<DeletedSubstate>}
     * @memberof StateUpdates
     */
    deleted_substates: Array<DeletedSubstate>;
    /**
     * 
     * @type {Array<EntityReference>}
     * @memberof StateUpdates
     */
    new_global_entities: Array<EntityReference>;
}

/**
 * Check if a given object implements the StateUpdates interface.
 */
export function instanceOfStateUpdates(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "deleted_partitions" in value;
    isInstance = isInstance && "created_substates" in value;
    isInstance = isInstance && "updated_substates" in value;
    isInstance = isInstance && "deleted_substates" in value;
    isInstance = isInstance && "new_global_entities" in value;

    return isInstance;
}

export function StateUpdatesFromJSON(json: any): StateUpdates {
    return StateUpdatesFromJSONTyped(json, false);
}

export function StateUpdatesFromJSONTyped(json: any, ignoreDiscriminator: boolean): StateUpdates {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'deleted_partitions': ((json['deleted_partitions'] as Array<any>).map(PartitionIdFromJSON)),
        'created_substates': ((json['created_substates'] as Array<any>).map(CreatedSubstateFromJSON)),
        'updated_substates': ((json['updated_substates'] as Array<any>).map(UpdatedSubstateFromJSON)),
        'deleted_substates': ((json['deleted_substates'] as Array<any>).map(DeletedSubstateFromJSON)),
        'new_global_entities': ((json['new_global_entities'] as Array<any>).map(EntityReferenceFromJSON)),
    };
}

export function StateUpdatesToJSON(value?: StateUpdates | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'deleted_partitions': ((value.deleted_partitions as Array<any>).map(PartitionIdToJSON)),
        'created_substates': ((value.created_substates as Array<any>).map(CreatedSubstateToJSON)),
        'updated_substates': ((value.updated_substates as Array<any>).map(UpdatedSubstateToJSON)),
        'deleted_substates': ((value.deleted_substates as Array<any>).map(DeletedSubstateToJSON)),
        'new_global_entities': ((value.new_global_entities as Array<any>).map(EntityReferenceToJSON)),
    };
}


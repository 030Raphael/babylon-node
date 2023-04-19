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
import type { PackageSchema } from './PackageSchema';
import {
    PackageSchemaFromJSON,
    PackageSchemaFromJSONTyped,
    PackageSchemaToJSON,
} from './PackageSchema';

/**
 * 
 * @export
 * @interface PackageInfoSubstate
 */
export interface PackageInfoSubstate {
    /**
     * 
     * @type {string}
     * @memberof PackageInfoSubstate
     */
    substate_type: PackageInfoSubstateSubstateTypeEnum;
    /**
     * 
     * @type {PackageSchema}
     * @memberof PackageInfoSubstate
     */
    package_schema: PackageSchema;
    /**
     * 
     * @type {Array<string>}
     * @memberof PackageInfoSubstate
     */
    dependent_resources: Array<string>;
    /**
     * 
     * @type {Array<string>}
     * @memberof PackageInfoSubstate
     */
    dependent_components: Array<string>;
}


/**
 * @export
 */
export const PackageInfoSubstateSubstateTypeEnum = {
    PackageInfo: 'PackageInfo'
} as const;
export type PackageInfoSubstateSubstateTypeEnum = typeof PackageInfoSubstateSubstateTypeEnum[keyof typeof PackageInfoSubstateSubstateTypeEnum];


/**
 * Check if a given object implements the PackageInfoSubstate interface.
 */
export function instanceOfPackageInfoSubstate(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "substate_type" in value;
    isInstance = isInstance && "package_schema" in value;
    isInstance = isInstance && "dependent_resources" in value;
    isInstance = isInstance && "dependent_components" in value;

    return isInstance;
}

export function PackageInfoSubstateFromJSON(json: any): PackageInfoSubstate {
    return PackageInfoSubstateFromJSONTyped(json, false);
}

export function PackageInfoSubstateFromJSONTyped(json: any, ignoreDiscriminator: boolean): PackageInfoSubstate {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'substate_type': json['substate_type'],
        'package_schema': PackageSchemaFromJSON(json['package_schema']),
        'dependent_resources': json['dependent_resources'],
        'dependent_components': json['dependent_components'],
    };
}

export function PackageInfoSubstateToJSON(value?: PackageInfoSubstate | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'substate_type': value.substate_type,
        'package_schema': PackageSchemaToJSON(value.package_schema),
        'dependent_resources': value.dependent_resources,
        'dependent_components': value.dependent_components,
    };
}


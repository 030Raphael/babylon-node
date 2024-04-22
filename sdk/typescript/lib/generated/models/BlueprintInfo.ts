/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon (Anemone)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.1.3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { GenericSubstitution } from './GenericSubstitution';
import {
    GenericSubstitutionFromJSON,
    GenericSubstitutionFromJSONTyped,
    GenericSubstitutionToJSON,
} from './GenericSubstitution';

/**
 * 
 * @export
 * @interface BlueprintInfo
 */
export interface BlueprintInfo {
    /**
     * The Bech32m-encoded human readable version of the package address
     * @type {string}
     * @memberof BlueprintInfo
     */
    package_address: string;
    /**
     * 
     * @type {string}
     * @memberof BlueprintInfo
     */
    blueprint_name: string;
    /**
     * 
     * @type {string}
     * @memberof BlueprintInfo
     */
    blueprint_version: string;
    /**
     * The Bech32m-encoded human readable version of any global address
     * @type {string}
     * @memberof BlueprintInfo
     */
    outer_object?: string;
    /**
     * 
     * @type {Array<string>}
     * @memberof BlueprintInfo
     */
    features: Array<string>;
    /**
     * 
     * @type {Array<GenericSubstitution>}
     * @memberof BlueprintInfo
     */
    generic_substitutions: Array<GenericSubstitution>;
}

/**
 * Check if a given object implements the BlueprintInfo interface.
 */
export function instanceOfBlueprintInfo(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "package_address" in value;
    isInstance = isInstance && "blueprint_name" in value;
    isInstance = isInstance && "blueprint_version" in value;
    isInstance = isInstance && "features" in value;
    isInstance = isInstance && "generic_substitutions" in value;

    return isInstance;
}

export function BlueprintInfoFromJSON(json: any): BlueprintInfo {
    return BlueprintInfoFromJSONTyped(json, false);
}

export function BlueprintInfoFromJSONTyped(json: any, ignoreDiscriminator: boolean): BlueprintInfo {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'package_address': json['package_address'],
        'blueprint_name': json['blueprint_name'],
        'blueprint_version': json['blueprint_version'],
        'outer_object': !exists(json, 'outer_object') ? undefined : json['outer_object'],
        'features': json['features'],
        'generic_substitutions': ((json['generic_substitutions'] as Array<any>).map(GenericSubstitutionFromJSON)),
    };
}

export function BlueprintInfoToJSON(value?: BlueprintInfo | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'package_address': value.package_address,
        'blueprint_name': value.blueprint_name,
        'blueprint_version': value.blueprint_version,
        'outer_object': value.outer_object,
        'features': value.features,
        'generic_substitutions': ((value.generic_substitutions as Array<any>).map(GenericSubstitutionToJSON)),
    };
}


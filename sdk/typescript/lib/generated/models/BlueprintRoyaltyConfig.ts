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
import type { RoyaltyConfig } from './RoyaltyConfig';
import {
    RoyaltyConfigFromJSON,
    RoyaltyConfigFromJSONTyped,
    RoyaltyConfigToJSON,
} from './RoyaltyConfig';

/**
 * 
 * @export
 * @interface BlueprintRoyaltyConfig
 */
export interface BlueprintRoyaltyConfig {
    /**
     * 
     * @type {string}
     * @memberof BlueprintRoyaltyConfig
     */
    blueprint_name: string;
    /**
     * 
     * @type {RoyaltyConfig}
     * @memberof BlueprintRoyaltyConfig
     */
    royalty_config: RoyaltyConfig;
}

/**
 * Check if a given object implements the BlueprintRoyaltyConfig interface.
 */
export function instanceOfBlueprintRoyaltyConfig(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "blueprint_name" in value;
    isInstance = isInstance && "royalty_config" in value;

    return isInstance;
}

export function BlueprintRoyaltyConfigFromJSON(json: any): BlueprintRoyaltyConfig {
    return BlueprintRoyaltyConfigFromJSONTyped(json, false);
}

export function BlueprintRoyaltyConfigFromJSONTyped(json: any, ignoreDiscriminator: boolean): BlueprintRoyaltyConfig {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'blueprint_name': json['blueprint_name'],
        'royalty_config': RoyaltyConfigFromJSON(json['royalty_config']),
    };
}

export function BlueprintRoyaltyConfigToJSON(value?: BlueprintRoyaltyConfig | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'blueprint_name': value.blueprint_name,
        'royalty_config': RoyaltyConfigToJSON(value.royalty_config),
    };
}


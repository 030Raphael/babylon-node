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
import type { BlueprintInterface } from './BlueprintInterface';
import {
    BlueprintInterfaceFromJSON,
    BlueprintInterfaceFromJSONTyped,
    BlueprintInterfaceToJSON,
} from './BlueprintInterface';
import type { HookExport } from './HookExport';
import {
    HookExportFromJSON,
    HookExportFromJSONTyped,
    HookExportToJSON,
} from './HookExport';
import type { PackageExport } from './PackageExport';
import {
    PackageExportFromJSON,
    PackageExportFromJSONTyped,
    PackageExportToJSON,
} from './PackageExport';

/**
 * 
 * @export
 * @interface BlueprintDefinition
 */
export interface BlueprintDefinition {
    /**
     * 
     * @type {BlueprintInterface}
     * @memberof BlueprintDefinition
     */
    _interface: BlueprintInterface;
    /**
     * A map from the function name to its export
     * @type {{ [key: string]: PackageExport; }}
     * @memberof BlueprintDefinition
     */
    function_exports: { [key: string]: PackageExport; };
    /**
     * A map from certain object lifecycle hooks to a callback "package export".
     * There is at most one callback registered for each `ObjectHook`.
     * @type {Array<HookExport>}
     * @memberof BlueprintDefinition
     */
    hook_exports: Array<HookExport>;
}

/**
 * Check if a given object implements the BlueprintDefinition interface.
 */
export function instanceOfBlueprintDefinition(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "_interface" in value;
    isInstance = isInstance && "function_exports" in value;
    isInstance = isInstance && "hook_exports" in value;

    return isInstance;
}

export function BlueprintDefinitionFromJSON(json: any): BlueprintDefinition {
    return BlueprintDefinitionFromJSONTyped(json, false);
}

export function BlueprintDefinitionFromJSONTyped(json: any, ignoreDiscriminator: boolean): BlueprintDefinition {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        '_interface': BlueprintInterfaceFromJSON(json['interface']),
        'function_exports': (mapValues(json['function_exports'], PackageExportFromJSON)),
        'hook_exports': ((json['hook_exports'] as Array<any>).map(HookExportFromJSON)),
    };
}

export function BlueprintDefinitionToJSON(value?: BlueprintDefinition | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'interface': BlueprintInterfaceToJSON(value._interface),
        'function_exports': (mapValues(value.function_exports, PackageExportToJSON)),
        'hook_exports': ((value.hook_exports as Array<any>).map(HookExportToJSON)),
    };
}


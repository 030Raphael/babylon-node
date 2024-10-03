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
import type { SignallingValidator } from './SignallingValidator';
import {
    SignallingValidatorFromJSON,
    SignallingValidatorFromJSONTyped,
    SignallingValidatorToJSON,
} from './SignallingValidator';

/**
 * 
 * @export
 * @interface ProtocolVersionReadiness
 */
export interface ProtocolVersionReadiness {
    /**
     * A name identifying a protocol version. May be absent to denote no readiness signalled by
     * the `signalling_validators`.
     * @type {string}
     * @memberof ProtocolVersionReadiness
     */
    signalled_protocol_version?: string;
    /**
     * A sum of `active_stake_proportion` across `signalling_validators` (i.e. an easily-computable convenience field).
     * This is a string-encoded fixed-precision decimal to 18 decimal places.
     * A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`.
     * @type {string}
     * @memberof ProtocolVersionReadiness
     */
    total_active_stake_proportion: string;
    /**
     * References to some of the current validators (i.e. a subset of `current_validator_set`)
     * which have signalled readiness for the `signalled_protocol_version`.
     * @type {Array<SignallingValidator>}
     * @memberof ProtocolVersionReadiness
     */
    signalling_validators: Array<SignallingValidator>;
}

/**
 * Check if a given object implements the ProtocolVersionReadiness interface.
 */
export function instanceOfProtocolVersionReadiness(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "total_active_stake_proportion" in value;
    isInstance = isInstance && "signalling_validators" in value;

    return isInstance;
}

export function ProtocolVersionReadinessFromJSON(json: any): ProtocolVersionReadiness {
    return ProtocolVersionReadinessFromJSONTyped(json, false);
}

export function ProtocolVersionReadinessFromJSONTyped(json: any, ignoreDiscriminator: boolean): ProtocolVersionReadiness {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'signalled_protocol_version': !exists(json, 'signalled_protocol_version') ? undefined : json['signalled_protocol_version'],
        'total_active_stake_proportion': json['total_active_stake_proportion'],
        'signalling_validators': ((json['signalling_validators'] as Array<any>).map(SignallingValidatorFromJSON)),
    };
}

export function ProtocolVersionReadinessToJSON(value?: ProtocolVersionReadiness | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'signalled_protocol_version': value.signalled_protocol_version,
        'total_active_stake_proportion': value.total_active_stake_proportion,
        'signalling_validators': ((value.signalling_validators as Array<any>).map(SignallingValidatorToJSON)),
    };
}


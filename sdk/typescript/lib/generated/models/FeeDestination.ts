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
import type { PaymentToRoyaltyRecipient } from './PaymentToRoyaltyRecipient';
import {
    PaymentToRoyaltyRecipientFromJSON,
    PaymentToRoyaltyRecipientFromJSONTyped,
    PaymentToRoyaltyRecipientToJSON,
} from './PaymentToRoyaltyRecipient';

/**
 * 
 * @export
 * @interface FeeDestination
 */
export interface FeeDestination {
    /**
     * The string-encoded decimal representing the amount of fee in XRD paid to the proposer.
     * A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`.
     * @type {string}
     * @memberof FeeDestination
     */
    to_proposer: string;
    /**
     * The string-encoded decimal representing the amount of fee in XRD paid to the validator set.
     * A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`.
     * @type {string}
     * @memberof FeeDestination
     */
    to_validator_set: string;
    /**
     * The string-encoded decimal representing the amount of fee burnt, in XRD.
     * A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`.
     * @type {string}
     * @memberof FeeDestination
     */
    to_burn: string;
    /**
     * A breakdown of where the royalties were paid to.
     * @type {Array<PaymentToRoyaltyRecipient>}
     * @memberof FeeDestination
     */
    to_royalty_recipients: Array<PaymentToRoyaltyRecipient>;
}

/**
 * Check if a given object implements the FeeDestination interface.
 */
export function instanceOfFeeDestination(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "to_proposer" in value;
    isInstance = isInstance && "to_validator_set" in value;
    isInstance = isInstance && "to_burn" in value;
    isInstance = isInstance && "to_royalty_recipients" in value;

    return isInstance;
}

export function FeeDestinationFromJSON(json: any): FeeDestination {
    return FeeDestinationFromJSONTyped(json, false);
}

export function FeeDestinationFromJSONTyped(json: any, ignoreDiscriminator: boolean): FeeDestination {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'to_proposer': json['to_proposer'],
        'to_validator_set': json['to_validator_set'],
        'to_burn': json['to_burn'],
        'to_royalty_recipients': ((json['to_royalty_recipients'] as Array<any>).map(PaymentToRoyaltyRecipientFromJSON)),
    };
}

export function FeeDestinationToJSON(value?: FeeDestination | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'to_proposer': value.to_proposer,
        'to_validator_set': value.to_validator_set,
        'to_burn': value.to_burn,
        'to_royalty_recipients': ((value.to_royalty_recipients as Array<any>).map(PaymentToRoyaltyRecipientToJSON)),
    };
}


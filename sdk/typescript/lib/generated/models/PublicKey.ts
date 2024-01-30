/* tslint:disable */
/* eslint-disable */
/**
 * Radix Core API - Babylon (Anemone)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node\'s function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node\'s current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import {
    EcdsaSecp256k1PublicKey,
    instanceOfEcdsaSecp256k1PublicKey,
    EcdsaSecp256k1PublicKeyFromJSON,
    EcdsaSecp256k1PublicKeyFromJSONTyped,
    EcdsaSecp256k1PublicKeyToJSON,
} from './EcdsaSecp256k1PublicKey';
import {
    EddsaEd25519PublicKey,
    instanceOfEddsaEd25519PublicKey,
    EddsaEd25519PublicKeyFromJSON,
    EddsaEd25519PublicKeyFromJSONTyped,
    EddsaEd25519PublicKeyToJSON,
} from './EddsaEd25519PublicKey';

/**
 * @type PublicKey
 * 
 * @export
 */
export type PublicKey = { key_type: 'EcdsaSecp256k1' } & EcdsaSecp256k1PublicKey | { key_type: 'EddsaEd25519' } & EddsaEd25519PublicKey;

export function PublicKeyFromJSON(json: any): PublicKey {
    return PublicKeyFromJSONTyped(json, false);
}

export function PublicKeyFromJSONTyped(json: any, ignoreDiscriminator: boolean): PublicKey {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    switch (json['key_type']) {
        case 'EcdsaSecp256k1':
            return {...EcdsaSecp256k1PublicKeyFromJSONTyped(json, true), key_type: 'EcdsaSecp256k1'};
        case 'EddsaEd25519':
            return {...EddsaEd25519PublicKeyFromJSONTyped(json, true), key_type: 'EddsaEd25519'};
        default:
            throw new Error(`No variant of PublicKey exists with 'key_type=${json['key_type']}'`);
    }
}

export function PublicKeyToJSON(value?: PublicKey | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    switch (value['key_type']) {
        case 'EcdsaSecp256k1':
            return EcdsaSecp256k1PublicKeyToJSON(value);
        case 'EddsaEd25519':
            return EddsaEd25519PublicKeyToJSON(value);
        default:
            throw new Error(`No variant of PublicKey exists with 'key_type=${value['key_type']}'`);
    }

}


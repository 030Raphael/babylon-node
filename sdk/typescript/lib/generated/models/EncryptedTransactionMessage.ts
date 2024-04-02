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

import { exists, mapValues } from '../runtime';
import type { EncryptedMessageCurveDecryptorSet } from './EncryptedMessageCurveDecryptorSet';
import {
    EncryptedMessageCurveDecryptorSetFromJSON,
    EncryptedMessageCurveDecryptorSetFromJSONTyped,
    EncryptedMessageCurveDecryptorSetToJSON,
} from './EncryptedMessageCurveDecryptorSet';

/**
 * 
 * @export
 * @interface EncryptedTransactionMessage
 */
export interface EncryptedTransactionMessage {
    /**
     * 
     * @type {string}
     * @memberof EncryptedTransactionMessage
     */
    type: EncryptedTransactionMessageTypeEnum;
    /**
     * The hex-encoded (128-bit) AES-GCM encrypted bytes of an SBOR-encoded `PlaintextTransactionMessage`.
     * The bytes are serialized as the concatenation `Nonce/IV (12 bytes) || Cipher (variable length) || Tag/MAC (16 bytes)`:
     * @type {string}
     * @memberof EncryptedTransactionMessage
     */
    encrypted_hex: string;
    /**
     * 
     * @type {Array<EncryptedMessageCurveDecryptorSet>}
     * @memberof EncryptedTransactionMessage
     */
    curve_decryptor_sets: Array<EncryptedMessageCurveDecryptorSet>;
}


/**
 * @export
 */
export const EncryptedTransactionMessageTypeEnum = {
    Encrypted: 'Encrypted'
} as const;
export type EncryptedTransactionMessageTypeEnum = typeof EncryptedTransactionMessageTypeEnum[keyof typeof EncryptedTransactionMessageTypeEnum];


/**
 * Check if a given object implements the EncryptedTransactionMessage interface.
 */
export function instanceOfEncryptedTransactionMessage(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "type" in value;
    isInstance = isInstance && "encrypted_hex" in value;
    isInstance = isInstance && "curve_decryptor_sets" in value;

    return isInstance;
}

export function EncryptedTransactionMessageFromJSON(json: any): EncryptedTransactionMessage {
    return EncryptedTransactionMessageFromJSONTyped(json, false);
}

export function EncryptedTransactionMessageFromJSONTyped(json: any, ignoreDiscriminator: boolean): EncryptedTransactionMessage {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'type': json['type'],
        'encrypted_hex': json['encrypted_hex'],
        'curve_decryptor_sets': ((json['curve_decryptor_sets'] as Array<any>).map(EncryptedMessageCurveDecryptorSetFromJSON)),
    };
}

export function EncryptedTransactionMessageToJSON(value?: EncryptedTransactionMessage | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'type': value.type,
        'encrypted_hex': value.encrypted_hex,
        'curve_decryptor_sets': ((value.curve_decryptor_sets as Array<any>).map(EncryptedMessageCurveDecryptorSetToJSON)),
    };
}


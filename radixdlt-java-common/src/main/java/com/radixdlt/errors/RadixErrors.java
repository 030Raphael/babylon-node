/* Copyright 2021 Radix DLT Ltd incorporated in England.
 *
 * Licensed under the Radix License, Version 1.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at:
 *
 * radixfoundation.org/licenses/LICENSE-v1
 *
 * The Licensor hereby grants permission for the Canonical version of the Work to be
 * published, distributed and used under or by reference to the Licensor’s trademark
 * Radix ® and use of any unregistered trade names, logos or get-up.
 *
 * The Licensor provides the Work (and each Contributor provides its Contributions) on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT,
 * MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Whilst the Work is capable of being deployed, used and adopted (instantiated) to create
 * a distributed ledger it is your responsibility to test and validate the code, together
 * with all logic and performance of that code under all foreseeable scenarios.
 *
 * The Licensor does not make or purport to make and hereby excludes liability for all
 * and any representation, warranty or undertaking in any form whatsoever, whether express
 * or implied, to any entity or person, including any representation, warranty or
 * undertaking, as to the functionality security use, value or other characteristics of
 * any distributed ledger nor in respect the functioning or value of any tokens which may
 * be created stored or transferred using the Work. The Licensor does not warrant that the
 * Work or any use of the Work complies with any law or regulation in any territory where
 * it may be implemented or used or that it will be appropriate for any specific purpose.
 *
 * Neither the licensor nor any current or former employees, officers, directors, partners,
 * trustees, representatives, agents, advisors, contractors, or volunteers of the Licensor
 * shall be liable for any direct or indirect, special, incidental, consequential or other
 * losses of any kind, in tort, contract or otherwise (including but not limited to loss
 * of revenue, income or profits, or loss of use or data, or loss of reputation, or loss
 * of any economic or other opportunity of whatsoever nature or howsoever arising), arising
 * out of or in connection with (without limitation of any use, misuse, of any ledger system
 * or use made or its functionality or any performance or operation of any code or protocol
 * caused by bugs or programming or logic errors or otherwise);
 *
 * A. any offer, purchase, holding, use, sale, exchange or transmission of any
 * cryptographic keys, tokens or assets created, exchanged, stored or arising from any
 * interaction with the Work;
 *
 * B. any failure in a transmission or loss of any token or assets keys or other digital
 * artefacts due to errors in transmission;
 *
 * C. bugs, hacks, logic errors or faults in the Work or any communication;
 *
 * D. system software or apparatus including but not limited to losses caused by errors
 * in holding or transmitting tokens by any third-party;
 *
 * E. breaches or failure of security including hacker attacks, loss or disclosure of
 * password, loss of private key, unauthorised use or misuse of such passwords or keys;
 *
 * F. any losses including loss of anticipated savings or other benefits resulting from
 * use of the Work or any changes to the Work (however implemented).
 *
 * You are solely responsible for; testing, validating and evaluation of all operation
 * logic, functionality, security and appropriateness of using the Work for any commercial
 * or non-commercial purpose and for any reproduction or redistribution by You of the
 * Work. You assume all risks associated with Your use of the Work and the exercise of
 * permissions under this License.
 */

package com.radixdlt.errors;

import com.radixdlt.utils.functional.Failure;

/**
 * Full list of internal error codes.
 * <p>
 * <b>WARNING: New errors should be added to the end of the list to preserve error codes.</b>
 */
public enum RadixErrors implements Failure {
	GENERAL("General error (used for testing only)"),
	UNKNOWN("Unknown error of type {0} with message {1}"),

	ASYNC_PROCESSING_ERROR("Async processing error {0}"),

	ERROR_CALL_DATA("{0}"),
	ERROR_CONSTRAINT_VIOLATION("{0}"),
	ERROR_DEFAULT_SYSTEM_LOAN("{0}"),
	ERROR_DELEGATION_NOT_ALLOWED("{0}"),
	ERROR_INVALID_HASHED_KEY("{0}"),
	ERROR_INVALID_PERMISSION("{0}"),
	ERROR_INVALID_RESOURCE("{0}"),
	ERROR_INVALID_VIRTUAL_SUBSTATE("{0}"),
	ERROR_LOCAL_SUBSTATE_NOT_FOUND("{0}"),
	ERROR_MINIMUM_STAKE("{0}"),
	ERROR_MISMATCH("{0}"),
	ERROR_MISSING_PROCEDURE("{0}"),
	ERROR_MULTIPLE_FEE_RESERVE_DEPOSIT("Multiple fee reserve deposit"),
	ERROR_NOT_AUTHORIZED("{0}"),
	ERROR_NOT_A_RESOURCE("{0}"),
	ERROR_NOT_ENOUGH_RESERVE("{0}"),
	ERROR_NOT_ENOUGH_RESOURCES("{0}"),
	ERROR_PROCEDURE("{0}"),
	ERROR_RESERVED_SYMBOL("{0}"),
	ERROR_RESERVE_NOT_EMPTY("{0}"),
	ERROR_RESOURCE_ALLOCATION_AND_DESTRUCTION("{0}"),
	ERROR_SIGNED_SYSTEM("{0}"),
	ERROR_SUBSTATE_NOT_FOUND("{0}"),
	ERROR_VIRTUAL_PARENT_STATE_DOES_NOT_EXIST("{0}"),
	ERROR_VIRTUAL_SUBSTATE_ALREADY_DOWN("{0}"),

	INTERRUPTED_OPERATION("Operation interrupted with InterruptedException. Details: {0} {1}"),

	INVALID_ACCOUNT_ADDRESS("Invalid account address {0}"),
	INVALID_ACTION_DATA("Invalid action data {0}"),
	INVALID_AID_LENGTH("AID string has incorrect length {0}"),
	INVALID_AID_STRING("AID string is 'null'"),
	INVALID_PAGE_SIZE("Size {0} must be > 0"),
	INVALID_PUBLIC_KEY("Invalid public key {0}"),
	INVALID_RESOURCE_ADDRESS("Invalid resource address {0}"),
	INVALID_SIGNATURE_DER("Invalid signature DER {0}"),
	INVALID_TX_ID("Invalid TX ID {0}"),
	INVALID_VALIDATOR_ADDRESS("Invalid validator address {0}"),
	INVALID_VALUE_OUT_OF_RANGE("Parameter {0} must be between {1} and {2}"),
	INVALID_VALUE_TYPE("Invalid value type {0}"),

	IO_ERROR("I/O Error: {0} {1}"),

	MISSING_ACTION_FIELD("Required field {0} is not present in action definition"),
	MISSING_BASE_URL("Base URL is mandatory"),
	MISSING_KEYSTORE_FILE("keystore file '{0}' does not exist or is not accessible"),
	MISSING_PARAMETER("The parameter {0} is missing"),

	MUST_MATCH_TX_ID("Provided txID does not match provided transaction"),

	SSL_ALGORITHM_ERROR("SSL algorithm error: {0}"),
	SSL_GENERAL_ERROR("SSL algorithm error: {0}"),
	SSL_KEY_ERROR("SSL Key error: {0}"),

	UNABLE_TO_ADD_TO_MEMPOOL("Unable to add transaction to mempool: mempool is full"),
	UNABLE_TO_DESERIALIZE("Unable to deserialize: {0}"),
	UNABLE_TO_LOAD_KEYSTORE("Unable to load keystore: {0}"),
	UNABLE_TO_MAKE_SIGNATURE_RECOVERABLE("Unable to convert signature to recoverable {0}"),
	UNABLE_TO_PARSE_BOOLEAN("Unable to parse boolean value: {0}"),
	UNABLE_TO_PARSE_COMMAND_LINE("Error parsing command line parameters: {0}"),
	UNABLE_TO_PARSE_FLOAT("Unable to parse float number: {0}"),
	UNABLE_TO_PARSE_HEX_STRING("The value {0} is not a correct hexadecimal string"),
	UNABLE_TO_PARSE_INT("Unable to parse integer number: {0}"),
	UNABLE_TO_PARSE_UINT("Unable to parse unsigned integer number: {0}"),
	UNABLE_TO_PREPARE_TX("Unable to prepare transaction"),
	UNABLE_TO_SERIALIZE("Unable to serialize: {0}"),
	UNABLE_TO_SUBMIT_TX("Transaction submission failed: {0}"),
	UNKNOWN_ACTION("Unknown action {0}"),
	UNKNOWN_PARTICLE("Unknown particle for key {0}"),
	UNKNOWN_RRI("Unknown RRI {0}"),
	UNKNOWN_TX_ID("Transaction with id {0} not found"),
	UNSUPPORTED_ACTION("Action type {0} is not supported");

	private final String message;

	RadixErrors(String message) {
		this.message = message;
	}

	@Override
	public String message() {
		return message;
	}

	@Override
	public int code() {
		return Category.GENERAL.forId(ordinal());
	}
}

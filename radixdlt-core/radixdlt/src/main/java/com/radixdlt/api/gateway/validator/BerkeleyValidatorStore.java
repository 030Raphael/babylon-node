/*
 * Copyright 2021 Radix Publishing Ltd incorporated in Jersey (Channel Islands).
 * Licensed under the Radix License, Version 1.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at:
 *
 * radixfoundation.org/licenses/LICENSE-v1
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

package com.radixdlt.api.gateway.validator;

import com.google.common.collect.Streams;
import com.google.inject.Inject;
import com.radixdlt.accounting.REResourceAccounting;
import com.radixdlt.api.gateway.openapitools.JSON;
import com.radixdlt.api.gateway.openapitools.model.Validator;
import com.radixdlt.application.system.state.StakeBucket;
import com.radixdlt.application.system.state.StakeOwnershipBucket;
import com.radixdlt.application.tokens.state.ExittingOwnershipBucket;
import com.radixdlt.application.tokens.state.PreparedStakeBucket;
import com.radixdlt.application.validators.state.AllowDelegationFlag;
import com.radixdlt.application.validators.state.ValidatorData;
import com.radixdlt.application.validators.state.ValidatorFeeCopy;
import com.radixdlt.application.validators.state.ValidatorMetaData;
import com.radixdlt.application.validators.state.ValidatorOwnerCopy;
import com.radixdlt.application.validators.state.ValidatorRegisteredCopy;
import com.radixdlt.constraintmachine.REProcessedTxn;
import com.radixdlt.constraintmachine.REStateUpdate;
import com.radixdlt.constraintmachine.RawSubstateBytes;
import com.radixdlt.constraintmachine.SystemMapKey;
import com.radixdlt.crypto.ECPublicKey;
import com.radixdlt.identifiers.REAddr;
import com.radixdlt.networks.Addressing;
import com.radixdlt.store.DatabaseEnvironment;
import com.radixdlt.store.berkeley.BerkeleyAdditionalStore;
import com.radixdlt.utils.Pair;
import com.radixdlt.utils.UInt256;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.SecondaryConfig;
import com.sleepycat.je.SecondaryCursor;
import com.sleepycat.je.SecondaryDatabase;
import com.sleepycat.je.Transaction;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static com.google.common.primitives.UnsignedBytes.lexicographicalComparator;
import static com.radixdlt.application.validators.scrypt.ValidatorUpdateRakeConstraintScrypt.RAKE_PERCENTAGE_GRANULARITY;
import static com.sleepycat.je.OperationStatus.SUCCESS;

public final class BerkeleyValidatorStore implements BerkeleyAdditionalStore {
	private final Addressing addressing;
	private Database validatorDatabase;
	private SecondaryDatabase orderedValidatorsDatabase;

	@Inject
	public BerkeleyValidatorStore(Addressing addressing) {
		this.addressing = addressing;
	}

	@Override
	public void open(DatabaseEnvironment dbEnv) {
		var env = dbEnv.getEnvironment();
		validatorDatabase = env.openDatabase(null, "radix.validator_db", new DatabaseConfig()
			.setAllowCreate(true)
			.setTransactional(true)
			.setKeyPrefixing(true)
			.setBtreeComparator(lexicographicalComparator())
		);

		orderedValidatorsDatabase = env.openSecondaryDatabase(
			null,
			"radix.ordered_validator_db",
			validatorDatabase,
			(SecondaryConfig) new SecondaryConfig()
				.setKeyCreator(
					(secondary, key, data, result) -> {
						var buf = ByteBuffer.allocate(1 + UInt256.BYTES + ECPublicKey.COMPRESSED_BYTES);

						var json = new JSONObject(new String(data.getData(), StandardCharsets.UTF_8));
						var registered = json.getJSONObject("properties").getBoolean("registered");
						buf.put((byte) (registered ? 1 : 0));

						var stakeString = json.getJSONObject("stake").getString("nextEpochEstimatedStake");
						var stake = UInt256.from(stakeString);
						buf.put(stake.toByteArray());

						var validatorKey = addressing.forValidators().parseOrThrow(
							json.getJSONObject("validator_identifier").getString("address"),
							IllegalStateException::new
						);
						buf.put(validatorKey.getCompressedBytes());

						result.setData(buf.array());
						return true;
					}
				)
				.setAllowCreate(true)
				.setTransactional(true)
		);
	}

	@Override
	public void close() {
		if (validatorDatabase != null) {
			validatorDatabase.close();
		}
		if (orderedValidatorsDatabase != null) {
			orderedValidatorsDatabase.close();
		}
	}

	private Validator mapValidator(JSONObject validatorJson) {
		var stakeJson = validatorJson.getJSONObject("stake");
		var ownerEstimateString = stakeJson.getString("nextEpochEstimatedOwnerStake");
		var stakeEstimateString = stakeJson.getString("nextEpochEstimatedStake");
		var ownerAddress = (String) validatorJson.getJSONObject("properties").remove("owner_address");
		validatorJson.getJSONObject("properties").put("owner_account_identifier", new JSONObject()
			.put("address", ownerAddress)
		);
		validatorJson.put("info", new JSONObject()
			.put("owner_stake", new JSONObject()
				.put("token_identifier", new JSONObject()
					.put("rri", addressing.forResources().of("xrd", REAddr.ofNativeToken()))
				)
				.put("value", ownerEstimateString)
			)
		);
		validatorJson.put("stake", new JSONObject()
			.put("token_identifier", new JSONObject()
				.put("rri", addressing.forResources().of("xrd", REAddr.ofNativeToken()))
			)
			.put("value", stakeEstimateString)
		);
		try {
			return JSON.getDefault().getMapper().readValue(validatorJson.toString(), Validator.class);
		} catch (IOException e) {
			throw new IllegalStateException();
		}
	}

	public Validator getValidatorInfo(ECPublicKey validatorKey) {
		var validatorJson = getCurrentValidatorInfo(validatorKey, null, null);
		return mapValidator(validatorJson);
	}

	private static class ValidatorsIterator implements Iterator<JSONObject> {
		private final long skip;
		private final DatabaseEntry key = new DatabaseEntry();
		private final DatabaseEntry value = new DatabaseEntry();
		private final SecondaryDatabase db;
		private SecondaryCursor cursor;
		private OperationStatus status;

		ValidatorsIterator(SecondaryDatabase db, long skip) {
			this.db = db;
			this.skip = skip;
		}

		void open() {
			cursor = db.openCursor(null, null);
			status = cursor.getLast(null, key, skip == 0 ? value : null, null) != null ? SUCCESS : OperationStatus.NOTFOUND;
			for (int i = 0; status != SUCCESS && (i < skip); i++) {
				status = cursor.getPrev(key, (i == skip - 1) ? value : null, null);
			}
		}

		void close() {
			if (cursor != null) {
				cursor.close();
			}
		}

		@Override
		public boolean hasNext() {
			return status == SUCCESS;
		}

		@Override
		public JSONObject next() {
			if (status != SUCCESS) {
				throw new NoSuchElementException();
			}
			var next = new JSONObject(new String(value.getData(), StandardCharsets.UTF_8));
			status = cursor.getPrev(key, value, null);
			return next;
		}
	}

	public Stream<Validator> getValidators(long skip) {
		var iterator = new ValidatorsIterator(orderedValidatorsDatabase, skip);
		iterator.open();
		return Streams.stream(iterator)
			.map(this::mapValidator)
			.onClose(iterator::close);
	}

	private JSONObject getCurrentValidatorInfo(ECPublicKey validatorKey, Transaction dbTxn, LockMode lockMode) {
		var key = new DatabaseEntry(validatorKey.getBytes());
		var value = new DatabaseEntry();
		var status = validatorDatabase.get(dbTxn, key, value, lockMode);
		final JSONObject validatorJson;
		if (status == OperationStatus.SUCCESS) {
			var jsonString = new String(value.getData(), StandardCharsets.UTF_8);
			validatorJson = new JSONObject(jsonString);
		} else if (status == OperationStatus.NOTFOUND) {
			validatorJson = createValidatorInfoDefault(validatorKey);
		} else {
			throw new IllegalStateException("Unexpected status: " + status);
		}


		return validatorJson;
	}

	private JSONObject createValidatorInfoDefault(ECPublicKey validatorKey) {
		var json = new JSONObject()
			.put("validator_identifier", new JSONObject()
				.put("address", addressing.forValidators().of(validatorKey))
			)
			.put("properties", new JSONObject())
			.put("stake", new JSONObject()
				.put("delegators", new JSONObject())
				.put("preparedStake", "0")
				.put("exitingOwnership", "0")
				.put("currentStake", "0")
				.put("currentOwnership", "0")
				.put("nextEpochEstimatedStake", "0")
				.put("nextEpochEstimatedOwnerStake", "0")
			);
		var p = getData(ValidatorOwnerCopy.createVirtual(validatorKey));
		updateJson(json, p.getFirst(), p.getSecond());
		p = getData(AllowDelegationFlag.createVirtual(validatorKey));
		updateJson(json, p.getFirst(), p.getSecond());
		p = getData(ValidatorFeeCopy.createVirtual(validatorKey));
		updateJson(json, p.getFirst(), p.getSecond());
		p = getData(ValidatorRegisteredCopy.createVirtual(validatorKey));
		updateJson(json, p.getFirst(), p.getSecond());
		p = getData(ValidatorMetaData.createVirtual(validatorKey));
		updateJson(json, p.getFirst(), p.getSecond());
		return json;
	}

	private Pair<String, Map<String, Object>> getData(ValidatorData validatorData) {
		if (validatorData instanceof ValidatorOwnerCopy) {
			var copy = (ValidatorOwnerCopy) validatorData;
			return Pair.of(
				"properties",
				Map.of("owner_address", addressing.forAccounts().of(copy.getOwner()))
			);
		} else if (validatorData instanceof AllowDelegationFlag) {
			var allowDelegationFlag = (AllowDelegationFlag) validatorData;
			return Pair.of(
				"properties",
				Map.of("external_stake_accepted", allowDelegationFlag.allowsDelegation())
			);
		} else if (validatorData instanceof ValidatorFeeCopy) {
			var copy = (ValidatorFeeCopy) validatorData;
			return Pair.of(
				"properties",
				Map.of("validator_fee", (double) copy.getRakePercentage() / (double) RAKE_PERCENTAGE_GRANULARITY + "")
			);
		} else if (validatorData instanceof ValidatorMetaData) {
			var meta = (ValidatorMetaData) validatorData;
			return Pair.of("properties", Map.of("name", meta.getName(), "url", meta.getUrl()));
		} else if (validatorData instanceof ValidatorRegisteredCopy) {
			var copy = (ValidatorRegisteredCopy) validatorData;
			return Pair.of("properties", Map.of("registered", copy.isRegistered()));
		}
		return Pair.of(null, Map.of());
	}

	private void storeValidator(Transaction dbTxn, ECPublicKey validatorKey, JSONObject json) {
		var key = new DatabaseEntry(validatorKey.getBytes());
		var value = new DatabaseEntry();
		value.setData(json.toString().getBytes(StandardCharsets.UTF_8));
		var status = validatorDatabase.put(dbTxn, key, value);
		if (status != OperationStatus.SUCCESS) {
			throw new IllegalStateException("Unexpected status: " + status);
		}
	}

	private JSONObject getDelegatorObject(JSONObject delegators, String delegatorAddress) {
		var delegator = delegators.optJSONObject(delegatorAddress);
		return delegator == null ? new JSONObject() : delegator;
	}

	private boolean updateDelegatorObject(
		JSONObject validatorJson,
		JSONObject delegatorJson,
		BigInteger exitingOwnership,
		BigInteger preparedStake,
		BigInteger ownership
	) {
		if (exitingOwnership != null) {
			if (exitingOwnership.compareTo(BigInteger.ZERO) == 0) {
				delegatorJson.remove("exitingOwnership");
			} else {
				delegatorJson.put("exitingOwnership", exitingOwnership.toString(10));
			}
		}

		if (preparedStake != null) {
			if (preparedStake.compareTo(BigInteger.ZERO) == 0) {
				delegatorJson.remove("preparedStake");
			} else {
				delegatorJson.put("preparedStake", preparedStake.toString(10));
			}
		}

		if (ownership != null) {
			if (ownership.compareTo(BigInteger.ZERO) == 0) {
				delegatorJson.remove("currentOwnership");
			} else {
				delegatorJson.put("currentOwnership", ownership.toString(10));
			}
		}

		var isEmpty = delegatorJson.keySet().isEmpty();
		if (!isEmpty) {
			var updatedOwnership = new BigInteger(delegatorJson.optString("currentOwnership", "0"), 10);
			var updatedExitingOwnership = new BigInteger(delegatorJson.optString("exitingOwnership", "0"), 10);
			var updatedPreparedStake = new BigInteger(delegatorJson.optString("preparedStake", "0"), 10);
			var curStake = new BigInteger(validatorJson.getJSONObject("stake").getString("currentStake"), 10);
			var curOwnership = new BigInteger(validatorJson.getJSONObject("stake").getString("currentOwnership"), 10);
			var stakeFromOwnership = curOwnership.equals(BigInteger.ZERO)
				? BigInteger.ZERO
				: updatedOwnership.subtract(updatedExitingOwnership).multiply(curStake).divide(curOwnership);
			var nextEpochEstimatedStake = stakeFromOwnership.add(updatedPreparedStake);
			delegatorJson.put("nextEpochEstimatedStake", nextEpochEstimatedStake);
		}
		return isEmpty;
	}

	private void updateStake(Transaction dbTxn, ECPublicKey validatorKey, BigInteger amount) {
		var json = getCurrentValidatorInfo(validatorKey, dbTxn, LockMode.READ_UNCOMMITTED);
		var stakeJson = json.getJSONObject("stake");
		var currentOwnership = new BigInteger(stakeJson.getString("currentStake"), 10);
		var updateAmount = currentOwnership.add(amount);
		stakeJson.put("currentStake", updateAmount.toString(10));
		storeValidator(dbTxn, validatorKey, json);
	}

	private void updateOwnership(Transaction dbTxn, ECPublicKey validatorKey, REAddr owner, BigInteger amount) {
		var json = getCurrentValidatorInfo(validatorKey, dbTxn, LockMode.READ_UNCOMMITTED);
		var stakeJson = json.getJSONObject("stake");
		var currentOwnership = new BigInteger(stakeJson.getString("currentOwnership"), 10);
		var updateAmount = currentOwnership.add(amount);
		stakeJson.put("currentOwnership", updateAmount.toString(10));

		var delegators = json.getJSONObject("stake").getJSONObject("delegators");
		var address = addressing.forAccounts().of(owner);
		var delegator = getDelegatorObject(delegators, address);
		var ownership = new BigInteger(delegator.optString("currentOwnership", "0"), 10);
		var delegatorOwnershipAmount = ownership.add(amount);
		if (updateDelegatorObject(json, delegator, null, null, delegatorOwnershipAmount)) {
			delegators.remove(address);
		} else {
			delegators.put(address, delegator);
		}
		storeValidator(dbTxn, validatorKey, json);
	}

	private void updateExittingOwnership(Transaction dbTxn, ECPublicKey validatorKey, REAddr owner, BigInteger amount) {
		var json = getCurrentValidatorInfo(validatorKey, dbTxn, LockMode.READ_UNCOMMITTED);
		var stakeJson = json.getJSONObject("stake");
		var ownershipUnstake = new BigInteger(stakeJson.getString("exitingOwnership"), 10);
		var updateAmount = ownershipUnstake.add(amount);
		stakeJson.put("exitingOwnership", updateAmount.toString(10));

		var delegators = stakeJson.getJSONObject("delegators");
		var address = addressing.forAccounts().of(owner);
		var delegator = getDelegatorObject(delegators, address);
		var exitingOwnership = new BigInteger(delegator.optString("exitingOwnership", "0"), 10);
		var delegatorUpdateAmount = exitingOwnership.add(amount);
		if (updateDelegatorObject(json, delegator, delegatorUpdateAmount, null, null)) {
			delegators.remove(address);
		} else {
			delegators.put(address, delegator);
		}

		storeValidator(dbTxn, validatorKey, json);
	}

	private void updatePreparedStake(Transaction dbTxn, ECPublicKey validatorKey, REAddr owner, BigInteger amount) {
		var json = getCurrentValidatorInfo(validatorKey, dbTxn, LockMode.READ_UNCOMMITTED);
		var stakeJson = json.getJSONObject("stake");
		var totalPrepared = new BigInteger(stakeJson.getString("preparedStake"), 10);
		var updateAmount = totalPrepared.add(amount);
		stakeJson.put("preparedStake", updateAmount.toString(10));

		if (owner != null) {
			var delegators = stakeJson.getJSONObject("delegators");
			var address = addressing.forAccounts().of(owner);
			var delegator = getDelegatorObject(delegators, address);
			var preparedStake = new BigInteger(delegator.optString("preparedStake", "0"), 10);
			var delegatorPreparedStakeUpdateAmount = preparedStake.add(amount);
			if (updateDelegatorObject(json, delegator, null, delegatorPreparedStakeUpdateAmount, null)) {
				delegators.remove(address);
			} else {
				delegators.put(address, delegator);
			}
			delegator.put("preparedStake", delegatorPreparedStakeUpdateAmount.toString(10));
			delegators.put(address, delegator);
		}

		storeValidator(dbTxn, validatorKey, json);
	}

	private void updateJson(JSONObject json, String key, Map<String, Object> data) {
		JSONObject toUpdate = key == null ? json : json.getJSONObject(key);
		data.forEach(toUpdate::put);
	}

	private void updateData(Transaction dbTxn, ValidatorData validatorData) {
		var validatorKey = validatorData.getValidatorKey();
		var p = getData(validatorData);
		if (!p.getSecond().isEmpty()) {
			var json = getCurrentValidatorInfo(validatorKey, dbTxn, LockMode.READ_UNCOMMITTED);
			updateJson(json, p.getFirst(), p.getSecond());
			storeValidator(dbTxn, validatorKey, json);
		}
	}

	private void updateNextEpochEstimates(JSONObject json) {
		var stakeJson = json.getJSONObject("stake");
		var curStake = new BigInteger(stakeJson.getString("currentStake"), 10);
		var preparedStake = new BigInteger(stakeJson.getString("preparedStake"), 10);
		var exitingOwnership = new BigInteger(stakeJson.getString("exitingOwnership"), 10);
		var curOwnership = new BigInteger(stakeJson.getString("currentOwnership"), 10);

		var curStakeFromOwnership = curOwnership.equals(BigInteger.ZERO)
			? BigInteger.ZERO
			: curOwnership.multiply(curStake).divide(curOwnership.add(exitingOwnership));
		var estimatedNextEpochStake = curStakeFromOwnership.add(preparedStake);
		stakeJson.put("nextEpochEstimatedStake", estimatedNextEpochStake.toString(10));

		var ownerAddress = json.getJSONObject("properties").getString("owner_address");
		var delegators = stakeJson.getJSONObject("delegators");
		var ownerDelegator = getDelegatorObject(delegators, ownerAddress);
		var estimatedOwnerStake = new BigInteger(ownerDelegator.optString("nextEpochEstimatedStake", "0"), 10);
		stakeJson.put("nextEpochEstimatedOwnerStake", estimatedOwnerStake.toString(10));
	}

	@Override
	public void process(Transaction dbTxn, REProcessedTxn txn, long stateVersion, Function<SystemMapKey, Optional<RawSubstateBytes>> mapper) {
		txn.stateUpdates()
			.filter(REStateUpdate::isBootUp)
			.map(REStateUpdate::getParsed)
			.filter(ValidatorData.class::isInstance)
			.map(ValidatorData.class::cast)
			.forEach(u -> updateData(dbTxn, u));

		var validatorsUpdate = new HashSet<ECPublicKey>();

		REResourceAccounting.compute(txn.stateUpdates()).bucketAccounting().entrySet().stream()
			.filter(e -> e.getKey().getValidatorKey() != null)
			.forEach(e -> {
				var validatorKey = e.getKey().getValidatorKey();
				validatorsUpdate.add(validatorKey);
				if (e.getKey() instanceof PreparedStakeBucket) {
					updatePreparedStake(dbTxn, validatorKey, e.getKey().getOwner(), e.getValue());
				} else if (e.getKey() instanceof ExittingOwnershipBucket) {
					updateExittingOwnership(dbTxn, validatorKey, e.getKey().getOwner(), e.getValue());
				} else if (e.getKey() instanceof StakeOwnershipBucket) {
					updateOwnership(dbTxn, validatorKey, e.getKey().getOwner(), e.getValue());
				} else if (e.getKey() instanceof StakeBucket) {
					updateStake(dbTxn, validatorKey, e.getValue());
				}
			});

		validatorsUpdate.forEach(k -> {
			var json = getCurrentValidatorInfo(k, dbTxn, LockMode.READ_UNCOMMITTED);
			updateNextEpochEstimates(json);
			storeValidator(dbTxn, k, json);
		});
	}
}

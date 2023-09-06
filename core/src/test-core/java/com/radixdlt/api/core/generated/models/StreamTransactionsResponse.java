/*
 * Babylon Core API - RCnet v3
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.core.generated.models;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.CommittedStateIdentifier;
import com.radixdlt.api.core.generated.models.CommittedTransaction;
import com.radixdlt.api.core.generated.models.LedgerProof;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * StreamTransactionsResponse
 */
@JsonPropertyOrder({
  StreamTransactionsResponse.JSON_PROPERTY_PREVIOUS_STATE_IDENTIFIERS,
  StreamTransactionsResponse.JSON_PROPERTY_FROM_STATE_VERSION,
  StreamTransactionsResponse.JSON_PROPERTY_COUNT,
  StreamTransactionsResponse.JSON_PROPERTY_MAX_LEDGER_STATE_VERSION,
  StreamTransactionsResponse.JSON_PROPERTY_TRANSACTIONS,
  StreamTransactionsResponse.JSON_PROPERTY_PROOFS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class StreamTransactionsResponse {
  public static final String JSON_PROPERTY_PREVIOUS_STATE_IDENTIFIERS = "previous_state_identifiers";
  private CommittedStateIdentifier previousStateIdentifiers;

  public static final String JSON_PROPERTY_FROM_STATE_VERSION = "from_state_version";
  private Long fromStateVersion;

  public static final String JSON_PROPERTY_COUNT = "count";
  private Integer count;

  public static final String JSON_PROPERTY_MAX_LEDGER_STATE_VERSION = "max_ledger_state_version";
  private Long maxLedgerStateVersion;

  public static final String JSON_PROPERTY_TRANSACTIONS = "transactions";
  private List<CommittedTransaction> transactions = new ArrayList<>();

  public static final String JSON_PROPERTY_PROOFS = "proofs";
  private List<LedgerProof> proofs = null;

  public StreamTransactionsResponse() { 
  }

  public StreamTransactionsResponse previousStateIdentifiers(CommittedStateIdentifier previousStateIdentifiers) {
    this.previousStateIdentifiers = previousStateIdentifiers;
    return this;
  }

   /**
   * Get previousStateIdentifiers
   * @return previousStateIdentifiers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PREVIOUS_STATE_IDENTIFIERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CommittedStateIdentifier getPreviousStateIdentifiers() {
    return previousStateIdentifiers;
  }


  @JsonProperty(JSON_PROPERTY_PREVIOUS_STATE_IDENTIFIERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPreviousStateIdentifiers(CommittedStateIdentifier previousStateIdentifiers) {
    this.previousStateIdentifiers = previousStateIdentifiers;
  }


  public StreamTransactionsResponse fromStateVersion(Long fromStateVersion) {
    this.fromStateVersion = fromStateVersion;
    return this;
  }

   /**
   * Get fromStateVersion
   * minimum: 1
   * maximum: 100000000000000
   * @return fromStateVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_FROM_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getFromStateVersion() {
    return fromStateVersion;
  }


  @JsonProperty(JSON_PROPERTY_FROM_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFromStateVersion(Long fromStateVersion) {
    this.fromStateVersion = fromStateVersion;
  }


  public StreamTransactionsResponse count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10000&#x60;, giving the total count of transactions in the returned response
   * minimum: 0
   * maximum: 10000
   * @return count
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10000`, giving the total count of transactions in the returned response")
  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getCount() {
    return count;
  }


  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCount(Integer count) {
    this.count = count;
  }


  public StreamTransactionsResponse maxLedgerStateVersion(Long maxLedgerStateVersion) {
    this.maxLedgerStateVersion = maxLedgerStateVersion;
    return this;
  }

   /**
   * Get maxLedgerStateVersion
   * minimum: 1
   * maximum: 100000000000000
   * @return maxLedgerStateVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_MAX_LEDGER_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getMaxLedgerStateVersion() {
    return maxLedgerStateVersion;
  }


  @JsonProperty(JSON_PROPERTY_MAX_LEDGER_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMaxLedgerStateVersion(Long maxLedgerStateVersion) {
    this.maxLedgerStateVersion = maxLedgerStateVersion;
  }


  public StreamTransactionsResponse transactions(List<CommittedTransaction> transactions) {
    this.transactions = transactions;
    return this;
  }

  public StreamTransactionsResponse addTransactionsItem(CommittedTransaction transactionsItem) {
    this.transactions.add(transactionsItem);
    return this;
  }

   /**
   * A committed transactions list starting from the &#x60;from_state_version&#x60; (inclusive).
   * @return transactions
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A committed transactions list starting from the `from_state_version` (inclusive).")
  @JsonProperty(JSON_PROPERTY_TRANSACTIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<CommittedTransaction> getTransactions() {
    return transactions;
  }


  @JsonProperty(JSON_PROPERTY_TRANSACTIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTransactions(List<CommittedTransaction> transactions) {
    this.transactions = transactions;
  }


  public StreamTransactionsResponse proofs(List<LedgerProof> proofs) {
    this.proofs = proofs;
    return this;
  }

  public StreamTransactionsResponse addProofsItem(LedgerProof proofsItem) {
    if (this.proofs == null) {
      this.proofs = new ArrayList<>();
    }
    this.proofs.add(proofsItem);
    return this;
  }

   /**
   * A ledger proof list starting from &#x60;from_state_version&#x60; (inclusive) stored by this node.
   * @return proofs
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A ledger proof list starting from `from_state_version` (inclusive) stored by this node.")
  @JsonProperty(JSON_PROPERTY_PROOFS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<LedgerProof> getProofs() {
    return proofs;
  }


  @JsonProperty(JSON_PROPERTY_PROOFS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProofs(List<LedgerProof> proofs) {
    this.proofs = proofs;
  }


  /**
   * Return true if this StreamTransactionsResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StreamTransactionsResponse streamTransactionsResponse = (StreamTransactionsResponse) o;
    return Objects.equals(this.previousStateIdentifiers, streamTransactionsResponse.previousStateIdentifiers) &&
        Objects.equals(this.fromStateVersion, streamTransactionsResponse.fromStateVersion) &&
        Objects.equals(this.count, streamTransactionsResponse.count) &&
        Objects.equals(this.maxLedgerStateVersion, streamTransactionsResponse.maxLedgerStateVersion) &&
        Objects.equals(this.transactions, streamTransactionsResponse.transactions) &&
        Objects.equals(this.proofs, streamTransactionsResponse.proofs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(previousStateIdentifiers, fromStateVersion, count, maxLedgerStateVersion, transactions, proofs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StreamTransactionsResponse {\n");
    sb.append("    previousStateIdentifiers: ").append(toIndentedString(previousStateIdentifiers)).append("\n");
    sb.append("    fromStateVersion: ").append(toIndentedString(fromStateVersion)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    maxLedgerStateVersion: ").append(toIndentedString(maxLedgerStateVersion)).append("\n");
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
    sb.append("    proofs: ").append(toIndentedString(proofs)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}


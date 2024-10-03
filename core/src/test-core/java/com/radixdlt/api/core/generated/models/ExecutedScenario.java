/*
 * Radix Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.4
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
import com.radixdlt.api.core.generated.models.ExecutedScenarioTransaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ExecutedScenario
 */
@JsonPropertyOrder({
  ExecutedScenario.JSON_PROPERTY_SEQUENCE_NUMBER,
  ExecutedScenario.JSON_PROPERTY_LOGICAL_NAME,
  ExecutedScenario.JSON_PROPERTY_COMMITTED_TRANSACTIONS,
  ExecutedScenario.JSON_PROPERTY_ADDRESSES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ExecutedScenario {
  public static final String JSON_PROPERTY_SEQUENCE_NUMBER = "sequence_number";
  private Integer sequenceNumber;

  public static final String JSON_PROPERTY_LOGICAL_NAME = "logical_name";
  private String logicalName;

  public static final String JSON_PROPERTY_COMMITTED_TRANSACTIONS = "committed_transactions";
  private List<ExecutedScenarioTransaction> committedTransactions = new ArrayList<>();

  public static final String JSON_PROPERTY_ADDRESSES = "addresses";
  private Map<String, String> addresses = new HashMap<>();

  public ExecutedScenario() { 
  }

  public ExecutedScenario sequenceNumber(Integer sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
    return this;
  }

   /**
   * An index of the Scenario (reflecting its execution order).
   * minimum: 0
   * maximum: 1000000
   * @return sequenceNumber
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An index of the Scenario (reflecting its execution order).")
  @JsonProperty(JSON_PROPERTY_SEQUENCE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getSequenceNumber() {
    return sequenceNumber;
  }


  @JsonProperty(JSON_PROPERTY_SEQUENCE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSequenceNumber(Integer sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }


  public ExecutedScenario logicalName(String logicalName) {
    this.logicalName = logicalName;
    return this;
  }

   /**
   * Get logicalName
   * @return logicalName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_LOGICAL_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLogicalName() {
    return logicalName;
  }


  @JsonProperty(JSON_PROPERTY_LOGICAL_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLogicalName(String logicalName) {
    this.logicalName = logicalName;
  }


  public ExecutedScenario committedTransactions(List<ExecutedScenarioTransaction> committedTransactions) {
    this.committedTransactions = committedTransactions;
    return this;
  }

  public ExecutedScenario addCommittedTransactionsItem(ExecutedScenarioTransaction committedTransactionsItem) {
    this.committedTransactions.add(committedTransactionsItem);
    return this;
  }

   /**
   * Transactions successfully committed by the Scenario.
   * @return committedTransactions
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Transactions successfully committed by the Scenario.")
  @JsonProperty(JSON_PROPERTY_COMMITTED_TRANSACTIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<ExecutedScenarioTransaction> getCommittedTransactions() {
    return committedTransactions;
  }


  @JsonProperty(JSON_PROPERTY_COMMITTED_TRANSACTIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCommittedTransactions(List<ExecutedScenarioTransaction> committedTransactions) {
    this.committedTransactions = committedTransactions;
  }


  public ExecutedScenario addresses(Map<String, String> addresses) {
    this.addresses = addresses;
    return this;
  }

  public ExecutedScenario putAddressesItem(String key, String addressesItem) {
    this.addresses.put(key, addressesItem);
    return this;
  }

   /**
   * Well-named addresses touched/created by the Scenario, keyed by their name. 
   * @return addresses
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Well-named addresses touched/created by the Scenario, keyed by their name. ")
  @JsonProperty(JSON_PROPERTY_ADDRESSES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Map<String, String> getAddresses() {
    return addresses;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESSES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAddresses(Map<String, String> addresses) {
    this.addresses = addresses;
  }


  /**
   * Return true if this ExecutedScenario object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExecutedScenario executedScenario = (ExecutedScenario) o;
    return Objects.equals(this.sequenceNumber, executedScenario.sequenceNumber) &&
        Objects.equals(this.logicalName, executedScenario.logicalName) &&
        Objects.equals(this.committedTransactions, executedScenario.committedTransactions) &&
        Objects.equals(this.addresses, executedScenario.addresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sequenceNumber, logicalName, committedTransactions, addresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExecutedScenario {\n");
    sb.append("    sequenceNumber: ").append(toIndentedString(sequenceNumber)).append("\n");
    sb.append("    logicalName: ").append(toIndentedString(logicalName)).append("\n");
    sb.append("    committedTransactions: ").append(toIndentedString(committedTransactions)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
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


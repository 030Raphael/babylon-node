/*
 * Babylon Core API - RCnet V2
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
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
import com.radixdlt.api.core.generated.models.LtsTransactionIntentStatus;
import com.radixdlt.api.core.generated.models.LtsTransactionPayloadDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * LtsTransactionStatusResponse
 */
@JsonPropertyOrder({
  LtsTransactionStatusResponse.JSON_PROPERTY_INTENT_STATUS,
  LtsTransactionStatusResponse.JSON_PROPERTY_STATUS_DESCRIPTION,
  LtsTransactionStatusResponse.JSON_PROPERTY_COMMITTED_STATE_VERSION,
  LtsTransactionStatusResponse.JSON_PROPERTY_INVALID_FROM_EPOCH,
  LtsTransactionStatusResponse.JSON_PROPERTY_KNOWN_PAYLOADS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class LtsTransactionStatusResponse {
  public static final String JSON_PROPERTY_INTENT_STATUS = "intent_status";
  private LtsTransactionIntentStatus intentStatus;

  public static final String JSON_PROPERTY_STATUS_DESCRIPTION = "status_description";
  private String statusDescription;

  public static final String JSON_PROPERTY_COMMITTED_STATE_VERSION = "committed_state_version";
  private Long committedStateVersion;

  public static final String JSON_PROPERTY_INVALID_FROM_EPOCH = "invalid_from_epoch";
  private Long invalidFromEpoch;

  public static final String JSON_PROPERTY_KNOWN_PAYLOADS = "known_payloads";
  private List<LtsTransactionPayloadDetails> knownPayloads = new ArrayList<>();

  public LtsTransactionStatusResponse() { 
  }

  public LtsTransactionStatusResponse intentStatus(LtsTransactionIntentStatus intentStatus) {
    this.intentStatus = intentStatus;
    return this;
  }

   /**
   * Get intentStatus
   * @return intentStatus
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_INTENT_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public LtsTransactionIntentStatus getIntentStatus() {
    return intentStatus;
  }


  @JsonProperty(JSON_PROPERTY_INTENT_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIntentStatus(LtsTransactionIntentStatus intentStatus) {
    this.intentStatus = intentStatus;
  }


  public LtsTransactionStatusResponse statusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
    return this;
  }

   /**
   * An explanation as to why the intent status is resolved as it is. 
   * @return statusDescription
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An explanation as to why the intent status is resolved as it is. ")
  @JsonProperty(JSON_PROPERTY_STATUS_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getStatusDescription() {
    return statusDescription;
  }


  @JsonProperty(JSON_PROPERTY_STATUS_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
  }


  public LtsTransactionStatusResponse committedStateVersion(Long committedStateVersion) {
    this.committedStateVersion = committedStateVersion;
    return this;
  }

   /**
   * An integer between &#x60;1&#x60; and &#x60;10^13&#x60;, giving the resultant state version when the transaction was committed. This is only present if the intent was committed (as a Success or Failure). This can be considered to be the auto-incrementing primary key for a committed tranasction, and can be used in (eg) to look up details on the transaction&#39;s outcome from the &#x60;/lts/stream/transaction-outcomes&#x60; endpoint. 
   * minimum: 1
   * maximum: 100000000000000
   * @return committedStateVersion
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An integer between `1` and `10^13`, giving the resultant state version when the transaction was committed. This is only present if the intent was committed (as a Success or Failure). This can be considered to be the auto-incrementing primary key for a committed tranasction, and can be used in (eg) to look up details on the transaction's outcome from the `/lts/stream/transaction-outcomes` endpoint. ")
  @JsonProperty(JSON_PROPERTY_COMMITTED_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getCommittedStateVersion() {
    return committedStateVersion;
  }


  @JsonProperty(JSON_PROPERTY_COMMITTED_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCommittedStateVersion(Long committedStateVersion) {
    this.committedStateVersion = committedStateVersion;
  }


  public LtsTransactionStatusResponse invalidFromEpoch(Long invalidFromEpoch) {
    this.invalidFromEpoch = invalidFromEpoch;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, marking the epoch from which the transaction will no longer be valid, and be permanently rejected. Only present if the intent status is InMempool or Unknown and we know about a payload. 
   * minimum: 0
   * maximum: 10000000000
   * @return invalidFromEpoch
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An integer between `0` and `10^10`, marking the epoch from which the transaction will no longer be valid, and be permanently rejected. Only present if the intent status is InMempool or Unknown and we know about a payload. ")
  @JsonProperty(JSON_PROPERTY_INVALID_FROM_EPOCH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getInvalidFromEpoch() {
    return invalidFromEpoch;
  }


  @JsonProperty(JSON_PROPERTY_INVALID_FROM_EPOCH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInvalidFromEpoch(Long invalidFromEpoch) {
    this.invalidFromEpoch = invalidFromEpoch;
  }


  public LtsTransactionStatusResponse knownPayloads(List<LtsTransactionPayloadDetails> knownPayloads) {
    this.knownPayloads = knownPayloads;
    return this;
  }

  public LtsTransactionStatusResponse addKnownPayloadsItem(LtsTransactionPayloadDetails knownPayloadsItem) {
    this.knownPayloads.add(knownPayloadsItem);
    return this;
  }

   /**
   * Get knownPayloads
   * @return knownPayloads
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_KNOWN_PAYLOADS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<LtsTransactionPayloadDetails> getKnownPayloads() {
    return knownPayloads;
  }


  @JsonProperty(JSON_PROPERTY_KNOWN_PAYLOADS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKnownPayloads(List<LtsTransactionPayloadDetails> knownPayloads) {
    this.knownPayloads = knownPayloads;
  }


  /**
   * Return true if this LtsTransactionStatusResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LtsTransactionStatusResponse ltsTransactionStatusResponse = (LtsTransactionStatusResponse) o;
    return Objects.equals(this.intentStatus, ltsTransactionStatusResponse.intentStatus) &&
        Objects.equals(this.statusDescription, ltsTransactionStatusResponse.statusDescription) &&
        Objects.equals(this.committedStateVersion, ltsTransactionStatusResponse.committedStateVersion) &&
        Objects.equals(this.invalidFromEpoch, ltsTransactionStatusResponse.invalidFromEpoch) &&
        Objects.equals(this.knownPayloads, ltsTransactionStatusResponse.knownPayloads);
  }

  @Override
  public int hashCode() {
    return Objects.hash(intentStatus, statusDescription, committedStateVersion, invalidFromEpoch, knownPayloads);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LtsTransactionStatusResponse {\n");
    sb.append("    intentStatus: ").append(toIndentedString(intentStatus)).append("\n");
    sb.append("    statusDescription: ").append(toIndentedString(statusDescription)).append("\n");
    sb.append("    committedStateVersion: ").append(toIndentedString(committedStateVersion)).append("\n");
    sb.append("    invalidFromEpoch: ").append(toIndentedString(invalidFromEpoch)).append("\n");
    sb.append("    knownPayloads: ").append(toIndentedString(knownPayloads)).append("\n");
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


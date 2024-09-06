/*
 * Radix Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.3
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
import com.radixdlt.api.core.generated.models.CostingParameters;
import com.radixdlt.api.core.generated.models.Event;
import com.radixdlt.api.core.generated.models.FeeDestination;
import com.radixdlt.api.core.generated.models.FeeSource;
import com.radixdlt.api.core.generated.models.FeeSummary;
import com.radixdlt.api.core.generated.models.NextEpoch;
import com.radixdlt.api.core.generated.models.SborData;
import com.radixdlt.api.core.generated.models.StateUpdates;
import com.radixdlt.api.core.generated.models.TransactionStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * The transaction execution receipt
 */
@ApiModel(description = "The transaction execution receipt")
@JsonPropertyOrder({
  TransactionReceipt.JSON_PROPERTY_STATUS,
  TransactionReceipt.JSON_PROPERTY_FEE_SUMMARY,
  TransactionReceipt.JSON_PROPERTY_COSTING_PARAMETERS,
  TransactionReceipt.JSON_PROPERTY_FEE_SOURCE,
  TransactionReceipt.JSON_PROPERTY_FEE_DESTINATION,
  TransactionReceipt.JSON_PROPERTY_STATE_UPDATES,
  TransactionReceipt.JSON_PROPERTY_EVENTS,
  TransactionReceipt.JSON_PROPERTY_NEXT_EPOCH,
  TransactionReceipt.JSON_PROPERTY_OUTPUT,
  TransactionReceipt.JSON_PROPERTY_ERROR_MESSAGE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TransactionReceipt {
  public static final String JSON_PROPERTY_STATUS = "status";
  private TransactionStatus status;

  public static final String JSON_PROPERTY_FEE_SUMMARY = "fee_summary";
  private FeeSummary feeSummary;

  public static final String JSON_PROPERTY_COSTING_PARAMETERS = "costing_parameters";
  private CostingParameters costingParameters;

  public static final String JSON_PROPERTY_FEE_SOURCE = "fee_source";
  private FeeSource feeSource;

  public static final String JSON_PROPERTY_FEE_DESTINATION = "fee_destination";
  private FeeDestination feeDestination;

  public static final String JSON_PROPERTY_STATE_UPDATES = "state_updates";
  private StateUpdates stateUpdates;

  public static final String JSON_PROPERTY_EVENTS = "events";
  private List<Event> events = null;

  public static final String JSON_PROPERTY_NEXT_EPOCH = "next_epoch";
  private NextEpoch nextEpoch;

  public static final String JSON_PROPERTY_OUTPUT = "output";
  private List<SborData> output = null;

  public static final String JSON_PROPERTY_ERROR_MESSAGE = "error_message";
  private String errorMessage;

  public TransactionReceipt() { 
  }

  public TransactionReceipt status(TransactionStatus status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TransactionStatus getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatus(TransactionStatus status) {
    this.status = status;
  }


  public TransactionReceipt feeSummary(FeeSummary feeSummary) {
    this.feeSummary = feeSummary;
    return this;
  }

   /**
   * Get feeSummary
   * @return feeSummary
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_FEE_SUMMARY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public FeeSummary getFeeSummary() {
    return feeSummary;
  }


  @JsonProperty(JSON_PROPERTY_FEE_SUMMARY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFeeSummary(FeeSummary feeSummary) {
    this.feeSummary = feeSummary;
  }


  public TransactionReceipt costingParameters(CostingParameters costingParameters) {
    this.costingParameters = costingParameters;
    return this;
  }

   /**
   * Get costingParameters
   * @return costingParameters
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_COSTING_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public CostingParameters getCostingParameters() {
    return costingParameters;
  }


  @JsonProperty(JSON_PROPERTY_COSTING_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCostingParameters(CostingParameters costingParameters) {
    this.costingParameters = costingParameters;
  }


  public TransactionReceipt feeSource(FeeSource feeSource) {
    this.feeSource = feeSource;
    return this;
  }

   /**
   * Get feeSource
   * @return feeSource
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FEE_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public FeeSource getFeeSource() {
    return feeSource;
  }


  @JsonProperty(JSON_PROPERTY_FEE_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFeeSource(FeeSource feeSource) {
    this.feeSource = feeSource;
  }


  public TransactionReceipt feeDestination(FeeDestination feeDestination) {
    this.feeDestination = feeDestination;
    return this;
  }

   /**
   * Get feeDestination
   * @return feeDestination
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FEE_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public FeeDestination getFeeDestination() {
    return feeDestination;
  }


  @JsonProperty(JSON_PROPERTY_FEE_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFeeDestination(FeeDestination feeDestination) {
    this.feeDestination = feeDestination;
  }


  public TransactionReceipt stateUpdates(StateUpdates stateUpdates) {
    this.stateUpdates = stateUpdates;
    return this;
  }

   /**
   * Get stateUpdates
   * @return stateUpdates
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STATE_UPDATES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public StateUpdates getStateUpdates() {
    return stateUpdates;
  }


  @JsonProperty(JSON_PROPERTY_STATE_UPDATES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStateUpdates(StateUpdates stateUpdates) {
    this.stateUpdates = stateUpdates;
  }


  public TransactionReceipt events(List<Event> events) {
    this.events = events;
    return this;
  }

  public TransactionReceipt addEventsItem(Event eventsItem) {
    if (this.events == null) {
      this.events = new ArrayList<>();
    }
    this.events.add(eventsItem);
    return this;
  }

   /**
   * Get events
   * @return events
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Event> getEvents() {
    return events;
  }


  @JsonProperty(JSON_PROPERTY_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEvents(List<Event> events) {
    this.events = events;
  }


  public TransactionReceipt nextEpoch(NextEpoch nextEpoch) {
    this.nextEpoch = nextEpoch;
    return this;
  }

   /**
   * Get nextEpoch
   * @return nextEpoch
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NEXT_EPOCH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public NextEpoch getNextEpoch() {
    return nextEpoch;
  }


  @JsonProperty(JSON_PROPERTY_NEXT_EPOCH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNextEpoch(NextEpoch nextEpoch) {
    this.nextEpoch = nextEpoch;
  }


  public TransactionReceipt output(List<SborData> output) {
    this.output = output;
    return this;
  }

  public TransactionReceipt addOutputItem(SborData outputItem) {
    if (this.output == null) {
      this.output = new ArrayList<>();
    }
    this.output.add(outputItem);
    return this;
  }

   /**
   * The manifest line-by-line engine return data (only present if &#x60;status&#x60; is &#x60;Succeeded&#x60;)
   * @return output
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The manifest line-by-line engine return data (only present if `status` is `Succeeded`)")
  @JsonProperty(JSON_PROPERTY_OUTPUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SborData> getOutput() {
    return output;
  }


  @JsonProperty(JSON_PROPERTY_OUTPUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOutput(List<SborData> output) {
    this.output = output;
  }


  public TransactionReceipt errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

   /**
   * Error message (only present if status is &#x60;Failed&#x60; or &#x60;Rejected&#x60;)
   * @return errorMessage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Error message (only present if status is `Failed` or `Rejected`)")
  @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getErrorMessage() {
    return errorMessage;
  }


  @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }


  /**
   * Return true if this TransactionReceipt object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionReceipt transactionReceipt = (TransactionReceipt) o;
    return Objects.equals(this.status, transactionReceipt.status) &&
        Objects.equals(this.feeSummary, transactionReceipt.feeSummary) &&
        Objects.equals(this.costingParameters, transactionReceipt.costingParameters) &&
        Objects.equals(this.feeSource, transactionReceipt.feeSource) &&
        Objects.equals(this.feeDestination, transactionReceipt.feeDestination) &&
        Objects.equals(this.stateUpdates, transactionReceipt.stateUpdates) &&
        Objects.equals(this.events, transactionReceipt.events) &&
        Objects.equals(this.nextEpoch, transactionReceipt.nextEpoch) &&
        Objects.equals(this.output, transactionReceipt.output) &&
        Objects.equals(this.errorMessage, transactionReceipt.errorMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, feeSummary, costingParameters, feeSource, feeDestination, stateUpdates, events, nextEpoch, output, errorMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionReceipt {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    feeSummary: ").append(toIndentedString(feeSummary)).append("\n");
    sb.append("    costingParameters: ").append(toIndentedString(costingParameters)).append("\n");
    sb.append("    feeSource: ").append(toIndentedString(feeSource)).append("\n");
    sb.append("    feeDestination: ").append(toIndentedString(feeDestination)).append("\n");
    sb.append("    stateUpdates: ").append(toIndentedString(stateUpdates)).append("\n");
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
    sb.append("    nextEpoch: ").append(toIndentedString(nextEpoch)).append("\n");
    sb.append("    output: ").append(toIndentedString(output)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
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


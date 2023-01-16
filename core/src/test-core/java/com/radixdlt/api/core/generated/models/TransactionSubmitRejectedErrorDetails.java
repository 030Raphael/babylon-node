/*
 * Babylon Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.2.0
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
import com.radixdlt.api.core.generated.models.TransactionSubmitErrorDetailsBase;
import com.radixdlt.api.core.generated.models.TransactionSubmitErrorDetailsType;
import com.radixdlt.api.core.generated.models.TransactionSubmitRejectedErrorDetailsAllOf;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * TransactionSubmitRejectedErrorDetails
 */
@JsonPropertyOrder({
  TransactionSubmitRejectedErrorDetails.JSON_PROPERTY_TYPE,
  TransactionSubmitRejectedErrorDetails.JSON_PROPERTY_ERROR_MESSAGE,
  TransactionSubmitRejectedErrorDetails.JSON_PROPERTY_IS_FRESH,
  TransactionSubmitRejectedErrorDetails.JSON_PROPERTY_IS_PAYLOAD_REJECTION_PERMANENT,
  TransactionSubmitRejectedErrorDetails.JSON_PROPERTY_IS_INTENT_REJECTION_PERMANENT,
  TransactionSubmitRejectedErrorDetails.JSON_PROPERTY_IS_REJECTED_BECAUSE_INTENT_ALREADY_COMMITTED,
  TransactionSubmitRejectedErrorDetails.JSON_PROPERTY_RECALCULATION_DUE,
  TransactionSubmitRejectedErrorDetails.JSON_PROPERTY_INVALID_FROM_EPOCH
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TransactionSubmitRejectedErrorDetails {
  public static final String JSON_PROPERTY_TYPE = "type";
  private TransactionSubmitErrorDetailsType type;

  public static final String JSON_PROPERTY_ERROR_MESSAGE = "error_message";
  private String errorMessage;

  public static final String JSON_PROPERTY_IS_FRESH = "is_fresh";
  private Boolean isFresh;

  public static final String JSON_PROPERTY_IS_PAYLOAD_REJECTION_PERMANENT = "is_payload_rejection_permanent";
  private Boolean isPayloadRejectionPermanent;

  public static final String JSON_PROPERTY_IS_INTENT_REJECTION_PERMANENT = "is_intent_rejection_permanent";
  private Boolean isIntentRejectionPermanent;

  public static final String JSON_PROPERTY_IS_REJECTED_BECAUSE_INTENT_ALREADY_COMMITTED = "is_rejected_because_intent_already_committed";
  private Boolean isRejectedBecauseIntentAlreadyCommitted;

  public static final String JSON_PROPERTY_RECALCULATION_DUE = "recalculation_due";
  private Long recalculationDue;

  public static final String JSON_PROPERTY_INVALID_FROM_EPOCH = "invalid_from_epoch";
  private Long invalidFromEpoch;

  public TransactionSubmitRejectedErrorDetails() { 
  }

  public TransactionSubmitRejectedErrorDetails type(TransactionSubmitErrorDetailsType type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TransactionSubmitErrorDetailsType getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(TransactionSubmitErrorDetailsType type) {
    this.type = type;
  }


  public TransactionSubmitRejectedErrorDetails errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

   /**
   * An explanation of the error
   * @return errorMessage
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An explanation of the error")
  @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getErrorMessage() {
    return errorMessage;
  }


  @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }


  public TransactionSubmitRejectedErrorDetails isFresh(Boolean isFresh) {
    this.isFresh = isFresh;
    return this;
  }

   /**
   * Whether (true) this rejected status has just been calculated fresh, or (false) the status is from the pending transaction result cache. 
   * @return isFresh
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Whether (true) this rejected status has just been calculated fresh, or (false) the status is from the pending transaction result cache. ")
  @JsonProperty(JSON_PROPERTY_IS_FRESH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getIsFresh() {
    return isFresh;
  }


  @JsonProperty(JSON_PROPERTY_IS_FRESH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIsFresh(Boolean isFresh) {
    this.isFresh = isFresh;
  }


  public TransactionSubmitRejectedErrorDetails isPayloadRejectionPermanent(Boolean isPayloadRejectionPermanent) {
    this.isPayloadRejectionPermanent = isPayloadRejectionPermanent;
    return this;
  }

   /**
   * Whether the rejection of this payload is known to be permanent. 
   * @return isPayloadRejectionPermanent
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Whether the rejection of this payload is known to be permanent. ")
  @JsonProperty(JSON_PROPERTY_IS_PAYLOAD_REJECTION_PERMANENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getIsPayloadRejectionPermanent() {
    return isPayloadRejectionPermanent;
  }


  @JsonProperty(JSON_PROPERTY_IS_PAYLOAD_REJECTION_PERMANENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIsPayloadRejectionPermanent(Boolean isPayloadRejectionPermanent) {
    this.isPayloadRejectionPermanent = isPayloadRejectionPermanent;
  }


  public TransactionSubmitRejectedErrorDetails isIntentRejectionPermanent(Boolean isIntentRejectionPermanent) {
    this.isIntentRejectionPermanent = isIntentRejectionPermanent;
    return this;
  }

   /**
   * Whether the rejection of this intent is known to be permanent - this is a stronger statement than the payload rejection being permanent, as it implies any payloads containing the intent will also be permanently rejected. 
   * @return isIntentRejectionPermanent
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Whether the rejection of this intent is known to be permanent - this is a stronger statement than the payload rejection being permanent, as it implies any payloads containing the intent will also be permanently rejected. ")
  @JsonProperty(JSON_PROPERTY_IS_INTENT_REJECTION_PERMANENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getIsIntentRejectionPermanent() {
    return isIntentRejectionPermanent;
  }


  @JsonProperty(JSON_PROPERTY_IS_INTENT_REJECTION_PERMANENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIsIntentRejectionPermanent(Boolean isIntentRejectionPermanent) {
    this.isIntentRejectionPermanent = isIntentRejectionPermanent;
  }


  public TransactionSubmitRejectedErrorDetails isRejectedBecauseIntentAlreadyCommitted(Boolean isRejectedBecauseIntentAlreadyCommitted) {
    this.isRejectedBecauseIntentAlreadyCommitted = isRejectedBecauseIntentAlreadyCommitted;
    return this;
  }

   /**
   * Whether the cached rejection of this intent is due to the intent already having been committed. If so, see the /transaction/receipt endpoint for further information. 
   * @return isRejectedBecauseIntentAlreadyCommitted
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Whether the cached rejection of this intent is due to the intent already having been committed. If so, see the /transaction/receipt endpoint for further information. ")
  @JsonProperty(JSON_PROPERTY_IS_REJECTED_BECAUSE_INTENT_ALREADY_COMMITTED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getIsRejectedBecauseIntentAlreadyCommitted() {
    return isRejectedBecauseIntentAlreadyCommitted;
  }


  @JsonProperty(JSON_PROPERTY_IS_REJECTED_BECAUSE_INTENT_ALREADY_COMMITTED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIsRejectedBecauseIntentAlreadyCommitted(Boolean isRejectedBecauseIntentAlreadyCommitted) {
    this.isRejectedBecauseIntentAlreadyCommitted = isRejectedBecauseIntentAlreadyCommitted;
  }


  public TransactionSubmitRejectedErrorDetails recalculationDue(Long recalculationDue) {
    this.recalculationDue = recalculationDue;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^14&#x60;, marking the unix timestamp in milliseconds after which the node will consider recalculating the validity of the transaction. Only present if the rejection isn&#39;t permanent. 
   * minimum: 0
   * maximum: 100000000000000
   * @return recalculationDue
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An integer between `0` and `10^14`, marking the unix timestamp in milliseconds after which the node will consider recalculating the validity of the transaction. Only present if the rejection isn't permanent. ")
  @JsonProperty(JSON_PROPERTY_RECALCULATION_DUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getRecalculationDue() {
    return recalculationDue;
  }


  @JsonProperty(JSON_PROPERTY_RECALCULATION_DUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRecalculationDue(Long recalculationDue) {
    this.recalculationDue = recalculationDue;
  }


  public TransactionSubmitRejectedErrorDetails invalidFromEpoch(Long invalidFromEpoch) {
    this.invalidFromEpoch = invalidFromEpoch;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, marking the epoch from which the transaction will no longer be valid, and be permanently rejected. Only present if the rejection isn&#39;t permanent. 
   * minimum: 0
   * maximum: 10000000000
   * @return invalidFromEpoch
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An integer between `0` and `10^10`, marking the epoch from which the transaction will no longer be valid, and be permanently rejected. Only present if the rejection isn't permanent. ")
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


  /**
   * Return true if this TransactionSubmitRejectedErrorDetails object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionSubmitRejectedErrorDetails transactionSubmitRejectedErrorDetails = (TransactionSubmitRejectedErrorDetails) o;
    return Objects.equals(this.type, transactionSubmitRejectedErrorDetails.type) &&
        Objects.equals(this.errorMessage, transactionSubmitRejectedErrorDetails.errorMessage) &&
        Objects.equals(this.isFresh, transactionSubmitRejectedErrorDetails.isFresh) &&
        Objects.equals(this.isPayloadRejectionPermanent, transactionSubmitRejectedErrorDetails.isPayloadRejectionPermanent) &&
        Objects.equals(this.isIntentRejectionPermanent, transactionSubmitRejectedErrorDetails.isIntentRejectionPermanent) &&
        Objects.equals(this.isRejectedBecauseIntentAlreadyCommitted, transactionSubmitRejectedErrorDetails.isRejectedBecauseIntentAlreadyCommitted) &&
        Objects.equals(this.recalculationDue, transactionSubmitRejectedErrorDetails.recalculationDue) &&
        Objects.equals(this.invalidFromEpoch, transactionSubmitRejectedErrorDetails.invalidFromEpoch);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, errorMessage, isFresh, isPayloadRejectionPermanent, isIntentRejectionPermanent, isRejectedBecauseIntentAlreadyCommitted, recalculationDue, invalidFromEpoch);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionSubmitRejectedErrorDetails {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("    isFresh: ").append(toIndentedString(isFresh)).append("\n");
    sb.append("    isPayloadRejectionPermanent: ").append(toIndentedString(isPayloadRejectionPermanent)).append("\n");
    sb.append("    isIntentRejectionPermanent: ").append(toIndentedString(isIntentRejectionPermanent)).append("\n");
    sb.append("    isRejectedBecauseIntentAlreadyCommitted: ").append(toIndentedString(isRejectedBecauseIntentAlreadyCommitted)).append("\n");
    sb.append("    recalculationDue: ").append(toIndentedString(recalculationDue)).append("\n");
    sb.append("    invalidFromEpoch: ").append(toIndentedString(invalidFromEpoch)).append("\n");
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


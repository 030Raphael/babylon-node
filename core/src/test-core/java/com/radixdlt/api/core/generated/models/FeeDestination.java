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
import com.radixdlt.api.core.generated.models.PaymentToRoyaltyRecipient;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * FeeDestination
 */
@JsonPropertyOrder({
  FeeDestination.JSON_PROPERTY_TO_PROPOSER,
  FeeDestination.JSON_PROPERTY_TO_VALIDATOR_SET,
  FeeDestination.JSON_PROPERTY_TO_BURN,
  FeeDestination.JSON_PROPERTY_TO_ROYALTY_RECIPIENTS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class FeeDestination {
  public static final String JSON_PROPERTY_TO_PROPOSER = "to_proposer";
  private String toProposer;

  public static final String JSON_PROPERTY_TO_VALIDATOR_SET = "to_validator_set";
  private String toValidatorSet;

  public static final String JSON_PROPERTY_TO_BURN = "to_burn";
  private String toBurn;

  public static final String JSON_PROPERTY_TO_ROYALTY_RECIPIENTS = "to_royalty_recipients";
  private List<PaymentToRoyaltyRecipient> toRoyaltyRecipients = new ArrayList<>();

  public FeeDestination() { 
  }

  public FeeDestination toProposer(String toProposer) {
    this.toProposer = toProposer;
    return this;
  }

   /**
   * The string-encoded decimal representing the amount of fee in XRD paid to the proposer. A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(192 - 1) &lt;&#x3D; m &lt; 2^(192 - 1)&#x60;. 
   * @return toProposer
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The string-encoded decimal representing the amount of fee in XRD paid to the proposer. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_TO_PROPOSER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getToProposer() {
    return toProposer;
  }


  @JsonProperty(JSON_PROPERTY_TO_PROPOSER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setToProposer(String toProposer) {
    this.toProposer = toProposer;
  }


  public FeeDestination toValidatorSet(String toValidatorSet) {
    this.toValidatorSet = toValidatorSet;
    return this;
  }

   /**
   * The string-encoded decimal representing the amount of fee in XRD paid to the validator set. A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(192 - 1) &lt;&#x3D; m &lt; 2^(192 - 1)&#x60;. 
   * @return toValidatorSet
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The string-encoded decimal representing the amount of fee in XRD paid to the validator set. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_TO_VALIDATOR_SET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getToValidatorSet() {
    return toValidatorSet;
  }


  @JsonProperty(JSON_PROPERTY_TO_VALIDATOR_SET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setToValidatorSet(String toValidatorSet) {
    this.toValidatorSet = toValidatorSet;
  }


  public FeeDestination toBurn(String toBurn) {
    this.toBurn = toBurn;
    return this;
  }

   /**
   * The string-encoded decimal representing the amount of fee burnt, in XRD. A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(192 - 1) &lt;&#x3D; m &lt; 2^(192 - 1)&#x60;. 
   * @return toBurn
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The string-encoded decimal representing the amount of fee burnt, in XRD. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_TO_BURN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getToBurn() {
    return toBurn;
  }


  @JsonProperty(JSON_PROPERTY_TO_BURN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setToBurn(String toBurn) {
    this.toBurn = toBurn;
  }


  public FeeDestination toRoyaltyRecipients(List<PaymentToRoyaltyRecipient> toRoyaltyRecipients) {
    this.toRoyaltyRecipients = toRoyaltyRecipients;
    return this;
  }

  public FeeDestination addToRoyaltyRecipientsItem(PaymentToRoyaltyRecipient toRoyaltyRecipientsItem) {
    this.toRoyaltyRecipients.add(toRoyaltyRecipientsItem);
    return this;
  }

   /**
   * A breakdown of where the royalties were paid to. 
   * @return toRoyaltyRecipients
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A breakdown of where the royalties were paid to. ")
  @JsonProperty(JSON_PROPERTY_TO_ROYALTY_RECIPIENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<PaymentToRoyaltyRecipient> getToRoyaltyRecipients() {
    return toRoyaltyRecipients;
  }


  @JsonProperty(JSON_PROPERTY_TO_ROYALTY_RECIPIENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setToRoyaltyRecipients(List<PaymentToRoyaltyRecipient> toRoyaltyRecipients) {
    this.toRoyaltyRecipients = toRoyaltyRecipients;
  }


  /**
   * Return true if this FeeDestination object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FeeDestination feeDestination = (FeeDestination) o;
    return Objects.equals(this.toProposer, feeDestination.toProposer) &&
        Objects.equals(this.toValidatorSet, feeDestination.toValidatorSet) &&
        Objects.equals(this.toBurn, feeDestination.toBurn) &&
        Objects.equals(this.toRoyaltyRecipients, feeDestination.toRoyaltyRecipients);
  }

  @Override
  public int hashCode() {
    return Objects.hash(toProposer, toValidatorSet, toBurn, toRoyaltyRecipients);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FeeDestination {\n");
    sb.append("    toProposer: ").append(toIndentedString(toProposer)).append("\n");
    sb.append("    toValidatorSet: ").append(toIndentedString(toValidatorSet)).append("\n");
    sb.append("    toBurn: ").append(toIndentedString(toBurn)).append("\n");
    sb.append("    toRoyaltyRecipients: ").append(toIndentedString(toRoyaltyRecipients)).append("\n");
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


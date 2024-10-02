/*
 * Radix System API
 * This API is exposed by the Babylon Radix node to give clients access to information about the node itself, its configuration, status and subsystems.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against ledger state, you may also wish to consider using the [Core API or Gateway API instead](https://docs-babylon.radixdlt.com/main/apis/api-specification.html). 
 *
 * The version of the OpenAPI document: v1.2.3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.system.generated.models;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * SignalledReadinessThreshold
 */
@JsonPropertyOrder({
  SignalledReadinessThreshold.JSON_PROPERTY_REQUIRED_RATIO_OF_STAKE_SUPPORTED,
  SignalledReadinessThreshold.JSON_PROPERTY_REQUIRED_CONSECUTIVE_COMPLETED_EPOCHS_OF_SUPPORT
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SignalledReadinessThreshold {
  public static final String JSON_PROPERTY_REQUIRED_RATIO_OF_STAKE_SUPPORTED = "required_ratio_of_stake_supported";
  private String requiredRatioOfStakeSupported;

  public static final String JSON_PROPERTY_REQUIRED_CONSECUTIVE_COMPLETED_EPOCHS_OF_SUPPORT = "required_consecutive_completed_epochs_of_support";
  private Long requiredConsecutiveCompletedEpochsOfSupport;


  public SignalledReadinessThreshold requiredRatioOfStakeSupported(String requiredRatioOfStakeSupported) {
    this.requiredRatioOfStakeSupported = requiredRatioOfStakeSupported;
    return this;
  }

   /**
   * Get requiredRatioOfStakeSupported
   * @return requiredRatioOfStakeSupported
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_REQUIRED_RATIO_OF_STAKE_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getRequiredRatioOfStakeSupported() {
    return requiredRatioOfStakeSupported;
  }


  @JsonProperty(JSON_PROPERTY_REQUIRED_RATIO_OF_STAKE_SUPPORTED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRequiredRatioOfStakeSupported(String requiredRatioOfStakeSupported) {
    this.requiredRatioOfStakeSupported = requiredRatioOfStakeSupported;
  }


  public SignalledReadinessThreshold requiredConsecutiveCompletedEpochsOfSupport(Long requiredConsecutiveCompletedEpochsOfSupport) {
    this.requiredConsecutiveCompletedEpochsOfSupport = requiredConsecutiveCompletedEpochsOfSupport;
    return this;
  }

   /**
   * Get requiredConsecutiveCompletedEpochsOfSupport
   * @return requiredConsecutiveCompletedEpochsOfSupport
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_REQUIRED_CONSECUTIVE_COMPLETED_EPOCHS_OF_SUPPORT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getRequiredConsecutiveCompletedEpochsOfSupport() {
    return requiredConsecutiveCompletedEpochsOfSupport;
  }


  @JsonProperty(JSON_PROPERTY_REQUIRED_CONSECUTIVE_COMPLETED_EPOCHS_OF_SUPPORT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRequiredConsecutiveCompletedEpochsOfSupport(Long requiredConsecutiveCompletedEpochsOfSupport) {
    this.requiredConsecutiveCompletedEpochsOfSupport = requiredConsecutiveCompletedEpochsOfSupport;
  }


  /**
   * Return true if this SignalledReadinessThreshold object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignalledReadinessThreshold signalledReadinessThreshold = (SignalledReadinessThreshold) o;
    return Objects.equals(this.requiredRatioOfStakeSupported, signalledReadinessThreshold.requiredRatioOfStakeSupported) &&
        Objects.equals(this.requiredConsecutiveCompletedEpochsOfSupport, signalledReadinessThreshold.requiredConsecutiveCompletedEpochsOfSupport);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requiredRatioOfStakeSupported, requiredConsecutiveCompletedEpochsOfSupport);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignalledReadinessThreshold {\n");
    sb.append("    requiredRatioOfStakeSupported: ").append(toIndentedString(requiredRatioOfStakeSupported)).append("\n");
    sb.append("    requiredConsecutiveCompletedEpochsOfSupport: ").append(toIndentedString(requiredConsecutiveCompletedEpochsOfSupport)).append("\n");
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


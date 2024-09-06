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
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.system.generated.models.EnactAtStartOfEpochIfValidatorsReadyCondition;
import com.radixdlt.api.system.generated.models.EnactAtStartOfEpochIfValidatorsReadyConditionAllOf;
import com.radixdlt.api.system.generated.models.EnactAtStartOfEpochUnconditionallyCondition;
import com.radixdlt.api.system.generated.models.ProtocolUpdateEnactmentCondition;
import com.radixdlt.api.system.generated.models.ProtocolUpdateEnactmentConditionType;
import com.radixdlt.api.system.generated.models.SignalledReadinessThreshold;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.common.JSON;
/**
 * EnactAtStartOfEpochIfValidatorsReadyCondition
 */
@JsonPropertyOrder({
  EnactAtStartOfEpochIfValidatorsReadyCondition.JSON_PROPERTY_READINESS_SIGNAL,
  EnactAtStartOfEpochIfValidatorsReadyCondition.JSON_PROPERTY_LOWER_BOUND_EPOCH_INCLUSIVE,
  EnactAtStartOfEpochIfValidatorsReadyCondition.JSON_PROPERTY_UPPER_BOUND_EPOCH_EXCLUSIVE,
  EnactAtStartOfEpochIfValidatorsReadyCondition.JSON_PROPERTY_READINESS_THRESHOLDS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = EnactAtStartOfEpochIfValidatorsReadyCondition.class, name = "EnactAtStartOfEpochIfValidatorsReady"),
  @JsonSubTypes.Type(value = EnactAtStartOfEpochUnconditionallyCondition.class, name = "EnactAtStartOfEpochUnconditionally"),
})

public class EnactAtStartOfEpochIfValidatorsReadyCondition extends ProtocolUpdateEnactmentCondition {
  public static final String JSON_PROPERTY_READINESS_SIGNAL = "readiness_signal";
  private String readinessSignal;

  public static final String JSON_PROPERTY_LOWER_BOUND_EPOCH_INCLUSIVE = "lower_bound_epoch_inclusive";
  private Long lowerBoundEpochInclusive;

  public static final String JSON_PROPERTY_UPPER_BOUND_EPOCH_EXCLUSIVE = "upper_bound_epoch_exclusive";
  private Long upperBoundEpochExclusive;

  public static final String JSON_PROPERTY_READINESS_THRESHOLDS = "readiness_thresholds";
  private List<SignalledReadinessThreshold> readinessThresholds = new ArrayList<>();


  public EnactAtStartOfEpochIfValidatorsReadyCondition readinessSignal(String readinessSignal) {
    this.readinessSignal = readinessSignal;
    return this;
  }

   /**
   * Get readinessSignal
   * @return readinessSignal
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_READINESS_SIGNAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getReadinessSignal() {
    return readinessSignal;
  }


  @JsonProperty(JSON_PROPERTY_READINESS_SIGNAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setReadinessSignal(String readinessSignal) {
    this.readinessSignal = readinessSignal;
  }


  public EnactAtStartOfEpochIfValidatorsReadyCondition lowerBoundEpochInclusive(Long lowerBoundEpochInclusive) {
    this.lowerBoundEpochInclusive = lowerBoundEpochInclusive;
    return this;
  }

   /**
   * Get lowerBoundEpochInclusive
   * @return lowerBoundEpochInclusive
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_LOWER_BOUND_EPOCH_INCLUSIVE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getLowerBoundEpochInclusive() {
    return lowerBoundEpochInclusive;
  }


  @JsonProperty(JSON_PROPERTY_LOWER_BOUND_EPOCH_INCLUSIVE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLowerBoundEpochInclusive(Long lowerBoundEpochInclusive) {
    this.lowerBoundEpochInclusive = lowerBoundEpochInclusive;
  }


  public EnactAtStartOfEpochIfValidatorsReadyCondition upperBoundEpochExclusive(Long upperBoundEpochExclusive) {
    this.upperBoundEpochExclusive = upperBoundEpochExclusive;
    return this;
  }

   /**
   * Get upperBoundEpochExclusive
   * @return upperBoundEpochExclusive
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_UPPER_BOUND_EPOCH_EXCLUSIVE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getUpperBoundEpochExclusive() {
    return upperBoundEpochExclusive;
  }


  @JsonProperty(JSON_PROPERTY_UPPER_BOUND_EPOCH_EXCLUSIVE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUpperBoundEpochExclusive(Long upperBoundEpochExclusive) {
    this.upperBoundEpochExclusive = upperBoundEpochExclusive;
  }


  public EnactAtStartOfEpochIfValidatorsReadyCondition readinessThresholds(List<SignalledReadinessThreshold> readinessThresholds) {
    this.readinessThresholds = readinessThresholds;
    return this;
  }

  public EnactAtStartOfEpochIfValidatorsReadyCondition addReadinessThresholdsItem(SignalledReadinessThreshold readinessThresholdsItem) {
    this.readinessThresholds.add(readinessThresholdsItem);
    return this;
  }

   /**
   * Get readinessThresholds
   * @return readinessThresholds
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_READINESS_THRESHOLDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<SignalledReadinessThreshold> getReadinessThresholds() {
    return readinessThresholds;
  }


  @JsonProperty(JSON_PROPERTY_READINESS_THRESHOLDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setReadinessThresholds(List<SignalledReadinessThreshold> readinessThresholds) {
    this.readinessThresholds = readinessThresholds;
  }


  /**
   * Return true if this EnactAtStartOfEpochIfValidatorsReadyCondition object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnactAtStartOfEpochIfValidatorsReadyCondition enactAtStartOfEpochIfValidatorsReadyCondition = (EnactAtStartOfEpochIfValidatorsReadyCondition) o;
    return Objects.equals(this.readinessSignal, enactAtStartOfEpochIfValidatorsReadyCondition.readinessSignal) &&
        Objects.equals(this.lowerBoundEpochInclusive, enactAtStartOfEpochIfValidatorsReadyCondition.lowerBoundEpochInclusive) &&
        Objects.equals(this.upperBoundEpochExclusive, enactAtStartOfEpochIfValidatorsReadyCondition.upperBoundEpochExclusive) &&
        Objects.equals(this.readinessThresholds, enactAtStartOfEpochIfValidatorsReadyCondition.readinessThresholds) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(readinessSignal, lowerBoundEpochInclusive, upperBoundEpochExclusive, readinessThresholds, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnactAtStartOfEpochIfValidatorsReadyCondition {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    readinessSignal: ").append(toIndentedString(readinessSignal)).append("\n");
    sb.append("    lowerBoundEpochInclusive: ").append(toIndentedString(lowerBoundEpochInclusive)).append("\n");
    sb.append("    upperBoundEpochExclusive: ").append(toIndentedString(upperBoundEpochExclusive)).append("\n");
    sb.append("    readinessThresholds: ").append(toIndentedString(readinessThresholds)).append("\n");
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

static {
  // Initialize and register the discriminator mappings.
  Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
  mappings.put("EnactAtStartOfEpochIfValidatorsReady", EnactAtStartOfEpochIfValidatorsReadyCondition.class);
  mappings.put("EnactAtStartOfEpochUnconditionally", EnactAtStartOfEpochUnconditionallyCondition.class);
  mappings.put("EnactAtStartOfEpochIfValidatorsReadyCondition", EnactAtStartOfEpochIfValidatorsReadyCondition.class);
  JSON.registerDiscriminator(EnactAtStartOfEpochIfValidatorsReadyCondition.class, "type", mappings);
}
}


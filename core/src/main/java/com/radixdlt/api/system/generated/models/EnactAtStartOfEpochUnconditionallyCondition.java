/*
 * Radix System API - Babylon (Anemone)
 * This API is exposed by the Babylon Radix node to give clients access to information about the node itself, its configuration, status and subsystems.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against ledger state, you may also wish to consider using the [Core API or Gateway API instead](https://docs-babylon.radixdlt.com/main/apis/api-specification.html). 
 *
 * The version of the OpenAPI document: v1.1.3
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
import com.radixdlt.api.system.generated.models.EnactAtStartOfEpochUnconditionallyCondition;
import com.radixdlt.api.system.generated.models.EnactAtStartOfEpochUnconditionallyConditionAllOf;
import com.radixdlt.api.system.generated.models.ProtocolUpdateEnactmentCondition;
import com.radixdlt.api.system.generated.models.ProtocolUpdateEnactmentConditionType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.common.JSON;
/**
 * EnactAtStartOfEpochUnconditionallyCondition
 */
@JsonPropertyOrder({
  EnactAtStartOfEpochUnconditionallyCondition.JSON_PROPERTY_EPOCH
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = EnactAtStartOfEpochIfValidatorsReadyCondition.class, name = "EnactAtStartOfEpochIfValidatorsReady"),
  @JsonSubTypes.Type(value = EnactAtStartOfEpochUnconditionallyCondition.class, name = "EnactAtStartOfEpochUnconditionally"),
})

public class EnactAtStartOfEpochUnconditionallyCondition extends ProtocolUpdateEnactmentCondition {
  public static final String JSON_PROPERTY_EPOCH = "epoch";
  private Long epoch;


  public EnactAtStartOfEpochUnconditionallyCondition epoch(Long epoch) {
    this.epoch = epoch;
    return this;
  }

   /**
   * Get epoch
   * @return epoch
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_EPOCH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getEpoch() {
    return epoch;
  }


  @JsonProperty(JSON_PROPERTY_EPOCH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEpoch(Long epoch) {
    this.epoch = epoch;
  }


  /**
   * Return true if this EnactAtStartOfEpochUnconditionallyCondition object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnactAtStartOfEpochUnconditionallyCondition enactAtStartOfEpochUnconditionallyCondition = (EnactAtStartOfEpochUnconditionallyCondition) o;
    return Objects.equals(this.epoch, enactAtStartOfEpochUnconditionallyCondition.epoch) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(epoch, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnactAtStartOfEpochUnconditionallyCondition {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    epoch: ").append(toIndentedString(epoch)).append("\n");
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
  mappings.put("EnactAtStartOfEpochUnconditionallyCondition", EnactAtStartOfEpochUnconditionallyCondition.class);
  JSON.registerDiscriminator(EnactAtStartOfEpochUnconditionallyCondition.class, "type", mappings);
}
}


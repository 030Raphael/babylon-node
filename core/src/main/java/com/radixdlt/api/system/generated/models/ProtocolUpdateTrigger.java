/*
 * Radix System API - Babylon (Anemone)
 * This API is exposed by the Babylon Radix node to give clients access to information about the node itself, its configuration, status and subsystems.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against ledger state, you may also wish to consider using the [Core API or Gateway API instead](https://docs-babylon.radixdlt.com/main/apis/api-specification.html). 
 *
 * The version of the OpenAPI document: v1.1.0
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
import com.radixdlt.api.system.generated.models.ProtocolUpdateEnactmentCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ProtocolUpdateTrigger
 */
@JsonPropertyOrder({
  ProtocolUpdateTrigger.JSON_PROPERTY_NEXT_PROTOCOL_VERSION,
  ProtocolUpdateTrigger.JSON_PROPERTY_ENACTMENT_CONDITION
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ProtocolUpdateTrigger {
  public static final String JSON_PROPERTY_NEXT_PROTOCOL_VERSION = "next_protocol_version";
  private String nextProtocolVersion;

  public static final String JSON_PROPERTY_ENACTMENT_CONDITION = "enactment_condition";
  private ProtocolUpdateEnactmentCondition enactmentCondition;


  public ProtocolUpdateTrigger nextProtocolVersion(String nextProtocolVersion) {
    this.nextProtocolVersion = nextProtocolVersion;
    return this;
  }

   /**
   * Get nextProtocolVersion
   * @return nextProtocolVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_NEXT_PROTOCOL_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNextProtocolVersion() {
    return nextProtocolVersion;
  }


  @JsonProperty(JSON_PROPERTY_NEXT_PROTOCOL_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNextProtocolVersion(String nextProtocolVersion) {
    this.nextProtocolVersion = nextProtocolVersion;
  }


  public ProtocolUpdateTrigger enactmentCondition(ProtocolUpdateEnactmentCondition enactmentCondition) {
    this.enactmentCondition = enactmentCondition;
    return this;
  }

   /**
   * Get enactmentCondition
   * @return enactmentCondition
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ENACTMENT_CONDITION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ProtocolUpdateEnactmentCondition getEnactmentCondition() {
    return enactmentCondition;
  }


  @JsonProperty(JSON_PROPERTY_ENACTMENT_CONDITION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEnactmentCondition(ProtocolUpdateEnactmentCondition enactmentCondition) {
    this.enactmentCondition = enactmentCondition;
  }


  /**
   * Return true if this ProtocolUpdateTrigger object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProtocolUpdateTrigger protocolUpdateTrigger = (ProtocolUpdateTrigger) o;
    return Objects.equals(this.nextProtocolVersion, protocolUpdateTrigger.nextProtocolVersion) &&
        Objects.equals(this.enactmentCondition, protocolUpdateTrigger.enactmentCondition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nextProtocolVersion, enactmentCondition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProtocolUpdateTrigger {\n");
    sb.append("    nextProtocolVersion: ").append(toIndentedString(nextProtocolVersion)).append("\n");
    sb.append("    enactmentCondition: ").append(toIndentedString(enactmentCondition)).append("\n");
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


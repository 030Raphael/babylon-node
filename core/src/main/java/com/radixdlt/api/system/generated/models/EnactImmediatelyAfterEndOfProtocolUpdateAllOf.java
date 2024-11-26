/*
 * Radix System API
 * This API is exposed by the Babylon Radix node to give clients access to information about the node itself, its configuration, status and subsystems.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against ledger state, you may also wish to consider using the [Core API or Gateway API instead](https://docs-babylon.radixdlt.com/main/apis/api-specification.html). 
 *
 * The version of the OpenAPI document: v1.3.0
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
 * EnactImmediatelyAfterEndOfProtocolUpdateAllOf
 */
@JsonPropertyOrder({
  EnactImmediatelyAfterEndOfProtocolUpdateAllOf.JSON_PROPERTY_TRIGGER_AFTER
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class EnactImmediatelyAfterEndOfProtocolUpdateAllOf {
  public static final String JSON_PROPERTY_TRIGGER_AFTER = "trigger_after";
  private String triggerAfter;


  public EnactImmediatelyAfterEndOfProtocolUpdateAllOf triggerAfter(String triggerAfter) {
    this.triggerAfter = triggerAfter;
    return this;
  }

   /**
   * Get triggerAfter
   * @return triggerAfter
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TRIGGER_AFTER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTriggerAfter() {
    return triggerAfter;
  }


  @JsonProperty(JSON_PROPERTY_TRIGGER_AFTER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTriggerAfter(String triggerAfter) {
    this.triggerAfter = triggerAfter;
  }


  /**
   * Return true if this EnactImmediatelyAfterEndOfProtocolUpdate_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnactImmediatelyAfterEndOfProtocolUpdateAllOf enactImmediatelyAfterEndOfProtocolUpdateAllOf = (EnactImmediatelyAfterEndOfProtocolUpdateAllOf) o;
    return Objects.equals(this.triggerAfter, enactImmediatelyAfterEndOfProtocolUpdateAllOf.triggerAfter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(triggerAfter);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnactImmediatelyAfterEndOfProtocolUpdateAllOf {\n");
    sb.append("    triggerAfter: ").append(toIndentedString(triggerAfter)).append("\n");
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


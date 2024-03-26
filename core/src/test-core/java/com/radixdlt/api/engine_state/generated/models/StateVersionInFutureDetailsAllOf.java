/*
 * Engine State API
 * This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v0.0.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.engine_state.generated.models;

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
 * StateVersionInFutureDetailsAllOf
 */
@JsonPropertyOrder({
  StateVersionInFutureDetailsAllOf.JSON_PROPERTY_CURRENT_STATE_VERSION
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class StateVersionInFutureDetailsAllOf {
  public static final String JSON_PROPERTY_CURRENT_STATE_VERSION = "current_state_version";
  private Long currentStateVersion;

  public StateVersionInFutureDetailsAllOf() { 
  }

  public StateVersionInFutureDetailsAllOf currentStateVersion(Long currentStateVersion) {
    this.currentStateVersion = currentStateVersion;
    return this;
  }

   /**
   * Get currentStateVersion
   * minimum: 1
   * maximum: 100000000000000
   * @return currentStateVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CURRENT_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getCurrentStateVersion() {
    return currentStateVersion;
  }


  @JsonProperty(JSON_PROPERTY_CURRENT_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCurrentStateVersion(Long currentStateVersion) {
    this.currentStateVersion = currentStateVersion;
  }


  /**
   * Return true if this StateVersionInFutureDetails_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StateVersionInFutureDetailsAllOf stateVersionInFutureDetailsAllOf = (StateVersionInFutureDetailsAllOf) o;
    return Objects.equals(this.currentStateVersion, stateVersionInFutureDetailsAllOf.currentStateVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentStateVersion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StateVersionInFutureDetailsAllOf {\n");
    sb.append("    currentStateVersion: ").append(toIndentedString(currentStateVersion)).append("\n");
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


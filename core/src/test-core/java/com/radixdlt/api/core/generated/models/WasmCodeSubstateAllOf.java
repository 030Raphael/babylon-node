/*
 * Babylon Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.3.0
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * WasmCodeSubstateAllOf
 */
@JsonPropertyOrder({
  WasmCodeSubstateAllOf.JSON_PROPERTY_CODE_HEX
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class WasmCodeSubstateAllOf {
  public static final String JSON_PROPERTY_CODE_HEX = "code_hex";
  private String codeHex;

  public WasmCodeSubstateAllOf() { 
  }

  public WasmCodeSubstateAllOf codeHex(String codeHex) {
    this.codeHex = codeHex;
    return this;
  }

   /**
   * The hex-encoded package code
   * @return codeHex
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded package code")
  @JsonProperty(JSON_PROPERTY_CODE_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCodeHex() {
    return codeHex;
  }


  @JsonProperty(JSON_PROPERTY_CODE_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCodeHex(String codeHex) {
    this.codeHex = codeHex;
  }


  /**
   * Return true if this WasmCodeSubstate_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WasmCodeSubstateAllOf wasmCodeSubstateAllOf = (WasmCodeSubstateAllOf) o;
    return Objects.equals(this.codeHex, wasmCodeSubstateAllOf.codeHex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeHex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WasmCodeSubstateAllOf {\n");
    sb.append("    codeHex: ").append(toIndentedString(codeHex)).append("\n");
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


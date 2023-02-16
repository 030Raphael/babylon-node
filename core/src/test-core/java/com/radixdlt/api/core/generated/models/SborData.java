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
 * SborData
 */
@JsonPropertyOrder({
  SborData.JSON_PROPERTY_DATA_HEX,
  SborData.JSON_PROPERTY_DATA_JSON
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SborData {
  public static final String JSON_PROPERTY_DATA_HEX = "data_hex";
  private String dataHex;

  public static final String JSON_PROPERTY_DATA_JSON = "data_json";
  private Object dataJson = null;

  public SborData() { 
  }

  public SborData dataHex(String dataHex) {
    this.dataHex = dataHex;
    return this;
  }

   /**
   * The hex-encoded, raw SBOR-encoded data
   * @return dataHex
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded, raw SBOR-encoded data")
  @JsonProperty(JSON_PROPERTY_DATA_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDataHex() {
    return dataHex;
  }


  @JsonProperty(JSON_PROPERTY_DATA_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDataHex(String dataHex) {
    this.dataHex = dataHex;
  }


  public SborData dataJson(Object dataJson) {
    this.dataJson = dataJson;
    return this;
  }

   /**
   * An untyped JSON body representing the content of the SBOR data
   * @return dataJson
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(required = true, value = "An untyped JSON body representing the content of the SBOR data")
  @JsonProperty(JSON_PROPERTY_DATA_JSON)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Object getDataJson() {
    return dataJson;
  }


  @JsonProperty(JSON_PROPERTY_DATA_JSON)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDataJson(Object dataJson) {
    this.dataJson = dataJson;
  }


  /**
   * Return true if this SborData object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SborData sborData = (SborData) o;
    return Objects.equals(this.dataHex, sborData.dataHex) &&
        Objects.equals(this.dataJson, sborData.dataJson);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataHex, dataJson);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SborData {\n");
    sb.append("    dataHex: ").append(toIndentedString(dataHex)).append("\n");
    sb.append("    dataJson: ").append(toIndentedString(dataJson)).append("\n");
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


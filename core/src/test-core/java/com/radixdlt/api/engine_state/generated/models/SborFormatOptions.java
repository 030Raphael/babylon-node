/*
 * Engine State API - Babylon (Anemone)
 * **This API is currently in Beta**  This specification may experience breaking changes as part of Babylon Node releases. Such changes will be clearly mentioned in the [babylon-node release notes](https://github.com/radixdlt/babylon-node/releases). We advise against using this API for business-critical integrations before the `version` indicated above becomes stable, which is expected in Q4 of 2024.  This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v1.2.1-beta
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
 * Requested SBOR representation to use for every &#x60;SborData&#x60; within the response.
 */
@ApiModel(description = "Requested SBOR representation to use for every `SborData` within the response.")
@JsonPropertyOrder({
  SborFormatOptions.JSON_PROPERTY_RAW_HEX,
  SborFormatOptions.JSON_PROPERTY_PROGRAMMATIC_JSON
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SborFormatOptions {
  public static final String JSON_PROPERTY_RAW_HEX = "raw_hex";
  private Boolean rawHex;

  public static final String JSON_PROPERTY_PROGRAMMATIC_JSON = "programmatic_json";
  private Boolean programmaticJson;

  public SborFormatOptions() { 
  }

  public SborFormatOptions rawHex(Boolean rawHex) {
    this.rawHex = rawHex;
    return this;
  }

   /**
   * Whether to return the raw hex-encoded bytes (default false).
   * @return rawHex
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether to return the raw hex-encoded bytes (default false).")
  @JsonProperty(JSON_PROPERTY_RAW_HEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getRawHex() {
    return rawHex;
  }


  @JsonProperty(JSON_PROPERTY_RAW_HEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRawHex(Boolean rawHex) {
    this.rawHex = rawHex;
  }


  public SborFormatOptions programmaticJson(Boolean programmaticJson) {
    this.programmaticJson = programmaticJson;
    return this;
  }

   /**
   * Whether to return the Programmatic JSON (default true).
   * @return programmaticJson
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether to return the Programmatic JSON (default true).")
  @JsonProperty(JSON_PROPERTY_PROGRAMMATIC_JSON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getProgrammaticJson() {
    return programmaticJson;
  }


  @JsonProperty(JSON_PROPERTY_PROGRAMMATIC_JSON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProgrammaticJson(Boolean programmaticJson) {
    this.programmaticJson = programmaticJson;
  }


  /**
   * Return true if this SborFormatOptions object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SborFormatOptions sborFormatOptions = (SborFormatOptions) o;
    return Objects.equals(this.rawHex, sborFormatOptions.rawHex) &&
        Objects.equals(this.programmaticJson, sborFormatOptions.programmaticJson);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rawHex, programmaticJson);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SborFormatOptions {\n");
    sb.append("    rawHex: ").append(toIndentedString(rawHex)).append("\n");
    sb.append("    programmaticJson: ").append(toIndentedString(programmaticJson)).append("\n");
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


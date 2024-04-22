/*
 * Radix Core API - Babylon (Anemone)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.1.3
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
 * InstantMs
 */
@JsonPropertyOrder({
  InstantMs.JSON_PROPERTY_UNIX_TIMESTAMP_MS,
  InstantMs.JSON_PROPERTY_DATE_TIME
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class InstantMs {
  public static final String JSON_PROPERTY_UNIX_TIMESTAMP_MS = "unix_timestamp_ms";
  private Long unixTimestampMs;

  public static final String JSON_PROPERTY_DATE_TIME = "date_time";
  private String dateTime;

  public InstantMs() { 
  }

  public InstantMs unixTimestampMs(Long unixTimestampMs) {
    this.unixTimestampMs = unixTimestampMs;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^14&#x60;, marking the unix timestamp in ms.
   * minimum: 0
   * maximum: 100000000000000
   * @return unixTimestampMs
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^14`, marking the unix timestamp in ms.")
  @JsonProperty(JSON_PROPERTY_UNIX_TIMESTAMP_MS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getUnixTimestampMs() {
    return unixTimestampMs;
  }


  @JsonProperty(JSON_PROPERTY_UNIX_TIMESTAMP_MS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUnixTimestampMs(Long unixTimestampMs) {
    this.unixTimestampMs = unixTimestampMs;
  }


  public InstantMs dateTime(String dateTime) {
    this.dateTime = dateTime;
    return this;
  }

   /**
   * The RFC 3339 / ISO 8601 string representation of the timestamp. Will always use \&quot;Z\&quot; (denoting UTC) and include milliseconds (even if &#x60;000&#x60;). E.g.: &#x60;2023-01-26T18:30:09.453Z&#x60;. 
   * @return dateTime
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The RFC 3339 / ISO 8601 string representation of the timestamp. Will always use \"Z\" (denoting UTC) and include milliseconds (even if `000`). E.g.: `2023-01-26T18:30:09.453Z`. ")
  @JsonProperty(JSON_PROPERTY_DATE_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDateTime() {
    return dateTime;
  }


  @JsonProperty(JSON_PROPERTY_DATE_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
  }


  /**
   * Return true if this InstantMs object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstantMs instantMs = (InstantMs) o;
    return Objects.equals(this.unixTimestampMs, instantMs.unixTimestampMs) &&
        Objects.equals(this.dateTime, instantMs.dateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unixTimestampMs, dateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstantMs {\n");
    sb.append("    unixTimestampMs: ").append(toIndentedString(unixTimestampMs)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
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


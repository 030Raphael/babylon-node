/*
 * Radix Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.4
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
 * EpochRound
 */
@JsonPropertyOrder({
  EpochRound.JSON_PROPERTY_EPOCH,
  EpochRound.JSON_PROPERTY_ROUND
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class EpochRound {
  public static final String JSON_PROPERTY_EPOCH = "epoch";
  private Long epoch;

  public static final String JSON_PROPERTY_ROUND = "round";
  private Long round;

  public EpochRound() { 
  }

  public EpochRound epoch(Long epoch) {
    this.epoch = epoch;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, marking the epoch. Only present if the rejection is temporary due to a header specifying a \&quot;from epoch\&quot; in the future. 
   * minimum: 0
   * maximum: 10000000000
   * @return epoch
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^10`, marking the epoch. Only present if the rejection is temporary due to a header specifying a \"from epoch\" in the future. ")
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


  public EpochRound round(Long round) {
    this.round = round;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, marking the current round in an epoch
   * minimum: 0
   * maximum: 10000000000
   * @return round
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^10`, marking the current round in an epoch")
  @JsonProperty(JSON_PROPERTY_ROUND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getRound() {
    return round;
  }


  @JsonProperty(JSON_PROPERTY_ROUND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRound(Long round) {
    this.round = round;
  }


  /**
   * Return true if this EpochRound object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EpochRound epochRound = (EpochRound) o;
    return Objects.equals(this.epoch, epochRound.epoch) &&
        Objects.equals(this.round, epochRound.round);
  }

  @Override
  public int hashCode() {
    return Objects.hash(epoch, round);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EpochRound {\n");
    sb.append("    epoch: ").append(toIndentedString(epoch)).append("\n");
    sb.append("    round: ").append(toIndentedString(round)).append("\n");
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


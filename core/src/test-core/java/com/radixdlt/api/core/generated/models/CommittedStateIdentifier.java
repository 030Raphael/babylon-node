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
 * CommittedStateIdentifier
 */
@JsonPropertyOrder({
  CommittedStateIdentifier.JSON_PROPERTY_STATE_VERSION,
  CommittedStateIdentifier.JSON_PROPERTY_ACCUMULATOR_HASH
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CommittedStateIdentifier {
  public static final String JSON_PROPERTY_STATE_VERSION = "state_version";
  private Long stateVersion;

  public static final String JSON_PROPERTY_ACCUMULATOR_HASH = "accumulator_hash";
  private String accumulatorHash;

  public CommittedStateIdentifier() { 
  }

  public CommittedStateIdentifier stateVersion(Long stateVersion) {
    this.stateVersion = stateVersion;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^13&#x60;, representing the state version. The state version increments with each transaction, starting at &#x60;0&#x60; pre-genesis.
   * minimum: 0
   * maximum: 100000000000000
   * @return stateVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^13`, representing the state version. The state version increments with each transaction, starting at `0` pre-genesis.")
  @JsonProperty(JSON_PROPERTY_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getStateVersion() {
    return stateVersion;
  }


  @JsonProperty(JSON_PROPERTY_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStateVersion(Long stateVersion) {
    this.stateVersion = stateVersion;
  }


  public CommittedStateIdentifier accumulatorHash(String accumulatorHash) {
    this.accumulatorHash = accumulatorHash;
    return this;
  }

   /**
   * The hex-encoded transaction accumulator hash. This hash captures the order of all transactions on ledger. This hash is &#x60;ACC_{N+1} &#x3D; SHA256(SHA256(CONCAT(ACC_N, LEDGER_HASH_{N})))&#x60;, starting with &#x60;ACC_0 &#x3D; 000..000&#x60; the pre-genesis accumulator. 
   * @return accumulatorHash
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded transaction accumulator hash. This hash captures the order of all transactions on ledger. This hash is `ACC_{N+1} = SHA256(SHA256(CONCAT(ACC_N, LEDGER_HASH_{N})))`, starting with `ACC_0 = 000..000` the pre-genesis accumulator. ")
  @JsonProperty(JSON_PROPERTY_ACCUMULATOR_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAccumulatorHash() {
    return accumulatorHash;
  }


  @JsonProperty(JSON_PROPERTY_ACCUMULATOR_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAccumulatorHash(String accumulatorHash) {
    this.accumulatorHash = accumulatorHash;
  }


  /**
   * Return true if this CommittedStateIdentifier object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommittedStateIdentifier committedStateIdentifier = (CommittedStateIdentifier) o;
    return Objects.equals(this.stateVersion, committedStateIdentifier.stateVersion) &&
        Objects.equals(this.accumulatorHash, committedStateIdentifier.accumulatorHash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stateVersion, accumulatorHash);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommittedStateIdentifier {\n");
    sb.append("    stateVersion: ").append(toIndentedString(stateVersion)).append("\n");
    sb.append("    accumulatorHash: ").append(toIndentedString(accumulatorHash)).append("\n");
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


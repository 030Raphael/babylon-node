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
import com.radixdlt.api.core.generated.models.CommittedStateIdentifier;
import com.radixdlt.api.core.generated.models.EpochRound;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * NetworkStatusResponse
 */
@JsonPropertyOrder({
  NetworkStatusResponse.JSON_PROPERTY_PRE_GENESIS_STATE_IDENTIFIER,
  NetworkStatusResponse.JSON_PROPERTY_GENESIS_EPOCH_ROUND,
  NetworkStatusResponse.JSON_PROPERTY_POST_GENESIS_STATE_IDENTIFIER,
  NetworkStatusResponse.JSON_PROPERTY_POST_GENESIS_EPOCH_ROUND,
  NetworkStatusResponse.JSON_PROPERTY_CURRENT_STATE_IDENTIFIER,
  NetworkStatusResponse.JSON_PROPERTY_CURRENT_EPOCH_ROUND,
  NetworkStatusResponse.JSON_PROPERTY_CURRENT_PROTOCOL_VERSION
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class NetworkStatusResponse {
  public static final String JSON_PROPERTY_PRE_GENESIS_STATE_IDENTIFIER = "pre_genesis_state_identifier";
  private CommittedStateIdentifier preGenesisStateIdentifier;

  public static final String JSON_PROPERTY_GENESIS_EPOCH_ROUND = "genesis_epoch_round";
  private EpochRound genesisEpochRound;

  public static final String JSON_PROPERTY_POST_GENESIS_STATE_IDENTIFIER = "post_genesis_state_identifier";
  private CommittedStateIdentifier postGenesisStateIdentifier;

  public static final String JSON_PROPERTY_POST_GENESIS_EPOCH_ROUND = "post_genesis_epoch_round";
  private EpochRound postGenesisEpochRound;

  public static final String JSON_PROPERTY_CURRENT_STATE_IDENTIFIER = "current_state_identifier";
  private CommittedStateIdentifier currentStateIdentifier;

  public static final String JSON_PROPERTY_CURRENT_EPOCH_ROUND = "current_epoch_round";
  private EpochRound currentEpochRound;

  public static final String JSON_PROPERTY_CURRENT_PROTOCOL_VERSION = "current_protocol_version";
  private String currentProtocolVersion;

  public NetworkStatusResponse() { 
  }

  public NetworkStatusResponse preGenesisStateIdentifier(CommittedStateIdentifier preGenesisStateIdentifier) {
    this.preGenesisStateIdentifier = preGenesisStateIdentifier;
    return this;
  }

   /**
   * Get preGenesisStateIdentifier
   * @return preGenesisStateIdentifier
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PRE_GENESIS_STATE_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public CommittedStateIdentifier getPreGenesisStateIdentifier() {
    return preGenesisStateIdentifier;
  }


  @JsonProperty(JSON_PROPERTY_PRE_GENESIS_STATE_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPreGenesisStateIdentifier(CommittedStateIdentifier preGenesisStateIdentifier) {
    this.preGenesisStateIdentifier = preGenesisStateIdentifier;
  }


  public NetworkStatusResponse genesisEpochRound(EpochRound genesisEpochRound) {
    this.genesisEpochRound = genesisEpochRound;
    return this;
  }

   /**
   * Get genesisEpochRound
   * @return genesisEpochRound
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_GENESIS_EPOCH_ROUND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public EpochRound getGenesisEpochRound() {
    return genesisEpochRound;
  }


  @JsonProperty(JSON_PROPERTY_GENESIS_EPOCH_ROUND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGenesisEpochRound(EpochRound genesisEpochRound) {
    this.genesisEpochRound = genesisEpochRound;
  }


  public NetworkStatusResponse postGenesisStateIdentifier(CommittedStateIdentifier postGenesisStateIdentifier) {
    this.postGenesisStateIdentifier = postGenesisStateIdentifier;
    return this;
  }

   /**
   * Get postGenesisStateIdentifier
   * @return postGenesisStateIdentifier
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_POST_GENESIS_STATE_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CommittedStateIdentifier getPostGenesisStateIdentifier() {
    return postGenesisStateIdentifier;
  }


  @JsonProperty(JSON_PROPERTY_POST_GENESIS_STATE_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPostGenesisStateIdentifier(CommittedStateIdentifier postGenesisStateIdentifier) {
    this.postGenesisStateIdentifier = postGenesisStateIdentifier;
  }


  public NetworkStatusResponse postGenesisEpochRound(EpochRound postGenesisEpochRound) {
    this.postGenesisEpochRound = postGenesisEpochRound;
    return this;
  }

   /**
   * Get postGenesisEpochRound
   * @return postGenesisEpochRound
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_POST_GENESIS_EPOCH_ROUND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public EpochRound getPostGenesisEpochRound() {
    return postGenesisEpochRound;
  }


  @JsonProperty(JSON_PROPERTY_POST_GENESIS_EPOCH_ROUND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPostGenesisEpochRound(EpochRound postGenesisEpochRound) {
    this.postGenesisEpochRound = postGenesisEpochRound;
  }


  public NetworkStatusResponse currentStateIdentifier(CommittedStateIdentifier currentStateIdentifier) {
    this.currentStateIdentifier = currentStateIdentifier;
    return this;
  }

   /**
   * Get currentStateIdentifier
   * @return currentStateIdentifier
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CURRENT_STATE_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CommittedStateIdentifier getCurrentStateIdentifier() {
    return currentStateIdentifier;
  }


  @JsonProperty(JSON_PROPERTY_CURRENT_STATE_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCurrentStateIdentifier(CommittedStateIdentifier currentStateIdentifier) {
    this.currentStateIdentifier = currentStateIdentifier;
  }


  public NetworkStatusResponse currentEpochRound(EpochRound currentEpochRound) {
    this.currentEpochRound = currentEpochRound;
    return this;
  }

   /**
   * Get currentEpochRound
   * @return currentEpochRound
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CURRENT_EPOCH_ROUND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public EpochRound getCurrentEpochRound() {
    return currentEpochRound;
  }


  @JsonProperty(JSON_PROPERTY_CURRENT_EPOCH_ROUND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCurrentEpochRound(EpochRound currentEpochRound) {
    this.currentEpochRound = currentEpochRound;
  }


  public NetworkStatusResponse currentProtocolVersion(String currentProtocolVersion) {
    this.currentProtocolVersion = currentProtocolVersion;
    return this;
  }

   /**
   * A descriptor for the current protocol version that the node is running. 
   * @return currentProtocolVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A descriptor for the current protocol version that the node is running. ")
  @JsonProperty(JSON_PROPERTY_CURRENT_PROTOCOL_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCurrentProtocolVersion() {
    return currentProtocolVersion;
  }


  @JsonProperty(JSON_PROPERTY_CURRENT_PROTOCOL_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCurrentProtocolVersion(String currentProtocolVersion) {
    this.currentProtocolVersion = currentProtocolVersion;
  }


  /**
   * Return true if this NetworkStatusResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkStatusResponse networkStatusResponse = (NetworkStatusResponse) o;
    return Objects.equals(this.preGenesisStateIdentifier, networkStatusResponse.preGenesisStateIdentifier) &&
        Objects.equals(this.genesisEpochRound, networkStatusResponse.genesisEpochRound) &&
        Objects.equals(this.postGenesisStateIdentifier, networkStatusResponse.postGenesisStateIdentifier) &&
        Objects.equals(this.postGenesisEpochRound, networkStatusResponse.postGenesisEpochRound) &&
        Objects.equals(this.currentStateIdentifier, networkStatusResponse.currentStateIdentifier) &&
        Objects.equals(this.currentEpochRound, networkStatusResponse.currentEpochRound) &&
        Objects.equals(this.currentProtocolVersion, networkStatusResponse.currentProtocolVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(preGenesisStateIdentifier, genesisEpochRound, postGenesisStateIdentifier, postGenesisEpochRound, currentStateIdentifier, currentEpochRound, currentProtocolVersion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkStatusResponse {\n");
    sb.append("    preGenesisStateIdentifier: ").append(toIndentedString(preGenesisStateIdentifier)).append("\n");
    sb.append("    genesisEpochRound: ").append(toIndentedString(genesisEpochRound)).append("\n");
    sb.append("    postGenesisStateIdentifier: ").append(toIndentedString(postGenesisStateIdentifier)).append("\n");
    sb.append("    postGenesisEpochRound: ").append(toIndentedString(postGenesisEpochRound)).append("\n");
    sb.append("    currentStateIdentifier: ").append(toIndentedString(currentStateIdentifier)).append("\n");
    sb.append("    currentEpochRound: ").append(toIndentedString(currentEpochRound)).append("\n");
    sb.append("    currentProtocolVersion: ").append(toIndentedString(currentProtocolVersion)).append("\n");
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


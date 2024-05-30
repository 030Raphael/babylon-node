/*
 * Radix Core API - Babylon (Bottlenose)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.1
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
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * MempoolTransactionRequest
 */
@JsonPropertyOrder({
  MempoolTransactionRequest.JSON_PROPERTY_NETWORK,
  MempoolTransactionRequest.JSON_PROPERTY_PAYLOAD_HASHES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MempoolTransactionRequest {
  public static final String JSON_PROPERTY_NETWORK = "network";
  private String network;

  public static final String JSON_PROPERTY_PAYLOAD_HASHES = "payload_hashes";
  private List<String> payloadHashes = new ArrayList<>();

  public MempoolTransactionRequest() { 
  }

  public MempoolTransactionRequest network(String network) {
    this.network = network;
    return this;
  }

   /**
   * The logical name of the network
   * @return network
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "{{network}}", required = true, value = "The logical name of the network")
  @JsonProperty(JSON_PROPERTY_NETWORK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNetwork() {
    return network;
  }


  @JsonProperty(JSON_PROPERTY_NETWORK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNetwork(String network) {
    this.network = network;
  }


  public MempoolTransactionRequest payloadHashes(List<String> payloadHashes) {
    this.payloadHashes = payloadHashes;
    return this;
  }

  public MempoolTransactionRequest addPayloadHashesItem(String payloadHashesItem) {
    this.payloadHashes.add(payloadHashesItem);
    return this;
  }

   /**
   * A list of payload hashes to attempt to read. Each hash must be either hex, or in Bech32m format.
   * @return payloadHashes
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A list of payload hashes to attempt to read. Each hash must be either hex, or in Bech32m format.")
  @JsonProperty(JSON_PROPERTY_PAYLOAD_HASHES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getPayloadHashes() {
    return payloadHashes;
  }


  @JsonProperty(JSON_PROPERTY_PAYLOAD_HASHES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPayloadHashes(List<String> payloadHashes) {
    this.payloadHashes = payloadHashes;
  }


  /**
   * Return true if this MempoolTransactionRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MempoolTransactionRequest mempoolTransactionRequest = (MempoolTransactionRequest) o;
    return Objects.equals(this.network, mempoolTransactionRequest.network) &&
        Objects.equals(this.payloadHashes, mempoolTransactionRequest.payloadHashes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(network, payloadHashes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MempoolTransactionRequest {\n");
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
    sb.append("    payloadHashes: ").append(toIndentedString(payloadHashes)).append("\n");
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


/*
 * Babylon Core API - RCnet V2
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
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
 * Different versions regarding the node, network and api.
 */
@ApiModel(description = "Different versions regarding the node, network and api.")
@JsonPropertyOrder({
  NetworkConfigurationResponseVersion.JSON_PROPERTY_CORE_VERSION,
  NetworkConfigurationResponseVersion.JSON_PROPERTY_API_VERSION
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class NetworkConfigurationResponseVersion {
  public static final String JSON_PROPERTY_CORE_VERSION = "core_version";
  private String coreVersion;

  public static final String JSON_PROPERTY_API_VERSION = "api_version";
  private String apiVersion;

  public NetworkConfigurationResponseVersion() { 
  }

  public NetworkConfigurationResponseVersion coreVersion(String coreVersion) {
    this.coreVersion = coreVersion;
    return this;
  }

   /**
   * Get coreVersion
   * @return coreVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CORE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCoreVersion() {
    return coreVersion;
  }


  @JsonProperty(JSON_PROPERTY_CORE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCoreVersion(String coreVersion) {
    this.coreVersion = coreVersion;
  }


  public NetworkConfigurationResponseVersion apiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return this;
  }

   /**
   * Get apiVersion
   * @return apiVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_API_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getApiVersion() {
    return apiVersion;
  }


  @JsonProperty(JSON_PROPERTY_API_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }


  /**
   * Return true if this NetworkConfigurationResponse_version object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkConfigurationResponseVersion networkConfigurationResponseVersion = (NetworkConfigurationResponseVersion) o;
    return Objects.equals(this.coreVersion, networkConfigurationResponseVersion.coreVersion) &&
        Objects.equals(this.apiVersion, networkConfigurationResponseVersion.apiVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coreVersion, apiVersion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkConfigurationResponseVersion {\n");
    sb.append("    coreVersion: ").append(toIndentedString(coreVersion)).append("\n");
    sb.append("    apiVersion: ").append(toIndentedString(apiVersion)).append("\n");
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


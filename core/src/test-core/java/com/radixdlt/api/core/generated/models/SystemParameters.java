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
import com.radixdlt.api.core.generated.models.CostingModuleConfig;
import com.radixdlt.api.core.generated.models.LimitParameters;
import com.radixdlt.api.core.generated.models.NetworkDefinition;
import com.radixdlt.api.core.generated.models.SystemCostingParameters;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * SystemParameters
 */
@JsonPropertyOrder({
  SystemParameters.JSON_PROPERTY_NETWORK_DEFINITION,
  SystemParameters.JSON_PROPERTY_COSTING_MODULE_CONFIG,
  SystemParameters.JSON_PROPERTY_COSTING_PARAMETERS,
  SystemParameters.JSON_PROPERTY_LIMIT_PARAMETERS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SystemParameters {
  public static final String JSON_PROPERTY_NETWORK_DEFINITION = "network_definition";
  private NetworkDefinition networkDefinition;

  public static final String JSON_PROPERTY_COSTING_MODULE_CONFIG = "costing_module_config";
  private CostingModuleConfig costingModuleConfig;

  public static final String JSON_PROPERTY_COSTING_PARAMETERS = "costing_parameters";
  private SystemCostingParameters costingParameters;

  public static final String JSON_PROPERTY_LIMIT_PARAMETERS = "limit_parameters";
  private LimitParameters limitParameters;

  public SystemParameters() { 
  }

  public SystemParameters networkDefinition(NetworkDefinition networkDefinition) {
    this.networkDefinition = networkDefinition;
    return this;
  }

   /**
   * Get networkDefinition
   * @return networkDefinition
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_NETWORK_DEFINITION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public NetworkDefinition getNetworkDefinition() {
    return networkDefinition;
  }


  @JsonProperty(JSON_PROPERTY_NETWORK_DEFINITION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNetworkDefinition(NetworkDefinition networkDefinition) {
    this.networkDefinition = networkDefinition;
  }


  public SystemParameters costingModuleConfig(CostingModuleConfig costingModuleConfig) {
    this.costingModuleConfig = costingModuleConfig;
    return this;
  }

   /**
   * Get costingModuleConfig
   * @return costingModuleConfig
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_COSTING_MODULE_CONFIG)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public CostingModuleConfig getCostingModuleConfig() {
    return costingModuleConfig;
  }


  @JsonProperty(JSON_PROPERTY_COSTING_MODULE_CONFIG)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCostingModuleConfig(CostingModuleConfig costingModuleConfig) {
    this.costingModuleConfig = costingModuleConfig;
  }


  public SystemParameters costingParameters(SystemCostingParameters costingParameters) {
    this.costingParameters = costingParameters;
    return this;
  }

   /**
   * Get costingParameters
   * @return costingParameters
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_COSTING_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SystemCostingParameters getCostingParameters() {
    return costingParameters;
  }


  @JsonProperty(JSON_PROPERTY_COSTING_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCostingParameters(SystemCostingParameters costingParameters) {
    this.costingParameters = costingParameters;
  }


  public SystemParameters limitParameters(LimitParameters limitParameters) {
    this.limitParameters = limitParameters;
    return this;
  }

   /**
   * Get limitParameters
   * @return limitParameters
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_LIMIT_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public LimitParameters getLimitParameters() {
    return limitParameters;
  }


  @JsonProperty(JSON_PROPERTY_LIMIT_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLimitParameters(LimitParameters limitParameters) {
    this.limitParameters = limitParameters;
  }


  /**
   * Return true if this SystemParameters object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemParameters systemParameters = (SystemParameters) o;
    return Objects.equals(this.networkDefinition, systemParameters.networkDefinition) &&
        Objects.equals(this.costingModuleConfig, systemParameters.costingModuleConfig) &&
        Objects.equals(this.costingParameters, systemParameters.costingParameters) &&
        Objects.equals(this.limitParameters, systemParameters.limitParameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkDefinition, costingModuleConfig, costingParameters, limitParameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemParameters {\n");
    sb.append("    networkDefinition: ").append(toIndentedString(networkDefinition)).append("\n");
    sb.append("    costingModuleConfig: ").append(toIndentedString(costingModuleConfig)).append("\n");
    sb.append("    costingParameters: ").append(toIndentedString(costingParameters)).append("\n");
    sb.append("    limitParameters: ").append(toIndentedString(limitParameters)).append("\n");
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


/*
 * Radix Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.3.0
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
import com.radixdlt.api.core.generated.models.BlueprintInterface;
import com.radixdlt.api.core.generated.models.HookExport;
import com.radixdlt.api.core.generated.models.PackageExport;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * BlueprintDefinition
 */
@JsonPropertyOrder({
  BlueprintDefinition.JSON_PROPERTY_INTERFACE,
  BlueprintDefinition.JSON_PROPERTY_FUNCTION_EXPORTS,
  BlueprintDefinition.JSON_PROPERTY_HOOK_EXPORTS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class BlueprintDefinition {
  public static final String JSON_PROPERTY_INTERFACE = "interface";
  private BlueprintInterface _interface;

  public static final String JSON_PROPERTY_FUNCTION_EXPORTS = "function_exports";
  private Map<String, PackageExport> functionExports = new HashMap<>();

  public static final String JSON_PROPERTY_HOOK_EXPORTS = "hook_exports";
  private List<HookExport> hookExports = new ArrayList<>();

  public BlueprintDefinition() { 
  }

  public BlueprintDefinition _interface(BlueprintInterface _interface) {
    this._interface = _interface;
    return this;
  }

   /**
   * Get _interface
   * @return _interface
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_INTERFACE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BlueprintInterface getInterface() {
    return _interface;
  }


  @JsonProperty(JSON_PROPERTY_INTERFACE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setInterface(BlueprintInterface _interface) {
    this._interface = _interface;
  }


  public BlueprintDefinition functionExports(Map<String, PackageExport> functionExports) {
    this.functionExports = functionExports;
    return this;
  }

  public BlueprintDefinition putFunctionExportsItem(String key, PackageExport functionExportsItem) {
    this.functionExports.put(key, functionExportsItem);
    return this;
  }

   /**
   * A map from the function name to its export
   * @return functionExports
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A map from the function name to its export")
  @JsonProperty(JSON_PROPERTY_FUNCTION_EXPORTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Map<String, PackageExport> getFunctionExports() {
    return functionExports;
  }


  @JsonProperty(JSON_PROPERTY_FUNCTION_EXPORTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFunctionExports(Map<String, PackageExport> functionExports) {
    this.functionExports = functionExports;
  }


  public BlueprintDefinition hookExports(List<HookExport> hookExports) {
    this.hookExports = hookExports;
    return this;
  }

  public BlueprintDefinition addHookExportsItem(HookExport hookExportsItem) {
    this.hookExports.add(hookExportsItem);
    return this;
  }

   /**
   * A map from certain object lifecycle hooks to a callback \&quot;package export\&quot;. There is at most one callback registered for each &#x60;ObjectHook&#x60;. 
   * @return hookExports
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A map from certain object lifecycle hooks to a callback \"package export\". There is at most one callback registered for each `ObjectHook`. ")
  @JsonProperty(JSON_PROPERTY_HOOK_EXPORTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<HookExport> getHookExports() {
    return hookExports;
  }


  @JsonProperty(JSON_PROPERTY_HOOK_EXPORTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setHookExports(List<HookExport> hookExports) {
    this.hookExports = hookExports;
  }


  /**
   * Return true if this BlueprintDefinition object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlueprintDefinition blueprintDefinition = (BlueprintDefinition) o;
    return Objects.equals(this._interface, blueprintDefinition._interface) &&
        Objects.equals(this.functionExports, blueprintDefinition.functionExports) &&
        Objects.equals(this.hookExports, blueprintDefinition.hookExports);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_interface, functionExports, hookExports);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlueprintDefinition {\n");
    sb.append("    _interface: ").append(toIndentedString(_interface)).append("\n");
    sb.append("    functionExports: ").append(toIndentedString(functionExports)).append("\n");
    sb.append("    hookExports: ").append(toIndentedString(hookExports)).append("\n");
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


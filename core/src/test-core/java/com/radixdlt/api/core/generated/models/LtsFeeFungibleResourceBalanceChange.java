/*
 * Radix Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.3
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
import com.radixdlt.api.core.generated.models.LtsFeeFungibleResourceBalanceChangeType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * LtsFeeFungibleResourceBalanceChange
 */
@JsonPropertyOrder({
  LtsFeeFungibleResourceBalanceChange.JSON_PROPERTY_TYPE,
  LtsFeeFungibleResourceBalanceChange.JSON_PROPERTY_RESOURCE_ADDRESS,
  LtsFeeFungibleResourceBalanceChange.JSON_PROPERTY_BALANCE_CHANGE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class LtsFeeFungibleResourceBalanceChange {
  public static final String JSON_PROPERTY_TYPE = "type";
  private LtsFeeFungibleResourceBalanceChangeType type;

  public static final String JSON_PROPERTY_RESOURCE_ADDRESS = "resource_address";
  private String resourceAddress;

  public static final String JSON_PROPERTY_BALANCE_CHANGE = "balance_change";
  private String balanceChange;

  public LtsFeeFungibleResourceBalanceChange() { 
  }

  public LtsFeeFungibleResourceBalanceChange type(LtsFeeFungibleResourceBalanceChangeType type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public LtsFeeFungibleResourceBalanceChangeType getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(LtsFeeFungibleResourceBalanceChangeType type) {
    this.type = type;
  }


  public LtsFeeFungibleResourceBalanceChange resourceAddress(String resourceAddress) {
    this.resourceAddress = resourceAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the fungible resource&#39;s address 
   * @return resourceAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the fungible resource's address ")
  @JsonProperty(JSON_PROPERTY_RESOURCE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getResourceAddress() {
    return resourceAddress;
  }


  @JsonProperty(JSON_PROPERTY_RESOURCE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResourceAddress(String resourceAddress) {
    this.resourceAddress = resourceAddress;
  }


  public LtsFeeFungibleResourceBalanceChange balanceChange(String balanceChange) {
    this.balanceChange = balanceChange;
    return this;
  }

   /**
   * The string-encoded decimal representing the amount of change for the fungible resource. A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(192 - 1) &lt;&#x3D; m &lt; 2^(192 - 1)&#x60;. 
   * @return balanceChange
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The string-encoded decimal representing the amount of change for the fungible resource. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_BALANCE_CHANGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getBalanceChange() {
    return balanceChange;
  }


  @JsonProperty(JSON_PROPERTY_BALANCE_CHANGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBalanceChange(String balanceChange) {
    this.balanceChange = balanceChange;
  }


  /**
   * Return true if this LtsFeeFungibleResourceBalanceChange object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LtsFeeFungibleResourceBalanceChange ltsFeeFungibleResourceBalanceChange = (LtsFeeFungibleResourceBalanceChange) o;
    return Objects.equals(this.type, ltsFeeFungibleResourceBalanceChange.type) &&
        Objects.equals(this.resourceAddress, ltsFeeFungibleResourceBalanceChange.resourceAddress) &&
        Objects.equals(this.balanceChange, ltsFeeFungibleResourceBalanceChange.balanceChange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, resourceAddress, balanceChange);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LtsFeeFungibleResourceBalanceChange {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    resourceAddress: ").append(toIndentedString(resourceAddress)).append("\n");
    sb.append("    balanceChange: ").append(toIndentedString(balanceChange)).append("\n");
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


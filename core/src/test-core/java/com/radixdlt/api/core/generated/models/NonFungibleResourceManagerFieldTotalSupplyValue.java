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
 * NonFungibleResourceManagerFieldTotalSupplyValue
 */
@JsonPropertyOrder({
  NonFungibleResourceManagerFieldTotalSupplyValue.JSON_PROPERTY_TOTAL_SUPPLY
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class NonFungibleResourceManagerFieldTotalSupplyValue {
  public static final String JSON_PROPERTY_TOTAL_SUPPLY = "total_supply";
  private String totalSupply;

  public NonFungibleResourceManagerFieldTotalSupplyValue() { 
  }

  public NonFungibleResourceManagerFieldTotalSupplyValue totalSupply(String totalSupply) {
    this.totalSupply = totalSupply;
    return this;
  }

   /**
   * The string-encoded decimal representing the total supply of this resource. A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(192 - 1) &lt;&#x3D; m &lt; 2^(192 - 1)&#x60;. 
   * @return totalSupply
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The string-encoded decimal representing the total supply of this resource. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_TOTAL_SUPPLY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTotalSupply() {
    return totalSupply;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL_SUPPLY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTotalSupply(String totalSupply) {
    this.totalSupply = totalSupply;
  }


  /**
   * Return true if this NonFungibleResourceManagerFieldTotalSupplyValue object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonFungibleResourceManagerFieldTotalSupplyValue nonFungibleResourceManagerFieldTotalSupplyValue = (NonFungibleResourceManagerFieldTotalSupplyValue) o;
    return Objects.equals(this.totalSupply, nonFungibleResourceManagerFieldTotalSupplyValue.totalSupply);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalSupply);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NonFungibleResourceManagerFieldTotalSupplyValue {\n");
    sb.append("    totalSupply: ").append(toIndentedString(totalSupply)).append("\n");
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


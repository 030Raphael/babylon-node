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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.AllOfProofRule;
import com.radixdlt.api.core.generated.models.AmountOfProofRule;
import com.radixdlt.api.core.generated.models.AnyOfProofRule;
import com.radixdlt.api.core.generated.models.CountOfProofRule;
import com.radixdlt.api.core.generated.models.CountOfProofRuleAllOf;
import com.radixdlt.api.core.generated.models.DynamicCount;
import com.radixdlt.api.core.generated.models.DynamicResourceDescriptorList;
import com.radixdlt.api.core.generated.models.ProofRule;
import com.radixdlt.api.core.generated.models.ProofRuleType;
import com.radixdlt.api.core.generated.models.RequireProofRule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * CountOfProofRule
 */
@JsonPropertyOrder({
  CountOfProofRule.JSON_PROPERTY_COUNT,
  CountOfProofRule.JSON_PROPERTY_LIST
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = AllOfProofRule.class, name = "AllOf"),
  @JsonSubTypes.Type(value = AmountOfProofRule.class, name = "AmountOf"),
  @JsonSubTypes.Type(value = AnyOfProofRule.class, name = "AnyOf"),
  @JsonSubTypes.Type(value = CountOfProofRule.class, name = "CountOf"),
  @JsonSubTypes.Type(value = RequireProofRule.class, name = "Require"),
})

public class CountOfProofRule extends ProofRule {
  public static final String JSON_PROPERTY_COUNT = "count";
  private DynamicCount count;

  public static final String JSON_PROPERTY_LIST = "list";
  private DynamicResourceDescriptorList _list;

  public CountOfProofRule() { 
  }

  public CountOfProofRule count(DynamicCount count) {
    this.count = count;
    return this;
  }

   /**
   * Get count
   * @return count
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public DynamicCount getCount() {
    return count;
  }


  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCount(DynamicCount count) {
    this.count = count;
  }


  public CountOfProofRule _list(DynamicResourceDescriptorList _list) {
    this._list = _list;
    return this;
  }

   /**
   * Get _list
   * @return _list
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_LIST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public DynamicResourceDescriptorList getList() {
    return _list;
  }


  @JsonProperty(JSON_PROPERTY_LIST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setList(DynamicResourceDescriptorList _list) {
    this._list = _list;
  }


  /**
   * Return true if this CountOfProofRule object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CountOfProofRule countOfProofRule = (CountOfProofRule) o;
    return Objects.equals(this.count, countOfProofRule.count) &&
        Objects.equals(this._list, countOfProofRule._list) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, _list, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CountOfProofRule {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    _list: ").append(toIndentedString(_list)).append("\n");
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

static {
  // Initialize and register the discriminator mappings.
  Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
  mappings.put("AllOf", AllOfProofRule.class);
  mappings.put("AmountOf", AmountOfProofRule.class);
  mappings.put("AnyOf", AnyOfProofRule.class);
  mappings.put("CountOf", CountOfProofRule.class);
  mappings.put("Require", RequireProofRule.class);
  mappings.put("CountOfProofRule", CountOfProofRule.class);
  JSON.registerDiscriminator(CountOfProofRule.class, "type", mappings);
}
}


/*
 * Engine State API - Babylon (Anemone)
 * **This API is currently in Beta**  This specification may experience breaking changes as part of Babylon Node releases. Such changes will be clearly mentioned in the [babylon-node release notes](https://github.com/radixdlt/babylon-node/releases). We advise against using this API for business-critical integrations before the `version` indicated above becomes stable, which is expected in Q4 of 2024.  This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v1.2.1-beta
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.engine_state.generated.models;

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
import com.radixdlt.api.engine_state.generated.models.AllOfProofRule;
import com.radixdlt.api.engine_state.generated.models.AmountOfProofRule;
import com.radixdlt.api.engine_state.generated.models.AnyOfProofRule;
import com.radixdlt.api.engine_state.generated.models.CountOfProofRule;
import com.radixdlt.api.engine_state.generated.models.ProofRuleType;
import com.radixdlt.api.engine_state.generated.models.RequireProofRule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.engine_state.generated.client.JSON;
/**
 * ProofRule
 */
@JsonPropertyOrder({
  ProofRule.JSON_PROPERTY_TYPE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = AllOfProofRule.class, name = "AllOf"),
  @JsonSubTypes.Type(value = AllOfProofRule.class, name = "AllOfProofRule"),
  @JsonSubTypes.Type(value = AmountOfProofRule.class, name = "AmountOf"),
  @JsonSubTypes.Type(value = AmountOfProofRule.class, name = "AmountOfProofRule"),
  @JsonSubTypes.Type(value = AnyOfProofRule.class, name = "AnyOf"),
  @JsonSubTypes.Type(value = AnyOfProofRule.class, name = "AnyOfProofRule"),
  @JsonSubTypes.Type(value = CountOfProofRule.class, name = "CountOf"),
  @JsonSubTypes.Type(value = CountOfProofRule.class, name = "CountOfProofRule"),
  @JsonSubTypes.Type(value = RequireProofRule.class, name = "Require"),
  @JsonSubTypes.Type(value = RequireProofRule.class, name = "RequireProofRule"),
})

public class ProofRule {
  public static final String JSON_PROPERTY_TYPE = "type";
  private ProofRuleType type;

  public ProofRule() { 
  }

  public ProofRule type(ProofRuleType type) {
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

  public ProofRuleType getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(ProofRuleType type) {
    this.type = type;
  }


  /**
   * Return true if this ProofRule object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProofRule proofRule = (ProofRule) o;
    return Objects.equals(this.type, proofRule.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProofRule {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
  mappings.put("AllOfProofRule", AllOfProofRule.class);
  mappings.put("AmountOf", AmountOfProofRule.class);
  mappings.put("AmountOfProofRule", AmountOfProofRule.class);
  mappings.put("AnyOf", AnyOfProofRule.class);
  mappings.put("AnyOfProofRule", AnyOfProofRule.class);
  mappings.put("CountOf", CountOfProofRule.class);
  mappings.put("CountOfProofRule", CountOfProofRule.class);
  mappings.put("Require", RequireProofRule.class);
  mappings.put("RequireProofRule", RequireProofRule.class);
  mappings.put("ProofRule", ProofRule.class);
  JSON.registerDiscriminator(ProofRule.class, "type", mappings);
}
}


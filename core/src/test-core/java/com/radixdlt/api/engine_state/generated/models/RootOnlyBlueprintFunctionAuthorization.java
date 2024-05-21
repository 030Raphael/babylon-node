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
import com.radixdlt.api.engine_state.generated.models.BlueprintFunctionAuthorization;
import com.radixdlt.api.engine_state.generated.models.BlueprintFunctionAuthorizationType;
import com.radixdlt.api.engine_state.generated.models.ByAccessRuleBlueprintFunctionAuthorization;
import com.radixdlt.api.engine_state.generated.models.PublicBlueprintFunctionAuthorization;
import com.radixdlt.api.engine_state.generated.models.RootOnlyBlueprintFunctionAuthorization;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.engine_state.generated.client.JSON;
/**
 * RootOnlyBlueprintFunctionAuthorization
 */
@JsonPropertyOrder({
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = ByAccessRuleBlueprintFunctionAuthorization.class, name = "ByAccessRule"),
  @JsonSubTypes.Type(value = PublicBlueprintFunctionAuthorization.class, name = "Public"),
  @JsonSubTypes.Type(value = RootOnlyBlueprintFunctionAuthorization.class, name = "RootOnly"),
})

public class RootOnlyBlueprintFunctionAuthorization extends BlueprintFunctionAuthorization {
  public RootOnlyBlueprintFunctionAuthorization() { 
  }

  /**
   * Return true if this RootOnlyBlueprintFunctionAuthorization object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RootOnlyBlueprintFunctionAuthorization {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
  mappings.put("ByAccessRule", ByAccessRuleBlueprintFunctionAuthorization.class);
  mappings.put("Public", PublicBlueprintFunctionAuthorization.class);
  mappings.put("RootOnly", RootOnlyBlueprintFunctionAuthorization.class);
  mappings.put("RootOnlyBlueprintFunctionAuthorization", RootOnlyBlueprintFunctionAuthorization.class);
  JSON.registerDiscriminator(RootOnlyBlueprintFunctionAuthorization.class, "type", mappings);
}
}


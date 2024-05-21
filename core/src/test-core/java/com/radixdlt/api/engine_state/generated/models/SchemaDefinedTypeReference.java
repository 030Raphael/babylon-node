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
import com.radixdlt.api.engine_state.generated.models.ResolvedTypeReference;
import com.radixdlt.api.engine_state.generated.models.ResolvedTypeReferenceType;
import com.radixdlt.api.engine_state.generated.models.SchemaDefinedTypeReference;
import com.radixdlt.api.engine_state.generated.models.SchemaDefinedTypeReferenceAllOf;
import com.radixdlt.api.engine_state.generated.models.SchemaReference;
import com.radixdlt.api.engine_state.generated.models.WellKnownTypeReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.engine_state.generated.client.JSON;
/**
 * Reference to a fully-resolved type within a specific schema.
 */
@ApiModel(description = "Reference to a fully-resolved type within a specific schema.")
@JsonPropertyOrder({
  SchemaDefinedTypeReference.JSON_PROPERTY_SCHEMA_REFERENCE,
  SchemaDefinedTypeReference.JSON_PROPERTY_INDEX
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = SchemaDefinedTypeReference.class, name = "SchemaDefined"),
  @JsonSubTypes.Type(value = WellKnownTypeReference.class, name = "WellKnown"),
})

public class SchemaDefinedTypeReference extends ResolvedTypeReference {
  public static final String JSON_PROPERTY_SCHEMA_REFERENCE = "schema_reference";
  private SchemaReference schemaReference;

  public static final String JSON_PROPERTY_INDEX = "index";
  private Long index;

  public SchemaDefinedTypeReference() { 
  }

  public SchemaDefinedTypeReference schemaReference(SchemaReference schemaReference) {
    this.schemaReference = schemaReference;
    return this;
  }

   /**
   * Get schemaReference
   * @return schemaReference
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SCHEMA_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SchemaReference getSchemaReference() {
    return schemaReference;
  }


  @JsonProperty(JSON_PROPERTY_SCHEMA_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSchemaReference(SchemaReference schemaReference) {
    this.schemaReference = schemaReference;
  }


  public SchemaDefinedTypeReference index(Long index) {
    this.index = index;
    return this;
  }

   /**
   * The type&#39;s index within the referenced schema.
   * minimum: 0
   * maximum: 4294967295
   * @return index
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The type's index within the referenced schema.")
  @JsonProperty(JSON_PROPERTY_INDEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getIndex() {
    return index;
  }


  @JsonProperty(JSON_PROPERTY_INDEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIndex(Long index) {
    this.index = index;
  }


  /**
   * Return true if this SchemaDefinedTypeReference object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SchemaDefinedTypeReference schemaDefinedTypeReference = (SchemaDefinedTypeReference) o;
    return Objects.equals(this.schemaReference, schemaDefinedTypeReference.schemaReference) &&
        Objects.equals(this.index, schemaDefinedTypeReference.index) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(schemaReference, index, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SchemaDefinedTypeReference {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    schemaReference: ").append(toIndentedString(schemaReference)).append("\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
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
  mappings.put("SchemaDefined", SchemaDefinedTypeReference.class);
  mappings.put("WellKnown", WellKnownTypeReference.class);
  mappings.put("SchemaDefinedTypeReference", SchemaDefinedTypeReference.class);
  JSON.registerDiscriminator(SchemaDefinedTypeReference.class, "type", mappings);
}
}


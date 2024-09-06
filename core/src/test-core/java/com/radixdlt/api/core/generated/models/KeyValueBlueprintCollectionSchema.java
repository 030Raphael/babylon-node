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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.BlueprintCollectionSchema;
import com.radixdlt.api.core.generated.models.BlueprintCollectionSchemaType;
import com.radixdlt.api.core.generated.models.BlueprintPayloadDef;
import com.radixdlt.api.core.generated.models.IndexBlueprintCollectionSchema;
import com.radixdlt.api.core.generated.models.KeyValueBlueprintCollectionSchema;
import com.radixdlt.api.core.generated.models.KeyValueBlueprintCollectionSchemaAllOf;
import com.radixdlt.api.core.generated.models.SortedIndexBlueprintCollectionSchema;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * KeyValueBlueprintCollectionSchema
 */
@JsonPropertyOrder({
  KeyValueBlueprintCollectionSchema.JSON_PROPERTY_KEY_TYPE_REF,
  KeyValueBlueprintCollectionSchema.JSON_PROPERTY_VALUE_TYPE_REF,
  KeyValueBlueprintCollectionSchema.JSON_PROPERTY_ALLOW_OWNERSHIP
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = IndexBlueprintCollectionSchema.class, name = "Index"),
  @JsonSubTypes.Type(value = KeyValueBlueprintCollectionSchema.class, name = "KeyValue"),
  @JsonSubTypes.Type(value = SortedIndexBlueprintCollectionSchema.class, name = "SortedIndex"),
})

public class KeyValueBlueprintCollectionSchema extends BlueprintCollectionSchema {
  public static final String JSON_PROPERTY_KEY_TYPE_REF = "key_type_ref";
  private BlueprintPayloadDef keyTypeRef;

  public static final String JSON_PROPERTY_VALUE_TYPE_REF = "value_type_ref";
  private BlueprintPayloadDef valueTypeRef;

  public static final String JSON_PROPERTY_ALLOW_OWNERSHIP = "allow_ownership";
  private Boolean allowOwnership;

  public KeyValueBlueprintCollectionSchema() { 
  }

  public KeyValueBlueprintCollectionSchema keyTypeRef(BlueprintPayloadDef keyTypeRef) {
    this.keyTypeRef = keyTypeRef;
    return this;
  }

   /**
   * Get keyTypeRef
   * @return keyTypeRef
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_KEY_TYPE_REF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BlueprintPayloadDef getKeyTypeRef() {
    return keyTypeRef;
  }


  @JsonProperty(JSON_PROPERTY_KEY_TYPE_REF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKeyTypeRef(BlueprintPayloadDef keyTypeRef) {
    this.keyTypeRef = keyTypeRef;
  }


  public KeyValueBlueprintCollectionSchema valueTypeRef(BlueprintPayloadDef valueTypeRef) {
    this.valueTypeRef = valueTypeRef;
    return this;
  }

   /**
   * Get valueTypeRef
   * @return valueTypeRef
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_VALUE_TYPE_REF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BlueprintPayloadDef getValueTypeRef() {
    return valueTypeRef;
  }


  @JsonProperty(JSON_PROPERTY_VALUE_TYPE_REF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValueTypeRef(BlueprintPayloadDef valueTypeRef) {
    this.valueTypeRef = valueTypeRef;
  }


  public KeyValueBlueprintCollectionSchema allowOwnership(Boolean allowOwnership) {
    this.allowOwnership = allowOwnership;
    return this;
  }

   /**
   * Whether the entries of the key-value partition are allowed to own child nodes.
   * @return allowOwnership
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Whether the entries of the key-value partition are allowed to own child nodes.")
  @JsonProperty(JSON_PROPERTY_ALLOW_OWNERSHIP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getAllowOwnership() {
    return allowOwnership;
  }


  @JsonProperty(JSON_PROPERTY_ALLOW_OWNERSHIP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAllowOwnership(Boolean allowOwnership) {
    this.allowOwnership = allowOwnership;
  }


  /**
   * Return true if this KeyValueBlueprintCollectionSchema object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeyValueBlueprintCollectionSchema keyValueBlueprintCollectionSchema = (KeyValueBlueprintCollectionSchema) o;
    return Objects.equals(this.keyTypeRef, keyValueBlueprintCollectionSchema.keyTypeRef) &&
        Objects.equals(this.valueTypeRef, keyValueBlueprintCollectionSchema.valueTypeRef) &&
        Objects.equals(this.allowOwnership, keyValueBlueprintCollectionSchema.allowOwnership) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyTypeRef, valueTypeRef, allowOwnership, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyValueBlueprintCollectionSchema {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    keyTypeRef: ").append(toIndentedString(keyTypeRef)).append("\n");
    sb.append("    valueTypeRef: ").append(toIndentedString(valueTypeRef)).append("\n");
    sb.append("    allowOwnership: ").append(toIndentedString(allowOwnership)).append("\n");
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
  mappings.put("Index", IndexBlueprintCollectionSchema.class);
  mappings.put("KeyValue", KeyValueBlueprintCollectionSchema.class);
  mappings.put("SortedIndex", SortedIndexBlueprintCollectionSchema.class);
  mappings.put("KeyValueBlueprintCollectionSchema", KeyValueBlueprintCollectionSchema.class);
  JSON.registerDiscriminator(KeyValueBlueprintCollectionSchema.class, "type", mappings);
}
}


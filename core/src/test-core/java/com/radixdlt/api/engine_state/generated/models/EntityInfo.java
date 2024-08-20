/*
 * Engine State API (Beta)
 * **This API is currently in Beta**  This specification may experience breaking changes as part of Babylon Node releases. Such changes will be clearly mentioned in the [babylon-node release notes](https://github.com/radixdlt/babylon-node/releases). We advise against using this API for business-critical integrations before the `version` indicated above becomes stable, which is expected in Q4 of 2024.  This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v1.2.2
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
import com.radixdlt.api.engine_state.generated.models.EntityAncestryInfo;
import com.radixdlt.api.engine_state.generated.models.KeyValueStoreEntityInfo;
import com.radixdlt.api.engine_state.generated.models.ObjectEntityInfo;
import com.radixdlt.api.engine_state.generated.models.SystemType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.engine_state.generated.client.JSON;
/**
 * EntityInfo
 */
@JsonPropertyOrder({
  EntityInfo.JSON_PROPERTY_SYSTEM_TYPE,
  EntityInfo.JSON_PROPERTY_ANCESTRY
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "system_type", // ignore manually set system_type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the system_type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "system_type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = KeyValueStoreEntityInfo.class, name = "KeyValueStore"),
  @JsonSubTypes.Type(value = KeyValueStoreEntityInfo.class, name = "KeyValueStoreEntityInfo"),
  @JsonSubTypes.Type(value = ObjectEntityInfo.class, name = "Object"),
  @JsonSubTypes.Type(value = ObjectEntityInfo.class, name = "ObjectEntityInfo"),
})

public class EntityInfo {
  public static final String JSON_PROPERTY_SYSTEM_TYPE = "system_type";
  private SystemType systemType;

  public static final String JSON_PROPERTY_ANCESTRY = "ancestry";
  private EntityAncestryInfo ancestry;

  public EntityInfo() { 
  }

  public EntityInfo systemType(SystemType systemType) {
    this.systemType = systemType;
    return this;
  }

   /**
   * Get systemType
   * @return systemType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SYSTEM_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SystemType getSystemType() {
    return systemType;
  }


  @JsonProperty(JSON_PROPERTY_SYSTEM_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSystemType(SystemType systemType) {
    this.systemType = systemType;
  }


  public EntityInfo ancestry(EntityAncestryInfo ancestry) {
    this.ancestry = ancestry;
    return this;
  }

   /**
   * Get ancestry
   * @return ancestry
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ANCESTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public EntityAncestryInfo getAncestry() {
    return ancestry;
  }


  @JsonProperty(JSON_PROPERTY_ANCESTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAncestry(EntityAncestryInfo ancestry) {
    this.ancestry = ancestry;
  }


  /**
   * Return true if this EntityInfo object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntityInfo entityInfo = (EntityInfo) o;
    return Objects.equals(this.systemType, entityInfo.systemType) &&
        Objects.equals(this.ancestry, entityInfo.ancestry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(systemType, ancestry);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntityInfo {\n");
    sb.append("    systemType: ").append(toIndentedString(systemType)).append("\n");
    sb.append("    ancestry: ").append(toIndentedString(ancestry)).append("\n");
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
  mappings.put("KeyValueStore", KeyValueStoreEntityInfo.class);
  mappings.put("KeyValueStoreEntityInfo", KeyValueStoreEntityInfo.class);
  mappings.put("Object", ObjectEntityInfo.class);
  mappings.put("ObjectEntityInfo", ObjectEntityInfo.class);
  mappings.put("EntityInfo", EntityInfo.class);
  JSON.registerDiscriminator(EntityInfo.class, "system_type", mappings);
}
}


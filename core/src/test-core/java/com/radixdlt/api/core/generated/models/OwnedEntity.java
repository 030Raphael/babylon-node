/*
 * Babylon Core API - RCnet v3
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
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
import com.radixdlt.api.core.generated.models.EntityReference;
import com.radixdlt.api.core.generated.models.EntityType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * OwnedEntity
 */
@JsonPropertyOrder({
  OwnedEntity.JSON_PROPERTY_ENTITY_TYPE,
  OwnedEntity.JSON_PROPERTY_IS_GLOBAL,
  OwnedEntity.JSON_PROPERTY_ENTITY_ADDRESS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class OwnedEntity {
  public static final String JSON_PROPERTY_ENTITY_TYPE = "entity_type";
  private EntityType entityType;

  public static final String JSON_PROPERTY_IS_GLOBAL = "is_global";
  private Boolean isGlobal;

  public static final String JSON_PROPERTY_ENTITY_ADDRESS = "entity_address";
  private String entityAddress;

  public OwnedEntity() { 
  }

  public OwnedEntity entityType(EntityType entityType) {
    this.entityType = entityType;
    return this;
  }

   /**
   * Get entityType
   * @return entityType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EntityType getEntityType() {
    return entityType;
  }


  @JsonProperty(JSON_PROPERTY_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEntityType(EntityType entityType) {
    this.entityType = entityType;
  }


  public OwnedEntity isGlobal(Boolean isGlobal) {
    this.isGlobal = isGlobal;
    return this;
  }

   /**
   * Get isGlobal
   * @return isGlobal
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_IS_GLOBAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getIsGlobal() {
    return isGlobal;
  }


  @JsonProperty(JSON_PROPERTY_IS_GLOBAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIsGlobal(Boolean isGlobal) {
    this.isGlobal = isGlobal;
  }


  public OwnedEntity entityAddress(String entityAddress) {
    this.entityAddress = entityAddress;
    return this;
  }

   /**
   * Bech32m-encoded human readable version of the entity&#39;s address (ie the entity&#39;s node id)
   * @return entityAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Bech32m-encoded human readable version of the entity's address (ie the entity's node id)")
  @JsonProperty(JSON_PROPERTY_ENTITY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getEntityAddress() {
    return entityAddress;
  }


  @JsonProperty(JSON_PROPERTY_ENTITY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEntityAddress(String entityAddress) {
    this.entityAddress = entityAddress;
  }


  /**
   * Return true if this OwnedEntity object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OwnedEntity ownedEntity = (OwnedEntity) o;
    return Objects.equals(this.entityType, ownedEntity.entityType) &&
        Objects.equals(this.isGlobal, ownedEntity.isGlobal) &&
        Objects.equals(this.entityAddress, ownedEntity.entityAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entityType, isGlobal, entityAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OwnedEntity {\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    isGlobal: ").append(toIndentedString(isGlobal)).append("\n");
    sb.append("    entityAddress: ").append(toIndentedString(entityAddress)).append("\n");
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


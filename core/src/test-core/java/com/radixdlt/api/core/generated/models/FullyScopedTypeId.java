/*
 * Radix Core API - Babylon (Bottlenose)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.0
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
import com.radixdlt.api.core.generated.models.LocalTypeId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * An identifier for a type in the context of a schema in an entity&#39;s schema partition.  Note - this type provides a schema context even for well-known types where this context is effectively irrelevant. 
 */
@ApiModel(description = "An identifier for a type in the context of a schema in an entity's schema partition.  Note - this type provides a schema context even for well-known types where this context is effectively irrelevant. ")
@JsonPropertyOrder({
  FullyScopedTypeId.JSON_PROPERTY_ENTITY_ADDRESS,
  FullyScopedTypeId.JSON_PROPERTY_SCHEMA_HASH,
  FullyScopedTypeId.JSON_PROPERTY_LOCAL_TYPE_ID
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class FullyScopedTypeId {
  public static final String JSON_PROPERTY_ENTITY_ADDRESS = "entity_address";
  private String entityAddress;

  public static final String JSON_PROPERTY_SCHEMA_HASH = "schema_hash";
  private String schemaHash;

  public static final String JSON_PROPERTY_LOCAL_TYPE_ID = "local_type_id";
  private LocalTypeId localTypeId;

  public FullyScopedTypeId() { 
  }

  public FullyScopedTypeId entityAddress(String entityAddress) {
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


  public FullyScopedTypeId schemaHash(String schemaHash) {
    this.schemaHash = schemaHash;
    return this;
  }

   /**
   * The hex-encoded schema hash, capturing the identity of an SBOR schema.
   * @return schemaHash
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded schema hash, capturing the identity of an SBOR schema.")
  @JsonProperty(JSON_PROPERTY_SCHEMA_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getSchemaHash() {
    return schemaHash;
  }


  @JsonProperty(JSON_PROPERTY_SCHEMA_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSchemaHash(String schemaHash) {
    this.schemaHash = schemaHash;
  }


  public FullyScopedTypeId localTypeId(LocalTypeId localTypeId) {
    this.localTypeId = localTypeId;
    return this;
  }

   /**
   * Get localTypeId
   * @return localTypeId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_LOCAL_TYPE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public LocalTypeId getLocalTypeId() {
    return localTypeId;
  }


  @JsonProperty(JSON_PROPERTY_LOCAL_TYPE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLocalTypeId(LocalTypeId localTypeId) {
    this.localTypeId = localTypeId;
  }


  /**
   * Return true if this FullyScopedTypeId object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FullyScopedTypeId fullyScopedTypeId = (FullyScopedTypeId) o;
    return Objects.equals(this.entityAddress, fullyScopedTypeId.entityAddress) &&
        Objects.equals(this.schemaHash, fullyScopedTypeId.schemaHash) &&
        Objects.equals(this.localTypeId, fullyScopedTypeId.localTypeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entityAddress, schemaHash, localTypeId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FullyScopedTypeId {\n");
    sb.append("    entityAddress: ").append(toIndentedString(entityAddress)).append("\n");
    sb.append("    schemaHash: ").append(toIndentedString(schemaHash)).append("\n");
    sb.append("    localTypeId: ").append(toIndentedString(localTypeId)).append("\n");
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


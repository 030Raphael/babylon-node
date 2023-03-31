/*
 * Babylon Core API - RCnet V1
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
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
import com.radixdlt.api.core.generated.models.FieldSchemaSubpath;
import com.radixdlt.api.core.generated.models.IndexSchemaSubpath;
import com.radixdlt.api.core.generated.models.IndexSchemaSubpathAllOf;
import com.radixdlt.api.core.generated.models.SchemaSubpath;
import com.radixdlt.api.core.generated.models.SchemaSubpathType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * IndexSchemaSubpath
 */
@JsonPropertyOrder({
  IndexSchemaSubpath.JSON_PROPERTY_INDEX
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = FieldSchemaSubpath.class, name = "Field"),
  @JsonSubTypes.Type(value = IndexSchemaSubpath.class, name = "Index"),
})

public class IndexSchemaSubpath extends SchemaSubpath {
  public static final String JSON_PROPERTY_INDEX = "index";
  private String index;

  public IndexSchemaSubpath() { 
  }

  public IndexSchemaSubpath index(String index) {
    this.index = index;
    return this;
  }

   /**
   * A decimal-string-encoded integer between 0 and 2^64 - 1, which captures the index of the schema sub-path
   * @return index
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A decimal-string-encoded integer between 0 and 2^64 - 1, which captures the index of the schema sub-path")
  @JsonProperty(JSON_PROPERTY_INDEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getIndex() {
    return index;
  }


  @JsonProperty(JSON_PROPERTY_INDEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIndex(String index) {
    this.index = index;
  }


  /**
   * Return true if this IndexSchemaSubpath object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndexSchemaSubpath indexSchemaSubpath = (IndexSchemaSubpath) o;
    return Objects.equals(this.index, indexSchemaSubpath.index) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndexSchemaSubpath {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
  mappings.put("Field", FieldSchemaSubpath.class);
  mappings.put("Index", IndexSchemaSubpath.class);
  mappings.put("IndexSchemaSubpath", IndexSchemaSubpath.class);
  JSON.registerDiscriminator(IndexSchemaSubpath.class, "type", mappings);
}
}


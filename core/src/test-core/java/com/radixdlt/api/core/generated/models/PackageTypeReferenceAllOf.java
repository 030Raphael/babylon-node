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
import com.radixdlt.api.core.generated.models.LocalTypeIndex;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * PackageTypeReferenceAllOf
 */
@JsonPropertyOrder({
  PackageTypeReferenceAllOf.JSON_PROPERTY_PACKAGE_ADDRESS,
  PackageTypeReferenceAllOf.JSON_PROPERTY_SCHEMA_HASH,
  PackageTypeReferenceAllOf.JSON_PROPERTY_LOCAL_TYPE_INDEX
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class PackageTypeReferenceAllOf {
  public static final String JSON_PROPERTY_PACKAGE_ADDRESS = "package_address";
  private String packageAddress;

  public static final String JSON_PROPERTY_SCHEMA_HASH = "schema_hash";
  private String schemaHash;

  public static final String JSON_PROPERTY_LOCAL_TYPE_INDEX = "local_type_index";
  private LocalTypeIndex localTypeIndex;

  public PackageTypeReferenceAllOf() { 
  }

  public PackageTypeReferenceAllOf packageAddress(String packageAddress) {
    this.packageAddress = packageAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the package address
   * @return packageAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the package address")
  @JsonProperty(JSON_PROPERTY_PACKAGE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPackageAddress() {
    return packageAddress;
  }


  @JsonProperty(JSON_PROPERTY_PACKAGE_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPackageAddress(String packageAddress) {
    this.packageAddress = packageAddress;
  }


  public PackageTypeReferenceAllOf schemaHash(String schemaHash) {
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


  public PackageTypeReferenceAllOf localTypeIndex(LocalTypeIndex localTypeIndex) {
    this.localTypeIndex = localTypeIndex;
    return this;
  }

   /**
   * Get localTypeIndex
   * @return localTypeIndex
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_LOCAL_TYPE_INDEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public LocalTypeIndex getLocalTypeIndex() {
    return localTypeIndex;
  }


  @JsonProperty(JSON_PROPERTY_LOCAL_TYPE_INDEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLocalTypeIndex(LocalTypeIndex localTypeIndex) {
    this.localTypeIndex = localTypeIndex;
  }


  /**
   * Return true if this PackageTypeReference_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PackageTypeReferenceAllOf packageTypeReferenceAllOf = (PackageTypeReferenceAllOf) o;
    return Objects.equals(this.packageAddress, packageTypeReferenceAllOf.packageAddress) &&
        Objects.equals(this.schemaHash, packageTypeReferenceAllOf.schemaHash) &&
        Objects.equals(this.localTypeIndex, packageTypeReferenceAllOf.localTypeIndex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packageAddress, schemaHash, localTypeIndex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PackageTypeReferenceAllOf {\n");
    sb.append("    packageAddress: ").append(toIndentedString(packageAddress)).append("\n");
    sb.append("    schemaHash: ").append(toIndentedString(schemaHash)).append("\n");
    sb.append("    localTypeIndex: ").append(toIndentedString(localTypeIndex)).append("\n");
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


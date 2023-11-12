/*
 * Radix Core API - Babylon
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.0.4
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
import com.radixdlt.api.core.generated.models.ModuleId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * BrowseObjectCollectionIteratorRequest
 */
@JsonPropertyOrder({
  BrowseObjectCollectionIteratorRequest.JSON_PROPERTY_NETWORK,
  BrowseObjectCollectionIteratorRequest.JSON_PROPERTY_ENTITY_ADDRESS,
  BrowseObjectCollectionIteratorRequest.JSON_PROPERTY_MODULE_ID,
  BrowseObjectCollectionIteratorRequest.JSON_PROPERTY_COLLECTION_NAME,
  BrowseObjectCollectionIteratorRequest.JSON_PROPERTY_COLLECTION_INDEX,
  BrowseObjectCollectionIteratorRequest.JSON_PROPERTY_MAX_PAGE_SIZE,
  BrowseObjectCollectionIteratorRequest.JSON_PROPERTY_CONTINUATION_TOKEN
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class BrowseObjectCollectionIteratorRequest {
  public static final String JSON_PROPERTY_NETWORK = "network";
  private String network;

  public static final String JSON_PROPERTY_ENTITY_ADDRESS = "entity_address";
  private String entityAddress;

  public static final String JSON_PROPERTY_MODULE_ID = "module_id";
  private ModuleId moduleId;

  public static final String JSON_PROPERTY_COLLECTION_NAME = "collection_name";
  private String collectionName;

  public static final String JSON_PROPERTY_COLLECTION_INDEX = "collection_index";
  private Integer collectionIndex;

  public static final String JSON_PROPERTY_MAX_PAGE_SIZE = "max_page_size";
  private Integer maxPageSize;

  public static final String JSON_PROPERTY_CONTINUATION_TOKEN = "continuation_token";
  private String continuationToken;

  public BrowseObjectCollectionIteratorRequest() { 
  }

  public BrowseObjectCollectionIteratorRequest network(String network) {
    this.network = network;
    return this;
  }

   /**
   * The logical name of the network
   * @return network
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "{{network}}", required = true, value = "The logical name of the network")
  @JsonProperty(JSON_PROPERTY_NETWORK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNetwork() {
    return network;
  }


  @JsonProperty(JSON_PROPERTY_NETWORK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNetwork(String network) {
    this.network = network;
  }


  public BrowseObjectCollectionIteratorRequest entityAddress(String entityAddress) {
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


  public BrowseObjectCollectionIteratorRequest moduleId(ModuleId moduleId) {
    this.moduleId = moduleId;
    return this;
  }

   /**
   * Get moduleId
   * @return moduleId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_MODULE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ModuleId getModuleId() {
    return moduleId;
  }


  @JsonProperty(JSON_PROPERTY_MODULE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setModuleId(ModuleId moduleId) {
    this.moduleId = moduleId;
  }


  public BrowseObjectCollectionIteratorRequest collectionName(String collectionName) {
    this.collectionName = collectionName;
    return this;
  }

   /**
   * Name of the collection to read. Either this or &#x60;collection_index&#x60; is required.
   * @return collectionName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Name of the collection to read. Either this or `collection_index` is required.")
  @JsonProperty(JSON_PROPERTY_COLLECTION_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCollectionName() {
    return collectionName;
  }


  @JsonProperty(JSON_PROPERTY_COLLECTION_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCollectionName(String collectionName) {
    this.collectionName = collectionName;
  }


  public BrowseObjectCollectionIteratorRequest collectionIndex(Integer collectionIndex) {
    this.collectionIndex = collectionIndex;
    return this;
  }

   /**
   * Index of the field to read. Either this or &#x60;collection_name&#x60; is required.
   * minimum: 0
   * maximum: 255
   * @return collectionIndex
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Index of the field to read. Either this or `collection_name` is required.")
  @JsonProperty(JSON_PROPERTY_COLLECTION_INDEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getCollectionIndex() {
    return collectionIndex;
  }


  @JsonProperty(JSON_PROPERTY_COLLECTION_INDEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCollectionIndex(Integer collectionIndex) {
    this.collectionIndex = collectionIndex;
  }


  public BrowseObjectCollectionIteratorRequest maxPageSize(Integer maxPageSize) {
    this.maxPageSize = maxPageSize;
    return this;
  }

   /**
   * A maximum number of items to be included in the paged listing response. By default, each paged listing endpoint imposes its own limit on the number of returned items (which may even be driven dynamically by system load, etc). This client-provided maximum page size simply adds a further constraint (i.e. can only lower down the number of returned items). 
   * minimum: 1
   * maximum: 1000
   * @return maxPageSize
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A maximum number of items to be included in the paged listing response. By default, each paged listing endpoint imposes its own limit on the number of returned items (which may even be driven dynamically by system load, etc). This client-provided maximum page size simply adds a further constraint (i.e. can only lower down the number of returned items). ")
  @JsonProperty(JSON_PROPERTY_MAX_PAGE_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getMaxPageSize() {
    return maxPageSize;
  }


  @JsonProperty(JSON_PROPERTY_MAX_PAGE_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMaxPageSize(Integer maxPageSize) {
    this.maxPageSize = maxPageSize;
  }


  public BrowseObjectCollectionIteratorRequest continuationToken(String continuationToken) {
    this.continuationToken = continuationToken;
    return this;
  }

   /**
   * An opaque string conveying the information on where the next page of results starts. It is returned in every paged listing response (except for the last page), and it can be passed in every paged listing request (in order to begin listing from where the previous response ended). 
   * @return continuationToken
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An opaque string conveying the information on where the next page of results starts. It is returned in every paged listing response (except for the last page), and it can be passed in every paged listing request (in order to begin listing from where the previous response ended). ")
  @JsonProperty(JSON_PROPERTY_CONTINUATION_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getContinuationToken() {
    return continuationToken;
  }


  @JsonProperty(JSON_PROPERTY_CONTINUATION_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContinuationToken(String continuationToken) {
    this.continuationToken = continuationToken;
  }


  /**
   * Return true if this BrowseObjectCollectionIteratorRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BrowseObjectCollectionIteratorRequest browseObjectCollectionIteratorRequest = (BrowseObjectCollectionIteratorRequest) o;
    return Objects.equals(this.network, browseObjectCollectionIteratorRequest.network) &&
        Objects.equals(this.entityAddress, browseObjectCollectionIteratorRequest.entityAddress) &&
        Objects.equals(this.moduleId, browseObjectCollectionIteratorRequest.moduleId) &&
        Objects.equals(this.collectionName, browseObjectCollectionIteratorRequest.collectionName) &&
        Objects.equals(this.collectionIndex, browseObjectCollectionIteratorRequest.collectionIndex) &&
        Objects.equals(this.maxPageSize, browseObjectCollectionIteratorRequest.maxPageSize) &&
        Objects.equals(this.continuationToken, browseObjectCollectionIteratorRequest.continuationToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(network, entityAddress, moduleId, collectionName, collectionIndex, maxPageSize, continuationToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BrowseObjectCollectionIteratorRequest {\n");
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
    sb.append("    entityAddress: ").append(toIndentedString(entityAddress)).append("\n");
    sb.append("    moduleId: ").append(toIndentedString(moduleId)).append("\n");
    sb.append("    collectionName: ").append(toIndentedString(collectionName)).append("\n");
    sb.append("    collectionIndex: ").append(toIndentedString(collectionIndex)).append("\n");
    sb.append("    maxPageSize: ").append(toIndentedString(maxPageSize)).append("\n");
    sb.append("    continuationToken: ").append(toIndentedString(continuationToken)).append("\n");
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


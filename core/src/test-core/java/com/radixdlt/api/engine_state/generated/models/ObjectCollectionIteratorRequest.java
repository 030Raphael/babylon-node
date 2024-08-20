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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.engine_state.generated.models.AttachedModuleId;
import com.radixdlt.api.engine_state.generated.models.LedgerStateSelector;
import com.radixdlt.api.engine_state.generated.models.SborFormatOptions;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ObjectCollectionIteratorRequest
 */
@JsonPropertyOrder({
  ObjectCollectionIteratorRequest.JSON_PROPERTY_ENTITY_ADDRESS,
  ObjectCollectionIteratorRequest.JSON_PROPERTY_ATTACHED_MODULE_ID,
  ObjectCollectionIteratorRequest.JSON_PROPERTY_COLLECTION_NAME,
  ObjectCollectionIteratorRequest.JSON_PROPERTY_COLLECTION_INDEX,
  ObjectCollectionIteratorRequest.JSON_PROPERTY_SBOR_FORMAT_OPTIONS,
  ObjectCollectionIteratorRequest.JSON_PROPERTY_MAX_PAGE_SIZE,
  ObjectCollectionIteratorRequest.JSON_PROPERTY_CONTINUATION_TOKEN,
  ObjectCollectionIteratorRequest.JSON_PROPERTY_AT_LEDGER_STATE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ObjectCollectionIteratorRequest {
  public static final String JSON_PROPERTY_ENTITY_ADDRESS = "entity_address";
  private String entityAddress;

  public static final String JSON_PROPERTY_ATTACHED_MODULE_ID = "attached_module_id";
  private AttachedModuleId attachedModuleId;

  public static final String JSON_PROPERTY_COLLECTION_NAME = "collection_name";
  private String collectionName;

  public static final String JSON_PROPERTY_COLLECTION_INDEX = "collection_index";
  private Integer collectionIndex;

  public static final String JSON_PROPERTY_SBOR_FORMAT_OPTIONS = "sbor_format_options";
  private SborFormatOptions sborFormatOptions;

  public static final String JSON_PROPERTY_MAX_PAGE_SIZE = "max_page_size";
  private Integer maxPageSize;

  public static final String JSON_PROPERTY_CONTINUATION_TOKEN = "continuation_token";
  private String continuationToken;

  public static final String JSON_PROPERTY_AT_LEDGER_STATE = "at_ledger_state";
  private LedgerStateSelector atLedgerState;

  public ObjectCollectionIteratorRequest() { 
  }

  public ObjectCollectionIteratorRequest entityAddress(String entityAddress) {
    this.entityAddress = entityAddress;
    return this;
  }

   /**
   * A Bech32m-encoded, human readable rendering of an arbitrary Entity&#39;s address.
   * @return entityAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A Bech32m-encoded, human readable rendering of an arbitrary Entity's address.")
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


  public ObjectCollectionIteratorRequest attachedModuleId(AttachedModuleId attachedModuleId) {
    this.attachedModuleId = attachedModuleId;
    return this;
  }

   /**
   * Get attachedModuleId
   * @return attachedModuleId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ATTACHED_MODULE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AttachedModuleId getAttachedModuleId() {
    return attachedModuleId;
  }


  @JsonProperty(JSON_PROPERTY_ATTACHED_MODULE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAttachedModuleId(AttachedModuleId attachedModuleId) {
    this.attachedModuleId = attachedModuleId;
  }


  public ObjectCollectionIteratorRequest collectionName(String collectionName) {
    this.collectionName = collectionName;
    return this;
  }

   /**
   * Name of the collection to read. Either this or &#x60;collection_index&#x60; is required. Note: getting a collection by name is only a convenience feature, meant for manual, ad-hoc requests (i.e. allowing a human to use the human-readable &#x60;DerivedName&#x60; when available). In general, a collection&#39;s primary identifier is its index, and any production-grade integration should use it. 
   * @return collectionName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Name of the collection to read. Either this or `collection_index` is required. Note: getting a collection by name is only a convenience feature, meant for manual, ad-hoc requests (i.e. allowing a human to use the human-readable `DerivedName` when available). In general, a collection's primary identifier is its index, and any production-grade integration should use it. ")
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


  public ObjectCollectionIteratorRequest collectionIndex(Integer collectionIndex) {
    this.collectionIndex = collectionIndex;
    return this;
  }

   /**
   * Index of the collection to read. Either this or &#x60;collection_name&#x60; is required.
   * minimum: 0
   * maximum: 255
   * @return collectionIndex
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Index of the collection to read. Either this or `collection_name` is required.")
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


  public ObjectCollectionIteratorRequest sborFormatOptions(SborFormatOptions sborFormatOptions) {
    this.sborFormatOptions = sborFormatOptions;
    return this;
  }

   /**
   * Get sborFormatOptions
   * @return sborFormatOptions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SBOR_FORMAT_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SborFormatOptions getSborFormatOptions() {
    return sborFormatOptions;
  }


  @JsonProperty(JSON_PROPERTY_SBOR_FORMAT_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSborFormatOptions(SborFormatOptions sborFormatOptions) {
    this.sborFormatOptions = sborFormatOptions;
  }


  public ObjectCollectionIteratorRequest maxPageSize(Integer maxPageSize) {
    this.maxPageSize = maxPageSize;
    return this;
  }

   /**
   * A maximum number of items to be included in the paged listing response.
   * minimum: 1
   * maximum: 100
   * @return maxPageSize
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A maximum number of items to be included in the paged listing response.")
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


  public ObjectCollectionIteratorRequest continuationToken(String continuationToken) {
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


  public ObjectCollectionIteratorRequest atLedgerState(LedgerStateSelector atLedgerState) {
    this.atLedgerState = atLedgerState;
    return this;
  }

   /**
   * Get atLedgerState
   * @return atLedgerState
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_AT_LEDGER_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LedgerStateSelector getAtLedgerState() {
    return atLedgerState;
  }


  @JsonProperty(JSON_PROPERTY_AT_LEDGER_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAtLedgerState(LedgerStateSelector atLedgerState) {
    this.atLedgerState = atLedgerState;
  }


  /**
   * Return true if this ObjectCollectionIteratorRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectCollectionIteratorRequest objectCollectionIteratorRequest = (ObjectCollectionIteratorRequest) o;
    return Objects.equals(this.entityAddress, objectCollectionIteratorRequest.entityAddress) &&
        Objects.equals(this.attachedModuleId, objectCollectionIteratorRequest.attachedModuleId) &&
        Objects.equals(this.collectionName, objectCollectionIteratorRequest.collectionName) &&
        Objects.equals(this.collectionIndex, objectCollectionIteratorRequest.collectionIndex) &&
        Objects.equals(this.sborFormatOptions, objectCollectionIteratorRequest.sborFormatOptions) &&
        Objects.equals(this.maxPageSize, objectCollectionIteratorRequest.maxPageSize) &&
        Objects.equals(this.continuationToken, objectCollectionIteratorRequest.continuationToken) &&
        Objects.equals(this.atLedgerState, objectCollectionIteratorRequest.atLedgerState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entityAddress, attachedModuleId, collectionName, collectionIndex, sborFormatOptions, maxPageSize, continuationToken, atLedgerState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectCollectionIteratorRequest {\n");
    sb.append("    entityAddress: ").append(toIndentedString(entityAddress)).append("\n");
    sb.append("    attachedModuleId: ").append(toIndentedString(attachedModuleId)).append("\n");
    sb.append("    collectionName: ").append(toIndentedString(collectionName)).append("\n");
    sb.append("    collectionIndex: ").append(toIndentedString(collectionIndex)).append("\n");
    sb.append("    sborFormatOptions: ").append(toIndentedString(sborFormatOptions)).append("\n");
    sb.append("    maxPageSize: ").append(toIndentedString(maxPageSize)).append("\n");
    sb.append("    continuationToken: ").append(toIndentedString(continuationToken)).append("\n");
    sb.append("    atLedgerState: ").append(toIndentedString(atLedgerState)).append("\n");
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


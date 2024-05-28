/*
 * Engine State API - Babylon (Anemone)
 * **This API is currently in Beta**  This specification may experience breaking changes as part of Babylon Node releases. Such changes will be clearly mentioned in the [babylon-node release notes](https://github.com/radixdlt/babylon-node/releases). We advise against using this API for business-critical integrations before the `version` indicated above becomes stable, which is expected in Q4 of 2024.  This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v0.1-beta
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
import com.radixdlt.api.engine_state.generated.models.ObjectCollectionKind;
import com.radixdlt.api.engine_state.generated.models.ResolvedTypeReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ObjectCollectionInfo
 */
@JsonPropertyOrder({
  ObjectCollectionInfo.JSON_PROPERTY_INDEX,
  ObjectCollectionInfo.JSON_PROPERTY_KIND,
  ObjectCollectionInfo.JSON_PROPERTY_NAME,
  ObjectCollectionInfo.JSON_PROPERTY_KEY_TYPE_REFERENCE,
  ObjectCollectionInfo.JSON_PROPERTY_VALUE_TYPE_REFERENCE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ObjectCollectionInfo {
  public static final String JSON_PROPERTY_INDEX = "index";
  private Integer index;

  public static final String JSON_PROPERTY_KIND = "kind";
  private ObjectCollectionKind kind;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_KEY_TYPE_REFERENCE = "key_type_reference";
  private ResolvedTypeReference keyTypeReference;

  public static final String JSON_PROPERTY_VALUE_TYPE_REFERENCE = "value_type_reference";
  private ResolvedTypeReference valueTypeReference;

  public ObjectCollectionInfo() { 
  }

  public ObjectCollectionInfo index(Integer index) {
    this.index = index;
    return this;
  }

   /**
   * Collection&#39;s index - please note that it will not necessarily be equal to an index of this item within &#x60;ObjectModuleStateInfo.collections&#x60;. 
   * minimum: 0
   * maximum: 255
   * @return index
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Collection's index - please note that it will not necessarily be equal to an index of this item within `ObjectModuleStateInfo.collections`. ")
  @JsonProperty(JSON_PROPERTY_INDEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getIndex() {
    return index;
  }


  @JsonProperty(JSON_PROPERTY_INDEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIndex(Integer index) {
    this.index = index;
  }


  public ObjectCollectionInfo kind(ObjectCollectionKind kind) {
    this.kind = kind;
    return this;
  }

   /**
   * Get kind
   * @return kind
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ObjectCollectionKind getKind() {
    return kind;
  }


  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKind(ObjectCollectionKind kind) {
    this.kind = kind;
  }


  public ObjectCollectionInfo name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A human-readable name, derived on a best-effort basis from the type info/blueprint/schema. May be missing either because the subject deliberately has no defined name (e.g. in case of an unnamed tuple) or because the name resolution was not successful (e.g. when certain naming conventions are not observed within the relevant definitions). 
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A human-readable name, derived on a best-effort basis from the type info/blueprint/schema. May be missing either because the subject deliberately has no defined name (e.g. in case of an unnamed tuple) or because the name resolution was not successful (e.g. when certain naming conventions are not observed within the relevant definitions). ")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }


  public ObjectCollectionInfo keyTypeReference(ResolvedTypeReference keyTypeReference) {
    this.keyTypeReference = keyTypeReference;
    return this;
  }

   /**
   * Get keyTypeReference
   * @return keyTypeReference
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_KEY_TYPE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ResolvedTypeReference getKeyTypeReference() {
    return keyTypeReference;
  }


  @JsonProperty(JSON_PROPERTY_KEY_TYPE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKeyTypeReference(ResolvedTypeReference keyTypeReference) {
    this.keyTypeReference = keyTypeReference;
  }


  public ObjectCollectionInfo valueTypeReference(ResolvedTypeReference valueTypeReference) {
    this.valueTypeReference = valueTypeReference;
    return this;
  }

   /**
   * Get valueTypeReference
   * @return valueTypeReference
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_VALUE_TYPE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ResolvedTypeReference getValueTypeReference() {
    return valueTypeReference;
  }


  @JsonProperty(JSON_PROPERTY_VALUE_TYPE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValueTypeReference(ResolvedTypeReference valueTypeReference) {
    this.valueTypeReference = valueTypeReference;
  }


  /**
   * Return true if this ObjectCollectionInfo object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectCollectionInfo objectCollectionInfo = (ObjectCollectionInfo) o;
    return Objects.equals(this.index, objectCollectionInfo.index) &&
        Objects.equals(this.kind, objectCollectionInfo.kind) &&
        Objects.equals(this.name, objectCollectionInfo.name) &&
        Objects.equals(this.keyTypeReference, objectCollectionInfo.keyTypeReference) &&
        Objects.equals(this.valueTypeReference, objectCollectionInfo.valueTypeReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, kind, name, keyTypeReference, valueTypeReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectCollectionInfo {\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    keyTypeReference: ").append(toIndentedString(keyTypeReference)).append("\n");
    sb.append("    valueTypeReference: ").append(toIndentedString(valueTypeReference)).append("\n");
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


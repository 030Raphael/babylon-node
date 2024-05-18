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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.engine_state.generated.models.ResolvedTypeReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ObjectFieldInfo
 */
@JsonPropertyOrder({
  ObjectFieldInfo.JSON_PROPERTY_INDEX,
  ObjectFieldInfo.JSON_PROPERTY_NAME,
  ObjectFieldInfo.JSON_PROPERTY_TYPE_REFERENCE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ObjectFieldInfo {
  public static final String JSON_PROPERTY_INDEX = "index";
  private Integer index;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_TYPE_REFERENCE = "type_reference";
  private ResolvedTypeReference typeReference;

  public ObjectFieldInfo() { 
  }

  public ObjectFieldInfo index(Integer index) {
    this.index = index;
    return this;
  }

   /**
   * Field&#39;s index - please note that it will not necessarily be equal to an index of this item within &#x60;ObjectModuleStateInfo.fields&#x60; (since e.g. not all conditional fields defined by the blueprint must be present for the object). 
   * minimum: 0
   * maximum: 255
   * @return index
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Field's index - please note that it will not necessarily be equal to an index of this item within `ObjectModuleStateInfo.fields` (since e.g. not all conditional fields defined by the blueprint must be present for the object). ")
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


  public ObjectFieldInfo name(String name) {
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


  public ObjectFieldInfo typeReference(ResolvedTypeReference typeReference) {
    this.typeReference = typeReference;
    return this;
  }

   /**
   * Get typeReference
   * @return typeReference
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TYPE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ResolvedTypeReference getTypeReference() {
    return typeReference;
  }


  @JsonProperty(JSON_PROPERTY_TYPE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTypeReference(ResolvedTypeReference typeReference) {
    this.typeReference = typeReference;
  }


  /**
   * Return true if this ObjectFieldInfo object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectFieldInfo objectFieldInfo = (ObjectFieldInfo) o;
    return Objects.equals(this.index, objectFieldInfo.index) &&
        Objects.equals(this.name, objectFieldInfo.name) &&
        Objects.equals(this.typeReference, objectFieldInfo.typeReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, name, typeReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectFieldInfo {\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    typeReference: ").append(toIndentedString(typeReference)).append("\n");
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


/*
 * Engine State API (Beta)
 * **This API is currently in Beta**  This specification may experience breaking changes as part of Babylon Node releases. Such changes will be clearly mentioned in the [babylon-node release notes](https://github.com/radixdlt/babylon-node/releases). We advise against using this API for business-critical integrations before the `version` indicated above becomes stable, which is expected in Q4 of 2024.  This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v1.2.3
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
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Object&#39;s metadata details defined on a per-instance basis (i.e. not in blueprint). Please note that even uninstantiated objects do have instance info (i.e. a default one). 
 */
@ApiModel(description = "Object's metadata details defined on a per-instance basis (i.e. not in blueprint). Please note that even uninstantiated objects do have instance info (i.e. a default one). ")
@JsonPropertyOrder({
  ObjectInstanceInfo.JSON_PROPERTY_OUTER_OBJECT_ADDRESS,
  ObjectInstanceInfo.JSON_PROPERTY_ENABLED_FEATURES,
  ObjectInstanceInfo.JSON_PROPERTY_SUBSTITUTED_GENERIC_TYPES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ObjectInstanceInfo {
  public static final String JSON_PROPERTY_OUTER_OBJECT_ADDRESS = "outer_object_address";
  private String outerObjectAddress;

  public static final String JSON_PROPERTY_ENABLED_FEATURES = "enabled_features";
  private List<String> enabledFeatures = new ArrayList<>();

  public static final String JSON_PROPERTY_SUBSTITUTED_GENERIC_TYPES = "substituted_generic_types";
  private List<ResolvedTypeReference> substitutedGenericTypes = new ArrayList<>();

  public ObjectInstanceInfo() { 
  }

  public ObjectInstanceInfo outerObjectAddress(String outerObjectAddress) {
    this.outerObjectAddress = outerObjectAddress;
    return this;
  }

   /**
   * A Bech32m-encoded, human readable rendering of any global Entity&#39;s address.
   * @return outerObjectAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A Bech32m-encoded, human readable rendering of any global Entity's address.")
  @JsonProperty(JSON_PROPERTY_OUTER_OBJECT_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOuterObjectAddress() {
    return outerObjectAddress;
  }


  @JsonProperty(JSON_PROPERTY_OUTER_OBJECT_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOuterObjectAddress(String outerObjectAddress) {
    this.outerObjectAddress = outerObjectAddress;
  }


  public ObjectInstanceInfo enabledFeatures(List<String> enabledFeatures) {
    this.enabledFeatures = enabledFeatures;
    return this;
  }

  public ObjectInstanceInfo addEnabledFeaturesItem(String enabledFeaturesItem) {
    this.enabledFeatures.add(enabledFeaturesItem);
    return this;
  }

   /**
   * Names of the features enabled for this instance.
   * @return enabledFeatures
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Names of the features enabled for this instance.")
  @JsonProperty(JSON_PROPERTY_ENABLED_FEATURES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getEnabledFeatures() {
    return enabledFeatures;
  }


  @JsonProperty(JSON_PROPERTY_ENABLED_FEATURES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEnabledFeatures(List<String> enabledFeatures) {
    this.enabledFeatures = enabledFeatures;
  }


  public ObjectInstanceInfo substitutedGenericTypes(List<ResolvedTypeReference> substitutedGenericTypes) {
    this.substitutedGenericTypes = substitutedGenericTypes;
    return this;
  }

  public ObjectInstanceInfo addSubstitutedGenericTypesItem(ResolvedTypeReference substitutedGenericTypesItem) {
    this.substitutedGenericTypes.add(substitutedGenericTypesItem);
    return this;
  }

   /**
   * The actual types used for generics defined by the blueprint.
   * @return substitutedGenericTypes
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The actual types used for generics defined by the blueprint.")
  @JsonProperty(JSON_PROPERTY_SUBSTITUTED_GENERIC_TYPES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<ResolvedTypeReference> getSubstitutedGenericTypes() {
    return substitutedGenericTypes;
  }


  @JsonProperty(JSON_PROPERTY_SUBSTITUTED_GENERIC_TYPES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSubstitutedGenericTypes(List<ResolvedTypeReference> substitutedGenericTypes) {
    this.substitutedGenericTypes = substitutedGenericTypes;
  }


  /**
   * Return true if this ObjectInstanceInfo object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectInstanceInfo objectInstanceInfo = (ObjectInstanceInfo) o;
    return Objects.equals(this.outerObjectAddress, objectInstanceInfo.outerObjectAddress) &&
        Objects.equals(this.enabledFeatures, objectInstanceInfo.enabledFeatures) &&
        Objects.equals(this.substitutedGenericTypes, objectInstanceInfo.substitutedGenericTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(outerObjectAddress, enabledFeatures, substitutedGenericTypes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectInstanceInfo {\n");
    sb.append("    outerObjectAddress: ").append(toIndentedString(outerObjectAddress)).append("\n");
    sb.append("    enabledFeatures: ").append(toIndentedString(enabledFeatures)).append("\n");
    sb.append("    substitutedGenericTypes: ").append(toIndentedString(substitutedGenericTypes)).append("\n");
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


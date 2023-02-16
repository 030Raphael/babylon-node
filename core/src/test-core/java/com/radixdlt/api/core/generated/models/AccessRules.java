/*
 * Babylon Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.AccessRule;
import com.radixdlt.api.core.generated.models.GroupedAuthEntry;
import com.radixdlt.api.core.generated.models.MethodAuthEntry;
import com.radixdlt.api.core.generated.models.MethodAuthMutabilityEntry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * AccessRules
 */
@JsonPropertyOrder({
  AccessRules.JSON_PROPERTY_METHOD_AUTH,
  AccessRules.JSON_PROPERTY_GROUPED_AUTH,
  AccessRules.JSON_PROPERTY_DEFAULT_AUTH,
  AccessRules.JSON_PROPERTY_METHOD_AUTH_MUTABILITY,
  AccessRules.JSON_PROPERTY_GROUPED_AUTH_MUTABILITY,
  AccessRules.JSON_PROPERTY_DEFAULT_AUTH_MUTABILITY
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class AccessRules {
  public static final String JSON_PROPERTY_METHOD_AUTH = "method_auth";
  private List<MethodAuthEntry> methodAuth = new ArrayList<>();

  public static final String JSON_PROPERTY_GROUPED_AUTH = "grouped_auth";
  private List<GroupedAuthEntry> groupedAuth = new ArrayList<>();

  public static final String JSON_PROPERTY_DEFAULT_AUTH = "default_auth";
  private AccessRule defaultAuth;

  public static final String JSON_PROPERTY_METHOD_AUTH_MUTABILITY = "method_auth_mutability";
  private List<MethodAuthMutabilityEntry> methodAuthMutability = new ArrayList<>();

  public static final String JSON_PROPERTY_GROUPED_AUTH_MUTABILITY = "grouped_auth_mutability";
  private List<GroupedAuthEntry> groupedAuthMutability = new ArrayList<>();

  public static final String JSON_PROPERTY_DEFAULT_AUTH_MUTABILITY = "default_auth_mutability";
  private AccessRule defaultAuthMutability;

  public AccessRules() { 
  }

  public AccessRules methodAuth(List<MethodAuthEntry> methodAuth) {
    this.methodAuth = methodAuth;
    return this;
  }

  public AccessRules addMethodAuthItem(MethodAuthEntry methodAuthItem) {
    this.methodAuth.add(methodAuthItem);
    return this;
  }

   /**
   * Get methodAuth
   * @return methodAuth
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_METHOD_AUTH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<MethodAuthEntry> getMethodAuth() {
    return methodAuth;
  }


  @JsonProperty(JSON_PROPERTY_METHOD_AUTH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMethodAuth(List<MethodAuthEntry> methodAuth) {
    this.methodAuth = methodAuth;
  }


  public AccessRules groupedAuth(List<GroupedAuthEntry> groupedAuth) {
    this.groupedAuth = groupedAuth;
    return this;
  }

  public AccessRules addGroupedAuthItem(GroupedAuthEntry groupedAuthItem) {
    this.groupedAuth.add(groupedAuthItem);
    return this;
  }

   /**
   * Get groupedAuth
   * @return groupedAuth
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_GROUPED_AUTH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<GroupedAuthEntry> getGroupedAuth() {
    return groupedAuth;
  }


  @JsonProperty(JSON_PROPERTY_GROUPED_AUTH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGroupedAuth(List<GroupedAuthEntry> groupedAuth) {
    this.groupedAuth = groupedAuth;
  }


  public AccessRules defaultAuth(AccessRule defaultAuth) {
    this.defaultAuth = defaultAuth;
    return this;
  }

   /**
   * Get defaultAuth
   * @return defaultAuth
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_DEFAULT_AUTH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public AccessRule getDefaultAuth() {
    return defaultAuth;
  }


  @JsonProperty(JSON_PROPERTY_DEFAULT_AUTH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDefaultAuth(AccessRule defaultAuth) {
    this.defaultAuth = defaultAuth;
  }


  public AccessRules methodAuthMutability(List<MethodAuthMutabilityEntry> methodAuthMutability) {
    this.methodAuthMutability = methodAuthMutability;
    return this;
  }

  public AccessRules addMethodAuthMutabilityItem(MethodAuthMutabilityEntry methodAuthMutabilityItem) {
    this.methodAuthMutability.add(methodAuthMutabilityItem);
    return this;
  }

   /**
   * Get methodAuthMutability
   * @return methodAuthMutability
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_METHOD_AUTH_MUTABILITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<MethodAuthMutabilityEntry> getMethodAuthMutability() {
    return methodAuthMutability;
  }


  @JsonProperty(JSON_PROPERTY_METHOD_AUTH_MUTABILITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMethodAuthMutability(List<MethodAuthMutabilityEntry> methodAuthMutability) {
    this.methodAuthMutability = methodAuthMutability;
  }


  public AccessRules groupedAuthMutability(List<GroupedAuthEntry> groupedAuthMutability) {
    this.groupedAuthMutability = groupedAuthMutability;
    return this;
  }

  public AccessRules addGroupedAuthMutabilityItem(GroupedAuthEntry groupedAuthMutabilityItem) {
    this.groupedAuthMutability.add(groupedAuthMutabilityItem);
    return this;
  }

   /**
   * Get groupedAuthMutability
   * @return groupedAuthMutability
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_GROUPED_AUTH_MUTABILITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<GroupedAuthEntry> getGroupedAuthMutability() {
    return groupedAuthMutability;
  }


  @JsonProperty(JSON_PROPERTY_GROUPED_AUTH_MUTABILITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGroupedAuthMutability(List<GroupedAuthEntry> groupedAuthMutability) {
    this.groupedAuthMutability = groupedAuthMutability;
  }


  public AccessRules defaultAuthMutability(AccessRule defaultAuthMutability) {
    this.defaultAuthMutability = defaultAuthMutability;
    return this;
  }

   /**
   * Get defaultAuthMutability
   * @return defaultAuthMutability
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_DEFAULT_AUTH_MUTABILITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public AccessRule getDefaultAuthMutability() {
    return defaultAuthMutability;
  }


  @JsonProperty(JSON_PROPERTY_DEFAULT_AUTH_MUTABILITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDefaultAuthMutability(AccessRule defaultAuthMutability) {
    this.defaultAuthMutability = defaultAuthMutability;
  }


  /**
   * Return true if this AccessRules object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccessRules accessRules = (AccessRules) o;
    return Objects.equals(this.methodAuth, accessRules.methodAuth) &&
        Objects.equals(this.groupedAuth, accessRules.groupedAuth) &&
        Objects.equals(this.defaultAuth, accessRules.defaultAuth) &&
        Objects.equals(this.methodAuthMutability, accessRules.methodAuthMutability) &&
        Objects.equals(this.groupedAuthMutability, accessRules.groupedAuthMutability) &&
        Objects.equals(this.defaultAuthMutability, accessRules.defaultAuthMutability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(methodAuth, groupedAuth, defaultAuth, methodAuthMutability, groupedAuthMutability, defaultAuthMutability);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccessRules {\n");
    sb.append("    methodAuth: ").append(toIndentedString(methodAuth)).append("\n");
    sb.append("    groupedAuth: ").append(toIndentedString(groupedAuth)).append("\n");
    sb.append("    defaultAuth: ").append(toIndentedString(defaultAuth)).append("\n");
    sb.append("    methodAuthMutability: ").append(toIndentedString(methodAuthMutability)).append("\n");
    sb.append("    groupedAuthMutability: ").append(toIndentedString(groupedAuthMutability)).append("\n");
    sb.append("    defaultAuthMutability: ").append(toIndentedString(defaultAuthMutability)).append("\n");
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


/*
 * Engine State API
 * This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v0.0.1
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
import com.radixdlt.api.engine_state.generated.models.RoyaltyAmount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ObjectMethodRoyalty
 */
@JsonPropertyOrder({
  ObjectMethodRoyalty.JSON_PROPERTY_NAME,
  ObjectMethodRoyalty.JSON_PROPERTY_COMPONENT_ROYALTY_AMOUNT,
  ObjectMethodRoyalty.JSON_PROPERTY_PACKAGE_ROYALTY_AMOUNT
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ObjectMethodRoyalty {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_COMPONENT_ROYALTY_AMOUNT = "component_royalty_amount";
  private RoyaltyAmount componentRoyaltyAmount;

  public static final String JSON_PROPERTY_PACKAGE_ROYALTY_AMOUNT = "package_royalty_amount";
  private RoyaltyAmount packageRoyaltyAmount;

  public ObjectMethodRoyalty() { 
  }

  public ObjectMethodRoyalty name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Method name.
   * @return name
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Method name.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
  }


  public ObjectMethodRoyalty componentRoyaltyAmount(RoyaltyAmount componentRoyaltyAmount) {
    this.componentRoyaltyAmount = componentRoyaltyAmount;
    return this;
  }

   /**
   * Get componentRoyaltyAmount
   * @return componentRoyaltyAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_COMPONENT_ROYALTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RoyaltyAmount getComponentRoyaltyAmount() {
    return componentRoyaltyAmount;
  }


  @JsonProperty(JSON_PROPERTY_COMPONENT_ROYALTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setComponentRoyaltyAmount(RoyaltyAmount componentRoyaltyAmount) {
    this.componentRoyaltyAmount = componentRoyaltyAmount;
  }


  public ObjectMethodRoyalty packageRoyaltyAmount(RoyaltyAmount packageRoyaltyAmount) {
    this.packageRoyaltyAmount = packageRoyaltyAmount;
    return this;
  }

   /**
   * Get packageRoyaltyAmount
   * @return packageRoyaltyAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PACKAGE_ROYALTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RoyaltyAmount getPackageRoyaltyAmount() {
    return packageRoyaltyAmount;
  }


  @JsonProperty(JSON_PROPERTY_PACKAGE_ROYALTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPackageRoyaltyAmount(RoyaltyAmount packageRoyaltyAmount) {
    this.packageRoyaltyAmount = packageRoyaltyAmount;
  }


  /**
   * Return true if this ObjectMethodRoyalty object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectMethodRoyalty objectMethodRoyalty = (ObjectMethodRoyalty) o;
    return Objects.equals(this.name, objectMethodRoyalty.name) &&
        Objects.equals(this.componentRoyaltyAmount, objectMethodRoyalty.componentRoyaltyAmount) &&
        Objects.equals(this.packageRoyaltyAmount, objectMethodRoyalty.packageRoyaltyAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, componentRoyaltyAmount, packageRoyaltyAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectMethodRoyalty {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    componentRoyaltyAmount: ").append(toIndentedString(componentRoyaltyAmount)).append("\n");
    sb.append("    packageRoyaltyAmount: ").append(toIndentedString(packageRoyaltyAmount)).append("\n");
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


/*
 * Engine State API (Beta)
 * **This API is currently in Beta**  This specification may experience breaking changes as part of Babylon Node releases. Such changes will be clearly mentioned in the [babylon-node release notes](https://github.com/radixdlt/babylon-node/releases). We advise against using this API for business-critical integrations before the `version` indicated above becomes stable, which is expected in Q4 of 2024.  This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v1.2.4
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
import com.radixdlt.api.engine_state.generated.models.BlueprintFunctionAuthorization;
import com.radixdlt.api.engine_state.generated.models.BlueprintResolvedTypeReference;
import com.radixdlt.api.engine_state.generated.models.RoyaltyAmount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * BlueprintFunctionInfo
 */
@JsonPropertyOrder({
  BlueprintFunctionInfo.JSON_PROPERTY_NAME,
  BlueprintFunctionInfo.JSON_PROPERTY_INPUT_TYPE_REFERENCE,
  BlueprintFunctionInfo.JSON_PROPERTY_OUTPUT_TYPE_REFERENCE,
  BlueprintFunctionInfo.JSON_PROPERTY_AUTHORIZATION,
  BlueprintFunctionInfo.JSON_PROPERTY_ROYALTY_AMOUNT
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class BlueprintFunctionInfo {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_INPUT_TYPE_REFERENCE = "input_type_reference";
  private BlueprintResolvedTypeReference inputTypeReference;

  public static final String JSON_PROPERTY_OUTPUT_TYPE_REFERENCE = "output_type_reference";
  private BlueprintResolvedTypeReference outputTypeReference;

  public static final String JSON_PROPERTY_AUTHORIZATION = "authorization";
  private BlueprintFunctionAuthorization authorization;

  public static final String JSON_PROPERTY_ROYALTY_AMOUNT = "royalty_amount";
  private RoyaltyAmount royaltyAmount;

  public BlueprintFunctionInfo() { 
  }

  public BlueprintFunctionInfo name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
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


  public BlueprintFunctionInfo inputTypeReference(BlueprintResolvedTypeReference inputTypeReference) {
    this.inputTypeReference = inputTypeReference;
    return this;
  }

   /**
   * Get inputTypeReference
   * @return inputTypeReference
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_INPUT_TYPE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BlueprintResolvedTypeReference getInputTypeReference() {
    return inputTypeReference;
  }


  @JsonProperty(JSON_PROPERTY_INPUT_TYPE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setInputTypeReference(BlueprintResolvedTypeReference inputTypeReference) {
    this.inputTypeReference = inputTypeReference;
  }


  public BlueprintFunctionInfo outputTypeReference(BlueprintResolvedTypeReference outputTypeReference) {
    this.outputTypeReference = outputTypeReference;
    return this;
  }

   /**
   * Get outputTypeReference
   * @return outputTypeReference
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_OUTPUT_TYPE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BlueprintResolvedTypeReference getOutputTypeReference() {
    return outputTypeReference;
  }


  @JsonProperty(JSON_PROPERTY_OUTPUT_TYPE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOutputTypeReference(BlueprintResolvedTypeReference outputTypeReference) {
    this.outputTypeReference = outputTypeReference;
  }


  public BlueprintFunctionInfo authorization(BlueprintFunctionAuthorization authorization) {
    this.authorization = authorization;
    return this;
  }

   /**
   * Get authorization
   * @return authorization
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_AUTHORIZATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public BlueprintFunctionAuthorization getAuthorization() {
    return authorization;
  }


  @JsonProperty(JSON_PROPERTY_AUTHORIZATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAuthorization(BlueprintFunctionAuthorization authorization) {
    this.authorization = authorization;
  }


  public BlueprintFunctionInfo royaltyAmount(RoyaltyAmount royaltyAmount) {
    this.royaltyAmount = royaltyAmount;
    return this;
  }

   /**
   * Get royaltyAmount
   * @return royaltyAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ROYALTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RoyaltyAmount getRoyaltyAmount() {
    return royaltyAmount;
  }


  @JsonProperty(JSON_PROPERTY_ROYALTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoyaltyAmount(RoyaltyAmount royaltyAmount) {
    this.royaltyAmount = royaltyAmount;
  }


  /**
   * Return true if this BlueprintFunctionInfo object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlueprintFunctionInfo blueprintFunctionInfo = (BlueprintFunctionInfo) o;
    return Objects.equals(this.name, blueprintFunctionInfo.name) &&
        Objects.equals(this.inputTypeReference, blueprintFunctionInfo.inputTypeReference) &&
        Objects.equals(this.outputTypeReference, blueprintFunctionInfo.outputTypeReference) &&
        Objects.equals(this.authorization, blueprintFunctionInfo.authorization) &&
        Objects.equals(this.royaltyAmount, blueprintFunctionInfo.royaltyAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, inputTypeReference, outputTypeReference, authorization, royaltyAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlueprintFunctionInfo {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    inputTypeReference: ").append(toIndentedString(inputTypeReference)).append("\n");
    sb.append("    outputTypeReference: ").append(toIndentedString(outputTypeReference)).append("\n");
    sb.append("    authorization: ").append(toIndentedString(authorization)).append("\n");
    sb.append("    royaltyAmount: ").append(toIndentedString(royaltyAmount)).append("\n");
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


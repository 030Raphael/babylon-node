/*
 * Radix Gateway API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.9.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.gateway.openapitools.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.radixdlt.api.gateway.openapitools.JSON;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * TransactionFinalizeResponseError
 */
@JsonPropertyOrder({
  TransactionFinalizeResponseError.JSON_PROPERTY_DETAILS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-12-01T19:04:44.841200-06:00[America/Chicago]")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = TransactionFinalizeResponseError.class, name = "TransactionFinalizeResponseError"),
  @JsonSubTypes.Type(value = TransactionFinalizeResponseSuccess.class, name = "TransactionFinalizeResponseSuccess"),
})

public class TransactionFinalizeResponseError extends TransactionFinalizeResponse {
  public static final String JSON_PROPERTY_DETAILS = "details";
  private ErrorDetails details;


  public TransactionFinalizeResponseError details(ErrorDetails details) {
    this.details = details;
    return this;
  }

   /**
   * Get details
   * @return details
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ErrorDetails getDetails() {
    return details;
  }


  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDetails(ErrorDetails details) {
    this.details = details;
  }


  /**
   * Return true if this TransactionFinalizeResponseError object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionFinalizeResponseError transactionFinalizeResponseError = (TransactionFinalizeResponseError) o;
    return Objects.equals(this.details, transactionFinalizeResponseError.details) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(details, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionFinalizeResponseError {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
  mappings.put("TransactionFinalizeResponseError", TransactionFinalizeResponseError.class);
  mappings.put("TransactionFinalizeResponseSuccess", TransactionFinalizeResponseSuccess.class);
  mappings.put("TransactionFinalizeResponseError", TransactionFinalizeResponseError.class);
  JSON.registerDiscriminator(TransactionFinalizeResponseError.class, "type", mappings);
}
}


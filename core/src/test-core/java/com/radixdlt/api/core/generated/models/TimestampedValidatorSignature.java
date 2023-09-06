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
import com.radixdlt.api.core.generated.models.EcdsaSecp256k1PublicKey;
import com.radixdlt.api.core.generated.models.EcdsaSecp256k1Signature;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * TimestampedValidatorSignature
 */
@JsonPropertyOrder({
  TimestampedValidatorSignature.JSON_PROPERTY_KEY,
  TimestampedValidatorSignature.JSON_PROPERTY_VALIDATOR_ADDRESS,
  TimestampedValidatorSignature.JSON_PROPERTY_TIMESTAMP_MS,
  TimestampedValidatorSignature.JSON_PROPERTY_SIGNATURE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TimestampedValidatorSignature {
  public static final String JSON_PROPERTY_KEY = "key";
  private EcdsaSecp256k1PublicKey key;

  public static final String JSON_PROPERTY_VALIDATOR_ADDRESS = "validator_address";
  private String validatorAddress;

  public static final String JSON_PROPERTY_TIMESTAMP_MS = "timestamp_ms";
  private Long timestampMs;

  public static final String JSON_PROPERTY_SIGNATURE = "signature";
  private EcdsaSecp256k1Signature signature;

  public TimestampedValidatorSignature() { 
  }

  public TimestampedValidatorSignature key(EcdsaSecp256k1PublicKey key) {
    this.key = key;
    return this;
  }

   /**
   * Get key
   * @return key
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EcdsaSecp256k1PublicKey getKey() {
    return key;
  }


  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKey(EcdsaSecp256k1PublicKey key) {
    this.key = key;
  }


  public TimestampedValidatorSignature validatorAddress(String validatorAddress) {
    this.validatorAddress = validatorAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the component address
   * @return validatorAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the component address")
  @JsonProperty(JSON_PROPERTY_VALIDATOR_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getValidatorAddress() {
    return validatorAddress;
  }


  @JsonProperty(JSON_PROPERTY_VALIDATOR_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValidatorAddress(String validatorAddress) {
    this.validatorAddress = validatorAddress;
  }


  public TimestampedValidatorSignature timestampMs(Long timestampMs) {
    this.timestampMs = timestampMs;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^14&#x60;, marking the unix timestamp in ms.
   * minimum: 0
   * maximum: 100000000000000
   * @return timestampMs
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^14`, marking the unix timestamp in ms.")
  @JsonProperty(JSON_PROPERTY_TIMESTAMP_MS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getTimestampMs() {
    return timestampMs;
  }


  @JsonProperty(JSON_PROPERTY_TIMESTAMP_MS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTimestampMs(Long timestampMs) {
    this.timestampMs = timestampMs;
  }


  public TimestampedValidatorSignature signature(EcdsaSecp256k1Signature signature) {
    this.signature = signature;
    return this;
  }

   /**
   * Get signature
   * @return signature
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SIGNATURE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EcdsaSecp256k1Signature getSignature() {
    return signature;
  }


  @JsonProperty(JSON_PROPERTY_SIGNATURE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSignature(EcdsaSecp256k1Signature signature) {
    this.signature = signature;
  }


  /**
   * Return true if this TimestampedValidatorSignature object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimestampedValidatorSignature timestampedValidatorSignature = (TimestampedValidatorSignature) o;
    return Objects.equals(this.key, timestampedValidatorSignature.key) &&
        Objects.equals(this.validatorAddress, timestampedValidatorSignature.validatorAddress) &&
        Objects.equals(this.timestampMs, timestampedValidatorSignature.timestampMs) &&
        Objects.equals(this.signature, timestampedValidatorSignature.signature);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, validatorAddress, timestampMs, signature);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimestampedValidatorSignature {\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    validatorAddress: ").append(toIndentedString(validatorAddress)).append("\n");
    sb.append("    timestampMs: ").append(toIndentedString(timestampMs)).append("\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
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


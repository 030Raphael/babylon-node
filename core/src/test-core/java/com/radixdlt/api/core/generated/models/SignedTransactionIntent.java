/*
 * Radix Core API - Babylon (Anemone)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.1.3
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
import com.radixdlt.api.core.generated.models.SignatureWithPublicKey;
import com.radixdlt.api.core.generated.models.TransactionIntent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * SignedTransactionIntent
 */
@JsonPropertyOrder({
  SignedTransactionIntent.JSON_PROPERTY_HASH,
  SignedTransactionIntent.JSON_PROPERTY_HASH_BECH32M,
  SignedTransactionIntent.JSON_PROPERTY_INTENT,
  SignedTransactionIntent.JSON_PROPERTY_INTENT_SIGNATURES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SignedTransactionIntent {
  public static final String JSON_PROPERTY_HASH = "hash";
  private String hash;

  public static final String JSON_PROPERTY_HASH_BECH32M = "hash_bech32m";
  private String hashBech32m;

  public static final String JSON_PROPERTY_INTENT = "intent";
  private TransactionIntent intent;

  public static final String JSON_PROPERTY_INTENT_SIGNATURES = "intent_signatures";
  private List<SignatureWithPublicKey> intentSignatures = new ArrayList<>();

  public SignedTransactionIntent() { 
  }

  public SignedTransactionIntent hash(String hash) {
    this.hash = hash;
    return this;
  }

   /**
   * The hex-encoded signed intent hash for a user transaction. This hash identifies the transaction intent, plus additional signatures. This hash is signed by the notary, to create the submittable NotarizedTransaction. 
   * @return hash
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded signed intent hash for a user transaction. This hash identifies the transaction intent, plus additional signatures. This hash is signed by the notary, to create the submittable NotarizedTransaction. ")
  @JsonProperty(JSON_PROPERTY_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getHash() {
    return hash;
  }


  @JsonProperty(JSON_PROPERTY_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setHash(String hash) {
    this.hash = hash;
  }


  public SignedTransactionIntent hashBech32m(String hashBech32m) {
    this.hashBech32m = hashBech32m;
    return this;
  }

   /**
   * The Bech32m-encoded human readable &#x60;SignedIntentHash&#x60;.
   * @return hashBech32m
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable `SignedIntentHash`.")
  @JsonProperty(JSON_PROPERTY_HASH_BECH32M)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getHashBech32m() {
    return hashBech32m;
  }


  @JsonProperty(JSON_PROPERTY_HASH_BECH32M)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setHashBech32m(String hashBech32m) {
    this.hashBech32m = hashBech32m;
  }


  public SignedTransactionIntent intent(TransactionIntent intent) {
    this.intent = intent;
    return this;
  }

   /**
   * Get intent
   * @return intent
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_INTENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TransactionIntent getIntent() {
    return intent;
  }


  @JsonProperty(JSON_PROPERTY_INTENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIntent(TransactionIntent intent) {
    this.intent = intent;
  }


  public SignedTransactionIntent intentSignatures(List<SignatureWithPublicKey> intentSignatures) {
    this.intentSignatures = intentSignatures;
    return this;
  }

  public SignedTransactionIntent addIntentSignaturesItem(SignatureWithPublicKey intentSignaturesItem) {
    this.intentSignatures.add(intentSignaturesItem);
    return this;
  }

   /**
   * Get intentSignatures
   * @return intentSignatures
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_INTENT_SIGNATURES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<SignatureWithPublicKey> getIntentSignatures() {
    return intentSignatures;
  }


  @JsonProperty(JSON_PROPERTY_INTENT_SIGNATURES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIntentSignatures(List<SignatureWithPublicKey> intentSignatures) {
    this.intentSignatures = intentSignatures;
  }


  /**
   * Return true if this SignedTransactionIntent object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignedTransactionIntent signedTransactionIntent = (SignedTransactionIntent) o;
    return Objects.equals(this.hash, signedTransactionIntent.hash) &&
        Objects.equals(this.hashBech32m, signedTransactionIntent.hashBech32m) &&
        Objects.equals(this.intent, signedTransactionIntent.intent) &&
        Objects.equals(this.intentSignatures, signedTransactionIntent.intentSignatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hash, hashBech32m, intent, intentSignatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignedTransactionIntent {\n");
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
    sb.append("    hashBech32m: ").append(toIndentedString(hashBech32m)).append("\n");
    sb.append("    intent: ").append(toIndentedString(intent)).append("\n");
    sb.append("    intentSignatures: ").append(toIndentedString(intentSignatures)).append("\n");
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


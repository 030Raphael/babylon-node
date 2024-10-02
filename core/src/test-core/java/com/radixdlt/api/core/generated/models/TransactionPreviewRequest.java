/*
 * Radix Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.3
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
import com.radixdlt.api.core.generated.models.LedgerStateSelector;
import com.radixdlt.api.core.generated.models.PublicKey;
import com.radixdlt.api.core.generated.models.TransactionMessage;
import com.radixdlt.api.core.generated.models.TransactionPreviewRequestFlags;
import com.radixdlt.api.core.generated.models.TransactionPreviewResponseOptions;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * TransactionPreviewRequest
 */
@JsonPropertyOrder({
  TransactionPreviewRequest.JSON_PROPERTY_NETWORK,
  TransactionPreviewRequest.JSON_PROPERTY_AT_LEDGER_STATE,
  TransactionPreviewRequest.JSON_PROPERTY_MANIFEST,
  TransactionPreviewRequest.JSON_PROPERTY_BLOBS_HEX,
  TransactionPreviewRequest.JSON_PROPERTY_START_EPOCH_INCLUSIVE,
  TransactionPreviewRequest.JSON_PROPERTY_END_EPOCH_EXCLUSIVE,
  TransactionPreviewRequest.JSON_PROPERTY_NOTARY_PUBLIC_KEY,
  TransactionPreviewRequest.JSON_PROPERTY_NOTARY_IS_SIGNATORY,
  TransactionPreviewRequest.JSON_PROPERTY_TIP_PERCENTAGE,
  TransactionPreviewRequest.JSON_PROPERTY_NONCE,
  TransactionPreviewRequest.JSON_PROPERTY_SIGNER_PUBLIC_KEYS,
  TransactionPreviewRequest.JSON_PROPERTY_MESSAGE,
  TransactionPreviewRequest.JSON_PROPERTY_OPTIONS,
  TransactionPreviewRequest.JSON_PROPERTY_FLAGS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TransactionPreviewRequest {
  public static final String JSON_PROPERTY_NETWORK = "network";
  private String network;

  public static final String JSON_PROPERTY_AT_LEDGER_STATE = "at_ledger_state";
  private LedgerStateSelector atLedgerState;

  public static final String JSON_PROPERTY_MANIFEST = "manifest";
  private String manifest;

  public static final String JSON_PROPERTY_BLOBS_HEX = "blobs_hex";
  private List<String> blobsHex = null;

  public static final String JSON_PROPERTY_START_EPOCH_INCLUSIVE = "start_epoch_inclusive";
  private Long startEpochInclusive;

  public static final String JSON_PROPERTY_END_EPOCH_EXCLUSIVE = "end_epoch_exclusive";
  private Long endEpochExclusive;

  public static final String JSON_PROPERTY_NOTARY_PUBLIC_KEY = "notary_public_key";
  private PublicKey notaryPublicKey;

  public static final String JSON_PROPERTY_NOTARY_IS_SIGNATORY = "notary_is_signatory";
  private Boolean notaryIsSignatory;

  public static final String JSON_PROPERTY_TIP_PERCENTAGE = "tip_percentage";
  private Integer tipPercentage;

  public static final String JSON_PROPERTY_NONCE = "nonce";
  private Long nonce;

  public static final String JSON_PROPERTY_SIGNER_PUBLIC_KEYS = "signer_public_keys";
  private List<PublicKey> signerPublicKeys = new ArrayList<>();

  public static final String JSON_PROPERTY_MESSAGE = "message";
  private TransactionMessage message;

  public static final String JSON_PROPERTY_OPTIONS = "options";
  private TransactionPreviewResponseOptions options;

  public static final String JSON_PROPERTY_FLAGS = "flags";
  private TransactionPreviewRequestFlags flags;

  public TransactionPreviewRequest() { 
  }

  public TransactionPreviewRequest network(String network) {
    this.network = network;
    return this;
  }

   /**
   * The logical name of the network
   * @return network
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "{{network}}", required = true, value = "The logical name of the network")
  @JsonProperty(JSON_PROPERTY_NETWORK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNetwork() {
    return network;
  }


  @JsonProperty(JSON_PROPERTY_NETWORK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNetwork(String network) {
    this.network = network;
  }


  public TransactionPreviewRequest atLedgerState(LedgerStateSelector atLedgerState) {
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


  public TransactionPreviewRequest manifest(String manifest) {
    this.manifest = manifest;
    return this;
  }

   /**
   * A text representation of a transaction manifest.
   * @return manifest
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A text representation of a transaction manifest.")
  @JsonProperty(JSON_PROPERTY_MANIFEST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getManifest() {
    return manifest;
  }


  @JsonProperty(JSON_PROPERTY_MANIFEST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setManifest(String manifest) {
    this.manifest = manifest;
  }


  public TransactionPreviewRequest blobsHex(List<String> blobsHex) {
    this.blobsHex = blobsHex;
    return this;
  }

  public TransactionPreviewRequest addBlobsHexItem(String blobsHexItem) {
    if (this.blobsHex == null) {
      this.blobsHex = new ArrayList<>();
    }
    this.blobsHex.add(blobsHexItem);
    return this;
  }

   /**
   * An array of hex-encoded blob data, if referenced by the manifest.
   * @return blobsHex
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An array of hex-encoded blob data, if referenced by the manifest.")
  @JsonProperty(JSON_PROPERTY_BLOBS_HEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getBlobsHex() {
    return blobsHex;
  }


  @JsonProperty(JSON_PROPERTY_BLOBS_HEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBlobsHex(List<String> blobsHex) {
    this.blobsHex = blobsHex;
  }


  public TransactionPreviewRequest startEpochInclusive(Long startEpochInclusive) {
    this.startEpochInclusive = startEpochInclusive;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, marking the epoch at which the transaction starts being valid. If omitted, the current epoch will be used (taking into account the &#x60;at_ledger_state&#x60;, if specified). 
   * minimum: 0
   * maximum: 10000000000
   * @return startEpochInclusive
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An integer between `0` and `10^10`, marking the epoch at which the transaction starts being valid. If omitted, the current epoch will be used (taking into account the `at_ledger_state`, if specified). ")
  @JsonProperty(JSON_PROPERTY_START_EPOCH_INCLUSIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getStartEpochInclusive() {
    return startEpochInclusive;
  }


  @JsonProperty(JSON_PROPERTY_START_EPOCH_INCLUSIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStartEpochInclusive(Long startEpochInclusive) {
    this.startEpochInclusive = startEpochInclusive;
  }


  public TransactionPreviewRequest endEpochExclusive(Long endEpochExclusive) {
    this.endEpochExclusive = endEpochExclusive;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, marking the epoch at which the transaction is no longer valid. If omitted, a maximum epoch (relative to the &#x60;start_epoch_inclusive&#x60;) will be used. 
   * minimum: 0
   * maximum: 10000000000
   * @return endEpochExclusive
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An integer between `0` and `10^10`, marking the epoch at which the transaction is no longer valid. If omitted, a maximum epoch (relative to the `start_epoch_inclusive`) will be used. ")
  @JsonProperty(JSON_PROPERTY_END_EPOCH_EXCLUSIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getEndEpochExclusive() {
    return endEpochExclusive;
  }


  @JsonProperty(JSON_PROPERTY_END_EPOCH_EXCLUSIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEndEpochExclusive(Long endEpochExclusive) {
    this.endEpochExclusive = endEpochExclusive;
  }


  public TransactionPreviewRequest notaryPublicKey(PublicKey notaryPublicKey) {
    this.notaryPublicKey = notaryPublicKey;
    return this;
  }

   /**
   * Get notaryPublicKey
   * @return notaryPublicKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NOTARY_PUBLIC_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PublicKey getNotaryPublicKey() {
    return notaryPublicKey;
  }


  @JsonProperty(JSON_PROPERTY_NOTARY_PUBLIC_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNotaryPublicKey(PublicKey notaryPublicKey) {
    this.notaryPublicKey = notaryPublicKey;
  }


  public TransactionPreviewRequest notaryIsSignatory(Boolean notaryIsSignatory) {
    this.notaryIsSignatory = notaryIsSignatory;
    return this;
  }

   /**
   * Whether the notary should count as a signatory (defaults to &#x60;false&#x60;).
   * @return notaryIsSignatory
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether the notary should count as a signatory (defaults to `false`).")
  @JsonProperty(JSON_PROPERTY_NOTARY_IS_SIGNATORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getNotaryIsSignatory() {
    return notaryIsSignatory;
  }


  @JsonProperty(JSON_PROPERTY_NOTARY_IS_SIGNATORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNotaryIsSignatory(Boolean notaryIsSignatory) {
    this.notaryIsSignatory = notaryIsSignatory;
  }


  public TransactionPreviewRequest tipPercentage(Integer tipPercentage) {
    this.tipPercentage = tipPercentage;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;65535&#x60;, giving the validator tip as a percentage amount. A value of &#x60;1&#x60; corresponds to a 1% fee. 
   * minimum: 0
   * maximum: 65535
   * @return tipPercentage
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `65535`, giving the validator tip as a percentage amount. A value of `1` corresponds to a 1% fee. ")
  @JsonProperty(JSON_PROPERTY_TIP_PERCENTAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getTipPercentage() {
    return tipPercentage;
  }


  @JsonProperty(JSON_PROPERTY_TIP_PERCENTAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTipPercentage(Integer tipPercentage) {
    this.tipPercentage = tipPercentage;
  }


  public TransactionPreviewRequest nonce(Long nonce) {
    this.nonce = nonce;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;2^32 - 1&#x60;, chosen to allow a unique intent to be created (to enable submitting an otherwise identical/duplicate intent). 
   * minimum: 0
   * maximum: 4294967295
   * @return nonce
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `2^32 - 1`, chosen to allow a unique intent to be created (to enable submitting an otherwise identical/duplicate intent). ")
  @JsonProperty(JSON_PROPERTY_NONCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getNonce() {
    return nonce;
  }


  @JsonProperty(JSON_PROPERTY_NONCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNonce(Long nonce) {
    this.nonce = nonce;
  }


  public TransactionPreviewRequest signerPublicKeys(List<PublicKey> signerPublicKeys) {
    this.signerPublicKeys = signerPublicKeys;
    return this;
  }

  public TransactionPreviewRequest addSignerPublicKeysItem(PublicKey signerPublicKeysItem) {
    this.signerPublicKeys.add(signerPublicKeysItem);
    return this;
  }

   /**
   * A list of public keys to be used as transaction signers
   * @return signerPublicKeys
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A list of public keys to be used as transaction signers")
  @JsonProperty(JSON_PROPERTY_SIGNER_PUBLIC_KEYS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<PublicKey> getSignerPublicKeys() {
    return signerPublicKeys;
  }


  @JsonProperty(JSON_PROPERTY_SIGNER_PUBLIC_KEYS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSignerPublicKeys(List<PublicKey> signerPublicKeys) {
    this.signerPublicKeys = signerPublicKeys;
  }


  public TransactionPreviewRequest message(TransactionMessage message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TransactionMessage getMessage() {
    return message;
  }


  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMessage(TransactionMessage message) {
    this.message = message;
  }


  public TransactionPreviewRequest options(TransactionPreviewResponseOptions options) {
    this.options = options;
    return this;
  }

   /**
   * Get options
   * @return options
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TransactionPreviewResponseOptions getOptions() {
    return options;
  }


  @JsonProperty(JSON_PROPERTY_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOptions(TransactionPreviewResponseOptions options) {
    this.options = options;
  }


  public TransactionPreviewRequest flags(TransactionPreviewRequestFlags flags) {
    this.flags = flags;
    return this;
  }

   /**
   * Get flags
   * @return flags
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_FLAGS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TransactionPreviewRequestFlags getFlags() {
    return flags;
  }


  @JsonProperty(JSON_PROPERTY_FLAGS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFlags(TransactionPreviewRequestFlags flags) {
    this.flags = flags;
  }


  /**
   * Return true if this TransactionPreviewRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionPreviewRequest transactionPreviewRequest = (TransactionPreviewRequest) o;
    return Objects.equals(this.network, transactionPreviewRequest.network) &&
        Objects.equals(this.atLedgerState, transactionPreviewRequest.atLedgerState) &&
        Objects.equals(this.manifest, transactionPreviewRequest.manifest) &&
        Objects.equals(this.blobsHex, transactionPreviewRequest.blobsHex) &&
        Objects.equals(this.startEpochInclusive, transactionPreviewRequest.startEpochInclusive) &&
        Objects.equals(this.endEpochExclusive, transactionPreviewRequest.endEpochExclusive) &&
        Objects.equals(this.notaryPublicKey, transactionPreviewRequest.notaryPublicKey) &&
        Objects.equals(this.notaryIsSignatory, transactionPreviewRequest.notaryIsSignatory) &&
        Objects.equals(this.tipPercentage, transactionPreviewRequest.tipPercentage) &&
        Objects.equals(this.nonce, transactionPreviewRequest.nonce) &&
        Objects.equals(this.signerPublicKeys, transactionPreviewRequest.signerPublicKeys) &&
        Objects.equals(this.message, transactionPreviewRequest.message) &&
        Objects.equals(this.options, transactionPreviewRequest.options) &&
        Objects.equals(this.flags, transactionPreviewRequest.flags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(network, atLedgerState, manifest, blobsHex, startEpochInclusive, endEpochExclusive, notaryPublicKey, notaryIsSignatory, tipPercentage, nonce, signerPublicKeys, message, options, flags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionPreviewRequest {\n");
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
    sb.append("    atLedgerState: ").append(toIndentedString(atLedgerState)).append("\n");
    sb.append("    manifest: ").append(toIndentedString(manifest)).append("\n");
    sb.append("    blobsHex: ").append(toIndentedString(blobsHex)).append("\n");
    sb.append("    startEpochInclusive: ").append(toIndentedString(startEpochInclusive)).append("\n");
    sb.append("    endEpochExclusive: ").append(toIndentedString(endEpochExclusive)).append("\n");
    sb.append("    notaryPublicKey: ").append(toIndentedString(notaryPublicKey)).append("\n");
    sb.append("    notaryIsSignatory: ").append(toIndentedString(notaryIsSignatory)).append("\n");
    sb.append("    tipPercentage: ").append(toIndentedString(tipPercentage)).append("\n");
    sb.append("    nonce: ").append(toIndentedString(nonce)).append("\n");
    sb.append("    signerPublicKeys: ").append(toIndentedString(signerPublicKeys)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
    sb.append("    flags: ").append(toIndentedString(flags)).append("\n");
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


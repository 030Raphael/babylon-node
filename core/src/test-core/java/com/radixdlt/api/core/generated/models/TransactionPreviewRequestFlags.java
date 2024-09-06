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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * TransactionPreviewRequestFlags
 */
@JsonPropertyOrder({
  TransactionPreviewRequestFlags.JSON_PROPERTY_USE_FREE_CREDIT,
  TransactionPreviewRequestFlags.JSON_PROPERTY_ASSUME_ALL_SIGNATURE_PROOFS,
  TransactionPreviewRequestFlags.JSON_PROPERTY_SKIP_EPOCH_CHECK,
  TransactionPreviewRequestFlags.JSON_PROPERTY_DISABLE_AUTH_CHECKS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TransactionPreviewRequestFlags {
  public static final String JSON_PROPERTY_USE_FREE_CREDIT = "use_free_credit";
  private Boolean useFreeCredit;

  public static final String JSON_PROPERTY_ASSUME_ALL_SIGNATURE_PROOFS = "assume_all_signature_proofs";
  private Boolean assumeAllSignatureProofs;

  public static final String JSON_PROPERTY_SKIP_EPOCH_CHECK = "skip_epoch_check";
  private Boolean skipEpochCheck;

  public static final String JSON_PROPERTY_DISABLE_AUTH_CHECKS = "disable_auth_checks";
  private Boolean disableAuthChecks;

  public TransactionPreviewRequestFlags() { 
  }

  public TransactionPreviewRequestFlags useFreeCredit(Boolean useFreeCredit) {
    this.useFreeCredit = useFreeCredit;
    return this;
  }

   /**
   * Get useFreeCredit
   * @return useFreeCredit
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_USE_FREE_CREDIT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getUseFreeCredit() {
    return useFreeCredit;
  }


  @JsonProperty(JSON_PROPERTY_USE_FREE_CREDIT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUseFreeCredit(Boolean useFreeCredit) {
    this.useFreeCredit = useFreeCredit;
  }


  public TransactionPreviewRequestFlags assumeAllSignatureProofs(Boolean assumeAllSignatureProofs) {
    this.assumeAllSignatureProofs = assumeAllSignatureProofs;
    return this;
  }

   /**
   * Get assumeAllSignatureProofs
   * @return assumeAllSignatureProofs
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ASSUME_ALL_SIGNATURE_PROOFS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getAssumeAllSignatureProofs() {
    return assumeAllSignatureProofs;
  }


  @JsonProperty(JSON_PROPERTY_ASSUME_ALL_SIGNATURE_PROOFS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAssumeAllSignatureProofs(Boolean assumeAllSignatureProofs) {
    this.assumeAllSignatureProofs = assumeAllSignatureProofs;
  }


  public TransactionPreviewRequestFlags skipEpochCheck(Boolean skipEpochCheck) {
    this.skipEpochCheck = skipEpochCheck;
    return this;
  }

   /**
   * Get skipEpochCheck
   * @return skipEpochCheck
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SKIP_EPOCH_CHECK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getSkipEpochCheck() {
    return skipEpochCheck;
  }


  @JsonProperty(JSON_PROPERTY_SKIP_EPOCH_CHECK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSkipEpochCheck(Boolean skipEpochCheck) {
    this.skipEpochCheck = skipEpochCheck;
  }


  public TransactionPreviewRequestFlags disableAuthChecks(Boolean disableAuthChecks) {
    this.disableAuthChecks = disableAuthChecks;
    return this;
  }

   /**
   * Can be used to skip performing auth checks during runtime.  This could be used to e.g.: * Preview protocol update style transactions * Mint resources for previewing trades with resources you don&#39;t own. If doing this, be warned:   * Only resources which were potentially mintable/burnable at creation time   will be mintable/burnable, due to feature flags on the resource.   * Please see the below warning about unexpected results if using this approach.  Please be warned - this mode of operation is quite a departure from normal operation: * Calculated fees will likely be lower than a standard execution * This mode can subtly break invariants some dApp code might rely on, or result in unexpected behaviour, so the resulting execution result might not be valid for your needs. For example, if I used this flag to mint pool units to preview a redemption (or some dApp interaction which behind the scenes redeemed them), they&#39;d redeem for less than they&#39;re currently worth, because the blueprint code relies on the total supply of the pool units to calculate their redemption worth, and you&#39;ve just inflated the total supply through the mint operation. 
   * @return disableAuthChecks
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Can be used to skip performing auth checks during runtime.  This could be used to e.g.: * Preview protocol update style transactions * Mint resources for previewing trades with resources you don't own. If doing this, be warned:   * Only resources which were potentially mintable/burnable at creation time   will be mintable/burnable, due to feature flags on the resource.   * Please see the below warning about unexpected results if using this approach.  Please be warned - this mode of operation is quite a departure from normal operation: * Calculated fees will likely be lower than a standard execution * This mode can subtly break invariants some dApp code might rely on, or result in unexpected behaviour, so the resulting execution result might not be valid for your needs. For example, if I used this flag to mint pool units to preview a redemption (or some dApp interaction which behind the scenes redeemed them), they'd redeem for less than they're currently worth, because the blueprint code relies on the total supply of the pool units to calculate their redemption worth, and you've just inflated the total supply through the mint operation. ")
  @JsonProperty(JSON_PROPERTY_DISABLE_AUTH_CHECKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getDisableAuthChecks() {
    return disableAuthChecks;
  }


  @JsonProperty(JSON_PROPERTY_DISABLE_AUTH_CHECKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisableAuthChecks(Boolean disableAuthChecks) {
    this.disableAuthChecks = disableAuthChecks;
  }


  /**
   * Return true if this TransactionPreviewRequest_flags object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionPreviewRequestFlags transactionPreviewRequestFlags = (TransactionPreviewRequestFlags) o;
    return Objects.equals(this.useFreeCredit, transactionPreviewRequestFlags.useFreeCredit) &&
        Objects.equals(this.assumeAllSignatureProofs, transactionPreviewRequestFlags.assumeAllSignatureProofs) &&
        Objects.equals(this.skipEpochCheck, transactionPreviewRequestFlags.skipEpochCheck) &&
        Objects.equals(this.disableAuthChecks, transactionPreviewRequestFlags.disableAuthChecks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(useFreeCredit, assumeAllSignatureProofs, skipEpochCheck, disableAuthChecks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionPreviewRequestFlags {\n");
    sb.append("    useFreeCredit: ").append(toIndentedString(useFreeCredit)).append("\n");
    sb.append("    assumeAllSignatureProofs: ").append(toIndentedString(assumeAllSignatureProofs)).append("\n");
    sb.append("    skipEpochCheck: ").append(toIndentedString(skipEpochCheck)).append("\n");
    sb.append("    disableAuthChecks: ").append(toIndentedString(disableAuthChecks)).append("\n");
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


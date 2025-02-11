/*
 * Radix Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.3.0
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
import com.radixdlt.api.core.generated.models.PublicKey;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * TransactionHeaderV2
 */
@JsonPropertyOrder({
  TransactionHeaderV2.JSON_PROPERTY_NOTARY_PUBLIC_KEY,
  TransactionHeaderV2.JSON_PROPERTY_NOTARY_IS_SIGNATORY,
  TransactionHeaderV2.JSON_PROPERTY_TIP_BASIS_POINTS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TransactionHeaderV2 {
  public static final String JSON_PROPERTY_NOTARY_PUBLIC_KEY = "notary_public_key";
  private PublicKey notaryPublicKey;

  public static final String JSON_PROPERTY_NOTARY_IS_SIGNATORY = "notary_is_signatory";
  private Boolean notaryIsSignatory;

  public static final String JSON_PROPERTY_TIP_BASIS_POINTS = "tip_basis_points";
  private Long tipBasisPoints;

  public TransactionHeaderV2() { 
  }

  public TransactionHeaderV2 notaryPublicKey(PublicKey notaryPublicKey) {
    this.notaryPublicKey = notaryPublicKey;
    return this;
  }

   /**
   * Get notaryPublicKey
   * @return notaryPublicKey
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_NOTARY_PUBLIC_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public PublicKey getNotaryPublicKey() {
    return notaryPublicKey;
  }


  @JsonProperty(JSON_PROPERTY_NOTARY_PUBLIC_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNotaryPublicKey(PublicKey notaryPublicKey) {
    this.notaryPublicKey = notaryPublicKey;
  }


  public TransactionHeaderV2 notaryIsSignatory(Boolean notaryIsSignatory) {
    this.notaryIsSignatory = notaryIsSignatory;
    return this;
  }

   /**
   * Specifies whether the notary public key should be included in the transaction signers list
   * @return notaryIsSignatory
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Specifies whether the notary public key should be included in the transaction signers list")
  @JsonProperty(JSON_PROPERTY_NOTARY_IS_SIGNATORY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getNotaryIsSignatory() {
    return notaryIsSignatory;
  }


  @JsonProperty(JSON_PROPERTY_NOTARY_IS_SIGNATORY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNotaryIsSignatory(Boolean notaryIsSignatory) {
    this.notaryIsSignatory = notaryIsSignatory;
  }


  public TransactionHeaderV2 tipBasisPoints(Long tipBasisPoints) {
    this.tipBasisPoints = tipBasisPoints;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;2^32 - 1 &#x3D; 4294967295&#x60;, giving the validator tip as a basis points amount. That is, a value of &#x60;1&#x60; corresponds to an additional tip on 0.01% of the base fee. 
   * minimum: 0
   * maximum: 4294967295
   * @return tipBasisPoints
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `2^32 - 1 = 4294967295`, giving the validator tip as a basis points amount. That is, a value of `1` corresponds to an additional tip on 0.01% of the base fee. ")
  @JsonProperty(JSON_PROPERTY_TIP_BASIS_POINTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getTipBasisPoints() {
    return tipBasisPoints;
  }


  @JsonProperty(JSON_PROPERTY_TIP_BASIS_POINTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTipBasisPoints(Long tipBasisPoints) {
    this.tipBasisPoints = tipBasisPoints;
  }


  /**
   * Return true if this TransactionHeaderV2 object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionHeaderV2 transactionHeaderV2 = (TransactionHeaderV2) o;
    return Objects.equals(this.notaryPublicKey, transactionHeaderV2.notaryPublicKey) &&
        Objects.equals(this.notaryIsSignatory, transactionHeaderV2.notaryIsSignatory) &&
        Objects.equals(this.tipBasisPoints, transactionHeaderV2.tipBasisPoints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(notaryPublicKey, notaryIsSignatory, tipBasisPoints);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionHeaderV2 {\n");
    sb.append("    notaryPublicKey: ").append(toIndentedString(notaryPublicKey)).append("\n");
    sb.append("    notaryIsSignatory: ").append(toIndentedString(notaryIsSignatory)).append("\n");
    sb.append("    tipBasisPoints: ").append(toIndentedString(tipBasisPoints)).append("\n");
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


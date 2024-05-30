/*
 * Radix Core API - Babylon (Bottlenose)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.1
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
import com.radixdlt.api.core.generated.models.CommittedStateIdentifier;
import com.radixdlt.api.core.generated.models.CommittedTransactionBalanceChanges;
import com.radixdlt.api.core.generated.models.LedgerTransaction;
import com.radixdlt.api.core.generated.models.TransactionReceipt;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * CommittedTransaction
 */
@JsonPropertyOrder({
  CommittedTransaction.JSON_PROPERTY_RESULTANT_STATE_IDENTIFIERS,
  CommittedTransaction.JSON_PROPERTY_LEDGER_TRANSACTION,
  CommittedTransaction.JSON_PROPERTY_RECEIPT,
  CommittedTransaction.JSON_PROPERTY_BALANCE_CHANGES,
  CommittedTransaction.JSON_PROPERTY_PROPOSER_TIMESTAMP_MS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CommittedTransaction {
  public static final String JSON_PROPERTY_RESULTANT_STATE_IDENTIFIERS = "resultant_state_identifiers";
  private CommittedStateIdentifier resultantStateIdentifiers;

  public static final String JSON_PROPERTY_LEDGER_TRANSACTION = "ledger_transaction";
  private LedgerTransaction ledgerTransaction;

  public static final String JSON_PROPERTY_RECEIPT = "receipt";
  private TransactionReceipt receipt;

  public static final String JSON_PROPERTY_BALANCE_CHANGES = "balance_changes";
  private CommittedTransactionBalanceChanges balanceChanges;

  public static final String JSON_PROPERTY_PROPOSER_TIMESTAMP_MS = "proposer_timestamp_ms";
  private Long proposerTimestampMs;

  public CommittedTransaction() { 
  }

  public CommittedTransaction resultantStateIdentifiers(CommittedStateIdentifier resultantStateIdentifiers) {
    this.resultantStateIdentifiers = resultantStateIdentifiers;
    return this;
  }

   /**
   * Get resultantStateIdentifiers
   * @return resultantStateIdentifiers
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_RESULTANT_STATE_IDENTIFIERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public CommittedStateIdentifier getResultantStateIdentifiers() {
    return resultantStateIdentifiers;
  }


  @JsonProperty(JSON_PROPERTY_RESULTANT_STATE_IDENTIFIERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResultantStateIdentifiers(CommittedStateIdentifier resultantStateIdentifiers) {
    this.resultantStateIdentifiers = resultantStateIdentifiers;
  }


  public CommittedTransaction ledgerTransaction(LedgerTransaction ledgerTransaction) {
    this.ledgerTransaction = ledgerTransaction;
    return this;
  }

   /**
   * Get ledgerTransaction
   * @return ledgerTransaction
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_LEDGER_TRANSACTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public LedgerTransaction getLedgerTransaction() {
    return ledgerTransaction;
  }


  @JsonProperty(JSON_PROPERTY_LEDGER_TRANSACTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLedgerTransaction(LedgerTransaction ledgerTransaction) {
    this.ledgerTransaction = ledgerTransaction;
  }


  public CommittedTransaction receipt(TransactionReceipt receipt) {
    this.receipt = receipt;
    return this;
  }

   /**
   * Get receipt
   * @return receipt
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_RECEIPT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TransactionReceipt getReceipt() {
    return receipt;
  }


  @JsonProperty(JSON_PROPERTY_RECEIPT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setReceipt(TransactionReceipt receipt) {
    this.receipt = receipt;
  }


  public CommittedTransaction balanceChanges(CommittedTransactionBalanceChanges balanceChanges) {
    this.balanceChanges = balanceChanges;
    return this;
  }

   /**
   * Get balanceChanges
   * @return balanceChanges
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BALANCE_CHANGES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CommittedTransactionBalanceChanges getBalanceChanges() {
    return balanceChanges;
  }


  @JsonProperty(JSON_PROPERTY_BALANCE_CHANGES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBalanceChanges(CommittedTransactionBalanceChanges balanceChanges) {
    this.balanceChanges = balanceChanges;
  }


  public CommittedTransaction proposerTimestampMs(Long proposerTimestampMs) {
    this.proposerTimestampMs = proposerTimestampMs;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^14&#x60;, marking the proposer timestamp in ms.
   * minimum: 0
   * maximum: 100000000000000
   * @return proposerTimestampMs
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^14`, marking the proposer timestamp in ms.")
  @JsonProperty(JSON_PROPERTY_PROPOSER_TIMESTAMP_MS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getProposerTimestampMs() {
    return proposerTimestampMs;
  }


  @JsonProperty(JSON_PROPERTY_PROPOSER_TIMESTAMP_MS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProposerTimestampMs(Long proposerTimestampMs) {
    this.proposerTimestampMs = proposerTimestampMs;
  }


  /**
   * Return true if this CommittedTransaction object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommittedTransaction committedTransaction = (CommittedTransaction) o;
    return Objects.equals(this.resultantStateIdentifiers, committedTransaction.resultantStateIdentifiers) &&
        Objects.equals(this.ledgerTransaction, committedTransaction.ledgerTransaction) &&
        Objects.equals(this.receipt, committedTransaction.receipt) &&
        Objects.equals(this.balanceChanges, committedTransaction.balanceChanges) &&
        Objects.equals(this.proposerTimestampMs, committedTransaction.proposerTimestampMs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resultantStateIdentifiers, ledgerTransaction, receipt, balanceChanges, proposerTimestampMs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommittedTransaction {\n");
    sb.append("    resultantStateIdentifiers: ").append(toIndentedString(resultantStateIdentifiers)).append("\n");
    sb.append("    ledgerTransaction: ").append(toIndentedString(ledgerTransaction)).append("\n");
    sb.append("    receipt: ").append(toIndentedString(receipt)).append("\n");
    sb.append("    balanceChanges: ").append(toIndentedString(balanceChanges)).append("\n");
    sb.append("    proposerTimestampMs: ").append(toIndentedString(proposerTimestampMs)).append("\n");
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


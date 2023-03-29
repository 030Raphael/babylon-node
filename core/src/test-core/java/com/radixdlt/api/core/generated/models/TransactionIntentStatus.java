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
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The status of the transaction intent, as determined by the node. FateUncertain or FateUncertainButLikelyRejection mean that it&#39;s still possible that a payload containing the transaction  
 */
public enum TransactionIntentStatus {
  
  COMMITTEDSUCCESS("CommittedSuccess"),
  
  COMMITTEDFAILURE("CommittedFailure"),
  
  PERMANENTREJECTION("PermanentRejection"),
  
  INMEMPOOL("InMempool"),
  
  NOTSEEN("NotSeen"),
  
  FATEUNCERTAIN("FateUncertain"),
  
  FATEUNCERTAINBUTLIKELYREJECTION("FateUncertainButLikelyRejection");

  private String value;

  TransactionIntentStatus(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static TransactionIntentStatus fromValue(String value) {
    for (TransactionIntentStatus b : TransactionIntentStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


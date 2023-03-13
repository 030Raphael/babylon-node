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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets SubstateType
 */
public enum SubstateType {
  
  METADATAENTRY("MetadataEntry"),
  
  ACCESSRULES("AccessRules"),
  
  FUNCTIONACCESSRULES("FunctionAccessRules"),
  
  TYPEINFO("TypeInfo"),
  
  COMPONENTSTATE("ComponentState"),
  
  COMPONENTROYALTYCONFIG("ComponentRoyaltyConfig"),
  
  COMPONENTROYALTYACCUMULATOR("ComponentRoyaltyAccumulator"),
  
  PACKAGEINFO("PackageInfo"),
  
  PACKAGECODE("PackageCode"),
  
  PACKAGECODETYPE("PackageCodeType"),
  
  PACKAGEROYALTYCONFIG("PackageRoyaltyConfig"),
  
  PACKAGEROYALTYACCUMULATOR("PackageRoyaltyAccumulator"),
  
  RESOURCEMANAGER("ResourceManager"),
  
  EPOCHMANAGER("EpochManager"),
  
  VALIDATORSET("ValidatorSet"),
  
  VALIDATOR("Validator"),
  
  CLOCKCURRENTMINUTE("ClockCurrentMinute"),
  
  KEYVALUESTOREENTRY("KeyValueStoreEntry"),
  
  NONFUNGIBLESTOREENTRY("NonFungibleStoreEntry"),
  
  VAULTINFO("VaultInfo"),
  
  VAULTFUNGIBLE("VaultFungible"),
  
  VAULTNONFUNGIBLE("VaultNonFungible"),
  
  VAULTLOCKEDFUNGIBLE("VaultLockedFungible"),
  
  VAULTLOCKEDNONFUNGIBLE("VaultLockedNonFungible"),
  
  ACCESSCONTROLLER("AccessController"),
  
  ACCOUNT("Account"),
  
  PACKAGEEVENTSCHEMA("PackageEventSchema");

  private String value;

  SubstateType(String value) {
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
  public static SubstateType fromValue(String value) {
    for (SubstateType b : SubstateType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


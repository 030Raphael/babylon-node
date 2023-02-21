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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.AccessControllerSubstate;
import com.radixdlt.api.core.generated.models.AccessRulesChainSubstate;
import com.radixdlt.api.core.generated.models.AccountSubstate;
import com.radixdlt.api.core.generated.models.ClockCurrentMinuteSubstate;
import com.radixdlt.api.core.generated.models.ComponentInfoSubstate;
import com.radixdlt.api.core.generated.models.ComponentRoyaltyAccumulatorSubstate;
import com.radixdlt.api.core.generated.models.ComponentRoyaltyConfigSubstate;
import com.radixdlt.api.core.generated.models.ComponentStateSubstate;
import com.radixdlt.api.core.generated.models.EpochManagerSubstate;
import com.radixdlt.api.core.generated.models.GlobalAddressSubstate;
import com.radixdlt.api.core.generated.models.KeyValueStoreEntrySubstate;
import com.radixdlt.api.core.generated.models.MetadataSubstate;
import com.radixdlt.api.core.generated.models.NativeCodeSubstate;
import com.radixdlt.api.core.generated.models.NonFungibleStoreEntrySubstate;
import com.radixdlt.api.core.generated.models.PackageInfoSubstate;
import com.radixdlt.api.core.generated.models.PackageRoyaltyAccumulatorSubstate;
import com.radixdlt.api.core.generated.models.PackageRoyaltyConfigSubstate;
import com.radixdlt.api.core.generated.models.PackageTypeInfoSubstate;
import com.radixdlt.api.core.generated.models.ResourceManagerSubstate;
import com.radixdlt.api.core.generated.models.SubstateType;
import com.radixdlt.api.core.generated.models.ValidatorSetSubstate;
import com.radixdlt.api.core.generated.models.ValidatorSubstate;
import com.radixdlt.api.core.generated.models.VaultSubstate;
import com.radixdlt.api.core.generated.models.WasmCodeSubstate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * Substate
 */
@JsonPropertyOrder({
  Substate.JSON_PROPERTY_SUBSTATE_TYPE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "substate_type", // ignore manually set substate_type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the substate_type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "substate_type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = AccessControllerSubstate.class, name = "AccessController"),
  @JsonSubTypes.Type(value = AccessControllerSubstate.class, name = "AccessControllerSubstate"),
  @JsonSubTypes.Type(value = AccessRulesChainSubstate.class, name = "AccessRulesChain"),
  @JsonSubTypes.Type(value = AccessRulesChainSubstate.class, name = "AccessRulesChainSubstate"),
  @JsonSubTypes.Type(value = AccountSubstate.class, name = "Account"),
  @JsonSubTypes.Type(value = AccountSubstate.class, name = "AccountSubstate"),
  @JsonSubTypes.Type(value = ClockCurrentMinuteSubstate.class, name = "ClockCurrentMinute"),
  @JsonSubTypes.Type(value = ClockCurrentMinuteSubstate.class, name = "ClockCurrentMinuteSubstate"),
  @JsonSubTypes.Type(value = ComponentInfoSubstate.class, name = "ComponentInfo"),
  @JsonSubTypes.Type(value = ComponentInfoSubstate.class, name = "ComponentInfoSubstate"),
  @JsonSubTypes.Type(value = ComponentRoyaltyAccumulatorSubstate.class, name = "ComponentRoyaltyAccumulator"),
  @JsonSubTypes.Type(value = ComponentRoyaltyAccumulatorSubstate.class, name = "ComponentRoyaltyAccumulatorSubstate"),
  @JsonSubTypes.Type(value = ComponentRoyaltyConfigSubstate.class, name = "ComponentRoyaltyConfig"),
  @JsonSubTypes.Type(value = ComponentRoyaltyConfigSubstate.class, name = "ComponentRoyaltyConfigSubstate"),
  @JsonSubTypes.Type(value = ComponentStateSubstate.class, name = "ComponentState"),
  @JsonSubTypes.Type(value = ComponentStateSubstate.class, name = "ComponentStateSubstate"),
  @JsonSubTypes.Type(value = EpochManagerSubstate.class, name = "EpochManager"),
  @JsonSubTypes.Type(value = EpochManagerSubstate.class, name = "EpochManagerSubstate"),
  @JsonSubTypes.Type(value = GlobalAddressSubstate.class, name = "GlobalAddress"),
  @JsonSubTypes.Type(value = GlobalAddressSubstate.class, name = "GlobalAddressSubstate"),
  @JsonSubTypes.Type(value = KeyValueStoreEntrySubstate.class, name = "KeyValueStoreEntry"),
  @JsonSubTypes.Type(value = KeyValueStoreEntrySubstate.class, name = "KeyValueStoreEntrySubstate"),
  @JsonSubTypes.Type(value = MetadataSubstate.class, name = "Metadata"),
  @JsonSubTypes.Type(value = MetadataSubstate.class, name = "MetadataSubstate"),
  @JsonSubTypes.Type(value = NativeCodeSubstate.class, name = "NativeCode"),
  @JsonSubTypes.Type(value = NativeCodeSubstate.class, name = "NativeCodeSubstate"),
  @JsonSubTypes.Type(value = NonFungibleStoreEntrySubstate.class, name = "NonFungibleStoreEntry"),
  @JsonSubTypes.Type(value = NonFungibleStoreEntrySubstate.class, name = "NonFungibleStoreEntrySubstate"),
  @JsonSubTypes.Type(value = PackageInfoSubstate.class, name = "PackageInfo"),
  @JsonSubTypes.Type(value = PackageInfoSubstate.class, name = "PackageInfoSubstate"),
  @JsonSubTypes.Type(value = PackageRoyaltyAccumulatorSubstate.class, name = "PackageRoyaltyAccumulator"),
  @JsonSubTypes.Type(value = PackageRoyaltyAccumulatorSubstate.class, name = "PackageRoyaltyAccumulatorSubstate"),
  @JsonSubTypes.Type(value = PackageRoyaltyConfigSubstate.class, name = "PackageRoyaltyConfig"),
  @JsonSubTypes.Type(value = PackageRoyaltyConfigSubstate.class, name = "PackageRoyaltyConfigSubstate"),
  @JsonSubTypes.Type(value = PackageTypeInfoSubstate.class, name = "PackageTypeInfo"),
  @JsonSubTypes.Type(value = PackageTypeInfoSubstate.class, name = "PackageTypeInfoSubstate"),
  @JsonSubTypes.Type(value = ResourceManagerSubstate.class, name = "ResourceManager"),
  @JsonSubTypes.Type(value = ResourceManagerSubstate.class, name = "ResourceManagerSubstate"),
  @JsonSubTypes.Type(value = ValidatorSubstate.class, name = "Validator"),
  @JsonSubTypes.Type(value = ValidatorSetSubstate.class, name = "ValidatorSet"),
  @JsonSubTypes.Type(value = ValidatorSetSubstate.class, name = "ValidatorSetSubstate"),
  @JsonSubTypes.Type(value = ValidatorSubstate.class, name = "ValidatorSubstate"),
  @JsonSubTypes.Type(value = VaultSubstate.class, name = "Vault"),
  @JsonSubTypes.Type(value = VaultSubstate.class, name = "VaultSubstate"),
  @JsonSubTypes.Type(value = WasmCodeSubstate.class, name = "WasmCode"),
  @JsonSubTypes.Type(value = WasmCodeSubstate.class, name = "WasmCodeSubstate"),
})

public class Substate {
  public static final String JSON_PROPERTY_SUBSTATE_TYPE = "substate_type";
  private SubstateType substateType;

  public Substate() { 
  }

  public Substate substateType(SubstateType substateType) {
    this.substateType = substateType;
    return this;
  }

   /**
   * Get substateType
   * @return substateType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SUBSTATE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SubstateType getSubstateType() {
    return substateType;
  }


  @JsonProperty(JSON_PROPERTY_SUBSTATE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSubstateType(SubstateType substateType) {
    this.substateType = substateType;
  }


  /**
   * Return true if this Substate object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Substate substate = (Substate) o;
    return Objects.equals(this.substateType, substate.substateType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(substateType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Substate {\n");
    sb.append("    substateType: ").append(toIndentedString(substateType)).append("\n");
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
  mappings.put("AccessController", AccessControllerSubstate.class);
  mappings.put("AccessControllerSubstate", AccessControllerSubstate.class);
  mappings.put("AccessRulesChain", AccessRulesChainSubstate.class);
  mappings.put("AccessRulesChainSubstate", AccessRulesChainSubstate.class);
  mappings.put("Account", AccountSubstate.class);
  mappings.put("AccountSubstate", AccountSubstate.class);
  mappings.put("ClockCurrentMinute", ClockCurrentMinuteSubstate.class);
  mappings.put("ClockCurrentMinuteSubstate", ClockCurrentMinuteSubstate.class);
  mappings.put("ComponentInfo", ComponentInfoSubstate.class);
  mappings.put("ComponentInfoSubstate", ComponentInfoSubstate.class);
  mappings.put("ComponentRoyaltyAccumulator", ComponentRoyaltyAccumulatorSubstate.class);
  mappings.put("ComponentRoyaltyAccumulatorSubstate", ComponentRoyaltyAccumulatorSubstate.class);
  mappings.put("ComponentRoyaltyConfig", ComponentRoyaltyConfigSubstate.class);
  mappings.put("ComponentRoyaltyConfigSubstate", ComponentRoyaltyConfigSubstate.class);
  mappings.put("ComponentState", ComponentStateSubstate.class);
  mappings.put("ComponentStateSubstate", ComponentStateSubstate.class);
  mappings.put("EpochManager", EpochManagerSubstate.class);
  mappings.put("EpochManagerSubstate", EpochManagerSubstate.class);
  mappings.put("GlobalAddress", GlobalAddressSubstate.class);
  mappings.put("GlobalAddressSubstate", GlobalAddressSubstate.class);
  mappings.put("KeyValueStoreEntry", KeyValueStoreEntrySubstate.class);
  mappings.put("KeyValueStoreEntrySubstate", KeyValueStoreEntrySubstate.class);
  mappings.put("Metadata", MetadataSubstate.class);
  mappings.put("MetadataSubstate", MetadataSubstate.class);
  mappings.put("NativeCode", NativeCodeSubstate.class);
  mappings.put("NativeCodeSubstate", NativeCodeSubstate.class);
  mappings.put("NonFungibleStoreEntry", NonFungibleStoreEntrySubstate.class);
  mappings.put("NonFungibleStoreEntrySubstate", NonFungibleStoreEntrySubstate.class);
  mappings.put("PackageInfo", PackageInfoSubstate.class);
  mappings.put("PackageInfoSubstate", PackageInfoSubstate.class);
  mappings.put("PackageRoyaltyAccumulator", PackageRoyaltyAccumulatorSubstate.class);
  mappings.put("PackageRoyaltyAccumulatorSubstate", PackageRoyaltyAccumulatorSubstate.class);
  mappings.put("PackageRoyaltyConfig", PackageRoyaltyConfigSubstate.class);
  mappings.put("PackageRoyaltyConfigSubstate", PackageRoyaltyConfigSubstate.class);
  mappings.put("PackageTypeInfo", PackageTypeInfoSubstate.class);
  mappings.put("PackageTypeInfoSubstate", PackageTypeInfoSubstate.class);
  mappings.put("ResourceManager", ResourceManagerSubstate.class);
  mappings.put("ResourceManagerSubstate", ResourceManagerSubstate.class);
  mappings.put("Validator", ValidatorSubstate.class);
  mappings.put("ValidatorSet", ValidatorSetSubstate.class);
  mappings.put("ValidatorSetSubstate", ValidatorSetSubstate.class);
  mappings.put("ValidatorSubstate", ValidatorSubstate.class);
  mappings.put("Vault", VaultSubstate.class);
  mappings.put("VaultSubstate", VaultSubstate.class);
  mappings.put("WasmCode", WasmCodeSubstate.class);
  mappings.put("WasmCodeSubstate", WasmCodeSubstate.class);
  mappings.put("Substate", Substate.class);
  JSON.registerDiscriminator(Substate.class, "substate_type", mappings);
}
}


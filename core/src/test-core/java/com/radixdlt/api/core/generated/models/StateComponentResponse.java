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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.ResourceAmount;
import com.radixdlt.api.core.generated.models.StateComponentDescendentId;
import com.radixdlt.api.core.generated.models.Substate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * StateComponentResponse
 */
@JsonPropertyOrder({
  StateComponentResponse.JSON_PROPERTY_INFO,
  StateComponentResponse.JSON_PROPERTY_STATE,
  StateComponentResponse.JSON_PROPERTY_ACCOUNT,
  StateComponentResponse.JSON_PROPERTY_ROYALTY_CONFIG,
  StateComponentResponse.JSON_PROPERTY_ROYALTY_ACCUMULATOR,
  StateComponentResponse.JSON_PROPERTY_ACCESS_RULES,
  StateComponentResponse.JSON_PROPERTY_STATE_OWNED_VAULTS,
  StateComponentResponse.JSON_PROPERTY_DESCENDENT_IDS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class StateComponentResponse {
  public static final String JSON_PROPERTY_INFO = "info";
  private Substate info;

  public static final String JSON_PROPERTY_STATE = "state";
  private Substate state;

  public static final String JSON_PROPERTY_ACCOUNT = "account";
  private Substate account;

  public static final String JSON_PROPERTY_ROYALTY_CONFIG = "royalty_config";
  private Substate royaltyConfig;

  public static final String JSON_PROPERTY_ROYALTY_ACCUMULATOR = "royalty_accumulator";
  private Substate royaltyAccumulator;

  public static final String JSON_PROPERTY_ACCESS_RULES = "access_rules";
  private Substate accessRules;

  public static final String JSON_PROPERTY_STATE_OWNED_VAULTS = "state_owned_vaults";
  private List<ResourceAmount> stateOwnedVaults = new ArrayList<>();

  public static final String JSON_PROPERTY_DESCENDENT_IDS = "descendent_ids";
  private List<StateComponentDescendentId> descendentIds = new ArrayList<>();

  public StateComponentResponse() { 
  }

  public StateComponentResponse info(Substate info) {
    this.info = info;
    return this;
  }

   /**
   * Get info
   * @return info
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_INFO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getInfo() {
    return info;
  }


  @JsonProperty(JSON_PROPERTY_INFO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setInfo(Substate info) {
    this.info = info;
  }


  public StateComponentResponse state(Substate state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Substate getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setState(Substate state) {
    this.state = state;
  }


  public StateComponentResponse account(Substate account) {
    this.account = account;
    return this;
  }

   /**
   * Get account
   * @return account
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ACCOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Substate getAccount() {
    return account;
  }


  @JsonProperty(JSON_PROPERTY_ACCOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccount(Substate account) {
    this.account = account;
  }


  public StateComponentResponse royaltyConfig(Substate royaltyConfig) {
    this.royaltyConfig = royaltyConfig;
    return this;
  }

   /**
   * Get royaltyConfig
   * @return royaltyConfig
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ROYALTY_CONFIG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Substate getRoyaltyConfig() {
    return royaltyConfig;
  }


  @JsonProperty(JSON_PROPERTY_ROYALTY_CONFIG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoyaltyConfig(Substate royaltyConfig) {
    this.royaltyConfig = royaltyConfig;
  }


  public StateComponentResponse royaltyAccumulator(Substate royaltyAccumulator) {
    this.royaltyAccumulator = royaltyAccumulator;
    return this;
  }

   /**
   * Get royaltyAccumulator
   * @return royaltyAccumulator
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ROYALTY_ACCUMULATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Substate getRoyaltyAccumulator() {
    return royaltyAccumulator;
  }


  @JsonProperty(JSON_PROPERTY_ROYALTY_ACCUMULATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoyaltyAccumulator(Substate royaltyAccumulator) {
    this.royaltyAccumulator = royaltyAccumulator;
  }


  public StateComponentResponse accessRules(Substate accessRules) {
    this.accessRules = accessRules;
    return this;
  }

   /**
   * Get accessRules
   * @return accessRules
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ACCESS_RULES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getAccessRules() {
    return accessRules;
  }


  @JsonProperty(JSON_PROPERTY_ACCESS_RULES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAccessRules(Substate accessRules) {
    this.accessRules = accessRules;
  }


  public StateComponentResponse stateOwnedVaults(List<ResourceAmount> stateOwnedVaults) {
    this.stateOwnedVaults = stateOwnedVaults;
    return this;
  }

  public StateComponentResponse addStateOwnedVaultsItem(ResourceAmount stateOwnedVaultsItem) {
    this.stateOwnedVaults.add(stateOwnedVaultsItem);
    return this;
  }

   /**
   * Any vaults owned directly or indirectly by the component
   * @return stateOwnedVaults
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Any vaults owned directly or indirectly by the component")
  @JsonProperty(JSON_PROPERTY_STATE_OWNED_VAULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<ResourceAmount> getStateOwnedVaults() {
    return stateOwnedVaults;
  }


  @JsonProperty(JSON_PROPERTY_STATE_OWNED_VAULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStateOwnedVaults(List<ResourceAmount> stateOwnedVaults) {
    this.stateOwnedVaults = stateOwnedVaults;
  }


  public StateComponentResponse descendentIds(List<StateComponentDescendentId> descendentIds) {
    this.descendentIds = descendentIds;
    return this;
  }

  public StateComponentResponse addDescendentIdsItem(StateComponentDescendentId descendentIdsItem) {
    this.descendentIds.add(descendentIdsItem);
    return this;
  }

   /**
   * Any descendent nodes owned directly or indirectly by the component
   * @return descendentIds
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Any descendent nodes owned directly or indirectly by the component")
  @JsonProperty(JSON_PROPERTY_DESCENDENT_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<StateComponentDescendentId> getDescendentIds() {
    return descendentIds;
  }


  @JsonProperty(JSON_PROPERTY_DESCENDENT_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDescendentIds(List<StateComponentDescendentId> descendentIds) {
    this.descendentIds = descendentIds;
  }


  /**
   * Return true if this StateComponentResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StateComponentResponse stateComponentResponse = (StateComponentResponse) o;
    return Objects.equals(this.info, stateComponentResponse.info) &&
        Objects.equals(this.state, stateComponentResponse.state) &&
        Objects.equals(this.account, stateComponentResponse.account) &&
        Objects.equals(this.royaltyConfig, stateComponentResponse.royaltyConfig) &&
        Objects.equals(this.royaltyAccumulator, stateComponentResponse.royaltyAccumulator) &&
        Objects.equals(this.accessRules, stateComponentResponse.accessRules) &&
        Objects.equals(this.stateOwnedVaults, stateComponentResponse.stateOwnedVaults) &&
        Objects.equals(this.descendentIds, stateComponentResponse.descendentIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(info, state, account, royaltyConfig, royaltyAccumulator, accessRules, stateOwnedVaults, descendentIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StateComponentResponse {\n");
    sb.append("    info: ").append(toIndentedString(info)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    royaltyConfig: ").append(toIndentedString(royaltyConfig)).append("\n");
    sb.append("    royaltyAccumulator: ").append(toIndentedString(royaltyAccumulator)).append("\n");
    sb.append("    accessRules: ").append(toIndentedString(accessRules)).append("\n");
    sb.append("    stateOwnedVaults: ").append(toIndentedString(stateOwnedVaults)).append("\n");
    sb.append("    descendentIds: ").append(toIndentedString(descendentIds)).append("\n");
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


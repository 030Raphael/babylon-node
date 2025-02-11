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
import com.radixdlt.api.core.generated.models.LedgerStateSummary;
import com.radixdlt.api.core.generated.models.StateComponentDescendentNode;
import com.radixdlt.api.core.generated.models.Substate;
import com.radixdlt.api.core.generated.models.VaultBalance;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * StateAccessControllerResponse
 */
@JsonPropertyOrder({
  StateAccessControllerResponse.JSON_PROPERTY_AT_LEDGER_STATE,
  StateAccessControllerResponse.JSON_PROPERTY_STATE,
  StateAccessControllerResponse.JSON_PROPERTY_OWNER_ROLE,
  StateAccessControllerResponse.JSON_PROPERTY_VAULTS,
  StateAccessControllerResponse.JSON_PROPERTY_DESCENDENT_NODES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class StateAccessControllerResponse {
  public static final String JSON_PROPERTY_AT_LEDGER_STATE = "at_ledger_state";
  private LedgerStateSummary atLedgerState;

  public static final String JSON_PROPERTY_STATE = "state";
  private Substate state;

  public static final String JSON_PROPERTY_OWNER_ROLE = "owner_role";
  private Substate ownerRole;

  public static final String JSON_PROPERTY_VAULTS = "vaults";
  private List<VaultBalance> vaults = new ArrayList<>();

  public static final String JSON_PROPERTY_DESCENDENT_NODES = "descendent_nodes";
  private List<StateComponentDescendentNode> descendentNodes = new ArrayList<>();

  public StateAccessControllerResponse() { 
  }

  public StateAccessControllerResponse atLedgerState(LedgerStateSummary atLedgerState) {
    this.atLedgerState = atLedgerState;
    return this;
  }

   /**
   * Get atLedgerState
   * @return atLedgerState
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_AT_LEDGER_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public LedgerStateSummary getAtLedgerState() {
    return atLedgerState;
  }


  @JsonProperty(JSON_PROPERTY_AT_LEDGER_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAtLedgerState(LedgerStateSummary atLedgerState) {
    this.atLedgerState = atLedgerState;
  }


  public StateAccessControllerResponse state(Substate state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setState(Substate state) {
    this.state = state;
  }


  public StateAccessControllerResponse ownerRole(Substate ownerRole) {
    this.ownerRole = ownerRole;
    return this;
  }

   /**
   * Get ownerRole
   * @return ownerRole
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_OWNER_ROLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getOwnerRole() {
    return ownerRole;
  }


  @JsonProperty(JSON_PROPERTY_OWNER_ROLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOwnerRole(Substate ownerRole) {
    this.ownerRole = ownerRole;
  }


  public StateAccessControllerResponse vaults(List<VaultBalance> vaults) {
    this.vaults = vaults;
    return this;
  }

  public StateAccessControllerResponse addVaultsItem(VaultBalance vaultsItem) {
    this.vaults.add(vaultsItem);
    return this;
  }

   /**
   * Any vaults owned directly or indirectly by the component
   * @return vaults
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Any vaults owned directly or indirectly by the component")
  @JsonProperty(JSON_PROPERTY_VAULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<VaultBalance> getVaults() {
    return vaults;
  }


  @JsonProperty(JSON_PROPERTY_VAULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setVaults(List<VaultBalance> vaults) {
    this.vaults = vaults;
  }


  public StateAccessControllerResponse descendentNodes(List<StateComponentDescendentNode> descendentNodes) {
    this.descendentNodes = descendentNodes;
    return this;
  }

  public StateAccessControllerResponse addDescendentNodesItem(StateComponentDescendentNode descendentNodesItem) {
    this.descendentNodes.add(descendentNodesItem);
    return this;
  }

   /**
   * Any descendent nodes owned directly or indirectly by the component
   * @return descendentNodes
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Any descendent nodes owned directly or indirectly by the component")
  @JsonProperty(JSON_PROPERTY_DESCENDENT_NODES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<StateComponentDescendentNode> getDescendentNodes() {
    return descendentNodes;
  }


  @JsonProperty(JSON_PROPERTY_DESCENDENT_NODES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDescendentNodes(List<StateComponentDescendentNode> descendentNodes) {
    this.descendentNodes = descendentNodes;
  }


  /**
   * Return true if this StateAccessControllerResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StateAccessControllerResponse stateAccessControllerResponse = (StateAccessControllerResponse) o;
    return Objects.equals(this.atLedgerState, stateAccessControllerResponse.atLedgerState) &&
        Objects.equals(this.state, stateAccessControllerResponse.state) &&
        Objects.equals(this.ownerRole, stateAccessControllerResponse.ownerRole) &&
        Objects.equals(this.vaults, stateAccessControllerResponse.vaults) &&
        Objects.equals(this.descendentNodes, stateAccessControllerResponse.descendentNodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(atLedgerState, state, ownerRole, vaults, descendentNodes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StateAccessControllerResponse {\n");
    sb.append("    atLedgerState: ").append(toIndentedString(atLedgerState)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    ownerRole: ").append(toIndentedString(ownerRole)).append("\n");
    sb.append("    vaults: ").append(toIndentedString(vaults)).append("\n");
    sb.append("    descendentNodes: ").append(toIndentedString(descendentNodes)).append("\n");
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


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
import com.radixdlt.api.core.generated.models.ActiveValidatorIndex;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * LeaderProposalHistory
 */
@JsonPropertyOrder({
  LeaderProposalHistory.JSON_PROPERTY_GAP_ROUND_LEADERS,
  LeaderProposalHistory.JSON_PROPERTY_CURRENT_LEADER,
  LeaderProposalHistory.JSON_PROPERTY_IS_FALLBACK
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class LeaderProposalHistory {
  public static final String JSON_PROPERTY_GAP_ROUND_LEADERS = "gap_round_leaders";
  private List<ActiveValidatorIndex> gapRoundLeaders = new ArrayList<>();

  public static final String JSON_PROPERTY_CURRENT_LEADER = "current_leader";
  private ActiveValidatorIndex currentLeader;

  public static final String JSON_PROPERTY_IS_FALLBACK = "is_fallback";
  private Boolean isFallback;

  public LeaderProposalHistory() { 
  }

  public LeaderProposalHistory gapRoundLeaders(List<ActiveValidatorIndex> gapRoundLeaders) {
    this.gapRoundLeaders = gapRoundLeaders;
    return this;
  }

  public LeaderProposalHistory addGapRoundLeadersItem(ActiveValidatorIndex gapRoundLeadersItem) {
    this.gapRoundLeaders.add(gapRoundLeadersItem);
    return this;
  }

   /**
   * The validators which were leaders of the \&quot;gap\&quot; rounds (i.e. since the previous &#x60;RoundUpdateValidatorTransaction&#x60; - which means that this list will contain exactly &#x60;current.round - previous.round - 1&#x60; elements). The validators on this list should be penalized during emissions at the end of the epoch.
   * @return gapRoundLeaders
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The validators which were leaders of the \"gap\" rounds (i.e. since the previous `RoundUpdateValidatorTransaction` - which means that this list will contain exactly `current.round - previous.round - 1` elements). The validators on this list should be penalized during emissions at the end of the epoch.")
  @JsonProperty(JSON_PROPERTY_GAP_ROUND_LEADERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<ActiveValidatorIndex> getGapRoundLeaders() {
    return gapRoundLeaders;
  }


  @JsonProperty(JSON_PROPERTY_GAP_ROUND_LEADERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGapRoundLeaders(List<ActiveValidatorIndex> gapRoundLeaders) {
    this.gapRoundLeaders = gapRoundLeaders;
  }


  public LeaderProposalHistory currentLeader(ActiveValidatorIndex currentLeader) {
    this.currentLeader = currentLeader;
    return this;
  }

   /**
   * Get currentLeader
   * @return currentLeader
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CURRENT_LEADER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ActiveValidatorIndex getCurrentLeader() {
    return currentLeader;
  }


  @JsonProperty(JSON_PROPERTY_CURRENT_LEADER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCurrentLeader(ActiveValidatorIndex currentLeader) {
    this.currentLeader = currentLeader;
  }


  public LeaderProposalHistory isFallback(Boolean isFallback) {
    this.isFallback = isFallback;
    return this;
  }

   /**
   * Whether the concluded round was conducted in a \&quot;fallback\&quot; mode (i.e. indicating a fault of the current leader). When &#x60;true&#x60;, the &#x60;current_leader&#x60; should be penalized during emissions in the same way as &#x60;gap_round_leaders&#x60;. When &#x60;false&#x60;, the &#x60;current_leader&#x60; is considered to have made this round&#39;s proposal successfully.
   * @return isFallback
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Whether the concluded round was conducted in a \"fallback\" mode (i.e. indicating a fault of the current leader). When `true`, the `current_leader` should be penalized during emissions in the same way as `gap_round_leaders`. When `false`, the `current_leader` is considered to have made this round's proposal successfully.")
  @JsonProperty(JSON_PROPERTY_IS_FALLBACK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getIsFallback() {
    return isFallback;
  }


  @JsonProperty(JSON_PROPERTY_IS_FALLBACK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIsFallback(Boolean isFallback) {
    this.isFallback = isFallback;
  }


  /**
   * Return true if this LeaderProposalHistory object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LeaderProposalHistory leaderProposalHistory = (LeaderProposalHistory) o;
    return Objects.equals(this.gapRoundLeaders, leaderProposalHistory.gapRoundLeaders) &&
        Objects.equals(this.currentLeader, leaderProposalHistory.currentLeader) &&
        Objects.equals(this.isFallback, leaderProposalHistory.isFallback);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gapRoundLeaders, currentLeader, isFallback);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LeaderProposalHistory {\n");
    sb.append("    gapRoundLeaders: ").append(toIndentedString(gapRoundLeaders)).append("\n");
    sb.append("    currentLeader: ").append(toIndentedString(currentLeader)).append("\n");
    sb.append("    isFallback: ").append(toIndentedString(isFallback)).append("\n");
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


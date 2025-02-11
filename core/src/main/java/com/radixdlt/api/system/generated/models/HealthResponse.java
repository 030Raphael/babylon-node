/*
 * Radix System API
 * This API is exposed by the Babylon Radix node to give clients access to information about the node itself, its configuration, status and subsystems.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against ledger state, you may also wish to consider using the [Core API or Gateway API instead](https://docs-babylon.radixdlt.com/main/apis/api-specification.html). 
 *
 * The version of the OpenAPI document: v1.3.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.system.generated.models;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.system.generated.models.EnactedProtocolUpdate;
import com.radixdlt.api.system.generated.models.PendingProtocolUpdate;
import com.radixdlt.api.system.generated.models.RecentSelfProposalMissStatistic;
import com.radixdlt.api.system.generated.models.UnknownReportedPendingProtocolUpdate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * HealthResponse
 */
@JsonPropertyOrder({
  HealthResponse.JSON_PROPERTY_STATUS,
  HealthResponse.JSON_PROPERTY_DETAIL,
  HealthResponse.JSON_PROPERTY_RECENT_SELF_PROPOSAL_MISS_STATISTIC,
  HealthResponse.JSON_PROPERTY_CURRENT_PROTOCOL_VERSION,
  HealthResponse.JSON_PROPERTY_ENACTED_PROTOCOL_UPDATES,
  HealthResponse.JSON_PROPERTY_PENDING_PROTOCOL_UPDATES,
  HealthResponse.JSON_PROPERTY_UNKNOWN_REPORTED_PENDING_PROTOCOL_UPDATES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class HealthResponse {
  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    BOOTING_PRE_GENESIS("BOOTING_PRE_GENESIS"),
    
    SYNCING("SYNCING"),
    
    UP("UP"),
    
    OUT_OF_SYNC("OUT_OF_SYNC");

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_STATUS = "status";
  private StatusEnum status;

  public static final String JSON_PROPERTY_DETAIL = "detail";
  private String detail;

  public static final String JSON_PROPERTY_RECENT_SELF_PROPOSAL_MISS_STATISTIC = "recent_self_proposal_miss_statistic";
  private RecentSelfProposalMissStatistic recentSelfProposalMissStatistic;

  public static final String JSON_PROPERTY_CURRENT_PROTOCOL_VERSION = "current_protocol_version";
  private String currentProtocolVersion;

  public static final String JSON_PROPERTY_ENACTED_PROTOCOL_UPDATES = "enacted_protocol_updates";
  private List<EnactedProtocolUpdate> enactedProtocolUpdates = new ArrayList<>();

  public static final String JSON_PROPERTY_PENDING_PROTOCOL_UPDATES = "pending_protocol_updates";
  private List<PendingProtocolUpdate> pendingProtocolUpdates = new ArrayList<>();

  public static final String JSON_PROPERTY_UNKNOWN_REPORTED_PENDING_PROTOCOL_UPDATES = "unknown_reported_pending_protocol_updates";
  private List<UnknownReportedPendingProtocolUpdate> unknownReportedPendingProtocolUpdates = new ArrayList<>();


  public HealthResponse status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public StatusEnum getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  public HealthResponse detail(String detail) {
    this.detail = detail;
    return this;
  }

   /**
   * A human-readable message detailing the &#x60;status&#x60;.
   * @return detail
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A human-readable message detailing the `status`.")
  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDetail() {
    return detail;
  }


  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDetail(String detail) {
    this.detail = detail;
  }


  public HealthResponse recentSelfProposalMissStatistic(RecentSelfProposalMissStatistic recentSelfProposalMissStatistic) {
    this.recentSelfProposalMissStatistic = recentSelfProposalMissStatistic;
    return this;
  }

   /**
   * Get recentSelfProposalMissStatistic
   * @return recentSelfProposalMissStatistic
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_RECENT_SELF_PROPOSAL_MISS_STATISTIC)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public RecentSelfProposalMissStatistic getRecentSelfProposalMissStatistic() {
    return recentSelfProposalMissStatistic;
  }


  @JsonProperty(JSON_PROPERTY_RECENT_SELF_PROPOSAL_MISS_STATISTIC)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRecentSelfProposalMissStatistic(RecentSelfProposalMissStatistic recentSelfProposalMissStatistic) {
    this.recentSelfProposalMissStatistic = recentSelfProposalMissStatistic;
  }


  public HealthResponse currentProtocolVersion(String currentProtocolVersion) {
    this.currentProtocolVersion = currentProtocolVersion;
    return this;
  }

   /**
   * A name identifying a protocol version.
   * @return currentProtocolVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A name identifying a protocol version.")
  @JsonProperty(JSON_PROPERTY_CURRENT_PROTOCOL_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCurrentProtocolVersion() {
    return currentProtocolVersion;
  }


  @JsonProperty(JSON_PROPERTY_CURRENT_PROTOCOL_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCurrentProtocolVersion(String currentProtocolVersion) {
    this.currentProtocolVersion = currentProtocolVersion;
  }


  public HealthResponse enactedProtocolUpdates(List<EnactedProtocolUpdate> enactedProtocolUpdates) {
    this.enactedProtocolUpdates = enactedProtocolUpdates;
    return this;
  }

  public HealthResponse addEnactedProtocolUpdatesItem(EnactedProtocolUpdate enactedProtocolUpdatesItem) {
    this.enactedProtocolUpdates.add(enactedProtocolUpdatesItem);
    return this;
  }

   /**
   * Get enactedProtocolUpdates
   * @return enactedProtocolUpdates
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ENACTED_PROTOCOL_UPDATES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<EnactedProtocolUpdate> getEnactedProtocolUpdates() {
    return enactedProtocolUpdates;
  }


  @JsonProperty(JSON_PROPERTY_ENACTED_PROTOCOL_UPDATES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEnactedProtocolUpdates(List<EnactedProtocolUpdate> enactedProtocolUpdates) {
    this.enactedProtocolUpdates = enactedProtocolUpdates;
  }


  public HealthResponse pendingProtocolUpdates(List<PendingProtocolUpdate> pendingProtocolUpdates) {
    this.pendingProtocolUpdates = pendingProtocolUpdates;
    return this;
  }

  public HealthResponse addPendingProtocolUpdatesItem(PendingProtocolUpdate pendingProtocolUpdatesItem) {
    this.pendingProtocolUpdates.add(pendingProtocolUpdatesItem);
    return this;
  }

   /**
   * Get pendingProtocolUpdates
   * @return pendingProtocolUpdates
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PENDING_PROTOCOL_UPDATES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<PendingProtocolUpdate> getPendingProtocolUpdates() {
    return pendingProtocolUpdates;
  }


  @JsonProperty(JSON_PROPERTY_PENDING_PROTOCOL_UPDATES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPendingProtocolUpdates(List<PendingProtocolUpdate> pendingProtocolUpdates) {
    this.pendingProtocolUpdates = pendingProtocolUpdates;
  }


  public HealthResponse unknownReportedPendingProtocolUpdates(List<UnknownReportedPendingProtocolUpdate> unknownReportedPendingProtocolUpdates) {
    this.unknownReportedPendingProtocolUpdates = unknownReportedPendingProtocolUpdates;
    return this;
  }

  public HealthResponse addUnknownReportedPendingProtocolUpdatesItem(UnknownReportedPendingProtocolUpdate unknownReportedPendingProtocolUpdatesItem) {
    this.unknownReportedPendingProtocolUpdates.add(unknownReportedPendingProtocolUpdatesItem);
    return this;
  }

   /**
   * Get unknownReportedPendingProtocolUpdates
   * @return unknownReportedPendingProtocolUpdates
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_UNKNOWN_REPORTED_PENDING_PROTOCOL_UPDATES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<UnknownReportedPendingProtocolUpdate> getUnknownReportedPendingProtocolUpdates() {
    return unknownReportedPendingProtocolUpdates;
  }


  @JsonProperty(JSON_PROPERTY_UNKNOWN_REPORTED_PENDING_PROTOCOL_UPDATES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUnknownReportedPendingProtocolUpdates(List<UnknownReportedPendingProtocolUpdate> unknownReportedPendingProtocolUpdates) {
    this.unknownReportedPendingProtocolUpdates = unknownReportedPendingProtocolUpdates;
  }


  /**
   * Return true if this HealthResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HealthResponse healthResponse = (HealthResponse) o;
    return Objects.equals(this.status, healthResponse.status) &&
        Objects.equals(this.detail, healthResponse.detail) &&
        Objects.equals(this.recentSelfProposalMissStatistic, healthResponse.recentSelfProposalMissStatistic) &&
        Objects.equals(this.currentProtocolVersion, healthResponse.currentProtocolVersion) &&
        Objects.equals(this.enactedProtocolUpdates, healthResponse.enactedProtocolUpdates) &&
        Objects.equals(this.pendingProtocolUpdates, healthResponse.pendingProtocolUpdates) &&
        Objects.equals(this.unknownReportedPendingProtocolUpdates, healthResponse.unknownReportedPendingProtocolUpdates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, detail, recentSelfProposalMissStatistic, currentProtocolVersion, enactedProtocolUpdates, pendingProtocolUpdates, unknownReportedPendingProtocolUpdates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealthResponse {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    recentSelfProposalMissStatistic: ").append(toIndentedString(recentSelfProposalMissStatistic)).append("\n");
    sb.append("    currentProtocolVersion: ").append(toIndentedString(currentProtocolVersion)).append("\n");
    sb.append("    enactedProtocolUpdates: ").append(toIndentedString(enactedProtocolUpdates)).append("\n");
    sb.append("    pendingProtocolUpdates: ").append(toIndentedString(pendingProtocolUpdates)).append("\n");
    sb.append("    unknownReportedPendingProtocolUpdates: ").append(toIndentedString(unknownReportedPendingProtocolUpdates)).append("\n");
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


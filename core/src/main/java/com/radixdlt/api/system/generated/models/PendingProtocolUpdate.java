/*
 * Radix System API
 * This API is exposed by the Babylon Radix node to give clients access to information about the node itself, its configuration, status and subsystems.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against ledger state, you may also wish to consider using the [Core API or Gateway API instead](https://docs-babylon.radixdlt.com/main/apis/api-specification.html). 
 *
 * The version of the OpenAPI document: v1.2.3
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
import com.radixdlt.api.system.generated.models.PendingProtocolUpdateState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * PendingProtocolUpdate
 */
@JsonPropertyOrder({
  PendingProtocolUpdate.JSON_PROPERTY_PROTOCOL_VERSION,
  PendingProtocolUpdate.JSON_PROPERTY_STATE,
  PendingProtocolUpdate.JSON_PROPERTY_READINESS_SIGNAL_NAME,
  PendingProtocolUpdate.JSON_PROPERTY_READINESS_SIGNAL_STATUS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class PendingProtocolUpdate {
  public static final String JSON_PROPERTY_PROTOCOL_VERSION = "protocol_version";
  private String protocolVersion;

  public static final String JSON_PROPERTY_STATE = "state";
  private PendingProtocolUpdateState state;

  public static final String JSON_PROPERTY_READINESS_SIGNAL_NAME = "readiness_signal_name";
  private String readinessSignalName;

  /**
   * Gets or Sets readinessSignalStatus
   */
  public enum ReadinessSignalStatusEnum {
    READINESS_SIGNALLED("READINESS_SIGNALLED"),
    
    READINESS_NOT_SIGNALLED("READINESS_NOT_SIGNALLED"),
    
    NO_SIGNAL_REQUIRED("NO_SIGNAL_REQUIRED");

    private String value;

    ReadinessSignalStatusEnum(String value) {
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
    public static ReadinessSignalStatusEnum fromValue(String value) {
      for (ReadinessSignalStatusEnum b : ReadinessSignalStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_READINESS_SIGNAL_STATUS = "readiness_signal_status";
  private ReadinessSignalStatusEnum readinessSignalStatus;


  public PendingProtocolUpdate protocolVersion(String protocolVersion) {
    this.protocolVersion = protocolVersion;
    return this;
  }

   /**
   * A name identifying a protocol version.
   * @return protocolVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A name identifying a protocol version.")
  @JsonProperty(JSON_PROPERTY_PROTOCOL_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getProtocolVersion() {
    return protocolVersion;
  }


  @JsonProperty(JSON_PROPERTY_PROTOCOL_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProtocolVersion(String protocolVersion) {
    this.protocolVersion = protocolVersion;
  }


  public PendingProtocolUpdate state(PendingProtocolUpdateState state) {
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

  public PendingProtocolUpdateState getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setState(PendingProtocolUpdateState state) {
    this.state = state;
  }


  public PendingProtocolUpdate readinessSignalName(String readinessSignalName) {
    this.readinessSignalName = readinessSignalName;
    return this;
  }

   /**
   * Get readinessSignalName
   * @return readinessSignalName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_READINESS_SIGNAL_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getReadinessSignalName() {
    return readinessSignalName;
  }


  @JsonProperty(JSON_PROPERTY_READINESS_SIGNAL_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReadinessSignalName(String readinessSignalName) {
    this.readinessSignalName = readinessSignalName;
  }


  public PendingProtocolUpdate readinessSignalStatus(ReadinessSignalStatusEnum readinessSignalStatus) {
    this.readinessSignalStatus = readinessSignalStatus;
    return this;
  }

   /**
   * Get readinessSignalStatus
   * @return readinessSignalStatus
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_READINESS_SIGNAL_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ReadinessSignalStatusEnum getReadinessSignalStatus() {
    return readinessSignalStatus;
  }


  @JsonProperty(JSON_PROPERTY_READINESS_SIGNAL_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setReadinessSignalStatus(ReadinessSignalStatusEnum readinessSignalStatus) {
    this.readinessSignalStatus = readinessSignalStatus;
  }


  /**
   * Return true if this PendingProtocolUpdate object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PendingProtocolUpdate pendingProtocolUpdate = (PendingProtocolUpdate) o;
    return Objects.equals(this.protocolVersion, pendingProtocolUpdate.protocolVersion) &&
        Objects.equals(this.state, pendingProtocolUpdate.state) &&
        Objects.equals(this.readinessSignalName, pendingProtocolUpdate.readinessSignalName) &&
        Objects.equals(this.readinessSignalStatus, pendingProtocolUpdate.readinessSignalStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(protocolVersion, state, readinessSignalName, readinessSignalStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PendingProtocolUpdate {\n");
    sb.append("    protocolVersion: ").append(toIndentedString(protocolVersion)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    readinessSignalName: ").append(toIndentedString(readinessSignalName)).append("\n");
    sb.append("    readinessSignalStatus: ").append(toIndentedString(readinessSignalStatus)).append("\n");
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


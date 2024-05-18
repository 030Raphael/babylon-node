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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * SignificantProtocolUpdateReadinessEntry
 */
@JsonPropertyOrder({
  SignificantProtocolUpdateReadinessEntry.JSON_PROPERTY_READINESS_SIGNAL_NAME,
  SignificantProtocolUpdateReadinessEntry.JSON_PROPERTY_SIGNALLED_STAKE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SignificantProtocolUpdateReadinessEntry {
  public static final String JSON_PROPERTY_READINESS_SIGNAL_NAME = "readiness_signal_name";
  private String readinessSignalName;

  public static final String JSON_PROPERTY_SIGNALLED_STAKE = "signalled_stake";
  private String signalledStake;

  public SignificantProtocolUpdateReadinessEntry() { 
  }

  public SignificantProtocolUpdateReadinessEntry readinessSignalName(String readinessSignalName) {
    this.readinessSignalName = readinessSignalName;
    return this;
  }

   /**
   * Get readinessSignalName
   * @return readinessSignalName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_READINESS_SIGNAL_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getReadinessSignalName() {
    return readinessSignalName;
  }


  @JsonProperty(JSON_PROPERTY_READINESS_SIGNAL_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setReadinessSignalName(String readinessSignalName) {
    this.readinessSignalName = readinessSignalName;
  }


  public SignificantProtocolUpdateReadinessEntry signalledStake(String signalledStake) {
    this.signalledStake = signalledStake;
    return this;
  }

   /**
   * Get signalledStake
   * @return signalledStake
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SIGNALLED_STAKE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getSignalledStake() {
    return signalledStake;
  }


  @JsonProperty(JSON_PROPERTY_SIGNALLED_STAKE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSignalledStake(String signalledStake) {
    this.signalledStake = signalledStake;
  }


  /**
   * Return true if this SignificantProtocolUpdateReadinessEntry object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignificantProtocolUpdateReadinessEntry significantProtocolUpdateReadinessEntry = (SignificantProtocolUpdateReadinessEntry) o;
    return Objects.equals(this.readinessSignalName, significantProtocolUpdateReadinessEntry.readinessSignalName) &&
        Objects.equals(this.signalledStake, significantProtocolUpdateReadinessEntry.signalledStake);
  }

  @Override
  public int hashCode() {
    return Objects.hash(readinessSignalName, signalledStake);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignificantProtocolUpdateReadinessEntry {\n");
    sb.append("    readinessSignalName: ").append(toIndentedString(readinessSignalName)).append("\n");
    sb.append("    signalledStake: ").append(toIndentedString(signalledStake)).append("\n");
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


/*
 * Radix Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.3
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
import com.radixdlt.api.core.generated.models.SignallingValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ProtocolVersionReadiness
 */
@JsonPropertyOrder({
  ProtocolVersionReadiness.JSON_PROPERTY_SIGNALLED_PROTOCOL_VERSION,
  ProtocolVersionReadiness.JSON_PROPERTY_TOTAL_ACTIVE_STAKE_PROPORTION,
  ProtocolVersionReadiness.JSON_PROPERTY_SIGNALLING_VALIDATORS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ProtocolVersionReadiness {
  public static final String JSON_PROPERTY_SIGNALLED_PROTOCOL_VERSION = "signalled_protocol_version";
  private String signalledProtocolVersion;

  public static final String JSON_PROPERTY_TOTAL_ACTIVE_STAKE_PROPORTION = "total_active_stake_proportion";
  private String totalActiveStakeProportion;

  public static final String JSON_PROPERTY_SIGNALLING_VALIDATORS = "signalling_validators";
  private List<SignallingValidator> signallingValidators = new ArrayList<>();

  public ProtocolVersionReadiness() { 
  }

  public ProtocolVersionReadiness signalledProtocolVersion(String signalledProtocolVersion) {
    this.signalledProtocolVersion = signalledProtocolVersion;
    return this;
  }

   /**
   * A name identifying a protocol version. May be absent to denote no readiness signalled by the &#x60;signalling_validators&#x60;. 
   * @return signalledProtocolVersion
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A name identifying a protocol version. May be absent to denote no readiness signalled by the `signalling_validators`. ")
  @JsonProperty(JSON_PROPERTY_SIGNALLED_PROTOCOL_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSignalledProtocolVersion() {
    return signalledProtocolVersion;
  }


  @JsonProperty(JSON_PROPERTY_SIGNALLED_PROTOCOL_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSignalledProtocolVersion(String signalledProtocolVersion) {
    this.signalledProtocolVersion = signalledProtocolVersion;
  }


  public ProtocolVersionReadiness totalActiveStakeProportion(String totalActiveStakeProportion) {
    this.totalActiveStakeProportion = totalActiveStakeProportion;
    return this;
  }

   /**
   * A sum of &#x60;active_stake_proportion&#x60; across &#x60;signalling_validators&#x60; (i.e. an easily-computable convenience field). This is a string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(192 - 1) &lt;&#x3D; m &lt; 2^(192 - 1)&#x60;. 
   * @return totalActiveStakeProportion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A sum of `active_stake_proportion` across `signalling_validators` (i.e. an easily-computable convenience field). This is a string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_TOTAL_ACTIVE_STAKE_PROPORTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTotalActiveStakeProportion() {
    return totalActiveStakeProportion;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL_ACTIVE_STAKE_PROPORTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTotalActiveStakeProportion(String totalActiveStakeProportion) {
    this.totalActiveStakeProportion = totalActiveStakeProportion;
  }


  public ProtocolVersionReadiness signallingValidators(List<SignallingValidator> signallingValidators) {
    this.signallingValidators = signallingValidators;
    return this;
  }

  public ProtocolVersionReadiness addSignallingValidatorsItem(SignallingValidator signallingValidatorsItem) {
    this.signallingValidators.add(signallingValidatorsItem);
    return this;
  }

   /**
   * References to some of the current validators (i.e. a subset of &#x60;current_validator_set&#x60;) which have signalled readiness for the &#x60;signalled_protocol_version&#x60;. 
   * @return signallingValidators
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "References to some of the current validators (i.e. a subset of `current_validator_set`) which have signalled readiness for the `signalled_protocol_version`. ")
  @JsonProperty(JSON_PROPERTY_SIGNALLING_VALIDATORS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<SignallingValidator> getSignallingValidators() {
    return signallingValidators;
  }


  @JsonProperty(JSON_PROPERTY_SIGNALLING_VALIDATORS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSignallingValidators(List<SignallingValidator> signallingValidators) {
    this.signallingValidators = signallingValidators;
  }


  /**
   * Return true if this ProtocolVersionReadiness object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProtocolVersionReadiness protocolVersionReadiness = (ProtocolVersionReadiness) o;
    return Objects.equals(this.signalledProtocolVersion, protocolVersionReadiness.signalledProtocolVersion) &&
        Objects.equals(this.totalActiveStakeProportion, protocolVersionReadiness.totalActiveStakeProportion) &&
        Objects.equals(this.signallingValidators, protocolVersionReadiness.signallingValidators);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signalledProtocolVersion, totalActiveStakeProportion, signallingValidators);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProtocolVersionReadiness {\n");
    sb.append("    signalledProtocolVersion: ").append(toIndentedString(signalledProtocolVersion)).append("\n");
    sb.append("    totalActiveStakeProportion: ").append(toIndentedString(totalActiveStakeProportion)).append("\n");
    sb.append("    signallingValidators: ").append(toIndentedString(signallingValidators)).append("\n");
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


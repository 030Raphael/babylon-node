/*
 * Engine State API - Babylon (Anemone)
 * **This API is currently in Beta**  This specification may experience breaking changes as part of Babylon Node releases. Such changes will be clearly mentioned in the [babylon-node release notes](https://github.com/radixdlt/babylon-node/releases). We advise against using this API for business-critical integrations before the `version` indicated above becomes stable, which is expected in Q4 of 2024.  This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v1.2.1-beta
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.engine_state.generated.models;

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
import com.radixdlt.api.engine_state.generated.models.ErrorDetails;
import com.radixdlt.api.engine_state.generated.models.ErrorType;
import com.radixdlt.api.engine_state.generated.models.RequestedItemInvalidDetails;
import com.radixdlt.api.engine_state.generated.models.RequestedItemNotFoundDetails;
import com.radixdlt.api.engine_state.generated.models.StateVersionInFutureDetails;
import com.radixdlt.api.engine_state.generated.models.StateVersionInTooDistantPastDetails;
import com.radixdlt.api.engine_state.generated.models.StateVersionInTooDistantPastDetailsAllOf;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.engine_state.generated.client.JSON;
/**
 * StateVersionInTooDistantPastDetails
 */
@JsonPropertyOrder({
  StateVersionInTooDistantPastDetails.JSON_PROPERTY_EARLIEST_AVAILABLE_STATE_VERSION
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "error_type", // ignore manually set error_type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the error_type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "error_type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = RequestedItemInvalidDetails.class, name = "RequestedItemInvalid"),
  @JsonSubTypes.Type(value = RequestedItemNotFoundDetails.class, name = "RequestedItemNotFound"),
  @JsonSubTypes.Type(value = StateVersionInFutureDetails.class, name = "StateVersionInFuture"),
  @JsonSubTypes.Type(value = StateVersionInTooDistantPastDetails.class, name = "StateVersionInTooDistantPast"),
})

public class StateVersionInTooDistantPastDetails extends ErrorDetails {
  public static final String JSON_PROPERTY_EARLIEST_AVAILABLE_STATE_VERSION = "earliest_available_state_version";
  private Long earliestAvailableStateVersion;

  public StateVersionInTooDistantPastDetails() { 
  }

  public StateVersionInTooDistantPastDetails earliestAvailableStateVersion(Long earliestAvailableStateVersion) {
    this.earliestAvailableStateVersion = earliestAvailableStateVersion;
    return this;
  }

   /**
   * Get earliestAvailableStateVersion
   * minimum: 1
   * maximum: 100000000000000
   * @return earliestAvailableStateVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_EARLIEST_AVAILABLE_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getEarliestAvailableStateVersion() {
    return earliestAvailableStateVersion;
  }


  @JsonProperty(JSON_PROPERTY_EARLIEST_AVAILABLE_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEarliestAvailableStateVersion(Long earliestAvailableStateVersion) {
    this.earliestAvailableStateVersion = earliestAvailableStateVersion;
  }


  /**
   * Return true if this StateVersionInTooDistantPastDetails object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StateVersionInTooDistantPastDetails stateVersionInTooDistantPastDetails = (StateVersionInTooDistantPastDetails) o;
    return Objects.equals(this.earliestAvailableStateVersion, stateVersionInTooDistantPastDetails.earliestAvailableStateVersion) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(earliestAvailableStateVersion, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StateVersionInTooDistantPastDetails {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    earliestAvailableStateVersion: ").append(toIndentedString(earliestAvailableStateVersion)).append("\n");
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
  mappings.put("RequestedItemInvalid", RequestedItemInvalidDetails.class);
  mappings.put("RequestedItemNotFound", RequestedItemNotFoundDetails.class);
  mappings.put("StateVersionInFuture", StateVersionInFutureDetails.class);
  mappings.put("StateVersionInTooDistantPast", StateVersionInTooDistantPastDetails.class);
  mappings.put("StateVersionInTooDistantPastDetails", StateVersionInTooDistantPastDetails.class);
  JSON.registerDiscriminator(StateVersionInTooDistantPastDetails.class, "error_type", mappings);
}
}


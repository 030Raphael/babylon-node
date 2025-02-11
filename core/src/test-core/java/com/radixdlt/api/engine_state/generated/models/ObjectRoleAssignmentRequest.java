/*
 * Engine State API (Beta)
 * **This API is currently in Beta**  This specification may experience breaking changes as part of Babylon Node releases. Such changes will be clearly mentioned in the [babylon-node release notes](https://github.com/radixdlt/babylon-node/releases). We advise against using this API for business-critical integrations before the `version` indicated above becomes stable, which is expected in Q4 of 2024.  This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v1.3.0
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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.engine_state.generated.models.LedgerStateSelector;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ObjectRoleAssignmentRequest
 */
@JsonPropertyOrder({
  ObjectRoleAssignmentRequest.JSON_PROPERTY_ENTITY_ADDRESS,
  ObjectRoleAssignmentRequest.JSON_PROPERTY_AT_LEDGER_STATE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ObjectRoleAssignmentRequest {
  public static final String JSON_PROPERTY_ENTITY_ADDRESS = "entity_address";
  private String entityAddress;

  public static final String JSON_PROPERTY_AT_LEDGER_STATE = "at_ledger_state";
  private LedgerStateSelector atLedgerState;

  public ObjectRoleAssignmentRequest() { 
  }

  public ObjectRoleAssignmentRequest entityAddress(String entityAddress) {
    this.entityAddress = entityAddress;
    return this;
  }

   /**
   * A Bech32m-encoded, human readable rendering of an arbitrary Entity&#39;s address.
   * @return entityAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A Bech32m-encoded, human readable rendering of an arbitrary Entity's address.")
  @JsonProperty(JSON_PROPERTY_ENTITY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getEntityAddress() {
    return entityAddress;
  }


  @JsonProperty(JSON_PROPERTY_ENTITY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEntityAddress(String entityAddress) {
    this.entityAddress = entityAddress;
  }


  public ObjectRoleAssignmentRequest atLedgerState(LedgerStateSelector atLedgerState) {
    this.atLedgerState = atLedgerState;
    return this;
  }

   /**
   * Get atLedgerState
   * @return atLedgerState
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_AT_LEDGER_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LedgerStateSelector getAtLedgerState() {
    return atLedgerState;
  }


  @JsonProperty(JSON_PROPERTY_AT_LEDGER_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAtLedgerState(LedgerStateSelector atLedgerState) {
    this.atLedgerState = atLedgerState;
  }


  /**
   * Return true if this ObjectRoleAssignmentRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectRoleAssignmentRequest objectRoleAssignmentRequest = (ObjectRoleAssignmentRequest) o;
    return Objects.equals(this.entityAddress, objectRoleAssignmentRequest.entityAddress) &&
        Objects.equals(this.atLedgerState, objectRoleAssignmentRequest.atLedgerState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entityAddress, atLedgerState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectRoleAssignmentRequest {\n");
    sb.append("    entityAddress: ").append(toIndentedString(entityAddress)).append("\n");
    sb.append("    atLedgerState: ").append(toIndentedString(atLedgerState)).append("\n");
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


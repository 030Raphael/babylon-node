/*
 * Babylon Core API - RCnet V2
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
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
import com.radixdlt.api.core.generated.models.AccessRule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * GroupedAuthEntry
 */
@JsonPropertyOrder({
  GroupedAuthEntry.JSON_PROPERTY_GROUP_NAME,
  GroupedAuthEntry.JSON_PROPERTY_ACCESS_RULE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class GroupedAuthEntry {
  public static final String JSON_PROPERTY_GROUP_NAME = "group_name";
  private String groupName;

  public static final String JSON_PROPERTY_ACCESS_RULE = "access_rule";
  private AccessRule accessRule;

  public GroupedAuthEntry() { 
  }

  public GroupedAuthEntry groupName(String groupName) {
    this.groupName = groupName;
    return this;
  }

   /**
   * Get groupName
   * @return groupName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_GROUP_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getGroupName() {
    return groupName;
  }


  @JsonProperty(JSON_PROPERTY_GROUP_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }


  public GroupedAuthEntry accessRule(AccessRule accessRule) {
    this.accessRule = accessRule;
    return this;
  }

   /**
   * Get accessRule
   * @return accessRule
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ACCESS_RULE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public AccessRule getAccessRule() {
    return accessRule;
  }


  @JsonProperty(JSON_PROPERTY_ACCESS_RULE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAccessRule(AccessRule accessRule) {
    this.accessRule = accessRule;
  }


  /**
   * Return true if this GroupedAuthEntry object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupedAuthEntry groupedAuthEntry = (GroupedAuthEntry) o;
    return Objects.equals(this.groupName, groupedAuthEntry.groupName) &&
        Objects.equals(this.accessRule, groupedAuthEntry.accessRule);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupName, accessRule);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupedAuthEntry {\n");
    sb.append("    groupName: ").append(toIndentedString(groupName)).append("\n");
    sb.append("    accessRule: ").append(toIndentedString(accessRule)).append("\n");
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


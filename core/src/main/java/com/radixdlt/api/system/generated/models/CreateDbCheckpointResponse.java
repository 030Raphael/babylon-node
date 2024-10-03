/*
 * Radix System API
 * This API is exposed by the Babylon Radix node to give clients access to information about the node itself, its configuration, status and subsystems.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against ledger state, you may also wish to consider using the [Core API or Gateway API instead](https://docs-babylon.radixdlt.com/main/apis/api-specification.html). 
 *
 * The version of the OpenAPI document: v1.2.4
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * CreateDbCheckpointResponse
 */
@JsonPropertyOrder({
  CreateDbCheckpointResponse.JSON_PROPERTY_CHECKPOINT_RELATIVE_PATH
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CreateDbCheckpointResponse {
  public static final String JSON_PROPERTY_CHECKPOINT_RELATIVE_PATH = "checkpoint_relative_path";
  private String checkpointRelativePath;


  public CreateDbCheckpointResponse checkpointRelativePath(String checkpointRelativePath) {
    this.checkpointRelativePath = checkpointRelativePath;
    return this;
  }

   /**
   * Get checkpointRelativePath
   * @return checkpointRelativePath
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CHECKPOINT_RELATIVE_PATH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCheckpointRelativePath() {
    return checkpointRelativePath;
  }


  @JsonProperty(JSON_PROPERTY_CHECKPOINT_RELATIVE_PATH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCheckpointRelativePath(String checkpointRelativePath) {
    this.checkpointRelativePath = checkpointRelativePath;
  }


  /**
   * Return true if this CreateDbCheckpointResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDbCheckpointResponse createDbCheckpointResponse = (CreateDbCheckpointResponse) o;
    return Objects.equals(this.checkpointRelativePath, createDbCheckpointResponse.checkpointRelativePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(checkpointRelativePath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDbCheckpointResponse {\n");
    sb.append("    checkpointRelativePath: ").append(toIndentedString(checkpointRelativePath)).append("\n");
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


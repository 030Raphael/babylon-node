/*
 * Radix System API - Babylon (Anemone)
 * This API is exposed by the Babylon Radix node to give clients access to information about the node itself, its configuration, status and subsystems.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against ledger state, you may also wish to consider using the [Core API or Gateway API instead](https://docs-babylon.radixdlt.com/main/apis/api-specification.html). 
 *
 * The version of the OpenAPI document: v1.2.1
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
 * MempoolConfiguration
 */
@JsonPropertyOrder({
  MempoolConfiguration.JSON_PROPERTY_MAX_SIZE,
  MempoolConfiguration.JSON_PROPERTY_THROTTLE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MempoolConfiguration {
  public static final String JSON_PROPERTY_MAX_SIZE = "max_size";
  private Integer maxSize;

  public static final String JSON_PROPERTY_THROTTLE = "throttle";
  private Long throttle;


  public MempoolConfiguration maxSize(Integer maxSize) {
    this.maxSize = maxSize;
    return this;
  }

   /**
   * Get maxSize
   * @return maxSize
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_MAX_SIZE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getMaxSize() {
    return maxSize;
  }


  @JsonProperty(JSON_PROPERTY_MAX_SIZE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMaxSize(Integer maxSize) {
    this.maxSize = maxSize;
  }


  public MempoolConfiguration throttle(Long throttle) {
    this.throttle = throttle;
    return this;
  }

   /**
   * Get throttle
   * @return throttle
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_THROTTLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getThrottle() {
    return throttle;
  }


  @JsonProperty(JSON_PROPERTY_THROTTLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setThrottle(Long throttle) {
    this.throttle = throttle;
  }


  /**
   * Return true if this MempoolConfiguration object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MempoolConfiguration mempoolConfiguration = (MempoolConfiguration) o;
    return Objects.equals(this.maxSize, mempoolConfiguration.maxSize) &&
        Objects.equals(this.throttle, mempoolConfiguration.throttle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxSize, throttle);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MempoolConfiguration {\n");
    sb.append("    maxSize: ").append(toIndentedString(maxSize)).append("\n");
    sb.append("    throttle: ").append(toIndentedString(throttle)).append("\n");
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


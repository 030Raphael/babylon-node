/*
 * Babylon Core API - RCnet V1
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.3.0
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
import com.radixdlt.api.core.generated.models.LocalTypeIndex;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * FunctionDefinition
 */
@JsonPropertyOrder({
  FunctionDefinition.JSON_PROPERTY_RECEIVER,
  FunctionDefinition.JSON_PROPERTY_INPUT,
  FunctionDefinition.JSON_PROPERTY_OUTPUT,
  FunctionDefinition.JSON_PROPERTY_EXPORT_NAME
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class FunctionDefinition {
  /**
   * Gets or Sets receiver
   */
  public enum ReceiverEnum {
    FUNCTION("Function"),
    
    COMPONENTREADONLY("ComponentReadOnly"),
    
    COMPONENTMUTABLE("ComponentMutable");

    private String value;

    ReceiverEnum(String value) {
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
    public static ReceiverEnum fromValue(String value) {
      for (ReceiverEnum b : ReceiverEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_RECEIVER = "receiver";
  private ReceiverEnum receiver;

  public static final String JSON_PROPERTY_INPUT = "input";
  private LocalTypeIndex input;

  public static final String JSON_PROPERTY_OUTPUT = "output";
  private LocalTypeIndex output;

  public static final String JSON_PROPERTY_EXPORT_NAME = "export_name";
  private String exportName;

  public FunctionDefinition() { 
  }

  public FunctionDefinition receiver(ReceiverEnum receiver) {
    this.receiver = receiver;
    return this;
  }

   /**
   * Get receiver
   * @return receiver
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_RECEIVER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ReceiverEnum getReceiver() {
    return receiver;
  }


  @JsonProperty(JSON_PROPERTY_RECEIVER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setReceiver(ReceiverEnum receiver) {
    this.receiver = receiver;
  }


  public FunctionDefinition input(LocalTypeIndex input) {
    this.input = input;
    return this;
  }

   /**
   * Get input
   * @return input
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_INPUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public LocalTypeIndex getInput() {
    return input;
  }


  @JsonProperty(JSON_PROPERTY_INPUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setInput(LocalTypeIndex input) {
    this.input = input;
  }


  public FunctionDefinition output(LocalTypeIndex output) {
    this.output = output;
    return this;
  }

   /**
   * Get output
   * @return output
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_OUTPUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public LocalTypeIndex getOutput() {
    return output;
  }


  @JsonProperty(JSON_PROPERTY_OUTPUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOutput(LocalTypeIndex output) {
    this.output = output;
  }


  public FunctionDefinition exportName(String exportName) {
    this.exportName = exportName;
    return this;
  }

   /**
   * Get exportName
   * @return exportName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_EXPORT_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getExportName() {
    return exportName;
  }


  @JsonProperty(JSON_PROPERTY_EXPORT_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExportName(String exportName) {
    this.exportName = exportName;
  }


  /**
   * Return true if this FunctionDefinition object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FunctionDefinition functionDefinition = (FunctionDefinition) o;
    return Objects.equals(this.receiver, functionDefinition.receiver) &&
        Objects.equals(this.input, functionDefinition.input) &&
        Objects.equals(this.output, functionDefinition.output) &&
        Objects.equals(this.exportName, functionDefinition.exportName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(receiver, input, output, exportName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FunctionDefinition {\n");
    sb.append("    receiver: ").append(toIndentedString(receiver)).append("\n");
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
    sb.append("    output: ").append(toIndentedString(output)).append("\n");
    sb.append("    exportName: ").append(toIndentedString(exportName)).append("\n");
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


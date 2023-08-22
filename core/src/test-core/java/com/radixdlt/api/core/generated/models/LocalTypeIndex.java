/*
 * Babylon Core API - RCnet v3
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
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
import com.radixdlt.api.core.generated.models.SborData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * LocalTypeIndex
 */
@JsonPropertyOrder({
  LocalTypeIndex.JSON_PROPERTY_KIND,
  LocalTypeIndex.JSON_PROPERTY_INDEX,
  LocalTypeIndex.JSON_PROPERTY_AS_SBOR
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class LocalTypeIndex {
  /**
   * The location against which to resolve this type reference.
   */
  public enum KindEnum {
    WELLKNOWN("WellKnown"),
    
    SCHEMALOCAL("SchemaLocal");

    private String value;

    KindEnum(String value) {
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
    public static KindEnum fromValue(String value) {
      for (KindEnum b : KindEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_KIND = "kind";
  private KindEnum kind;

  public static final String JSON_PROPERTY_INDEX = "index";
  private Long index;

  public static final String JSON_PROPERTY_AS_SBOR = "as_sbor";
  private SborData asSbor;

  public LocalTypeIndex() { 
  }

  public LocalTypeIndex kind(KindEnum kind) {
    this.kind = kind;
    return this;
  }

   /**
   * The location against which to resolve this type reference.
   * @return kind
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The location against which to resolve this type reference.")
  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public KindEnum getKind() {
    return kind;
  }


  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKind(KindEnum kind) {
    this.kind = kind;
  }


  public LocalTypeIndex index(Long index) {
    this.index = index;
    return this;
  }

   /**
   * A reference to a type, interpreted according to &#x60;kind&#x60;: - if &#x60;WellKnown&#x60;, then it is a pointer to a well known scrypto type with that ID, - if &#x60;SchemaLocal&#x60;, then it is a pointer into the given schema. 
   * minimum: 0
   * maximum: 4294967295
   * @return index
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A reference to a type, interpreted according to `kind`: - if `WellKnown`, then it is a pointer to a well known scrypto type with that ID, - if `SchemaLocal`, then it is a pointer into the given schema. ")
  @JsonProperty(JSON_PROPERTY_INDEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getIndex() {
    return index;
  }


  @JsonProperty(JSON_PROPERTY_INDEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIndex(Long index) {
    this.index = index;
  }


  public LocalTypeIndex asSbor(SborData asSbor) {
    this.asSbor = asSbor;
    return this;
  }

   /**
   * Get asSbor
   * @return asSbor
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_AS_SBOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SborData getAsSbor() {
    return asSbor;
  }


  @JsonProperty(JSON_PROPERTY_AS_SBOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAsSbor(SborData asSbor) {
    this.asSbor = asSbor;
  }


  /**
   * Return true if this LocalTypeIndex object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocalTypeIndex localTypeIndex = (LocalTypeIndex) o;
    return Objects.equals(this.kind, localTypeIndex.kind) &&
        Objects.equals(this.index, localTypeIndex.index) &&
        Objects.equals(this.asSbor, localTypeIndex.asSbor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, index, asSbor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocalTypeIndex {\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    asSbor: ").append(toIndentedString(asSbor)).append("\n");
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


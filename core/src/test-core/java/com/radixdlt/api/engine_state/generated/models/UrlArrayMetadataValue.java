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
import com.radixdlt.api.engine_state.generated.models.BoolArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.BoolMetadataValue;
import com.radixdlt.api.engine_state.generated.models.DecimalArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.DecimalMetadataValue;
import com.radixdlt.api.engine_state.generated.models.GlobalAddressArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.GlobalAddressMetadataValue;
import com.radixdlt.api.engine_state.generated.models.I32ArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.I32MetadataValue;
import com.radixdlt.api.engine_state.generated.models.I64ArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.I64MetadataValue;
import com.radixdlt.api.engine_state.generated.models.InstantArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.InstantMetadataValue;
import com.radixdlt.api.engine_state.generated.models.MetadataValue;
import com.radixdlt.api.engine_state.generated.models.MetadataValueType;
import com.radixdlt.api.engine_state.generated.models.NonFungibleGlobalIdArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.NonFungibleGlobalIdMetadataValue;
import com.radixdlt.api.engine_state.generated.models.NonFungibleLocalIdArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.NonFungibleLocalIdMetadataValue;
import com.radixdlt.api.engine_state.generated.models.OriginArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.OriginMetadataValue;
import com.radixdlt.api.engine_state.generated.models.PublicKeyArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.PublicKeyHashArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.PublicKeyHashMetadataValue;
import com.radixdlt.api.engine_state.generated.models.PublicKeyMetadataValue;
import com.radixdlt.api.engine_state.generated.models.StringArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.StringArrayMetadataValueAllOf;
import com.radixdlt.api.engine_state.generated.models.StringMetadataValue;
import com.radixdlt.api.engine_state.generated.models.U32ArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.U32MetadataValue;
import com.radixdlt.api.engine_state.generated.models.U64ArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.U64MetadataValue;
import com.radixdlt.api.engine_state.generated.models.U8ArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.U8MetadataValue;
import com.radixdlt.api.engine_state.generated.models.UrlArrayMetadataValue;
import com.radixdlt.api.engine_state.generated.models.UrlMetadataValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.engine_state.generated.client.JSON;
/**
 * UrlArrayMetadataValue
 */
@JsonPropertyOrder({
  UrlArrayMetadataValue.JSON_PROPERTY_VALUE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = BoolMetadataValue.class, name = "Bool"),
  @JsonSubTypes.Type(value = BoolArrayMetadataValue.class, name = "BoolArray"),
  @JsonSubTypes.Type(value = DecimalMetadataValue.class, name = "Decimal"),
  @JsonSubTypes.Type(value = DecimalArrayMetadataValue.class, name = "DecimalArray"),
  @JsonSubTypes.Type(value = GlobalAddressMetadataValue.class, name = "GlobalAddress"),
  @JsonSubTypes.Type(value = GlobalAddressArrayMetadataValue.class, name = "GlobalAddressArray"),
  @JsonSubTypes.Type(value = I32MetadataValue.class, name = "I32"),
  @JsonSubTypes.Type(value = I32ArrayMetadataValue.class, name = "I32Array"),
  @JsonSubTypes.Type(value = I64MetadataValue.class, name = "I64"),
  @JsonSubTypes.Type(value = I64ArrayMetadataValue.class, name = "I64Array"),
  @JsonSubTypes.Type(value = InstantMetadataValue.class, name = "Instant"),
  @JsonSubTypes.Type(value = InstantArrayMetadataValue.class, name = "InstantArray"),
  @JsonSubTypes.Type(value = NonFungibleGlobalIdMetadataValue.class, name = "NonFungibleGlobalId"),
  @JsonSubTypes.Type(value = NonFungibleGlobalIdArrayMetadataValue.class, name = "NonFungibleGlobalIdArray"),
  @JsonSubTypes.Type(value = NonFungibleLocalIdMetadataValue.class, name = "NonFungibleLocalId"),
  @JsonSubTypes.Type(value = NonFungibleLocalIdArrayMetadataValue.class, name = "NonFungibleLocalIdArray"),
  @JsonSubTypes.Type(value = OriginMetadataValue.class, name = "Origin"),
  @JsonSubTypes.Type(value = OriginArrayMetadataValue.class, name = "OriginArray"),
  @JsonSubTypes.Type(value = PublicKeyMetadataValue.class, name = "PublicKey"),
  @JsonSubTypes.Type(value = PublicKeyArrayMetadataValue.class, name = "PublicKeyArray"),
  @JsonSubTypes.Type(value = PublicKeyHashMetadataValue.class, name = "PublicKeyHash"),
  @JsonSubTypes.Type(value = PublicKeyHashArrayMetadataValue.class, name = "PublicKeyHashArray"),
  @JsonSubTypes.Type(value = StringMetadataValue.class, name = "String"),
  @JsonSubTypes.Type(value = StringArrayMetadataValue.class, name = "StringArray"),
  @JsonSubTypes.Type(value = U32MetadataValue.class, name = "U32"),
  @JsonSubTypes.Type(value = U32ArrayMetadataValue.class, name = "U32Array"),
  @JsonSubTypes.Type(value = U64MetadataValue.class, name = "U64"),
  @JsonSubTypes.Type(value = U64ArrayMetadataValue.class, name = "U64Array"),
  @JsonSubTypes.Type(value = U8MetadataValue.class, name = "U8"),
  @JsonSubTypes.Type(value = U8ArrayMetadataValue.class, name = "U8Array"),
  @JsonSubTypes.Type(value = UrlMetadataValue.class, name = "Url"),
  @JsonSubTypes.Type(value = UrlArrayMetadataValue.class, name = "UrlArray"),
})

public class UrlArrayMetadataValue extends MetadataValue {
  public static final String JSON_PROPERTY_VALUE = "value";
  private List<String> value = new ArrayList<>();

  public UrlArrayMetadataValue() { 
  }

  public UrlArrayMetadataValue value(List<String> value) {
    this.value = value;
    return this;
  }

  public UrlArrayMetadataValue addValueItem(String valueItem) {
    this.value.add(valueItem);
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getValue() {
    return value;
  }


  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValue(List<String> value) {
    this.value = value;
  }


  /**
   * Return true if this UrlArrayMetadataValue object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UrlArrayMetadataValue urlArrayMetadataValue = (UrlArrayMetadataValue) o;
    return Objects.equals(this.value, urlArrayMetadataValue.value) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UrlArrayMetadataValue {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
  mappings.put("Bool", BoolMetadataValue.class);
  mappings.put("BoolArray", BoolArrayMetadataValue.class);
  mappings.put("Decimal", DecimalMetadataValue.class);
  mappings.put("DecimalArray", DecimalArrayMetadataValue.class);
  mappings.put("GlobalAddress", GlobalAddressMetadataValue.class);
  mappings.put("GlobalAddressArray", GlobalAddressArrayMetadataValue.class);
  mappings.put("I32", I32MetadataValue.class);
  mappings.put("I32Array", I32ArrayMetadataValue.class);
  mappings.put("I64", I64MetadataValue.class);
  mappings.put("I64Array", I64ArrayMetadataValue.class);
  mappings.put("Instant", InstantMetadataValue.class);
  mappings.put("InstantArray", InstantArrayMetadataValue.class);
  mappings.put("NonFungibleGlobalId", NonFungibleGlobalIdMetadataValue.class);
  mappings.put("NonFungibleGlobalIdArray", NonFungibleGlobalIdArrayMetadataValue.class);
  mappings.put("NonFungibleLocalId", NonFungibleLocalIdMetadataValue.class);
  mappings.put("NonFungibleLocalIdArray", NonFungibleLocalIdArrayMetadataValue.class);
  mappings.put("Origin", OriginMetadataValue.class);
  mappings.put("OriginArray", OriginArrayMetadataValue.class);
  mappings.put("PublicKey", PublicKeyMetadataValue.class);
  mappings.put("PublicKeyArray", PublicKeyArrayMetadataValue.class);
  mappings.put("PublicKeyHash", PublicKeyHashMetadataValue.class);
  mappings.put("PublicKeyHashArray", PublicKeyHashArrayMetadataValue.class);
  mappings.put("String", StringMetadataValue.class);
  mappings.put("StringArray", StringArrayMetadataValue.class);
  mappings.put("U32", U32MetadataValue.class);
  mappings.put("U32Array", U32ArrayMetadataValue.class);
  mappings.put("U64", U64MetadataValue.class);
  mappings.put("U64Array", U64ArrayMetadataValue.class);
  mappings.put("U8", U8MetadataValue.class);
  mappings.put("U8Array", U8ArrayMetadataValue.class);
  mappings.put("Url", UrlMetadataValue.class);
  mappings.put("UrlArray", UrlArrayMetadataValue.class);
  mappings.put("UrlArrayMetadataValue", UrlArrayMetadataValue.class);
  JSON.registerDiscriminator(UrlArrayMetadataValue.class, "type", mappings);
}
}


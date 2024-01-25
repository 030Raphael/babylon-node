/*
 * Radix Core API - Babylon (Anemone)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.1.0
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.BasicErrorResponse;
import com.radixdlt.api.core.generated.models.ErrorResponse;
import com.radixdlt.api.core.generated.models.ErrorResponseType;
import com.radixdlt.api.core.generated.models.LtsTransactionSubmitErrorDetails;
import com.radixdlt.api.core.generated.models.LtsTransactionSubmitErrorResponse;
import com.radixdlt.api.core.generated.models.LtsTransactionSubmitErrorResponseAllOf;
import com.radixdlt.api.core.generated.models.StreamProofsErrorResponse;
import com.radixdlt.api.core.generated.models.StreamTransactionsErrorResponse;
import com.radixdlt.api.core.generated.models.TransactionSubmitErrorResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * LtsTransactionSubmitErrorResponse
 */
@JsonPropertyOrder({
  LtsTransactionSubmitErrorResponse.JSON_PROPERTY_DETAILS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "error_type", // ignore manually set error_type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the error_type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "error_type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = BasicErrorResponse.class, name = "Basic"),
  @JsonSubTypes.Type(value = LtsTransactionSubmitErrorResponse.class, name = "LtsTransactionSubmit"),
  @JsonSubTypes.Type(value = StreamProofsErrorResponse.class, name = "StreamProofs"),
  @JsonSubTypes.Type(value = StreamTransactionsErrorResponse.class, name = "StreamTransactions"),
  @JsonSubTypes.Type(value = TransactionSubmitErrorResponse.class, name = "TransactionSubmit"),
})

public class LtsTransactionSubmitErrorResponse extends ErrorResponse {
  public static final String JSON_PROPERTY_DETAILS = "details";
  private LtsTransactionSubmitErrorDetails details;

  public LtsTransactionSubmitErrorResponse() { 
  }

  public LtsTransactionSubmitErrorResponse details(LtsTransactionSubmitErrorDetails details) {
    this.details = details;
    return this;
  }

   /**
   * Get details
   * @return details
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LtsTransactionSubmitErrorDetails getDetails() {
    return details;
  }


  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetails(LtsTransactionSubmitErrorDetails details) {
    this.details = details;
  }


  /**
   * Return true if this LtsTransactionSubmitErrorResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LtsTransactionSubmitErrorResponse ltsTransactionSubmitErrorResponse = (LtsTransactionSubmitErrorResponse) o;
    return Objects.equals(this.details, ltsTransactionSubmitErrorResponse.details) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(details, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LtsTransactionSubmitErrorResponse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
  mappings.put("Basic", BasicErrorResponse.class);
  mappings.put("LtsTransactionSubmit", LtsTransactionSubmitErrorResponse.class);
  mappings.put("StreamProofs", StreamProofsErrorResponse.class);
  mappings.put("StreamTransactions", StreamTransactionsErrorResponse.class);
  mappings.put("TransactionSubmit", TransactionSubmitErrorResponse.class);
  mappings.put("LtsTransactionSubmitErrorResponse", LtsTransactionSubmitErrorResponse.class);
  JSON.registerDiscriminator(LtsTransactionSubmitErrorResponse.class, "error_type", mappings);
}
}


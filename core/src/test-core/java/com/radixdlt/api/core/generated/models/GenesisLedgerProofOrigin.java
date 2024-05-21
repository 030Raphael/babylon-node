/*
 * Radix Core API - Babylon (Bottlenose)
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.2.1
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
import com.radixdlt.api.core.generated.models.ConsensusLedgerProofOrigin;
import com.radixdlt.api.core.generated.models.GenesisLedgerProofOrigin;
import com.radixdlt.api.core.generated.models.GenesisLedgerProofOriginAllOf;
import com.radixdlt.api.core.generated.models.LedgerProofOrigin;
import com.radixdlt.api.core.generated.models.LedgerProofOriginType;
import com.radixdlt.api.core.generated.models.ProtocolUpdateLedgerProofOrigin;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * GenesisLedgerProofOrigin
 */
@JsonPropertyOrder({
  GenesisLedgerProofOrigin.JSON_PROPERTY_GENESIS_OPAQUE_HASH
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = ConsensusLedgerProofOrigin.class, name = "Consensus"),
  @JsonSubTypes.Type(value = GenesisLedgerProofOrigin.class, name = "Genesis"),
  @JsonSubTypes.Type(value = ProtocolUpdateLedgerProofOrigin.class, name = "ProtocolUpdate"),
})

public class GenesisLedgerProofOrigin extends LedgerProofOrigin {
  public static final String JSON_PROPERTY_GENESIS_OPAQUE_HASH = "genesis_opaque_hash";
  private String genesisOpaqueHash;

  public GenesisLedgerProofOrigin() { 
  }

  public GenesisLedgerProofOrigin genesisOpaqueHash(String genesisOpaqueHash) {
    this.genesisOpaqueHash = genesisOpaqueHash;
    return this;
  }

   /**
   * Get genesisOpaqueHash
   * @return genesisOpaqueHash
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_GENESIS_OPAQUE_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getGenesisOpaqueHash() {
    return genesisOpaqueHash;
  }


  @JsonProperty(JSON_PROPERTY_GENESIS_OPAQUE_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGenesisOpaqueHash(String genesisOpaqueHash) {
    this.genesisOpaqueHash = genesisOpaqueHash;
  }


  /**
   * Return true if this GenesisLedgerProofOrigin object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenesisLedgerProofOrigin genesisLedgerProofOrigin = (GenesisLedgerProofOrigin) o;
    return Objects.equals(this.genesisOpaqueHash, genesisLedgerProofOrigin.genesisOpaqueHash) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(genesisOpaqueHash, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenesisLedgerProofOrigin {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    genesisOpaqueHash: ").append(toIndentedString(genesisOpaqueHash)).append("\n");
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
  mappings.put("Consensus", ConsensusLedgerProofOrigin.class);
  mappings.put("Genesis", GenesisLedgerProofOrigin.class);
  mappings.put("ProtocolUpdate", ProtocolUpdateLedgerProofOrigin.class);
  mappings.put("GenesisLedgerProofOrigin", GenesisLedgerProofOrigin.class);
  JSON.registerDiscriminator(GenesisLedgerProofOrigin.class, "type", mappings);
}
}


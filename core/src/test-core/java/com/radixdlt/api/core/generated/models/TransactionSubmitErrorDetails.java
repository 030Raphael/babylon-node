/*
 * Babylon Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.2.0
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
import com.radixdlt.api.core.generated.models.TransactionSubmitErrorDetailsType;
import com.radixdlt.api.core.generated.models.TransactionSubmitMempoolFullErrorDetails;
import com.radixdlt.api.core.generated.models.TransactionSubmitRejectedErrorDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.radixdlt.api.core.generated.client.JSON;

@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonDeserialize(using=TransactionSubmitErrorDetails.TransactionSubmitErrorDetailsDeserializer.class)
@JsonSerialize(using = TransactionSubmitErrorDetails.TransactionSubmitErrorDetailsSerializer.class)
public class TransactionSubmitErrorDetails extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(TransactionSubmitErrorDetails.class.getName());

    public static class TransactionSubmitErrorDetailsSerializer extends StdSerializer<TransactionSubmitErrorDetails> {
        public TransactionSubmitErrorDetailsSerializer(Class<TransactionSubmitErrorDetails> t) {
            super(t);
        }

        public TransactionSubmitErrorDetailsSerializer() {
            this(null);
        }

        @Override
        public void serialize(TransactionSubmitErrorDetails value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class TransactionSubmitErrorDetailsDeserializer extends StdDeserializer<TransactionSubmitErrorDetails> {
        public TransactionSubmitErrorDetailsDeserializer() {
            this(TransactionSubmitErrorDetails.class);
        }

        public TransactionSubmitErrorDetailsDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public TransactionSubmitErrorDetails deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            Class<?> cls = JSON.getClassForElement(tree, TransactionSubmitErrorDetails.class);
            if (cls != null) {
                // When the OAS schema includes a discriminator, use the discriminator value to
                // discriminate the anyOf schemas.
                // Get the discriminator mapping value to get the class.
                deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
                TransactionSubmitErrorDetails ret = new TransactionSubmitErrorDetails();
                ret.setActualInstance(deserialized);
                return ret;
            }
            // deserialize TransactionSubmitMempoolFullErrorDetails
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(TransactionSubmitMempoolFullErrorDetails.class);
                TransactionSubmitErrorDetails ret = new TransactionSubmitErrorDetails();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'TransactionSubmitErrorDetails'", e);
            }

            // deserialize TransactionSubmitRejectedErrorDetails
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(TransactionSubmitRejectedErrorDetails.class);
                TransactionSubmitErrorDetails ret = new TransactionSubmitErrorDetails();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'TransactionSubmitErrorDetails'", e);
            }

            throw new IOException(String.format("Failed deserialization for TransactionSubmitErrorDetails: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public TransactionSubmitErrorDetails getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "TransactionSubmitErrorDetails cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public TransactionSubmitErrorDetails() {
        super("anyOf", Boolean.FALSE);
    }

    public TransactionSubmitErrorDetails(TransactionSubmitMempoolFullErrorDetails o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public TransactionSubmitErrorDetails(TransactionSubmitRejectedErrorDetails o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("TransactionSubmitMempoolFullErrorDetails", TransactionSubmitMempoolFullErrorDetails.class);
        schemas.put("TransactionSubmitRejectedErrorDetails", TransactionSubmitRejectedErrorDetails.class);
        JSON.registerDescendants(TransactionSubmitErrorDetails.class, Collections.unmodifiableMap(schemas));
        // Initialize and register the discriminator mappings.
        Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
        mappings.put("MempoolFull", TransactionSubmitMempoolFullErrorDetails.class);
        mappings.put("Rejected", TransactionSubmitRejectedErrorDetails.class);
        mappings.put("TransactionSubmitMempoolFullErrorDetails", TransactionSubmitMempoolFullErrorDetails.class);
        mappings.put("TransactionSubmitRejectedErrorDetails", TransactionSubmitRejectedErrorDetails.class);
        mappings.put("TransactionSubmitErrorDetails", TransactionSubmitErrorDetails.class);
        JSON.registerDiscriminator(TransactionSubmitErrorDetails.class, "type", mappings);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return TransactionSubmitErrorDetails.schemas;
    }

    /**
     * Set the instance that matches the anyOf child schema, check
     * the instance parameter is valid against the anyOf child schemas:
     * TransactionSubmitMempoolFullErrorDetails, TransactionSubmitRejectedErrorDetails
     *
     * It could be an instance of the 'anyOf' schemas.
     * The anyOf child schemas may themselves be a composed schema (allOf, anyOf, anyOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(TransactionSubmitMempoolFullErrorDetails.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(TransactionSubmitRejectedErrorDetails.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be TransactionSubmitMempoolFullErrorDetails, TransactionSubmitRejectedErrorDetails");
    }

    /**
     * Get the actual instance, which can be the following:
     * TransactionSubmitMempoolFullErrorDetails, TransactionSubmitRejectedErrorDetails
     *
     * @return The actual instance (TransactionSubmitMempoolFullErrorDetails, TransactionSubmitRejectedErrorDetails)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `TransactionSubmitMempoolFullErrorDetails`. If the actual instance is not `TransactionSubmitMempoolFullErrorDetails`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `TransactionSubmitMempoolFullErrorDetails`
     * @throws ClassCastException if the instance is not `TransactionSubmitMempoolFullErrorDetails`
     */
    public TransactionSubmitMempoolFullErrorDetails getTransactionSubmitMempoolFullErrorDetails() throws ClassCastException {
        return (TransactionSubmitMempoolFullErrorDetails)super.getActualInstance();
    }

    /**
     * Get the actual instance of `TransactionSubmitRejectedErrorDetails`. If the actual instance is not `TransactionSubmitRejectedErrorDetails`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `TransactionSubmitRejectedErrorDetails`
     * @throws ClassCastException if the instance is not `TransactionSubmitRejectedErrorDetails`
     */
    public TransactionSubmitRejectedErrorDetails getTransactionSubmitRejectedErrorDetails() throws ClassCastException {
        return (TransactionSubmitRejectedErrorDetails)super.getActualInstance();
    }

}


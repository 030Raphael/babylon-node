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

import com.radixdlt.api.engine_state.generated.client.ApiException;
import java.util.Objects;
import java.lang.reflect.Type;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Abstract class for oneOf,anyOf schemas defined in OpenAPI spec
 */
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public abstract class AbstractOpenApiSchema {

    // store the actual instance of the schema/object
    private Object instance;

    // is nullable
    private Boolean isNullable;

    // schema type (e.g. oneOf, anyOf)
    private final String schemaType;

    public AbstractOpenApiSchema(String schemaType, Boolean isNullable) {
        this.schemaType = schemaType;
        this.isNullable = isNullable;
    }

    /**
     * Get the list of oneOf/anyOf composed schemas allowed to be stored in this object
     *
     * @return an instance of the actual schema/object
     */
    public abstract Map<String, Class<?>> getSchemas();

    /**
     * Get the actual instance
     *
     * @return an instance of the actual schema/object
     */
    @JsonValue
    public Object getActualInstance() {return instance;}

    /**
     * Set the actual instance
     *
     * @param instance the actual instance of the schema/object
     */
    public void setActualInstance(Object instance) {this.instance = instance;}

    /**
     * Get the instant recursively when the schemas defined in oneOf/anyof happen to be oneOf/anyOf schema as well
     *
     * @return an instance of the actual schema/object
     */
    public Object getActualInstanceRecursively() {
        return getActualInstanceRecursively(this);
    }

    private Object getActualInstanceRecursively(AbstractOpenApiSchema object) {
        if (object.getActualInstance() == null) {
            return null;
        } else if (object.getActualInstance() instanceof AbstractOpenApiSchema) {
            return getActualInstanceRecursively((AbstractOpenApiSchema)object.getActualInstance());
        } else {
            return object.getActualInstance();
        }
    }

    /**
     * Get the schema type (e.g. anyOf, oneOf)
     *
     * @return the schema type
     */
    public String getSchemaType() {
        return schemaType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ").append(getClass()).append(" {\n");
        sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
        sb.append("    isNullable: ").append(toIndentedString(isNullable)).append("\n");
        sb.append("    schemaType: ").append(toIndentedString(schemaType)).append("\n");
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

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractOpenApiSchema a = (AbstractOpenApiSchema) o;
        return Objects.equals(this.instance, a.instance) &&
            Objects.equals(this.isNullable, a.isNullable) &&
            Objects.equals(this.schemaType, a.schemaType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instance, isNullable, schemaType);
    }

    /**
     * Is nullable
     *
     * @return true if it's nullable
     */
    public Boolean isNullable() {
        if (Boolean.TRUE.equals(isNullable)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }



}

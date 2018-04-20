package com.okta.sdk.models.directory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.okta.sdk.framework.ApiObject;

import java.util.Map;
import java.util.Objects;

/**
 * Represents a JSON Schema Draft 4 description of user fields and validation
 */
public class JsonSchema extends ApiObject {

    @JsonProperty("properties")
    private Map<String, JsonSchemaProperty> properties;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonSchema that = (JsonSchema) o;
        return Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(properties);
    }

    public Map<String, JsonSchemaProperty> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, JsonSchemaProperty> properties) {
        this.properties = properties;
    }
}

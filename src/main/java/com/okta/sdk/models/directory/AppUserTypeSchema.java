package com.okta.sdk.models.directory;

import com.okta.sdk.framework.ApiObject;

import java.util.Objects;

public class AppUserTypeSchema extends ApiObject {

    /**
     * Unique ID of this user type schema
     */
    private String id;

    /**
     * Display name of this user type schema
     */
    private String displayName;

    /**
     * Name of this user type schema
     */
    private String name;

    /**
     * JSON Schema Draft 4 description of user fields and validation
     */
    private JsonSchema schema;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserTypeSchema that = (AppUserTypeSchema) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(displayName, that.displayName) &&
                Objects.equals(name, that.name) &&
                Objects.equals(schema, that.schema);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, displayName, name, schema);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonSchema getSchema() {
        return schema;
    }

    public void setSchema(JsonSchema schema) {
        this.schema = schema;
    }
}

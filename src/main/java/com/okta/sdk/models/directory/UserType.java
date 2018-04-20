package com.okta.sdk.models.directory;

import com.okta.sdk.framework.ApiObject;

import java.util.List;
import java.util.Objects;

public class UserType extends ApiObject {

    /**
     * Unique ID of this user type
     */
    private String id;

    /**
     * Display name of this user type
     */
    private String displayName;

    /**
     * Name of this user type
     */
    private String name;

    /**
     * Name of this user type
     */
    private String description;

//    /**
//     * HATEOAS links including app and schemas
//     */
//    @JsonSerialize(
//            include = JsonSerialize.Inclusion.NON_EMPTY
//    )
//    @JsonProperty("_links")
//    private Map<String, LinksUnion> links;

    /**
     * Names of schemas related for this user type
     */
    private List<String> schemas;

    /**
     * Whether or not this user type is default
     * FIXME: what does this mean?
     */
    private boolean isDefault;

    /**
     * Type of this user type
     * IMPORTED or ?
     * FIXME: clarify accepted values for this
     */
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserType that = (UserType) o;
        return isDefault == that.isDefault &&
                Objects.equals(id, that.id) &&
                Objects.equals(displayName, that.displayName) &&
                Objects.equals(name, that.name) &&
                Objects.equals(schemas, that.schemas) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, displayName, name, isDefault, schemas, type);
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

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public List<String> getSchemas() {
        return schemas;
    }

    public void setSchemas(List<String> schemas) {
        this.schemas = schemas;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

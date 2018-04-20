package com.okta.sdk.models.directory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.okta.sdk.framework.ApiObject;

import java.util.Objects;

/**
 * Represents a JSON Schema Draft 4 property
 */
public class JsonSchemaProperty extends ApiObject {

    private String title;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String description;

    private String type;

    private boolean required;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String mutability;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String scope;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String validationType;

    private String externalName;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int maxLength;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonSchemaProperty that = (JsonSchemaProperty) o;
        return required == that.required &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(type, that.type) &&
                Objects.equals(mutability, that.mutability) &&
                Objects.equals(scope, that.scope) &&
                Objects.equals(validationType, that.validationType) &&
                Objects.equals(externalName, that.externalName) &&
                Objects.equals(maxLength, that.maxLength);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, description, type, required, mutability, scope, validationType, externalName, maxLength);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getMutability() {
        return mutability;
    }

    public void setMutability(String mutability) {
        this.mutability = mutability;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getValidationType() {
        return validationType;
    }

    public void setValidationType(String validationType) {
        this.validationType = validationType;
    }

    public String getExternalName() {
        return externalName;
    }

    public void setExternalName(String externalName) {
        this.externalName = externalName;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
}

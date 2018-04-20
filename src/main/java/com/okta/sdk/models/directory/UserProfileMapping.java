package com.okta.sdk.models.directory;

import com.okta.sdk.framework.ApiObject;

import java.util.List;
import java.util.Objects;

public class UserProfileMapping extends ApiObject {

    /**
     * ID of the {@link AppUserTypeSchema} to map attributes from
     */
    private String sourceId;

    /**
     * ID of the {@link AppUserTypeSchema} to map attributes to
     */
    private String targetId;

    private List<UserProfilePropertyMapping> propertyMappings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileMapping that = (UserProfileMapping) o;
        return Objects.equals(sourceId, that.sourceId) &&
                Objects.equals(targetId, that.targetId) &&
                Objects.equals(propertyMappings, that.propertyMappings);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sourceId, targetId, propertyMappings);
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public List<UserProfilePropertyMapping> getPropertyMappings() {
        return propertyMappings;
    }

    public void setPropertyMappings(List<UserProfilePropertyMapping> propertyMappings) {
        this.propertyMappings = propertyMappings;
    }
}

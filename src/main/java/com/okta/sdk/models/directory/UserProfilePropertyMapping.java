package com.okta.sdk.models.directory;

import java.util.Objects;

public class UserProfilePropertyMapping {
    /**
     * Field to update in the target {@link com.okta.sdk.models.apps.AppUser}
     */
    private String targetField;

    /**
     * Expression to obtain the value from the source {@link com.okta.sdk.models.apps.AppUser}
     */
    private String sourceExpression;

    /**
     * Push status
     * FIXME: what is this?
     */
    private String pushStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfilePropertyMapping that = (UserProfilePropertyMapping) o;
        return Objects.equals(targetField, that.targetField) &&
                Objects.equals(sourceExpression, that.sourceExpression) &&
                Objects.equals(pushStatus, that.pushStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(targetField, sourceExpression, pushStatus);
    }

    public String getTargetField() {
        return targetField;
    }

    public void setTargetField(String targetField) {
        this.targetField = targetField;
    }

    public String getSourceExpression() {
        return sourceExpression;
    }

    public void setSourceExpression(String sourceExpression) {
        this.sourceExpression = sourceExpression;
    }

    public String getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(String pushStatus) {
        this.pushStatus = pushStatus;
    }
}

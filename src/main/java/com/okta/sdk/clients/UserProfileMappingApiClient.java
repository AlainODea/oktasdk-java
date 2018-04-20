package com.okta.sdk.clients;

import com.fasterxml.jackson.core.type.TypeReference;
import com.okta.sdk.framework.ApiClientConfiguration;
import com.okta.sdk.framework.JsonApiClient;
import com.okta.sdk.models.directory.UserProfileMapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * NOT PUBLIC API. This has been reverse-engineered by observing Okta Admin UI
 *
 * This is not a committed API by Okta and could be changed or removed with
 * no prior notice.
 */
public class UserProfileMappingApiClient extends JsonApiClient {

    public UserProfileMappingApiClient(ApiClientConfiguration config) {
        super(config);
    }

    /**
     * Get the {@link UserProfileMapping}s between the source AppUserType
     * and the target AppUserType.
     *
     * @param source ID of the source AppUserType
     * @param target ID of the target AppUserType
     * @return a list of all {@link UserProfileMapping}s between source and target
     * @throws IOException if the API request fails
     */
    public List<UserProfileMapping> getUserProfileMappings(String source, String target) throws IOException {
        Map<String, String> params = new HashMap<String, String>(2);
        params.put("source", source);
        params.put("target", target);
        return get(getEncodedPathWithQueryParams("", params), new TypeReference<List<UserProfileMapping>>() {});
    }

    /**
     * <p>Update the {@link UserProfileMapping}s between the source AppUserType
     * and the target AppUserType.</p>
     *
     * <p>WARNING: replaces the existing mappings, does not append to them!!</p>
     *
     * @param item new UserProfileMappings to establish between source and target
     * @return a list of all {@link UserProfileMapping}s between source and target
     * @throws IOException if the API request fails
     */
    public UserProfileMapping updateUserProfileMapping(UserProfileMapping item) throws IOException {
        return put(getFullPath(""), item, new TypeReference<UserProfileMapping>() {});
    }


    /**
     * Reapply the {@link UserProfileMapping}s between the source AppUserType
     * and the target AppUserType to all AppUsers.
     *
     * @param source ID of the source AppUserType
     * @param target ID of the target AppUserType
     * @throws IOException if the API request fails
     */
    public void reapplyUserProfileMappings(String source, String target) throws IOException {
        Map<String, String> params = new HashMap<String, String>(2);
        params.put("source", source);
        params.put("target", target);
        put(getEncodedPathWithQueryParams("/reapply", params));
    }

    @Override
    protected String getFullPath(String relativePath) {
        return String.format("/api/internal/v%d/mappings%s", apiVersion, relativePath);
    }
}

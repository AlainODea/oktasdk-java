package com.okta.sdk.clients;

import com.fasterxml.jackson.core.type.TypeReference;
import com.okta.sdk.framework.*;
import com.okta.sdk.models.directory.AppUserType;
import com.okta.sdk.models.directory.AppUserTypeSchema;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTypeApiClient extends JsonApiClient {
    public UserTypeApiClient(ApiClientConfiguration config) {
        super(config);
    }

    public List<AppUserType> getAppUserTypes() throws IOException {
        return getAppUserTypesWithLimit(Utils.getDefaultResultsLimit());
    }

    public AppUserType getDefaultAppUserType() throws IOException {
        return get(getEncodedPath("/default"), new TypeReference<AppUserType>() {});
    }

    public List<AppUserType> getAppUserTypesWithLimit(int limit) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("limit", Integer.toString(limit));
        return get(getEncodedPathWithQueryParams("/", params), new TypeReference<List<AppUserType>>() {});
    }

    public List<AppUserTypeSchema> getAppUserTypeSchemas(String id) throws IOException {
        return get(getEncodedPath("/%s/schemas", id), new TypeReference<List<AppUserTypeSchema>>() {});
    }

    public List<AppUserType> getAppUserTypesWithFilter(FilterBuilder filterBuilder) throws IOException {
        return get(getEncodedPath("?filter=%s", filterBuilder.toString()), new TypeReference<List<AppUserType>>() {});
    }

    public List<AppUserType> getAppUserTypesWithQuery(String query) throws IOException {
        return get(getEncodedPath("?q=%s", query), new TypeReference<List<AppUserType>>() {});
    }

    public AppUserType createAppUserType(AppUserType item) throws IOException {
        return post(getEncodedPath("/"), item, new TypeReference<AppUserType>() {});
    }

    public AppUserType updateAppUserType(AppUserType item) throws IOException {
        return put(getEncodedPath("/%s", item.getId()), item, new TypeReference<AppUserType>() {});
    }

    public PagedResults<AppUserType> getAppUserTypesPagedResultsWithLimit(int limit) throws IOException {
        return new PagedResults<AppUserType>(getAppUserTypesApiResponseWithLimit(limit));
    }

    public PagedResults<AppUserType> getAppUserTypesPagedResultsByUrl(String url) throws IOException {
        return new PagedResults<AppUserType>(getAppUserTypesApiResponseByUrl(url));
    }

    protected ApiResponse<List<AppUserType>> getAppUserTypesApiResponseByUrl(String url) throws IOException {
        HttpResponse resp = getHttpResponse(url);
        List<AppUserType> items = unmarshallResponse(new TypeReference<List<AppUserType>>() {}, resp);
        return new ApiResponse<List<AppUserType>>(resp, items);
    }

    protected ApiResponse<List<AppUserType>> getAppUserTypesApiResponseWithLimit(int limit) throws IOException {
        HttpResponse resp = getHttpResponse(getEncodedPath("?limit=%s", Integer.toString(limit)));
        List<AppUserType> items = unmarshallResponse(new TypeReference<List<AppUserType>>() {}, resp);
        return new ApiResponse<List<AppUserType>>(resp, items);
    }

    protected String getFullPath(String relativePath) {
        return String.format("/api/v%d/user/types%s", apiVersion, relativePath);
    }
}

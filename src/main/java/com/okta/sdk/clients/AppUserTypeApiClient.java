package com.okta.sdk.clients;

import com.fasterxml.jackson.core.type.TypeReference;
import com.okta.sdk.framework.*;
import com.okta.sdk.models.directory.AppUserTypeSchema;
import com.okta.sdk.models.directory.AppUserType;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppUserTypeApiClient extends JsonApiClient {
    public AppUserTypeApiClient(ApiClientConfiguration config) {
        super(config);
    }

    public List<AppUserType> getAppUserTypes() throws IOException {
        return getAppUserTypesWithLimit(Utils.getDefaultResultsLimit());
    }

    public List<AppUserType> getAppUserTypesWithLimit(int limit) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("limit", Integer.toString(limit));
        return get(getEncodedPathWithQueryParams("/", params), new TypeReference<List<AppUserType>>() {});
    }

    public List<AppUserTypeSchema> getAppUserTypeSchemas(String id) throws IOException {
        return get(getEncodedPath("/%s/schemas", id), new TypeReference<List<AppUserTypeSchema>>() {});
    }

    public AppUserTypeSchema updateAppUserTypeSchemas(String id, AppUserTypeSchema schema) throws IOException {
        return put(getEncodedPath("/%s/schemas/%s", id, schema.getId()), schema, new TypeReference<AppUserTypeSchema>() {});
    }

    public List<AppUserType> getAppUserTypesWithFilter(FilterBuilder filterBuilder) throws IOException {
        return get(getEncodedPath("?filter=%s", filterBuilder.toString()), new TypeReference<List<AppUserType>>() {});
    }

    public PagedResults<AppUserType> getAppUserTypesPagedResultsWithQuery(String query) throws IOException {
        String encodedPath = getEncodedPath("?q=%s&limit=-1", query);
        HttpResponse resp = getHttpResponse(encodedPath);
        List<AppUserType> items = unmarshallResponse(new TypeReference<List<AppUserType>>() {}, resp);
        ApiResponse<List<AppUserType>> apiResponse = new ApiResponse<List<AppUserType>>(resp, items);
        return new StartIdPagedResults<AppUserType>(apiResponse, getAbsoluteURI(encodedPath));
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
        return String.format("/api/v%d/apps/user/types%s", apiVersion, relativePath);
    }
}

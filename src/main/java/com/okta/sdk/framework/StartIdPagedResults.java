package com.okta.sdk.framework;

import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class StartIdPagedResults<T extends StartIdPageable> extends PagedResults<T> {

    private final URI uri;

    public StartIdPagedResults(ApiResponse<List<T>> apiResponse, URI uri) {
        super(apiResponse);
        this.uri = uri;
    }

    @Override
    public boolean isLastPage() {
        return getResult().isEmpty();
    }

    // This can't be determined
    @Override
    public boolean isFirstPage() {
        return false;
    }

    @Override
    public String getNextUrl() {
        List<T> result = getResult();
        String start = result.get(result.size() - 1).getId();
        URIBuilder uriBuilder = new URIBuilder(uri).setParameter("start", start);
        try {
            return uriBuilder.build().toASCIIString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}

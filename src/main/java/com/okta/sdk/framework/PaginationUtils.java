package com.okta.sdk.framework;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PaginationUtils {
    public static <T> void consumePagedResults(long timeout, TimeUnit timeUnit, PagedResults<T> pagedResults, Pager<T> pager, CrashableConsumer<T> consumer) throws Exception {
        while (!Thread.currentThread().isInterrupted()) {
            List<T> page = pagedResults.getResult();
            for (T item : page) {
                consumer.accept(item);
            }
            if (pagedResults.isLastPage()) {
                break;
            }
            timeUnit.sleep(timeout);
            pagedResults = pager.pagedResultsByUrl(pagedResults.getNextUrl());
        }
    }

    public interface CrashableConsumer<T> {
        void accept(T t) throws Exception;
    }

    public interface Pager<T> {
        PagedResults<T> pagedResultsByUrl(String url) throws Exception;
    }
}

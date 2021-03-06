/*!
 * Copyright (c) 2015-2016, Okta, Inc. and/or its affiliates. All rights reserved.
 * The Okta software accompanied by this notice is provided pursuant to the Apache License, Version 2.0 (the "License.")
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and limitations under the License.
 */

package com.okta.sdk.framework;

import com.okta.sdk.exceptions.SdkException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.joda.time.DateTime;

public class RateLimitContext {

    private HttpResponse httpResponse;

    public RateLimitContext(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    /**
     * @return The number of requests remaining in the current window
     * @throws Exception
     */
    public long getNumRequestsRemaining() throws Exception {
        return getHeaderValueLong("X-Rate-Limit-Remaining");
    }

    /**
     * @return When the next window starts, in Unix time. When the
     * next window starts, the server will reset the request count
     * @throws Exception
     */
    public long getNextWindowUnixTime() throws Exception {
        return getHeaderValueLong("X-Rate-Limit-Reset");
    }

    /**
     * @return When the next window starts, as a DateTime. When the
     * next window starts, the server will reset the request count
     * @throws Exception
     */
    public DateTime getNextWindowDateTime() throws Exception {
        Long unixTime = getNextWindowUnixTime();
        try {
            return new DateTime(unixTime * 1000L);
        } catch (Exception e) {
            throw new SdkException("Unable to convert X-Rate-Limit-Reset to DateTime");
        }
    }

    /**
     * @return The maximum number of requests allowed in a window
     * @throws Exception
     */
    public Long getRequestLimit() throws Exception {
        return getHeaderValueLong("X-Rate-Limit-Limit");
    }

    private String getHeaderValueString(String headerName) throws Exception {
        if (httpResponse == null) {
            throw new SdkException("No http response");
        }

        Header[] headers = httpResponse.getHeaders(headerName);
        if (headers.length > 0) {
            Header header = headers[0];
            return header.getValue();
        } else {
            throw new SdkException("No " + headerName + " header");
        }
    }

    private long getHeaderValueLong(String headerName) throws Exception {
        String headerString = getHeaderValueString(headerName);
        try {
            return Long.parseLong(headerString);
        } catch (Exception e){
            throw new SdkException("Error parsing " + headerName + " header");
        }
    }

}

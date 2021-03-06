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

package com.okta.sdk.models.factors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.okta.sdk.framework.ApiObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactorDeviceEnrollRequest extends ApiObject {

    private Verification verify;

    private Map<String, Object> profile;

    /**
     * Gets verify
     */
    public Verification getVerify() {
        return this.verify;
    }

    /**
     * Sets verify
     */
    public void setVerify(Verification val) {
        this.verify = val;
    }

    /**
     * Gets profile
     */
    public Map<String, Object> getProfile() {
        return this.profile;
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
    @JsonProperty(value = "_embedded")
    private Map<String, Object> embedded;

    /**
     * Sets profile
     */
    public void setProfile(Map<String, Object> val) {
        this.profile = val;
    }

    @JsonIgnore
    @SuppressWarnings("unchecked")
     public List<FactorEnrollRequest> getFactorsToEnroll() {
        return (List<FactorEnrollRequest>) embedded.get("factors");
    }

    @JsonIgnore
    public void setFactorsToEnroll(List<FactorEnrollRequest> factorsToEnroll) {
        if (embedded == null) {
            embedded = new HashMap<String, Object>();
        }
        embedded.put("factors", factorsToEnroll);
    }
}
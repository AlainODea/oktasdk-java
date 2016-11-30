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

package com.okta.sdk.models.apps;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.okta.sdk.framework.ApiObject;

public class Visibility extends ApiObject {

    /**
     * Automatically log in when user lands on login page
     */
    private Boolean autoSubmitToolbar;

    /**
     * Hides this app for specific end-user apps
     */
    @JsonProperty("hide")
    private HideAvailabilityOption hideAvailabilityOption;

    /**
     * Displays specific appLinks for the app
     */
    private AppLinks appLinks;

    /**
     * Gets autoSubmitToolbar
     */
    public Boolean getAutoSubmitToolbar() {
        return this.autoSubmitToolbar;
    }

    /**
     * Sets autoSubmitToolbar
     */
    public void setAutoSubmitToolbar(Boolean val) {
        this.autoSubmitToolbar = val;
    }

    /**
     * Gets hide
     */
    public HideAvailabilityOption getHideAvailabilityOption() {
        return this.hideAvailabilityOption;
    }

    /**
     * Sets hide
     */
    public void setHideAvailabilityOption(HideAvailabilityOption val) {
        this.hideAvailabilityOption = val;
    }

    /**
     * Gets appLinks
     */
    public AppLinks getAppLinks() {
        return this.appLinks;
    }

    /**
     * Sets appLinks
     */
    public void setAppLinks(AppLinks val) {
        this.appLinks = val;
    }
}
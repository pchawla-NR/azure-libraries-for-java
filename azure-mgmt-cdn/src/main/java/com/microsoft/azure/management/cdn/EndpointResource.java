/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cdn;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines the ARM Resource ID for the linked endpoints.
 */
public class EndpointResource {
    /**
     * ARM Resource ID string.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * Get aRM Resource ID string.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set aRM Resource ID string.
     *
     * @param id the id value to set
     * @return the CdnEndpoint object itself.
     */
    public EndpointResource withId(String id) {
        this.id = id;
        return this;
    }

}
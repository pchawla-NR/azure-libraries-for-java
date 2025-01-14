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
 * The json object that contains properties required to create a security
 * policy.
 */
public class SecurityPolicyProperties extends AFDStateProperties {
    /**
     * object which contains security policy parameters.
     */
    @JsonProperty(value = "parameters")
    private SecurityPolicyParameters parameters;

    /**
     * Get object which contains security policy parameters.
     *
     * @return the parameters value
     */
    public SecurityPolicyParameters parameters() {
        return this.parameters;
    }

    /**
     * Set object which contains security policy parameters.
     *
     * @param parameters the parameters value to set
     * @return the SecurityPolicyProperties object itself.
     */
    public SecurityPolicyProperties withParameters(SecurityPolicyParameters parameters) {
        this.parameters = parameters;
        return this;
    }

}

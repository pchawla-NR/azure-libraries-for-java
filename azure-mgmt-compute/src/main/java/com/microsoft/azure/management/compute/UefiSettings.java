/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies the security settings like secure boot and vTPM used while
 * creating the virtual machine. &lt;br&gt;&lt;br&gt;Minimum api-version:
 * 2020-12-01.
 */
public class UefiSettings {
    /**
     * Specifies whether secure boot should be enabled on the virtual machine.
     * &lt;br&gt;&lt;br&gt;Minimum api-version: 2020-12-01.
     */
    @JsonProperty(value = "secureBootEnabled")
    private Boolean secureBootEnabled;

    /**
     * Specifies whether vTPM should be enabled on the virtual machine.
     * &lt;br&gt;&lt;br&gt;Minimum api-version: 2020-12-01.
     */
    @JsonProperty(value = "vTpmEnabled")
    private Boolean vTpmEnabled;

    /**
     * Get specifies whether secure boot should be enabled on the virtual machine. &lt;br&gt;&lt;br&gt;Minimum api-version: 2020-12-01.
     *
     * @return the secureBootEnabled value
     */
    public Boolean secureBootEnabled() {
        return this.secureBootEnabled;
    }

    /**
     * Set specifies whether secure boot should be enabled on the virtual machine. &lt;br&gt;&lt;br&gt;Minimum api-version: 2020-12-01.
     *
     * @param secureBootEnabled the secureBootEnabled value to set
     * @return the UefiSettings object itself.
     */
    public UefiSettings withSecureBootEnabled(Boolean secureBootEnabled) {
        this.secureBootEnabled = secureBootEnabled;
        return this;
    }

    /**
     * Get specifies whether vTPM should be enabled on the virtual machine. &lt;br&gt;&lt;br&gt;Minimum api-version: 2020-12-01.
     *
     * @return the vTpmEnabled value
     */
    public Boolean vTpmEnabled() {
        return this.vTpmEnabled;
    }

    /**
     * Set specifies whether vTPM should be enabled on the virtual machine. &lt;br&gt;&lt;br&gt;Minimum api-version: 2020-12-01.
     *
     * @param vTpmEnabled the vTpmEnabled value to set
     * @return the UefiSettings object itself.
     */
    public UefiSettings withVTpmEnabled(Boolean vTpmEnabled) {
        this.vTpmEnabled = vTpmEnabled;
        return this;
    }

}

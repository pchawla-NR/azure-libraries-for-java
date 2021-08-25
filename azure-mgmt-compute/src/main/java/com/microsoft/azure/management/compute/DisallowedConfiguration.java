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
 * Specifies the disallowed configuration for a virtual machine image.
 */
public class DisallowedConfiguration {
    /**
     * VM disk types which are disallowed. Possible values include: 'None',
     * 'Unmanaged'.
     */
    @JsonProperty(value = "vmDiskType")
    private VmDiskTypes vmDiskType;

    /**
     * Get vM disk types which are disallowed. Possible values include: 'None', 'Unmanaged'.
     *
     * @return the vmDiskType value
     */
    public VmDiskTypes vmDiskType() {
        return this.vmDiskType;
    }

    /**
     * Set vM disk types which are disallowed. Possible values include: 'None', 'Unmanaged'.
     *
     * @param vmDiskType the vmDiskType value to set
     * @return the DisallowedConfiguration object itself.
     */
    public DisallowedConfiguration withVmDiskType(VmDiskTypes vmDiskType) {
        this.vmDiskType = vmDiskType;
        return this;
    }

}

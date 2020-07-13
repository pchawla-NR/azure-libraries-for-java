/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.storage.implementation;

import com.microsoft.azure.management.storage.SkuName;
import com.microsoft.azure.management.storage.SkuTier;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The SKU of the storage account.
 */
public class SkuInner {
    /**
     * Possible values include: 'Standard_LRS', 'Standard_GRS',
     * 'Standard_RAGRS', 'Standard_ZRS', 'Premium_LRS', 'Premium_ZRS',
     * 'Standard_GZRS', 'Standard_RAGZRS'.
     */
    @JsonProperty(value = "name", required = true)
    private SkuName name;

    /**
     * Possible values include: 'Standard', 'Premium'.
     */
    @JsonProperty(value = "tier")
    private SkuTier tier;

    /**
     * Get possible values include: 'Standard_LRS', 'Standard_GRS', 'Standard_RAGRS', 'Standard_ZRS', 'Premium_LRS', 'Premium_ZRS', 'Standard_GZRS', 'Standard_RAGZRS'.
     *
     * @return the name value
     */
    public SkuName name() {
        return this.name;
    }

    /**
     * Set possible values include: 'Standard_LRS', 'Standard_GRS', 'Standard_RAGRS', 'Standard_ZRS', 'Premium_LRS', 'Premium_ZRS', 'Standard_GZRS', 'Standard_RAGZRS'.
     *
     * @param name the name value to set
     * @return the SkuInner object itself.
     */
    public SkuInner withName(SkuName name) {
        this.name = name;
        return this;
    }

    /**
     * Get possible values include: 'Standard', 'Premium'.
     *
     * @return the tier value
     */
    public SkuTier tier() {
        return this.tier;
    }

    /**
     * Set possible values include: 'Standard', 'Premium'.
     *
     * @param tier the tier value to set
     * @return the SkuInner object itself.
     */
    public SkuInner withTier(SkuTier tier) {
        this.tier = tier;
        return this;
    }

}

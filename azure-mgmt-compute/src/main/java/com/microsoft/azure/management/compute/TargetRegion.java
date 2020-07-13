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
 * Describes the target region information.
 */
public class TargetRegion {
    /**
     * The name of the region.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * The number of replicas of the Image Version to be created per region.
     * This property is updatable.
     */
    @JsonProperty(value = "regionalReplicaCount")
    private Integer regionalReplicaCount;

    /**
     * Specifies the storage account type to be used to store the image. This
     * property is not updatable. Possible values include: 'Standard_LRS',
     * 'Standard_ZRS', 'Premium_LRS'.
     */
    @JsonProperty(value = "storageAccountType")
    private StorageAccountType storageAccountType;

    /**
     * The encryption property.
     */
    @JsonProperty(value = "encryption")
    private EncryptionImages encryption;

    /**
     * Get the name of the region.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name of the region.
     *
     * @param name the name value to set
     * @return the TargetRegion object itself.
     */
    public TargetRegion withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the number of replicas of the Image Version to be created per region. This property is updatable.
     *
     * @return the regionalReplicaCount value
     */
    public Integer regionalReplicaCount() {
        return this.regionalReplicaCount;
    }

    /**
     * Set the number of replicas of the Image Version to be created per region. This property is updatable.
     *
     * @param regionalReplicaCount the regionalReplicaCount value to set
     * @return the TargetRegion object itself.
     */
    public TargetRegion withRegionalReplicaCount(Integer regionalReplicaCount) {
        this.regionalReplicaCount = regionalReplicaCount;
        return this;
    }

    /**
     * Get specifies the storage account type to be used to store the image. This property is not updatable. Possible values include: 'Standard_LRS', 'Standard_ZRS', 'Premium_LRS'.
     *
     * @return the storageAccountType value
     */
    public StorageAccountType storageAccountType() {
        return this.storageAccountType;
    }

    /**
     * Set specifies the storage account type to be used to store the image. This property is not updatable. Possible values include: 'Standard_LRS', 'Standard_ZRS', 'Premium_LRS'.
     *
     * @param storageAccountType the storageAccountType value to set
     * @return the TargetRegion object itself.
     */
    public TargetRegion withStorageAccountType(StorageAccountType storageAccountType) {
        this.storageAccountType = storageAccountType;
        return this;
    }

    /**
     * Get the encryption value.
     *
     * @return the encryption value
     */
    public EncryptionImages encryption() {
        return this.encryption;
    }

    /**
     * Set the encryption value.
     *
     * @param encryption the encryption value to set
     * @return the TargetRegion object itself.
     */
    public TargetRegion withEncryption(EncryptionImages encryption) {
        this.encryption = encryption;
        return this;
    }

}

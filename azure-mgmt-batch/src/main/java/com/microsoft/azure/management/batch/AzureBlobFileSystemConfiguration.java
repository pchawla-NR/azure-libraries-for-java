/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.batch;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Information used to connect to an Azure Storage Container using Blobfuse.
 */
public class AzureBlobFileSystemConfiguration {
    /**
     * The Azure Storage Account name.
     */
    @JsonProperty(value = "accountName", required = true)
    private String accountName;

    /**
     * The Azure Blob Storage Container name.
     */
    @JsonProperty(value = "containerName", required = true)
    private String containerName;

    /**
     * The Azure Storage Account key.
     * This property is mutually exclusive with sasKey and one must be
     * specified.
     */
    @JsonProperty(value = "accountKey")
    private String accountKey;

    /**
     * The Azure Storage SAS token.
     * This property is mutually exclusive with accountKey and one must be
     * specified.
     */
    @JsonProperty(value = "sasKey")
    private String sasKey;

    /**
     * Additional command line options to pass to the mount command.
     * These are 'net use' options in Windows and 'mount' options in Linux.
     */
    @JsonProperty(value = "blobfuseOptions")
    private String blobfuseOptions;

    /**
     * The relative path on the compute node where the file system will be
     * mounted.
     * All file systems are mounted relative to the Batch mounts directory,
     * accessible via the AZ_BATCH_NODE_MOUNTS_DIR environment variable.
     */
    @JsonProperty(value = "relativeMountPath", required = true)
    private String relativeMountPath;

    /**
     * Get the accountName value.
     *
     * @return the accountName value
     */
    public String accountName() {
        return this.accountName;
    }

    /**
     * Set the accountName value.
     *
     * @param accountName the accountName value to set
     * @return the AzureBlobFileSystemConfiguration object itself.
     */
    public AzureBlobFileSystemConfiguration withAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    /**
     * Get the containerName value.
     *
     * @return the containerName value
     */
    public String containerName() {
        return this.containerName;
    }

    /**
     * Set the containerName value.
     *
     * @param containerName the containerName value to set
     * @return the AzureBlobFileSystemConfiguration object itself.
     */
    public AzureBlobFileSystemConfiguration withContainerName(String containerName) {
        this.containerName = containerName;
        return this;
    }

    /**
     * Get this property is mutually exclusive with sasKey and one must be specified.
     *
     * @return the accountKey value
     */
    public String accountKey() {
        return this.accountKey;
    }

    /**
     * Set this property is mutually exclusive with sasKey and one must be specified.
     *
     * @param accountKey the accountKey value to set
     * @return the AzureBlobFileSystemConfiguration object itself.
     */
    public AzureBlobFileSystemConfiguration withAccountKey(String accountKey) {
        this.accountKey = accountKey;
        return this;
    }

    /**
     * Get this property is mutually exclusive with accountKey and one must be specified.
     *
     * @return the sasKey value
     */
    public String sasKey() {
        return this.sasKey;
    }

    /**
     * Set this property is mutually exclusive with accountKey and one must be specified.
     *
     * @param sasKey the sasKey value to set
     * @return the AzureBlobFileSystemConfiguration object itself.
     */
    public AzureBlobFileSystemConfiguration withSasKey(String sasKey) {
        this.sasKey = sasKey;
        return this;
    }

    /**
     * Get these are 'net use' options in Windows and 'mount' options in Linux.
     *
     * @return the blobfuseOptions value
     */
    public String blobfuseOptions() {
        return this.blobfuseOptions;
    }

    /**
     * Set these are 'net use' options in Windows and 'mount' options in Linux.
     *
     * @param blobfuseOptions the blobfuseOptions value to set
     * @return the AzureBlobFileSystemConfiguration object itself.
     */
    public AzureBlobFileSystemConfiguration withBlobfuseOptions(String blobfuseOptions) {
        this.blobfuseOptions = blobfuseOptions;
        return this;
    }

    /**
     * Get all file systems are mounted relative to the Batch mounts directory, accessible via the AZ_BATCH_NODE_MOUNTS_DIR environment variable.
     *
     * @return the relativeMountPath value
     */
    public String relativeMountPath() {
        return this.relativeMountPath;
    }

    /**
     * Set all file systems are mounted relative to the Batch mounts directory, accessible via the AZ_BATCH_NODE_MOUNTS_DIR environment variable.
     *
     * @param relativeMountPath the relativeMountPath value to set
     * @return the AzureBlobFileSystemConfiguration object itself.
     */
    public AzureBlobFileSystemConfiguration withRelativeMountPath(String relativeMountPath) {
        this.relativeMountPath = relativeMountPath;
        return this;
    }

}
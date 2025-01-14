/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.compute;

import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.management.apigeneration.LangDefinition;

/**
 * Type representing encryption configuration to be applied to a Windows virtual machine.
 */
@LangDefinition
public class WindowsVMDiskEncryptionConfiguration
        extends VirtualMachineEncryptionConfiguration<WindowsVMDiskEncryptionConfiguration> {
    /**
     * Creates WindowsVMDiskEncryptionConfiguration.
     *
     * @param keyVaultId the resource ID of the key vault to store the disk encryption key
     * @param aadClientId  client ID of an AAD application which has permission to the key vault
     * @param aadSecret client secret corresponding to the aadClientId
     */
    public WindowsVMDiskEncryptionConfiguration(String keyVaultId,
                                                String aadClientId,
                                                String aadSecret) {
        super(keyVaultId, null, aadClientId, aadSecret, null);
    }

    /**
     * Creates WindowsVMDiskEncryptionConfiguration.
     *
     * @param keyVaultId the resource ID of the key vault to store the disk encryption key
     * @param vaultUri URI of the key vault data-plane endpoint
     * @param aadClientId  client ID of an AAD application which has permission to the key vault
     * @param aadSecret client secret corresponding to the aadClientId
     */
    public WindowsVMDiskEncryptionConfiguration(String keyVaultId,
                                                String vaultUri,
                                                String aadClientId,
                                                String aadSecret) {
        super(keyVaultId, vaultUri, aadClientId, aadSecret, null);
    }

    /**
     * Creates WindowsVMDiskEncryptionConfiguration.
     *
     * @param keyVaultId the resource ID of the key vault to store the disk encryption key
     * @param aadClientId  client ID of an AAD application which has permission to the key vault
     * @param aadSecret client secret corresponding to the aadClientId
     * @param azureEnvironment Azure environment
     */
    public WindowsVMDiskEncryptionConfiguration(String keyVaultId,
                                                String aadClientId,
                                                String aadSecret,
                                                AzureEnvironment azureEnvironment) {
        super(keyVaultId, null, aadClientId, aadSecret, azureEnvironment);
    }

    /**
     * Creates WindowsVMDiskEncryptionConfiguration.
     *
     * @param keyVaultId the resource ID of the key vault to store the disk encryption key
     */
    public WindowsVMDiskEncryptionConfiguration(String keyVaultId) {
        super(keyVaultId, null, null);
    }

    /**
     * Creates WindowsVMDiskEncryptionConfiguration.
     *
     * @param keyVaultId the resource ID of the key vault to store the disk encryption key
     * @param vaultUri URI of the key vault data-plane endpoint
     */
    public WindowsVMDiskEncryptionConfiguration(String keyVaultId,
                                                String vaultUri) {
        super(keyVaultId, vaultUri, null);
    }

    /**
     * Creates WindowsVMDiskEncryptionConfiguration.
     *
     * @param keyVaultId the resource ID of the key vault to store the disk encryption key
     * @param azureEnvironment Azure environment
     */
    public WindowsVMDiskEncryptionConfiguration(String keyVaultId,
                                                AzureEnvironment azureEnvironment) {
        super(keyVaultId, null, azureEnvironment);
    }

    @Override
    public OperatingSystemTypes osType() {
        return OperatingSystemTypes.WINDOWS;
    }
}
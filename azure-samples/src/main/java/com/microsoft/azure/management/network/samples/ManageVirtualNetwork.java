/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.network.samples;

import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.compute.KnownLinuxVirtualMachineImage;
import com.microsoft.azure.management.compute.VirtualMachine;
import com.microsoft.azure.management.compute.VirtualMachineSizeTypes;
import com.microsoft.azure.management.network.Network;
import com.microsoft.azure.management.network.NetworkSecurityGroup;
import com.microsoft.azure.management.network.SecurityRuleProtocol;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.azure.management.resources.fluentcore.utils.SdkContext;
import com.microsoft.azure.management.samples.Utils;
import com.microsoft.rest.LogLevel;

import java.io.File;
import java.util.Date;

/**
 * Azure Network sample for managing virtual networks -
 *  - Create a virtual network with Subnets
 *  - Update a virtual network
 *  - Create virtual machines in the virtual network subnets
 *  - Create another virtual network
 *  - List virtual networks
 *  - Delete a virtual network.
 */

public final class ManageVirtualNetwork {

    /**
     * Main function which runs the actual sample.
     * @param azure instance of the azure client
     * @return true if sample runs successfully
     */
    public static boolean runSample(Azure azure) {
        final String vnetName1 = SdkContext.randomResourceName("vnet1", 20);
        final String vnetName2 = SdkContext.randomResourceName("vnet2", 20);
        final String vnet1FrontEndSubnetName = "frontend";
        final String vnet1BackEndSubnetName = "backend";
        final String vnet1FrontEndSubnetNsgName = "frontendnsg";
        final String vnet1BackEndSubnetNsgName = "backendnsg";
        final String frontEndVMName = SdkContext.randomResourceName("fevm", 24);
        final String backEndVMName = SdkContext.randomResourceName("bevm", 24);
        final String publicIPAddressLeafDnsForFrontEndVM = SdkContext.randomResourceName("pip1", 24);
        final String userName = "tirekicker";
        final String sshKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCfSPC2K7LZcFKEO+/t3dzmQYtrJFZNxOsbVgOVKietqHyvmYGHEC0J2wPdAqQ/63g/hhAEFRoyehM+rbeDri4txB3YFfnOK58jqdkyXzupWqXzOrlKY4Wz9SKjjN765+dqUITjKRIaAip1Ri137szRg71WnrmdP3SphTRlCx1Bk2nXqWPsclbRDCiZeF8QOTi4JqbmJyK5+0UqhqYRduun8ylAwKKQJ1NJt85sYIHn9f1Rfr6Tq2zS0wZ7DHbZL+zB5rSlAr8QyUdg/GQD+cmSs6LvPJKL78d6hMGk84ARtFo4A79ovwX/Fj01znDQkU6nJildfkaolH2rWFG/qttD azjava@javalib.com";
        final String rgName = SdkContext.randomResourceName("rgNEMV", 24);

        try {
            //============================================================
            // Create a virtual network with specific address-space and two subnet

            // Creates a network security group for backend subnet

            System.out.println("Creating a network security group for virtual network backend subnet...");

            NetworkSecurityGroup backEndSubnetNsg = azure.networkSecurityGroups().define(vnet1BackEndSubnetNsgName)
                    .withRegion(Region.US_EAST)
                    .withNewResourceGroup(rgName)
                    .defineRule("DenyInternetInComing")
                        .denyInbound()
                        .fromAddress("INTERNET")
                        .fromAnyPort()
                        .toAnyAddress()
                        .toAnyPort()
                        .withAnyProtocol()
                        .attach()
                    .defineRule("DenyInternetOutGoing")
                        .denyOutbound()
                        .fromAnyAddress()
                        .fromAnyPort()
                        .toAddress("INTERNET")
                        .toAnyPort()
                        .withAnyProtocol()
                        .attach()
                    .create();

            System.out.println("Created network security group");
            // Print the network security group
            Utils.print(backEndSubnetNsg);

            // Create the virtual network with frontend and backend subnets, with
            // network security group rule applied to backend subnet]

            System.out.println("Creating virtual network #1...");

            Network virtualNetwork1 = azure.networks().define(vnetName1)
                    .withRegion(Region.US_EAST)
                    .withExistingResourceGroup(rgName)
                    .withAddressSpace("192.168.0.0/16")
                    .withSubnet(vnet1FrontEndSubnetName, "192.168.1.0/24")
                    .defineSubnet(vnet1BackEndSubnetName)
                        .withAddressPrefix("192.168.2.0/24")
                        .withExistingNetworkSecurityGroup(backEndSubnetNsg)
                        .attach()
                    .create();

            System.out.println("Created a virtual network");
            // Print the virtual network details
            Utils.print(virtualNetwork1);


            //============================================================
            // Update a virtual network

            // Creates a network security group for frontend subnet

            System.out.println("Creating a network security group for virtual network backend subnet...");

            NetworkSecurityGroup frontEndSubnetNsg = azure.networkSecurityGroups().define(vnet1FrontEndSubnetNsgName)
                    .withRegion(Region.US_EAST)
                    .withExistingResourceGroup(rgName)
                    .defineRule("AllowHttpInComing")
                        .allowInbound()
                        .fromAddress("INTERNET")
                        .fromAnyPort()
                        .toAnyAddress()
                        .toPort(80)
                        .withProtocol(SecurityRuleProtocol.TCP)
                        .attach()
                    .defineRule("DenyInternetOutGoing")
                        .denyOutbound()
                        .fromAnyAddress()
                        .fromAnyPort()
                        .toAddress("INTERNET")
                        .toAnyPort()
                        .withAnyProtocol()
                        .attach()
                    .create();

            System.out.println("Created network security group");
            // Print the network security group
            Utils.print(frontEndSubnetNsg);

            // Update the virtual network frontend subnet by associating it with network security group

            System.out.println("Associating network security group rule to frontend subnet");

            virtualNetwork1.update()
                    .updateSubnet(vnet1FrontEndSubnetName)
                        .withExistingNetworkSecurityGroup(frontEndSubnetNsg)
                        .parent()
                    .apply();

            System.out.println("Network security group rule associated with the frontend subnet");
            // Print the virtual network details
            Utils.print(virtualNetwork1);


            //============================================================
            // Create a virtual machine in each subnet

            // Creates the first virtual machine in frontend subnet

            System.out.println("Creating a Linux virtual machine in the frontend subnet");

            Date t1 = new Date();

            VirtualMachine frontEndVM = azure.virtualMachines().define(frontEndVMName)
                    .withRegion(Region.US_EAST)
                    .withExistingResourceGroup(rgName)
                    .withExistingPrimaryNetwork(virtualNetwork1)
                    .withSubnet(vnet1FrontEndSubnetName)
                    .withPrimaryPrivateIPAddressDynamic()
                    .withNewPrimaryPublicIPAddress(publicIPAddressLeafDnsForFrontEndVM)
                    .withPopularLinuxImage(KnownLinuxVirtualMachineImage.UBUNTU_SERVER_16_04_LTS)
                    .withRootUsername(userName)
                    .withSsh(sshKey)
                    .withSize(VirtualMachineSizeTypes.fromString("Standard_D2a_v4"))
                    .create();

            Date t2 = new Date();
            System.out.println("Created Linux VM: (took "
                    + ((t2.getTime() - t1.getTime()) / 1000) + " seconds) " + frontEndVM.id());
            // Print virtual machine details
            Utils.print(frontEndVM);


            // Creates the second virtual machine in the backend subnet

            System.out.println("Creating a Linux virtual machine in the backend subnet");

            Date t3 = new Date();

            VirtualMachine backEndVM = azure.virtualMachines().define(backEndVMName)
                    .withRegion(Region.US_EAST)
                    .withExistingResourceGroup(rgName)
                    .withExistingPrimaryNetwork(virtualNetwork1)
                    .withSubnet(vnet1BackEndSubnetName)
                    .withPrimaryPrivateIPAddressDynamic()
                    .withoutPrimaryPublicIPAddress()
                    .withPopularLinuxImage(KnownLinuxVirtualMachineImage.UBUNTU_SERVER_16_04_LTS)
                    .withRootUsername(userName)
                    .withSsh(sshKey)
                    .withSize(VirtualMachineSizeTypes.fromString("Standard_D2a_v4"))
                    .create();

            Date t4 = new Date();
            System.out.println("Created Linux VM: (took "
                    + ((t4.getTime() - t3.getTime()) / 1000) + " seconds) " + backEndVM.id());
            // Print virtual machine details
            Utils.print(backEndVM);


            //============================================================
            // Create a virtual network with default address-space and one default subnet

            System.out.println("Creating virtual network #2...");

            Network virtualNetwork2 = azure.networks().define(vnetName2)
                    .withRegion(Region.US_EAST)
                    .withNewResourceGroup(rgName)
                    .create();

            System.out.println("Created a virtual network");
            // Print the virtual network details
            Utils.print(virtualNetwork2);


            //============================================================
            // List virtual networks

            for (Network virtualNetwork : azure.networks().listByResourceGroup(rgName)) {
                Utils.print(virtualNetwork);
            }


            //============================================================
            // Delete a virtual network
            System.out.println("Deleting the virtual network");
            azure.networks().deleteById(virtualNetwork2.id());
            System.out.println("Deleted the virtual network");

            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                System.out.println("Deleting Resource Group: " + rgName);
                azure.resourceGroups().beginDeleteByName(rgName);
            } catch (NullPointerException npe) {
                System.out.println("Did not create any resources in Azure. No clean up is necessary");
            } catch (Exception g) {
                g.printStackTrace();
            }
        }

        return false;
    }

    /**
     * Main entry point.
     * @param args the parameters
     */
    public static void main(String[] args) {
        try {
            //=============================================================
            // Authenticate

            final File credFile = new File(System.getenv("AZURE_AUTH_LOCATION"));

            Azure azure = Azure.configure()
                    .withLogLevel(LogLevel.BODY)
                    .authenticate(credFile)
                    .withDefaultSubscription();

            // Print selected subscription
            System.out.println("Selected subscription: " + azure.subscriptionId());

            runSample(azure);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private ManageVirtualNetwork() {
    }
}

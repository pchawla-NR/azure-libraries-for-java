/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.network;


import com.microsoft.azure.SubResource;
import com.microsoft.azure.management.network.implementation.NetworkManager;
import com.microsoft.azure.management.network.implementation.PublicIPPrefixInner;
import com.microsoft.azure.management.network.model.UpdatableWithTags;
import com.microsoft.azure.management.resources.fluentcore.arm.AvailabilityZoneId;
import com.microsoft.azure.management.resources.fluentcore.arm.models.GroupableResource;
import com.microsoft.azure.management.resources.fluentcore.arm.models.Resource;
import com.microsoft.azure.management.resources.fluentcore.model.Appliable;
import com.microsoft.azure.management.resources.fluentcore.model.Creatable;
import com.microsoft.azure.management.resources.fluentcore.model.Refreshable;
import com.microsoft.azure.management.resources.fluentcore.model.Updatable;

import java.util.List;
import java.util.Set;

/**
 * Type representing PublicIPPrefix.
 */
public interface PublicIPPrefix extends
        GroupableResource<NetworkManager, PublicIPPrefixInner>,
        Refreshable<PublicIPPrefix>,
        Updatable<PublicIPPrefix.Update>,
        UpdatableWithTags<PublicIPPrefix> {
    /**
     * @return the ipPrefix value.
     */
    String ipPrefix();

    /**
     * @return the ipTags value.
     */
    List<IpTag> ipTags();

    /**
     * @return the loadBalancerFrontendIpConfiguration value.
     */
    SubResource loadBalancerFrontendIpConfiguration();

    /**
     * @return the prefixLength value.
     */
    Integer prefixLength();

    /**
     * @return the provisioningState value.
     */
    ProvisioningState provisioningState();

    /**
     * @return the publicIPAddresses value.
     */
    List<ReferencedPublicIpAddress> publicIPAddresses();

    /**
     * @return the publicIPAddressVersion value.
     */
    IPVersion publicIPAddressVersion();

    /**
     * @return the resourceGuid value.
     */
    String resourceGuid();

    /**
     * @return the sku value.
     */
    PublicIPPrefixSku sku();

    /**
     * @return the availability zones assigned to the public IP prefix
     */
    Set<AvailabilityZoneId> availabilityZones();

    /**
     * The entirety of the PublicIPPrefix definition.
     */
    interface Definition extends DefinitionStages.Blank,
            DefinitionStages.WithGroup, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of PublicIPPrefix definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a PublicIPPrefix definition.
         */
        interface Blank extends GroupableResource.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of the PublicIPPrefix definition allowing to specify the resource group.
         */
        interface WithGroup extends GroupableResource.DefinitionStages.WithGroup<WithCreate> {
        }

        /**
         * The stage of the publicipprefix definition allowing to specify IpTags.
         */
        interface WithIpTags {
            /**
             * Specifies ipTags.
             *
             * @param ipTags The list of tags associated with the public IP prefix
             * @return the next definition stage
             */
            WithCreate withIpTags(List<IpTag> ipTags);
        }

        /**
         * The stage of the publicipprefix definition allowing to specify PrefixLength.
         */
        interface WithPrefixLength {
            /**
             * Specifies prefixLength.
             *
             * @param prefixLength The Length of the Public IP Prefix
             * @return the next definition stage
             */
            WithCreate withPrefixLength(Integer prefixLength);
        }

        /**
         * The stage of the publicipprefix definition allowing to specify PublicIPAddressVersion.
         */
        interface WithPublicIPAddressVersion {
            /**
             * Specifies publicIPAddressVersion.
             *
             * @param publicIPAddressVersion The public IP address version. Possible values include: 'IPv4', 'IPv6'
             * @return the next definition stage
             */
            WithCreate withPublicIPAddressVersion(IPVersion publicIPAddressVersion);
        }

        /**
         * The stage of the publicipprefix definition allowing to specify Sku.
         */
        interface WithSku {
            /**
             * Specifies sku.
             *
             * @param sku The public IP prefix SKU
             * @return the next definition stage
             */
            WithCreate withSku(PublicIPPrefixSku sku);
        }

        /**
         * The stage of the IP public prefix definition allowing to specify availability zone.
         */
        interface WithAvailabilityZone {
            /**
             * Specifies the availability zone for the IP address.
             *
             * @param zoneId the zone identifier.
             * @return the next stage of the definition
             */
            WithCreate withAvailabilityZone(AvailabilityZoneId zoneId);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<PublicIPPrefix>,
                Resource.DefinitionWithTags<WithCreate>,
                DefinitionStages.WithIpTags,
                DefinitionStages.WithPrefixLength,
                DefinitionStages.WithPublicIPAddressVersion,
                DefinitionStages.WithSku,
                DefinitionStages.WithAvailabilityZone {
        }
    }

    /**
     * The template for a PublicIPPrefix update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<PublicIPPrefix>,
            Resource.UpdateWithTags<Update>,
            UpdateStages.WithIpTags {
    }

    /**
     * Grouping of PublicIPPrefix update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the publicipprefix update allowing to specify IpTags.
         */
        interface WithIpTags {
            /**
             * Specifies ipTags.
             *
             * @param ipTags The list of tags associated with the public IP prefix
             * @return the next update stage
             */
            Update withIpTags(List<IpTag> ipTags);
        }
    }
}

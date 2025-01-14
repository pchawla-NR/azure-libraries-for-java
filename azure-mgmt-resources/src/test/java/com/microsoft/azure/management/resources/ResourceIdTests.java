/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.resources;

import com.microsoft.azure.management.resources.fluentcore.arm.ResourceId;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class to test ResourceId class.
 */
public class ResourceIdTests {


    @Test
    public void resourceIdForTopLevelResourceWorksFine() {
        ResourceId resourceId = ResourceId.fromString("/subscriptions/9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef/resourceGroups/resourceGroupName/providers/Microsoft.Network/applicationGateways/something");

        Assert.assertEquals(resourceId.name(), "something");
        Assert.assertEquals(resourceId.subscriptionId(), "9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef");
        Assert.assertEquals(resourceId.resourceGroupName(), "resourceGroupName");
        Assert.assertEquals(resourceId.providerNamespace(), "Microsoft.Network");
        Assert.assertEquals(resourceId.resourceType(), "applicationGateways");
        Assert.assertEquals(resourceId.fullResourceType(), "Microsoft.Network/applicationGateways");
        Assert.assertNull(resourceId.parent());
    }

    @Test
    public void resourceIdForChildLevelResourceWorksFine() {
        ResourceId resourceId = ResourceId.fromString("/subscriptions/9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef/resourceGroups/resourceGroupName/providers/Microsoft.Network/applicationGateways/something/someChildType/childName");
        
        Assert.assertEquals(resourceId.name(), "childName");
        Assert.assertEquals(resourceId.subscriptionId(), "9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef");
        Assert.assertEquals(resourceId.resourceGroupName(), "resourceGroupName");
        Assert.assertEquals(resourceId.providerNamespace(), "Microsoft.Network");
        Assert.assertEquals(resourceId.resourceType(), "someChildType");
        Assert.assertEquals(resourceId.fullResourceType(), "Microsoft.Network/applicationGateways/someChildType");
        Assert.assertNotNull(resourceId.parent());
        Assert.assertEquals(resourceId.parent().name(), "something");
        Assert.assertEquals(resourceId.parent().subscriptionId(), "9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef");
        Assert.assertEquals(resourceId.parent().resourceGroupName(), "resourceGroupName");
        Assert.assertEquals(resourceId.parent().name(), "something");
        Assert.assertEquals(resourceId.parent().providerNamespace(), "Microsoft.Network");
        Assert.assertEquals(resourceId.parent().resourceType(), "applicationGateways");
        Assert.assertEquals(resourceId.parent().fullResourceType(), "Microsoft.Network/applicationGateways");
    }

    @Test
    public void resourceIdForGrandChildLevelResourceWorksFine() {
        ResourceId resourceId = ResourceId.fromString("/subscriptions/9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef/resourceGroups/resourceGroupName/providers/Microsoft.Network/applicationGateways/something/someChildType/childName/grandChildType/grandChild");

        Assert.assertEquals(resourceId.name(), "grandChild");
        Assert.assertEquals(resourceId.subscriptionId(), "9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef");
        Assert.assertEquals(resourceId.resourceGroupName(), "resourceGroupName");
        Assert.assertEquals(resourceId.providerNamespace(), "Microsoft.Network");
        Assert.assertEquals(resourceId.resourceType(), "grandChildType");
        Assert.assertEquals(resourceId.fullResourceType(), "Microsoft.Network/applicationGateways/someChildType/grandChildType");
        Assert.assertNotNull(resourceId.parent());
        Assert.assertEquals(resourceId.parent().name(), "childName");
        Assert.assertEquals(resourceId.parent().subscriptionId(), "9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef");
        Assert.assertEquals(resourceId.parent().resourceGroupName(), "resourceGroupName");
        Assert.assertEquals(resourceId.parent().providerNamespace(), "Microsoft.Network");
        Assert.assertEquals(resourceId.parent().resourceType(), "someChildType");
        Assert.assertEquals(resourceId.parent().fullResourceType(), "Microsoft.Network/applicationGateways/someChildType");
        Assert.assertNotNull(resourceId.parent().parent());
        Assert.assertEquals(resourceId.parent().parent().name(), "something");
        Assert.assertEquals(resourceId.parent().parent().subscriptionId(), "9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef");
        Assert.assertEquals(resourceId.parent().parent().resourceGroupName(), "resourceGroupName");
        Assert.assertEquals(resourceId.parent().parent().name(), "something");
        Assert.assertEquals(resourceId.parent().parent().providerNamespace(), "Microsoft.Network");
        Assert.assertEquals(resourceId.parent().parent().resourceType(), "applicationGateways");
        Assert.assertEquals(resourceId.parent().parent().fullResourceType(), "Microsoft.Network/applicationGateways");
    }


    @Test
    public void resourceIdForTopLevelResourceWorksFineForServiceBus() {
        ResourceId resourceId = ResourceId.fromString("/subscriptions/9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef/resourceGroups/resourceGroupName/providers/Microsoft.ServiceBus/namespaces/something");

        Assert.assertEquals(resourceId.name(), "something");
        Assert.assertEquals(resourceId.subscriptionId(), "9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef");
        Assert.assertEquals(resourceId.resourceGroupName(), "resourceGroupName");
        Assert.assertEquals(resourceId.providerNamespace(), "Microsoft.ServiceBus");
        Assert.assertEquals(resourceId.resourceType(), "namespaces");
        Assert.assertEquals(resourceId.fullResourceType(), "Microsoft.ServiceBus/namespaces");
        Assert.assertNull(resourceId.parent());
    }

    @Test
    public void resourceIdForChildLevelResourceWorksFineForServiceBus() {
        ResourceId resourceId = ResourceId.fromString("/subscriptions/9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef/resourceGroups/resourceGroupName/providers/Microsoft.ServiceBus/namespaces/something/queues/childName/childName2");

        Assert.assertEquals(resourceId.name(), "childName/childName2");
        Assert.assertEquals(resourceId.subscriptionId(), "9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef");
        Assert.assertEquals(resourceId.resourceGroupName(), "resourceGroupName");
        Assert.assertEquals(resourceId.providerNamespace(), "Microsoft.ServiceBus");
        Assert.assertEquals(resourceId.resourceType(), "queues");
        Assert.assertEquals(resourceId.fullResourceType(), "Microsoft.ServiceBus/namespaces/queues");
        Assert.assertNotNull(resourceId.parent());
        Assert.assertEquals(resourceId.parent().name(), "something");
        Assert.assertEquals(resourceId.parent().subscriptionId(), "9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef");
        Assert.assertEquals(resourceId.parent().resourceGroupName(), "resourceGroupName");
        Assert.assertEquals(resourceId.parent().providerNamespace(), "Microsoft.ServiceBus");
        Assert.assertEquals(resourceId.parent().resourceType(), "namespaces");
        Assert.assertEquals(resourceId.parent().fullResourceType(), "Microsoft.ServiceBus/namespaces");
    }

    @Test
    public void resourceIdForChildLevelResourceWorksFineForServiceBusTopics() {
        ResourceId resourceId = ResourceId.fromString("/subscriptions/9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef/resourceGroups/resourceGroupName/providers/Microsoft.ServiceBus/namespaces/something/topics/someTopic/someTopic1/someTopic2");

        Assert.assertEquals("someTopic/someTopic1/someTopic2", resourceId.name());
        Assert.assertEquals("9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef", resourceId.subscriptionId());
        Assert.assertEquals("resourceGroupName", resourceId.resourceGroupName());
        Assert.assertEquals("Microsoft.ServiceBus", resourceId.providerNamespace());
        Assert.assertEquals("topics", resourceId.resourceType());
        Assert.assertEquals("Microsoft.ServiceBus/namespaces/topics", resourceId.fullResourceType());
        Assert.assertNotNull(resourceId.parent());
        Assert.assertEquals("something", resourceId.parent().name());
        Assert.assertEquals("9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef", resourceId.parent().subscriptionId());
        Assert.assertEquals("resourceGroupName", resourceId.parent().resourceGroupName());
        Assert.assertEquals("Microsoft.ServiceBus", resourceId.parent().providerNamespace());
        Assert.assertEquals("namespaces", resourceId.parent().resourceType());
        Assert.assertEquals("Microsoft.ServiceBus/namespaces", resourceId.parent().fullResourceType());
    }

    @Test
    public void resourceIdForGrandChildLevelResourceWorksFineForServiceBusTopicsWithSubscriptions() {
        ResourceId resourceId = ResourceId.fromString("/subscriptions/9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef/resourceGroups/resourceGroupName/providers/Microsoft.ServiceBus/namespaces/something/topics/someTopic/subscriptions/somesubscription");

        Assert.assertEquals("somesubscription", resourceId.name());
        Assert.assertEquals("9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef", resourceId.subscriptionId());
        Assert.assertEquals("resourceGroupName", resourceId.resourceGroupName());
        Assert.assertEquals("Microsoft.ServiceBus",resourceId.providerNamespace());
        Assert.assertEquals("subscriptions", resourceId.resourceType());
        Assert.assertEquals("Microsoft.ServiceBus/namespaces/topics/subscriptions", resourceId.fullResourceType());
        Assert.assertNotNull(resourceId.parent());
        Assert.assertEquals("someTopic", resourceId.parent().name());
        Assert.assertEquals("9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef", resourceId.parent().subscriptionId());
        Assert.assertEquals("resourceGroupName",resourceId.parent().resourceGroupName());
        Assert.assertEquals("Microsoft.ServiceBus", resourceId.parent().providerNamespace());
        Assert.assertEquals("topics", resourceId.parent().resourceType());
        Assert.assertEquals("Microsoft.ServiceBus/namespaces/topics", resourceId.parent().fullResourceType());
        Assert.assertNotNull(resourceId.parent().parent());
        Assert.assertEquals("something", resourceId.parent().parent().name());
        Assert.assertEquals("9657ab5d-4a4a-4fd2-ae7a-4cd9fbd030ef", resourceId.parent().parent().subscriptionId());
        Assert.assertEquals("resourceGroupName", resourceId.parent().parent().resourceGroupName());
        Assert.assertEquals("Microsoft.ServiceBus", resourceId.parent().parent().providerNamespace());
        Assert.assertEquals("namespaces", resourceId.parent().parent().resourceType());
        Assert.assertEquals("Microsoft.ServiceBus/namespaces", resourceId.parent().parent().fullResourceType());
    }
}

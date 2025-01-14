/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management;

import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.AzureResponseBuilder;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.microsoft.azure.credentials.AzureTokenCredentials;
import com.microsoft.azure.management.apigeneration.Beta;
import com.microsoft.azure.management.apigeneration.Beta.SinceVersion;
import com.microsoft.azure.management.appservice.FunctionApps;
import com.microsoft.azure.management.appservice.WebApps;
import com.microsoft.azure.management.appservice.implementation.AppServiceManager;
import com.microsoft.azure.management.batch.BatchAccounts;
import com.microsoft.azure.management.batch.implementation.BatchManager;
import com.microsoft.azure.management.batchai.BatchAIUsages;
import com.microsoft.azure.management.batchai.BatchAIWorkspaces;
import com.microsoft.azure.management.batchai.implementation.BatchAIManager;
import com.microsoft.azure.management.cdn.CdnProfiles;
import com.microsoft.azure.management.cdn.implementation.CdnManager;
import com.microsoft.azure.management.compute.AvailabilitySets;
import com.microsoft.azure.management.compute.ComputeSkus;
import com.microsoft.azure.management.compute.ComputeUsages;
import com.microsoft.azure.management.compute.Disks;
import com.microsoft.azure.management.compute.Galleries;
import com.microsoft.azure.management.compute.GalleryImageVersions;
import com.microsoft.azure.management.compute.GalleryImages;
import com.microsoft.azure.management.compute.Snapshots;
import com.microsoft.azure.management.compute.VirtualMachineCustomImages;
import com.microsoft.azure.management.compute.VirtualMachineImages;
import com.microsoft.azure.management.compute.VirtualMachineScaleSets;
import com.microsoft.azure.management.compute.VirtualMachines;
import com.microsoft.azure.management.compute.implementation.ComputeManager;
import com.microsoft.azure.management.containerinstance.ContainerGroups;
import com.microsoft.azure.management.containerinstance.implementation.ContainerInstanceManager;
import com.microsoft.azure.management.containerregistry.Registries;
import com.microsoft.azure.management.containerregistry.RegistryTaskRuns;
import com.microsoft.azure.management.containerregistry.RegistryTasks;
import com.microsoft.azure.management.containerregistry.implementation.ContainerRegistryManager;
import com.microsoft.azure.management.containerservice.ContainerServices;
import com.microsoft.azure.management.containerservice.KubernetesClusters;
import com.microsoft.azure.management.containerservice.implementation.ContainerServiceManager;
import com.microsoft.azure.management.cosmosdb.CosmosDBAccounts;
import com.microsoft.azure.management.cosmosdb.implementation.CosmosDBManager;
import com.microsoft.azure.management.dns.DnsZones;
import com.microsoft.azure.management.dns.implementation.DnsZoneManager;
import com.microsoft.azure.management.eventhub.EventHubDisasterRecoveryPairings;
import com.microsoft.azure.management.eventhub.EventHubNamespaces;
import com.microsoft.azure.management.eventhub.EventHubs;
import com.microsoft.azure.management.eventhub.implementation.EventHubManager;
import com.microsoft.azure.management.graphrbac.ActiveDirectoryApplications;
import com.microsoft.azure.management.graphrbac.ActiveDirectoryGroups;
import com.microsoft.azure.management.graphrbac.ActiveDirectoryUsers;
import com.microsoft.azure.management.graphrbac.RoleAssignments;
import com.microsoft.azure.management.graphrbac.RoleDefinitions;
import com.microsoft.azure.management.graphrbac.ServicePrincipals;
import com.microsoft.azure.management.graphrbac.implementation.GraphRbacManager;
import com.microsoft.azure.management.keyvault.Vaults;
import com.microsoft.azure.management.keyvault.implementation.KeyVaultManager;
import com.microsoft.azure.management.locks.ManagementLocks;
import com.microsoft.azure.management.locks.implementation.AuthorizationManager;
import com.microsoft.azure.management.monitor.ActionGroups;
import com.microsoft.azure.management.monitor.ActivityLogs;
import com.microsoft.azure.management.monitor.AlertRules;
import com.microsoft.azure.management.monitor.AutoscaleSettings;
import com.microsoft.azure.management.monitor.DiagnosticSettings;
import com.microsoft.azure.management.monitor.MetricDefinitions;
import com.microsoft.azure.management.monitor.implementation.MonitorManager;
import com.microsoft.azure.management.msi.Identities;
import com.microsoft.azure.management.msi.implementation.MSIManager;
import com.microsoft.azure.management.network.ApplicationGateways;
import com.microsoft.azure.management.network.ApplicationSecurityGroups;
import com.microsoft.azure.management.network.DdosProtectionPlans;
import com.microsoft.azure.management.network.ExpressRouteCircuits;
import com.microsoft.azure.management.network.ExpressRouteCrossConnections;
import com.microsoft.azure.management.network.LoadBalancers;
import com.microsoft.azure.management.network.LocalNetworkGateways;
import com.microsoft.azure.management.network.NetworkInterfaces;
import com.microsoft.azure.management.network.NetworkSecurityGroups;
import com.microsoft.azure.management.network.NetworkUsages;
import com.microsoft.azure.management.network.NetworkWatchers;
import com.microsoft.azure.management.network.Networks;
import com.microsoft.azure.management.network.PublicIPAddresses;
import com.microsoft.azure.management.network.PublicIPPrefixes;
import com.microsoft.azure.management.network.RouteFilters;
import com.microsoft.azure.management.network.RouteTables;
import com.microsoft.azure.management.network.VirtualNetworkGateways;
import com.microsoft.azure.management.network.implementation.NetworkManager;
import com.microsoft.azure.management.redis.RedisCaches;
import com.microsoft.azure.management.redis.implementation.RedisManager;
import com.microsoft.azure.management.resources.Deployments;
import com.microsoft.azure.management.resources.Features;
import com.microsoft.azure.management.resources.GenericResources;
import com.microsoft.azure.management.resources.PolicyAssignments;
import com.microsoft.azure.management.resources.PolicyDefinitions;
import com.microsoft.azure.management.resources.Providers;
import com.microsoft.azure.management.resources.ResourceGroups;
import com.microsoft.azure.management.resources.Subscription;
import com.microsoft.azure.management.resources.Subscriptions;
import com.microsoft.azure.management.resources.TagOperations;
import com.microsoft.azure.management.resources.Tenants;
import com.microsoft.azure.management.resources.fluentcore.arm.AzureConfigurable;
import com.microsoft.azure.management.resources.fluentcore.arm.implementation.AzureConfigurableImpl;
import com.microsoft.azure.management.resources.fluentcore.utils.ProviderRegistrationInterceptor;
import com.microsoft.azure.management.resources.fluentcore.utils.ResourceManagerThrottlingInterceptor;
import com.microsoft.azure.management.resources.implementation.ResourceManager;
import com.microsoft.azure.management.search.SearchServices;
import com.microsoft.azure.management.search.implementation.SearchServiceManager;
import com.microsoft.azure.management.servicebus.ServiceBusNamespaces;
import com.microsoft.azure.management.servicebus.implementation.ServiceBusManager;
import com.microsoft.azure.management.sql.SqlServers;
import com.microsoft.azure.management.sql.implementation.SqlServerManager;
import com.microsoft.azure.management.storage.BlobContainers;
import com.microsoft.azure.management.storage.BlobServices;
import com.microsoft.azure.management.storage.ManagementPolicies;
import com.microsoft.azure.management.storage.StorageAccounts;
import com.microsoft.azure.management.storage.StorageSkus;
import com.microsoft.azure.management.storage.Usages;
import com.microsoft.azure.management.storage.implementation.StorageManager;
import com.microsoft.azure.management.trafficmanager.TrafficManagerProfiles;
import com.microsoft.azure.management.trafficmanager.implementation.TrafficManager;
import com.microsoft.azure.serializer.AzureJacksonAdapter;
import com.microsoft.rest.RestClient;

import java.io.File;
import java.io.IOException;

/**
 * The entry point for accessing resource management APIs in Azure.
 *
 * A new set of management libraries are now Generally Available. For documentation on how to use the new libraries, please @see <a href="https://aka.ms/azsdk/java/mgmt">the new libraries for Azure resource management</a>.
 */
public final class Azure implements AzureInterface {
    private final ResourceManager resourceManager;
    private final StorageManager storageManager;
    private final ComputeManager computeManager;
    private final NetworkManager networkManager;
    private final KeyVaultManager keyVaultManager;
    private final BatchManager batchManager;
    private final BatchAIManager batchAIManager;
    private final TrafficManager trafficManager;
    private final RedisManager redisManager;
    private final CdnManager cdnManager;
    private final DnsZoneManager dnsZoneManager;
    private final AppServiceManager appServiceManager;
    private final SqlServerManager sqlServerManager;
    private final ServiceBusManager serviceBusManager;
    private final ContainerInstanceManager containerInstanceManager;
    private final ContainerRegistryManager containerRegistryManager;
    private final ContainerServiceManager containerServiceManager;
    private final SearchServiceManager searchServiceManager;
    private final CosmosDBManager cosmosDBManager;
    private final AuthorizationManager authorizationManager;
    private final MSIManager msiManager;
    private final MonitorManager monitorManager;
    private final EventHubManager eventHubManager;
    private final String subscriptionId;
    private final Authenticated authenticated;

    /**
     * Authenticate to Azure using an Azure credentials object.
     *
     * @param credentials the credentials object
     * @return the authenticated Azure client
     */
    public static Authenticated authenticate(AzureTokenCredentials credentials) {
        return new AuthenticatedImpl(new RestClient.Builder()
                .withBaseUrl(credentials.environment(), AzureEnvironment.Endpoint.RESOURCE_MANAGER)
                .withCredentials(credentials)
                .withSerializerAdapter(new AzureJacksonAdapter())
                .withResponseBuilderFactory(new AzureResponseBuilder.Factory())
                .withInterceptor(new ProviderRegistrationInterceptor(credentials))
                .withInterceptor(new ResourceManagerThrottlingInterceptor())
                .build(), credentials.domain());
    }

    /**
     * Authenticates API access using a properties file containing the required credentials.
     * @param credentialsFile the file containing the credentials in the standard Java properties file format,
     * with the following keys:<p>
     * <code>
        *   subscription= #subscription ID<br>
        *   tenant= #tenant ID<br>
        *   client= #client id<br>
        *   key= #client key<br>
        *   managementURI= #management URI<br>
        *   baseURL= #base URL<br>
        *   authURL= #authentication URL<br>
     *</code>
     * @return authenticated Azure client
     * @throws IOException exception thrown from file access
     */
    public static Authenticated authenticate(File credentialsFile) throws IOException {
        ApplicationTokenCredentials credentials = ApplicationTokenCredentials.fromFile(credentialsFile);
        return new AuthenticatedImpl(new RestClient.Builder()
                .withBaseUrl(credentials.environment(), AzureEnvironment.Endpoint.RESOURCE_MANAGER)
                .withCredentials(credentials)
                .withSerializerAdapter(new AzureJacksonAdapter())
                .withResponseBuilderFactory(new AzureResponseBuilder.Factory())
                .withInterceptor(new ProviderRegistrationInterceptor(credentials))
                .withInterceptor(new ResourceManagerThrottlingInterceptor())
                .build(), credentials.domain()).withDefaultSubscription(credentials.defaultSubscriptionId());
    }

    /**
     * Authenticates API access using a RestClient instance.
     * @param restClient the RestClient configured with Azure authentication credentials
     * @param tenantId the tenantId in Active Directory
     * @return authenticated Azure client
     */
    public static Authenticated authenticate(RestClient restClient, String tenantId) {
        return new AuthenticatedImpl(restClient, tenantId);
    }

    /**
     * Authenticates API access using a RestClient instance.
     * @param restClient the RestClient configured with Azure authentication credentials
     * @param tenantId the tenantId in Active Directory
     * @param subscriptionId the ID of the subscription
     * @return authenticated Azure client
     */
    public static Authenticated authenticate(RestClient restClient, String tenantId, String subscriptionId) {
        return new AuthenticatedImpl(restClient, tenantId).withDefaultSubscription(subscriptionId);
    }

    /**
     * @return an interface allow configurations on the client.
     */
    public static Configurable configure() {
        return new ConfigurableImpl();
    }

    /**
     * The interface allowing configurations to be made on the client.
     */
    public interface Configurable extends AzureConfigurable<Configurable> {
        /**
         * Authenticates API access based on the provided credentials.
         *
         * @param credentials The credentials to authenticate API access with
         * @return the authenticated Azure client
         */
        Authenticated authenticate(AzureTokenCredentials credentials);

        /**
         * Authenticates API access using a properties file containing the required credentials.
         *
         * @param credentialsFile the file containing the credentials in the standard Java properties file format following
         * the same schema as {@link Azure#authenticate(File)}.<p>
         * @return Authenticated Azure client
          * @throws IOException exceptions thrown from file access
          */
        Authenticated authenticate(File credentialsFile) throws IOException;
    }

    /**
     * The implementation for {@link Configurable}.
     */
    private static final class ConfigurableImpl extends AzureConfigurableImpl<Configurable> implements Configurable {
        @Override
        public Authenticated authenticate(AzureTokenCredentials credentials) {
            if (credentials.defaultSubscriptionId() != null) {
                return Azure.authenticate(buildRestClient(credentials), credentials.domain(), credentials.defaultSubscriptionId());
            } else {
                return Azure.authenticate(buildRestClient(credentials), credentials.domain());
            }
        }

        @Override
        public Authenticated authenticate(File credentialsFile) throws IOException {
            ApplicationTokenCredentials credentials = ApplicationTokenCredentials.fromFile(credentialsFile);
            return Azure.authenticate(buildRestClient(credentials), credentials.domain(), credentials.defaultSubscriptionId());
        }
    }

    /**
     * Provides authenticated access to a subset of Azure APIs that do not require a specific subscription.
     * <p>
     * To access the subscription-specific APIs, use {@link Authenticated#withSubscription(String)},
     * or withDefaultSubscription() if a default subscription has already been previously specified
     * (for example, in a previously specified authentication file).
     */
    public interface Authenticated extends AccessManagement {
        /**
         * @return the currently selected tenant ID this client is authenticated to work with
         */
        String tenantId();

        /**
         * Entry point to subscription management APIs.
         *
         * @return Subscriptions interface providing access to subscription management
         */
        Subscriptions subscriptions();

        /**
         * Entry point to tenant management APIs.
         *
         * @return Tenants interface providing access to tenant management
         */
        Tenants tenants();

        /**
         * Selects a specific subscription for the APIs to work with.
         * <p>
         * Most Azure APIs require a specific subscription to be selected.
         *
         * @param subscriptionId the ID of the subscription
         * @return an authenticated Azure client configured to work with the specified subscription
         */
        Azure withSubscription(String subscriptionId);

        /**
         * Selects the default subscription as the subscription for the APIs to work with.
         * <p>
         * The default subscription can be specified inside the authentication file using {@link Azure#authenticate(File)}.
         * If no default subscription has been previously provided, the first subscription as
         * returned by {@link Authenticated#subscriptions()} will be selected.
         * @return an authenticated Azure client configured to work with the default subscription
         * @throws CloudException exception thrown from Azure
         * @throws IOException exception thrown from serialization/deserialization
         */
        Azure withDefaultSubscription() throws CloudException, IOException;
    }

    /**
     * The implementation for the Authenticated interface.
     */
    private static final class AuthenticatedImpl implements Authenticated {
        private final RestClient restClient;
        private final ResourceManager.Authenticated resourceManagerAuthenticated;
        private final GraphRbacManager graphRbacManager;
        private String defaultSubscription;
        private String tenantId;

        private AuthenticatedImpl(RestClient restClient, String tenantId) {
            this.resourceManagerAuthenticated = ResourceManager.authenticate(restClient);
            this.graphRbacManager = GraphRbacManager.authenticate(restClient, tenantId);
            this.restClient = restClient;
            this.tenantId = tenantId;
        }

        private AuthenticatedImpl withDefaultSubscription(String subscriptionId) {
            this.defaultSubscription = subscriptionId;
            return this;
        }

        @Override
        public String tenantId() {
            return tenantId;
        }

        @Override
        public Subscriptions subscriptions() {
            return resourceManagerAuthenticated.subscriptions();
        }

        @Override
        public Tenants tenants() {
            return resourceManagerAuthenticated.tenants();
        }

        @Override
        public ActiveDirectoryUsers activeDirectoryUsers() {
            return graphRbacManager.users();
        }

        @Override
        public ActiveDirectoryGroups activeDirectoryGroups() {
            return graphRbacManager.groups();
        }

        @Override
        public ServicePrincipals servicePrincipals() {
            return graphRbacManager.servicePrincipals();
        }

        @Override
        public ActiveDirectoryApplications activeDirectoryApplications() {
            return graphRbacManager.applications();
        }

        @Override
        public RoleDefinitions roleDefinitions() {
            return graphRbacManager.roleDefinitions();
        }

        @Override
        public RoleAssignments roleAssignments() {
            return graphRbacManager.roleAssignments();
        }

        @Override
        public Azure withSubscription(String subscriptionId) {
            return new Azure(restClient, subscriptionId, tenantId, this);
        }

        @Override
        public Azure withDefaultSubscription() throws CloudException, IOException {
            if (this.defaultSubscription != null) {
                return withSubscription(this.defaultSubscription);
            } else {
                PagedList<Subscription> subs = this.subscriptions().list();
                if (!subs.isEmpty()) {
                    return withSubscription(subs.get(0).subscriptionId());
                } else {
                    return withSubscription(null);
                }
            }
        }
    }

    private Azure(RestClient restClient, String subscriptionId, String tenantId, Authenticated authenticated) {
        this.resourceManager = ResourceManager.authenticate(restClient).withSubscription(subscriptionId);
        this.storageManager = StorageManager.authenticate(restClient, subscriptionId);
        this.computeManager = ComputeManager.authenticate(restClient, subscriptionId);
        this.networkManager = NetworkManager.authenticate(restClient, subscriptionId);
        this.keyVaultManager = KeyVaultManager.authenticate(restClient, tenantId, subscriptionId);
        this.batchManager = BatchManager.authenticate(restClient, subscriptionId);
        this.batchAIManager = BatchAIManager.authenticate(restClient, subscriptionId);
        this.trafficManager = TrafficManager.authenticate(restClient, subscriptionId);
        this.redisManager = RedisManager.authenticate(restClient, subscriptionId);
        this.cdnManager = CdnManager.authenticate(restClient, subscriptionId);
        this.dnsZoneManager = DnsZoneManager.authenticate(restClient, subscriptionId);
        this.appServiceManager = AppServiceManager.authenticate(restClient, tenantId, subscriptionId);
        this.sqlServerManager = SqlServerManager.authenticate(restClient, tenantId, subscriptionId);
        this.serviceBusManager = ServiceBusManager.authenticate(restClient, subscriptionId);
        this.containerInstanceManager = ContainerInstanceManager.authenticate(restClient, subscriptionId);
        this.containerRegistryManager = ContainerRegistryManager.authenticate(restClient, subscriptionId);
        this.containerServiceManager = ContainerServiceManager.authenticate(restClient, subscriptionId);
        this.cosmosDBManager = CosmosDBManager.authenticate(restClient, subscriptionId);
        this.searchServiceManager = SearchServiceManager.authenticate(restClient, subscriptionId);
        this.authorizationManager = AuthorizationManager.authenticate(restClient, subscriptionId);
        this.msiManager = MSIManager.authenticate(restClient, subscriptionId);
        this.monitorManager = MonitorManager.authenticate(restClient, subscriptionId);
        this.eventHubManager = EventHubManager.authenticate(restClient, subscriptionId);
        this.subscriptionId = subscriptionId;
        this.authenticated = authenticated;
    }

    /**
     * @return the currently selected subscription ID this client is authenticated to work with
     */
    @Override
    public String subscriptionId() {
        return this.subscriptionId;
    }

    /**
     * @return the currently tenant ID this client is authenticated to work with
     */
    public String tenantId() {
        return this.authenticated.tenantId();
    }

    /**
     * @return the currently selected subscription this client is authenticated to work with
     */
    @Override
    public Subscription getCurrentSubscription() {
        return this.subscriptions().getById(this.subscriptionId());
    }

    /**
     * @return entry point to managing subscriptions
     */
    @Override
    public Subscriptions subscriptions() {
        return this.resourceManager.subscriptions();
    }

    /**
     * @return entry point to managing tenants
     */
    public Tenants tenants() {
        return this.resourceManager.tenants();
    }

    /**
     * @return entry point to managing resource groups
     */
    @Override
    public ResourceGroups resourceGroups() {
        return this.resourceManager.resourceGroups();
    }

    /**
     * @return entry point to managing deployments
     */
    @Override
    public Deployments deployments() {
        return this.resourceManager.deployments();
    }

    /**
     * @return entry point to managing generic resources
     */
    @Override
    public GenericResources genericResources() {
        return resourceManager.genericResources();
    }

    /**
     * @return entry point to managing management locks
     */
    public ManagementLocks managementLocks() {
        return this.authorizationManager.managementLocks();
    }

    /**
     * @return entry point to managing features
     */
    @Override
    public Features features() {
        return resourceManager.features();
    }

    /**
     * @return entry point to managing resource providers
     */
    @Override
    public Providers providers() {
        return resourceManager.providers();
    }

    /**
     * @return entry point to managing policy definitions.
     */
    @Override
    public PolicyDefinitions policyDefinitions() {
        return resourceManager.policyDefinitions();
    }

    /**
     * @return entry point to managing policy assignments.
     */
    @Override
    public PolicyAssignments policyAssignments() {
        return resourceManager.policyAssignments();
    }

    /**
     * @return entry point to managing storage accounts
     */
    @Override
    public StorageAccounts storageAccounts() {
        return storageManager.storageAccounts();
    }

    /**
     * @return entry point to managing storage account usages
     */
    @Override
    public Usages storageUsages() {
        return storageManager.usages();
    }

    /**
     * @return entry point to managing storage service SKUs
     */
    public StorageSkus storageSkus() {
        return storageManager.storageSkus();
    }

    /**
     * @return entry point to managing availability sets
     */
    @Override
    public AvailabilitySets availabilitySets() {
        return computeManager.availabilitySets();
    }

    /**
     * @return entry point to managing virtual networks
     */
    @Override
    public Networks networks() {
        return networkManager.networks();
    }

    /**
     * @return entry point to managing route tables
     */
    @Override
    public RouteTables routeTables() {
        return networkManager.routeTables();
    }

    /**
     * @return entry point to managing load balancers
     */
    @Override
    public LoadBalancers loadBalancers() {
        return networkManager.loadBalancers();
    }

    /**
     * @return entry point to managing application gateways
     */
    @Override
    public ApplicationGateways applicationGateways() {
        return networkManager.applicationGateways();
    }

    /**
     * @return entry point to managing network security groups
     */
    @Override
    public NetworkSecurityGroups networkSecurityGroups() {
        return networkManager.networkSecurityGroups();
    }

    /**
     * @return entry point to managing network resource usages
     */
    @Override
    public NetworkUsages networkUsages() {
        return networkManager.usages();
    }

    /**
     * @return entry point to managing network watchers
     */
    @Override
    public NetworkWatchers networkWatchers() {
        return networkManager.networkWatchers();
    }

    /**
     * @return entry point to managing virtual network gateways
     */
    @Override
    public VirtualNetworkGateways virtualNetworkGateways() {
        return networkManager.virtualNetworkGateways();
    }

    /**
     * @return entry point to managing local network gateways
     */
    @Override
    public LocalNetworkGateways localNetworkGateways() {
        return networkManager.localNetworkGateways();
    }

    /**
     * @return entry point to managing express route circuits
     */
    @Beta(SinceVersion.V1_4_0)
    public ExpressRouteCircuits expressRouteCircuits() {
        return networkManager.expressRouteCircuits();
    }

    /**
     * @return entry point to managing express route cross connections
     */
    @Beta(SinceVersion.V1_11_0)
    public ExpressRouteCrossConnections expressRouteCrossConnections() {
        return networkManager.expressRouteCrossConnections();
    }

    /**
     * @return entry point to managing express route circuits
     */
    @Beta(SinceVersion.V1_10_0)
    public ApplicationSecurityGroups applicationSecurityGroups() {
        return networkManager.applicationSecurityGroups();
    }

    /**
     * @return entry point to managing route filters
     */
    @Beta(SinceVersion.V1_10_0)
    public RouteFilters routeFilters() {
        return networkManager.routeFilters();
    }

    /**
     * @return entry point to managing DDoS protection plans
     */
    @Beta(SinceVersion.V1_10_0)
    public DdosProtectionPlans ddosProtectionPlans() {
        return networkManager.ddosProtectionPlans();
    }

    /**
     * @return entry point to managing virtual machines
     */
    @Override
    public VirtualMachines virtualMachines() {
        return computeManager.virtualMachines();
    }

    /**
     * @return entry point to managing virtual machine scale sets.
     */
    @Override
    public VirtualMachineScaleSets virtualMachineScaleSets() {
        return computeManager.virtualMachineScaleSets();
    }

    /**
     * @return entry point to managing virtual machine images
     */
    @Override
    public VirtualMachineImages virtualMachineImages() {
        return computeManager.virtualMachineImages();
    }

    /**
     * @return entry point to managing virtual machine custom images
     */
    @Override
    public VirtualMachineCustomImages virtualMachineCustomImages() {
        return computeManager.virtualMachineCustomImages();
    }

    /**
     * @return entry point to managing managed disks
     */
    @Override
    public Disks disks() {
        return computeManager.disks();
    }

    /**
     * @return entry point to managing managed snapshots
     */
    @Override
    public Snapshots snapshots() {
        return computeManager.snapshots();
    }

    /**
     * @return the compute service SKU management API entry point
     */
    public ComputeSkus computeSkus() {
        return computeManager.computeSkus();
    }

    /**
     * @return entry point to managing public IP addresses
     */
    @Override
    public PublicIPAddresses publicIPAddresses() {
        return this.networkManager.publicIPAddresses();
    }

    /**
     * @return entry point to managing public IP prefixes
     */
    public PublicIPPrefixes publicIPPrefixes() {
        return this.networkManager.publicIPPrefixes();
    }

    /**
     * @return entry point to managing network interfaces
     */
    @Override
    public NetworkInterfaces networkInterfaces() {
        return this.networkManager.networkInterfaces();
    }

    /**
     * @return entry point to managing compute resource usages
     */
    @Override
    public ComputeUsages computeUsages() {
        return computeManager.usages();
    }

    /**
     * @return entry point to managing key vaults
     */
    @Override
    public Vaults vaults() {
        return this.keyVaultManager.vaults();
    }

    /**
     * @return entry point to managing batch accounts.
     */
    @Override
    public BatchAccounts batchAccounts() {
        return batchManager.batchAccounts();
    }

    /**
     * @return entry point to managing batch AI clusters.
     */
    @Beta(SinceVersion.V1_12_0)
    public BatchAIWorkspaces batchAIWorkspaces() {
        return batchAIManager.workspaces();
    }

    /**
     * @return entry point to managing batch AI usages.
     */
    @Beta(SinceVersion.V1_12_0)
    public BatchAIUsages batchAIUsages() {
        return batchAIManager.usages();
    }

    /**
     * @return entry point to managing traffic manager profiles.
     */
    @Override
    public TrafficManagerProfiles trafficManagerProfiles() {
        return trafficManager.profiles();
    }

    /**
     * @return entry point to managing Redis Caches.
     */
    @Override
    public RedisCaches redisCaches() {
        return redisManager.redisCaches();
    }

    /**
     * @return entry point to managing cdn manager profiles.
     */
    @Override
    public CdnProfiles cdnProfiles() {
        return cdnManager.profiles();
    }

    /**
     * @return entry point to managing DNS zones.
     */
    @Override
    public DnsZones dnsZones() {
        return dnsZoneManager.zones();
    }

    /**
     * @return entry point to managing web apps.
     */
    @Override
    @Beta
    public WebApps webApps() {
        return appServiceManager.webApps();
    }

    /**
     * @return entry point to managing function apps.
     */
    @Override
    @Beta
    public FunctionApps functionApps() {
        return appServiceManager.functionApps();
    }

    /**
     * @return entry point to managing app services.
     */
    @Beta
    public AppServiceManager appServices() {
        return appServiceManager;
    }

    /**
     * @return entry point to managing Sql server.
     */
    @Override
    public SqlServers sqlServers() {
        return sqlServerManager.sqlServers();
    }

    /**
     * @return entry point to managing Service Bus.
     */
    @Override
    @Beta
    public ServiceBusNamespaces serviceBusNamespaces() {
        return serviceBusManager.namespaces();
    }

    /**
     * @return entry point to managing Service Bus operations.
     */
    // TODO: To be revisited in the future
    //@Beta(SinceVersion.V1_1_0)
    //public ServiceBusOperations serviceBusOperations() {
    //    return serviceBusManager.operations();
    //}

    /**
     * @return entry point to managing Container Services.
     */
    @Override
    @Beta(SinceVersion.V1_4_0)
    public ContainerServices containerServices() {
        return containerServiceManager.containerServices();
    }

    /**
     * @return entry point to managing Kubernetes clusters.
     */
    @Override
    @Beta(SinceVersion.V1_4_0)
    public KubernetesClusters kubernetesClusters() {
        return containerServiceManager.kubernetesClusters();
    }

    /**
     * @return entry point to managing Azure Container Instances.
     */
    @Override
    @Beta(SinceVersion.V1_3_0)
    public ContainerGroups containerGroups() {
        return containerInstanceManager.containerGroups();
    }

    /**
     * @return entry point to managing Container Registries.
     */
    @Override
    @Beta(SinceVersion.V1_1_0)
    public Registries containerRegistries() {
        return containerRegistryManager.containerRegistries();
    }

    /**
     * @return entry point to managing Container Registry RegistryTasks.
     */
    @Beta
    public RegistryTasks containerRegistryTasks() {
        return containerRegistryManager.containerRegistryTasks();
    }

    /**
     * @return entry point to managing Container Registry RegistryTask Runs.
     */
    @Beta
    public RegistryTaskRuns containerRegistryTaskRuns() {
        return containerRegistryManager.registryTaskRuns();
    }

    /**
     * @return entry point to managing Container Regsitries.
     */
    @Override
    @Beta(SinceVersion.V1_2_0)
    public CosmosDBAccounts cosmosDBAccounts() {
        return cosmosDBManager.databaseAccounts();
    }

    /**
     * @return entry point to managing Search services.
     */
    @Override
    @Beta(SinceVersion.V1_2_0)
    public SearchServices searchServices() {
        return searchServiceManager.searchServices();
    }

    /**
     * @return entry point to managing Managed Service Identity (MSI) identities.
     */
    @Beta(Beta.SinceVersion.V1_5_1)
    public Identities identities() {
        return msiManager.identities();
    }

    /**
     * @return entry point to authentication and authorization management in Azure
     */
    @Override
    @Beta(SinceVersion.V1_2_0)
    public AccessManagement accessManagement() {
        return this.authenticated;
    }

    /**
     * @return entry point to listing activity log events in Azure
     */
    @Beta(SinceVersion.V1_6_0)
    public ActivityLogs activityLogs() {
        return this.monitorManager.activityLogs();
    }

    /**
     * @return entry point to listing metric definitions in Azure
     */
    @Beta(SinceVersion.V1_6_0)
    public MetricDefinitions metricDefinitions() {
        return this.monitorManager.metricDefinitions();
    }

    /**
     * @return entry point to listing diagnostic settings in Azure
     */
    @Beta(SinceVersion.V1_8_0)
    public DiagnosticSettings diagnosticSettings() {
        return this.monitorManager.diagnosticSettings();
    }

    /**
     * @return entry point to managing action groups in Azure
     */
    @Beta(SinceVersion.V1_9_0)
    public ActionGroups actionGroups() {
        return this.monitorManager.actionGroups();
    }

    /**
     * @return entry point to managing alertRules in Azure
     */
    @Beta(SinceVersion.V1_15_0)
    public AlertRules alertRules() {
        return this.monitorManager.alertRules();
    }


    /**
     * @return entry point to managing Autoscale Settings in Azure
     */
    @Beta(SinceVersion.V1_15_0)
    public AutoscaleSettings autoscaleSettings() {
        return this.monitorManager.autoscaleSettings();
    }

    /**
     * @return entry point to managing event hub namespaces.
     */
    @Beta(SinceVersion.V1_7_0)
    public EventHubNamespaces eventHubNamespaces() {
        return this.eventHubManager.namespaces();
    }

    /**
     * @return entry point to managing event hubs.
     */
    @Beta(SinceVersion.V1_7_0)
    public EventHubs eventHubs() {
        return this.eventHubManager.eventHubs();
    }

    /**
     * @return entry point to managing event hub namespace geo disaster recovery.
     */
    @Beta(SinceVersion.V1_7_0)
    public EventHubDisasterRecoveryPairings eventHubDisasterRecoveryPairings() {
        return this.eventHubManager.eventHubDisasterRecoveryPairings();
    }

    /**
     * @return entry point to manage compute galleries.
     */
    @Beta(Beta.SinceVersion.V1_15_0)
    public Galleries galleries() {
        return this.computeManager.galleries();
    }

    /**
     * @return entry point to manage compute gallery images.
     */
    @Beta(Beta.SinceVersion.V1_15_0)
    public GalleryImages galleryImages() {
        return this.computeManager.galleryImages();
    }

    /**
     * @return entry point to manage compute gallery image versions.
     */
    @Beta(Beta.SinceVersion.V1_15_0)
    public GalleryImageVersions galleryImageVersions() {
        return this.computeManager.galleryImageVersions();
    }

    /**
     * @return the blob container management API entry point
     */
    public BlobContainers storageBlobContainers() {
        return this.storageManager.blobContainers();
    }

    /**
     * @return the blob service management API entry point
     */
    public BlobServices storageBlobServices() {
        return this.storageManager.blobServices();
    }

    /**
     * @return the blob service management API entry point
     */
    public ManagementPolicies storageManagementPolicies() {
        return this.storageManager.managementPolicies();
    }

    /** @return entry point to tag management management */
    public TagOperations tagOperations() {
        return this.resourceManager.tagOperations();
    }
}

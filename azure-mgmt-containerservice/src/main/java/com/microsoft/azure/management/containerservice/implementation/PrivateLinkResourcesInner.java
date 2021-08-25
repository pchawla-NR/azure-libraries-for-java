/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.containerservice.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.CloudException;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in PrivateLinkResources.
 */
public class PrivateLinkResourcesInner {
    /** The Retrofit service to perform REST calls. */
    private PrivateLinkResourcesService service;
    /** The service client containing this operation class. */
    private ContainerServiceManagementClientImpl client;

    /**
     * Initializes an instance of PrivateLinkResourcesInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public PrivateLinkResourcesInner(Retrofit retrofit, ContainerServiceManagementClientImpl client) {
        this.service = retrofit.create(PrivateLinkResourcesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for PrivateLinkResources to be
     * used by Retrofit to perform actually REST calls.
     */
    interface PrivateLinkResourcesService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.containerservice.PrivateLinkResources list" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.ContainerService/managedClusters/{resourceName}/privateLinkResources")
        Observable<Response<ResponseBody>> list(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("resourceName") String resourceName, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Gets a list of private link resources in the specified managed cluster.
     * Gets a list of private link resources in the specified managed cluster. The operation returns properties of each private link resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the managed cluster resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PrivateLinkResourcesListResultInner object if successful.
     */
    public PrivateLinkResourcesListResultInner list(String resourceGroupName, String resourceName) {
        return listWithServiceResponseAsync(resourceGroupName, resourceName).toBlocking().single().body();
    }

    /**
     * Gets a list of private link resources in the specified managed cluster.
     * Gets a list of private link resources in the specified managed cluster. The operation returns properties of each private link resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the managed cluster resource.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<PrivateLinkResourcesListResultInner> listAsync(String resourceGroupName, String resourceName, final ServiceCallback<PrivateLinkResourcesListResultInner> serviceCallback) {
        return ServiceFuture.fromResponse(listWithServiceResponseAsync(resourceGroupName, resourceName), serviceCallback);
    }

    /**
     * Gets a list of private link resources in the specified managed cluster.
     * Gets a list of private link resources in the specified managed cluster. The operation returns properties of each private link resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the managed cluster resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PrivateLinkResourcesListResultInner object
     */
    public Observable<PrivateLinkResourcesListResultInner> listAsync(String resourceGroupName, String resourceName) {
        return listWithServiceResponseAsync(resourceGroupName, resourceName).map(new Func1<ServiceResponse<PrivateLinkResourcesListResultInner>, PrivateLinkResourcesListResultInner>() {
            @Override
            public PrivateLinkResourcesListResultInner call(ServiceResponse<PrivateLinkResourcesListResultInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Gets a list of private link resources in the specified managed cluster.
     * Gets a list of private link resources in the specified managed cluster. The operation returns properties of each private link resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param resourceName The name of the managed cluster resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PrivateLinkResourcesListResultInner object
     */
    public Observable<ServiceResponse<PrivateLinkResourcesListResultInner>> listWithServiceResponseAsync(String resourceGroupName, String resourceName) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (resourceName == null) {
            throw new IllegalArgumentException("Parameter resourceName is required and cannot be null.");
        }
        final String apiVersion = "2020-09-01";
        return service.list(this.client.subscriptionId(), resourceGroupName, resourceName, apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<PrivateLinkResourcesListResultInner>>>() {
                @Override
                public Observable<ServiceResponse<PrivateLinkResourcesListResultInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PrivateLinkResourcesListResultInner> clientResponse = listDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PrivateLinkResourcesListResultInner> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PrivateLinkResourcesListResultInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PrivateLinkResourcesListResultInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}

/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceFuture;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.management.appservice.DefaultErrorResponseException;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in DomainRegistrationProviders.
 */
public class DomainRegistrationProvidersInner {
    /** The Retrofit service to perform REST calls. */
    private DomainRegistrationProvidersService service;
    /** The service client containing this operation class. */
    private WebSiteManagementClientImpl client;

    /**
     * Initializes an instance of DomainRegistrationProvidersInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public DomainRegistrationProvidersInner(Retrofit retrofit, WebSiteManagementClientImpl client) {
        this.service = retrofit.create(DomainRegistrationProvidersService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for DomainRegistrationProviders to be
     * used by Retrofit to perform actually REST calls.
     */
    interface DomainRegistrationProvidersService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.appservice.DomainRegistrationProviders listOperations" })
        @GET("providers/Microsoft.DomainRegistration/operations")
        Observable<Response<ResponseBody>> listOperations(@Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.appservice.DomainRegistrationProviders listOperationsNext" })
        @GET
        Observable<Response<ResponseBody>> listOperationsNext(@Url String nextUrl, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     * Description for Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws DefaultErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;CsmOperationDescriptionInner&gt; object if successful.
     */
    public PagedList<CsmOperationDescriptionInner> listOperations() {
        ServiceResponse<Page<CsmOperationDescriptionInner>> response = listOperationsSinglePageAsync().toBlocking().single();
        return new PagedList<CsmOperationDescriptionInner>(response.body()) {
            @Override
            public Page<CsmOperationDescriptionInner> nextPage(String nextPageLink) {
                return listOperationsNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     * Description for Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<CsmOperationDescriptionInner>> listOperationsAsync(final ListOperationCallback<CsmOperationDescriptionInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listOperationsSinglePageAsync(),
            new Func1<String, Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>> call(String nextPageLink) {
                    return listOperationsNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     * Description for Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;CsmOperationDescriptionInner&gt; object
     */
    public Observable<Page<CsmOperationDescriptionInner>> listOperationsAsync() {
        return listOperationsWithServiceResponseAsync()
            .map(new Func1<ServiceResponse<Page<CsmOperationDescriptionInner>>, Page<CsmOperationDescriptionInner>>() {
                @Override
                public Page<CsmOperationDescriptionInner> call(ServiceResponse<Page<CsmOperationDescriptionInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     * Description for Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;CsmOperationDescriptionInner&gt; object
     */
    public Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>> listOperationsWithServiceResponseAsync() {
        return listOperationsSinglePageAsync()
            .concatMap(new Func1<ServiceResponse<Page<CsmOperationDescriptionInner>>, Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>> call(ServiceResponse<Page<CsmOperationDescriptionInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listOperationsNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     * Description for Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;CsmOperationDescriptionInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>> listOperationsSinglePageAsync() {
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.listOperations(this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<CsmOperationDescriptionInner>> result = listOperationsDelegate(response);
                        return Observable.just(new ServiceResponse<Page<CsmOperationDescriptionInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<CsmOperationDescriptionInner>> listOperationsDelegate(Response<ResponseBody> response) throws DefaultErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<CsmOperationDescriptionInner>, DefaultErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<CsmOperationDescriptionInner>>() { }.getType())
                .registerError(DefaultErrorResponseException.class)
                .build(response);
    }

    /**
     * Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     * Description for Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws DefaultErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;CsmOperationDescriptionInner&gt; object if successful.
     */
    public PagedList<CsmOperationDescriptionInner> listOperationsNext(final String nextPageLink) {
        ServiceResponse<Page<CsmOperationDescriptionInner>> response = listOperationsNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<CsmOperationDescriptionInner>(response.body()) {
            @Override
            public Page<CsmOperationDescriptionInner> nextPage(String nextPageLink) {
                return listOperationsNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     * Description for Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<CsmOperationDescriptionInner>> listOperationsNextAsync(final String nextPageLink, final ServiceFuture<List<CsmOperationDescriptionInner>> serviceFuture, final ListOperationCallback<CsmOperationDescriptionInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listOperationsNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>> call(String nextPageLink) {
                    return listOperationsNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     * Description for Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;CsmOperationDescriptionInner&gt; object
     */
    public Observable<Page<CsmOperationDescriptionInner>> listOperationsNextAsync(final String nextPageLink) {
        return listOperationsNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<CsmOperationDescriptionInner>>, Page<CsmOperationDescriptionInner>>() {
                @Override
                public Page<CsmOperationDescriptionInner> call(ServiceResponse<Page<CsmOperationDescriptionInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     * Description for Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;CsmOperationDescriptionInner&gt; object
     */
    public Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>> listOperationsNextWithServiceResponseAsync(final String nextPageLink) {
        return listOperationsNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<CsmOperationDescriptionInner>>, Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>> call(ServiceResponse<Page<CsmOperationDescriptionInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listOperationsNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     * Description for Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     *
    ServiceResponse<PageImpl<CsmOperationDescriptionInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;CsmOperationDescriptionInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>> listOperationsNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listOperationsNext(nextUrl, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<CsmOperationDescriptionInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<CsmOperationDescriptionInner>> result = listOperationsNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<CsmOperationDescriptionInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<CsmOperationDescriptionInner>> listOperationsNextDelegate(Response<ResponseBody> response) throws DefaultErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<CsmOperationDescriptionInner>, DefaultErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<CsmOperationDescriptionInner>>() { }.getType())
                .registerError(DefaultErrorResponseException.class)
                .build(response);
    }

}

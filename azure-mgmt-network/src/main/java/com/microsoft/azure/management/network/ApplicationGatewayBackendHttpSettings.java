/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network;

import com.microsoft.azure.SubResource;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Backend address pool settings of an application gateway.
 */
@JsonFlatten
public class ApplicationGatewayBackendHttpSettings extends SubResource {
    /**
     * The destination port on the backend.
     */
    @JsonProperty(value = "properties.port")
    private Integer port;

    /**
     * The protocol used to communicate with the backend. Possible values
     * include: 'Http', 'Https'.
     */
    @JsonProperty(value = "properties.protocol")
    private ApplicationGatewayProtocol protocol;

    /**
     * Cookie based affinity. Possible values include: 'Enabled', 'Disabled'.
     */
    @JsonProperty(value = "properties.cookieBasedAffinity")
    private ApplicationGatewayCookieBasedAffinity cookieBasedAffinity;

    /**
     * Request timeout in seconds. Application Gateway will fail the request if
     * response is not received within RequestTimeout. Acceptable values are
     * from 1 second to 86400 seconds.
     */
    @JsonProperty(value = "properties.requestTimeout")
    private Integer requestTimeout;

    /**
     * Probe resource of an application gateway.
     */
    @JsonProperty(value = "properties.probe")
    private SubResource probe;

    /**
     * Array of references to application gateway authentication certificates.
     */
    @JsonProperty(value = "properties.authenticationCertificates")
    private List<SubResource> authenticationCertificates;

    /**
     * Array of references to application gateway trusted root certificates.
     */
    @JsonProperty(value = "properties.trustedRootCertificates")
    private List<SubResource> trustedRootCertificates;

    /**
     * Connection draining of the backend http settings resource.
     */
    @JsonProperty(value = "properties.connectionDraining")
    private ApplicationGatewayConnectionDraining connectionDraining;

    /**
     * Host header to be sent to the backend servers.
     */
    @JsonProperty(value = "properties.hostName")
    private String hostName;

    /**
     * Whether to pick host header should be picked from the host name of the
     * backend server. Default value is false.
     */
    @JsonProperty(value = "properties.pickHostNameFromBackendAddress")
    private Boolean pickHostNameFromBackendAddress;

    /**
     * Cookie name to use for the affinity cookie.
     */
    @JsonProperty(value = "properties.affinityCookieName")
    private String affinityCookieName;

    /**
     * Whether the probe is enabled. Default value is false.
     */
    @JsonProperty(value = "properties.probeEnabled")
    private Boolean probeEnabled;

    /**
     * Path which should be used as a prefix for all HTTP requests. Null means
     * no path will be prefixed. Default value is null.
     */
    @JsonProperty(value = "properties.path")
    private String path;

    /**
     * The provisioning state of the backend HTTP settings resource. Possible
     * values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * Name of the backend http settings that is unique within an Application
     * Gateway.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /**
     * Type of the resource.
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    /**
     * Get the destination port on the backend.
     *
     * @return the port value
     */
    public Integer port() {
        return this.port;
    }

    /**
     * Set the destination port on the backend.
     *
     * @param port the port value to set
     * @return the ApplicationGatewayBackendHttpSettings object itself.
     */
    public ApplicationGatewayBackendHttpSettings withPort(Integer port) {
        this.port = port;
        return this;
    }

    /**
     * Get the protocol used to communicate with the backend. Possible values include: 'Http', 'Https'.
     *
     * @return the protocol value
     */
    public ApplicationGatewayProtocol protocol() {
        return this.protocol;
    }

    /**
     * Set the protocol used to communicate with the backend. Possible values include: 'Http', 'Https'.
     *
     * @param protocol the protocol value to set
     * @return the ApplicationGatewayBackendHttpSettings object itself.
     */
    public ApplicationGatewayBackendHttpSettings withProtocol(ApplicationGatewayProtocol protocol) {
        this.protocol = protocol;
        return this;
    }

    /**
     * Get cookie based affinity. Possible values include: 'Enabled', 'Disabled'.
     *
     * @return the cookieBasedAffinity value
     */
    public ApplicationGatewayCookieBasedAffinity cookieBasedAffinity() {
        return this.cookieBasedAffinity;
    }

    /**
     * Set cookie based affinity. Possible values include: 'Enabled', 'Disabled'.
     *
     * @param cookieBasedAffinity the cookieBasedAffinity value to set
     * @return the ApplicationGatewayBackendHttpSettings object itself.
     */
    public ApplicationGatewayBackendHttpSettings withCookieBasedAffinity(ApplicationGatewayCookieBasedAffinity cookieBasedAffinity) {
        this.cookieBasedAffinity = cookieBasedAffinity;
        return this;
    }

    /**
     * Get request timeout in seconds. Application Gateway will fail the request if response is not received within RequestTimeout. Acceptable values are from 1 second to 86400 seconds.
     *
     * @return the requestTimeout value
     */
    public Integer requestTimeout() {
        return this.requestTimeout;
    }

    /**
     * Set request timeout in seconds. Application Gateway will fail the request if response is not received within RequestTimeout. Acceptable values are from 1 second to 86400 seconds.
     *
     * @param requestTimeout the requestTimeout value to set
     * @return the ApplicationGatewayBackendHttpSettings object itself.
     */
    public ApplicationGatewayBackendHttpSettings withRequestTimeout(Integer requestTimeout) {
        this.requestTimeout = requestTimeout;
        return this;
    }

    /**
     * Get probe resource of an application gateway.
     *
     * @return the probe value
     */
    public SubResource probe() {
        return this.probe;
    }

    /**
     * Set probe resource of an application gateway.
     *
     * @param probe the probe value to set
     * @return the ApplicationGatewayBackendHttpSettings object itself.
     */
    public ApplicationGatewayBackendHttpSettings withProbe(SubResource probe) {
        this.probe = probe;
        return this;
    }

    /**
     * Get array of references to application gateway authentication certificates.
     *
     * @return the authenticationCertificates value
     */
    public List<SubResource> authenticationCertificates() {
        return this.authenticationCertificates;
    }

    /**
     * Set array of references to application gateway authentication certificates.
     *
     * @param authenticationCertificates the authenticationCertificates value to set
     * @return the ApplicationGatewayBackendHttpSettings object itself.
     */
    public ApplicationGatewayBackendHttpSettings withAuthenticationCertificates(List<SubResource> authenticationCertificates) {
        this.authenticationCertificates = authenticationCertificates;
        return this;
    }

    /**
     * Get array of references to application gateway trusted root certificates.
     *
     * @return the trustedRootCertificates value
     */
    public List<SubResource> trustedRootCertificates() {
        return this.trustedRootCertificates;
    }

    /**
     * Set array of references to application gateway trusted root certificates.
     *
     * @param trustedRootCertificates the trustedRootCertificates value to set
     * @return the ApplicationGatewayBackendHttpSettings object itself.
     */
    public ApplicationGatewayBackendHttpSettings withTrustedRootCertificates(List<SubResource> trustedRootCertificates) {
        this.trustedRootCertificates = trustedRootCertificates;
        return this;
    }

    /**
     * Get connection draining of the backend http settings resource.
     *
     * @return the connectionDraining value
     */
    public ApplicationGatewayConnectionDraining connectionDraining() {
        return this.connectionDraining;
    }

    /**
     * Set connection draining of the backend http settings resource.
     *
     * @param connectionDraining the connectionDraining value to set
     * @return the ApplicationGatewayBackendHttpSettings object itself.
     */
    public ApplicationGatewayBackendHttpSettings withConnectionDraining(ApplicationGatewayConnectionDraining connectionDraining) {
        this.connectionDraining = connectionDraining;
        return this;
    }

    /**
     * Get host header to be sent to the backend servers.
     *
     * @return the hostName value
     */
    public String hostName() {
        return this.hostName;
    }

    /**
     * Set host header to be sent to the backend servers.
     *
     * @param hostName the hostName value to set
     * @return the ApplicationGatewayBackendHttpSettings object itself.
     */
    public ApplicationGatewayBackendHttpSettings withHostName(String hostName) {
        this.hostName = hostName;
        return this;
    }

    /**
     * Get whether to pick host header should be picked from the host name of the backend server. Default value is false.
     *
     * @return the pickHostNameFromBackendAddress value
     */
    public Boolean pickHostNameFromBackendAddress() {
        return this.pickHostNameFromBackendAddress;
    }

    /**
     * Set whether to pick host header should be picked from the host name of the backend server. Default value is false.
     *
     * @param pickHostNameFromBackendAddress the pickHostNameFromBackendAddress value to set
     * @return the ApplicationGatewayBackendHttpSettings object itself.
     */
    public ApplicationGatewayBackendHttpSettings withPickHostNameFromBackendAddress(Boolean pickHostNameFromBackendAddress) {
        this.pickHostNameFromBackendAddress = pickHostNameFromBackendAddress;
        return this;
    }

    /**
     * Get cookie name to use for the affinity cookie.
     *
     * @return the affinityCookieName value
     */
    public String affinityCookieName() {
        return this.affinityCookieName;
    }

    /**
     * Set cookie name to use for the affinity cookie.
     *
     * @param affinityCookieName the affinityCookieName value to set
     * @return the ApplicationGatewayBackendHttpSettings object itself.
     */
    public ApplicationGatewayBackendHttpSettings withAffinityCookieName(String affinityCookieName) {
        this.affinityCookieName = affinityCookieName;
        return this;
    }

    /**
     * Get whether the probe is enabled. Default value is false.
     *
     * @return the probeEnabled value
     */
    public Boolean probeEnabled() {
        return this.probeEnabled;
    }

    /**
     * Set whether the probe is enabled. Default value is false.
     *
     * @param probeEnabled the probeEnabled value to set
     * @return the ApplicationGatewayBackendHttpSettings object itself.
     */
    public ApplicationGatewayBackendHttpSettings withProbeEnabled(Boolean probeEnabled) {
        this.probeEnabled = probeEnabled;
        return this;
    }

    /**
     * Get path which should be used as a prefix for all HTTP requests. Null means no path will be prefixed. Default value is null.
     *
     * @return the path value
     */
    public String path() {
        return this.path;
    }

    /**
     * Set path which should be used as a prefix for all HTTP requests. Null means no path will be prefixed. Default value is null.
     *
     * @param path the path value to set
     * @return the ApplicationGatewayBackendHttpSettings object itself.
     */
    public ApplicationGatewayBackendHttpSettings withPath(String path) {
        this.path = path;
        return this;
    }

    /**
     * Get the provisioning state of the backend HTTP settings resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get name of the backend http settings that is unique within an Application Gateway.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set name of the backend http settings that is unique within an Application Gateway.
     *
     * @param name the name value to set
     * @return the ApplicationGatewayBackendHttpSettings object itself.
     */
    public ApplicationGatewayBackendHttpSettings withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get a unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get type of the resource.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

}

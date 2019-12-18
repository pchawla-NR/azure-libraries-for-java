/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.implementation;

import com.microsoft.azure.management.sql.ServerKeyType;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.ProxyResource;

/**
 * A server key.
 */
@JsonFlatten
public class ServerKeyInner extends ProxyResource {
    /**
     * Kind of encryption protector. This is metadata used for the Azure portal
     * experience.
     */
    @JsonProperty(value = "kind")
    private String kind;

    /**
     * Resource location.
     */
    @JsonProperty(value = "location", access = JsonProperty.Access.WRITE_ONLY)
    private String location;

    /**
     * Subregion of the server key.
     */
    @JsonProperty(value = "properties.subregion", access = JsonProperty.Access.WRITE_ONLY)
    private String subregion;

    /**
     * The server key type like 'ServiceManaged', 'AzureKeyVault'. Possible
     * values include: 'ServiceManaged', 'AzureKeyVault'.
     */
    @JsonProperty(value = "properties.serverKeyType", required = true)
    private ServerKeyType serverKeyType;

    /**
     * The URI of the server key.
     */
    @JsonProperty(value = "properties.uri")
    private String uri;

    /**
     * Thumbprint of the server key.
     */
    @JsonProperty(value = "properties.thumbprint")
    private String thumbprint;

    /**
     * The server key creation date.
     */
    @JsonProperty(value = "properties.creationDate")
    private DateTime creationDate;

    /**
     * Get kind of encryption protector. This is metadata used for the Azure portal experience.
     *
     * @return the kind value
     */
    public String kind() {
        return this.kind;
    }

    /**
     * Set kind of encryption protector. This is metadata used for the Azure portal experience.
     *
     * @param kind the kind value to set
     * @return the ServerKeyInner object itself.
     */
    public ServerKeyInner withKind(String kind) {
        this.kind = kind;
        return this;
    }

    /**
     * Get resource location.
     *
     * @return the location value
     */
    public String location() {
        return this.location;
    }

    /**
     * Get subregion of the server key.
     *
     * @return the subregion value
     */
    public String subregion() {
        return this.subregion;
    }

    /**
     * Get the server key type like 'ServiceManaged', 'AzureKeyVault'. Possible values include: 'ServiceManaged', 'AzureKeyVault'.
     *
     * @return the serverKeyType value
     */
    public ServerKeyType serverKeyType() {
        return this.serverKeyType;
    }

    /**
     * Set the server key type like 'ServiceManaged', 'AzureKeyVault'. Possible values include: 'ServiceManaged', 'AzureKeyVault'.
     *
     * @param serverKeyType the serverKeyType value to set
     * @return the ServerKeyInner object itself.
     */
    public ServerKeyInner withServerKeyType(ServerKeyType serverKeyType) {
        this.serverKeyType = serverKeyType;
        return this;
    }

    /**
     * Get the URI of the server key.
     *
     * @return the uri value
     */
    public String uri() {
        return this.uri;
    }

    /**
     * Set the URI of the server key.
     *
     * @param uri the uri value to set
     * @return the ServerKeyInner object itself.
     */
    public ServerKeyInner withUri(String uri) {
        this.uri = uri;
        return this;
    }

    /**
     * Get thumbprint of the server key.
     *
     * @return the thumbprint value
     */
    public String thumbprint() {
        return this.thumbprint;
    }

    /**
     * Set thumbprint of the server key.
     *
     * @param thumbprint the thumbprint value to set
     * @return the ServerKeyInner object itself.
     */
    public ServerKeyInner withThumbprint(String thumbprint) {
        this.thumbprint = thumbprint;
        return this;
    }

    /**
     * Get the server key creation date.
     *
     * @return the creationDate value
     */
    public DateTime creationDate() {
        return this.creationDate;
    }

    /**
     * Set the server key creation date.
     *
     * @param creationDate the creationDate value to set
     * @return the ServerKeyInner object itself.
     */
    public ServerKeyInner withCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

}

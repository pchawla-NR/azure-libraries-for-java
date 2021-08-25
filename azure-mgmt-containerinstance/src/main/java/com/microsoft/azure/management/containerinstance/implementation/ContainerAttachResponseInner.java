/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.containerinstance.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The information for the output stream from container attach.
 */
public class ContainerAttachResponseInner {
    /**
     * The uri for the output stream from the attach.
     */
    @JsonProperty(value = "webSocketUri")
    private String webSocketUri;

    /**
     * The password to the output stream from the attach. Send as an
     * Authorization header value when connecting to the websocketUri.
     */
    @JsonProperty(value = "password")
    private String password;

    /**
     * Get the uri for the output stream from the attach.
     *
     * @return the webSocketUri value
     */
    public String webSocketUri() {
        return this.webSocketUri;
    }

    /**
     * Set the uri for the output stream from the attach.
     *
     * @param webSocketUri the webSocketUri value to set
     * @return the ContainerAttachResponseInner object itself.
     */
    public ContainerAttachResponseInner withWebSocketUri(String webSocketUri) {
        this.webSocketUri = webSocketUri;
        return this;
    }

    /**
     * Get the password to the output stream from the attach. Send as an Authorization header value when connecting to the websocketUri.
     *
     * @return the password value
     */
    public String password() {
        return this.password;
    }

    /**
     * Set the password to the output stream from the attach. Send as an Authorization header value when connecting to the websocketUri.
     *
     * @param password the password value to set
     * @return the ContainerAttachResponseInner object itself.
     */
    public ContainerAttachResponseInner withPassword(String password) {
        this.password = password;
        return this;
    }

}

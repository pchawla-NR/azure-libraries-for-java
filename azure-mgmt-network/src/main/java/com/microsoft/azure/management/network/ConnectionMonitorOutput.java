/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes a connection monitor output destination.
 */
public class ConnectionMonitorOutput {
    /**
     * Connection monitor output destination type. Currently, only "Workspace"
     * is supported. Possible values include: 'Workspace'.
     */
    @JsonProperty(value = "type")
    private OutputType type;

    /**
     * Describes the settings for producing output into a log analytics
     * workspace.
     */
    @JsonProperty(value = "workspaceSettings")
    private ConnectionMonitorWorkspaceSettings workspaceSettings;

    /**
     * Get connection monitor output destination type. Currently, only "Workspace" is supported. Possible values include: 'Workspace'.
     *
     * @return the type value
     */
    public OutputType type() {
        return this.type;
    }

    /**
     * Set connection monitor output destination type. Currently, only "Workspace" is supported. Possible values include: 'Workspace'.
     *
     * @param type the type value to set
     * @return the ConnectionMonitorOutput object itself.
     */
    public ConnectionMonitorOutput withType(OutputType type) {
        this.type = type;
        return this;
    }

    /**
     * Get describes the settings for producing output into a log analytics workspace.
     *
     * @return the workspaceSettings value
     */
    public ConnectionMonitorWorkspaceSettings workspaceSettings() {
        return this.workspaceSettings;
    }

    /**
     * Set describes the settings for producing output into a log analytics workspace.
     *
     * @param workspaceSettings the workspaceSettings value to set
     * @return the ConnectionMonitorOutput object itself.
     */
    public ConnectionMonitorOutput withWorkspaceSettings(ConnectionMonitorWorkspaceSettings workspaceSettings) {
        this.workspaceSettings = workspaceSettings;
        return this;
    }

}

/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Properties of sync group schema.
 */
public class SyncGroupSchema {
    /**
     * List of tables in sync group schema.
     */
    @JsonProperty(value = "tables")
    private List<SyncGroupSchemaTable> tables;

    /**
     * Name of master sync member where the schema is from.
     */
    @JsonProperty(value = "masterSyncMemberName")
    private String masterSyncMemberName;

    /**
     * Get list of tables in sync group schema.
     *
     * @return the tables value
     */
    public List<SyncGroupSchemaTable> tables() {
        return this.tables;
    }

    /**
     * Set list of tables in sync group schema.
     *
     * @param tables the tables value to set
     * @return the SyncGroupSchema object itself.
     */
    public SyncGroupSchema withTables(List<SyncGroupSchemaTable> tables) {
        this.tables = tables;
        return this;
    }

    /**
     * Get name of master sync member where the schema is from.
     *
     * @return the masterSyncMemberName value
     */
    public String masterSyncMemberName() {
        return this.masterSyncMemberName;
    }

    /**
     * Set name of master sync member where the schema is from.
     *
     * @param masterSyncMemberName the masterSyncMemberName value to set
     * @return the SyncGroupSchema object itself.
     */
    public SyncGroupSchema withMasterSyncMemberName(String masterSyncMemberName) {
        this.masterSyncMemberName = masterSyncMemberName;
        return this;
    }

}

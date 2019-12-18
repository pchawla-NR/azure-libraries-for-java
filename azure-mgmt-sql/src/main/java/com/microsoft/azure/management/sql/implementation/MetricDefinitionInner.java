/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.implementation;

import com.microsoft.azure.management.sql.MetricName;
import com.microsoft.azure.management.sql.PrimaryAggregationType;
import com.microsoft.azure.management.sql.UnitDefinitionType;
import java.util.List;
import com.microsoft.azure.management.sql.MetricAvailability;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A database metric definition.
 */
public class MetricDefinitionInner {
    /**
     * The name information for the metric.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private MetricName name;

    /**
     * The primary aggregation type defining how metric values are displayed.
     * Possible values include: 'None', 'Average', 'Count', 'Minimum',
     * 'Maximum', 'Total'.
     */
    @JsonProperty(value = "primaryAggregationType", access = JsonProperty.Access.WRITE_ONLY)
    private PrimaryAggregationType primaryAggregationType;

    /**
     * The resource uri of the database.
     */
    @JsonProperty(value = "resourceUri", access = JsonProperty.Access.WRITE_ONLY)
    private String resourceUri;

    /**
     * The unit of the metric. Possible values include: 'Count', 'Bytes',
     * 'Seconds', 'Percent', 'CountPerSecond', 'BytesPerSecond'.
     */
    @JsonProperty(value = "unit", access = JsonProperty.Access.WRITE_ONLY)
    private UnitDefinitionType unit;

    /**
     * The list of database metric availabilities for the metric.
     */
    @JsonProperty(value = "metricAvailabilities", access = JsonProperty.Access.WRITE_ONLY)
    private List<MetricAvailability> metricAvailabilities;

    /**
     * Get the name information for the metric.
     *
     * @return the name value
     */
    public MetricName name() {
        return this.name;
    }

    /**
     * Get the primary aggregation type defining how metric values are displayed. Possible values include: 'None', 'Average', 'Count', 'Minimum', 'Maximum', 'Total'.
     *
     * @return the primaryAggregationType value
     */
    public PrimaryAggregationType primaryAggregationType() {
        return this.primaryAggregationType;
    }

    /**
     * Get the resource uri of the database.
     *
     * @return the resourceUri value
     */
    public String resourceUri() {
        return this.resourceUri;
    }

    /**
     * Get the unit of the metric. Possible values include: 'Count', 'Bytes', 'Seconds', 'Percent', 'CountPerSecond', 'BytesPerSecond'.
     *
     * @return the unit value
     */
    public UnitDefinitionType unit() {
        return this.unit;
    }

    /**
     * Get the list of database metric availabilities for the metric.
     *
     * @return the metricAvailabilities value
     */
    public List<MetricAvailability> metricAvailabilities() {
        return this.metricAvailabilities;
    }

}

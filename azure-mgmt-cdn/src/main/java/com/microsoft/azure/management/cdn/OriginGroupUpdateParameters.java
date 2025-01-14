/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cdn;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Origin group properties needed for origin group creation or update.
 */
@JsonFlatten
public class OriginGroupUpdateParameters {
    /**
     * Health probe settings to the origin that is used to determine the health
     * of the origin.
     */
    @JsonProperty(value = "properties.healthProbeSettings")
    private HealthProbeParameters healthProbeSettings;

    /**
     * The source of the content being delivered via CDN within given origin
     * group.
     */
    @JsonProperty(value = "properties.origins")
    private List<ResourceReference> origins;

    /**
     * Time in minutes to shift the traffic to the endpoint gradually when an
     * unhealthy endpoint comes healthy or a new endpoint is added. Default is
     * 10 mins. This property is currently not supported.
     */
    @JsonProperty(value = "properties.trafficRestorationTimeToHealedOrNewEndpointsInMinutes")
    private Integer trafficRestorationTimeToHealedOrNewEndpointsInMinutes;

    /**
     * The JSON object that contains the properties to determine origin health
     * using real requests/responses. This property is currently not supported.
     */
    @JsonProperty(value = "properties.responseBasedOriginErrorDetectionSettings")
    private ResponseBasedOriginErrorDetectionParameters responseBasedOriginErrorDetectionSettings;

    /**
     * Get health probe settings to the origin that is used to determine the health of the origin.
     *
     * @return the healthProbeSettings value
     */
    public HealthProbeParameters healthProbeSettings() {
        return this.healthProbeSettings;
    }

    /**
     * Set health probe settings to the origin that is used to determine the health of the origin.
     *
     * @param healthProbeSettings the healthProbeSettings value to set
     * @return the OriginGroupUpdateParameters object itself.
     */
    public OriginGroupUpdateParameters withHealthProbeSettings(HealthProbeParameters healthProbeSettings) {
        this.healthProbeSettings = healthProbeSettings;
        return this;
    }

    /**
     * Get the source of the content being delivered via CDN within given origin group.
     *
     * @return the origins value
     */
    public List<ResourceReference> origins() {
        return this.origins;
    }

    /**
     * Set the source of the content being delivered via CDN within given origin group.
     *
     * @param origins the origins value to set
     * @return the OriginGroupUpdateParameters object itself.
     */
    public OriginGroupUpdateParameters withOrigins(List<ResourceReference> origins) {
        this.origins = origins;
        return this;
    }

    /**
     * Get time in minutes to shift the traffic to the endpoint gradually when an unhealthy endpoint comes healthy or a new endpoint is added. Default is 10 mins. This property is currently not supported.
     *
     * @return the trafficRestorationTimeToHealedOrNewEndpointsInMinutes value
     */
    public Integer trafficRestorationTimeToHealedOrNewEndpointsInMinutes() {
        return this.trafficRestorationTimeToHealedOrNewEndpointsInMinutes;
    }

    /**
     * Set time in minutes to shift the traffic to the endpoint gradually when an unhealthy endpoint comes healthy or a new endpoint is added. Default is 10 mins. This property is currently not supported.
     *
     * @param trafficRestorationTimeToHealedOrNewEndpointsInMinutes the trafficRestorationTimeToHealedOrNewEndpointsInMinutes value to set
     * @return the OriginGroupUpdateParameters object itself.
     */
    public OriginGroupUpdateParameters withTrafficRestorationTimeToHealedOrNewEndpointsInMinutes(Integer trafficRestorationTimeToHealedOrNewEndpointsInMinutes) {
        this.trafficRestorationTimeToHealedOrNewEndpointsInMinutes = trafficRestorationTimeToHealedOrNewEndpointsInMinutes;
        return this;
    }

    /**
     * Get the JSON object that contains the properties to determine origin health using real requests/responses. This property is currently not supported.
     *
     * @return the responseBasedOriginErrorDetectionSettings value
     */
    public ResponseBasedOriginErrorDetectionParameters responseBasedOriginErrorDetectionSettings() {
        return this.responseBasedOriginErrorDetectionSettings;
    }

    /**
     * Set the JSON object that contains the properties to determine origin health using real requests/responses. This property is currently not supported.
     *
     * @param responseBasedOriginErrorDetectionSettings the responseBasedOriginErrorDetectionSettings value to set
     * @return the OriginGroupUpdateParameters object itself.
     */
    public OriginGroupUpdateParameters withResponseBasedOriginErrorDetectionSettings(ResponseBasedOriginErrorDetectionParameters responseBasedOriginErrorDetectionSettings) {
        this.responseBasedOriginErrorDetectionSettings = responseBasedOriginErrorDetectionSettings;
        return this;
    }

}

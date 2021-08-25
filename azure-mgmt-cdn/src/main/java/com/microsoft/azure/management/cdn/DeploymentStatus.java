/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cdn;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for DeploymentStatus.
 */
public final class DeploymentStatus extends ExpandableStringEnum<DeploymentStatus> {
    /** Static value NotStarted for DeploymentStatus. */
    public static final DeploymentStatus NOT_STARTED = fromString("NotStarted");

    /** Static value InProgress for DeploymentStatus. */
    public static final DeploymentStatus IN_PROGRESS = fromString("InProgress");

    /** Static value Succeeded for DeploymentStatus. */
    public static final DeploymentStatus SUCCEEDED = fromString("Succeeded");

    /** Static value Failed for DeploymentStatus. */
    public static final DeploymentStatus FAILED = fromString("Failed");

    /**
     * Creates or finds a DeploymentStatus from its string representation.
     * @param name a name to look for
     * @return the corresponding DeploymentStatus
     */
    @JsonCreator
    public static DeploymentStatus fromString(String name) {
        return fromString(name, DeploymentStatus.class);
    }

    /**
     * @return known DeploymentStatus values
     */
    public static Collection<DeploymentStatus> values() {
        return values(DeploymentStatus.class);
    }
}

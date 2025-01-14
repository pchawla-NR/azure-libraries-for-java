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
 * Defines values for AfdProvisioningState.
 */
public final class AfdProvisioningState extends ExpandableStringEnum<AfdProvisioningState> {
    /** Static value Succeeded for AfdProvisioningState. */
    public static final AfdProvisioningState SUCCEEDED = fromString("Succeeded");

    /** Static value Failed for AfdProvisioningState. */
    public static final AfdProvisioningState FAILED = fromString("Failed");

    /** Static value Updating for AfdProvisioningState. */
    public static final AfdProvisioningState UPDATING = fromString("Updating");

    /** Static value Deleting for AfdProvisioningState. */
    public static final AfdProvisioningState DELETING = fromString("Deleting");

    /** Static value Creating for AfdProvisioningState. */
    public static final AfdProvisioningState CREATING = fromString("Creating");

    /**
     * Creates or finds a AfdProvisioningState from its string representation.
     * @param name a name to look for
     * @return the corresponding AfdProvisioningState
     */
    @JsonCreator
    public static AfdProvisioningState fromString(String name) {
        return fromString(name, AfdProvisioningState.class);
    }

    /**
     * @return known AfdProvisioningState values
     */
    public static Collection<AfdProvisioningState> values() {
        return values(AfdProvisioningState.class);
    }
}

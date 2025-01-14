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
 * Defines values for PolicyEnabledState.
 */
public final class PolicyEnabledState extends ExpandableStringEnum<PolicyEnabledState> {
    /** Static value Disabled for PolicyEnabledState. */
    public static final PolicyEnabledState DISABLED = fromString("Disabled");

    /** Static value Enabled for PolicyEnabledState. */
    public static final PolicyEnabledState ENABLED = fromString("Enabled");

    /**
     * Creates or finds a PolicyEnabledState from its string representation.
     * @param name a name to look for
     * @return the corresponding PolicyEnabledState
     */
    @JsonCreator
    public static PolicyEnabledState fromString(String name) {
        return fromString(name, PolicyEnabledState.class);
    }

    /**
     * @return known PolicyEnabledState values
     */
    public static Collection<PolicyEnabledState> values() {
        return values(PolicyEnabledState.class);
    }
}

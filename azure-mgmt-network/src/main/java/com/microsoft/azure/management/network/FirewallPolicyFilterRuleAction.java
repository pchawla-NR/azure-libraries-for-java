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
 * Properties of the FirewallPolicyFilterRuleAction.
 */
public class FirewallPolicyFilterRuleAction {
    /**
     * The type of action. Possible values include: 'Allow', 'Deny'.
     */
    @JsonProperty(value = "type")
    private FirewallPolicyFilterRuleActionType type;

    /**
     * Get the type of action. Possible values include: 'Allow', 'Deny'.
     *
     * @return the type value
     */
    public FirewallPolicyFilterRuleActionType type() {
        return this.type;
    }

    /**
     * Set the type of action. Possible values include: 'Allow', 'Deny'.
     *
     * @param type the type value to set
     * @return the FirewallPolicyFilterRuleAction object itself.
     */
    public FirewallPolicyFilterRuleAction withType(FirewallPolicyFilterRuleActionType type) {
        this.type = type;
        return this;
    }

}

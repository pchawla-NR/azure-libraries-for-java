/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.storage.implementation;


import com.microsoft.azure.management.apigeneration.LangDefinition;
import com.microsoft.azure.management.resources.fluentcore.model.implementation.WrapperImpl;
import com.microsoft.azure.management.storage.LegalHold;

import java.util.List;

@LangDefinition
class LegalHoldImpl extends WrapperImpl<LegalHoldInner> implements LegalHold {
    private final StorageManager manager;
    LegalHoldImpl(LegalHoldInner inner, StorageManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public StorageManager manager() {
        return this.manager;
    }

    @Override
    public Boolean hasLegalHold() {
        return this.inner().hasLegalHold();
    }

    @Override
    public List<String> tags() {
        return this.inner().tags();
    }

}
package com.facebook.presto.plugin.opentsdb;

import com.facebook.presto.common.type.TypeManager;
import com.google.inject.Binder;
import com.google.inject.Module;

import static java.util.Objects.requireNonNull;

public class OpenTsdbModule implements Module {
    private final TypeManager typeManager;

    public OpenTsdbModule(TypeManager typeManager)
    {
        this.typeManager = requireNonNull(typeManager, "typeManager is null");
    }

    @Override
    public void configure(Binder binder) {

    }
}

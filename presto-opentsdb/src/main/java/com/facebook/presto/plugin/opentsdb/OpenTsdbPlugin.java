package com.facebook.presto.plugin.opentsdb;

import com.facebook.presto.spi.Plugin;
import com.facebook.presto.spi.connector.ConnectorFactory;
import com.google.common.collect.ImmutableList;

public class OpenTsdbPlugin implements Plugin {
    @Override
    public Iterable<ConnectorFactory> getConnectorFactories()
    {
        return ImmutableList.of(new OpenTsdbConnectorFactory());
    }
}

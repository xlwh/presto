package com.facebook.presto.plugin.opentsdb;

import com.facebook.presto.spi.ConnectorSplit;
import com.facebook.presto.spi.HostAddress;
import com.facebook.presto.spi.NodeProvider;
import com.facebook.presto.spi.schedule.NodeSelectionStrategy;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

import java.net.URI;
import java.util.List;

import static com.facebook.presto.spi.schedule.NodeSelectionStrategy.NO_PREFERENCE;
import static java.util.Objects.requireNonNull;

public class OpenTsdbSplit implements ConnectorSplit {
    private final URI uri;
    private final List<HostAddress> addresses;

    @JsonCreator
    public OpenTsdbSplit(
            @JsonProperty("uri") URI uri)
    {
        this.uri = requireNonNull(uri, "uri is null");
        addresses = ImmutableList.of(HostAddress.fromUri(uri));
    }

    @JsonProperty
    public URI getUri()
    {
        return uri;
    }

    public boolean isRemotelyAccessible()
    {
        return true;
    }

    @Override
    public NodeSelectionStrategy getNodeSelectionStrategy()
    {
        return NO_PREFERENCE;
    }

    public List<HostAddress> getAddresses()
    {
        return addresses;
    }

    @Override
    public List<HostAddress> getPreferredNodes(NodeProvider nodeProvider)
    {
        return addresses;
    }

    @Override
    public Object getInfo()
    {
        return this;
    }
}

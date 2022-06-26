package com.facebook.presto.plugin.opentsdb;

import com.facebook.airlift.configuration.Config;
import com.facebook.airlift.configuration.ConfigDescription;

import javax.validation.constraints.NotNull;
import java.net.URI;

public class OpenTsdbConnectorConfig {
    private URI opentsdbURI = URI.create("http://localhost:4242/api/query");

    @NotNull
    public URI getOpentsdbURI() {
        return opentsdbURI;
    }

    @Config("opentsdb.uri")
    @ConfigDescription("OpenTSDB coordinator host address")
    public OpenTsdbConnectorConfig setOpenTsdbURI(URI opentsdbURI)
    {
        this.opentsdbURI = opentsdbURI;
        return this;
    }

}

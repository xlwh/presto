package com.facebook.presto.plugin.opentsdb;

import com.facebook.airlift.json.JsonCodec;
import com.facebook.airlift.log.Logger;
import okhttp3.OkHttpClient;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class OpenTsdbClient {
    private static final OkHttpClient httpClient = new OkHttpClient.Builder().build();
    private static final Logger log = Logger.get(OpenTsdbClient.class);

    @Inject
    public OpenTsdbClient(OpenTsdbConnectorConfig config, JsonCodec<Map<String, List<OpenTsdbTable>>> catalogCodec)
    {
        requireNonNull(config, "config is null");
        requireNonNull(catalogCodec, "catalogCodec is null");
    }
}

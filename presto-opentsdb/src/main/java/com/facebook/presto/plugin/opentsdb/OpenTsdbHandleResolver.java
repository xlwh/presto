package com.facebook.presto.plugin.opentsdb;

import com.facebook.presto.spi.*;
import com.facebook.presto.spi.connector.ConnectorTransactionHandle;

public class OpenTsdbHandleResolver implements ConnectorHandleResolver {
    @Override
    public Class<? extends ConnectorTableHandle> getTableHandleClass() {
        return OpenTsdbTableHandle.class;
    }

    @Override
    public Class<? extends ConnectorTableLayoutHandle> getTableLayoutHandleClass() {
        return OpenTsdbTableLayoutHandle.class;
    }

    @Override
    public Class<? extends ColumnHandle> getColumnHandleClass() {
        return OpenTsdbColumnHandle.class;
    }

    @Override
    public Class<? extends ConnectorSplit> getSplitClass() {
        return OpenTsdbSplit.class;
    }

    public Class<? extends ConnectorTransactionHandle> getTransactionHandleClass()
    {
        return OpenTsdbTransactionHandle.class;
    }
}

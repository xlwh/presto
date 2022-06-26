package com.facebook.presto.plugin.opentsdb;

import com.facebook.presto.common.type.Type;
import com.facebook.presto.spi.RecordCursor;
import com.facebook.presto.spi.RecordSet;

import java.util.List;

public class OpenTsdbRecordSet implements RecordSet {
    @Override
    public List<Type> getColumnTypes() {
        return null;
    }

    @Override
    public RecordCursor cursor() {
        return null;
    }
}

package com.facebook.presto.plugin.opentsdb;

import com.facebook.presto.common.type.Type;
import com.facebook.presto.spi.RecordCursor;
import io.airlift.slice.Slice;

public class OpenTsdbRecordCursor implements RecordCursor {
    @Override
    public long getCompletedBytes() {
        return 0;
    }

    @Override
    public long getReadTimeNanos() {
        return 0;
    }

    @Override
    public Type getType(int field) {
        return null;
    }

    @Override
    public boolean advanceNextPosition() {
        return false;
    }

    @Override
    public boolean getBoolean(int field) {
        return false;
    }

    @Override
    public long getLong(int field) {
        return 0;
    }

    @Override
    public double getDouble(int field) {
        return 0;
    }

    @Override
    public Slice getSlice(int field) {
        return null;
    }

    @Override
    public Object getObject(int field) {
        return null;
    }

    @Override
    public boolean isNull(int field) {
        return false;
    }

    @Override
    public void close() {

    }
}

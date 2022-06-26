package com.facebook.presto.plugin.opentsdb;

import com.facebook.presto.common.predicate.TupleDomain;
import com.facebook.presto.spi.ColumnHandle;
import com.facebook.presto.spi.ConnectorTableLayoutHandle;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;
import static java.util.Objects.requireNonNull;

public class OpenTsdbTableLayoutHandle implements ConnectorTableLayoutHandle {
    private final OpenTsdbTableHandle tableHandle;
    private final TupleDomain<ColumnHandle> constraint;

    @JsonCreator
    public OpenTsdbTableLayoutHandle(
            @JsonProperty("table") OpenTsdbTableHandle tableHandle,
            @JsonProperty("constraint") TupleDomain<ColumnHandle> constraint)
    {
        this.tableHandle = requireNonNull(tableHandle, "table is null");
        this.constraint = requireNonNull(constraint, "constraint is null");
    }

    @JsonProperty
    public OpenTsdbTableHandle getTableHandle()
    {
        return tableHandle;
    }

    @JsonProperty
    public TupleDomain<ColumnHandle> getConstraint()
    {
        return constraint;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        OpenTsdbTableLayoutHandle other = (OpenTsdbTableLayoutHandle) obj;
        return Objects.equals(tableHandle, other.tableHandle)
                && Objects.equals(constraint, other.constraint);
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public String toString()
    {
        return toStringHelper(this)
                .add("tableHandle", tableHandle)
                .add("constraint", constraint)
                .toString();
    }
}

package com.facebook.presto.plugin.opentsdb;

import com.facebook.presto.common.predicate.TupleDomain;
import com.facebook.presto.spi.ColumnHandle;
import com.facebook.presto.spi.ConnectorTableHandle;
import com.facebook.presto.spi.SchemaTableName;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

public class OpenTsdbTableHandle implements ConnectorTableHandle {
    private final String schemaName;
    private final String tableName;
    private Optional<TupleDomain<ColumnHandle>> predicate = Optional.empty();

    @JsonCreator
    public OpenTsdbTableHandle(
            @JsonProperty("schemaName") String schemaName,
            @JsonProperty("tableName") String tableName)
    {
        this(schemaName, tableName, Optional.empty());
    }

    private OpenTsdbTableHandle(String schemaName, String tableName, Optional<TupleDomain<ColumnHandle>> predicate)
    {
        this.schemaName = requireNonNull(schemaName, "schemaName is null");
        this.tableName = requireNonNull(tableName, "tableName is null");
        this.predicate = requireNonNull(predicate, "predicate is null");
    }

    @JsonProperty
    public String getSchemaName()
    {
        return schemaName;
    }

    @JsonProperty
    public String getTableName()
    {
        return tableName;
    }

    public SchemaTableName toSchemaTableName()
    {
        return new SchemaTableName(schemaName, tableName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(schemaName, tableName);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        OpenTsdbTableHandle other = (OpenTsdbTableHandle) obj;
        return Objects.equals(this.schemaName, other.schemaName) &&
                Objects.equals(this.tableName, other.tableName);
    }

    @Override
    public String toString()
    {
        return schemaName + ":" + tableName;
    }

    public Optional<TupleDomain<ColumnHandle>> getPredicate()
    {
        return this.predicate;
    }

    public OpenTsdbTableHandle withPredicate(TupleDomain<ColumnHandle> predicate)
    {
        return new OpenTsdbTableHandle(schemaName, tableName, Optional.of(predicate));
    }
}

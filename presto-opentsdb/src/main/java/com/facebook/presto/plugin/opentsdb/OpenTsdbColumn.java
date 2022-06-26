package com.facebook.presto.plugin.opentsdb;

import com.facebook.presto.common.type.StandardTypes;
import com.facebook.presto.common.type.Type;
import com.facebook.presto.common.type.TypeSignature;
import com.facebook.presto.common.type.TypeSignatureParameter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Objects.requireNonNull;

public class OpenTsdbColumn {
    private final String name;
    private final Type type;

    @JsonCreator
    public OpenTsdbColumn(
            @JsonProperty("name") String name,
            @JsonProperty("type") Type type)
    {
        checkArgument(!isNullOrEmpty(name), "name is null or is empty");
        checkArgument((name.equals("labels") || name.equals("timestamp") || name.equals("value")), "column name must be in (\"labels\"), (\"timestamp\"), (\"value\")");
        this.name = name;
        this.type = requireNonNull(type, "type is null");
    }

    @JsonProperty
    public String getName()
    {
        return name;
    }

    @JsonProperty
    public Type getType()
    {
        return type;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, type);
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

        OpenTsdbColumn other = (OpenTsdbColumn) obj;
        return Objects.equals(this.name, other.name) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public String toString()
    {
        return name + ":" + type;
    }

    public static TypeSignature mapType(TypeSignature keyType, TypeSignature valueType)
    {
        return new TypeSignature(StandardTypes.MAP, TypeSignatureParameter.of(keyType), TypeSignatureParameter.of(valueType));
    }
}

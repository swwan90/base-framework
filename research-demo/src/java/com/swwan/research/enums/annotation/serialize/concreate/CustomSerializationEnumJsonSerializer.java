package com.swwan.research.enums.annotation.serialize.concreate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.swwan.research.enums.annotation.serialize.CustomSerializationEnum;
import com.swwan.research.enums.annotation.serialize.EnumSerialize;
import com.swwan.research.enums.annotation.serialize.EnumSerializeAdapter;
import javafx.util.Pair;

import java.io.IOException;
import java.util.Set;

/**
 * @author swwan
 * @date 2022/4/9 - 10:01
 */
public class CustomSerializationEnumJsonSerializer<T extends Enum<T> & EnumSerialize<T>> extends JsonSerializer<T> {
    private final CustomSerializationEnum.Type type;

    public CustomSerializationEnumJsonSerializer(Pair<Class<Enum<?>>, Set<EnumSerialize<T>>> enumSerialize) {
        //noinspection unchecked,rawtypes
        CustomSerializationEnum annotation = EnumSerialize.getAnnotation((Class) enumSerialize.getKey());
        //找不到注解就默认使用name序列化
        type = annotation == null ? CustomSerializationEnum.Type.NAME : annotation.json();
    }

    @Override
    public void serialize(T value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        Object serializedValue;
        //noinspection ConstantConditions
        if (value instanceof EnumSerialize) {
            serializedValue = type.getSerializedValue(value);
        } else {
            //noinspection ConstantConditions
            serializedValue = type.getSerializedValue(new EnumSerializeAdapter(value));
        }
        serializers.findValueSerializer(serializedValue.getClass()).serialize(serializedValue, gen, serializers);
    }
}


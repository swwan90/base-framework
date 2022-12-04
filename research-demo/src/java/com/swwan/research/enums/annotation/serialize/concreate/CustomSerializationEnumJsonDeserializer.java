package com.swwan.research.enums.annotation.serialize.concreate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.swwan.research.enums.annotation.serialize.CustomSerializationEnum;
import com.swwan.research.enums.annotation.serialize.EnumSerialize;
import javafx.util.Pair;

import java.io.IOException;
import java.util.Set;

/**
 * @author swwan
 * @date 2022/4/9 - 10:06
 */
public class CustomSerializationEnumJsonDeserializer<T extends Enum<T> & EnumSerialize<T>> extends JsonDeserializer<T> {

    private final CustomSerializationEnum.Type type;
    private final Class<T> clazz;

    public CustomSerializationEnumJsonDeserializer(Pair<Class<Enum<?>>, Set<EnumSerialize<T>>> enumSerialize) {
        //noinspection unchecked,rawtypes
        clazz = (Class) enumSerialize.getKey();
        CustomSerializationEnum annotation = EnumSerialize.getAnnotation(clazz);
        type = annotation == null ? CustomSerializationEnum.Type.NAME : annotation.json();
    }

    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return type.getDeserializeObj(clazz, p.getText());
    }
}
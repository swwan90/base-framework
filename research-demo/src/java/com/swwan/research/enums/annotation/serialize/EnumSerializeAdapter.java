package com.swwan.research.enums.annotation.serialize;

/**
 * 枚举适配器
 * <p/>提供给没有实现{@EnumSerialize}接口的枚举类使用
 *
 * @author swwan
 * @date 2022/4/9 - 9:48
 */
@SuppressWarnings("rawtypes")
public class EnumSerializeAdapter implements EnumSerialize {

    private final Enum<?> enumInstance;

    public Enum<?> getEnumInstance() {
        return enumInstance;
    }

    public EnumSerializeAdapter(Enum<?> enumInstance) {
        this.enumInstance = enumInstance;
    }

    @Override
    public String getSerializationName() {
        return enumInstance.name();
    }

    @Override
    public Integer getSerializationId() {
        return enumInstance.ordinal();
    }

    @Override
    public Class getOriginalClass() {
        return enumInstance.getClass();
    }

    @Override
    public Enum getOrginalEnum() {
        return enumInstance;
    }

    @Override
    public String toString() {
        return enumInstance.toString();
    }
}

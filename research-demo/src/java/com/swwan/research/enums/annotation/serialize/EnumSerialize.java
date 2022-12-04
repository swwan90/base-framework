package com.swwan.research.enums.annotation.serialize;

import org.springframework.core.annotation.AnnotationUtils;

/**
 * 详细设置序列化的值
 * <p/>
 * 为了更好兼容适配器，增加获取原石类和原始对象的方法
 *
 * @author swwan
 * @date 2022/4/9 - 9:41
 */
public interface EnumSerialize<T extends Enum<T> & EnumSerialize<T>> {

    default String getSerializationName() {
        return ((Enum<?>) this).name();
    }

    default Integer getSerializationId() {
        return ((Enum<?>) this).ordinal();
    }

    /**
     * 获取原始类，专门给适配器使用
     */
    default Class<T> getOriginalClass() {
        //noinspection unchecked
        return (Class<T>) this.getClass();
    }

    /**
     * 获取原始枚举对象，专门给适配器使用
     */
    default Enum<T> getOrginalEnum() {
        //noinspection unchecked
        return (Enum<T>) this;
    }

    static <T extends Enum<T> & EnumSerialize<T>> CustomSerializationEnum getAnnotation(Class<T> enumClass) {
        return AnnotationUtils.findAnnotation(enumClass, CustomSerializationEnum.class);
    }
}

package com.swwan.research.common.utils.base;

import cn.hutool.core.util.StrUtil;
import com.swwan.research.common.base.IEnum;
import com.swwan.research.common.base.NameValueEnum;
import com.swwan.research.common.base.ValueEnum;

import java.util.EnumSet;

/**
 * 枚举工具类
 *
 * @author swwan
 * @date 2022/1/15 - 23:22
 */
@SuppressWarnings("all")
public class EnumUtil {

    public static <E extends Enum<E>, T> IEnum<T> getEnumByCode(Class<E> enumClass, T code) {
        if (null == code) {
            return null;
        }
        EnumSet<E> es = EnumSet.allOf(enumClass);
        for (E anEnum : es) {
            if (anEnum instanceof IEnum) {
                if (((IEnum<T>) anEnum).codeEquals(code)) {
                    return (IEnum<T>) anEnum;
                }
            }
        }
        return null;
    }

    /**
     * 判断枚举值是否存在与指定枚举数组中
     *
     * @param enums 枚举数组
     * @param value 枚举值
     * @param <T>   值类型
     * @return true: 存在；false: 不存在
     */
    public static <T> boolean isExist(ValueEnum<T>[] enums, T value) {
        if (value == null) {
            return false;
        }

        for (ValueEnum<T> e : enums) {
            if (value.equals(e.getValue())) {
                return true;
            }
        }

        return false;
    }

    /**
     * 判断枚举值是否存在与指定枚举类中
     *
     * @param enumClass 枚举类
     * @param value     枚举值
     * @param <E>       枚举类型
     * @param <V>       值类型
     * @return true: 存在；false: 不存在
     */
    public static <E extends Enum<? extends ValueEnum<V>>, V> boolean isExist(Class<E> enumClass, V value) {
        for (Enum<? extends ValueEnum<V>> e : enumClass.getEnumConstants()) {
            if (((ValueEnum<V>) e).getValue().equals(value)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 根据枚举值获取对应的枚举名称
     *
     * @param enums 枚举列表
     * @param value 枚举值
     * @param <T>   枚举类型
     * @return 枚举名称
     */
    public static <T> String getNameByValue(NameValueEnum<T>[] enums, T value) {
        if (value == null) {
            return null;
        }

        for (NameValueEnum<T> e : enums) {
            if (value.equals(e.getValue())) {
                return e.getName();
            }
        }

        return null;
    }

    /**
     * 根据枚举名称获取对应的枚举值
     *
     * @param enums 枚举列表
     * @param name  枚举名
     * @param <T>   枚举类型
     * @return 枚举值
     */
    public static <T> T getValueByName(NameValueEnum<T>[] enums, String name) {
        if (StrUtil.isEmpty(name)) {
            return null;
        }

        for (NameValueEnum<T> e : enums) {
            if (name.equals(e.getValue())) {
                return e.getValue();
            }
        }

        return null;
    }

    /**
     * 根据枚举值获取对应的枚举对象
     *
     * @param enums 枚举列表
     * @param value 枚举值
     * @param <E>   枚举类型
     * @param <V>   值类型
     * @return 枚举对象
     */
    public static <E extends Enum<? extends ValueEnum<V>>, V> E getEnumByValue(E[] enums, V value) {
        if (value == null) {
            return null;
        }

        for (E e : enums) {
            if (((ValueEnum<V>) e).getValue().equals(value)) {
                return e;
            }
        }

        return null;
    }

    /**
     * 根据枚举值获取对应的枚举对象
     *
     * @param enums 枚举列表
     * @param value 枚举值
     * @param <E>   枚举类型
     * @param <V>   值类型
     * @return 枚举对象
     */
    public static <E extends Enum<? extends ValueEnum<V>>, V> E getEnumByValue(Class<E> enumClass, V value) {
        if (value == null) {
            return null;
        }

        return getEnumByValue(enumClass.getEnumConstants(), value);
    }
}

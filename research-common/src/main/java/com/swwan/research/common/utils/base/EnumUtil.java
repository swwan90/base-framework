package com.swwan.research.common.utils.base;

import com.swwan.research.common.base.enums.IEnum;

import java.util.EnumSet;
import java.util.Optional;

/**
 * 枚举工具类 {@link cn.hutool.core.util.EnumUtil}
 *
 * @author swwan
 * @date 2022/1/15 - 23:22
 */
@SuppressWarnings("all")
public class EnumUtil {

    /**
     * 获取枚举对象
     *
     * @param enumClass 枚举类
     * @param code      枚举值
     * @return 枚举对象 {@link IEnum}<{@link T}>
     */
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

    public static <E extends Enum<E>, T> Optional<IEnum<T>> of(Class<E> enumClass, T code) {
        return Optional.ofNullable(getEnumByCode(enumClass, code));
    }

    /**
     * 根据枚举值获取对应的枚举描述
     *
     * @param enums 枚举对象数组
     * @param code 枚举值
     * @return 枚举描述
     */
    public static <E extends Enum<E>, T> String getDescriptionByCode(Class<E> enumClass, T code) {
        IEnum<T> clazz = getEnumByCode(enumClass, code);
        if (null == clazz) {
            return null;
        }
        return clazz.getDescription();
    }

    public static <E extends Enum<E>, T> Optional<String> getDescriptionByCodeWithOptional(Class<E> enumClass, T code) {
        return Optional.ofNullable(getDescriptionByCode(enumClass, code));
    }
}

package com.swwan.research.common.utils.base;

import com.swwan.research.common.base.IEnum;

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
}

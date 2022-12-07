package com.swwan.research.common.base.enums;

/**
 * @author swwan
 * @date 2022/12/7 - 19:42
 */
public interface BaseEnum<T extends Enum<T> & BaseEnum<T>> {

    /**
     * 获取code码存入DB
     *
     * @return {@link String}
     */
    Integer getCode();

    /**
     * 得到描述，便于维护
     *
     * @return {@link String}
     */
    String getDescription();

    /**
     * 根据code码获取枚举
     *
     * @param cls cls
     * @param code 代码
     * @return {@link T}
     */
    static <T extends Enum<T> & BaseEnum<T>> T parseByCode(Class<T> cls, Integer code) {
        for (T t : cls.getEnumConstants()) {
            if (t.getCode().intValue() == code.intValue()) {
                return t;
            }
        }
        return null;
    }

}

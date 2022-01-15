package com.swwan.research.common.base;

import java.util.Objects;

/**
 * 如若枚举名称和实际值不同，请务必重写getKey 方法
 * 枚举定义规范：
 * 枚举名切记大写
 * 描述尽量清晰
 * 不要出现错误拼写
 *
 * @author swwan
 * @date 2022/1/15 - 23:14
 */
public interface IEnum<T> {

    /**
     * 返回枚举实际值
     */
    T getCode();

    /**
     * 返回枚举描述
     *
     * @return 枚举说明
     */
    String getDescription();

    /**
     * 对比当前枚举对象和传入的枚举值是否一致（String类型会忽略大小写）
     * 当前枚举值是否匹配远端传入的值（比如：数据库的字段值、RPC传入的参数值）
     *
     * @param enumCode 枚举Code
     * @return 是否匹配
     */
    default boolean codeEquals(T enumCode) {
        if (enumCode == null) {
            return false;
        }
        if (enumCode instanceof String) {
            return ((String) enumCode).equalsIgnoreCase((String) getCode());
        } else {
            return Objects.equals(this.getCode(), enumCode);
        }
    }

    /**
     * 对比两个枚举项是否完全相同（==）
     *
     * @param anotherEnum 枚举
     * @return 是否相同
     */
    default boolean equals(IEnum<T> anotherEnum) {
        return this == anotherEnum;
    }
}

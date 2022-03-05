package com.swwan.research.common.base;

/**
 * 带有枚举值以及枚举名称的枚举接口
 * 实现此接口可使用{@link com.swwan.research.common.utils.base.EnumUtil}中的方法）
 *
 * @author swwan
 * @date 2022/2/15 - 22:17
 */
public interface NameValueEnum<T> extends ValueEnum<T> {

    /**
     * 获取枚举名称
     *
     * @return 枚举名称
     */
    String getName();
}

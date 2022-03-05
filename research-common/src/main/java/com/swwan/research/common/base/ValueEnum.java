package com.swwan.research.common.base;

/**
 * 最简单的枚举类，即只含value的枚举
 * 实现此接口可使用{@link com.swwan.research.common.utils.base.EnumUtil}中的方法）
 *
 * @author swwan
 * @date 2022/2/15 - 22:17
 */
public interface ValueEnum<T> {

    /**
     * 获取枚举值
     *
     * @return 枚举值
     */
    T getValue();
}

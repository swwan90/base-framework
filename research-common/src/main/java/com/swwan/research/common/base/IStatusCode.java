package com.swwan.research.common.base;

/**
 * 状态码接口
 *
 * @author swwan
 * @date 2021/12/18 - 16:43
 */
public interface IStatusCode {
    /**
     * 获取状态码
     *
     * @return 状态码
     */
    Integer getStatus();

    /**
     * 获取状态描述
     *
     * @return 描述信息
     */
    String getMsg();
}

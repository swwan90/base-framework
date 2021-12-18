package com.swwan.research.common.base;

import java.io.Serializable;

/**
 * 字典接口
 *
 * @author swwan
 * @date 2021/12/18 - 20:16
 */
public interface IDictCode extends Serializable {

    /**
     * 获取字典值
     *
     * @return 描述信息
     */
    String getValue();
}

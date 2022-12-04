package com.swwan.research.common.base.dict;

import java.io.Serializable;

/**
 * 字典值列表
 *
 * @author swwan
 */
public interface IDictCodeList extends Serializable {

    /**
     * 获取字典
     *
     * @return 字典
     */
    IDictCode getDictCode();

    /**
     * 获取字典值
     *
     * @return 字典值
     */
    String getValue();

    /**
     * 设置字典值
     *
     * @param var1 字典值
     */
    void setValue(String var1);

    /**
     * 获取字典描述
     *
     * @return 字典描述
     */
    String getDescription();

    /**
     * 设置字典描述
     *
     * @param var1 字典描述
     */
    void setDescription(String var1);
}
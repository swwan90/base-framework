package com.swwan.research.common.base;

import com.swwan.research.common.dto.DictCode;

/**
 * 基础数据字典
 *
 * @author swwan
 * @date 2021/12/18 - 16:45
 */
@SuppressWarnings("all")
public interface BaseDictCode extends IDictCode {
    DictCode 空字典 = DictCode.空字典;
    DictCode 数据状态 = DictCode.数据状态;
    DictCode 流程状态 = DictCode.流程状态;
    DictCode 是否 = DictCode.是否;
    DictCode 交换机类型 = DictCode.交换机类型;
    DictCode 个性化分类 = DictCode.个性化分类;
}
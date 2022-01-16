package com.swwan.research.common.base;

import com.swwan.research.common.entity.enums.DictCodeList;

/**
 * 基础字典列表
 *
 * @author Administrator
 */
@SuppressWarnings("all")
public interface BaseDictCodeList extends IDictCodeList {
    DictCodeList 数据状态_新建 = DictCodeList.数据状态_新建;
    DictCodeList 数据状态_新建中 = DictCodeList.数据状态_新建中;
    DictCodeList 数据状态_删除中 = DictCodeList.数据状态_删除中;
    DictCodeList 数据状态_删除 = DictCodeList.数据状态_删除;
    DictCodeList 数据状态_修改中 = DictCodeList.数据状态_修改中;
    DictCodeList 数据状态_修改 = DictCodeList.数据状态_修改;
    DictCodeList 数据状态_作废 = DictCodeList.数据状态_作废;
    DictCodeList 是否_是 = DictCodeList.是否_是;
    DictCodeList 是否_否 = DictCodeList.是否_否;
}
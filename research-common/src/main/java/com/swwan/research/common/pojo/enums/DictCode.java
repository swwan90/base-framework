package com.swwan.research.common.pojo.enums;

import cn.hutool.core.util.StrUtil;
import com.swwan.research.common.base.dict.BaseDictCode;

/**
 * 字典
 *
 * @author swwan
 * @date 2021/12/18 - 16:45
 */
@SuppressWarnings("all")
public enum DictCode implements BaseDictCode {

    空字典("NULL"),
    数据状态("STATUS"),
    流程状态("PROCESS_STATE"),
    是否("YES_NO"),
    权限模式("AUTHORITY_TYPE"),
    交换机类型("EXCHANGE_TYPE"),
    个性化分类("MYTODOANDWORK_PSL_TYPE");

    private String value;

    private DictCode(String value) {
        this.value = value;
    }

    public static DictCode get(String value) {
        DictCode[] values = values();
        DictCode[] var2 = values;
        int var3 = values.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            DictCode code = var2[var4];
            if (StrUtil.equals(value, code.getValue())) {
                return code;
            }
        }

        return null;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
package com.swwan.research.common.dto;

import cn.hutool.core.util.StrUtil;
import com.swwan.research.common.base.BaseDictCode;
import com.swwan.research.common.base.BaseDictCodeList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 字典列表
 *
 * @author swwan
 * @date 2021/12/18 - 16:45
 */
@SuppressWarnings("all")
public enum DictCodeList implements BaseDictCodeList {
    数据状态_新建(BaseDictCode.数据状态, "N", "新建"),
    数据状态_新建中(BaseDictCode.数据状态, "A", "新建中"),
    数据状态_删除中(BaseDictCode.数据状态, "P", "删除中"),
    数据状态_删除(BaseDictCode.数据状态, "D", "删除"),
    数据状态_修改中(BaseDictCode.数据状态, "U", "修改中"),
    数据状态_修改(BaseDictCode.数据状态, "M", "修改"),
    数据状态_作废(BaseDictCode.数据状态, "R", "作废"),
    是否_是(BaseDictCode.是否, "01", "是"),
    是否_否(BaseDictCode.是否, "02", "否"),
    交换机类型_Direct(BaseDictCode.交换机类型, "01", "Direct"),
    交换机类型_Fanout(BaseDictCode.交换机类型, "02", "Fanout"),
    交换机类型_Topic(BaseDictCode.交换机类型, "03", "Topic"),
    交换机类型_Headers(BaseDictCode.交换机类型, "04", "Headers"),
    待办事项和我的工作个性化分类_待办事项(BaseDictCode.个性化分类, "01", "待办事项"),
    待办事项和我的工作个性化分类_我的工作(BaseDictCode.个性化分类, "02", "我的工作");

    private BaseDictCode dictCode;
    private String value;
    private String description;

    private DictCodeList(BaseDictCode dictCode, String value, String description) {
        this.dictCode = dictCode;
        this.value = value;
        this.setDescription(description);
    }

    public static DictCodeList from(BaseDictCode dictCode, String value) {
        DictCodeList[] values = values();
        DictCodeList[] var3 = values;
        int var4 = values.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            DictCodeList code = var3[var5];
            if (StrUtil.equals(value, code.getValue()) && code.getDictCode().equals(dictCode)) {
                return code;
            }
        }

        return null;
    }

    public static List<SelectOptionDto> fromDictCode(BaseDictCode dictCode) {
        List<SelectOptionDto> result = new ArrayList();
        DictCodeList[] values = values();
        DictCodeList[] var3 = values;
        int var4 = values.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            DictCodeList code = var3[var5];
            if (code.getDictCode() == dictCode) {
                SelectOptionDto option = new SelectOptionDto();
                option.setId(code.getValue());
                option.setText(code.getDescription());
                result.add(option);
            }
        }

        return result;
    }

    public static List<String> valuesfromDictCode(BaseDictCode dictCode) {
        List<String> result = new ArrayList();
        DictCodeList[] values = values();
        DictCodeList[] var3 = values;
        int var4 = values.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            DictCodeList code = var3[var5];
            if (code.getDictCode() == dictCode) {
                result.add(code.getValue());
            }
        }

        return result;
    }

    @Override
    public BaseDictCode getDictCode() {
        return this.dictCode;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuotesDescription() {
        return "“" + this.description + "”";
    }

    public Integer getIntegerDescription() {
        Integer result = null;

        try {
            result = Integer.parseInt(this.description);
        } catch (Exception var3) {
        }

        return result;
    }

    public BigDecimal getBigDecimalDescription() {
        BigDecimal result = null;

        try {
            result = new BigDecimal(this.description);
        } catch (Exception var3) {
        }

        return result;
    }
}
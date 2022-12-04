package com.swwan.research.common.base.enums;

/**
 * 有效状态
 *
 * @author swwan
 * @date 2022/12/5 - 1:22
 */
public enum ValidStatus implements IEnum<Integer> {

    /** 有效 */ VALID(1, "valid"),
    /** 无效 */ INVALID(0, "invalid");

    /** 代码 */
    private Integer code;

    /** 描述 */
    private String description;

    ValidStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

package com.swwan.research.common.entity.enums;

import com.swwan.research.common.base.IEnum;
import com.swwan.research.common.utils.base.EnumUtil;

/**
 * 枚举示例
 *
 * @author swwan
 * @date 2022/1/16 - 10:10
 */
@SuppressWarnings("all")
public enum DataStatusEnum implements IEnum<String> {

    NEW("xx", "dd"),
    DELETED("dd", "xx"),
    ;

    private String code;
    private String description;

    DataStatusEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static void main(String[] args) {
        String description = EnumUtil.getEnumByCode(DataStatusEnum.class, "xx").getDescription();
        System.out.println(description);
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

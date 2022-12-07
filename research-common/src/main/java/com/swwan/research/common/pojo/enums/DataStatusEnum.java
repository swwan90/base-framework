package com.swwan.research.common.pojo.enums;

import com.swwan.research.common.base.enums.ICodeEnum;
import com.swwan.research.common.base.enums.IEnum;

import java.util.Optional;

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

    private String value;
    private String name;

    DataStatusEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public String getCode() {
        return value;
    }

    @Override
    public String getDescription() {
        return name;
    }

    public static Optional<IEnum<String>> of(String code) {
        return Optional.ofNullable(ICodeEnum.parseByCode(DataStatusEnum.class, code));
    }
}

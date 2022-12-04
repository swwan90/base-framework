package com.swwan.research.enums.annotation.enumerate;

import com.swwan.research.enums.annotation.serialize.CustomSerializationEnum;
import com.swwan.research.enums.annotation.serialize.EnumSerialize;

/**
 * @author swwan
 * @date 2022/4/9 - 10:10
 */
@CustomSerializationEnum(myBatis = CustomSerializationEnum.Type.ID, json = CustomSerializationEnum.Type.NAME)
public enum Gender implements EnumSerialize<Gender> {
    MALE("男"),
    FEMALE("女"),
    UNKNOWN("未知") {
        @Override
        public String getSerializationName() {
            return "秀吉";
        }

        @Override
        public Integer getSerializationId() {
            return 114514;
        }
    };

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    @Override
    public String getSerializationName() {
        return name;
    }
}

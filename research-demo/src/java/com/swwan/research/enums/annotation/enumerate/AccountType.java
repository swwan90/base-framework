package com.swwan.research.enums.annotation.enumerate;

import com.swwan.research.enums.annotation.serialize.CustomSerializationEnum;

/**
 * @author swwan
 * @date 2022/4/9 - 10:09
 */
@CustomSerializationEnum(
        myBatis = CustomSerializationEnum.Type.ID,
        json = CustomSerializationEnum.Type.NAME,
        requestParam = CustomSerializationEnum.Type.ID
)
public enum AccountType {
    BUILT_IN, ORDINARY, GUEST
}

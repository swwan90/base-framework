package com.swwan.research.common.base.mapper;

import com.swwan.research.common.base.enums.ValidStatus;

/**
 * @author swwan
 * @date 2022/12/7 - 20:51
 */
public class GenericEnumMapper {

    public Integer asInteger(ValidStatus status) {
        return status.getCode();
    }

    public ValidStatus asValidStatus(Integer code) {
        return ValidStatus.of(code).orElse(ValidStatus.INVALID);
    }
}

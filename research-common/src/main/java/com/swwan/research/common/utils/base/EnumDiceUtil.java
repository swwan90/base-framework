package com.swwan.research.common.utils.base;

import com.swwan.research.common.base.enums.BaseEnum;
import com.swwan.research.common.base.model.EnumVo;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 枚举转EnumVo
 *
 * @author swwan
 * @date 2022/12/7 - 20:57
 */
public class EnumDiceUtil {

    private EnumDiceUtil() {
    }

    public static <T extends Enum<T> & BaseEnum<T>> List<EnumVo> getEnumDictVo(Class<T> cls) {
        return EnumSet.allOf(cls).stream().map(et -> {
            EnumVo vo = new EnumVo();
            vo.setCode(et.getCode());
            vo.setName(et.getDescription());
            vo.setText(et.name());
            return vo;
        }).collect(Collectors.toList());
    }
}

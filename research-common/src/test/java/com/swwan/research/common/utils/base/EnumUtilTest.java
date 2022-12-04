package com.swwan.research.common.utils.base;

import cn.hutool.core.lang.Assert;
import com.swwan.research.common.base.enums.IEnum;
import com.swwan.research.common.pojo.enums.UserStatusCode;
import org.junit.jupiter.api.Test;

/**
 * enum util测试
 *
 * @author swwan
 * @date 2022/4/10 - 14:22
 */
class EnumUtilTest {

    /**
     * 得到枚举代码
     */
    @Test
    void getEnumByCode() {
        IEnum<Integer> enumByCode = EnumUtil.getEnumByCode(UserStatusCode.class, 2000);
        Assert.isTrue(enumByCode == UserStatusCode.ERR_2000);
    }

    /**
     * 被代码描述
     */
    @Test
    void getDescriptionByCode() {
        String desc = EnumUtil.getDescriptionByCode(UserStatusCode.class, 2000);
        Assert.isTrue(UserStatusCode.ERR_2000.getDescription().equals(desc));

        desc = cn.hutool.core.util.EnumUtil.getFieldBy(UserStatusCode::getDescription, UserStatusCode::getCode, 2000);
        Assert.isTrue(UserStatusCode.ERR_2000.getDescription().equals(desc));
    }
}
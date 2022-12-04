package com.swwan.research.common.utils.guava;

import cn.hutool.core.lang.Assert;
import com.google.common.base.MoreObjects;
import com.swwan.research.common.pojo.vo.ParamErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Objects;

/**
 * 更多测试对象
 *
 * @author swwan
 * @date 2022/12/5 - 0:50
 */
@Slf4j
public class MoreObjectsTest {

    @Test
    public void firstNonNull() {
        ParamErrorDto dto1 = null;
        ParamErrorDto dto2 = new ParamErrorDto();
        ParamErrorDto paramErrorDto = MoreObjects.firstNonNull(dto1, dto2);
        Assert.isTrue(Objects.nonNull(paramErrorDto));

    }

    @Test
    public void toStringHelper() {
        String s = MoreObjects.toStringHelper("toStringHelper").add("aaa", "bbbb").toString();
        String withNullValue = MoreObjects.toStringHelper("toStringHelper").omitNullValues().add("nullValue", null).add("aaa", "bbbb").toString();
        log.info(s);
        log.info(withNullValue);
    }
}


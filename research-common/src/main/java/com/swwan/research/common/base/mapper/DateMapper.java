package com.swwan.research.common.base.mapper;

import java.time.Instant;
import java.util.Objects;

/**
 * 时间转换映射
 *
 * @author swwan
 * @date 2022/12/7 - 20:48
 */
public class DateMapper {

    public Long asLong(Instant date) {
        return Objects.isNull(date) ? null : date.toEpochMilli();
    }

    public Instant asInstant(Long date) {
        return Objects.isNull(date) ? null : Instant.ofEpochMilli(date);
    }
}

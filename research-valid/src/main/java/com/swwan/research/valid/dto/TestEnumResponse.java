package com.swwan.research.valid.dto;

import com.swwan.research.common.entity.enums.DataStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author swwan
 * @date 2022/1/16 - 11:01
 */
@Data
@AllArgsConstructor
public class TestEnumResponse {

    public DataStatusEnum status;

    public String name;
}

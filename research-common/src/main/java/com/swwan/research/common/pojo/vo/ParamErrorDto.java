package com.swwan.research.common.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 参数错误的传输对象
 *
 * @author swwan
 * @date 2021/12/19 - 13:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParamErrorDto {

    /**
     * 字段名
     */
    private String field;

    /**
     * 字段错误描述
     */
    private String message;
}

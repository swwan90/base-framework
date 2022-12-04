package com.swwan.research.valid.dto;

import com.swwan.research.common.base.validate.ValidateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 地址
 *
 * @author swwan
 * @date 2021/12/18 - 22:04
 */
@Data
public class Address {

    @NotBlank(message = "省份不能为空", groups = ValidateGroup.Base.class)
    private String province;

    @NotBlank
    private String city;
}

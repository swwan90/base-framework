package com.swwan.research.common.pojo.enums;

import com.swwan.research.common.base.enums.ICodeEnum;
import com.swwan.research.common.base.enums.IEnum;
import com.swwan.research.common.base.enums.IStatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * 扩展的状态码
 */
@Getter
@AllArgsConstructor
@SuppressWarnings("all")
public enum UserStatusCode implements IStatusCodeEnum {
    ERR_2000(2000, "用户信息不存在"),
    ERR_2001(2001, "用户昵称格式错误"),
    ;

    private Integer status;
    private String msg;

    @Override
    public Integer getCode() {
        return status;
    }

    @Override
    public String getDescription() {
        return msg;
    }

    public static Optional<IEnum<Integer>> of(Integer code) {
        return Optional.ofNullable(ICodeEnum.parseByCode(UserStatusCode.class, code));
    }
}
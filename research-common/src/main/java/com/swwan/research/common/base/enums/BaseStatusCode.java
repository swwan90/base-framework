package com.swwan.research.common.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * 基础的状态码
 *
 * @author swwan
 * @date 2021/12/18 - 16:46
 */
@Getter
@AllArgsConstructor
public enum BaseStatusCode implements IStatusCodeEnum {
    /**
     * 成功
     */
    SUCCESS(200, "成功!"),

    /**
     * 参数错误
     */
    ERR_1000(1000, "参数错误!"),

    /**
     * 未知错误
     */
    ERR_9999(9999, "未知错误!");

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
        return Optional.ofNullable(ICodeEnum.parseByCode(BaseStatusCode.class, code));
    }
}

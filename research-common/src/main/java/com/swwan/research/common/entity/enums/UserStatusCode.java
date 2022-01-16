package com.swwan.research.common.entity.enums;

import com.swwan.research.common.base.IStatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 扩展的状态码
 */
@Getter
@AllArgsConstructor
@SuppressWarnings("all")
public enum UserStatusCode implements IStatusCode {
    ERR_2000(2000, "用户信息不存在"),
    ERR_2001(2001, "用户昵称格式错误"),
    ;

    private Integer status;
    private String msg;

    public static void main(String[] args) {
        IStatusCode userStatusCode = UserStatusCode.ERR_2000;
        System.out.println(userStatusCode.getStatus()+":"+userStatusCode.getMsg());
    }
}
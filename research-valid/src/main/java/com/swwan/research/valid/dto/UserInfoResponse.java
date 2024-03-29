package com.swwan.research.valid.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.swwan.research.common.base.mvc.ResponseJsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户信息响应
 *
 * @author swwan
 * @date 2021/12/18 - 15:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoResponse {

    /**
     * 用户名称
     */
    @JsonView(ResponseJsonView.Base.class)
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 电话号码
     */
    private String phone;

    private String create;

    private Date createTime;

    private String update;

    private String updateTime;
}


package com.swwan.research.valid.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * 用户信息请求
 *
 * @author swwan
 * @date 2021/12/18 - 15:12
 */
@Data
public class UserInfoRequest {

    /**
     * 用户名称
     */
    @NotBlank(message = "姓名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 年龄
     */
    @NotBlank(message = "年龄不能为空")
    @Min(value = 0, message = "年龄不能小于0岁")
    @Max(value = 120, message = "年龄不能大于120岁")
    private Integer age;

    /**
     * 性别
     * TODO 约束取值在枚举中
     */
    private Integer gender;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String mail;

    /**
     * 电话号码
     */
    @NotBlank(message = "联系方式不能为空")
    @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$", message = "号码格式不正确!")
    private String phone;

    /**
     * TODO 创建和更新的四个属性使用mybatis-plus封装起来，在操作数据库时自动注入
     */
    private String create;

    private String createTime;

    private String update;

    private String updateTime;
}

package com.swwan.research.valid.dto;

import com.swwan.research.common.dto.DictCode;
import com.swwan.research.common.utils.validator.CaseCheck;
import com.swwan.research.common.utils.validator.CaseMode;
import com.swwan.research.common.utils.validator.InDictionaryCheck;
import lombok.Data;

import javax.validation.constraints.*;

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
    @NotBlank(message = "姓名不能为空", groups = BaseValidate.class)
    private String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空", groups = InsertValidate.class)
    private String password;


    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空", groups = BaseValidate.class)
    @Min(value = 0, message = "年龄不能小于0岁", groups = BaseValidate.class)
    @Max(value = 120, message = "年龄不能大于120岁", groups = BaseValidate.class)
    private Integer age;

    /**
     * 状态
     */
    @NotBlank
    @CaseCheck(value = CaseMode.UPPER, message = "状态必须为大写字母", groups = {InsertValidate.class})
    @InDictionaryCheck(value = DictCode.数据状态, message = "状态输入不正确", groups = InsertValidate.class)
    private String status;
    /**
     * 性别
     * TODO 约束取值在枚举中
     */
    private Integer gender;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空", groups = UpdateValidate.class)
    @Email(message = "邮箱格式不正确", groups = UpdateValidate.class)
    private String mail;

    /**
     * 电话号码
     */
    @NotBlank(message = "联系方式不能为空")
    @Pattern(regexp = "^1(3\\d|4[5-9]|5[0-35-9]|6[2567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$", message = "号码格式不正确!")
    private String phone;

    /**
     * TODO 创建和更新的四个属性使用mybatis-plus封装起来，在操作数据库时自动注入
     */
    private String create;

    private String createTime;

    private String update;

    private String updateTime;

    /**
     * 基础的校验接口，标识着所有操作都需要校验的字段
     */
    public interface BaseValidate {
    }

    /**
     * 修改的校验接口
     * 继承自BaseValidate 也就是说指定为这个组的时候,在满足当前足校验规则的同时，还得满足 base 接口
     */
    public interface UpdateValidate extends BaseValidate {
    }

    /**
     * 增加的校验接口
     */
    public interface InsertValidate extends UpdateValidate {
    }
}

package com.swwan.research.vo;

import com.swwan.research.enums.annotation.enumerate.AccountType;
import com.swwan.research.enums.annotation.enumerate.Gender;
import lombok.Data;

/**
 * @author swwan
 * @date 2022/4/9 - 10:14
 */
@Data
public class UserEntity {
    private String username;
    private String password;
    private Gender gender;
    private AccountType accountType;
}

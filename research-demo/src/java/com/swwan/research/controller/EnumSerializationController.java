package com.swwan.research.controller;

import com.swwan.research.enums.annotation.enumerate.AccountType;
import com.swwan.research.enums.annotation.enumerate.Gender;
import com.swwan.research.mapping.UserMapper;
import com.swwan.research.vo.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author swwan
 * @date 2022/4/9 - 17:11
 */
@RestController
@RequiredArgsConstructor
public class EnumSerializationController {

    private final UserMapper userMapper;

    @GetMapping
    public List<UserEntity> get() {
        return userMapper.select();
    }

    @PostMapping
    public void creat(@RequestBody UserEntity userEntity) {
        userMapper.insert(userEntity);
    }

    @GetMapping("/gender")
    public Gender gender(Gender gender) {
        return gender;
    }

    @GetMapping("/accountType")
    public AccountType accountType(AccountType accountType) {
        return accountType;
    }
}

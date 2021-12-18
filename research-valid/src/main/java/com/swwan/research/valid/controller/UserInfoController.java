package com.swwan.research.valid.controller;

import cn.hutool.json.JSONUtil;
import com.swwan.research.valid.dto.UserInfoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息控制器
 *
 * @author swwan
 * @date 2021/12/18 - 15:48
 */
@Slf4j
@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    @PostMapping("/add")
    public void add(@Validated @RequestBody UserInfoRequest userInfoRequest) {
        log.info("add() called with parameters => 【userInfoRequest = {}】", JSONUtil.toJsonPrettyStr(userInfoRequest));
    }

    @PostMapping("/test/exception/print")
    public void printExceptionMessage() {
        String s = "Hello world";
        try {
            Integer i = Integer.valueOf(s);
        } catch (NumberFormatException e) {
            log.error("Failed to format {}", s);
        }
    }
}

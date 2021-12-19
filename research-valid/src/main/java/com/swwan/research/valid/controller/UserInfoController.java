package com.swwan.research.valid.controller;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonView;
import com.swwan.research.common.base.BaseResponse;
import com.swwan.research.common.base.ResponseJsonView;
import com.swwan.research.common.base.ValidateGroup;
import com.swwan.research.common.utils.response.ResponseDataBody;
import com.swwan.research.common.utils.response.ResponseUtils;
import com.swwan.research.valid.dto.UserInfoRequest;
import com.swwan.research.valid.dto.UserInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public void add(@Validated(ValidateGroup.Base.class) @RequestBody UserInfoRequest userInfoRequest) {
        log.info("add() called with parameters => 【userInfoRequest = {}】", JSONUtil.toJsonPrettyStr(userInfoRequest));
    }

    @PostMapping("/add2")
    public ResponseEntity<BaseResponse<UserInfoResponse>> add2(@Validated(ValidateGroup.Base.class) @RequestBody UserInfoRequest userInfoRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> log.error("error field is : {}, message is : {}", fieldError.getField(), fieldError.getDefaultMessage()));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        log.info("add() called with parameters => 【userInfoRequest = {}】", JSONUtil.toJsonPrettyStr(userInfoRequest));
        return new ResponseEntity<>(ResponseUtils.success(new UserInfoResponse()), HttpStatus.OK);
    }

    @PostMapping("/add3")
    @JsonView(ResponseJsonView.Base.class)
    public BaseResponse<UserInfoResponse> add3(@Validated(ValidateGroup.Base.class) @RequestBody UserInfoRequest userInfoRequest) {
//        log.info("add() called with parameters => 【userInfoRequest = {}】", JSONUtil.toJsonPrettyStr(userInfoRequest));

        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setUsername("xxx");
        userInfoResponse.setPassword("xxx");
        userInfoResponse.setMail("xxx");
        return  ResponseUtils.success(userInfoResponse);
    }

    @PostMapping("/add4")
    @JsonView(ResponseJsonView.Base.class)
    @ResponseDataBody
    public UserInfoResponse add4(@Validated(ValidateGroup.Base.class) @RequestBody UserInfoRequest userInfoRequest) {
//        log.info("add() called with parameters => 【userInfoRequest = {}】", JSONUtil.toJsonPrettyStr(userInfoRequest));

        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setUsername("xxx");
        userInfoResponse.setPassword("xxx");
        userInfoResponse.setMail("xxx");
        return  userInfoResponse;
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

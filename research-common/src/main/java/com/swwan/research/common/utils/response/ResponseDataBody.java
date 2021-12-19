package com.swwan.research.common.utils.response;

import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * 将返回结果封装到 BaseResponse
 *
 * @author swwan
 * @date 2021/12/19 - 12:43
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ResponseBody
public @interface ResponseDataBody {
}

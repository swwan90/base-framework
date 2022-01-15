//package com.swwan.research.common.base;
//
//import cn.hutool.json.JSONUtil;
//import com.swwan.research.common.dto.ParamErrorDto;
//import com.swwan.research.common.utils.response.ResponseDataBody;
//import com.swwan.research.common.utils.response.ResponseUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.validation.BindException;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Controller的的基础对象
// *
// * @author swwan
// * @date 2021/12/19 - 13:23
// */
//@Slf4j
//@ResponseDataBody
//public class BaseController {
//
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public Object httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException httpMessageNotReadableException) {
//        log.error("捕获请求参数读取异常：", httpMessageNotReadableException);
//        // 前端未传递参数，导致读取参数异常
//        return ResponseUtil.error(BaseStatusCode.ERR_1000);
//    }
//
//    @ExceptionHandler(BindException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public Object bindExceptionHandler(BindException bindException) {
//        log.error("捕获请求参数校验异常：", bindException);
//        // 获取到所有的校验失败的属性
//        List<FieldError> fieldErrors = bindException.getFieldErrors();
//
//        // 实例化一个用于装参数错误的列表
//        List<ParamErrorDto> paramErrorDtoList = new ArrayList<>();
//        fieldErrors.forEach(fieldError -> paramErrorDtoList.add(new ParamErrorDto(fieldError.getField(), fieldError.getDefaultMessage())));
//
//        log.info("请求参数校验异常信息：{}", JSONUtil.toJsonStr(paramErrorDtoList));
//        return ResponseUtil.error(BaseStatusCode.ERR_1000, paramErrorDtoList);
//    }
//
//    @ExceptionHandler(BaseException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public Object baseExceptionHandler(BaseException baseException) {
//        log.error("捕获到业务异常!", baseException);
//        // 基础的业务异常
//        return ResponseUtil.error(baseException);
//    }
//
//    /**
//     * 兜底的异常处理
//     * 通过ExceptionHandler 捕获controller未捕获到的异常，
//     * 给用户一个友好的返回
//     *
//     * @param ex 异常信息
//     * @return 封装的返回对象
//     */
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public Object exceptionHandler(Exception ex) {
//        log.error("exceptionHandler....");
//        // 所有的  自定义的、已知的异常全部都没有匹配上
//        // 直接响应响应一个未知错误的提醒
//        return ResponseUtil.error(BaseStatusCode.ERR_9999);
//    }
//}

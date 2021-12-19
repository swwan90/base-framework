package com.swwan.research.common.utils.response;

import com.swwan.research.common.base.BaseResponse;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;

/**
 * ResponseDataBody注解 实现
 * 将返回结果封装到 BaseResponse
 *
 * @author swwan
 * @date 2021/12/19 - 12:44
 */
@RestControllerAdvice(basePackages = "com.swwan.research")
public class ResponseDataBodyAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 得到自定义的注解
     */
    private static final Class<? extends Annotation> ANNOTATION_TYPE = ResponseDataBody.class;

    /**
     * 判断类或者方法是否使用了 @ResponseDataBody
     * 这里将注解添加在BaseController上面；
     * 只要继承了BaseController的Controller都使用了该注解
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return AnnotatedElementUtils.hasAnnotation(methodParameter.getContainingClass(), ANNOTATION_TYPE)
                || methodParameter.hasMethodAnnotation(ANNOTATION_TYPE);
    }

    /**
     * 将返回结果封装到 BaseResponse
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        // 防止重复包裹的问题
        if (o instanceof BaseResponse) {
            return o;
        }
        return ResponseUtils.success(o);
    }
}

package com.swwan.research.common.utils.response;

import com.swwan.research.common.base.enums.BaseStatusCode;
import com.swwan.research.common.base.mvc.BaseException;
import com.swwan.research.common.base.mvc.BaseResponse;
import org.springframework.http.HttpStatus;

/**
 * 响应帮助类
 */
public class ResponseUtil {

    /**
     * 响应成功
     *
     * @return 基础的响应对象
     */
    public static BaseResponse<Void> success() {
        return new BaseResponse<>(BaseStatusCode.SUCCESS);
    }

    /**
     * 根据Http状态码返回
     *
     * @return 基础的响应对象
     */
    public static BaseResponse<Void> successByHttpStatus() {
        return new BaseResponse<>(HttpStatus.OK);
    }

    /**
     * 根据自定义的状态码返回
     * 有响应数据的成功
     *
     * @param data 响应的数据
     * @param <T>  响应的数据类型
     * @return 基础的响应对象
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(BaseStatusCode.SUCCESS, data);
    }

    /**
     * 根据http状态码返回
     *
     * @param data 响应的数据
     * @param <T>  响应的数据类型
     * @return 基础的响应对象
     */
    public static <T> BaseResponse<T> successByHttpStatus(T data) {
        return new BaseResponse<>(HttpStatus.OK, data);
    }

    /**
     * 没有响应数据的失败
     *
     * @param statusCode 状态码
     * @return 基础的响应对象
     */
    public static BaseResponse<Void> error(BaseStatusCode statusCode) {
        return new BaseResponse<>(statusCode);
    }

    /**
     * 有响应数据的失败
     *
     * @param statusCode 状态码
     * @param data       数据
     * @return 基础的响应对象
     */
    public static <T> BaseResponse<T> error(BaseStatusCode statusCode, T data) {
        return new BaseResponse<>(statusCode, data);
    }

    /**
     * 异常后的响应
     *
     * @param baseException 异常
     * @return 基础的响应对象
     */
    public static BaseResponse<Void> error(BaseException baseException) {
        return new BaseResponse<>(baseException);
    }
}
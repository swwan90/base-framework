package com.swwan.research.common.base.mvc;

import com.swwan.research.common.base.enums.BaseStatusCode;
import com.swwan.research.common.base.enums.IStatusCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * 基础异常
 *
 * @author swwan
 * @date 2021/12/18 - 16:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {
    /**
     * 错误码
     */
    private Integer error;

    /**
     * 错误描述
     */
    private String msg;

    /**
     * 错误后响应的信息
     */
    private Object data;

    /**
     * 根据错误码实例化异常
     *
     * @param statusCode 自定义错误码
     */
    public BaseException(IStatusCodeEnum statusCode) {
        // 校验是否传递了异常码
        if (null == statusCode) {
            // 如果没有统一设置为未知错误
            setInfo(BaseStatusCode.ERR_9999);
        } else {
            setInfo(statusCode);
        }
    }

    /**
     * 根据http状态码抛出异常
     *
     * @param httpStatus http状态码
     */
    public BaseException(HttpStatus httpStatus) {
        if (null == httpStatus) {
            // 没有传递默认使用 未知异常
            setInfo(BaseStatusCode.ERR_9999);
        } else {
            setInfo(httpStatus);
        }
    }

    /**
     * 根据错误码实例化异常 并返回数据
     *
     * @param statusCode 状态码
     * @param data       数据
     */
    public BaseException(IStatusCodeEnum statusCode, Object data) {
        // 校验是否传递了异常码
        if (null == statusCode) {
            // 如果没有统一设置为未知错误
            setInfo(BaseStatusCode.ERR_9999);
        } else {
            setInfo(statusCode);
        }
        // 校验数据是否为null
        if (null != data) {
            this.data = data;
        }
    }

    /**
     * 根据http的状态码实例化异常 并返回数据
     *
     * @param httpStatus HTTP状态码
     * @param data       数据
     */
    public BaseException(HttpStatus httpStatus, Object data) {
        // 校验是否传递了异常码
        if (null == httpStatus) {
            // 如果没有统一设置为未知错误
            setInfo(BaseStatusCode.ERR_9999);
        } else {
            setInfo(httpStatus);
        }
        // 校验数据是否为null
        if (null != data) {
            this.data = data;
        }
    }


    /**
     * 设置状态码及描述信息
     * 内部使用的方法
     *
     * @param statusCode 状态码
     */
    private void setInfo(IStatusCodeEnum statusCode) {
        if (null != statusCode) {
            this.error = statusCode.getStatus();
            this.msg = statusCode.getMsg();
        }
    }

    /**
     * 根据HttpStatus设置属性
     *
     * @param httpStatus HTTP状态码
     */
    private void setInfo(HttpStatus httpStatus) {
        if (null != httpStatus) {
            this.error = httpStatus.value();
            this.msg = httpStatus.getReasonPhrase();
        }
    }
}


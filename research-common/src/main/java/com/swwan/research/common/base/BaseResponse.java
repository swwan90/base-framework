package com.swwan.research.common.base;

import cn.hutool.core.util.StrUtil;
import com.swwan.research.common.utils.cast.CastUtils;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * 基础响应对象
 * 
 * @author swwan
 * @date 2021/12/18 - 16:42
 */
@Data
public class BaseResponse<T> {
    /**
     * 状态码
     */
    private Integer status;
    /**
     * 状态描述
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;

    /**
     * 只有状态码的响应
     *
     * @param statusCode 状态码
     */
    public BaseResponse(IStatusCode statusCode) {
        if (null != statusCode) {
            this.status = statusCode.getStatus();
            this.msg = statusCode.getMsg();
        }
    }

    /**
     * 有状态码且有参数的响应
     *
     * @param statusCode 状态码
     * @param data  返回数据
     */
    public BaseResponse(IStatusCode statusCode, T data) {
        if (null != statusCode) {
            this.status = statusCode.getStatus();
            this.msg = statusCode.getMsg();
        }
        if (null != data) {
            this.data = data;
        }
    }

    /**
     * 根据HttpStatus响应
     *
     * @param httpStatus http请求状态码
     */
    public BaseResponse(HttpStatus httpStatus) {
        if (null != httpStatus) {
            this.status = httpStatus.value();
            this.msg = httpStatus.getReasonPhrase();
        }
    }

    /**
     * 根据http状态码返回 并返回额外返回数据
     *
     * @param httpStatus http状态码
     * @param data       数据
     */
    public BaseResponse(HttpStatus httpStatus, T data) {
        if (null != httpStatus) {
            this.status = httpStatus.value();
            this.msg = httpStatus.getReasonPhrase();
        }
        if (null != data) {
            this.data = data;
        }
    }

    /**
     * 根据异常响应错误码
     *
     * @param baseException 异常对象
     */
    public BaseResponse(BaseException baseException) {
        if (null != baseException) {
            this.status = baseException.getError();
            this.msg = baseException.getMsg();
            this.data = CastUtils.castObject2Type(baseException);
        }
    }

    /**
     * 响应数据最外层的视图 也是所有响应视图的父类
     */
    public interface ResponseBaseView {
    }
}

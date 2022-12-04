package com.swwan.research.common.exception;

import com.swwan.research.common.base.enums.IStatusCodeEnum;
import com.swwan.research.common.base.mvc.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author swwan
 * @date 2021/12/24 - 23:46
 */

public class RequestServletException extends BaseException {


    public RequestServletException(IStatusCodeEnum statusCode) {
        super(statusCode);
    }

    public RequestServletException(HttpStatus httpStatus) {
        super(httpStatus);
    }

    public RequestServletException(IStatusCodeEnum statusCode, Object data) {
        super(statusCode, data);
    }

    public RequestServletException(HttpStatus httpStatus, Object data) {
        super(httpStatus, data);
    }
}

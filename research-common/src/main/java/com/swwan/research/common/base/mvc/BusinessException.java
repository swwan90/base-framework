package com.swwan.research.common.base.mvc;

import com.swwan.research.common.base.enums.BaseEnum;
import lombok.Getter;

/**
 * 业务异常
 * 强制业务异常必须提供code码，便于统一维护
 *
 * @author swwan
 * @date 2022/12/7 - 20:19
 */
@Getter
public class BusinessException extends RuntimeException {

    private final BaseEnum msg;

    private Object data;

    public BusinessException(BaseEnum msg) {
        super(msg.getDescription());
        this.msg = msg;
    }

    public BusinessException(BaseEnum msg, Object data) {
        super(msg.getDescription());
        this.msg = msg;
        this.data = data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

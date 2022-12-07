package com.swwan.research.common.base.mvc;

import com.swwan.research.common.base.validate.ValidateResult;

import java.util.List;

/**
 * 参数校验异常
 *
 * @author swwan
 * @date 2022/12/7 - 20:27
 */
public class ValidationException extends RuntimeException {

    private List<ValidateResult> results;

    public ValidationException(List<ValidateResult> results) {
        super();
        this.results = results;
    }
}

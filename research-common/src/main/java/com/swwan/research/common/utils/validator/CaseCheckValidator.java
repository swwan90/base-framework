package com.swwan.research.common.utils.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 大小写校验器
 *
 * @author swwan
 * @date 2021/12/18 - 17:20
 */
public class CaseCheckValidator implements ConstraintValidator<CaseCheck, String> {

    /**
     * 大小写模式枚举
     */
    private CaseMode caseMode;

    public static void main(String[] args) {
        String value = "aaAA1";
        String pattern = "^[a-zA-Z]*$";
        boolean isMatch = Pattern.matches(pattern, value);
        System.out.println(isMatch);
    }

    @Override
    public void initialize(CaseCheck constraintAnnotation) {
        this.caseMode = constraintAnnotation.value();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        // 如果文本为空，不进行校验
        // 因为有其他的注解是可以校验空或者空字符串的
        if (value == null) {
            return true;
        }

        // 校验是否是纯字母
        String pattern = "^[a-zA-Z]*$";
        boolean isMatch = Pattern.matches(pattern, value);
        // 如果存在非字母，校验失败
        if (!isMatch) {
            return false;
        }

        // 如果没有指定方式，校验失败
        if (caseMode == null) {
            return false;
        }


        // 校验是否符合指定大小写模式
        boolean result = false;
        switch (caseMode) {
            case UPPER:
                result = value.equals(value.toUpperCase());
                break;
            case LOWER:
                result = value.equals(value.toLowerCase());
                break;
            default:
        }
        return result;
    }
}

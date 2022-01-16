package com.swwan.research.common.utils.validator;

import com.swwan.research.common.entity.enums.DictCode;
import com.swwan.research.common.entity.enums.DictCodeList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 字典校验器
 *
 * @author swwan
 * @date 2021/12/18 - 20:14
 */
public class InDictionaryCheckValidator implements ConstraintValidator<InDictionaryCheck, String> {

    /**
     * 数据字典
     */
    private DictCode dictCode;


    @Override
    public void initialize(InDictionaryCheck constraintAnnotation) {
        this.dictCode = constraintAnnotation.value();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * 校验数据
     *
     * @param value                      待校验数据
     * @param constraintValidatorContext 注解中内容
     * @return 是否通过
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        // 如果文本为空，不进行校验
        // 因为有其他的注解是可以校验空或者空字符串的
        if (value == null) {
            return true;
        }

        // 如果没有指定数据字典，校验失败
        if (dictCode == null) {
            return false;
        }

        // 校验字典值是否包含
        DictCodeList dictCodeList = DictCodeList.from(dictCode, value);
        return dictCodeList != null;
    }

    public static void main(String[] args) {
        DictCode YES_NO = DictCode.是否;
        DictCodeList dictCodeList1 = DictCodeList.from(YES_NO, "01");
        DictCodeList dictCodeList2 = DictCodeList.from(YES_NO, "03");
        System.out.println("dict1" + dictCodeList1);
        System.out.println("dict2" + dictCodeList2);
    }
}

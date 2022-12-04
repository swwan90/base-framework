package com.swwan.research.common.utils.validator;

import com.swwan.research.common.pojo.enums.DictCode;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 字典校验
 *
 * Constraint：指定校验器
 * @author swwan
 * @date 2021/12/18 - 17:18
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InDictionaryCheckValidator.class)
public @interface InDictionaryCheck {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    DictCode value() default DictCode.空字典;
}

package com.swwan.research.common.annotation;

import java.lang.annotation.*;

/**
 * 类型转换的注解
 *
 * @author swwan
 * @date 2022/12/5 - 1:19
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ElementType.FIELD})
public @interface TypeConverter {

    String toTypeFullName() default "java.lang.String";
}

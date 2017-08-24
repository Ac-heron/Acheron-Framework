package com.herohuang.framework.annotation;

import com.herohuang.framework.enums.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法注解
 *
 * @author Acheron
 * @date 24/07/2017
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {

    /**
     * 请求类型与路径
     */
    String value();

    /**
     * 请求的方法方式get post etc..
     *
     * @return
     * @see com.herohuang.framework.enums.RequestMethod
     */
    RequestMethod method();

}

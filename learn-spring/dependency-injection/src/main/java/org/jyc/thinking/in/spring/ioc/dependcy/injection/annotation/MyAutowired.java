package org.jyc.thinking.in.spring.ioc.dependcy.injection.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

/**
 * 自定义注解
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Autowired
public @interface MyAutowired {
    boolean required() default true;
}

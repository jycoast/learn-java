package org.jyc.thinking.in.spring.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义Component注解
 *
 * @author jiyongchao
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@MyComponent // 元注解，实现@Component
public @interface MyComponent2 {
}

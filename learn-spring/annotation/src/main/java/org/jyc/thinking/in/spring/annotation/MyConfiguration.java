package org.jyc.thinking.in.spring.annotation;

/**
 * @author jiyongchao
 */
@MyComponent2
public @interface MyConfiguration {

    String name() default "";
}

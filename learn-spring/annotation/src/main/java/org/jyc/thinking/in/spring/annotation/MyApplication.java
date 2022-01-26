package org.jyc.thinking.in.spring.annotation;

import java.lang.annotation.*;

/**
 * 自定义应用注解
 *
 * @author jiyongchao
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@MyComponent2
@MyConfiguration(name = "my-application")
public @interface MyApplication {
}

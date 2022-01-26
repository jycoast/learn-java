package org.jyc.thinking.in.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 自定义的ComponentScan
 *
 * @author jiyongchao
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MyComponentScan
public @interface MyComponentScan2 {

    @AliasFor(annotation = MyComponentScan.class, attribute = "scanBasePackages")
    String[] BasePackages() default {};

    /**
     * 隐形覆盖
     * 在@MyComponentScan中也有scanBasePackages属性，如果注解中存在同名的就会覆盖掉元标注注解中的属性
     *
     * @return
     */
    String[] scanBasePackages() default {};

    /**
     * 显性覆盖
     * packages覆盖了scanBasePackages 同时覆盖了@MyComponentScan.scanBasePackages
     *
     * @return
     */
    @AliasFor("scanBasePackages")
    String[] packages() default {};
}

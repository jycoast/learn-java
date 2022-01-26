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
@ComponentScan
public @interface MyComponentScan {
    /**
     * 隐形别名,当被元标注的注解中的属性无法表达语义的时候，就需要额外增加attribute属性，如果没有attribute属性，就表示"继承" @AliasFor中的注解的属性
     * <p>
     * 是注解的一种"多态"，子注解提供了新的属性方法引用"父"（元）注解中的属性方法
     *
     * @return
     */
    @AliasFor(annotation = ComponentScan.class, attribute = "basePackages")
    String[] scanBasePackages() default {"#"};

    /**
     * scanBasePackages -> @AliasFor ComponentScan.basePackages.value(显性别名)
     *
     * @AliasFor ComponentScan.basePackages.value 传递隐形别名,而且这种方式是支持多层次的
     */
//    @AliasFor(annotation = ComponentScan.class, attribute = "value")
//    String[] scanBasePackages() default {};
}

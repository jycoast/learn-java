package org.jyc.thinking.in.spring.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 激活“HelloWorld”模块注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
// 第二步：通过@Import注解导入具体实现
//@Import(HelloWorldConfiguration.class)
// 方法二：通过@ImportSelector接口实现
//@Import(HelloWorldImportSelector.class)
//方法三：通过 ImportBeanDefinitionRegistrar
@Import(HelloWorldImportBeanDefinitionRegistrar.class)
public @interface EnableHelloWorld {
}

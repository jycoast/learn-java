package org.jyc.thinking.in.spring.aop.features;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AspectJ XML方式示例
 */
@Configuration
@Aspect // 声名为切面类
public class AspectJXmlDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/spring-aop-context.xml");
        AspectJXmlDemo aspectJXmlDemo = context.getBean(AspectJXmlDemo.class);
        System.out.println(aspectJXmlDemo);
        context.close();
    }
}

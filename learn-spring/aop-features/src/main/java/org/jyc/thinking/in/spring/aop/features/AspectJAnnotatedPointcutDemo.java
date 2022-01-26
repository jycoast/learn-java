package org.jyc.thinking.in.spring.aop.features;

import org.jyc.thinking.in.spring.aop.features.aspect.AspectConfiguration;
import org.jyc.thinking.in.spring.aop.features.aspect.AspectConfiguration2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Pointcut 基于注解示例
 */
@Configuration
@EnableAspectJAutoProxy
public class AspectJAnnotatedPointcutDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AspectJAnnotatedPointcutDemo.class, AspectConfiguration.class, AspectConfiguration2.class);
        context.refresh();
        AspectJAnnotatedPointcutDemo aspectJAnnotationDemo = context.getBean(AspectJAnnotatedPointcutDemo.class);
        aspectJAnnotationDemo.execute();
        context.close();
    }

    public void execute() {
        System.out.println("execute()...");
    }
}

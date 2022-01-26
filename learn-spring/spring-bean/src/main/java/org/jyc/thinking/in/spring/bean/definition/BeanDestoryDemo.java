package org.jyc.thinking.in.spring.bean.definition;

import org.jyc.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.jyc.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

public class BeanDestoryDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanDestoryDemo.class);
        applicationContext.refresh();
        // 非延迟初始化在Spring应用上下文启动完成后，被初始化。
        System.out.println("应用上下文已启动...");
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);
        System.out.println("应用上下文准备关闭...");
        applicationContext.close();
        System.out.println("应用上下文已关闭...");
    }

    @Bean(initMethod = "initUserFactory",destroyMethod = "doDestory")
    @Lazy(value = false)
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}

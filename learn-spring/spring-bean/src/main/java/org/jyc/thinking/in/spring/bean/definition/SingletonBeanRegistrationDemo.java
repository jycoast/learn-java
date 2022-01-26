package org.jyc.thinking.in.spring.bean.definition;

import org.jyc.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.jyc.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 单体Bean注册示例
 */
public class SingletonBeanRegistrationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册外部单例对象
        UserFactory userFactory = new DefaultUserFactory();
        // 创建一个外部UserFactory对象
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        // 注册外部单例对象
        beanFactory.registerSingleton("userFactory", userFactory);
        applicationContext.refresh();
        UserFactory userFactoryByLookup = beanFactory.getBean("userFactory", UserFactory.class);
        System.out.println("userFactory == userFactoryByLookup: " + (userFactory == userFactoryByLookup));
        applicationContext.close();
    }
}

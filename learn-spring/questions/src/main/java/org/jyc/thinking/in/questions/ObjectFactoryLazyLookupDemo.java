package org.jyc.thinking.in.questions;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * {@link org.springframework.beans.factory.ObjectFactory} 延迟依赖查找示例
 *
 * @author jiyongchao
 */
public class ObjectFactoryLazyLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ObjectFactoryLazyLookupDemo.class);
        context.refresh();

        ObjectFactoryLazyLookupDemo demo = context.getBean(ObjectFactoryLazyLookupDemo.class);
        // 代理对象
        ObjectProvider<User> objectProvider = demo.objectProvider;
        ObjectFactory<User> userObjectFactory = demo.userObjectFactory;

        // ObjectFactory和ObjectProvider
        System.out.println("userObjectFactory == objectProvider: " +
                (userObjectFactory == objectProvider));
        // 结果为true，说明两者的底层实现是一样的。
        System.out.println("userObjectFactory.getClass() == objectProvider.getClass(): " +
                (userObjectFactory.getClass() == objectProvider.getClass()));

        // 实际对象(延迟查找)
        System.out.println(userObjectFactory.getObject());
        System.out.println(objectProvider.getObject());
        System.out.println(context.getBean(User.class));
        context.close();
    }

    @Autowired
    private ObjectFactory<User> userObjectFactory;

    @Autowired
    private ObjectProvider<User> objectProvider;

    @Bean
    @Lazy
    public User user() {
        User user = new User();
        user.setId("111111");
        user.setName("吉永超");
        return user;
    }
}

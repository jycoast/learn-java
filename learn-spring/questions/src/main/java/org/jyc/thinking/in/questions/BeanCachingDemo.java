package org.jyc.thinking.in.questions;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * Bean缓存示例
 *
 * @author jiyongchao
 */
public class BeanCachingDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanCachingDemo.class);
        context.refresh();

        BeanCachingDemo beanCachingDemo = context.getBean(BeanCachingDemo.class);

        for (int i = 0; i < 9; i++) {
            // singletonBean会被缓存
            System.out.println(beanCachingDemo == context.getBean(BeanCachingDemo.class));
        }
        User user = context.getBean(User.class);

        for (int i = 0; i < 9; i++) {
            // prototype不会被缓存
            System.out.println(user == context.getBean(User.class));
        }
        context.close();
    }

    @Bean
//    @Scope("prototype") //原型scope
    public static User user() {
        User user = new User();
        user.setId("111111");
        user.setName("吉永超");
        return user;
    }
}

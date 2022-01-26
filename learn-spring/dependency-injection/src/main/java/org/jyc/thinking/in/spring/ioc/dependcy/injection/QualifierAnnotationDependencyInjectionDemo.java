package org.jyc.thinking.in.spring.ioc.dependcy.injection;


import org.jyc.thinking.in.spring.ioc.dependcy.injection.annotation.UserGroup;
import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/**
 * {@link org.springframework.beans.factory.annotation.Qualifier} 使用示例
 */
public class QualifierAnnotationDependencyInjectionDemo {

    @Autowired // SuperUser -> primary = true
    private User user;

    @Autowired
    @Qualifier("user") // 指定Bean名称或者ID
    private User namedUser;

    @Autowired
    private Collection<User> allUsers;

    @Autowired
    @Qualifier
    private Collection<User> qualifierUsers;

    @Autowired
    @UserGroup
    private Collection<User> groupedUsers;

    @Bean
    @Qualifier // 进行逻辑分组
    public User user1() {
        User user = new User();
        user.setId("7");
        return user;
    }

    @Bean
    @Qualifier
    public User user2() {
        User user = new User();
        user.setId("8");
        return user;
    }

    @Bean
    @UserGroup
    public User user3() {
        User user = new User();
        user.setId("9");
        return user;
    }

    @Bean
    @UserGroup
    public User user4() {
        User user = new User();
        user.setId("10");
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(QualifierAnnotationDependencyInjectionDemo.class);
        applicationContext.refresh();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        QualifierAnnotationDependencyInjectionDemo demo = applicationContext.getBean(QualifierAnnotationDependencyInjectionDemo.class);
        // 输出SuperUSer Bean
        System.out.println("demo.user = " + demo.user);
        // 输出 user Bean
        System.out.println("demo.namedUser = " + demo.namedUser);
        // 输出 SuperUSer、user,注意这里输出的不是所有的user对象
        System.out.println("demo.allUsers = " + demo.allUsers);
        // 输出 user1、user2、user3和user4,这个时候这个集合元素也增加了,这种方式了类似继承
        System.out.println("demo.qualifierUsers = " + demo.qualifierUsers);
        // 输出 user3和user4
        System.out.println("demo.groupedUsers = " + demo.groupedUsers);
        applicationContext.close();
    }
}

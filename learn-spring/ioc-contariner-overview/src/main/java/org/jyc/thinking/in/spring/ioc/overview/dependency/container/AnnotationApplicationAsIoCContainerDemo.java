package org.jyc.thinking.in.spring.ioc.overview.dependency.container;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * ApplicationContext作为IoC容器示例
 */
public class AnnotationApplicationAsIoCContainerDemo {
    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationApplicationAsIoCContainerDemo.class);
        applicationContext.refresh();
        // 依赖查找集合对象....
        lookupCollectionType(applicationContext);
        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId("1");
        user.setName("吉永超");
        return user;
    }

    /**
     * 按照类型查找集合对象
     * @param beanFactory
     */
    private static void lookupCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的User集合对象：" + users);
        }
    }
}

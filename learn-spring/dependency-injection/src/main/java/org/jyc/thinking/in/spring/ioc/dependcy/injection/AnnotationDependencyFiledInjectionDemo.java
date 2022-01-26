package org.jyc.thinking.in.spring.ioc.dependcy.injection;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 基于注解的字段注入依赖
 */
public class AnnotationDependencyFiledInjectionDemo {

    @Autowired
    private
    //static @Autowired会忽略掉静态字段
    UserHolder userHolder;

    @Resource
    private UserHolder userHolder2;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 配置Class也是 Spring Bean
        applicationContext.register(AnnotationDependencyFiledInjectionDemo.class);
        applicationContext.refresh();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        AnnotationDependencyFiledInjectionDemo demo = applicationContext.getBean(AnnotationDependencyFiledInjectionDemo.class);

        // Autowired字段关联
        UserHolder userHolder = demo.userHolder;
        // @Resource
        UserHolder userHolder2 = demo.userHolder2;
        System.out.println(userHolder);
        System.out.println(userHolder2);

        System.out.println(userHolder == userHolder2);
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user);
    }
}

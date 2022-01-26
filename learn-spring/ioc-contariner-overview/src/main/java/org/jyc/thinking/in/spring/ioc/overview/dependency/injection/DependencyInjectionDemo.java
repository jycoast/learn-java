package org.jyc.thinking.in.spring.ioc.overview.dependency.injection;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.jyc.thinking.in.spring.ioc.overview.dependency.repository.UserRespository;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入示例
 * 1、通过名称来查找
 * 2、通过类型来查找
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        // 配置XML文件
        // 启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        // 自定义的Bean
        UserRespository userRespository = beanFactory.getBean("userRespository", UserRespository.class);
//        System.out.println(userRespository.getUsers());
        // 依赖注入（内建依赖）
        System.out.println(userRespository.getBeanFactory());
//        System.out.println(userRespository.getBeanFactory() == beanFactory);
        ObjectFactory<ApplicationContext> userFactory = userRespository.getObjectFactory();
        System.out.println(userFactory.getObject() == beanFactory);

        // 依赖查找（错误）
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        // 容器内建Bean对象
        Environment environment = beanFactory.getBean(Environment.class);

        System.out.println("获取Enviroment类型的Bean" + environment);

    }

    private static void whoIsIocContainer(UserRespository userRespository, BeanFactory beanFactory) {
        System.out.println(userRespository.getBeanFactory() == beanFactory);

        // ApplicationContext is BeanFactory
    }
}

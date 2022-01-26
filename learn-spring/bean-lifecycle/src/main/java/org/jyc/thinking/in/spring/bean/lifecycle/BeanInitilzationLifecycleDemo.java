package org.jyc.thinking.in.spring.bean.lifecycle;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.SuperUser;
import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean的实例化
 */
public class BeanInitilzationLifecycleDemo {
    public static void main(String[] args) {
        executeBeanFactory();
    }

    public static void executeBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 方法一：添加BeanPostProcesssor实现InstantiationAwareBeanPostProcessor
        // 方法二：将MyInstantiationAwareBeanPostProcessor作为Bean注册
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());
        // 基于XML资源BeanDefinitionReader 实现
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] locations = {"META-INF/dependency-lookup-context.xml", "META-INF/bean-constructor-dependency-injection.xml"};
        int beanNumbers = xmlBeanDefinitionReader.loadBeanDefinitions(locations);
        System.out.println("已加载的BeanDefinitiond的数量：" + beanNumbers);
        beanFactory.preInstantiateSingletons();
        // 不需要合并BeanDefinition
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user.toString());
        // 需要合并BeanDefinition
        SuperUser superUser = beanFactory.getBean("SuperUser", SuperUser.class);
        System.out.println(superUser.toString());
        // 构造器注入式按照类型注入，底层resolveDependency
        UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
        // SmartInitializingSingleton 通常在Spring AppliactionContext场景使用
        System.out.println(userHolder.toString());
    }
}

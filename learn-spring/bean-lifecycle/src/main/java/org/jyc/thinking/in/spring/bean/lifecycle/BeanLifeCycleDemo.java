package org.jyc.thinking.in.spring.bean.lifecycle;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.SuperUser;
import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

public class BeanLifeCycleDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 方法一：添加BeanPostProcesssor实现InstantiationAwareBeanPostProcessor
        // 方法二：将MyInstantiationAwareBeanPostProcessor作为Bean注册
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        // 添加MyDestructionAwareBeanPostProcessor执行销毁前回调
        beanFactory.addBeanPostProcessor(new MyDestructionAwareBeanPostProcessor());
        // 添加CommonAnnotationBeanPostProcessor，解决@PostCOnstruct @PreDestory
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

        beanFactory.destroyBean("userHolder", userHolder);
        // Bean销毁并不意味这Bean垃圾回收了
        System.out.println(userHolder.toString());
        // 销毁BeanFactory中的单例Bean
        beanFactory.destroySingletons();
        // 强制GC
        System.gc();
        // 等待一段时间
        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        System.gc();
    }
}

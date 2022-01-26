package org.jyc.thinking.in.spring.bean.lifecycle;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.SuperUser;
import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * BeanDefinition合并示例
 */
public class MergedBeanDefinitionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 基于XML资源BeanDefinitionReader 实现
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String location = "META-INF/dependency-lookup-context.xml";
        Resource resource = new ClassPathResource(location);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        int beanNumbers = xmlBeanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.println("已加载的BeanDefinitiond的数量：" + beanNumbers);

        // 不需要合并BeanDefinition
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user.toString());
        // 需要合并BeanDefinition
        SuperUser superUser = beanFactory.getBean("SuperUser", SuperUser.class);
        System.out.println(superUser.toString());
    }
}

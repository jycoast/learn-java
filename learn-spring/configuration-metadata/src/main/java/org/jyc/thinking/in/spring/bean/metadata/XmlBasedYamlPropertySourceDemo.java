package org.jyc.thinking.in.spring.bean.metadata;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @author jiyongchao
 * YAML外部化配置示例
 */
public class XmlBasedYamlPropertySourceDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:/META-INF/yaml-property-source-context.xml");
        // 获取User Bean对象
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }
}

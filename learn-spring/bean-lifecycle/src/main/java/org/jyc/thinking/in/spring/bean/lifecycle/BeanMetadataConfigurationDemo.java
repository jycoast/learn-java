package org.jyc.thinking.in.spring.bean.lifecycle;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @author jiyongchao
 * Bean元信息配置实例
 */
public class BeanMetadataConfigurationDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 实例化PropertiesBeanDefinitionReader
        PropertiesBeanDefinitionReader propertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/user.properties";
        Resource resource = new ClassPathResource(location);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        int beanNumbers = propertiesBeanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.println("已加载的BeanDefinitiond的数量：" + beanNumbers);
        // 通过Bean ID和类型进行依赖查找
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user.toString());
    }
}

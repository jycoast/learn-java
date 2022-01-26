package org.jyc.thinking.in.spring.bean.metadata;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

/**
 * {@link org.springframework.beans.factory.support.PropertiesBeanDefinitionReader}示例
 *
 * @author jiyongchao
 */
public class PropertiesBeanDefinitionReaderDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/users-config-definitions.properties";
        // 默认通过ISO-8859-1
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        // 通过指定的Classpath获取Resource对象
        Resource resource = resourceLoader.getResource(location);
        // 转换成带字符编码的EncodedResource对象
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        int i = beanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.printf("已加载%d 个BeanDefinition\n", i);

        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }
}


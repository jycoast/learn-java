package org.jyc.thinking.in.spring.conversion;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * CustomizedPropertyEditor
 *
 * @author jiyongchao
 */
public class SpringCustomizedPropertyEditorDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/property-editors-context.xml");
        // AbstractApplicationContext -> "conversionService" ConversionService Bean
        // -> configurableBeanFactory#setConversionService(conversionService)
        // -> AbstractAutowireCapableBeanFactory#instantiateBean ->
        // -> AbstractBeanFactory#getConversionServicee
        // -> BeanDefinition -> BeanWrapper -> 属性转换(数据来源：PropertyValues)
        // -> setPropertyValues(PropertyValues) -> TypeConvert#convertIfNecessnary
        // -> TypeConverterDelegate -> PropertyEditor or ConversionService
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
        // 关闭应用上下文
        applicationContext.close();
    }
}
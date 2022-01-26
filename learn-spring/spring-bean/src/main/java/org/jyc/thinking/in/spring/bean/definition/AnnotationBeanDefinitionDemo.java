package org.jyc.thinking.in.spring.bean.definition;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 注解BeanDefinition示例
 */
@Import(AnnotationBeanDefinitionDemo.Config.class) // 3.通过@Import方式导入
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册配置类（configuration class）
//        applicationContext.register(AnnotationBeanDefinitionDemo.class);
        // 通过BeanDefinition注册API实现
        // 1.命名Bean的注册方式
        registerUserBeanDefinition(applicationContext,"mercyblitz-user");
        // 2.非命名Bean的注册方式
        registerUserBeanDefinition(applicationContext);
        applicationContext.refresh();
//        System.out.println("Config类型的所有的Beans" + applicationContext.getBeansOfType(Config.class));
        System.out.println("user类型的所有的Beans" + applicationContext.getBeansOfType(User.class));
        applicationContext.close();
    }

    /**
     * 命名Bean的注册方式
     *  @param registry
     * @param beanName
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", "1").addPropertyValue("name", "jiyongchao");
        // 判断如果beanName参数存在时
        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 非命名的Bean注册方法
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    /**
     * 非命名Bean的注册方式
     * @param registry
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry,null);
    }

    // 2.通过Component方式
    @Component //定义当前类作为Spring Bean（组件）
    public static class Config {
        // 1.通过@Bean方式定义
        @Bean({"user", "jyc"})
        public User user() {
            User user = new User();
            user.setId("1");
            user.setName("吉永超");
            return user;
        }
    }
}

package org.jyc.thinking.in.spring.dependency.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * 外部化配置作为依赖来源示例
 */
@PropertySource(value = "META-INF/default.properties",encoding = "GBK")
@Configuration
public class ExternalConfigurationDependencySourceDemo {

    @Value("${user.id}")
    private String id;

    @Value("${user.resource}")
    private Resource resource;

    // 如果是中文，这里会显示操作系统登录的用户名，而不是在配置文件中配置的信息。这是因为user.name是一个系统属性。
//    @Value("${user.name}")
//    private String name;
    // 直接输出会显示乱码
    @Value("${usr.name}")
    private String name;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ExternalConfigurationDependencySourceDemo.class);
        applicationContext.refresh();
        ExternalConfigurationDependencySourceDemo demo = applicationContext.getBean(ExternalConfigurationDependencySourceDemo.class);
        System.out.println("id: " + demo.id);
        System.out.println("resource: " + demo.resource);
        System.out.println("name: " + demo.name);

        applicationContext.close();
    }
}

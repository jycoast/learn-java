package org.jyc.thinking.in.spring.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;

/**
 * {@link org.springframework.core.env.Environment} 配值属性源变更示例
 */
public class EnvironmentPropertySourceChangeDemo {
    @Value("${user.name}")
    private String UserName; // 不具备动态更新地能力

    // propertySource(“first-property-source”) {user.name = 吉永超}
    // propertySource(Java System Properties) {user.name = jyc}

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(EnvironmentPropertySourceChangeDemo.class);

        // 在Spring应用上下文启动之前，调整Environment中的PropertySource
        ConfigurableEnvironment environment = context.getEnvironment();
        // 获取MutablePropertySources 对象
        MutablePropertySources propertySources = environment.getPropertySources();
        // 动态地插入PropertySource到PropertySources
        HashMap<String, Object> source = new HashMap<>();
        source.put("user.name", "吉永超");
        MapPropertySource propertySource = new MapPropertySource("first-property-source", source);
        propertySources.addFirst(propertySource);
        context.refresh();

        source.put("user.name", "007");
        EnvironmentPropertySourceChangeDemo environmentPropertySourceChangeDemo = context.getBean(EnvironmentPropertySourceChangeDemo.class);
        System.out.println(environmentPropertySourceChangeDemo.UserName);

        for (PropertySource ps : propertySources) {
            System.out.printf("PropertySource(name=%s),'user.name'属性=%s\n", ps.getName(), ps.getProperty("user.name"));
        }
        context.close();
    }
}

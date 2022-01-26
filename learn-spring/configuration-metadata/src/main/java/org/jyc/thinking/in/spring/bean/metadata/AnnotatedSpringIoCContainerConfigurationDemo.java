package org.jyc.thinking.in.spring.bean.metadata;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Map;

/**
 * @author jiyongchao
 */
// 将当前类作为配置类
@ImportResource("classpath:/META-INF/dependency-lookup-context.xml")
@Import(User.class)
@PropertySource("classpath:/META-INF/users-config-definitions.properties") //Java8 + @Repeatable
@PropertySource("classpath:/META-INF/users-config-definitions.properties")
//@PropertySources(@PropertySource(value = "1"))
public class AnnotatedSpringIoCContainerConfigurationDemo {

    @Bean
    public User configuredUser(@Value("${user.id}") String id, @Value("${user.name}") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotatedSpringIoCContainerConfigurationDemo.class);
        context.refresh();
        Map<String, User> userMap = context.getBeansOfType(User.class);
        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            System.out.printf("User Bean name:%s,content: %s \n", entry.getKey(), entry.getValue());
        }
        context.close();
    }
}

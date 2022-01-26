package org.jyc.thinking.in.spring.environment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * {@link Profile} 示例
 *
 * @author jiyognchao
 */
//@Configuration
public class ProfileDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ProfileDemo.class);

        // 获取Environment对象
        ConfigurableEnvironment environment = context.getEnvironment();
        // 默认的Profiles = ["odd"]
        environment.setDefaultProfiles("odd");

        // 添加活跃的Profiles
        environment.setActiveProfiles("even");
        context.refresh();

        Integer number = context.getBean("number", Integer.class);
        System.out.println(number);
        context.close();
    }

    @Bean(name = "number")
    @Profile("odd")
    public Integer odd() {
        return 1;
    }

    @Bean(name = "number")
//    @Profile("even")
    @Conditional(EventProfileCondition.class)
    public Integer even() {
        return 2;
    }
}

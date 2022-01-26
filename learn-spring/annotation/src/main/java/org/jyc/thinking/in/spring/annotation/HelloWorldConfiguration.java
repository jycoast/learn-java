package org.jyc.thinking.in.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * helloworld 配置类
 *
 * @author jiyongchao
 */
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String helloWorld() {
        return "HelloWorld";
    }
}

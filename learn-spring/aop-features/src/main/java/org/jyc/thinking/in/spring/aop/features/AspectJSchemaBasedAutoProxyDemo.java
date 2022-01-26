package org.jyc.thinking.in.spring.aop.features;

import org.jyc.thinking.in.spring.aop.overview.EchoService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于XML配置自动代理示例
 */
@Configuration
public class AspectJSchemaBasedAutoProxyDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/spring-aop-auto-proxy-context.xml");
        context.refresh();
        EchoService echoService = context.getBean(EchoService.class);
        System.out.println(echoService.echo("hello world"));
        context.close();
    }
}

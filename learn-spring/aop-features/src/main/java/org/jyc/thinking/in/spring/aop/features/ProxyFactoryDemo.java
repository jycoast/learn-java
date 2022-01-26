package org.jyc.thinking.in.spring.aop.features;

import org.jyc.thinking.in.spring.aop.features.interceptor.EchoServiceMethodInterceptor;
import org.jyc.thinking.in.spring.aop.overview.DefaultEchoService;
import org.jyc.thinking.in.spring.aop.overview.EchoService;
import org.springframework.aop.framework.ProxyFactory;

/**
 * {@link org.springframework.aop.framework.ProxyFactory} 示例
 */
public class ProxyFactoryDemo {
    public static void main(String[] args) {
        DefaultEchoService defaultEchoService = new DefaultEchoService();
        // 注入目标对象（被代理）
        ProxyFactory proxyFactory = new ProxyFactory(defaultEchoService);
        // 如果对象存在接口的话，生成的代理对象还是JDK动态代理的
        proxyFactory.setTarget(DefaultEchoService.class);
        // 添加Advice
        proxyFactory.addAdvice(new EchoServiceMethodInterceptor());
        // 获取代理对象
        EchoService echoService = (EchoService)proxyFactory.getProxy();
        System.out.println(echoService.echo("hello world"));
    }
}

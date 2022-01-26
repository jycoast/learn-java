package org.jyc.thinking.in.spring.aop.features;

import org.jyc.thinking.in.spring.aop.features.interceptor.EchoServiceMethodInterceptor;
import org.jyc.thinking.in.spring.aop.features.pointcut.EchoServiceEchoMethodPointcut;
import org.jyc.thinking.in.spring.aop.features.pointcut.EchoServicePointcut;
import org.jyc.thinking.in.spring.aop.overview.DefaultEchoService;
import org.jyc.thinking.in.spring.aop.overview.EchoService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * pointcut API使用示例
 */
public class PointcutApiDemo {
    public static void main(String[] args) {
        EchoServicePointcut echoServicePointcut = new EchoServicePointcut("echo", EchoService.class);
        ComposablePointcut pointcut = new ComposablePointcut(EchoServiceEchoMethodPointcut.INSTANCE);
        // 组合实现
        pointcut.intersection(echoServicePointcut.getClassFilter());
        pointcut.intersection(echoServicePointcut.getMethodMatcher());
        // 将Pointcut适配成Advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new EchoServiceMethodInterceptor());
        DefaultEchoService defaultEchoService = new DefaultEchoService();
        ProxyFactory proxyFactory = new ProxyFactory(defaultEchoService);
        // 添加Advisor
        proxyFactory.addAdvisor(advisor);
        EchoService echoService = (EchoService) proxyFactory.getProxy();
        System.out.println(echoService.echo("hello world"));
    }
}

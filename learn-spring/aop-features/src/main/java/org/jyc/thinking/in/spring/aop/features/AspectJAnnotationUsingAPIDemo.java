package org.jyc.thinking.in.spring.aop.features;

import org.jyc.thinking.in.spring.aop.features.aspect.AspectConfiguration;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * AspectJ API示例
 */
public class AspectJAnnotationUsingAPIDemo {
    public static void main(String[] args) {
        // 通过创建一个HashMap的缓存
        Map<String, Object> cache = new HashMap<>();
        // 创建proxy
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        // 增加Aspect 配置类
        proxyFactory.addAspect(AspectConfiguration.class);

        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                if ("put".equals(method.getName()) && args.length == 2) {
                    System.out.printf("[MethodBeforeAdvice]当前存放是key：%s，value：%s \n", args[0], args[1]);
                }
            }
        });

        proxyFactory.addAdvice(new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                if ("put".equals(method.getName()) && args.length == 2) {
                    System.out.printf("[AfterReturningAdvice]当前存放是key：%s，新存放的value：%s \n,之前关联的Value：%s",
                            args[0], // key
                            args[1], // new value
                            returnValue // old value
                    );
                }
            }
        });
        // 直接存储
//        cache.put("1", "A");
        // 通过代理对象存储
        Map<String, Object> proxy = proxyFactory.getProxy();
        proxy.put("1", "A");
        System.out.println(cache.get("1"));
    }
}

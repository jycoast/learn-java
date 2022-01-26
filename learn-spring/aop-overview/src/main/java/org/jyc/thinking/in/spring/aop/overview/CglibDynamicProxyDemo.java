package org.jyc.thinking.in.spring.aop.overview;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB动态代理示例
 */
public class CglibDynamicProxyDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        // 指定super Class = DefaultEchoService.class
        Class<DefaultEchoService> superClass = DefaultEchoService.class;
        enhancer.setSuperclass(superClass);
        // 指定拦截接口
        enhancer.setInterfaces(new Class[]{EchoService.class});
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object source, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                long startTime = System.currentTimeMillis();
                // Source -> CGLIB子类
                // 目标类 -> DefaultEchoService
                // 错误使用
//                Object result = method.invoke(source, args);
                Object result = methodProxy.invokeSuper(source, args);
                long costTime = System.currentTimeMillis() - startTime;
                System.out.println("[CGLIB字节码提升]echo方法执行时间: " + costTime);
                return result;
            }
        });
        // 创建代理对象
        EchoService echoService = (EchoService)enhancer.create();
        // 输出结果
        System.out.println(echoService.echo("hello world"));
    }
}

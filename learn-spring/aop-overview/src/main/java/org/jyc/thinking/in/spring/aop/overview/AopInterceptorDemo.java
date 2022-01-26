package org.jyc.thinking.in.spring.aop.overview;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * AOP 拦截示例
 */
public class AopInterceptorDemo {
    public static void main(String[] args2) {
        // 前置模式 + 后置模式
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Object proxy2 = Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, (proxy, method, args) -> {
            if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
                // 前置拦截器
                BeforeInterceptor beforeInterceptor = new BeforeInterceptor() {
                    @Override
                    public Object before(Object proxy, Method method, Object[] args) {
                        return System.currentTimeMillis();
                    }
                };
                Long startTime = 0L;
                Long endTime = 0L;
                Object result = null;
                try {
                    // 前置拦截
                    startTime = (Long) beforeInterceptor.before(proxy, method, args);
                    EchoService echoService = new DefaultEchoService();
                    result = echoService.echo((String) args[0]);
                    // 方法执行后置拦截器
                    AfterReturnInterceptor afterReturnInterceptor = new AfterReturnInterceptor() {
                        @Override
                        public Object after(Object proxy, Method method, Object[] args, Object returnResult) {
                            return System.currentTimeMillis();
                        }
                    };
                    endTime = (Long) afterReturnInterceptor.after(proxy, method, args, result);
                } catch (Exception e) {
                    // 异常拦截器
                    ExceptionInterceptor exceptionInterceptor = new ExceptionInterceptor() {
                        @Override
                        public void intercpt(Object proxy, Method method, Object[] args, Throwable throwable) {
                            // ...
                        }
                    };
                } finally {
                    // finally 后置拦截器
                    FinallyInterceptor finallyInterceptor = new TimeFinallyInterceptor(startTime, endTime);
                    Long costTime = (Long) finallyInterceptor.finalize(proxy, method, args, result);
                    System.out.println("echo方法执行时间: " + costTime);
                }
            }
            return null;
        });
        EchoService echoService = (EchoService) proxy2;
        echoService.echo("hello world");
    }
}

class TimeFinallyInterceptor implements FinallyInterceptor {

    private Long startTime;

    private Long endTime;

    public TimeFinallyInterceptor(Long startTime, Long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public Object finalize(Object proxy, Method method, Object[] args, Object returnResult) {
        return endTime - startTime;
    }
}
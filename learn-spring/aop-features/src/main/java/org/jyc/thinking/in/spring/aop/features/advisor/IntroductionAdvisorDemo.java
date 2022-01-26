package org.jyc.thinking.in.spring.aop.features.advisor;

import org.jyc.thinking.in.spring.aop.overview.EchoService;
import org.springframework.aop.IntroductionInfo;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * {@link org.springframework.aop.IntroductionAdvisor} 示例
 */
public class IntroductionAdvisorDemo implements EchoService, Comparable {
    public static void main(String[] args) {
        IntroductionAdvisorDemo target = new IntroductionAdvisorDemo();
        // 使用该都构造器会使得IntroductionInfo失效
        // ProxyFactory proxyFactory = new ProxyFactory(target);
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        // 添加Advisor
        proxyFactory.addAdvisor(new DefaultIntroductionAdvisor(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("BeforeAdvice: " + method);
            }
        }, new IntroductionInfo() {
            @Override
            public Class<?>[] getInterfaces() {
                return new Class[]{EchoService.class, Map.class};
            }
        }));

        Object proxy = proxyFactory.getProxy();
        EchoService echoService = (EchoService) proxy;
        echoService.echo("hello world");

        Map map = (Map)proxy;
        map.put("1","A");

        // 如果IntroductionInfo#getInterfaces未传入Comparable,这里会无法转换
        Comparable comparable = (Comparable) proxy;
        comparable.compareTo(null);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String echo(String message) throws NullPointerException {
        return "IntroductionAdvisorDemo: " + message;
    }
}

package org.jyc.thinking.in.spring.aop.features.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;

/**
 * Aspect配置类
 */
@Aspect
public class AspectConfiguration2 implements Ordered {

    @Pointcut("execution(public * *(..))")
    private void anyPublicMethod() {
    }

    @Before("anyPublicMethod()") // Join Point拦截动作
    public void beforeAnyPublicMethod2() {
        System.out.println("@Before any public method.(2)");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

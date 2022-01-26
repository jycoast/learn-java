package org.jyc.thinking.in.spring.aop.features.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * Aspect配置类
 */
@Aspect
@Order
public class AspectConfiguration {

    @Pointcut("execution(public * *(..))")  // 匹配Join Point
    private void anyPublicMethod() { // 方法名即Pointcut名称
        System.out.println("@Pointcut at any public method");
    }

    @Around("anyPublicMethod()")
    public Object aroundAnyPublicMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("@Around any public method.");
        return pjp.proceed();
    }

    @Before("anyPublicMethod()") // Join Point拦截动作
    public void beforeAnyPublicMethod() {
        System.out.println("@Before any public method.");
    }

    @After("anyPublicMethod()")
    public void finalizeAnyPublicMethod() {
        System.out.println("@After any public method.");
    }

    @AfterReturning("anyPublicMethod()")
    public void afterAnyPublicMethod() {
        System.out.println("@AfterReturning any public method.");
    }

    @AfterThrowing("anyPublicMethod()")
    public void afterThrowingAnyPublicMethod() {
        System.out.println("@AfterThrowing any public method.");
    }
}

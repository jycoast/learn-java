package org.jyc.thinking.in.spring.aop.features;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyThrowsAdvice implements ThrowsAdvice {
    // 方法名称必须为afterThrowing
    public void afterThrowing(RuntimeException e) {
        System.out.printf("Exception: %S/n", e);
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
        System.out.printf("method : %s,args: %s,Exception: %S/n",
                method,
                Arrays.asList(args),
                target,
                e);
    }
}

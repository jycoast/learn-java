package org.jyc.thinking.in.spring.aop.features.event;

/**
 * AOP执行器
 */
public class Executor { // ClassFilter
    public void execute() { // MethodMatcher：Join Point方法（需要Pointcut来匹配）
        System.out.println("Executor Executing...");
    }
}

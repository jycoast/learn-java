package org.jyc.thinking.in.spring.aop.features;

import org.springframework.aop.framework.ProxyFactory;

import java.util.Random;

public class ThrowsAdviceDemo {
    public static void main(String[] args) {
        ThrowsAdviceDemo instance = new ThrowsAdviceDemo();
        ProxyFactory proxyFactory = new ProxyFactory(instance);
        proxyFactory.addAdvice(new MyThrowsAdvice());
        ThrowsAdviceDemo proxy = (ThrowsAdviceDemo) proxyFactory.getProxy();
        proxy.execute();
        proxy.execute();
    }

    public void execute() {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new RuntimeException("For Purpose");
        }
        System.out.println("Executing...");
    }
}

package org.jyc.thinking.in.spring.bean.definition;

import org.jyc.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bena垃圾回收的示例
 */
public class BeanGarbageCollectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);
        applicationContext.refresh();
        applicationContext.close();
        System.out.println("Spring 应用上下文已关闭");
        // 强制触发GC
        System.gc();
    }
}

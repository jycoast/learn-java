package org.jyc.thinking.in.spring.lifecycle;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.Lifecycle;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author 自定义 {@link org.springframework.context.Lifecycle} Bean示例
 */
public class LifecycleDemo {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        // 注册MyLifecycle成为一个Spring Bean
        context.registerBeanDefinition("myLifecycle", BeanDefinitionBuilder.rootBeanDefinition(MyLifecycle.class).getBeanDefinition());
        context.refresh();
        // 启动应用上下文
        context.start();
        // 关闭Spring应用
        context.stop();
        context.close();
    }
}

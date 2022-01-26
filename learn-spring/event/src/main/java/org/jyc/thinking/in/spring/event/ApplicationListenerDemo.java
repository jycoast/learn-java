package org.jyc.thinking.in.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.sql.SQLOutput;

/**
 * {@link org.springframework.context.ApplicationListener} 示例
 *
 * @author jiyongchao
 */
@EnableAsync
public class ApplicationListenerDemo implements ApplicationEventPublisherAware {
    public static void main(String[] args) {
//        GenericApplicationContext context = new GenericApplicationContext();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 将引导类作为配置类
        context.register(ApplicationListenerDemo.class);
        // 方法一：基于Spring接口：向Spring应用上下文注册事件
        // a方法：基于ConfigApplicationContext API实现
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                println("ApplicationListene接收到Spring事件： " + event);
            }
        });
        // b.方法：基于ApplicationListener注册为Spring Bean
        context.register(MyApplicationListener.class);
        // 方法二：基于Spring注解@EventListener
        context.refresh();
        context.start();
        context.stop();
        context.close();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent(new ApplicationEvent("hello world") {
        });
        applicationEventPublisher.publishEvent("hello world");
    }

    static class MyApplicationListener implements ApplicationListener {
        @Override
        public void onApplicationEvent(ApplicationEvent event) {
            println("MyApplicationListener接收到Spring事件");
        }
    }

    @EventListener
    @Order(1)
    public void onApplicationEvent(ContextRefreshedEvent event) {
        println("@EventListener1接收到Spring事件");
    }

    @EventListener
    @Order(2)
    public void onApplicationEvent1(ContextRefreshedEvent event) {
        println("@EventListener2接收到Spring事件");
    }

    @EventListener
    @Async
    public void onApplicationEvent(ContextStartedEvent event) {
        println("@EventListener接收到Spring事件（异步）");
    }

    @EventListener
    public void onApplicationEvent(ContextClosedEvent event) {
        println("@EventListener接收到Spring事件");
    }

    private static void println(Object printable) {
        System.out.printf("[线程：%s] : %s\n", Thread.currentThread(), printable);
    }
}
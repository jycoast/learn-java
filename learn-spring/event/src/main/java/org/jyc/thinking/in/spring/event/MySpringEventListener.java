package org.jyc.thinking.in.spring.event;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationListener;

/**
 * 自定义Spring事件监听器
 *
 * @author jiyongchao
 */
public class MySpringEventListener implements ApplicationListener<MySpringEvent> {
    @Override
    public void onApplicationEvent(MySpringEvent event) {
        System.out.printf("[线程：%s] :监听到事件 %s\n", Thread.currentThread().getName(), event);
    }
}

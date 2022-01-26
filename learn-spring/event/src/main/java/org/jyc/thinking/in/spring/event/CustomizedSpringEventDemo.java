package org.jyc.thinking.in.spring.event;

import org.springframework.context.support.GenericApplicationContext;

/**
 * 自定义Spring事件示例
 *
 * @author jiyongchao
 */
public class CustomizedSpringEventDemo {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        context.addApplicationListener(new MySpringEventListener());

        context.refresh();

        context.publishEvent(new MySpringEvent("hello,world"));

        context.close();
    }
}

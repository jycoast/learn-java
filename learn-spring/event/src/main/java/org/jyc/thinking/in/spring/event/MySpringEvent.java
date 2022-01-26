package org.jyc.thinking.in.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义Spring事件
 *
 * @author jiyongchao
 */
public class MySpringEvent extends ApplicationEvent {

    public MySpringEvent(String message) {
        super(message);
    }

    @Override
    public Object getSource() {
        return (String) super.getSource();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

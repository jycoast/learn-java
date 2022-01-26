package org.jyc.thinking.in.spring.aop.features.event;

import org.springframework.context.ApplicationEvent;

public class ExecutedEvent extends ApplicationEvent {
    public ExecutedEvent(Object source) {
        super(source);
    }
}

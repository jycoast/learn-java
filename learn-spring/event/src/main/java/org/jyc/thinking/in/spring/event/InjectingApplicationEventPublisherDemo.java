package org.jyc.thinking.in.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @author jiyongchao
 */
public class InjectingApplicationEventPublisherDemo implements ApplicationEventPublisherAware {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        // #3
        applicationEventPublisher.publishEvent(new MySpringEvent("the event from @Autowired ApplicationEventPublisher"));
        // #4
        applicationContext.publishEvent(new MySpringEvent("the event from @Autowired ApplicationContext"));
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(InjectingApplicationEventPublisherDemo.class);

        context.addApplicationListener(new MySpringEventListener());

        context.refresh();

        context.close();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent(new MySpringEvent("the event from ApplicationEventPublisher")); //#1
    }

    public void setApplicationContext(ApplicationContext applicationContext) { //#2
        applicationEventPublisher.publishEvent("the event from ApplicationContext");
    }
}

package org.jyc.thinking.in.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 层次性Spring事件传播实现
 *
 * @author jiyongchao
 */
public class HierarchicalSpringEventPropagateDemo {
    public static void main(String[] args) {
        // 1.创建parent Spring应用上下文
        AnnotationConfigApplicationContext parentContent = new AnnotationConfigApplicationContext();
        // 2.创建current Spring应用上下文
        parentContent.setId("parent-context");
        parentContent.register(MyListener.class);

        // 3.current -> parent
        AnnotationConfigApplicationContext currentContent = new AnnotationConfigApplicationContext();
        parentContent.setId("current-context");
        currentContent.setParent(parentContent);
        currentContent.register(MyListener.class);

        parentContent.refresh();
        // 这里会触发两次，因为会出发父应用上下文的事件
        currentContent.refresh();

        // 注意这里的顺序，不能颠倒
        currentContent.close();
        parentContent.close();
    }

    static class MyListener implements ApplicationListener<ApplicationContextEvent> {
        // 这里必须是静态字段
        private static Set<ApplicationEvent> processedEvents = new LinkedHashSet<>();

        @Override
        public void onApplicationEvent(ApplicationContextEvent event) {
            if (processedEvents.add(event)) {
                System.out.printf("监听到 Spring应用上下文[ID：%s]事件： %s\n", event.getApplicationContext().getId(), event.getClass().getSimpleName());
            }
        }
    }
}

package org.jyc.thinking.in.spring.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author jiyonghcoa
 * @Value示例
 */
public class ValueAnnotationDemo {

    @Value("${user.name}")
    private String userName;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ValueAnnotationDemo.class);

        context.refresh();

        ValueAnnotationDemo bean = context.getBean(ValueAnnotationDemo.class);

        System.out.println(bean.userName);

        context.close();
    }
}

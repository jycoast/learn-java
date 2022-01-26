package org.jyc.thinking.in.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * {@link org.springframework.context.annotation.ComponentScan} 示例
 *
 * @author jiyongchao
 */
@ComponentScan(basePackages = "org.jyc.thinking.in.spring.annotation")
// @MyComponentScan(scanBasePackages = "org.jyc.thinking.in.spring.annotation")
public class ComponentScanDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ComponentScanDemo.class);

        context.refresh();
        // 从Spring 4.0开始支持多层次@Component派生
        TestClass bean = context.getBean(TestClass.class);
        System.out.println(bean);
        context.close();
    }
}
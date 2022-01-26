package org.jyc.thinking.in.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * Enable模块驱动示例
 *
 * @author jiyongchao
 */
@EnableHelloWorld
public class EnableModuleDemo { // 第一步：通过@Enable**命名
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(EnableModuleDemo.class);

        context.refresh();

        String bean = context.getBean("helloWorld", String.class);
        System.out.println(bean);
        context.close();
    }
}

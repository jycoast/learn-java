package org.jyc.thinking.in.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 属性覆盖
 *
 * @author jiyongchao
 */
@MyComponentScan2(packages = "org.jyc.thinking.in.spring.annotation")
// 在@MyComponentScan2.scanBasePackages <- @MyComponentScan.scanBasePackages 属性覆盖
public class AttributeOverridesDemo {
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

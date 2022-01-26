package org.jyc.thinking.in.spring.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.LiveBeansView;

/**
 * {@link org.springframework.context.support.LiveBeansView} 示例
 *
 * @author jiyongchao
 */
public class LiveBeansViewDemo {
    public static void main(String[] args) throws Exception{
        // 添加LiveBeansView的ObjectName的domain
        System.setProperty(LiveBeansView.MBEAN_DOMAIN_PROPERTY_NAME, "org.jyc.thinking.in.spring");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(LiveBeansViewDemo.class);

        context.refresh();
        System.out.println("按任意键继续");
        System.in.read();
        context.close();
    }
}

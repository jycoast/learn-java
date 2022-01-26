package org.jyc.thinking.in.spring.environment;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖注入{@link org.springframework.core.env.Environment}示例
 *
 * @author jiyongchao
 */
public class InjectingEnvironmentDemo implements EnvironmentAware, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Environment environment;

    @Autowired
    private Environment environment2;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(InjectingEnvironmentDemo.class);

        context.refresh();

        InjectingEnvironmentDemo injectingEnvironmentDemo = context.getBean(InjectingEnvironmentDemo.class);

        System.out.println(injectingEnvironmentDemo.environment);

        System.out.println(injectingEnvironmentDemo.environment == injectingEnvironmentDemo.environment2);

        System.out.println(context == injectingEnvironmentDemo.applicationContext);

        System.out.println(injectingEnvironmentDemo.environment == context.getEnvironment());


        context.close();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

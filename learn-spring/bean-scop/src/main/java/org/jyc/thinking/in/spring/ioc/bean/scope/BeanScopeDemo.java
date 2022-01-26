package org.jyc.thinking.in.spring.ioc.bean.scope;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Bean的作用域示例
 */
public class BeanScopeDemo implements DisposableBean {

    @Bean
    // 默认的scop就是“singleton”
    public static User singletonUser() {
        return createUser();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static User prototypeUser() {
        return createUser();
    }

    private static User createUser() {
        User user = new User();
        user.setId(String.valueOf(System.nanoTime()));
        return user;
    }

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser;

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser2;

    @Autowired
    private Map<String, User> users;

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    private static void scopedBeansByInjection(AnnotationConfigApplicationContext applicationContext) {
        BeanScopeDemo beanScopeDemo = applicationContext.getBean(BeanScopeDemo.class);
        System.out.println("beanScopeDemo.singletonUser = " + beanScopeDemo.singletonUser);
        System.out.println("beanScopeDemo.singletonUser1 = " + beanScopeDemo.singletonUser1);
        System.out.println("beanScopeDemo.prototypeUser1 = " + beanScopeDemo.prototypeUser);
        System.out.println("beanScopeDemo.prototypeUser2 = " + beanScopeDemo.prototypeUser1);
        System.out.println("beanScopeDemo.prototypeUser3 = " + beanScopeDemo.prototypeUser2);
        System.out.println("beanScopeDemo.users = " + beanScopeDemo.users);
    }

    private static void scopedBeansByLookup(AnnotationConfigApplicationContext applicationContext) {
        for (int i = 0; i < 3; i++) {
            User singletonUser = applicationContext.getBean("singletonUser", User.class);
            // singletonUser是共享的Bean对象
            System.out.println("singletonUser = " + singletonUser.getId());
            // prototypeUser是每次依赖查找都会生成新的Bean对象
            User prototypeUser = applicationContext.getBean("prototypeUser", User.class);
            System.out.println("prototypeUser = " + prototypeUser.getId());

        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanScopeDemo.class);
        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
                @Override
                public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                    System.out.printf("%s Bean名称: %s 在初始化后回调...%n", bean.getClass().getName(), beanName);
                    return bean;
                }
            });
        });
        applicationContext.refresh();
        // 结论一：
        // singleton Bean无论依赖查找还是依赖注入均为同一个对象
        // prototype Bean无论依赖查找还是依赖注入均为新生成的对象
        // 结论二：
        // 如果依赖注入集合类型的对象，singleton Bean和prototype Bean均会存在一个
        // prototype Bean有别于其他地方的依赖注入
        // 结论三：
        // 无论是Singleton还是Prototype Bean 均会执行初始化方法回调
        // 不过Singleton Bean会执行销毁方法回调
        scopedBeansByLookup(applicationContext);
        scopedBeansByInjection(applicationContext);
        applicationContext.close();
    }

    @Override
    public void destroy() {
        System.out.println("当前BeanScopeDemo Bean 正在销毁中");
        this.prototypeUser.destory();
        this.prototypeUser1.destory();
        this.prototypeUser2.destory();
        for (Map.Entry<String, User> entry : this.users.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            if (beanDefinition.isPrototype()) {
                User user = entry.getValue();
                user.destory();
            }
        }
        System.out.println("当前BeanScopeDemo Bean 销毁已完成...");
    }
}

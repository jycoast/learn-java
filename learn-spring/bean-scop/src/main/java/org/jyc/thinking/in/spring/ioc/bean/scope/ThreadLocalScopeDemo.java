package org.jyc.thinking.in.spring.ioc.bean.scope;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * 自定义Scope示例
 *
 * @author jiyongchao
 */
public class ThreadLocalScopeDemo {
    @Bean
    @Scope(ThreadLocalScope.SCOP_NAME)
    public User user() {
        return createUser();
    }

    private static User createUser() {
        User user = new User();
        user.setId(String.valueOf(System.nanoTime()));
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ThreadLocalScopeDemo.class);
        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
                    beanFactory.registerScope(ThreadLocalScope.SCOP_NAME, new ThreadLocalScope());
                }
        );
        applicationContext.refresh();
        scopedBeansByLookup(applicationContext);
        applicationContext.close();
    }

    private static void scopedBeansByInjection(AnnotationConfigApplicationContext applicationContext) {

    }

    private static void scopedBeansByLookup(AnnotationConfigApplicationContext applicationContext) {
        // 单个线程下，返回的永远是同一个Bean
//        for (int i = 0; i < 3; i++) {
//            User user = applicationContext.getBean("user", User.class);
//            System.out.println("user = " + user.getId());
//        }
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                User user = applicationContext.getBean("user", User.class);
                System.out.printf("[Thread id: %d] user = %s%n", Thread.currentThread().getId(), user);
            });
            thread.start();
            // 强制线程执行完成
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

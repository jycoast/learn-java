package org.jyc.thinking.in.spring.bean.lifecycle;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class UserHolder implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, EnvironmentAware, InitializingBean, SmartInitializingSingleton, DisposableBean {

    private final User user;

    private Integer number;

    private String description;

    private ClassLoader classLoader;

    private BeanFactory beanFactory;

    private String beanName;

    private Environment environment;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public Integer getNumber() {
        return number;
    }

    /**
     * 依赖于注解驱动，当前场景：BeanFactory，因此直接运行，并不会执行
     */
    @PostConstruct
    public void initPostConstruct() {
        this.description = "The user holder V4";
        System.out.println("initPostConstruct() = " + description);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.description = "The user holder V5";
        System.out.println("afterPropertiesSet() = " + description);
    }

    public void init() {
        this.description = "The user holder V6";
        System.out.println("init() = " + description);
    }

    @Override
    public void afterSingletonsInstantiated() {
        this.description = "The user holder V8";
        System.out.println("afterSingletonsInstantiated() = " + description);

    }

    @PreDestroy
    public void preDestory() {
        this.description = "The user holder V10";
        System.out.println("PreDestroy() = " + description);
    }

    @Override
    public void destroy() throws Exception {
        this.description = "The user holder V11";
        System.out.println("PreDestroy() = " + description);
    }

    public void doDestory() {
        this.description = "The user holder V12";
        System.out.println("PreDestroy() = " + description);
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                ", number=" + number +
                ", description='" + description + '\'' +
                ", classLoader=" + classLoader +
                ", beanFactory=" + beanFactory +
                ", beanName='" + beanName + '\'' +
                ", environment=" + environment +
                '}';
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    public UserHolder(User user) {
        this.user = user;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("UserHolder is finalized ...");
        super.finalize();
    }
}

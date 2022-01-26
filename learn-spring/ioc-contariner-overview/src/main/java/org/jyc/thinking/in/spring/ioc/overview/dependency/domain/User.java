package org.jyc.thinking.in.spring.ioc.overview.dependency.domain;

import org.jyc.thinking.in.spring.ioc.overview.dependency.City;
import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;

/**
 * 用户类
 */
public class User implements BeanNameAware {
    private String id;

    private String name;

    private transient String beanName;

    private City city;

    private Company company;

    public Company getCompany() {
        return company;
    }

    private Properties context;

    private String contextAsText;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", beanName='" + beanName + '\'' +
                ", city=" + city +
                ", company=" + company +
                ", context=" + context +
                ", contextAsText='" + contextAsText + '\'' +
                '}';
    }

    public String getContextAsText() {
        return contextAsText;
    }

    public void setContextAsText(String contextAsText) {
        this.contextAsText = contextAsText;
    }

    public Properties getContext() {
        return context;
    }

    public void setContext(Properties context) {
        this.context = context;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static User createUser() {
        User user = new User();
        user.setName("createUser");
        user.setId("123");
        return user;
    }

    @PostConstruct
    public void init() {
        System.out.println("User Bean [" + beanName + "]初始化...");
    }

    @PreDestroy
    public void destory() {
        System.out.println("User Bean [" + beanName + "]销毁化...");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}

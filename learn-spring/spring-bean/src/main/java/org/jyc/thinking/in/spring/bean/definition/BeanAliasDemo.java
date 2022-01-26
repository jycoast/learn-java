package org.jyc.thinking.in.spring.bean.definition;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean别名示例
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-definitions-context.xml");
        lookupByAliases(beanFactory);
    }

    /**
     * 按照类型查找
     * @param beanFactory
     */
    private static void lookupByAliases(BeanFactory beanFactory) {
        User user = beanFactory.getBean("user", User.class);
        User userAliases = beanFactory.getBean("jiyongchao-user", User.class);
        System.out.println("===========按照别名查找==========");
        System.out.println(userAliases == user);
    }
}
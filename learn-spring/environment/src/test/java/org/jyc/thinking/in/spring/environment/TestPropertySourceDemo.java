package org.jyc.thinking.in.spring.environment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

/**
 * {@link org.springframework.test.context.TestPropertySource}示例
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestPropertySourceDemo.class) //Spring 注解驱动测试注解
@TestPropertySource(properties = "user.name=吉永超")  // PropertySource(name=Inlined Test Properties)
public class TestPropertySourceDemo {
    @Value("${user.name}")
    private String userName;

    @Autowired
    private ConfigurableEnvironment environment;

    @Test
    public void testUserName() {
        System.out.println(new TestPropertySourceDemo().userName);
        for (PropertySource ps : environment.getPropertySources()) {
            System.out.printf("PropertySource(name=s%),user.name属性=%s\n", ps.getName(), ps.getProperty("user.name"));
        }
    }
}

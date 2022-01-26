package org.jyc.thinking.in.spring.validation;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * JavaBeans 示例
 *
 * @author ecidi
 */
public class JavaBeansDemo {
    public static void main(String[] args) throws Exception {
        // stopClass排除（截止）类
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);

        // 属性描述符 PropertyDescriptor
        // 所有的Java类均继承 java.lang.Object方法
        // Class属性来自于Object#getClass() 方法
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            propertyDescriptor.getReadMethod(); // Getter方法
            propertyDescriptor.getWriteMethod(); // Setter方法
            System.out.println(propertyDescriptor);
        });
        // 输出User定义的方法 MethodDescriptor
        Stream.of(beanInfo.getMethodDescriptors()).forEach(System.out::println);
    }
}

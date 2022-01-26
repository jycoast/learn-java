package org.jyc.thinking.in.spring.bean.metadata;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


public class UsersNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        // 将"user"元素注册对应的BeanDefinitionParser实现
        registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
    }
}

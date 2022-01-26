package org.jyc.thinking.in.spring.bean.lifecycle;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.SuperUser;
import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("SuperUser", beanName) && SuperUser.class.equals(beanClass)) {
            // 把配置好的SuperUser Bean覆盖
            return new SuperUser();
        }
        return null; // 保持Spring IoC容器的实例化操作
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())) {
            User user = (User) bean;
            user.setId("33");
            user.setName("jjjjjj");
            // "user"对象不允许属性赋值（填入）（配置元信息 -> 属性值）
            return false;
        }
        return true;
    }

    // 要注意如果postProcessAfterInstantiation返回的是false的话，这个方法不会被调用，因为相当于返回的Bean已经被替换了。
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {
        if (ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())) {
            // 假设<property name="number" value="1" />配置的话，那么在PropertyValues中就包含一个PropertyValues(number=1)
            final MutablePropertyValues propertyValues;
            if (pvs instanceof MutablePropertyValues) {
                propertyValues = (MutablePropertyValues) pvs;
            } else {
                propertyValues = new MutablePropertyValues();
            }
            // 等价于<property name="number" value="1" />
            propertyValues.addPropertyValue("number", "1");
            //
            if (propertyValues.contains("description")) {
                // PropertyValue是不可变的
//                    PropertyValue description = propertyValues.getPropertyValue("description");
                propertyValues.removePropertyValue("description");
                propertyValues.addPropertyValue("description", "The user holder V2");
            }
            return propertyValues;
        }
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())) {
            UserHolder userHolder = (UserHolder) bean;
            userHolder.setDescription("The user holder V3");
            return userHolder;
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())) {
            UserHolder userHolder = (UserHolder) bean;
            userHolder.setDescription("The user holder V7");
            return userHolder;
        }
        return null;
    }
}

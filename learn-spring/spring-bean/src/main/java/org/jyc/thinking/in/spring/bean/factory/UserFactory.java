package org.jyc.thinking.in.spring.bean.factory;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;

/**
 * User工厂类
 */
public interface UserFactory {
    default User createUser() {
        return User.createUser();
    }
}

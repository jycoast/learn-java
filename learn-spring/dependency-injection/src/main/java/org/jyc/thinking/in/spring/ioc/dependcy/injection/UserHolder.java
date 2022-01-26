package org.jyc.thinking.in.spring.ioc.dependcy.injection;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;

/**
 * {@link User} 的holder类
 */
public class UserHolder {

    public UserHolder() {

    }

    public UserHolder(User user) {
        this.user = user;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}

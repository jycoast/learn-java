package org.jyc.thinking.in.spring.ioc.overview.dependency.domain;

/**
 * 公司类
 */
public class Company {
    String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}

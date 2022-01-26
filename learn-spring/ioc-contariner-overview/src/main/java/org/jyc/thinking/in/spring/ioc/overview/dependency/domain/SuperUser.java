package org.jyc.thinking.in.spring.ioc.overview.dependency.domain;

/**
 * 超级用户
 */
@Super
public class SuperUser extends User{

    private String address;

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

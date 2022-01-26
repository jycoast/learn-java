package modules.FunctionalInterface;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/1/5 22:58
 * 4
 */
public class Person {
    private String username;

    private int age;

    public Person(String username,int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

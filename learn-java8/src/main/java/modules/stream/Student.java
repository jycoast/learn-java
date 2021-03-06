package modules.stream;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/9/14 22:54
 * 4
 */
public class Student {
    private String name;
    private int score;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }
}

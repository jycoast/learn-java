package modules.Stream2;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/9/15 22:52
 * 4
 */
public class Student {
    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
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
}

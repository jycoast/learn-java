package modules.lambda;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/8/24 23:28
 * 4
 */
public class StudentComparator {
    public int compareStudentByScore(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }

    public int compareStudentByName(Student student1, Student student2) {
        return student1.getName().compareToIgnoreCase(student2.getName());
    }
}

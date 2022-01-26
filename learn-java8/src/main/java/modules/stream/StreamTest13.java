package modules.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/9/14 22:56
 * 4
 */
public class StreamTest13 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);
//        Map<String, List<Student>> map = students.modules.stream().collect(Collectors.groupingBy(Student::getName));
//        System.out.println(map);
//        Map<Integer, List<Student>> map2 = students.modules.stream().collect(Collectors.groupingBy(Student::getScore));
        Map<String, Long> map3 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(map3);
        Map<String, Double> map4 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        System.out.println(map4);
        Map<Boolean, List<Student>> map5 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90));
        System.out.println(map5);
    }
}

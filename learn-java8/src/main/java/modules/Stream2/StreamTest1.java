package modules.Stream2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/9/15 22:54
 * 4
 */
public class StreamTest1 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);
//        List<Student> studentList = students.modules.stream().collect(Collectors.toList());
//        studentList.forEach(System.out::println);
//
//        System.out.println("count: " + students.modules.stream().collect(Collectors.counting()));
//        System.out.println("count: " + students.modules.stream().count());
        students.stream().collect(Collectors.minBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        students.stream().collect(Collectors.maxBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);

        System.out.println(students.stream().collect(Collectors.averagingInt(Student::getScore)));
        System.out.println(students.stream().collect(Collectors.summingInt(Student::getScore)));
        System.out.println(students.stream().collect(Collectors.summarizingInt(Student::getScore)));
        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining()));
        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining(",", "<begin>", "<end>")));
        students.stream().collect(Collectors.groupingBy(Student::getScore, Collectors.groupingBy(Student::getName)));
        students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 90, Collectors.
                partitioningBy(student -> student.getScore() > 80)));

        students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 80, Collectors.counting()));

        students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.collectingAndThen(Collectors.
                minBy(Comparator.comparingInt(Student::getScore)), Optional::get)));
    }
}

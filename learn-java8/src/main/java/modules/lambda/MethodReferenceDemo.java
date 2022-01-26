package modules.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/8/20 23:40
 * 4
 */
public class MethodReferenceDemo {

    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String str, Function<String, String> function) {
        return function.apply(str);
    }

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 10);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 50);
        Student student4 = new Student("zhaoliu", 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        students.sort((studentParam1, studentParam2) -> Student.compareStudentByScore(studentParam1, studentParam2));

        students.forEach(student -> System.out.println(student.getScore()));

        System.out.println("==================================");
        students.sort(Student::compareStudentByScore);
        students.forEach(student -> System.out.println(student.getScore()));

        System.out.println("==================================");
        StudentComparator studentComparator = new StudentComparator();
        students.sort((studentParam1, studentParam2) -> studentComparator.
                compareStudentByScore(studentParam1, studentParam2));
        students.forEach(student -> System.out.println(student.getScore()));

        System.out.println("==================================");

        students.sort(studentComparator::compareStudentByScore);
        students.forEach(student -> System.out.println(student.getScore()));

        System.out.println("==================================");

        students.sort((studentParam1, studentParam2) -> studentComparator.
                compareStudentByName(studentParam1, studentParam2));
        students.forEach(student -> System.out.println(student.getScore()));

        System.out.println("==================================");

        students.sort(studentComparator::compareStudentByName);
        students.forEach(student -> System.out.println(student.getName()));

        students.sort(Student::compareByName);
        students.forEach(student -> System.out.println(student.getName()));

        List<String> cities = Arrays.asList("qingdao", "chongqing", "tianjin", "beijing");
        Collections.sort(cities, (city1, city2) -> city1.compareToIgnoreCase(city2));
        cities.forEach(city -> System.out.println(city));
        Collections.sort(cities, String::compareToIgnoreCase);
        cities.forEach(System.out::println);


        MethodReferenceDemo methodReferenceDemo = new MethodReferenceDemo();
        System.out.println(methodReferenceDemo.getString(String::new));
        System.out.println(methodReferenceDemo.getString2("hello", String::new));

    }
}

package modules.FunctionalInterface;

import java.util.function.Supplier;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/8/19 23:17
 * 4
 */
public class StudentTest {
    public static void main(String[] args) {
        Supplier<Student> supplier = () -> new Student();
        System.out.println(supplier.get().getName());
        System.out.println("--------------");

        Supplier<Student> supplier2 = Student::new;
        System.out.println(supplier2.get().getName());
    }
}

package modules.FunctionalInterface;

import java.util.function.Predicate;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/1/6 21:30
 * 4
 */
public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> predicate = p -> p.length() > 5;
        System.out.println(predicate.test("hello"));
    }
}

package modules.FunctionalInterface;

import java.util.Date;
import java.util.function.Predicate;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/1/6 23:16
 * 4
 */
public class PredicateTest3 {
    public static void main(String[] args) {
        PredicateTest3 predicateTest3 = new PredicateTest3();
        System.out.println(predicateTest3.isEqual("test").test(new Date()));
    }

    public Predicate<Date> isEqual(Object object) {
        return Predicate.isEqual(object);
    }
}

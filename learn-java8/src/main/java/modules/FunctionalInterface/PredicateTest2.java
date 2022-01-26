package modules.FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/1/6 21:46
 * 4
 */
public class PredicateTest2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        PredicateTest2 predicateTest2 = new PredicateTest2();
        // 找到集合中所有的偶数
        predicateTest2.conditionFilter(list, item -> item % 2 == 0);
        // 找到集合中所有的奇数
        predicateTest2.conditionFilter(list, item -> item % 2 != 0);
        // 找到集合中所有大于5的数
        predicateTest2.conditionFilter(list, item -> item > 5);
        // 找到集合中所有小于3的数
        predicateTest2.conditionFilter(list, item -> item < 3);
        // 找到集合中所有大于5并且是偶数的数
        predicateTest2.conditionFilter2(list, item -> item > 5, item -> item % 2 == 0);
        // 找到集合中所有大于5或者是偶数的数
        predicateTest2.conditionFilter3(list, item -> item > 5, item -> item % 2 == 0);

        predicateTest2.conditionFilter4(list, item -> item > 5, item -> item % 2 == 0);
    }

    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                System.out.println(integer);
            }
        }

    }

    public void conditionFilter2(List<Integer> list, Predicate<Integer> predicate,
                                 Predicate<Integer> predicate2) {
        for (Integer integer : list) {
            if (predicate.and(predicate2).test(integer)) {
                System.out.println(integer);
            }
        }
    }

    public void conditionFilter3(List<Integer> list, Predicate<Integer> predicate,
                                 Predicate<Integer> predicate2) {
        for (Integer integer : list) {
            if (predicate.or(predicate2).test(integer)) {
                System.out.println(integer);
            }
        }
    }

    public void conditionFilter4(List<Integer> list, Predicate<Integer> predicate,
                                 Predicate<Integer> predicate2) {
        for (Integer integer : list) {
            if (predicate.or(predicate2).negate().test(integer)) {
                System.out.println(integer);
            }
        }
    }
}

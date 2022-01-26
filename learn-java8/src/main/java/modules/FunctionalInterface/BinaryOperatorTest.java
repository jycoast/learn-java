package modules.FunctionalInterface;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/8/19 23:55
 * 4
 */
public class BinaryOperatorTest {
    public static void main(String[] args) {
        BinaryOperatorTest binaryOperatorTest = new BinaryOperatorTest();
        System.out.println(binaryOperatorTest.getShort("hellohello", "hello", (a, b) -> a.length() - b.length()));
        System.out.println(binaryOperatorTest.getShort("hellohello", "hello", (a, b) -> a.charAt(0) - b.charAt(0)));
    }

    public String getShort(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.minBy(comparator).apply(a, b);
    }
}

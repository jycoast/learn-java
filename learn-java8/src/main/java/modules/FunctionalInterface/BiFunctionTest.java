package modules.FunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/1/5 22:15
 * 4
 */
public class BiFunctionTest {
    public static void main(String[] args) {
        BiFunctionTest biFunctionTest = new BiFunctionTest();
        System.out.println(biFunctionTest.compute(1, 2, (value1, value2) -> value1 + value2, value -> value * value));
    }

    public int compute(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }
}

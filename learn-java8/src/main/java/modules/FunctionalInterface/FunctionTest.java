package modules.FunctionalInterface;

import java.util.function.Function;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/1/5 22:01
 * 4
 */
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        System.out.println(functionTest.compute(2, value -> value * 3, value -> value * value));
        System.out.println(functionTest.compute2(2, value -> value * 3, value -> value * value));
    }

    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }

}

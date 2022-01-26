package modules.lambda;

import java.util.function.Function;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/1/5 17:34
 * 4
 */
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        System.out.println(functionTest.compute(1, value -> 2 * value));
        System.out.println(functionTest.compute(2, value -> value * value));
        System.out.println(functionTest.compute(3, value -> 3 + value));

        System.out.println(functionTest.convert(5, value -> String.valueOf(value + "hello")));
    }

    public int compute(int a, Function<Integer, Integer> function) {
        int result = function.apply(a);
        return result;
    }

        public String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }

    public int method1(int a) {
        return 2 * a;
    }

    public int method2(int a) {
        return a * a;
    }

    public int method3(int a) {
        return 3 + a;
    }
}

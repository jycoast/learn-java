package modules.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2019/12/25 9:43
 * 4
 */
public class LambdaTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","hello world");

        list.forEach((String x) -> System.out.println(x));


    }
}
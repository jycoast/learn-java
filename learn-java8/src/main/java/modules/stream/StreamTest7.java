package modules.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/9/2 22:59
 * 4
 */
public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().map(item -> item.substring(0, 1).toUpperCase() + item.substring(1)).forEach(System.out::println);

        list.stream().map((item -> {
            String result = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println(result);
            return result;
        })).forEach(System.out::println);
    }
}

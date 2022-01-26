package modules.Stream2;

import java.util.Arrays;
import java.util.List;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/10/4 22:28
 * 4
 */
public class StreamTest3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().map(item -> item + "abc").forEach(System.out::println);
    }
}

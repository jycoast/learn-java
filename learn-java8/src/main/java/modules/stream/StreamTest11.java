package modules.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/9/8 23:37
 * 4
 */
public class StreamTest11 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");
        list.stream().map(item -> item.split(" ")).distinct().collect(Collectors.toList()).forEach(System.out::println);
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().
                collect(Collectors.toList()).forEach(System.out::println);
    }
}

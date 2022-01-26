package modules.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/9/14 22:40
 * 4
 */
public class StreamTest12 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");
        list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).
                collect(Collectors.toList()).forEach(System.out::println);
    }
}

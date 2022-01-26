package modules.Stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/10/4 21:50
 * 4
 */
public class StreamTest2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        NullPointerException nullPointerException = new NullPointerException("exception");
        try (Stream<String> stream = list.stream()) {
            stream.onClose(() -> {
                System.out.println("aaa");
                throw nullPointerException;
            }).onClose(() -> {
                System.out.println("bbb");
                throw nullPointerException;
            }).forEach(System.out::println);
        }
    }
}

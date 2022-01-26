package modules.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/8/26 22:53
 * 4
 */
public class StreamTest2 {
    public static void main(String[] args) {
        Stream.of(new int[]{5, 6, 7,}).forEach(System.out::println);
        IntStream.of(new int[]{5, 6, 7,}).forEach(System.out::println);

        System.out.println("=================================");
        IntStream.range(3, 8).forEach(System.out::println);
        IntStream.rangeClosed(3, 8).forEach(System.out::println);
    }
}

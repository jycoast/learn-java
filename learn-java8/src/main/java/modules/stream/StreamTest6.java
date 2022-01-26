package modules.stream;

import java.util.stream.Stream;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/9/1 23:03
 * 4
 */
public class StreamTest6 {
    public static void main(String[] args) {
//        Stream<String> modules.stream = Stream.generate(UUID.randomUUID()::toString);
//        modules.stream.findFirst().ifPresent(System.out::println);
        Stream<Integer> stream = Stream.iterate(1, item -> item + 2).limit(6);
//        IntSummaryStatistics intSummaryStatistics = modules.stream.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();
//        System.out.println(intSummaryStatistics.getMax());
//        System.out.println(intSummaryStatistics.getMin());
//        System.out.println(intSummaryStatistics.getSum());
        System.out.println(stream);
        System.out.println(stream.filter(item -> item > 2));
        System.out.println(stream.distinct());

        System.out.println(stream);
        Stream<Integer> stream2 = stream.filter(item -> item > 2);
        System.out.println(stream2);
        Stream<Integer> stream3 = stream2.distinct();
        System.out.println(stream3);

        Stream<Integer> distinct = stream.filter(item -> item > 2).distinct();
    }
}

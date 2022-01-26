package modules.Stream2;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/10/6 13:35
 * 4
 */
public class ConsumerTest {
    public void test(Consumer<Integer> consumer) {
        consumer.accept(100);
    }

    public static void main(String[] args) {
        ConsumerTest consumerTest = new ConsumerTest();
        // 两个相同的Lambda表达式
        Consumer<Integer> consumer = i -> System.out.println(i);
        IntConsumer intConsumer = i -> System.out.println(i);
        // 面向对象的方式
        consumerTest.test(consumer);
        // 编译通过但执行报错
        consumerTest.test((Consumer<Integer>) intConsumer);
        // 传递行为，函数式的方式
        consumerTest.test(consumer::accept);
        consumerTest.test(intConsumer::accept);
    }
}

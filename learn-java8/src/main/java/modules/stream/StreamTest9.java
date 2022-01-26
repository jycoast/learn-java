package modules.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/9/8 23:05
 * 4
 */
public class StreamTest9 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(50000000);
        for (int i = 0; i < list.size(); i++) {
            list.add(UUID.randomUUID().toString());
        }

        System.out.println("==================");
        long startTime = System.nanoTime();
        list.parallelStream().sorted().count();
        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("=======================");
        System.out.println(millis);
    }
}

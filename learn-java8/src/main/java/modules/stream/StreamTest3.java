package modules.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/8/26 23:17
 * 4
 */
public class StreamTest3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(list.stream().map(i -> 2 * i).reduce(0, Integer::sum));
    }
}

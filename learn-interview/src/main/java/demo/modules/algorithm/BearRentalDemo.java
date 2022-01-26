package demo.modules.algorithm;

import java.util.*;

/**
 * 小熊U租面试题
 */
public class BearRentalDemo {

    public static void main(String[] args) {
        System.out.println(BearRentalDemo.specificElement());
        System.out.println(BearRentalDemo.missingNumbers());
    }

    /**
     * 给定一个整数数组 nums，其中恰好有三个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那三个元素。 倒序排序。
     */
    private static List<Integer> specificElement() {
        int[] array = {7, 8, 3, 1, 3, 2, 1, 8, 6};
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value == 1) {
                res.add(entry.getKey());
            }
        }
        Collections.sort(res);
        Collections.reverse(res);
        return res;
    }

    /**
     * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
     */
    private static Integer missingNumbers() {
        int[] array = {7, 8, 3, 4, 2, 1, 5, 0};
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (i != array[i]) {
                return i;
            }
        }
        return 0;
    }
}
package demo.modules.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 找出数组中给定的第三大的元素
 */
public class ThirdBiggestNum {
    public static void main(String[] args) {
        int[] nums = {7, 8, 3, 4, 2, 1, 5, 0};
        // 通过删除最大和第二大元素来实现
        System.out.println(removeByOrder(nums));
        // 通过维护前三大元素的set来实现
        System.out.println(CollectionsMin(nums));
    }

    private static Integer CollectionsMin(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(Collections.min(set));
            }
        }
        if (set.size() == 3) {
            return Collections.min(set);
        }
        return Collections.max(set);
    }

    public static Integer removeByOrder(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if (set.size() > 3) {
            for (int i = 0; i < 2; i++) {
                set.remove(Collections.max(set));
            }
        }
        return Collections.max(set);
    }
}

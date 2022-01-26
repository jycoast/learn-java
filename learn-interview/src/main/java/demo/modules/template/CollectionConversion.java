package demo.modules.template;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 集合之前互相转换的示例
 *
 * @see <a href="https://segmentfault.com/a/1190000022879508">java 不同数据类型间相互转换</a>
 */
public class CollectionConversion {
    public static void main(String[] args) {
        int[] nums = {7, 8, 3, 4, 2, 1, 5, 0, 2};
        System.out.println(intArrayToList(nums));
        System.out.println(intArrayToSet(nums));
        System.out.println(listToSet(intArrayToList(nums)));
    }

    public static List<Integer> intArrayToList(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    public static Set<Integer> intArrayToSet(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toSet());
    }

    public static Set<Integer> listToSet(List<Integer> list) {
        return new HashSet<>(list);
    }
}

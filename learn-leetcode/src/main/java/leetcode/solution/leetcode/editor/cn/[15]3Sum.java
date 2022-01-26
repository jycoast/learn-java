package leetcode.solution.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/">三数之和</a>
 */
class sum3 {
    public static void main(String[] args) {
        sum3 sum3 = new sum3();
        int[] nums = {-1, 1, 2, 3, 3, 4, -3, 0};
        System.out.println(sum3.threeSum(nums));
    }

    //    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new LinkedList<>();
//        int target = 0;
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if ((nums[i] + nums[j] + nums[k]) == target) {
//                        List<Integer> integers = Arrays.asList(nums[i],nums[j],nums[k]);
//                        res.add(integers);
//                    }
//                }
//            }
//        }
//        return res;
//    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        // 排序
        Arrays.sort(nums);
        System.out.println("排序之后的数组： " + Arrays.toString(nums));
        // O(n^2)
        for (int i = 0; i < nums.length - 2; i++) {
            // 经过排序之后的数组第一个数大于0，后面的数都比它大，一定不成立
            if (nums[i] > 0) {
                break;
            }
            // 去掉重复情况
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    // 去掉重复情况，一直移动到没有相同项
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else { // nums[left] + nums[right] + nums[i] > 0
                    right--;
                }
            }
        }

        return res;
    }
}

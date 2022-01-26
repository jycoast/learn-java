package demo.modules.algorithm;

import java.util.Arrays;

/**
 * vivo算法题记录
 * 一个无序数组中两个数之和等于给定的值sum
 */
public class VivoDemo {
    public static void main(String[] args) {
        int[] nums = {7, 8, 3, 4, 2, 1, 5, 0};
        VivoDemo.TwoSum(nums, 7);
        VivoDemo.TwoSum(nums, 5);
        VivoDemo.TwoSum2(nums, 7);
        VivoDemo.TwoSum2(nums, 5);
    }

    /**
     * 双指针法 o(n)
     *
     * @param nums
     * @param target
     */
    private static void TwoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                System.out.println("nums[i]= " + nums[i] + " nums[j]= " + nums[j]);
                return;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
    }

    /**
     * 穷举法 o(n^2)
     *
     * @param nums
     * @param target
     */
    private static void TwoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    System.out.println("nums[i]= " + nums[i] + " nums[j]= " + nums[j]);
                    return;
                }
            }
        }
    }
}

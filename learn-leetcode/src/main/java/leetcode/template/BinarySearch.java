package leetcode.template;

/**
 * 二分查找代码模板
 *
 */
public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return 0;
    }
}

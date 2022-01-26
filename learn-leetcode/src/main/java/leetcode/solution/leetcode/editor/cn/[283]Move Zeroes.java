package leetcode.solution.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode-cn.com/problems/move-zeroes/">移动零</a>
 */
class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] array = {1, 2, 0, 4, 5};
        moveZeroes.moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 将非零数移动到index处
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

package leetcode.solution.leetcode.editor.cn;

/**
 *
 */
class JumpGame {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            // 说明最大步数已经无法到达
            if (i > maxJump) {
                return false;
            }
            maxJump = Math.max(i + nums[i], maxJump);
        }
        return true;
    }
}

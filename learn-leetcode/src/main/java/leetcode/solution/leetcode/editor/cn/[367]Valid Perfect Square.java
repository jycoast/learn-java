package leetcode.solution.leetcode.editor.cn;

/**
 * @see <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array/">搜索旋转排序数组</a>
 */
class ValidPerfectSquare {
    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare(15));
    }

    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left <= right) {
            // 这么写的原因是极端情况下left + right相加的结果溢出
            int mid =  left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}

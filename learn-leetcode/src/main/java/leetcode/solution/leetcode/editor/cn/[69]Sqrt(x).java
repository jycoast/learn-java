package leetcode.solution.leetcode.editor.cn;

/**
 * @see <a href="https://leetcode-cn.com/problems/sqrtx/">平方根</a>
 */
class Sqrt {
    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(0));
    }

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}

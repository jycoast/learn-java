package leetcode.solution.leetcode.editor.cn;

/**
 * f(n) = f(n-1) + f(n-2) 斐波那契数列
 *
 * @see <a href="https://leetcode-cn.com/problems/climbing-stairs/">爬楼梯</a>
 */
class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(5));
    }

    /**
     * 方式一：使用递归的方式
     *
     * @param n
     * @return //
     */
//    public int climbStairs(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i < n + 1; i++) {
            f3 = f1 + f2;
            // 优化
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}

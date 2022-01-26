package leetcode.solution.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode-cn.com/problems/assign-cookies/">分发饼干<a/>
 */
class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        // 孩子数组的下标
        int i = 0;
        // 饼干数组的下标
        int j = 0;
        while (i < g.length && j < s.length) {
            // 满足条件就下一个孩子
            if (g[i] <= s[i]) {
                i++;
            }
            // 不满足下一个饼干
            j++;
        }
        // 下标i正好是满足条件的孩子的个数
        return i;
    }
}

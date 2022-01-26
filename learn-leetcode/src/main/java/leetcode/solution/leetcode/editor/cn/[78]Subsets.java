package leetcode.solution.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/subsets/">子集</a>
 */
class Subsets {
    /**
     * [a]: []、[a]
     * [a,b]: []、[a]、[b]、[a,b]
     * [a,b,c]: []、[a]、[b]、[a,b]、[a,c]、[a,b,c]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(nums, res, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, int n, ArrayList<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = n; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, res, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}

package leetcode.solution.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/generate-parentheses/">括号生成</a>
 */
class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n <= 0) {
            return res;
        }
        dfs("", res, n, 0, 0);
        return res;
    }

    public void dfs(String paths, List<String> res, int n, int left, int right) {
        // 剪枝,去掉( > n 或 ) > n 或 ) > (的情况，由于传递性，) > n可以去掉
        if (left > n || right > left) {
            return;
        }
        // 因为括号都是成对出现的，因此需要遍历的树的深度为n*2
        if (paths.length() == n * 2) {
            res.add(paths);
            paths = "";
            return;
        }
        dfs(paths + '(', res, n, left + 1, right);
        dfs(paths + ')', res, n, left, right + 1);
    }
}

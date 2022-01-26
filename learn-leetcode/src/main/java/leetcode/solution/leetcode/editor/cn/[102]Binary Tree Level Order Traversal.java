package leetcode.solution.leetcode.editor.cn;

import leetcode.template.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal/">二叉树的层序遍历</a>
 */
class BinaryTreLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> num = new LinkedList<>();
            int size = queue.size();
            // 遍历当前层结点
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                num.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                size--;
            }
            res.add(num);
        }
        return res;
    }
}

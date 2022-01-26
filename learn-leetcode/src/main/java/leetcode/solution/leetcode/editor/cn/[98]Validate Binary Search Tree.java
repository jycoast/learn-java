package leetcode.solution.leetcode.editor.cn;


import leetcode.template.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/">验证二叉搜索树</a>
 */
class ValidateBinarySearch {
    public boolean isValidBST2(TreeNode root) {
        List<Long> nums = new LinkedList<>();
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean inOrder(TreeNode root, List<Long> nums) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            inOrder(root.left, nums);
        }
        nums.add((long) root.val);
        if (root.right != null) {
            inOrder(root.right, nums);
        }
        return true;
    }

    public boolean validate(TreeNode node, long min, long max) {
        // 终止条件
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }
        // 相当于给子树上所有的节点都添加了min和max的边界
        // 约束root的左子树的值不超过root的值，右子树的值不小于root的值
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    /**
     * 利用中序遍历是递增序列的性质求解
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        // 存储上一个节点的值
        double inorder = -Double.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            // 当前节点的值与上一个节点的值进行比较
            if (node.val <= inorder) {
                return false;
            }
            inorder = node.val;
            root = node.right;
        }
        return true;
    }
}

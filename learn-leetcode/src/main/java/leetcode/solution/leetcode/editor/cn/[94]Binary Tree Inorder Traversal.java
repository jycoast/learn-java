package leetcode.solution.leetcode.editor.cn;


import leetcode.template.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-inorder-traversal/">二叉树的中序遍历</a>
 * <p>
 * 中序遍历：左子树 -> 根结点 -> 右子树
 */
class BinaryTreeInorderTraversal {

    /**
     * 使用递归
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        this.inorder(root, list);
//        return list;
//    }
//
//    public void inorder(TreeNode root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        if (root.left != null) {
//            inorder(root.left, res);
//        }
//        res.add(root.val);
//        if (root.right != null) {
//            inorder(root.right, res);
//        }
//    }

    /**
     * 通过栈
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (stack.size() > 0 || root != null) {
            // 不断往左子树方向走，每走一次就将当前节点保存到栈中
            // 这是模拟递归的调用
            if (root != null) {
                stack.add(root);
                root = root.left;
                // 当前节点为空，说明左边走到头了，从栈中弹出节点并保存
                // 然后转向右边节点，继续上面整个过程
            } else {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;
    }

    /**
     * 莫里斯遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        TreeNode cur = root;    // 记录当前节点位置
        List<Integer> res = new ArrayList<>();
        while (cur != null) {
            if (cur.left == null) {   // 左节点为空，移到右子节点
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) { // 遍历到左子树的最右侧节点
                    prev = prev.right;
                }
                if (prev.right == null) {        // 建立返回父节点连接
                    prev.right = cur;
                    cur = cur.left;
                } else {                        // 左子树建立了连接，说明遍历完了，可以拆除连接
                    res.add(cur.val);           // 中序遍历录入当前节点
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    // 获取前序节点
    public TreeNode getPredecessor(TreeNode root){
        TreeNode pre = root;
        if (root.left != null){
            pre = pre.left;
            // 一直往右孩子移动
            while (pre.right != null && pre.right != root){
                pre = pre.right;
            }
        }

        return pre;
    }

    // 莫里斯中序遍历
    public void morrisTravel(TreeNode root){
        while (root != null){
            if(root.left == null){
                // 打印当前节点
                System.out.println(root.val);
                // 进入到右孩子
                root = root.right;
            }else {
                // 找到当前节点的前序节点
                TreeNode pre = getPredecessor(root);
                // 如果前序节点的右孩子为null，将右孩子指向当前节点
                if (pre.right == null){
                    pre.right = root;
                    root = root.left;
                }else if (pre.right == root){
                    pre.right = null;
                    System.out.println(root.val);
                    root = root.right;
                }
            }
        }
    }
}

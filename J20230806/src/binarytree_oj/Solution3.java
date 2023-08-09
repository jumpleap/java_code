package binarytree_oj;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution3 {
    /**
     * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root 根节点
     * @return 返回集合
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        //判空
        if (root == null) {
            return ret;
        }

        postOrder(root, ret);
        return ret;
    }

    private void postOrder(TreeNode root, List<Integer> ret) {
        if (root == null) return;
        //左右根
        postOrder(root.left, ret);
        postOrder(root.right, ret);
        ret.add(root.val);
    }
}
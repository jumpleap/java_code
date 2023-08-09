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
class Solution1 {
    /**
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root 根节点
     * @return 返回集合
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        preOrder(root, list);
        return list;
    }

    private void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        //根左右
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
package binarytree_oj;

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

/*
给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
class Solution2 {
    /**
     * 思路分析：翻转二叉树，那么则需要把这颗树的左右节点进行翻转
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root 给定根节点
     * @return 翻转后的根节点
     */
    public TreeNode invertTree(TreeNode root) {
        //判空
        if (root == null) return root;

        //交换左右子树的节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        //递归左右子树
        invertTree(root.left);
        invertTree(root.right);
        //返回反转后的根节点
        return root;
    }
}
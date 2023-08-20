package leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
class Solution4 {
    public int maxDepth(TreeNode root) {
        //节点为空则返回0
        if(root == null) {
            return 0;
        }

        //左树的长度
        int leftHeight = maxDepth(root.left);
        //右树的长度
        int rightHeight = maxDepth(root.right);
        //判断左右树那个长，然后返回长的那个多1
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }
}
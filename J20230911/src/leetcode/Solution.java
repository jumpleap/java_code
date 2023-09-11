package leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/**
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */
class Solution {
    /**
     * 思路分析: 递归, 分别递归左子树和右子树,遇到null互返回0
     * 时间复杂度: O(n)
     * 空间复杂度: O(logN)
     * @param root 给定根节点
     * @return 返回二叉树的深度
     */
    public int maxDepth(TreeNode root) {
        //遇到空则返回0
        if (root == null) return 0;

        //递归计算左子树的节点个数
        int leftHeight = maxDepth(root.left);
        //递归计算右子树的节点个数
        int rightHeight = maxDepth(root.right);

        //判断那个节点数大,并返回个数+1[这个1表示当前节点]
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }
}
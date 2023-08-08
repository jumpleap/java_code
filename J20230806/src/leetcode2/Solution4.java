package leetcode2;

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

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 */
class Solution4 {
    /**
     * 递归：遇到节点则从sum中扣除节点值，一直到叶子节点判断sum是不是和叶子节点相等
     * 时间复杂度：O(n)
     * 空间复杂度：O(h)
     * @param root 给定的根节点
     * @param sum 给定的sum值
     * @return true/false
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        //判断节点是否为空
        if (root == null) {
            return false;
        }
        //遇到了叶子节点，比较两者的值
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        //左右进行递归
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
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
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
class Solution2 {
    /**
     * 思路分析：递归，递归左树的和右树，拿左树的左节点和右树的右节点，拿左树的右节点和右树的左节点比较
     * 1.若树只有一个节点/树为空树
     * 2.左树和右树均为空，返回true
     * 2. 左树为空或右树为空，返回false
     * 3.左右树的对应节点的值不同，返回false
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(logN)
     * @param root 给定根节点
     * @return 返回是否对称
     */
    public boolean isSymmetric(TreeNode root) {
        //空树
        if (root == null) return true;

        //递归树的左右节点
        return symmetric(root.left, root.right);
    }


    private boolean symmetric(TreeNode leftTree, TreeNode rightTree) {
        //只有一个节点的树
        if (leftTree == null && rightTree == null) return true;
        //左树为空或右树为空或左右树的节点值不同
        if (leftTree == null || rightTree == null || leftTree.val != rightTree.val) {
            return false;
        }
        //递归左树的左节点和右树的右节点；递归左树的右节点和右树的左节点
        return symmetric(leftTree.left, rightTree.right)
                && symmetric(leftTree.right, rightTree.left);
    }
}
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
class Solution {
    /**
     * 思路分析：分别判断这两颗树的左树和右树是否都相等
     * 时间复杂度：O(n)
     * @param p 树1
     * @param q 树2
     * @return true/false
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //1.一个为空，一个不为空
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        //2.两个都为空
        if (p == null && q == null) {
            return true;
        }

        //3.两个都不为空且节点值不同
        if (p.val != q.val) {
            return false;
        }

        //4.分别递归两个树的左子树和右子树进行比较
        //左子树和右子树均相等的情况下，即返回true
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
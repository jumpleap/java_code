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
给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。

二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 */
class Solution1 {
    /**
     * 思路分析：判断一棵树是否是另一颗树的子树的情况
     * 1.判断两颗树是否全等
     * 2.判断root树的左树是否和子树相等
     * 3.判断root树的右树是否和子树相等
     * 时间复杂度：O(m,n)
     * 空间复杂度：O(max(m,n))
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //若root是空，则返回false
        if (root == null) return false;

        //1.两个树全等
        if (isSameTree(root, subRoot)) {
            return true;
        }
        //判断左树是否和subRoot相等
        if (isSubtree(root.left, subRoot)) {
            return true;
        }

        //判断右树是否和subRoot相等
        if (isSubtree(root.right, subRoot)) {
            return true;
        }

        //若左树和右树均和subRoot不等，那么则返回false
        return false;
    }

    //判断两棵树是否相等
    private boolean isSameTree(TreeNode p, TreeNode q) {
        //一个为空，一个不为空
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        //两个都为空
        if (p == null && q == null) {
            return true;
        }

        //两个都不为空，但值不相等
        if (p.val != q.val) {
            return false;
        }

        //递归判断左右子树是否相等
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
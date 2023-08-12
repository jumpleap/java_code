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
     * 思路分析：判断两个树是否全等【结构相等且值相等】
     * 1.判断是否有存在一边为空，一边不为空的情况
     * 2.判断两个树是否都为空
     * 3.判断两个树的节点值是否相等
     * 4.递归判断其子树
     * 时间复杂度：O(min(m,n))
     * 空间复杂度：O(min(m,n))
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
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
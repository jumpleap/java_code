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
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
class Solution3 {
    /**
     * 思路分析：交换左右子树的位置，然后分别递归左右子树
     * 1.若当前的节点为空，直接返回root
     * 2.若当前节点的左右子树皆为空，直接返回root
     * 3.交换左右子树
     * 4.分别递归左右子树，最后返回已经交换后的左右子树
     * 时间复杂度：O(n)
     * 空间复杂度：O(logN)
     * @param root 给定的根节点
     * @return 返回交换后的root
     */
    public TreeNode mirrorTree(TreeNode root) {
        //root为空
        if (root == null) return root;

        //左树为空且右树为空
        if (root.left == null && root.right == null) return root;

        //交换左右树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        //分别递归左树和右树
        mirrorTree(root.left);
        mirrorTree(root.right);

        //返回已经交换后节点
        return root;
    }
}
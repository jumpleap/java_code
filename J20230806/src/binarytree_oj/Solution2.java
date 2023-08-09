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
class Solution2 {
    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root 根节点
     * @return 返回集合
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        //判空
        if (root == null) {
            return;
        }
        //中序遍历：左根右
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
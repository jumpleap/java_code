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
class Solution1 {
    /**
     * 递归: 计算左右子树的深度,判断左右子树是否平衡, 若平衡,继续递归左右子树, 查看后续的节点是否平衡
     * 时间复杂度: O(mn)
     * 空间复杂度L:O(n)
     * @param root 给定的root节点
     * @return 返回true/false
     */
    public boolean isBalanced(TreeNode root) {
        //空树返回true
        if (root == null) return true;

        //计算左右子树的深度
        int leftHeight = getHeightTree(root.left);
        int rightHeight = getHeightTree(root.right);

        //判断左右子树是否平衡,并继续递归左右子树,判断剩下的节点中都平衡
        return (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) &&
                isBalanced(root.right));
    }

    //计算左右子树的深度
    private int getHeightTree(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeightTree(root.left);
        int rightHeight = getHeightTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
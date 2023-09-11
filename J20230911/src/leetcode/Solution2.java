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
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
class Solution2 {
    /**
     * 递归, 递归左子树和右子树,判断递归的过程root是否为空,或root是否和p,q相等,相等则返回root
     * 1.递归结束后,左子树中是否右p,q节点, 没有则说明p,q均在右子树中
     * 2.递归结束后,右子树中是否右p,q节点, 没有则说明p,q均在左子树中
     * 3.若左右子树中各有一个p,q节点, 则说明root是最近公共祖先
     * 时间复杂度:O(N)
     * 空间复杂度:O(N)
     * @param root 给定的根节点
     * @param p p节点
     * @param q q节点
     * @return 返回最近公共祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //root为空
        if (root == null) return root;

        //root的值和p或q相等
        if (root == p || root == q) return root;

        //分别递归左树和右树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //若左树为空,则说明p,q的最近公共祖先在右树
        if (left == null) return right;
        //若右树为空,则说明p,q的最近公共祖先在左树
        if (right == null) return left;
        //左树和右树都不为空
        return root;
    }
}
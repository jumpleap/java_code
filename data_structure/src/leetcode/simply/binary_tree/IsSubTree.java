package leetcode.simply.binary_tree;

import leetcode.util.TreeNode;

// 子树判断
public class IsSubTree {
    /*
        给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
        如果存在，返回 true ；否则，返回 false 。
        二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
        链接：https://leetcode.cn/problems/subtree-of-another-tree/description/
     */

    /**
     * 思路分析：模拟，把递归中的每个节点及其子节点和子树进行比较，相等则返回true
     * 时间复杂度： O(N)
     * 空间复杂度： O(1)
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 判空
        if (root == null || subRoot == null) return false;
        // 判断两颗树是不是一样的树
        if (isSameTree(root, subRoot)) return true;

        // 分别判断左树和右树中是否含有这颗子树
        // boolean leftTree = isSubtree(root.left, subRoot);
        // if (leftTree) return true;

        // boolean rightTree = isSubtree(root.right, subRoot);
        // if (rightTree) return true;
        // return false;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        // 都是空树
        if (p == null && q == null) return true;

        // 一颗为空， 一颗不为空
        if ((p == null && q != null) || (p != null && q == null)) return false;

        // 值不同
        if (p.val != q.val) return false;

        // 分别判断左树和右树是否相等
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

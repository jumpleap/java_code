package leetcode.simply.binary_tree;

import leetcode.util.TreeNode;

// 相同的树
public class IsSameTree {
    /*
        给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
        如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
        链接：https://leetcode.cn/problems/same-tree/description/
     */

    /**
     * 思路分析： 模拟，分别比较两颗树的左树，右树的节点值是否相等， 不相等则返回false
     * 时间复杂度： O(N)
     * 空间复杂度： O(1)
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 两棵树都为空
        if (p == null && q == null) return true;

        // 一颗为空，一颗不为空
        if ((p == null && q != null) || (p != null && q == null)) return false;

        // 节点值不相同
        if (p.val != q.val) return false;

        // 分别判断左树和右树是否相等
        boolean left = isSameTree(p.left, q.left);
        if (!left) return false;
        boolean right = isSameTree(p.right, q.right);
        if (!right) return false;
        // 左右树都相等
        return true;

        // 另一种写法
        // return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

package leetcode.simply.binary_tree;

import leetcode.util.TreeNode;

// 完全二叉树的节点个数
public class CountNodes {
    /*
        给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
        完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
        其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
        若最底层为第 h 层，则该层包含 1~ 2h 个节点。
        https://leetcode.cn/problems/count-complete-tree-nodes/description/?envType=study-plan-v2&envId=top-interview-150
     */


    /**
     * 思路：深度优先遍历
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        // 判断当前节点是否为空
        if (root == null) return 0;

        // 进一步获取左树和右树的节点个数
        // 再加上1是把根节点的个数也算上
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

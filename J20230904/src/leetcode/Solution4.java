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
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
class Solution4 {
    //函数的作用就是判断B 是否是 A 的子结构树
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //约定空树不是任意一个树的子结构
        if (B == null || A == null) return false;
        return subStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    //dp的作用是判断从A 的根节点出发，是否存在跟B 结构相同的树。
    private boolean subStructure(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || B.val != A.val) return false;
        return subStructure(A.left, B.left) && subStructure(A.right, B.right);
    }
}
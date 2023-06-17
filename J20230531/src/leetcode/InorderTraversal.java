package leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        List<Integer> leftAll = inorderTraversal(root.left);
        ret.addAll(leftAll);
        ret.add(root.val);
        List<Integer> rightAll = inorderTraversal(root.right);
        ret.addAll(rightAll);
        return ret;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

package leetcode;

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution6 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] inorderTraversal(TreeNode root) {
        // write code here
        // 定义集合, 保存元素
        List<Integer> list = new ArrayList<>();
        // 中序遍历
        inOrder(root, list);
        // 申请数组空间
        int[] ans = new int[list.size()];

        // 数组赋值
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        // 判空
        if (root == null) {
            return;
        }

        // 左根右
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
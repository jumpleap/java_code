package leetcode.simply.binary_tree;
import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 二叉树的最大深度
public class MaxDepth {
    /*
        给定一个二叉树 root ，返回其最大深度。
        二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
        https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
     */

    /**
     * 深度优先搜索
     * 思路：
     *      1.递归左树，遇到null返回0，递归右树，遇到null返回0
     *      2.判断左树和右树谁高，最高的最后再加上根节点的1层高度
     *      3.返回深度
     * 时间复杂度：O(N)
     * 空间复杂度：O(Height)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        // 判空 或 到达了最后一个节点的前一个节点
        if (root == null) return 0;

        // 左树高度
        int leftHeight = maxDepth(root.left);
        // 右树高度
        int rightHeight = maxDepth(root.right);
        // 最后判断谁高，再加上根的高度【根也有一个高度】
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * 广度优先遍历
     * 思路：利用队列模拟二叉树的层序遍历，每遍历一层则height++，直到遍历结束
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        // 一个节点都没有
        if (root == null) return 0;

        // 初始化队列，用于广度遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 计算深度
        int height = 0;

        while (!queue.isEmpty()) {
            // 获取当前队列中的节点个数
            int size = queue.size();

            while (size > 0) {
                // 弹出当前的队头元素
                TreeNode tmp = queue.poll();

                // 那边不为空，则把那边入到队列中
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }

                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
                // 继续判断是否还有下一个节点
                size--;
            }
            // 到此，上述循环过程就是一层
            height++;
        }
        // 返回结果
        return height;
    }
}

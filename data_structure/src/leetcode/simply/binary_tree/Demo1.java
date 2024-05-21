package leetcode.simply.binary_tree;

import leetcode.util.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树代码
public class Demo1 {
    /*
        给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
        链接: https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
     */

    /**
     * 思路分析: 广度优先搜索 + 辅助队列
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 初始化顺序表
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 初始化队列
        Queue<TreeNode> queue = new LinkedList<>();

        // 判空
        if (root != null)
            queue.offer(root);

        // 队列不为空
        while (!queue.isEmpty()) {
            // 临时顺序表
            List<Integer> tmp = new ArrayList<>();

            // 获取当前队列的长度
            for (int i = queue.size(); i > 0; i--) {
                // 弹出队列中的元素
                TreeNode node = queue.poll();
                // 添加值
                tmp.add(node.val);

                // 左节点判空
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // 右节点判空
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
            // 把当前行的值入到ans中
            ans.add(tmp);

        }
        return ans;
    }
}

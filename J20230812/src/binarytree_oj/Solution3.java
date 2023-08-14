package binarytree_oj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/*
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
class Solution3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        //判空
        if (root == null) {
            return list;
        }
        //申请队列
        Queue<TreeNode> queue = new LinkedList<>();
        //把根结点放入到队列中去
        queue.offer(root);

        //队列不为空
        while (!queue.isEmpty()) {
            //申请顺序表
            List<Integer> ret = new ArrayList<>();
            //获取队列的长度
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                //出队
                TreeNode tmp = queue.poll();
                //把出队的值保存在队列中
                ret.add(tmp.val);

                //判断弹出的结点是否右左右结点，有则入队
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }

                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            //把该顺序表加入到另外一个顺序表中
            list.add(ret);
        }
        return list;

    }
}
package leetcode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution5 {
    public int[] levelOrder(TreeNode root) {
        //判空
        if(root == null) {
            return new int[0];
        }
        //使用队列存储树的结点
        Queue<TreeNode> queue = new LinkedList<>();
        //把根节点入队
        queue.offer(root);
        //使用顺序表保存结点的值
        ArrayList<Integer> list = new ArrayList<>();

        //队列不为空
        while(!queue.isEmpty()) {
            //弹出队头元素
            TreeNode tmp = queue.poll();
            //把值添加到顺序表中
            list.add(tmp.val);

            //判断弹出的结点是否右左右结点，有则入队
            if(tmp.left != null) {
                queue.offer(tmp.left);
            }
            if(tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
        //申请数组
        int[] array = new int[list.size()];
        //把顺序表中的值存在数组中，并返回
        for(int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
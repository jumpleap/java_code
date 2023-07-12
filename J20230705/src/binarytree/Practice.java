package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Practice {
    //二叉树的层次遍历
    public List<List<TreeNode>> levelOrder(TreeNode root) {
        List<List<TreeNode>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //求一下当前队列的大小  4
            int len = queue.size();
            // 出队列4次 相当于把 这一层的节点都 出队了
            List<TreeNode> tmp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                tmp.add(cur);
                System.out.print(cur.val + " ");
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ret.add(tmp);
        }
        return ret;
    }
}
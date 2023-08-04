package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution3 {
    //法一：递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        //申请顺序表
        List<Integer> list = new ArrayList<>();
        //进行递归
        inorder(root, list);
        return list;
    }

    /**
     * 思路分析：根据中序遍历的特点【左根右】来进行递归，遇到root为空后返回list
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * root 根节点
     * list 保存root中的值
     */
    private void inorder(TreeNode root, List<Integer> list) {
        //判空
        if (root == null) {
            return;
        }
        //中序遍历：左根右
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }


    /**
     * 思路分析：使用辅助栈来保存root中的节点，使用集合保存root中的节点值
     * 根据中序遍历的特点，先往左边找且找到的节点入栈，左边的元素为空后，弹出最后栈顶元素【最后一个左节点】，
     * 把该左节点的值保存到list集合中，又往右边继续找；往复循环按照这种规则寻找，最后则可以找完
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root 给定的根节点
     * @return 返回集合
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        //定义List集合：保存root中的值
        List<Integer> list = new ArrayList<>();
        //定义栈：保存root中节点
        Stack<TreeNode> stack = new Stack<>();

        //栈中的元素小于等于0 && root == null跳出循环
        while (stack.size() > 0 || root != null) {
            //root不等于空
            if (root != null) {
                //当前节点入栈
                stack.push(root);
                //往root的左边找节点,中序遍历特点：左根右
                root = root.left;
            } else { //root为空
                //弹出栈顶元素
                TreeNode tmp = stack.pop();
                //把栈顶元素的节点的值入到集合中
                list.add(tmp.val);
                //当前的root为空且已经把元素入栈，说明左和根已找到，往右边找
                root = tmp.right;
            }
        }
        return list;
    }
}
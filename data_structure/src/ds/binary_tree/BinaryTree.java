package ds.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 二叉树的基本操作
public class BinaryTree {
    // 节点类
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }


    // 创建一颗二叉树
    public TreeNode createBinaryTree() {
        TreeNode node = new TreeNode(11);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(231);
        TreeNode node4 = new TreeNode(10);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(7);

        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        return node;
    }

    // 前序遍历(根左右) -- 递归法
    public void preOrder(TreeNode root) {
        // 判空
        if (root == null) return;

        // 根左右
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 前序遍历(根左右) -- 非递归
    public void preOrderNor(TreeNode root) {
        // 判空
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // 获取栈顶节点
        TreeNode top = null;

        while (!stack.empty() || cur != null) {
            // cur不为空， 入栈， 一直入到没有左节点为止
            while (cur != null) {
                // 入栈
                stack.push(cur);
                // 根： 打印值
                System.out.print(cur.val + " ");
                // 指向下一个左节点
                cur = cur.left;
            }

            // 弹出当前的左节点
            top = stack.pop();
            // 拿到当前左节点的右节点
            cur = top.right;
        }
    }

    // 中序遍历（左根右） --- 递归
    public void inOrder(TreeNode root) {
        // 判空
        if (root == null) return;

        // 左根右
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // 中序遍历（左根右） --- 非递归
    public void inOrderNor(TreeNode root) {
        // 判空
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // 获取栈顶节点
        TreeNode top = null;

        while (cur != null || !stack.empty()) {
            // 入左节点， 一直入到左节点为空为止
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 获取栈顶节点
            top = stack.pop();
            // 打印根
            System.out.print(top.val + " ");
            // 左和根都已经访问了， 限制访问当前根的右节点
            cur = top.right;
        }
    }

    // 后序遍历（左右根） -- 递归
    public void postOrder(TreeNode root) {
        // 判空
        if (root == null) return;

        // 左右根
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    // 后序遍历（左右根） -- 非递归
    public void postOrderNor(TreeNode root) {
        // 判空
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        // 弹出节点的父节点
        TreeNode prev = null;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 当前的左节点已经全部入栈了
            top = stack.peek();

            // 判断top右节点是否为空，或是否已经遍历过了
            if (top.right == null || top.right == prev) {
                stack.pop();
                System.out.print(top.val + " ");
                prev = top;
            } else {
                cur = top.right;
            }
        }
    }

    // 获取节点个数 -- 计数法
    private int size;

    public int sizeOfCount(TreeNode root) {
        // 判空
        if (root == null) return size;

        // 随便一个遍历即可
        size++;
        sizeOfCount(root.left);
        sizeOfCount(root.right);
        // 最后返回节点数
        return size;
    }

    // 获取节点个数 -- 递归
    public int size(TreeNode root) {
        // 判空
        if (root == null) return 0;

        // 计算左树节点和右树节点数 + 根节点
        return size(root.left) + size(root.right) + 1;
    }

    // 叶子节点数 -- 计数法
    private int count;

    public int getLeafCount(TreeNode root) {
        // 判空
        if (root == null) return count;

        // 叶子节点
        if (root.left == null && root.right == null) {
            count++;
        }

        // 递归
        getLeafCount(root.left);
        getLeafCount(root.right);
        return count;
    }

    // 叶子节点数 -- 递归
    public int getLeafSize(TreeNode root) {
        // 判空
        if (root == null) return 0;

        // 叶子节点
        if (root.left == null && root.right == null) return 1;

        // 分别计算左右子树的叶子节点数
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    // 获取第K层的节点个数
    public int getKLevelNodeCount(TreeNode root, int k) {
        // 判空
        if (root == null || k == 0) return 0;
        // 第一层
        if (k == 1) return 1;

        // 分别计算左树第k层的节点数和分别计算右树第k层的节点数
        return getKLevelNodeCount(root.left, k - 1) + getKLevelNodeCount(root.right, k - 1);
    }

    // 获取二叉树的高度
    public int getTreeHeight(TreeNode root) {
        // 判空
        if (root == null) return 0;

        // 左树的高度
        int leftTree = getTreeHeight(root.left);
        // 右树的高度
        int rightTree = getTreeHeight(root.right);
        // 注：根也占一个高度
        // 判断那边树高，最后再加上根的高度
        return Math.max(leftTree, rightTree) + 1;
    }

    // 判断val值是否存在
    public boolean contains(TreeNode root, int val) {
        // 判空
        if (root == null) return false;

        // 判断根节点
        if (root.val == val) return true;

        // 判断左树中是否包含该节点
        boolean leftTree = contains(root.left, val);
        // 找到了
        if (leftTree) return true;

        // 判断右树中是否包含该节点
        boolean rightTree = contains(root.right, val);
        // 找到了
        if (rightTree) return true;

        // 不存在
        return false;
    }

    // 层序遍历
    public void levelOrder(TreeNode root) {
        // 判空
        if (root == null) return;
        // 初始化队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 弹出队头元素
            TreeNode cur = queue.poll();
            // 打印
            System.out.print(cur.val + " ");

            // 左节点不为空
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            // 右节点不为空
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    // 判断是不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        // 判空
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        // 入根节点
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 弹出队头元素
            TreeNode cur = queue.poll();

            // 队头元素不为空，把队头元素的左孩子和右孩子入队
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                // 队头为空后， 说明没有元素了
                break;
            }
        }

        // 若是完全二叉树，那么此时队列中全是null
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            // 遇到了非null，说明不是完全二叉树
            if (tmp != null) {
                return false;
            }
        }
        // 全是null，返回true
        return true;
    }
}
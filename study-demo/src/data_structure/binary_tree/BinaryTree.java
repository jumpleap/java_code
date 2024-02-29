package data_structure.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 二叉树代码
public class BinaryTree {
    // 节点类
    static class TreeNode {
        // 左子树
        private TreeNode left;
        // 右子树
        private TreeNode right;
        // 值
        private int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 创建一颗二叉树
     */
    public TreeNode createBinaryTree() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;

        // 返回根节点
        return treeNode;
    }

    /**
     * 前序遍历: 根左右
     */
    public void preOrder(TreeNode root) {
        // 判空
        if (root == null) {
            return;
        }
        // 根左右
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历: 左根右
     */
    public void inOrder(TreeNode root) {
        // 判空
        if (root == null) {
            return;
        }
        // 左根右
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    /**
     * 后序遍历: 左右根
     */
    public void postOrder(TreeNode root) {
        // 判空
        if (root == null) {
            return;
        }
        // 左右根
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    /**
     * 获取二叉树的节点个数(遍历)
     */
    public int count = 0;

    public void size2(TreeNode root) {
        // 判空
        if (root == null) {
            return;
        }
        size2(root.left);
        count++;
        size2(root.right);
    }

    /**
     * 获取二叉树的节点个数(递归)
     */
    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    /**
     * 获取叶子节点的个数(遍历思路解决)
     */
    public int leafSize = 0;

    public void getLeafNodeSize2(TreeNode root) {
        if (root == null) return;
        // 判断叶子节点
        if (root.left == null && root.right == null) {
            leafSize++;
            // return;
        }
        getLeafNodeSize2(root.left);
        getLeafNodeSize2(root.right);
    }

    /**
     * 获取叶子节点个数(子问题解决)
     */
    public int getLeafNodeSize(TreeNode root) {
        if (root == null) return 0;
        // 判断叶子节点
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeSize(root.left) + getLeafNodeSize(root.right);
    }

    /**
     * 获取第k层节点的个数
     */
    public int getKLevelNodeCount(TreeNode root, int k) {
        if (root == null) return 0;
        // 当k到达目标层, 就返回值
        if (k == 1) {
            return 1;
        }
        // 进行左右子数的递归
        return getKLevelNodeCount(root.left, k - 1) +
                getKLevelNodeCount(root.right, k - 1);
    }

    /**
     * 获取二叉树的高度
     */
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    /**
     * 判断value是否存在
     */
    public boolean find(TreeNode root, int value) {
        // 判空
        if (root == null) return false;
        // 找到了
        if (root.value == value) {
            return true;
        }
        // 递归查找左子树
        boolean leftTree = find(root.left, value);
        if (leftTree) return true;
        // 递归查找右子树
        boolean rightTree = find(root.right, value);
        if (rightTree) return true;
        // 没找到
        return false;
    }

    /**
     * 层序遍历
     */
    public void levelOrder(TreeNode root) {
        if (root == null) return;

        // 创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 入根节点
        queue.offer(root);

        // 当队列不为空时
        while (!queue.isEmpty()) {
            // 弹出当前队列中的节点
            TreeNode cur = queue.poll();
            System.out.print(cur.value + " ");

            // 把弹出节点的左右节点入队
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    /**
     * 判断一棵树是不是完全二叉树
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 弹出队头元素
            TreeNode cur = queue.poll();
            if (cur != null) {
                // 把队头元素的左右节点入队
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                // 遇到null, 跳出循环
                break;
            }
        }

        // 若是完全二叉树, 那么此时队列中已经全部是null
        // 若不是完全二叉树, 那么此时队列中还有非null值存在
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // 遇到非null存在, 直接返回false
            if (cur != null) {
                return false;
            }
        }
        // 全空返回true
        return true;
    }

    /**
     * 二叉树的前序遍历非递归实现: 根左右
     */
    public void preOrderNor(TreeNode root) {
        // 判空
        if (root == null) return;
        // 创建栈
        Stack<TreeNode> stack = new Stack<>();
        // 获取当前节点
        TreeNode cur = root;
        // 获取栈顶元素
        TreeNode top = null;

        // 当cur和stack都为空时, 跳出循环
        while (cur != null || !stack.isEmpty()) {
            // 当cur不为空时, 入栈
            // 一直入到没有左节点为止
            while (cur != null) {
                stack.push(cur);
                // 根: 打印值
                System.out.print(cur.value + " ");
                // 获取下一个左节点
                cur = cur.left;
            }

            // 弹出当前的左节点
            top = stack.pop();
            // 拿到与当前左节点最近的一个右节点
            cur = top.right;
        }
    }

    /**
     * 二叉树的中序遍历非递归实现: 左根右
     */
    public void inOrderNor(TreeNode root) {
        // 判空
        if (root == null) {
            return;
        }
        // 创建栈
        Stack<TreeNode> stack = new Stack<>();
        // 获取当前节点
        TreeNode cur = root;
        // 获取栈顶元素
        TreeNode top = null;

        // 当 cur 和 stack 均为空时, 跳出循环
        while (cur != null || !stack.isEmpty()) {
            // 当 cur 不为空, 则入栈, 左根右
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 当 cur 为空后, 说明左边的节点已经找完了, 开始到根了
            // 弹出栈顶元素, 即已经到找到最后一个左节点的值
            top = stack.pop();
            // 打印值, 即根
            System.out.print(top.value + " ");
            // 左边和根已经搞定, 接下来开始找右边的节点
            cur = top.right;
        }
    }

    /**
     * 二叉树的后序遍历非递归实现: 左右根
     */
    public void postOrderNor(TreeNode root) {
        // 判空
        if (root == null) return;
        // 创建栈
        Stack<TreeNode> stack = new Stack<>();
        // 获取当前节点
        TreeNode cur = root;
        // 获取栈顶元素
        TreeNode top = null;
        // 指向弹出的节点
        TreeNode prev = null;

        // 当 cur 和 stack 都为空, 跳出循环
        while (cur != null || !stack.isEmpty()) {
            // 把所有的左节点入栈, 一直到空
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 获取栈顶元素
            top = stack.peek();
            // 判断top的右节点是否为空, 或是否和prev节点相等, 相等则弹出
            if (top.right == null || top.right == prev) {
                stack.pop();
                System.out.print(top.value + " ");
                prev = top;
            } else {
                // 指向右节点
                cur = top.right;
            }
        }
    }
}
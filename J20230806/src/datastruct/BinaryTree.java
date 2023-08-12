package datastruct;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 创建一颗树，返回这个树的根节点
     * @return 根节点
     */
    public TreeNode createTree() {
        //申请节点
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        TreeNode H = new TreeNode(8);

        //连接
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }


    /**
     * 前序遍历 - 根左右
     * @param root 根节点
     */
    public void preOrder(TreeNode root) {
        if (root == null) return;
        //先访问根，再访问左和右
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历 - 左根右
     * @param root 根节点
     */
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    /**
     * 后序遍历 - 左右根
     * @param root 根节点
     */
    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 获取树中节点的个数 - 遍历思路
     */
    int size = 0;

    public void getSize(TreeNode root) {
        if (root == null) return;
        size++;//不为空则有节点
        getSize(root.left);
        getSize(root.right);
    }

    /**
     * 获取树中节点的个数 - 子问题思路
     * 分别求左子树的个数和右子树的个数
     * @param root 根节点
     * @return 返回节点树
     */
    public int getSize2(TreeNode root) {
        if (root == null) return 0;
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    /**
     * 获取叶子节点的个数 - 遍历思路
     * 叶子节点的判断：没有度的节点，即左子树为空且右子树为空
     */
    int leafSize = 0;

    public void getLeafNodeCount(TreeNode root) {
        if (root == null) return;

        //判断是不是叶子节点
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
    }

    /**
     * 获取叶子节点的个数 - 子问题思路
     * @param root 根节点
     * @return 返回叶子节点总数
     */
    public int getLeafNodeCount2(TreeNode root) {
        if (root == null) return 0;

        //判断叶子节点
        if (root.left == null && root.right == null) {
            return 1;
        }

        //左子树+右子树的叶子节点总数
        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right);
    }

    /**
     * 获取第K层节点的个数
     * @param root 根节点
     * @param k    第k层
     * @return 返回第K层的节点总数
     */
    public int getKLevelNodeCount(TreeNode root, int k) {
        if (root == null) return 0;
        //当前层的节点，则返回当前的节点数
        if (k == 1) return 1;
        k--;//下一层
        return getKLevelNodeCount(root.left, k) + getKLevelNodeCount(root.right, k);
    }


    /**
     * 获取树的高度 - 子问题
     * 分别获取左树的高度和右树的高度，比较大小 + 1
     * @param root 根节点
     * @return 返回高度
     */
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        //左树的高度
        int leftHeight = getHeight(root.left);
        //右树的高度
        int rightHeight = getHeight(root.right);
        //判断大小
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    /**
     * 检测值为value的元素是否存在
     * @param root 根节点
     * @param val  查找的值
     * @return 返回true/false
     */
    public boolean find(TreeNode root, int val) {
        //判空
        if (root == null) return false;
        //判断root
        if (root.val == val) {
            return true;
        }
        //查找左子树是否有这个节点
        boolean leftValue = find(root.left, val);
        if (leftValue) return true;
        //查看右子树是否有这个节点
        boolean rightValue = find(root.right, val);
        if (rightValue) return true;
        //都没有的情况
        return false;
    }

    /**
     * 层序遍历 -- 使用队列来进行实现
     * @param root 根节点
     */
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");

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
     * @param root 根节点
     * @return 返回true/false
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                //不是空则入队
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                //遇到空则跳出循环
                break;
            }
        }

        //若队列中有不为空的值，则说明不是完全二叉树
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                return false;
            }
        }
        return true;
    }
}
package binarytree;

import java.util.Scanner;

public class Solution {
    /*
    编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。
    例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，
    空格字符代表空树。建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String str = in.nextLine();
            TreeNode root = createTree(str);
            inOrder(root);
        }
    }

    public static int i = 0;

    //根据前序遍历构造二叉树
    public static TreeNode createTree(String str) {
        TreeNode root = null;
        //判断当前字符是不是#
        if (str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;//指向下一个字符
            root.left = createTree(str);
            root.right = createTree(str);
        } else {
            i++;//是#号直接跳到下一个字符
        }
        //把root返回
        return root;
    }

    //中序遍历
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        //左根右
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }


    /*
    给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
    如果存在，返回 true ；否则，返回 false 。
    二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //判断树是否为空
        if (root == null) {
            return false;
        }

        //判断两棵树是否全等
        if (isSameTree(root, subRoot)) {
            return true;
        }
        //判断子树在左边
        if (isSubtree(root.left, subRoot)) {
            return true;
        }
        //判断子树在右边
        if (isSubtree(root.right, subRoot)) {
            return true;
        }
        //都不存在的情况下
        return false;

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //一棵树为空，另一棵树不为空
        if (p == null && q != null || p != null && q == null) {
            return false;
        }

        //两颗树都为空
        if (p == null && q == null) {
            return true;
        }

        //值不相等的情况
        if (p.val != q.val) {
            return false;
        }

        //判断左右子树是否相等
        return isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //获取高度
        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);

        //判断是否是平衡树
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //求高度
    public int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);
        //返回高度
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     */
    public boolean isSymmetric(TreeNode root) {
        //空树
        if (root == null) {
            return true;
        }
        //返回结果
        return judge(root.left, root.right);
    }

    private boolean judge(TreeNode p, TreeNode q) {
        //一边为空，一边不为空
        if (p == null && q != null || p != null && q == null) {
            return false;
        }

        //两边都为空
        if (p == null && q == null) {
            return true;
        }
        //值不相等
        if (p.val != q.val) {
            return false;
        }
        //判断对称的值是否相等
        return judge(p.left, q.right) && judge(p.right, q.left);
    }


    /**
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        //交换左右结点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        //指向下一个结点的值，直到把所有的结点翻转完
        invertTree(root.left);
        invertTree(root.right);
        //最后返回根节点
        return root;
    }
}
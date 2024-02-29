package data_structure.binary_tree;

// 测试二叉树代码
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        // 创建二叉树
        BinaryTree.TreeNode root = binaryTree.createBinaryTree();
        // 前序遍历
        System.out.println("前序遍历结果: ");
        binaryTree.preOrder(root);
        // 中序遍历
        System.out.println("\n中序遍历结果: ");
        binaryTree.inOrder(root);
        // 后序遍历
        System.out.println("\n后序遍历结果: ");
        binaryTree.postOrder(root);
        System.out.println();
        // 二叉树的节点个数
        binaryTree.size2(root);
        System.out.println(binaryTree.count);
        System.out.println(binaryTree.size(root));
        // 二叉树的叶子节点
        binaryTree.getLeafNodeSize2(root);
        System.out.println(binaryTree.leafSize);
        // 获取第k层的节点个数
        System.out.println(binaryTree.getKLevelNodeCount(root, 3));
        // 获取二叉树的高度
        System.out.println(binaryTree.getHeight(root));
        // 查找value值
        System.out.println(binaryTree.find(root, 4));
        // 二叉树的层序遍历
        binaryTree.levelOrder(root);
        System.out.println();
        // 判断一棵树是不是完全二叉树
        System.out.println(binaryTree.isCompleteTree(root));
        // 二叉树的前序非递归遍历
        binaryTree.preOrderNor(root);
        System.out.println();
        // 二叉树的中序非递归
        binaryTree.inOrderNor(root);
        System.out.println();
        // 二叉树的后序非递归
        binaryTree.postOrderNor(root);
    }
}

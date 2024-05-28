package ds.binary_tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createBinaryTree();

        // 前序遍历
        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.preOrderNor(root);
        System.out.println();

        // 中序遍历
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.inOrderNor(root);
        System.out.println();

        // 后序遍历
        binaryTree.postOrder(root);
        System.out.println();
        binaryTree.postOrderNor(root);
        System.out.println();

        // 节点数
        System.out.println(binaryTree.sizeOfCount(root));
        System.out.println(binaryTree.size(root));

        // 叶子节点数
        System.out.println(binaryTree.getLeafCount(root));
        System.out.println(binaryTree.getLeafSize(root));

        // 第k层节点个数
        System.out.println(binaryTree.getKLevelNodeCount(root, 3));
        System.out.println(binaryTree.getKLevelNodeCount(root, 1));
        System.out.println(binaryTree.getKLevelNodeCount(root, 2));

        // 树的高度
        System.out.println(binaryTree.getTreeHeight(root));

        // 查找val值
        System.out.println(binaryTree.contains(root, 11));
        System.out.println(binaryTree.contains(root, 9));
        System.out.println(binaryTree.contains(root, 15));
        System.out.println(binaryTree.contains(root, 1110));

        // 层序遍历
        binaryTree.levelOrder(root);
        System.out.println();

        // 判断是不是完全二叉树
        System.out.println(binaryTree.isCompleteTree(root));
    }
}

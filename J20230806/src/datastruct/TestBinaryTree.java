package datastruct;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        System.out.println("======");

        //测试前、中、后序遍历
        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.postOrder(root);

        //节点总数
        System.out.println();
        binaryTree.getSize(root);
        System.out.println(binaryTree.size);
        System.out.println(binaryTree.getSize2(root));

        //叶子节点
        binaryTree.getLeafNodeCount(root);
        System.out.println(binaryTree.leafSize);
        System.out.println(binaryTree.getLeafNodeCount2(root));

        //获取k层节点的个数
        System.out.println(binaryTree.getKLevelNodeCount(root, 3));
        System.out.println(binaryTree.getKLevelNodeCount(root, 1));
        System.out.println(binaryTree.getKLevelNodeCount(root, 2));
        System.out.println(binaryTree.getKLevelNodeCount(root, 4));

        //获取树的高度
        System.out.println(binaryTree.getHeight(root));

        //查找节点
        System.out.println(binaryTree.find(root, 8));

    }
}

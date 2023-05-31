package tree;


import java.util.List;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();

        //List<BinaryTree.TreeNode> list =  binaryTree.preOrder2(root);
        //System.out.println(list);
        System.out.println();
        binaryTree.postOrder(root);
        System.out.println(binaryTree.getLeafSize(root));

        System.out.println(binaryTree.getHeight(root));
    }
}

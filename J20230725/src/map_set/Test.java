package map_set;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        //插入测试
        binarySearchTree.insert(40);
        binarySearchTree.insert(30);
        binarySearchTree.insert(70);
        binarySearchTree.insert(20);
        binarySearchTree.insert(35);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        binarySearchTree.insert(1);

        //删除
        //binarySearchTree.remove(40);
        binarySearchTree.remove(20);

        System.out.println();
    }
}

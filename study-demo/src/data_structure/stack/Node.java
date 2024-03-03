package data_structure.stack;

public class Node {
    public Node next;
    public int val;

    public Node(int val) {
        this.val = val;
    }

    public static Node createNode() {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node;
    }
}

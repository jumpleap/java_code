package linkedlist;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.display();

        myLinkedList.addIndex(0, 99);
        myLinkedList.display();
        myLinkedList.addIndex(5, 100);
        myLinkedList.display();
        myLinkedList.addIndex(2, 200);
        myLinkedList.display();
    }
}

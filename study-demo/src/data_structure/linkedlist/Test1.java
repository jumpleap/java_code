package data_structure.linkedlist;

public class Test1 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.display();

        linkedList.addLast(0);
        linkedList.addLast(4);
        linkedList.display();

        linkedList.addIndex(0, 111);
        linkedList.addIndex(6, 112);
        linkedList.display();
        linkedList.addIndex(3, 222);
        linkedList.display();

        System.out.println(linkedList.contains(1));
        System.out.println(linkedList.contains(111));
        System.out.println(linkedList.contains(112));
        System.out.println(linkedList.contains(333));

        linkedList.remove(111);
        linkedList.remove(112);
        linkedList.remove(0);
        linkedList.display();


        MyLinkedList list = new MyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.display();
        list.removeAllKey(1);
        list.display();



    }
}

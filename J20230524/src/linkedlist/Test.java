package linkedlist;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        /*myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.display();

        System.out.println(myLinkedList.contains(3));
        System.out.println(myLinkedList.contains(1));
        System.out.println(myLinkedList.contains(4));
        System.out.println(myLinkedList.contains(7));

        System.out.println(myLinkedList.size());*/

        myLinkedList.addLast(44);
        myLinkedList.addLast(44);
        myLinkedList.addLast(66);
        myLinkedList.addLast(78);
        myLinkedList.addLast(12);
        myLinkedList.addLast(12);
        myLinkedList.addLast(12);
        myLinkedList.addLast(12);
        myLinkedList.addLast(12);
        myLinkedList.display();
        myLinkedList.removeAllKey(44);
        myLinkedList.removeAllKey(12);
        myLinkedList.display();
        //myLinkedList.clear();

//        myLinkedList.addIndex(2,1);
//        myLinkedList.display();
//
//        myLinkedList.remove(44);
//        myLinkedList.display();
//
//        myLinkedList.remove(12);
//        myLinkedList.display();
//
//        myLinkedList.remove(1);
//        myLinkedList.display();
    }
}
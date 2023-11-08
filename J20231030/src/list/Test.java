package list;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.display();
        System.out.println(myLinkedList.size());

        myLinkedList.addLast(5);
        myLinkedList.addLast(6);
        myLinkedList.addLast(7);
        myLinkedList.display();
        System.out.println(myLinkedList.size());

        myLinkedList.addIndex(0, 111);
        myLinkedList.display();
        myLinkedList.addIndex(8, 222);
        myLinkedList.display();
        myLinkedList.addIndex(3,333);
        myLinkedList.display();
        myLinkedList.addIndex(1,444);
        myLinkedList.display();


        myLinkedList.remove(111);
        myLinkedList.display();
        myLinkedList.remove(222);
        myLinkedList.display();
        myLinkedList.remove(333);
        myLinkedList.display();

        myLinkedList.addLast(111);
        myLinkedList.addLast(111);
        myLinkedList.addLast(111);
        myLinkedList.addFirst(111);
        myLinkedList.addFirst(111);
        myLinkedList.addFirst(111);
        myLinkedList.addFirst(111);
        myLinkedList.addIndex(6,111);
        myLinkedList.display();

        myLinkedList.removeAllKey(111);
        myLinkedList.display();

        System.out.println(myLinkedList.getNode(1));
        System.out.println(myLinkedList.getNode(0));
        System.out.println(myLinkedList.getNode(7));
        //System.out.println(myLinkedList.getNode(8));
    }
}

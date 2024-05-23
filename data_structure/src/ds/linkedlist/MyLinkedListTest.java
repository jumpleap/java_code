package ds.linkedlist;

import java.util.Random;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        Random random = new Random();

        for(int i = 0; i < 10; i++) {
            list.headInsert(i);
        }
        list.display();

        for (int i = 10; i < 20; i++) {
            list.tailInsert(i);
        }
        list.display();

        list.randomInsert(0,1112);
        list.randomInsert(21, 1112);
        list.display();
        list.randomInsert(3,1111);
        list.display();

        list.removeOfVal(1);
        list.removeOfVal(1112);
        list.removeOfVal(1111);
        list.removeOfVal(1112);
        list.removeOfVal(0);
        list.display();

        MyLinkedList list1 = new MyLinkedList();
        list1.headInsert(1);
        list1.headInsert(1);
        list1.headInsert(1);
        list1.headInsert(1);
        list1.headInsert(1);
        list1.headInsert(1);
        list1.display();
        list1.remove(1);
        list1.display();

        System.out.println(list1.size());

        System.out.println(list1.isEmpty());

        System.out.println(list1.contains(1));
    }
}

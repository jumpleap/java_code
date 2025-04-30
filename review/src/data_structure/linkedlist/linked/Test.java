package data_structure.linkedlist.linked;

/**
 * @Author 林沐雨
 * @Date 2025/4/30
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.headInsert(5);
        list.headInsert(4);
        list.headInsert(3);
        list.headInsert(2);
        list.headInsert(1);
        list.display();

        list.tailInsert(6);
        list.tailInsert(7);
        list.tailInsert(8);
        list.tailInsert(9);
        list.tailInsert(10);
        list.display();

        list.insert(0, 0);
        list.insert(11, 11);
        list.insert(6, 111);
        list.display();

        System.out.println(list.contains(0));
        System.out.println(list.contains(11));
        System.out.println(list.contains(5));
        System.out.println(list.contains(1111));

        list.remove(0);
        list.remove(11);
        list.remove(111);
        list.display();
        System.out.println(list.size());

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.tailInsert(2);
        linkedList.tailInsert(1);
        linkedList.tailInsert(1);
        linkedList.tailInsert(2);
        linkedList.tailInsert(1);
        linkedList.tailInsert(1);
        linkedList.tailInsert(1);
        linkedList.tailInsert(1);
        linkedList.tailInsert(1);
        linkedList.removeAllVal(1);
        linkedList.display();
        linkedList.clear();
    }
}

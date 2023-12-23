package data_structure.linkedlist.singlelist;

// 测试自定义单链表
public class Test {
    public static void main(String[] args) {
        MySingleList list = new MySingleList();
        list.insertHead(4);
        list.insertHead(3);
        list.insertHead(2);
        list.insertHead(1);
        list.display();

        list.insertTail(5);
        list.insertTail(6);
        list.insertTail(7);
        list.display();

        list.insertRandom(0, 100);
        list.display();
        list.insertRandom(8, 1000);
        list.display();
        list.remove(100);
        list.display();

        list.insertTail(1);
        list.insertTail(1);
        list.insertTail(1);
        list.insertTail(1);
        list.display();
        list.removeAllKey(1);
        list.display();

        System.out.println(list.contains(1000));
    }
}
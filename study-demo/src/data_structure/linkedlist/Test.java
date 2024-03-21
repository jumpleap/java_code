package data_structure.linkedlist;

public class Test {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        // 头插法
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(4);
        singleLinkedList.addFirst(5);
        singleLinkedList.addFirst(6);
        singleLinkedList.display();

        // 尾插法
        singleLinkedList.addLast(0);
        singleLinkedList.addLast(111);
        singleLinkedList.display();

        // 任意位置插入
        singleLinkedList.addIndex(0, 11);
        singleLinkedList.addIndex(1, 12);
        //singleLinkedList.addIndex(5, 123);
        singleLinkedList.addIndex(10, 123);
        singleLinkedList.display();

        // 判断是否含有某个值
        System.out.println(singleLinkedList.contains(11));
        System.out.println(singleLinkedList.contains(123));
        System.out.println(singleLinkedList.contains(13));

        // 删除
        singleLinkedList.remove(11);
        singleLinkedList.display();
        singleLinkedList.remove(123);
        singleLinkedList.display();
        singleLinkedList.remove(0);
        singleLinkedList.display();

        // 删除所有相同的节点
        singleLinkedList.addIndex(1, 3);
        singleLinkedList.addIndex(4, 3);
        singleLinkedList.addIndex(7, 3);
        singleLinkedList.addIndex(0, 3);
        singleLinkedList.display();

        singleLinkedList.removeAllKey(3);
        singleLinkedList.display();

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.addFirst(1);
        singleLinkedList1.addFirst(1);
        singleLinkedList1.addFirst(1);
        singleLinkedList1.addFirst(1);
        singleLinkedList1.addFirst(1);
        singleLinkedList1.addFirst(1);
        singleLinkedList1.addFirst(1);
        singleLinkedList1.addFirst(1);
        singleLinkedList1.display();

        singleLinkedList1.removeAllKey(1);
        singleLinkedList1.display();
    }
}

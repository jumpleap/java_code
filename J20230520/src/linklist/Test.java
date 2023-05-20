package linklist;

public class Test {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.creatList();
        singleLinkedList.display();
        singleLinkedList.addFirst(55);
        singleLinkedList.addFirst(56);
        singleLinkedList.display();
        singleLinkedList.addLast(13);
        singleLinkedList.addLast(14);
        singleLinkedList.addLast(15);
        singleLinkedList.display();

        singleLinkedList.addIndex(0, 456);
        singleLinkedList.addIndex(11, 555);
        singleLinkedList.addIndex(2, 444);
        singleLinkedList.display();

        System.out.println(singleLinkedList.contains(444));
        System.out.println(singleLinkedList.contains(456));
        System.out.println(singleLinkedList.contains(555));
        System.out.println(singleLinkedList.contains(55));
        System.out.println(singleLinkedList.contains(78));

        singleLinkedList.remove(456);
        singleLinkedList.remove(555);
        singleLinkedList.remove(123);
        singleLinkedList.remove(13);
        singleLinkedList.display();

        System.out.println("===============================");
        singleLinkedList.addLast(12);
        singleLinkedList.addLast(12);
        singleLinkedList.addLast(12);
        singleLinkedList.addLast(12);
        singleLinkedList.addIndex(1, 12);
        singleLinkedList.addIndex(0, 12);
        singleLinkedList.addIndex(5, 12);
        singleLinkedList.addIndex(6, 12);
        singleLinkedList.display();

        singleLinkedList.removeAllKey(12);
        singleLinkedList.display();

        singleLinkedList.clear();
    }
}

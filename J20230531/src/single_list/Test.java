package single_list;

public class Test {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addFirst(1);
        singleList.addFirst(2);
        singleList.addFirst(3);
        singleList.addFirst(4);
        singleList.addFirst(4);

        singleList.display();
        System.out.println("=================");

        singleList.addLast(6);
        singleList.addLast(7);
        singleList.addLast(8);
        singleList.display();


        System.out.println("=================");
        singleList.addIndex(0,12);
        singleList.display();
        singleList.addIndex(0,13);
        singleList.display();

        singleList.addIndex(10,111);
        singleList.display();
        singleList.addIndex(11,123);
        singleList.display();

        singleList.addIndex(11,134);
        singleList.display();

        System.out.println(singleList.contains(13));
        System.out.println(singleList.contains(123));
        System.out.println(singleList.contains(4));
        System.out.println(singleList.contains(14));

        singleList.remove(13);
        singleList.remove(123);
        singleList.remove(134);
        singleList.remove(1);
        singleList.display();

        singleList.removeAllKey(4);
        singleList.display();

        SingleList singleList1 = new SingleList();
        singleList1.addLast(1);
        singleList1.addLast(1);
        singleList1.addLast(1);
        singleList1.addLast(1);
        singleList1.addLast(1);
        singleList1.addLast(1);
        singleList1.addLast(1);
        singleList1.addLast(1);
        singleList1.display();

        singleList1.removeAllKey(1);

        singleList1.display();
    }
}
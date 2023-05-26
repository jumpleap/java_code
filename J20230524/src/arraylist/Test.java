package arraylist;

public class Test {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.display();

        System.out.println("===========");
        myArrayList.add(0, 222);
        myArrayList.add(1, 333);
        myArrayList.add(2, 666);
        myArrayList.display();

        System.out.println(myArrayList.contains(2));
        System.out.println(myArrayList.contains(222));
        System.out.println(myArrayList.contains(333));
        System.out.println(myArrayList.contains(33));

        System.out.println(myArrayList.indexOf(222));
        System.out.println(myArrayList.indexOf(4));

        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.get(2));

        System.out.println(myArrayList.isEmpty());
        myArrayList.set(0, 666);
        myArrayList.set(6, 333);
        myArrayList.set(2, 123);
        myArrayList.set(5, 123);
        myArrayList.display();
        System.out.println(myArrayList.size());

        System.out.println("======================");
        myArrayList.remove(666);
        myArrayList.remove(333);
        myArrayList.remove(333);
        myArrayList.display();

        MyArrayList myArrayList1 = new MyArrayList();
        myArrayList1.add(1);
        myArrayList1.add(1);
        myArrayList1.add(1);
        myArrayList1.add(1);
        myArrayList1.add(1);
        myArrayList1.display();

        myArrayList1.remove(1);
        myArrayList1.remove(1);
        myArrayList1.remove(1);
        myArrayList1.remove(1);
        myArrayList1.remove(1);
        myArrayList1.display();
        myArrayList1.remove(1);
    }
}
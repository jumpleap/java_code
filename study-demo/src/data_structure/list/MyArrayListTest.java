package data_structure.list;

// 测试自定义顺序表
public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.display();

        list.add(0, 0);
        list.display();
        list.add(13, 13);
        list.display();
        list.add(7, 123);
        list.display();
        // list.add(-1, 0);
        list.add(15, 15);
        list.display();

        System.out.println(list.contains(0));
        System.out.println(list.contains(15));

        System.out.println(list.indexOf(0));
        System.out.println(list.indexOf(15));
        System.out.println(list.indexOf(-1));

        System.out.println(list.size());

        list.remove(0);
        list.display();
        list.remove(15);
        list.display();
        System.out.println(list.size());

        System.out.println(list.get(1));
        list.set(10, 100);
        list.display();

        list.clear();
    }
}

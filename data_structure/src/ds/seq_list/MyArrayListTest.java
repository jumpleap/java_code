package ds.seq_list;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.display();

        list.add(0, 111);
        list.add(3, 112);
        list.add(2, 114);
        list.display();

        list.removeOfElement(1);
        list.removeOfElement(111);
        list.removeOfElement(3);
        list.display();

        list.removeOfIndex(0);
        list.removeOfIndex(1);
        list.display();
        list.removeOfIndex(0);
        list.display();

        list.add(1);
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(3);
        list.display();
        list.remove(1);
        list.display();

        list.add(2);
        list.add(0);
        list.add(2);
        list.display();
        System.out.println(list.indexOf(2));
        System.out.println(list.lastIndexOf(0));

        System.out.println(list.contains(9));
        System.out.println(list.contains(2));

        System.out.println(list.isEmpty());

        System.out.println(list.size());

        System.out.println(list.get(0));
        list.set(0, 111);
        list.display();
    }
}

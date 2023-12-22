package data_structure.array;

public class Test {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.display();

        list.insert(0, 23);
        list.insert(7, 23);
        list.insert(3, 23);
        list.display();

        list.remove(1);
        list.display();
        list.remove(6);
        list.display();
        list.remove(3);
        list.display();

        System.out.println(list.contains(23));
        System.out.println(list.indexOf(2));
    }
}

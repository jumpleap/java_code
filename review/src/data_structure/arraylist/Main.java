package data_structure.arraylist;

/**
 * @Author 林沐雨
 * @Date 2025/4/17
 * @Description 测试顺序表
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();

        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(9);
        myArrayList.add(10);
        myArrayList.add(11);
        myArrayList.display();

        myArrayList.add(0, 0);
        myArrayList.add(12,12);
        myArrayList.display();

        myArrayList.remove(0);
        myArrayList.remove(12);
        myArrayList.remove(12);
        myArrayList.display();

        myArrayList.set(10, 111);
        myArrayList.set(6, 111);
        myArrayList.set(0, 111);
        myArrayList.display();

        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.get(10));

        System.out.println(myArrayList.indexOf(111));
        System.out.println(myArrayList.lastIndexOf(111));

        System.out.println(myArrayList.contains(1111));
        System.out.println(myArrayList.contains(111));
    }
}

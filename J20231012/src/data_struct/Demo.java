package data_struct;

public class Demo {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(10);
        myArrayList.add(11);
        myArrayList.add(12);
        myArrayList.add(13);

        myArrayList.add(0,1);
        myArrayList.add(3,1);
        myArrayList.add(6,1);
        System.out.println(myArrayList.contains(10));
        System.out.println(myArrayList.contains(99));

        System.out.println(myArrayList.indexOf(1));
        System.out.println(myArrayList.indexOf(10));
        System.out.println(myArrayList.indexOf(100));

        System.out.println(myArrayList.get(0));
        //System.out.println(myArrayList.get(10));

        System.out.println(myArrayList.isEmpty());
        myArrayList.set(2,1111);

        myArrayList.remove(1);
        myArrayList.remove(1);
        myArrayList.remove(1);
        myArrayList.set(3, 11011);
        System.out.println(myArrayList.size());
        //myArrayList.add(12,1);
        myArrayList.display();
    }
}

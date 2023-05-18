package arraylist;

public class Test {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        //myArrayList.display();

        //myArrayList.add(1,2);
        //myArrayList.add(0,3);
        myArrayList.add(3,5);
        System.out.println(myArrayList.contains(5));
        System.out.println(myArrayList.contains(2));
        System.out.println(myArrayList.contains(1));
        System.out.println(myArrayList.contains(6));
        myArrayList.remove(1);
        System.out.println(myArrayList.indexOf(2));

        System.out.println(myArrayList.get(3));
        myArrayList.set(1,123);
        System.out.println(myArrayList.isEmpty());
        myArrayList.display();

    }
}

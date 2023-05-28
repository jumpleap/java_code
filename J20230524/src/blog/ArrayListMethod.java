package blog;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListMethod {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
    }
}

class Demo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);

        //迭代器遍历
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object ret = iterator.next();
            System.out.print(ret + " ");
        }

        //for - each 循环
        for (Integer ret : arrayList) {
            System.out.print(ret + " ");
        }
    }
}


package ds.linkedlist;

import java.util.Random;

public class MySingleListTest {
    public static void main(String[] args) {
        MySingleList singleList = new MySingleList();
        Random random = new Random();
        singleList.headInsert(1);
        singleList.headInsert(2);
        singleList.headInsert(3);
        singleList.display();

        singleList.tailInsert(4);
        singleList.tailInsert(5);
        singleList.tailInsert(6);
        singleList.display();

//        for (int i = 7; i < 20; i++) {
//            int index = random.nextInt(7) + 1;
//            int data = random.nextInt(100);
//            singleList.insert(index, data);
//        }
        singleList.insert(0, 111);
        singleList.insert(7, 112);
        singleList.insert(3, 114);
        singleList.insert(3, 114);
        singleList.display();

        singleList.removeOfData(111);
        singleList.display();
        singleList.removeOfData(112);
        singleList.display();
        singleList.removeOfData(114);
        singleList.display();

        singleList.tailInsert(111);
        singleList.tailInsert(111);
        singleList.tailInsert(111);
        singleList.tailInsert(111);
        singleList.tailInsert(111);
        singleList.tailInsert(111);
        singleList.headInsert(111);
        singleList.headInsert(111);
        singleList.headInsert(111);
        singleList.headInsert(111);
        singleList.display();
        singleList.remove(111);
        singleList.display();

        MySingleList list = new MySingleList();
        list.headInsert(1);
        list.headInsert(1);
        list.headInsert(1);
        list.headInsert(2);
        list.headInsert(1);
        list.headInsert(1);
        list.display();
        list.remove(1);
        list.display();

        System.out.println(list.contains(2));

        System.out.println(list.isEmpty());

        System.out.println(list.size());
        list.clear();
    }
}

package data_structure.linkedlist.single;

/**
 * @Author 林沐雨
 * @Date 2025/4/29
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        MySingleList singleList = new MySingleList();
        singleList.tailInsert(0);
        singleList.headInsert(1);
        singleList.headInsert(2);
        singleList.headInsert(3);
        singleList.headInsert(4);
        singleList.headInsert(5);
        singleList.display();
        singleList.tailInsert(7);
        singleList.tailInsert(8);
        singleList.tailInsert(9);
        singleList.display();

        singleList.insert(0, 111);
//        singleList.insert(10, 111);
//        singleList.insert(3,111);
//        singleList.insert(8,111);
        singleList.insert(10,111);
        singleList.display();

        System.out.println(singleList.contains(0));
        System.out.println(singleList.contains(111));
        System.out.println(singleList.contains(1111));
        singleList.remove(111);
        singleList.remove(4);
        singleList.remove(9);
        singleList.remove(0);
        singleList.remove(111);
        singleList.display();

        MySingleList list = new MySingleList();
        list.tailInsert(1);
        list.tailInsert(0);
        list.tailInsert(0);
        list.tailInsert(0);
        list.tailInsert(0);
        list.tailInsert(0);
        list.tailInsert(2);
        list.tailInsert(1);
        list.removeOfVal(1);
        list.display();

        singleList.clear();
    }
}

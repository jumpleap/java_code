package data_structure.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 双向链表的使用
public class Demo {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        // 构造
        List<Integer> list1 = new ArrayList<>(list);
        System.out.println(list1);

        // 方法使用
        // add
        list.add(4);
        list.add(1,5);
        list.addAll(list1);
        System.out.println(list);

        // remove
        list.remove(6);
        list.remove(new Integer(3));
        list.removeAll(list1);
        System.out.println(list);

        // get, set, contains
        System.out.println(list.get(0));
        list.set(1, 111);
        System.out.println(list.contains(111));

        // indexOf, LastIndexOf
        System.out.println(list.indexOf(4));
        System.out.println(list.lastIndexOf(5));

        // subList
        List<Integer> list2 = list.subList(0, 1);
        System.out.println(list2);
    }
}

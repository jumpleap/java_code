package data_structure.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // 构造一个空的LinkedList
        // List<String> list1 = new LinkedList<>();
        List<String> list2 = new java.util.ArrayList<>();
        // list1.add("JavaSE");
        // list1.add("JavaWeb");
        // list1.add("JavaEE");

        for (String s : list2) {
            System.out.println(s);
        }
        // 使用ArrayList构造LinkedList
        List<String> list3 = new LinkedList<>(list2);
    }
}

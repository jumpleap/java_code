package practice;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(10);
        list.add(124);
        list.add(174);
        list.add(112);
        list.add(56);
        System.out.println(list);


        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if(num % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }
}
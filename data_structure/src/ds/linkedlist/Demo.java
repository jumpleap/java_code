package ds.linkedlist;

import java.util.LinkedList;
import java.util.List;

// 双向链表的使用
public class Demo {
    public static void main(String[] args) {
        // 初始化双向链表
        List<Integer> list = new LinkedList<>();

        // 添加
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(0,111);
        list.add(4,112);
        System.out.println(list);

        // 删除
        list.remove(new Integer(1));
        list.remove(1);
        System.out.println(list);

        // 查找
        System.out.println(list.contains(2));
        System.out.println(list.contains(112));

        // 获取下标的值
        System.out.println(list.get(1));

        // 更新
        list.set(1, 111);

        // 查找
        System.out.println(list.indexOf(1));
        System.out.println(list.lastIndexOf(112));
    }
}

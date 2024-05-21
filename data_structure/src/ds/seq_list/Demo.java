package ds.seq_list;

import java.util.ArrayList;
import java.util.List;

// 顺序表的使用
public class Demo {
    public static void main(String[] args) {
        // 初始化顺序表
        List<Integer> list = new ArrayList<>();

        // 添加数据
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1,2);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);

        // 删除数据
        list.remove(1);
        list.remove(new Integer(1));
        System.out.println(list);

        // 更新数据
        list.set(0, 111);
        System.out.println(list);

        // 获取元素在顺序表中第一次出现的位置
        System.out.println(list.indexOf(4));
        System.out.println(list.indexOf(1));

        // 获取元素在顺序表中最后一次出现的位置
        System.out.println(list.lastIndexOf(4));
        System.out.println(list.lastIndexOf(5));

        // 获取顺序表的长度
        System.out.println(list.size());

        // 判断顺序表是否为空
        System.out.println(list.isEmpty());

        // 判断某个元素是否在顺序表中存在
        System.out.println(list.contains(111));
        System.out.println(list.contains(112));

        // 获取给定下标的元素值
        System.out.println(list.get(1));
        System.out.println(list.get(3));
    }
}

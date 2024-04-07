package data_structure.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 顺序表的常用方法
public class Demo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        // 添加元素
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList);
        arrayList.add(1, 12);
        System.out.println(arrayList);

        // 顺序表长度
        System.out.println(arrayList.size());

        // 是否包含某个元素
        System.out.println(arrayList.contains(12));

        // 该元素第一次出现的下标
        System.out.println(arrayList.indexOf(1));

        // 该元素最后一次出现的下标
        System.out.println(arrayList.lastIndexOf(2));

        // 更新index处的值
        arrayList.set(0, 123);

        // 获取index处的值
        System.out.println(arrayList.get(0));

        // 根据index或值删除元素
        System.out.println(arrayList.remove(1));
        arrayList.remove(new Integer(2));
        System.out.println(arrayList);

        // 截取部分list
        List<Integer> list = arrayList.subList(0, 2);
        System.out.println(list);

        // 把list集合的元素添加到arrayList中去
        arrayList.addAll(list);
        System.out.println(arrayList);

        // ArrayList的遍历方法
        // 常规for循环
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();

        // 增强for循环
        for (int num : arrayList) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 迭代器
        // 创建迭代器
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            // 获取元素
            int num = iterator.next();
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

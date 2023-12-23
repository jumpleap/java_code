package data_structure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// 顺序表的API使用
public class ArrayListSAPi {
    public static void main(String[] args) {
        // 定义顺序表
        List<Integer> list = new ArrayList<>();

        // 添加元素
        list.add(1);
        list.add(0, 2);
        // 使用数组
        Integer[] nums = {1, 2, 3, 4, 5};
        List<Integer> list1 = Arrays.asList(nums);
        list.addAll(list1);
        // 遍历查看
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();


        //删除
        list.remove(1);
        // 需要使用包装类
        list.remove(new Integer(3));
        // 遍历查看
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        // contains
        System.out.println(list.contains(1));

        // get
        System.out.println(list.get(1));

        // indexOf
        System.out.println(list.indexOf(1));

        // lastIndexOf
        System.out.println(list.lastIndexOf(3));

        List<Integer> list2 = list.subList(0, 4);


        // 遍历方法
        // 1.for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // 2.加强for循环
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 3. Iterator遍历
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}

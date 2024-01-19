package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo4 {
    public static void main(String[] args) {
        // 数组接受多个参数
        int[] arr = func();
        System.out.println(Arrays.toString(arr));//[1, 2, 3, 4, 5]

        // 集合接受多个参数
        List<Integer> list = func1();
        for (int num : list) {
            System.out.print(num + " ");
        }
    }

    /**
     * 使用数组返回多个数据
     */
    private static int[] func() {
        return new int[]{1, 2, 3, 4, 5};
    }


    private static List<Integer> func1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        return list;
    }
}

package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Arrays常用的方法汇总
 */
public class Demo {
    public static void main(String[] args) {
        int[] array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] array1 = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        //给数组进行排序
        Arrays.sort(array);

        //输出排序后的结果
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println(Arrays.binarySearch(array, 3));
        System.out.println(Arrays.equals(array1,array));

        int[] ans = new int[10];
        Arrays.fill(ans,10);
        System.out.println(Arrays.toString(ans));

        Arrays.fill(ans,4,7,3);
        System.out.println(Arrays.toString(ans));

        List<int[]> list = new ArrayList<>();
        list = Arrays.asList(ans);
        System.out.println(list);
    }
}

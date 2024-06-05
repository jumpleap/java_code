package ds.sort;

import java.util.Arrays;

public class SimpleSortTest {
    static SimpleSort sort = new SimpleSort();

    public static void main(String[] args) {

        int[] arr = sort.getArray();
        System.out.println(Arrays.toString(arr));

        // 插入排序
        //test1(arr);

        // 冒泡排序
        //test2(arr);

        // 希尔排序
        //test3(arr);

        // 选择排序
        //test4(arr);

        // 计数排序
        //test5(arr);

        // 堆排序
        test6(arr);
    }

    // 堆排序
    private static void test6(int[] arr) {
        sort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 计数排序
    private static void test5(int[] arr) {
        sort.countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 选择排序
    private static void test4(int[] arr) {
        sort.selectInsert(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 希尔排序
    private static void test3(int[] arr) {
        sort.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 冒泡排序
    private static void test2(int[] arr) {
        sort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 插入排序
    public static void test1(int[] arr) {
        sort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

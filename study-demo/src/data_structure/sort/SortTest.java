package data_structure.sort;

import java.util.Arrays;

// 排序算法测试
public class SortTest {
    private final static Sort sort = new Sort();

    public static void main(String[] args) {
        test();
        test1();
        test2();
        test3();
    }

    /**
     * 选择排序测试
     */
    private static void test3() {
        // 获取数组
        int[] array = getArray();
        // 选择排序
        sort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序测试
     */
    private static void test2() {
        // 获取数组
        int[] array = getArray();
        // 选择排序
        sort.selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 希尔排序测试
     */
    private static void test1() {
        // 获取数组
        int[] array = getArray();
        // 希尔排序
        sort.shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 插入排序测试
     */
    private static void test() {
        // 获取数组
        int[] array = getArray();
        // 插入排序
        sort.insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 封装创建数组代码
     */
    public static int[] getArray() {
        int[] array = sort.createArray();
        System.out.println(Arrays.toString(array));
        return array;
    }
}

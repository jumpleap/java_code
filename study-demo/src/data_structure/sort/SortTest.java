package data_structure.sort;

import java.util.Arrays;
import java.util.Random;

// 排序算法测试
public class SortTest {
    private final static Sort sort = new Sort();

    public static void main(String[] args) {
//        test();
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
        test9();
    }

    /**
     * 计数排序测试
     */
    private static void test9() {
        // 获取数组
        int[] array = getArray();
        // 选择排序
        sort.countSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 归并排序非递归实现
     */
    private static void test8() {
        // 获取数组
        int[] array = getArray();
        // 选择排序
        sort.mergeSortNor(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 归并排序测试
     */
    private static void test7() {
        // 获取数组
        int[] array = getArray();
        // 选择排序
        sort.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 快速排序非递归测试
     */
    private static void test6() {
        // 获取数组
        int[] array = getArray();
        // 选择排序
        sort.quickSortNor(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 快速排序测试
     */
    private static void test5() {
        // 获取数组
        int[] array = getArray();
        // 选择排序
        sort.quickSort(array);
        System.out.println(Arrays.toString(array));
    }


    /**
     * 堆排序测试
     */
    private static void test4() {
        // 获取数组
        int[] array = getArray();
        // 选择排序
        sort.heapSort(array);
        System.out.println(Arrays.toString(array));
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
        int[] array = createArray();
        System.out.println(Arrays.toString(array));
        return array;
    }

    /**
     * 创建一个数组
     */
    public static int[] createArray() {
        // 为了设置随机数
        Random random = new Random();
        // 初始化数组
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            // 给数组中值进行赋值
            array[i] = random.nextInt(100);
        }
        // 返回
        return array;
    }
}

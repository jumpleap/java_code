package sort;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] array = {3,1,2,12,4,15,657,152,13};
        //Sort.insertSort(array);
        //Sort.shellSort(array);
        //Sort.shellSort(array);
        //Sort.heapSort(array);
        //Sort.bubbleSort(array);
        Sort.quickSort(array);

        System.out.println(Arrays.toString(array));

        /* 测试插入排序 */
        testInsertSort();

        /* 测试希尔排序 */
        testShellSort();

        /* 测试选择排序 */
        testSelectSort();

        testHeapSort();
        testQuickSort();
    }

    /**
     * 测试快速排序效率
     */
    public static void testQuickSort() {
        int[] array = new int[100000];
        test1(array);
        //test3(array);
        long start = System.currentTimeMillis();
        Sort.quickSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 测试堆排序效率
     */
    public static void testHeapSort() {
        int[] array = new int[100000];
        test1(array);
        //test3(array);
        long start = System.currentTimeMillis();
        Sort.heapSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 测试选择排序效率
     */
    public static void testSelectSort() {
        int[] array = new int[100000];
        test1(array);
        //test3(array);
        long start = System.currentTimeMillis();
        Sort.selectSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 希尔排序效率测试
     */
    public static void testShellSort() {
        int[] array = new int[100000];
        test1(array);
        //test3(array);
        long start = System.currentTimeMillis();
        Sort.shellSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 插入排序效率测试
     */
    public static void testInsertSort() {
        int[] array = new int[100000];
        //test1(array);
        test3(array);
        long start = System.currentTimeMillis();
        Sort.insertSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    //测试时间案例1
    public static void test1(int[] array) {
        for (int i = 0; i < 100000; i++) {
            array[i] = array.length - i;
        }
    }

    //测试时间案例2
    public static void test2(int[] array) {
        for (int i = 0; i < 100000; i++) {
            array[i] = i;
        }
    }

    //测试时间案例3
    public static void test3(int[] array) {
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            array[i] = random.nextInt(100000);
        }
    }
}
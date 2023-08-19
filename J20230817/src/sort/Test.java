package sort;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] ans = {13, 2, 45, 3, 67, 123, 1, 25};
        //Sort.insertSort(ans);
        //Sort.shellSort(ans);
        Sort.bubbleSort(ans);
        System.out.println(Arrays.toString(ans));


        //testInsertSort();
        //testShellSort();
        //testSelectSort();
        //testHeapSort();
        testBubbleSort();

    }

    //测试冒泡排序
    public static void testBubbleSort() {
        int[] arr = new int[100000];
        //orderNumber(arr);
        //notOrderNumber(arr);
        notOrderNumberRandom(arr);
        long begin = System.currentTimeMillis();
        Sort.bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序的时间：" + (end - begin) + "ms");
    }

    //选择排序测试
    public static void testHeapSort() {
        int[] arr = new int[100000];
        //orderNumber(arr);
        //notOrderNumber(arr);
        notOrderNumberRandom(arr);
        long begin = System.currentTimeMillis();
        Sort.heapSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("选择排序的时间：" + (end - begin) + "ms");
    }

    //选择排序测试
    public static void testSelectSort() {
        int[] arr = new int[100000];
        //orderNumber(arr);
        //notOrderNumber(arr);
        notOrderNumberRandom(arr);
        long begin = System.currentTimeMillis();
        Sort.selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("选择排序的时间：" + (end - begin) + "ms");
    }

    //希尔排序测试
    public static void testShellSort() {
        int[] arr = new int[100000];
        //orderNumber(arr);
        //notOrderNumber(arr);
        notOrderNumberRandom(arr);
        long begin = System.currentTimeMillis();
        Sort.shellSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("希尔排序的时间：" + (end - begin) + "ms");
    }

    //插入排序测试
    public static void testInsertSort() {
        int[] arr = new int[100000];
        //orderNumber(arr);
        //notOrderNumber(arr);
        notOrderNumberRandom(arr);
        long begin = System.currentTimeMillis();
        Sort.insertSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("插入排序的时间：" + (end - begin) + "ms");
    }

    public static void orderNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    public static void notOrderNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
    }

    public static void notOrderNumberRandom(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
        }
    }
}
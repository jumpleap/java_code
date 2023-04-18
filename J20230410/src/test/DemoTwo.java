package test;

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings({"all"})

public class DemoTwo {
    public static void main(String[] args) {
        //冒泡排序
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSort(array);//ctrl + f8打断点
        System.out.println(Arrays.toString(array));
    }

    //冒泡排序
    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;//优化
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j+1]) {
                    flag = false;//若为false这一趟还是无序的
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
            if(flag) {
                break;//这一趟已经有序
            }
        }
    }

    public static void main8(String[] args) {
        //二分查找
        Scanner scanner = new Scanner(System.in);
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("请输入你要查找的值：");
        int val = scanner.nextInt();

        int index = binarySearch(array, val);
        if (-1 == index) {
            System.out.println("找不到~");
        } else {
            System.out.println("找到了，下标是：" + index);
        }

        //Java自己提供的二分查找
        int[] arr = {1, 3, 2, 5, 4, 7, 6, 9, 8, 10};
        //使用sort排序
        Arrays.sort(arr);//底层是快速排序
        System.out.println(Arrays.binarySearch(arr, 3));//2
        System.out.println(Arrays.binarySearch(arr, 11));//-11
        //源码中：return -(low + 1);  // key not found.
    }

    //二分查找
    private static int binarySearch(int[] array, int val) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;//中间值
            //判断
            if (array[mid] > val) {//在左边
                right = mid - 1;
            } else if (array[mid] < val) {//在右边
                left = mid + 1;
            } else {
                return mid;//找到了
            }
        }
        return -1;
    }

    public static void main7(String[] args) {
        //顺序查找
        Scanner scanner = new Scanner(System.in);
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("请输入你要查找的值：");
        int val = scanner.nextInt();

        int ret = findVal(array, val);
        if (ret == -1) {
            System.out.println("找不到~");
        } else {
            System.out.println("找到了，下标是：" + ret);
        }
    }

    //顺序查找
    private static int findVal(int[] array, int val) {
        for (int i = 0; i < array.length; i++) {
            //找到了
            if (val == array[i]) {
                return i;
            }
        }
        return -1;//找不到
    }

    public static void main6(String[] args) {
        //使用库函数进行数组的拷贝
        int[] array = {1, 2, 3, 4, 5};
        int[] copy = new int[array.length];
        //使用Arrays.copyOf()方法进行数组拷贝
        copy = Arrays.copyOf(array, array.length * 2);//把整个array数组拷贝到copy中
        //使用的长度相当于为copy数组进行扩容了，底层源码：int[] copy = new int[newLength];
        System.out.println(Arrays.toString(copy));
        //按范围进行拷贝数据
        int[] arr = Arrays.copyOfRange(array, 1, 3);//拷贝[1,3)中的数据
        System.out.println(Arrays.toString(arr));

        //Arrays.copyOf()底层使用的拷贝源码是：
        // System.arraycopy(original,     0,       copy,        0,      Math.min(original.length, newLength));
        //                  源地址   拷贝的起始地址    目标空间   拷贝到那个位置      拷贝多少个数据
        //1) 若是拷贝的数据长度大于源地址的长度，则会报出数组下标异常
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = new int[array1.length];
        System.arraycopy(array1, 0, array2, 0, 3);
        System.out.println(Arrays.toString(array2));//1,2,3,0,0

        //填充数据：Arrays.fill();
        int[] array3 = new int[10];
        Arrays.fill(array3, 1);//10个位置全部是1
        //        填充的空间 填充值
        System.out.println(Arrays.toString(array3));//[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]

        Arrays.fill(array3, 1, 5, -1);
        //        填充的空间  从那点开始  到那个位置  填充值
        System.out.println(Arrays.toString(array3));//[1, -1, -1, -1, -1, 1, 1, 1, 1, 1]
    }

    public static void main5(String[] args) {
        //数组拷贝
        int[] array = {1, 2, 3, 4, 5};
        int[] copy = new int[array.length];

        //进行拷贝
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        System.out.println(Arrays.toString(copy));

        //思考以下代码是不是拷贝？ --> 不是，是两个引用指向了同一个数组对象
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = array1;
        System.out.println(Arrays.toString(array2));
    }

    public static void main4(String[] args) {
        //如何在方法中返回一个数组？
        int[] arr = getArray();
        System.out.println(Arrays.toString(arr));
    }

    //返回一个数组
    public static int[] getArray() {
        int[] array = {1, 2, 3, 4, 5};
        return array;
        //return new int[]{1, 2, 3, 4, 5};
    }

    public static void main3(String[] args) {
        int[] arr = {1, 2, 3, 4};
        //借助工具类打印数组：Arrays.toString();打印数组的内容
        System.out.println(Arrays.toString(arr));//[1, 2, 3, 4]
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr1));

        //模拟实现toString方法
        String str = myToString(arr);
        System.out.println(str);
    }

    //模拟实现toString方法
    public static String myToString(int[] arr) {
        String str = "[";
        //拼接到字符串中
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if (i != arr.length - 1) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }

    public static void main2(String[] args) {
        //以下的代码会输出什么？为什么？
        int[] array1 = {1, 2, 3, 4};
        func1(array1);
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");//1 2 3 4
        }
        System.out.println();

        int[] array2 = {1, 2, 3, 4};
        func2(array2);
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");//99 2 3 4
        }
        System.out.println();

        int[] array3 = null;//array3不指向任何地方
        System.out.println(array3.length);//空指针异常
    }

    public static void func2(int[] array) {
        array[0] = 99;
        //array = null;
    }

    public static void func1(int[] array) {
        array = new int[10];
    }

    public static void main1(String[] args) {
        //引用类型 --> 在变量中存储的是地址
        //第一种for循环的遍历方式
        int[] array = {1, 2, 3, 4};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        //for each循环：第二种for循环的遍历方式
        for (int x : array) {
            System.out.print(x + " ");
        }

        //求两个数的最大值,三个数的最大值
    }

    //两个数的最大值
    public static int max(int x, int y) {
        return ((x > y) ? x : y);
    }

    //三个数的最大值
    public static int max(int x, int y, int z) {
        int max = max(x, y);
        return max(max, z);
    }
}
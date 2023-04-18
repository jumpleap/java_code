package test;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        //给定一个整型数组, 实现冒泡排序(升序排序)
        int[] arr = {3, 1, 2, 4, 5, 7, 6, 8};
        bubbleSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;//优化
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    //交换数据位置
                    flag = false;
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            if(flag) {
                break;//有序了跳出
            }
        }
    }

    public static void main3(String[] args) {
        //调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
        //如数组：[1,2,3,4,5,6]
        //调整后可能是：[1, 5, 3, 4, 2, 6]
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[6];

        //输入数据
        for (int i = 0; i < arr.length; i++) {
            int tmp = scanner.nextInt();
            arr[i] = tmp;
        }

        arr = exchange(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int[] exchange(int[] nums) {
        int[] arr = new int[nums.length];

        int j = 0;
        //奇数在前
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1)
                arr[j++] = nums[i];
        }

        //偶数在后
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                arr[j++] = nums[i];
        }
        return arr;
    }

    public static void main2(String[] args) {
        //实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
        int[] arr = {2, 3, 4, 5, 6};
        double average = avg(arr);
        System.out.println(average);
    }

    public static double avg(int[] arr) {
        double sum = 0;
        //求和
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;//平均数
    }

    public static void main1(String[] args) {
        //实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 ,
        //并设置到对应的数组元素上. 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[3];

        //输入数据
        for (int i = 0; i < arr.length; i++) {
            int tmp = scanner.nextInt();
            arr[i] = tmp;
        }

        transform(arr);
        //打印
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void transform(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }
}
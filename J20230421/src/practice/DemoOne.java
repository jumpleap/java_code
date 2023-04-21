package practice;

import java.util.Arrays;

@SuppressWarnings({"all"})
public class DemoOne {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};

        //这个是引用指向引用吗？
        int[] array1 = array;
        //不是，是array1的引用指向array引用所指向的数组对象
    }
}

class One {
    public static void main(String[] args) {
        //以下代码是不是拷贝？
        int[] array = {1, 2, 3, 4, 5};
        int[] array1 = array;
        System.out.println(Arrays.toString(array1));//[1, 2, 3, 4, 5]
    }

    public static void main1(String[] args) {
        int[] ret = func();
        System.out.println(Arrays.toString(ret));
    }

    public static int[] func() {
        return new int[]{1, 2, 3, 4, 5, 6};
    }

    public static void main2(String[] args) {
        int[] array = {1,2,3,4};
        func(array);
        System.out.println(Arrays.toString(array));

    }

    public static void func(int[] array) {
        array = new int[10];
    }
}
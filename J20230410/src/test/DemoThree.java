package test;

import java.util.Scanner;

@SuppressWarnings({"all"})

public class DemoThree {
    public static void main(String[] args) {
        //数组中各种数据类型默认的值
        char[] ch = new char[10];
        int[] num = new int[10];
        double[] data = new double[10];
        boolean[] booleans = new boolean[10];

        //查看当中的默认值
        for (char c : ch) {
            System.out.print(c + " ");//默认值是'/u000000'---> 空格
        }
        System.out.println();

        for (int x : num) {
            System.out.print(x + " ");//默认值是0
        }
        System.out.println();

        for (double d : data) {
            System.out.print(d + " ");//默认值是0.0
        }
        System.out.println();

        for (boolean b : booleans) {
            System.out.print(b + " ");//默认值是false
        }
        System.out.println();

        //使用length得到数组长度
        System.out.println(num.length);//10
    }

    public static void main5(String[] args) {
        //按顺序打印出数字的每一位，如：123 打印：1 2 3
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入你想要打印的数字：");
        int digit = scanner.nextInt();
        print(digit);
    }

    //从首尾打印每一位
    private static void print(int digit) {
        if (digit < 9) {
            System.out.print(digit + " ");
            return;
        }
        print(digit / 10);
        System.out.print(digit % 10 + " ");
    }

    public static void main4(String[] args) {
        //斐波那契数
        //法1：递归
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你想求第几项斐波那契数：");

        int num = scanner.nextInt();
        System.out.println(fib(num));

        //法二：迭代
        System.out.println(fibNum(num));
    }

    //迭代实现斐波那契数
    private static int fibNum(int n) {
        if (n == 0)
            return 0;
        int x = 1;
        int y = 1;
        int ret = 1;

        //迭代求解斐波那契数
        while (n > 2) {
            ret = x + y;
            x = y;
            y = ret;
            n--;
        }
        return ret;
    }

    //递归实现斐波那契数
    private static int fib(int num) {
        if (num == 0)
            return 0;
        if (num == 1)
            return 1;
        return fib(num - 1) + fib(num - 2);
    }

    public static void main3(String[] args) {
        //求1!+2!+……+n!
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int sum = 0;
        //1！到num!阶乘的和
        for (int i = 1; i <= num; i++) {
            sum += fac(i);//累加
        }
        System.out.println(sum);
    }

    //求阶乘
    private static int fac(int n) {
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            ret *= i;
        }
        return ret;
    }

    public static void main2(String[] args) {
        //Java中交换两个整数的值
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println("交换前：x = " + x + " y = " + y);//10 29
        swap(x, y);
        System.out.println("交换后：x = " + x + " y = " + y);//10 29
        //可以发现，根本没有进行值的交换

        //思考一下，我们怎么实现这个值的交换？引用类型【数组】
        int[] arr = new int[2];
        arr[0] = 10;
        arr[1] = 29;

        System.out.println("交换前：arr[0] = " + arr[0] + " arr[1] = " + arr[1]);//10 29
        swap(arr);
        System.out.println("交换后：arr[0] = " + arr[0] + " arr[1] = " + arr[1]);//29 10
    }

    //交换
    private static void swap(int[] arr) {
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
    }

    //交换
    private static void swap(int x, int y) {
        int tmp = x;
        x = y;
        y = tmp;
    }

    public static void main1(String[] args) {
        //判断闰年
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = scanner.nextInt();
        System.out.println(isLeapYear(year));
    }

    //判断闰年
    private static boolean isLeapYear(int year) {
        if ((0 == year % 4 && 0 != year % 100) || (0 == year % 400)) {
            return true;//是闰年
        }
        return false;
    }
}

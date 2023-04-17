package test;

import java.util.Scanner;
@SuppressWarnings({"all"})

public class Test {
    public static void main(String[] args) {
        //求 N 的阶乘
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        num = scanner.nextInt();

        int fac = facNum(num);
        System.out.println(fac);
    }

    public static int facNum(int num) {
        int ret = 1;
        for (int i = 1; i <= num; i++) {
            ret *= i;
        }
        return ret;
    }

    public static void main4(String[] args) {
        //在同一个类中定义多个方法：要求不仅可以求2个整数的最大值，还可以求3个小数的最大值？
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        //求两个数的最大值
        int ret = getMax(x, y);
        //求三个数的最大值
        int max = getMax(x, y, z);
        System.out.println(ret + " " + max);
    }

    //三个数的最大值
    public static int getMax(int x, int y, int z) {
        int ret = Math.max(x, y);
        return Math.max(ret, z);
    }

    //两个数的最大值
    public static int getMax(int x, int y) {
        return Math.max(x, y);
    }

    public static void main3(String[] args) {
        //在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        double m = scanner.nextDouble();
        double n = scanner.nextDouble();
        double k = scanner.nextDouble();

        int sum1 = getSum(x, y);
        double sum2 = getSum(m, n, k);
        System.out.println("两个整数之和：" + sum1 + "，三个小数之和：" + sum2);
    }

    //三个小数之和
    public static double getSum(double m, double n, double k) {
        return m + n + k;
    }

    //两个整数之和
    public static int getSum(int x, int y) {
        return x + y;
    }

    public static void main2(String[] args) {
        //求斐波那契数列的第n项。(迭代实现)
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        num = scanner.nextInt();

        int fib = fibNum(num);
        System.out.println(fib);
    }

    public static int fibNum(int num) {
        if (num == 0)
            return 0;
        int n1 = 1;
        int n2 = 1;
        int ret = 1;

        //进行迭代
        while (num > 2) {
            ret = n1 + n2;
            n1 = n2;
            n2 = ret;
            num--;
        }
        return ret;
    }

    public static void main1(String[] args) {
        //求1！+2！+3！+4！+........+n!的和
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int ret = FacNum(num);
        System.out.println(ret);
    }

    public static int FacNum(int num) {
        int sum = 0;
        int res = 1;
        for (int i = 1; i <= num; i++) {
            //求1！，2！，3！……
            res *= i;
            //累加阶乘和
            sum += res;
        }
        return sum;
    }
}

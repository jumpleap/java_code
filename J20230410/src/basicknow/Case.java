package basicknow;

import java.util.Scanner;

public class Case {
    public static void main(String[] args) {
        //求 N 的阶乘  。
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int ret = facNum(num);
        System.out.println(num + "的阶乘为：" + ret);
    }

    //求阶乘
    public static int facNum(int num) {
        if (num <= 1)
            return 1;
        return num * facNum(num - 1);
    }

    public static void main3(String[] args) {
        //创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
        //要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        //求两个数的最大值
        int ret = max2(num1, num2);
        System.out.println("两个数中的最大值为：" + ret);
        //求三个数的最大值
        ret = max3(num1, num2, num3);
        System.out.println("三个数中的最大值为：" + ret);
    }

    //三个数的最大值
    public static int max3(int num1, int num2, int num3) {
        int ret = max2(num1, num2);
        return max2(ret, num3);
    }

    //两个数的最大值
    public static int max2(int num1, int num2) {
        return ((num1 > num2) ? num1 : num2);
    }

    public static void main2(String[] args) {
        //给定两个数，求这两个数的最大公约数
        Scanner scanner = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();

        //得到两个数中的最大值，也可以使用Math.max()获取
        if (num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int ret = 0;
        while (num2 != 0) {
            ret = num1 % num2;
            num1 = num2;
            num2 = ret;
        }
        System.out.println("最大公约数为：" + num1);
    }

    public static void main1(String[] args) {
        //获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        num = scanner.nextInt();

        int ret = 0;
        //偶数位
        for (int i = 31; i >= 0; i -= 2) {
            //取到偶数位然后&1得到当前的二进制位
            ret = (num >> i) & 1;
            System.out.print(ret);
        }
        System.out.println();//换行

        //奇数位
        for (int i = 30; i >= 0; i -= 2) {
            ret = (num >> i) & 1;
            System.out.print(ret);
        }
    }
}

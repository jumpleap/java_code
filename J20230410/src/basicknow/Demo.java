package basicknow;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        //给定两个数，求这两个数的最大公约数

    }


    public static void main4(String[] args) {
        //编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,
        // 密码错误， 可以重新输 入，最多输入三次。三次均错，则提示退出程序
        Scanner scanner = new Scanner(System.in);
        String password = "";
        String originPassword = "324561";
        int flag = 0;
        int i = 0;

        for (i = 0; i < 3; i++) {
            System.out.println("请输入密码：");
            password = scanner.next();

            //进行比较
            if (password.equals(originPassword)) {
                System.out.println("密码正确");
                break;
            } else {
                //最后一次不提示你还有没有机会了
                if(i == 2) {
                    flag = 1;
                    break;
                }
                System.out.println("密码错误，你还有" + (2 - i) + "次机会");
            }
        }

        //判断是不是3次机会都用完了
        if (flag == 1) {
            System.out.println("3次机会均使用完毕，请稍后再试~");
        }
    }

    public static void main3(String[] args) {
        //输出一个整数的每一位，如：123的每一位是3，2，1
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        num = scanner.nextInt();

        while (num != 0) {
            System.out.print(num % 10);
            num /= 10;
        }
    }


    public static void main2(String[] args) {
        //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
        double sum = 0;
        int flag = 1;
        for (int i = 1; i <= 100; i++) {
            sum += 1.0 / i * flag;
            flag = -flag;
        }
        System.out.println(sum);
    }


    public static void main1(String[] args) {
        //编写程序数一下 1到 100 的所有整数中出现多少个数字9
        int num = 1;
        int count = 0;
        while (num <= 100) {
            if (num % 10 == 9)
                count++;
            if (num / 10 == 9)
                count++;
            num++;
        }
        System.out.println("1-100中9的个数为:" + count);
    }
}

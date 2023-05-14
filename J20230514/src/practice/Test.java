package practice;

import java.util.Scanner;

@SuppressWarnings({"all"})

public class Test {
    public static void main(String[] args) {
        int a = 0;
        System.out.println(func());
    }

    public static int func() {
        try {
            return 10;
        } catch (ArithmeticException e) {

        } finally {
            return 100;
        }
    }

    public static void main4(String[] args) {
        try {
            func2();
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("抛出了一个异常");
        } finally {

        }
    }

    public static void func2() {
        try {
            int a = 0;
            System.out.println(10 / a);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println("处理了异常");

        /*int a = 0;
        System.out.println(10 / a);*/
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        try {
            System.out.println(10 / a);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("捕获到了算术异常");
        } finally {
            scanner.close();//关闭资源
            System.out.println("finally，不管是否抛出异常，都要执行");
        }
    }

    public static void main2(String[] args) {
        int a = 0;
        try {
            System.out.println(10 / a);
            int[] arr = null;
            System.out.println(arr.length);
            //再try中发生异常后的代码不会执行
            System.out.println("1234");
        } catch (ArithmeticException | NullPointerException e) {
            //可以使用|作为连接符来连接两个异常，但是不推荐
            e.printStackTrace();
            System.out.println("捕获到了算术异常或空指针异常");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("捕获到了异常");
        }
        System.out.println("其他业务代码");
    }

    public static void main1(String[] args) throws CloneNotSupportedException {
        test();
    }

    //throws：一般放在方法声明的地方
    public static void test() throws CloneNotSupportedException {
        int a = 0;
        if (a == 0) {
            //throw常用于抛出异常类
            throw new CloneNotSupportedException("a == 0");
        }
    }
}

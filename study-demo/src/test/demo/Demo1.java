package test.demo;

// %测试
public class Demo1 {

    public static void main(String[] args) {

    }

    public static void main1(String[] args) {
        System.out.println(100 % 3); // 1
        System.out.println(100.0 % 3); // 1.0
        System.out.println(100 % 3.0); // 1.0
        System.out.println(100.0 % 3.0); // 1.0
    }
}


abstract class A {
    // abstract不能修饰变量
//    public abstract int a;
}
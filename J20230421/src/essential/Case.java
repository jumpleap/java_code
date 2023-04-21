package essential;

import java.util.Arrays;
import java.util.Scanner;

public class Case {
    public static void main(String[] args) {
        //1.IDEA中打断点的快捷键？ ctrl + f8
        int a = 10;

        //2.switch括号中不能使用的基本数据类型有那些？
        // ———long、float、double、boolean类型
        long data = 10;
        float f = 13.1f;
        double d = 13.14;
        boolean flag = false;

        //验证
        //switch (data) {}
        //switch (f) {}
        //switch (d) {}
        //switch (flag) {}

        //3.case后面能不能跟变量？
        int week = 2;
        int n = 10;
//        switch (week) {
//            case n:
//        }

        //4.if、while、do-while括号中的表达式是什么类型的表达式？
//        if(1) { }
//
//        while(1) {}
//
//        do{
//        }while(1)

        //5.当使用scanner的时候，当想要关闭这个资源的时候，如何关闭？
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        System.out.println("请输入一个数：");
        num = scanner.nextInt();
        System.out.println(num);
        //关闭scanner资源
        scanner.close();
        //再次进行输入，看看是否能输入
        System.out.println("请输入一个数：");
        num = scanner.nextInt();
        System.out.println(num);

        //6.Java中如何读入多组数据？hasNext()和hasNextLine()的区别？
        //使用hasNext()hasNextLine()读取多组数据
        //hasNext()：读取空格前的数据，遇到空格或换行符结束读取
        //hasNextLine():读取一行数据，遇到换行符就结束这一行的读取
        String str = "";
        while (scanner.hasNext()) {
            str = scanner.next();
            //若是使用scanner.nextLine()会把这一行的数据都读取了
            //str = scanner.nextLine();
            System.out.println(str);
        }
        scanner.close();//关闭输入资源器

        /*
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            //若是使用scanner.next()读取遇到空格前的数据
            //str = scanner.next();
            System.out.println(str);
        }
        scanner.close();//关闭输入资源器
         */

        //7.如何求出某个对象所占的内存空间？

        //8.若是想要方法中返回多个数据，该怎么设计？
        int[] arr = func();
        System.out.println(Arrays.toString(arr));//[1, 2, 3, 4, 5]

        //9.方法中遇到return语句或方法结束后方法所开辟的内存空间是否还存在？
        //不存在，被JVM回收

        //10.Java中，形参的值是实参的一份拷贝

    }

    /**
     * 使用数组返回多个数据
     *
     * @return
     */
    private static int[] func() {
        return new int[]{1, 2, 3, 4, 5};
    }
}


class Test {
    public static void main(String[] args) {
        int num = 10;
        //传值
        deliver(num);
        System.out.println(num);//10

        int[] arr = new int[]{1, 2, 3, 4, 5};
        for (int x: arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        deliver(arr);
    }

    /**
     * 形参arr是实参arr地址的一份拷贝
     * @param arr
     */
    private static void deliver(int[] arr) {
        //Arrays.toString(arr);
        for (int x: arr) {
            System.out.print(x + " ");
        }
    }

    /**
     * 形参num是实参num的一份拷贝
     *
     * @param num
     */
    private static void deliver(int num) {
        System.out.println(num);//10
    }
}


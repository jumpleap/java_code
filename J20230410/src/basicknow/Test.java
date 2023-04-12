package basicknow;

public class Test {
    public static void main(String[] args) {
        //System.out.println("hello~");

        //1.Java程序在底层是怎么进行编译和运行的？
        //源文件 -- javac --> 字节码文件  -- java -- 得出结果

        //2.JDK、JRE和JVM三者的关系
        //JDK = JRE + JVM
        //JRE = JVM + Java基本类库
        //JVM：运行Java代码

        //5.字面常量：程序运行期间，固定不变的值
        //字符串常量：由""括起来的字符序列
        //整型常量：2，3，4，5等
        //字符常量：由''括起来的单个字符
        //浮点数常量：1.234
        //布尔常量：false
        //空常量：null

        //变量
        //int a = 10;//数据类型 变量名 = 初始值
        //a = 100;
        //System.out.println(a);//100

        //Java中的局部变量能不能不赋值就编译运行？
        //int num;
        //System.out.println(num);//错误，局部变量需要进行赋值才能进行使用，不然编译器会报错

        //Java中赋的值超过当前类型的最大值后能不能通过编译运行？
        //int max = 21111111111;//不能使用，超过了int的最大值
        //System.out.println(max);

        //若是使用相加的方式后，加的结果超过了最大值，编译器是否会报错？
//        int x = 2000000111;
//        int y = 1110000000;
//        int m = x + y;
//        System.out.println(m);//不会报错

        //获取整数类型的最大值和最小值
        System.out.println(Integer.MAX_VALUE);//最大值
        System.out.println(Integer.MIN_VALUE);//最小值

//        short a =128;
//        byte b =(byte) a;
//        System.out.println(a + " " + b);

        double x=2.0;
        int y=4;
        x/=++y;
        System.out.println(x);

        int a = 10;
        //System.out.println(!a);

    }
}

//3.一个Java文件中只能有一个和当前文件名一样的类
//class Test {
//
//}


//4.public修饰的类名必须和文件名一致
//public class Test2 {
//
//}
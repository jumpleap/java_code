package basicknow;

@SuppressWarnings({"all"})
public class Test {
    public static void main(String[] args) {
        //字符串中+号的作用:拼接字符串
        System.out.println("hello" + "java");//hellojava
        System.out.println(10 + "java" + 20);//10java20
        System.out.println(10 + 2 + "java" + 12);//12java12
        System.out.println("java" + 12 + 12);//java1212

        //字符串和int类型的相互转化
        //int -> String
        int num = 10;
        //法一：+号拼接
        String str = 10 + "";
        System.out.println(str);
        //法二：字符串的valueOf方法
        str = String.valueOf(num);
        System.out.println(str);

        //String -> int
        String s = "132";
        //法一：Integer的parseInt方法
        int ret = Integer.parseInt(s);
        System.out.println(ret);
        //法二：Integer的valueOf方法
        ret = Integer.valueOf(s);
        System.out.println(ret);

        //包装类指基本数据类型针对的类类型
        //如：char -> Character、int -> Integer、double -> Double等

        //Java中复合赋值运算符的特点：会进行强制类型转化
        int a = 20;
        short b = 10;
        //b = b + a;//错误，不能把高类型的赋值给低类型的
        b += a;//b = (int)(b+a)--> 会进行强制类型转化

        //3<x<9？
        int c = 10;
        //System.out.println(3 < c < 9);//错误，Java中不允许这样的表达式存在
        //解释：3<x:false，false < 9:不能进行比较，报错

        //短路与/或与逻辑与/或的区别
        //短路与/或：第一个操作数为假/真，第二个操作不执行
        //逻辑与/或：不管第一个操作数是真是假，第二个操作数均要执行
        int x = 10;
        int y = 20;
        int z = 15;
        boolean res = x++ > y++ && x++ > z++;
        System.out.println(x + " " + y + " " + z);//11 21 15
        boolean res1 = x++ < z++ || y++ < z++;
        System.out.println(x + " " + y + " " + z);//12 21 16


        //逻辑非能不能对非布尔类型使用
        //System.out.println(!a);//错误，！只能对布尔类型使用

        //条件表达式中对应的真假值必须是同类型的，或能发生隐式转化

        int m = 12;
        double n = 11;
        double result = m > n ? m : n;//m会自动发生类型转化为double类型
        System.out.println(result);//12.0

        //++/--运算符
        //1)前置++/--：先自增/自减，在使用
        //2)后置++/--：先使用，后自增/自减
        //3)单独使用，不分前后

        int d = 10;
        int k = 10;
        d++;//++d也是一样的
        k = ++d;//d先自增，再使用
        System.out.println(k + " " + d);//12 12
        k = d++;//d先使用，再自增
        System.out.println(k + " " + d);//12 13

    }


    public static void main2(String[] args) {
        //Java中浮点数的存储规则
        //(-1)^S * M * 2^E
        //S是符号问，M是有效数字（常表示1），E是指数位
        //float中符号位占1位，指数位占8位，有效位占23位
        //double中符号位占1位，指数位占11位，有效位52位
        //科学计数法中的E是可以是为负数的，所以我们在计算E的时候，
        //应该加上一个中间值，float类型+127，double类型+1023

        //Java中整数类型默认是int，小数类型是double
        //byte b = 128;//直接赋值的时候超过当前范围的最大值时，会进行类型检查
        //float f = 1.314f;//错误，Java中默认的double类型，想要使用则加上f

        //Java中浮点数的最小值是正值？
        //是正值，接近0的无穷小
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);

        //Java的命名规则
        //1.包名全小写，多单词之间使用.号分割
        //2.类型使用大驼峰的命名规则：每个单词的首字母均大写
        //3.变量名和方法名使用小驼峰的命名规则：第一个单词的首字母单词小写，其他单词的首字母均要大写
        //4.常量的标识符必须全部大写，若是多单词，中间使用下划线隔开；如：MAX_VALUE

        //Java的基本数据类型会不会在不同的平台上所占内存空间不同？
        //不会，在每个平台上所占的内存空间均是相同的，Java的基本数据类型是有Java虚拟机决定的，不是操作系统决定的

        //如何求出基本数据类型所占的内存空间大小？
        //使用各封装类的SIZE方法
        int byteSize = Byte.SIZE / 8;
        int shortSize = Short.SIZE / 8;
        int intSize = Integer.SIZE / 8;
        int longSize = Long.SIZE / 8;
        int floatSize = Float.SIZE / 8;
        int doubleSize = Double.SIZE / 8;
        int charSize = Character.SIZE / 8;

        //查看内存空间大小
        System.out.println(byteSize);//1
        System.out.println(shortSize);//2
        System.out.println(intSize);//4
        System.out.println(longSize);//8
        System.out.println(floatSize);//4
        System.out.println(doubleSize);//8
        System.out.println(charSize);//2

        //Java中整数除法和小数除法【右操作数不能为0，负责会发生异常】
        //整数除法：向下取整
        int a = 10;
        int b = 3;
        System.out.println(a / b);//3

        //小数除法：结果得到是小数
        double c = 10;
        int d = 3;
        System.out.println(c / d);//3.3333333333335

        //Java中没有绝对精确的浮点数【浮点数都是不精确的】？
        //数值在计算中均是以补码的方式存储的。但是计算机补码是有限的，因此，对于会产生的无限不循环或循环小数，会导致精度的丢失

        //Java中的字符类型有没有负数？
        //Java中的字符类型是没有负数的形式的，即Java中的字符类型是无符号的

        //Java中的布尔类型能不能和其他类型相互转化？
        //不能，布尔类型只能是true和false
        boolean bool = true;
        int num = 10;
        //num = bool;//错误，不能进行转化
        //num = (num)bool;//错误，也不能进行强制类型转化

        //自动类型转化：类型小的自动转化为类型大的
        short sh = 10;
        byte by = 30;
        int i = sh + by;//sh 和 by在进行运算的时候会先提升为int，然后在进行运算
        System.out.println(i);//40

        long l = 10;
        int data = 20;
        //data = l;//错误，高精度不能自动转化低精度的数据

        //强制类型转化：大的类型强制转化为小的【需要使用强制类型转化符()】
        int cur = 100;
        long p = 10;
        cur = (int) p;

        double total = 123.4525536644688558987;
        float sum = 1;
        sum = (float) total;//强制类型转化后的数据可能存在精度丢失的问题
        System.out.println(sum);//123.45255

    }


    public static void main1(String[] args) {
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

        double x = 2.0;
        int y = 4;
        x /= ++y;
        System.out.println(x);

        int a = 10;
        //System.out.println(!a);
        int Number1 = 0, Number2 = 0;
        int[] Array1 = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        for (int Ctr : Array1) {
            if (Ctr % 2 == 1) {
                Number1++;
            } else {
                Number2++;
                System.out.print(Ctr);
            }
        }

        int i = 10, j = 20;

        while (i++ < --j) {
        }
        System.out.println(i + " " + j);
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
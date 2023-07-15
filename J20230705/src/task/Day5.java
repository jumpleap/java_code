package task;

import java.util.Random;

public class Day5 {
    /*
    1、以下程序的输出结果是（A）
    public class Print{
        static boolean out(char c){
            System.out.print(c);
            return true;
        }
        public static void main(String[] argv){
            int i = 0;
            for(out('A');out('B') && (i<2);out('C')){
                i++;
                out('D');
            }
        }
    }
    A: ABDCBDCB B: BCDABCD C: 编译错误 D: 运行错误

    2、Java类Demo中存在方法func1、func2、func3和func4，请问该方法中，哪些是不合法的定义？【多选】（AD）
    public class Demo{
        float func1(){
            int i=1;
            return;
        }

        float func2(){
            short i=2;
            return i;
        }

        float func3(){
            long i=3;
            return i;
        }

        float func4(){
            double i=4;
            return i;
        }
    }
    A: func1 B: func2 C: func3 D: func4
    //解析：有返回值的方法必须给返回值，无返回值的方法可以给return;
    //精度低的可以直接赋给精度高的，精度高的需要强制类型转化给精度低的
    //long类型可以转化为float类型，因为float的最大值比long的最大值大

    3、对于下面这段代码，以下说法正确的是（C）
    public class Test{
        public int x;
        public static void main(String []args) {
            System. out. println("Value is" + x);
        }
    }
    A: 程序会打出 "Value is 0"
    B: 程序会抛出 NullPointerException
    C: 非静态变量不能够被静态方法引用
    D: 编译器会抛出 "possible reference before assignment"的错误
    //解析：静态方法只能调用静态成员，非静态方法都能调用

    4、请输出最终内容（A）
    int i = 3;
    String result = new String();
    switch (i) {
        case 1:
            result = result + "him ";
        case 2:
            result = result + "her ";
        case 3:
            result = result + "it ";
        default:
            result = result + "me ";
    }
    System.out.println(result);
    A: it me B: him her it me C: him her D: me
    //switch中若是没有break，则一直执行到有break的地方

    5、以下Java程序运行的结果是 （A）
    public class Tester{
        public static void main(String[] args){
            Integer var1=new Integer(1);
            Integer var2=var1;
            doSomething(var2);
            System.out.print(var1.intValue());
            System.out.print(var1==var2);
        }

        public static void doSomething(Integer integer){
            integer=new Integer(2);
        }
    }
    A: 1true B: 2true C: 1false D: 2false
     */

    //代码验证

    public static void main(String[] args) {
        Integer var1 = new Integer(1);
        Integer var2 = var1;
        doSomething(var2);
        System.out.print(var1.intValue());
        System.out.print(var1 == var2);
    }

    public static void doSomething(Integer integer) {
        integer = new Integer(2);
    }

    public int x;

    public static void main2(String[] args) {
        //System. out. println("Value is" + x);
    }

    static boolean out(char c) {
        System.out.print(c);
        return true;
    }

    public static void main1(String[] argv) {
        int i = 0;
        for (out('A'); out('B') && (i < 2); out('C')) {
            i++;
            out('D');
        }
    }


    /*
    代码题
     */

    /**
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
     */
    public int addDigits(int num) {
        int sum = 0;
        while (num != 0) {
            int ret = num;
            //对每个数求和
            while (ret != 0) {
                sum += ret % 10;
                ret /= 10;
            }
            if (sum >= 10) {
                //重置
                num = sum;
                sum = 0;
            } else {
                //小于10则跳出
                break;
            }
        }
        return sum;
    }

    public int addDigits1(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * 猜数字游戏的规则如下：
     * <p>
     * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
     * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
     */
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            //取中间值
            int mid = left + (right - left) / 2;
            if (guess(mid) < 0) {
                //猜小了
                right = mid - 1;
            } else if (guess(mid) > 0) {
                //猜大了
                left = mid + 1;
            } else {
                //猜对了
                return mid;
            }
        }
        return left;
    }

    private int guess(int val) {
        Random r = new Random();
        return r.nextInt(val) + 1;
    }
}
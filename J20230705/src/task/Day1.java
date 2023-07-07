package task;

import java.util.Stack;

/**
 * 第一天任务
 */
public class Day1 {
    /*
    1、JDK中提供的java、javac、jar等开发工具也是用Java编写的。（A）
    A. 对 B. 错
    //解析：A，JDK中的所有工具基本上都是Java所编写的，所有这些工具也是应用程序，也需要JRE来进行运行

    2、下面是java语言的基本特性是？【多选】（ABC）
    A. 封装 B. 多态 C. 继承 D. 高效
    //解析：Java语言的基本特性是：封装、继承、多态

    3、以下（）不是合法的标识符？（C）
    A. STRING B. x3x C. void D. deSf
    //解析：关键字不能做为标识符；
    标识符的命名规则：不能以数字开头，不能使用关键字、保留字作为标识符，
    标识符由大小写字母、数字、下划线和美元符号组成；常量需要使用全大写

    4、关于Float，下列说法错误的是（C）
    A: Float是一个类
    B: Float在java.lang包中
    C: Float a=1.0是正确的赋值方法
    D: Float a= new Float(1.0)是正确的赋值方法
    //解析：Float是float的封装类，Float类在Java.lang包下；
    1.0默认是double类型，不能进行自动装箱为Float类型

    5、下面的Java赋值语句哪些是有错误的（B）
    A: int i =1000;
    B: float f = 45.0;
    C: char s = ‘\u0639’;
    D: String s = "hello,world\0";
     */

    //答案验证
    public static void main(String[] args) {
        //Float a = 1.0;//1.0是double类型，转为float需要强制类型转化
        Float aFloat = new Float(1.0);//底层使用了强制类型转化
        /*
        底层源码：
            public Float(double value) {
                this.value = (float)value;
            }
         */
        char s = '\u0639';
    }

    /*
    给定一个长度为 n 的字符串，请编写一个函数判断该字符串是否回文。如果是回文请返回true，否则返回false。
    字符串回文指该字符串正序与其逆序逐字符一致。
    数据范围：0<n≤1000000
    要求：空间复杂度 O(1)，时间复杂度O(n)
     */

    /**
     * 法一：首尾字符判断【双指针】
     * 时间、空间复杂度：O(n)
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge1(String str) {
        char[] arr = str.toCharArray();//字符串转为字符数组
        int len = arr.length;

        for (int i = 0; i < len / 2; i++) {
            //判断首尾字符是否相等
            if (arr[i] != arr[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 法二：逆置字符串比较
     * 时间、空间复杂度：O(n)
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge2(String str) {
        //使用StringBuilder
        StringBuilder sb = new StringBuilder(str);
        //底层使用的也是append方法

        String s = sb.reverse().toString();//翻转字符串
        //判断两个字符串是否相等
        return str.equals(s);
    }

    /**
     * 栈的特点：先进后出
     * 时间、空间复杂度：O(n)
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge(String str) {
        Stack<Character> stack = new Stack<>();
        int len = str.length();
        //入栈
        for (int i = 0; i < len; i++) {
            stack.push(str.charAt(i));
        }

        //出栈和字符串中的字符进行比较
        for (int i = 0; i < len; i++) {
            if (stack.pop() != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 实现函数 int sqrt(int x).
     * 计算并返回 x 的平方根（向下取整）
     * 数据范围：0<=x<2^31−1
     * 要求：空间复杂度 O(1)，时间复杂度 O(logx)
     */

    /**
     * 若mid * mid <= x && (mid + 1) * (mid + 1) > x，则mid为中间值
     * 若mid < x / mid，则在右半区域
     * 若mid > x / mid，在左半区域
     * @param x 目标值
     * @return 返回值【平方根后的值】
     */
    public int sqrt (int x) {
        if (x < 2) {
            return x;
        }
        int left = 1;
        int right = x;
        int mid = 0;
        while (true) {
            //中间值，防止溢出
            mid = left + (right - left) / 2;
            //若mid * mid <= x && (mid + 1) * (mid + 1) > x，则mid为中间值
            //若mid < x / mid，则在右半区域
            //若mid > x / mid，在左半区域
            if ((mid <= x / mid) && ((mid + 1) > x / (mid + 1))) {
                return (int)mid;
            } else if (mid < (x / mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
}
package test.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// 面试题训练 - day1
public class Demo12 {
    // 选择题
    /*
        1. 在 Java 中，存放字符串常量的对象属于（ B）类对象。
        A Character
        B String
        C StringBuffer
        D Vector
        // 解释: Character: char的包装类; String: 存放字符串常量对象;
        // StringBuffer: 线程安全版的动态字符串; Vector: 集合(底层为数组), 线程安全

        2.已知如下类定义：
        class Base {
            public Base (){
                //...
            }
            public Base ( int m ){
                //...
            }
            public void fun( int n ){
                //...
            }
        }

        public class Child extends Base{
            // member methods
        }
        如下哪句可以正确地加入子类中？( D )
        A private void fun( int n ){ //...}
        B void fun ( int n ){ //... }
        C protected void fun ( int n ) { //... }
        D public void fun ( int n ) { //... }
        // 解释: 继承了之后, 重写了fun方法

        3. 下列选项中属于面向对象编程主要特征的是（ A ）
        A 继承
        B 自顶向下
        C 模块化
        D 逐步求精
        // 解释: 封装, 继承, 多态是面向对象的主要特征

        4.关于下列程序段的输出结果，说法正确的是：（ D ）
        public class MyClass{
            static int i;
            public static void main(String argv[]){
                System.out.println(i);
            }
        }
        A 有错误，变量i没有初始化。
        B null
        C 1
        D 0
        // 基本类型作成员变量: 有默认值; 引用类型: null

        5.下列代码的执行结果是：（ B ）
        public class Test{
            public static void main(String args[]){
                System.out.println(100%3);
                System.out.println(100%3.0);
            }
        }
        A 1和1
        B 1和1.0
        C 1.0和1
        D 1.0和1.0
        // 解释: 整数相模: 得到整数; 浮点数相模: 得到浮点数


        6.在基本 JAVA 类型中，如果不明确指定，整数型的默认是 __ 类型，浮点数的默认是 __ 类型（ B ）
        A int float
        B int double
        C long float
        D long double
        // Java中, 整数类型默认为int, 浮点数默认值为double

        7.方法通常存储在进程中的哪一区（ D ）
        A 堆区
        B 栈区
        C 全局区
        D 方法区
        // 解释:
        // 堆区: 数组, 成员变量(new的对象); 栈区: 局部变量, 形式参数
        // 全局区: 指在整个程序运行期间都可见的全局变量和静态变量的存储区
        // 方法区: 它与堆一样，是被线程共享的区域。在方法区中，
                  存储了每个类的信息（包括类的名称、方法信息、字段信息）、静态变量、常量以及编译器编译后的代码等。
                  方法区用于存储已被虚拟机加载的类信息、常量、静态变量、动态生成的类等数据。

        8.不考虑反射，关于私有访问控制符 private 修饰的成员变量，以下说法正确的是（ C ）
        A 可以三种类所引用：该类自身、与它在同一包中的其他类，在其他包中的该类的子类
        B 可以被两种类访问和引用：该类本身、该类的所有子类
        C 只能被该类自身所访问和修改
        D 只能被同一个包中的类访问
        // 解释:
        // private: 只有当前类中能访问和修改
        // 默认: 当前包下
        // protected: 当前包及其子类中
        // public: 所有包

        9. 类声明中，声明一个类不能再被继承的关键字是（ C ）
        A public
        B abstract
        C final
        D static
        // 解释: public: 权限修饰符, 修饰类: 所有包均可访问这个类, 修饰方法及属性: 实例对象可以直接访问
        // abstract: 抽象定义, 修饰类: 抽象类, 修饰方法: 抽象方法; 子类继承抽象类后需要实现抽象类中的所有抽象方法或其声明为抽象类
        // final: 修饰类: 表示为最终类, 不可被继承, 修饰方法: 该方法不可被重写,  修饰属性: 表示常量

        10.假设 A 类有如下定义，设 a 是 A 类的一个实例，下列语句调用哪个是错误的？（ C ）
        public class A {
            public int i;
            static String s;

            void method1(){}
            static void method2(){}
        }
        A System.out.println(a.i);
        B a.method1();
        C A.method1();
        D A.method2();
        // 解释: static修饰方法: 方法中只能访问静态成员或方法, 若想访问成员变量或方法, new一个实例对象
        // static修饰的方法或变量, 可以直接使用类名来访问
     */


    // 编程题
    /*
        牛牛举办了一次编程比赛,参加比赛的有3*n个选手,每个选手都有一个水平值a_i.现在要将这些选手进行组队,一共组成n个队伍,即每个队伍3人.牛牛发现队伍的水平值等于该队伍队员中第二高水平值。
        例如:
        一个队伍三个队员的水平值分别是3,3,3.那么队伍的水平值是3
        一个队伍三个队员的水平值分别是3,2,3.那么队伍的水平值是3
        一个队伍三个队员的水平值分别是1,5,2.那么队伍的水平值是2
        为了让比赛更有看点,牛牛想安排队伍使所有队伍的水平值总和最大。
        如样例所示:
        如果牛牛把6个队员划分到两个队伍
        如果方案为:
        team1:{1,2,5}, team2:{5,5,8}, 这时候水平值总和为7.
        而如果方案为:
        team1:{2,5,8}, team2:{1,5,5}, 这时候水平值总和为10.
        没有比总和为10更大的方案,所以输出10.
        链接：https://www.nowcoder.com/questionTerminal/6736cc3ffd1444a4a0057dee89be789b?orderByHotValue=1&page=1&onlyReference=false
        来源：牛客网
     */

    /**
     * 思路: 模拟, 排序后从数组的length-2开始获取, 然后3n-1, 3n-3..., 一直累加到>=n为止, n: 队伍的数量
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param args
     */
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        // 获取队伍数
        int n = in.nextInt();
        // 获取选手数
        int[] ans = new int[n * 3];
        // 输入值
        for (int i = 0; i < 3 * n; i++) {
            ans[i] = in.nextInt();
        }
        // 排序
        Arrays.sort(ans);
        // int会溢出, 因为给的数可能过大
        long sum = 0;
        // 规律: 3n-1, 3n-3, 3n-5....
        for (int i = ans.length - 2; i >= n; i -= 2) {
            sum += ans[i];
        }
        System.out.println(sum);
    }


    /*
        输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
        例如，输入”They are students.”和”aeiou”，
        则删除之后的第一个字符串变成”Thy r stdnts.”
        链接: https://www.nowcoder.com/practice/f0db4c36573d459cae44ac90b90c6212?tpId=85&&tqId=29868&rp=1&ru=/activity/oj&qru=/ta/2017test/question-ranking
     */

    /**
     * 法一: 暴力枚举
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(N)
     * @param args
     */
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入两个字符串
        String s1 = in.nextLine();
        String s2 = in.nextLine();

        // 初始化字符串, 用来添加字符
        StringBuilder s = new StringBuilder();
        // 遍历s1和s2字符串
        for (int i = 0; i < s1.length(); i++) {
            // 标记位, 标签当前s1字符串中的字符是否在s2中出现
            boolean flag = false;
            for (int j = 0; j < s2.length(); j++) {
                // s1的字符在s2中出现, 说明当前字符不能添加到字符串中
                if (s1.charAt(i) == s2.charAt(j)) {
                    // 标记位更新
                    flag = true;
                    break;
                }
            }
            // 若标记位未更新, 说明当前s1的字符未在s2中出现, 则把当前字符添加到字符串中
            if (!flag) {
                s.append(s1.charAt(i));
            }
        }
        System.out.println(s.toString());
    }

    /**
     * 法二: 哈希表
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param args
     */
    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入两个字符串
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        // 构造哈希表, Key:保存的字符, Value: 保存当前字符出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        // 把s2中的字符放到哈希表中, 并记录字符出现的次数
        for (int i = 0; i < s2.length(); i++) {
            // 判断当前字符是否在哈希表中, 不存在则加入哈希表中
            if (!map.containsKey(s2.charAt(i))) {
                map.put(s2.charAt(i), 1);
            }
        }

        // 结果字符串
        String s = "";
        // 遍历s1字符串
        for (int i = 0; i < s1.length(); i++) {
            // 判断s1的字符是否在哈希表中存在, 不存在的话则把当前字符添加到字符串中
            if (!map.containsKey(s1.charAt(i))) {
                s += s1.charAt(i);
            }
        }
        System.out.println(s);
    }
}

package task;

public class Day4 {
    /*
    1、在Java中，以下数据类型中,需要内存最多的是（B）
    A: byte B: long C: short D: int
    //解析:byte需要1个字节，long需要8个字节，short需要2个字节，int需要4个字节

    2、以下选项中，switch语句判断条件可以接受的数据类型有哪些 【多选】（ABCD）
    A: int B: byte C: char D: short
    //解析：switch语句中不能接收的数据类型有：浮点型家族、long

    3、有如下代码：请写出程序的输出结果。（B）
    public class Test {
        public static void main(String[] args) {
            int x = 0;
            for (int z = 0; z < 5; z++) {
                if (z>=2) {
                    x++;
                }
            }
            System.out.println(x);
        }
    }
    A: 4 B: 3 C: 1 D: 2

    4、下面结果输出是？（C）
    public class IfTest{
        public static void main(String[]args){
            int x=3;
            int y=1;
            if(x=y)
                System.out.println("Not equal");
            else
                System.out.println("Equal");
        }
    }
    A: The output is “Equal”
    B: The output in “Not Equal”
    C: An error at line 5 causes compilation to fall.
    D: The program executes but does not print a message
    //解析：Java是一门严谨的语言，if、while、for等语句中的判断表达式必须要能得到Boolean类型的值

    5、下列循环语句序列执行完成后，i的值是（C）
    int i;
    for(i=2;i<=10;i++){
        System.out.println(i);
    }
    A: 2 B: 10 C: 11 D: 不确定A
     */

    //代码检测
    public static void main2(String[] args) {
        int x = 3;
        int y = 1;
        if (x == y)
            System.out.println("Not equal");
        else
            System.out.println("Equal");
    }

    public static void main1(String[] args) {
        int x = 0;
        for (int z = 0; z < 5; z++) {
            if (z >= 2) {
                x++;
            }
        }
        System.out.println(x);
    }


    /**
     * 编程题
     */
    /*
    编写一个算法来判断一个数 n 是不是快乐数。
    「快乐数」 定义为：
    对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
    然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
    如果这个过程 结果为 1，那么这个数就是快乐数。
    如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     */

    /**
     * 思路分析：对数进行分割累加求和，判断和是不是1，特殊情况：1和7
     * 时间复杂度：O(n) 空间复杂度：O(1)
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        //在10以内的数字中，1和7是特殊情况
        if (n == 1) {
            return true;
        }

        //7是特殊情况
        while (n > 6) {
            int tmp = n;//临时变量
            int sum = 0;//累加和
            //进行每个数的分割累加
            while (tmp != 0) {
                int x = tmp % 10;
                sum += x * x;
                tmp /= 10;
            }

            //判断累加和的结果是否为1
            if (sum == 1) {
                return true;
            }
            n = sum;//不为1则需要重置
        }
        //小于等于6的情况返回false
        return false;
    }


    /*
    丑数 就是只包含质因数 2、3 和 5 的正整数。
    给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
     */

    /**
     * 思路分析：需要对2、3、5一直整除下去，直到不再含有2、3、5的数，最后判断n是否为1
     * 时间复杂度：O(logn) 空间复杂度：O(1)
     * @param n
     * @return
     */
    public boolean isUgly(int n) {
        //0和负整数不是丑数
        if (n <= 0) {
            return false;
        }

        //分别队2、3、5进行整除，直到不含有2、3、5的因数为止
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        //判断n是否为1
        return n == 1;
    }
}
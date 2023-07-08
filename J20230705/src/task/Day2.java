package task;

public class Day2 {
    /*
    1、下面哪些选项是正确的【多选】（AD）
    A: >>是算术右移操作符
    B: >>是逻辑右移操作符
    C: >>>是算术右移操作符
    D: >>>是逻辑右移操作符
    //解析：>>（算术右移）：低位丢弃，高位补符号位；>>>（逻辑右移）：低位丢弃，高位补无符号位


    2、定义如下程序：
    public static void main(String[] args){
        Double x=1.2;
        long l = 1.2;
        float f = x/l;
        System.out.println(f);
    }
    程序执行结果是？ （D）
    A: 1 B: 1f C: 运行报错 D: 编译报错
    //解析：1.2是double类型的数据，不能直接把double类型的数据直接赋值给long类型

    3、有如下代码：
    public class Test {
        public static void main(String[] args){
            int x = 0;
            int y = 0;
            int k = 0;
            for (int z = 0; z < 5; z++) {
                if ((++x > 2) && (++y > 2) && (k++ > 2)){
                    x++;
                    ++y;
                    k++;
                }
            }

            System.out.println(x + ”” +y + ”” +k);
        }
    }
    请写出程序的输出结果。（B）
    A: 432 B: 531 C: 421 D: 523

    4、下列语句序列执行后，输出结果是：（B）
    public class Ex{
        public static void main(String[]args){
            int a = 13;
            a = a / 5；
            System.out.println(a);
        }
    }
    A: 1 B: 2 C: 3 D: 4
    //解析：整数除法：得到的是整数，省略掉小数；小数除法：得到的小数

    5、以下代码段执行后的输出结果为：（C）
    public class Test {
        public static void main(String args[]) {
            int i = -5;
            i = ++(i++);
            System.out.println(i);
       }
    }
    A: -7 B: -3 C: 编译错误 D: -5
     */

    /*
    答案验证
     */

    public static void main(String[] args) {
        int i = -5;
        //i = ++(i++);
        //解析：++是使用在变量上的，不能使用在表达式上面
        System.out.println(i);
    }

    public static void main3(String[] args) {
        int a = 13;
        a = a / 5;
        System.out.println(a);//2
    }

    public static void main2(String[] args) {
        int x = 0;
        int y = 0;
        int k = 0;
        for (int z = 0; z < 5; z++) {
            if ((++x > 2) && (++y > 2) && (k++ > 2)) {
                x++;
                ++y;
                k++;
            }
        }

        System.out.println(x + "" + y + "" + k);//531
    }

    public static void main1(String[] args) {
        Double x = 1.2;
        //long l = 1.2;//这个需要强制类型转化
        //float f = x/l;//不能直接把double类型的数据
        //System.out.println(f);
    }

    /*
    句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。
    每个单词仅由大小写英文字母组成（不含标点符号）。
    例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
    给你一个句子 s​​​​​​ 和一个整数 k​​​​​​ ，
    请你将 s​​ 截断 ​，​​​使截断后的句子仅含 前 k​​​​​​ 个单词。
    返回 截断 s​​​​​​ 后得到的句子。
     */
    //法一：分割成字符串数组然后统计前k个字符串
    public String truncateSentence1(String s, int k) {
        String[] str = s.split(" ");//把字符串分割成字符串数组
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length && i < k; i++) {
            sb.append(str[i]);//添加字符串到StringBuilder里面
            //最后一个空格不添加
            if (i < k - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    //法二：遇到空格则使k自减，然后k不为把字符添加到StringBuilder中去，为0则跳出循环
    public String truncateSentence(String s, int k) {
        int len = s.length();//长度
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            //判断当前字符是不是字符
            if (s.charAt(i) == ' ') {
                k--;
            }
            //判断k是否为0，为0则跳出循环
            if (k != 0) {
                //不为0则添加到sb中去
                sb.append(s.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
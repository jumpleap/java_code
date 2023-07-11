package task;

@SuppressWarnings({"all"})
public class Day3 {
    /*
    1、以下JAVA程序的运行结果是什么 （D）
    public static void main(String[] args) {
        Double o1 = true ? new Integer(1) : new Double(2.0);
        Object o2;
        if(true){
            o2 = new Integer(1);
        } else {
            o2 = new Double(2.0);
        }
        System.out.print(o1);
        System.out.print(" ");
        System.out.print(o2);
    }
    A: 1 1 B: 1.0 1.0 C: 1 1.0 D: 1.0 1
    //解析：三目运算符以精度最高的来提升精度


    2、以下JAVA程序代码的输出是，定义如下程序：（B）
    public static void main(String args[]) {
        System.out.println(14^3);
    }
    A: 2744 B: 13 C: 17 D: 11
    //解析：1110 ^ 0011 --> 1101


    3、已知 boolean result = false，则下面哪个选项是合法的：【多选】（BD）
    A: result=1 //布尔类型不能转化为其他类型
    B: result=true
    C: if(result!=0) {//so something…}
    D: if(result) {//do something…}
    //解析：Java中的布尔类型不能和其他类型进行转化


    4、以下那些代码段能正确执行： 【多选】（CD）
        A.
    public static void main(String args[]) {
        byte a = 3;
        byte b = 2;
        b = a + b;
        System.out.println(b);
    }

        B.
    public static void main(String args[]) {
        byte a = 127;
        byte b = 126;
        b = a + b;
        System.out.println(b);
    }

        C.
    public static void main(String args[]) {
        byte a = 3;
        byte b = 2;
        a+=b;
        System.out.println(b);
    }

        D.
    public static void main(String args[]) {
        byte a = 127;
        byte b = 127;
        a+=b;
        System.out.println(b);
    }
    //解析：byte进行中的变量进行相加的时候，会导致整型提升为int


    5.以下表达式的类型和值是什么？（注意整数除法）（D）
    -5 + 1/4 + 2*-3 + 5.0
    A: int -3 B: int -4 C: double -5.5 D: double -6.0
    //解析：注意精度的提升
     */


    //代码验证
    public static void main4(String args[]) {
        byte a = 127;
        byte b = 127;
        a += b;
        System.out.println(b);
    }

    public static void main3(String args[]) {
        byte a = 3;
        byte b = 2;
        //b = a + b;//会转化为整型
        System.out.println(b);
    }

    public static void main2(String[] args) {
        Double o1 = true ? new Integer(1) : new Double(2.0);
        Object o2;
        if (true) {
            o2 = new Integer(1);
        } else {
            o2 = new Double(2.0);
        }
        System.out.print(o1);
        System.out.print(" ");
        System.out.print(o2);
    }

    public static void main1(String args[]) {
        System.out.println(14 ^ 3);
    }

    /*
    编程题
     */

    /*
    给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
    不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     */

    /**
     * 思路分析：把不等于val的值重新放入到数组中
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int index = 0;//记录下标
        //遍历数组
        for (int num : nums) {
            //num不等于val
            if (num != val) {
                nums[index++] = num;
            }
        }
        //返回数组的新长度
        return index;
    }

    /*
    罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
    给定一个罗马数字，将其转换成整数。
     */

    /**
     * 思路分析：左右指针：判断左边的数是否比右边大，若是大，则说明不需要减去左指针的值，若是小于，则需要减去左指针的值
     * 时间复杂度：O(n) 空间复杂度：O(1)
     */
    public int romanToInt(String s) {
        int len = s.length();
        int sum = 0;
        //左右指针
        int preNum = getValue(s.charAt(0));
        int lastNum = 0;

        for (int i = 1; i < len; i++) {
            lastNum = getValue(s.charAt(i));
            //判断左指针的值是否小于右指针，小于则减去左指针的值
            if (preNum < lastNum) {
                sum -= preNum;
            } else {
                //大于，加上左指针的值
                sum += preNum;
            }
            //让左右指针右移
            preNum = lastNum;
        }
        //这个时候右指针已经超出字符串长度，左指针刚好到达最后一个
        sum += preNum;
        return sum;

    }

    /**
     * 把罗马数转为对应的整数值
     * @param ch
     * @return
     */
    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
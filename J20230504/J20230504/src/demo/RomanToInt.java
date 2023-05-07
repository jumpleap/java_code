package demo;

import java.util.Scanner;

/**
 *罗马数字转整数
 */
public class RomanToInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;

        //多组输入
        while (scanner.hasNext()) {
            str = scanner.next();
            System.out.println(romanToInt(str));
        }
    }

    /**
     * 罗马数字转整数
     *
     * @param s 字符串
     * @return 返回的整数
     */
    public static int romanToInt(String s) {
        int sum = 0;
        int len = s.length();
        //获取第一个字符
        int preNum = getValue(s.charAt(0));

        for (int i = 1; i < len; i++) {
            int lastNum = getValue(s.charAt(i));
            //判断前面的一个数是否小于后一个数
            if (preNum < lastNum) {
                sum -= preNum;
            } else {
                //大于等于的情况
                sum += preNum;
            }
            //preNum移至下一个值
            preNum = lastNum;
        }
        //加上最后一个值
        sum += preNum;
        return sum;
    }

    /**
     * 罗马字符对应的数字
     *
     * @param ch 字符
     * @return 返回值
     */
    public static int getValue(char ch) {
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

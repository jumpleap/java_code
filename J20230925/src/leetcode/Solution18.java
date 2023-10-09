package leetcode;

public class Solution18 {
    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }

    /**
     * 思路分析: 模拟,遍历数组.
     * 1) 循环遍历字符串, 判断当前下标(左值)和后面一个下标(右值)的值的大小
     * 2) 若左值大于右值,则把这个左值计入sum中
     * 3) 若左值小于右值, 则把这个左值从sum中减去
     * 4) 最后循环数组结束后, 还有最后一个元素需要加上
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param s 给定字符串
     * @return 返回整数
     */
    public static int romanToInt(String s) {
        //用于遍历数组
        int index = 0;
        //数组长度
        int len = s.length();
        //计算和
        int sum = 0;

        //遍历数组
        while (index < len - 1) {
            //左值
            int leftValue = isRoman(s.charAt(index));
            //右值
            int rightValue = isRoman(s.charAt(index + 1));
            //判断大小,若左值大,则加,左值小,则减
            if (leftValue < rightValue) {
                sum -= leftValue;
            } else {
                sum += leftValue;
            }
            index++;
        }
        //最后一个元素也要加上
        sum += isRoman(s.charAt(index));
        return sum;
    }


    private static int isRoman(char ch) {
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
        }
        return -1;
    }
}

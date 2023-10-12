package leetcode;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 数据范围：两个数都满足
 * −10 ≤ num1,num2 ≤ 1000
 * −10≤n≤1000
 * 进阶：空间复杂度 O(1)，时间复杂度 O(1)
 */
public class Solution {
    /**
     * 思路分析: 使用位运算
     * 1) 异或用于计算两个数的和,但是不考虑进位
     * 2) (num1 & num2) << 1, 计算进位值
     * 3) 循环上述代码,直达进位值为0
     * 时间复杂度: O(1), 最多循环31次
     * 空间复杂度: O(1)
     * @param num1 给定数
     * @param num2 给定数
     * @return 返回两数之和
     */
    public int Add(int num1, int num2) {
        //判断num2是否为0
        if (num2 == 0) return num1;
        int sum = 0; //计算总和
        int carry = 0;//计算进位

        while (num2 != 0) {
            sum = num1 ^ num2;//计算和.不考虑进位
            carry = (num1 & num2) << 1;//计算进位
            num1 = sum;//num1用于就算总和
            num2 = carry;//num2用来判断是否需要进位
        }
        return num1;
    }
}
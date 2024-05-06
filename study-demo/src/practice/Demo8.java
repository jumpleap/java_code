package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Demo8 {
    /*
        描述
            正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
        数据范围：
            1≤a,b≤100000
        输入描述：
            输入两个正整数A和B。
        输出描述：
            输出A和B的最小公倍数。
        链接: https://www.nowcoder.com/practice/22948c2cad484e0291350abad86136c3?tpId=37&tqId=21331&ru=/exam/oj
     */

    /**
     * 法一
     * 思路分析: 模拟, 让两个数相乘, 然后sum每次累加其中一个数, 当sum % 两个数都为时, 这个数就是最小公倍数
     * 时间复杂度: O(logN)
     * 空间复杂度: O(1)
     */
    public static void main1(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        // 相乘
        long ret = (long) m * n;

        // 每次累加m
        for (long i = m; i <= ret; i += m) {
            // 判断是不是最小公倍数
            if (i % m == 0 && i % n == 0) {
                System.out.println(i);
                break;
            }
        }
    }


    /**
     * 法二: 数学公式: m x n / gcd(n, m % n)
     *
     * @param args
     */
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        // 获取最大公约数
        int gcd = gcd(m, n);
        System.out.println(m * n / gcd);
    }

    // 求最大公约数
    private static int gcd(int m, int n) {
        if (n == 0) return m;
        return gcd(n, m % n);
    }


    /*
        描述
            给定无序数组arr，返回其中最长的连续序列的长度(要求值连续，位置可以不连续,例如 3,4,5,6为连续的自然数）
            数据范围： 1≤n≤10^5，数组中的值满足 1≤val≤10^8
            要求：空间复杂度 O(n)，时间复杂度 O(nlogn)
        链接: https://www.nowcoder.com/practice/eac1c953170243338f941959146ac4bf?tpId=196&tqId=37143&ru=/exam/oj
     */

    /**
     * 思路分析: 排序 + 双指针
     * 时间复杂度: O(NlogN)
     * 空间复杂度: O(1)
     */
    public int MLS(int[] arr) {
        // 排序
        Arrays.sort(arr);
        int n = arr.length;

        // 从1开始遍历
        int right = 1;
        // 防止只有一个数
        int ret = 1;

        // 遍历
        while (right < n) {
            // 计数器
            int count = 1;
            while (right < n) {
                // 判断当前数和前一个数相减为1
                if (arr[right] - arr[right - 1] == 1) {
                    // 右移, 且计数器自增
                    right++;
                    count++;
                } else if (arr[right] - arr[right - 1] == 0) {
                    // 相等的数, 右移即可
                    right++;
                } else {
                    // 既不相等, 也不相减为1, 跳出
                    break;
                }
            }
            // 获取最大值
            ret = Math.max(ret, count);
            // 右移一位
            right++;
        }
        return ret;
    }


    /*

     */
}

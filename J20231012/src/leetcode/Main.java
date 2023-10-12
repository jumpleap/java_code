package leetcode;

import java.util.Scanner;

/**
 *请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）从棋盘左上角出发沿着边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 * 注：沿棋盘格之间的边缘线行走
 * 数据范围：
 * 1 ≤ m,n ≤ 8
 * 1≤n,m≤8
 */

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int m = in.nextInt();
            int n = in.nextInt();

            System.out.println(getMethodCount(m, n));
        }
    }

    /**
     * 思路分析: 递归
     * 1) 当m == 1或n==1时, 走的方案数为 m + n;
     * 2) 当m > 1, n > 1时. 那么需要一直递归
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     */
    private static int getMethodCount(int m, int n) {
        if (m == 1 || n == 1) return m + n;
        return getMethodCount(m - 1, n) + getMethodCount(m, n - 1);
    }
}
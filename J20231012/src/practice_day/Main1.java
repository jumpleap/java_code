package practice_day;

import java.util.Scanner;

/**
 * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数、
 * 左上角数和右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
 * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3，输入2则输出-1。
 * 数据范围：  1≤n≤10
 */

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = 2 * n - 1; //列
            int[][] nums = new int[n][m];

            //初始化
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nums[i][j] = 0;
                }
            }

            nums[0][0] = 1;
            for (int i = 1; i < n; i++) {
                //第一个数和最后一个数均是1
                nums[i][0] = nums[i][2 * i] = 1;
                for (int j = 1; j < 2 * i; j++) {
                    if (j == 1) { //第二个数
                        nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
                    } else {
                        nums[i][j] = nums[i - 1][j] + nums[i - 1][j - 1] + nums[i - 1][j - 2];
                    }
                }
            }

            int index = 0;
            for (; index < m; index++) {
                if (nums[n - 1][index] % 2 == 0) {
                    System.out.println(index + 1);
                    break;
                }
            }

            if (index == m) {
                System.out.println(-1);
            }
        }
    }
}
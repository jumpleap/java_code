package practice;

import java.util.Scanner;

// day4 - 笔试题
public class Demo4 {
    /*
        描述
            Fibonacci数列是这样定义的：
            F[0] = 0
            F[1] = 1
            for each i ≥ 2: F[i] = F[i-1] + F[i-2]
            因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，
            在Fibonacci数列中的数我们称为Fibonacci数。给你一个N，你想让其变为一个Fibonacci数，
            每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。
        输入描述：
            输入为一个正整数N(1 ≤ N ≤ 1,000,000)
        输出描述：
            输出一个最小的步数变为Fibonacci数"
        链接: https://www.nowcoder.com/practice/18ecd0ecf5ef4fe9ba3f17f8d00d2d66?tpId=122&tqId=33668&ru=/exam/oj
     */

    /**
     * 思路分析: 贪心; 找到目标数的前一个斐波那契数和后一个斐波那契数, 比较那个+1或-1的步数比较小
     * 时间复杂度: O(logN)
     * 空间复杂度: O(1)
     * @param args
     */
    public static void main1(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 定义获取斐波那契数的变量
        int x = 0;
        int y = 1;
        // 获取目标值的后一个斐波那契数
        int sum = 0;
        // 获取目标值的前一个斐波那契数
        int prev = 0;

        while (sum <= n) {
            // 指向sum
            prev = sum;
            // 获取下一个斐波那契数
            sum = x + y;
            // 迭代
            x = y;
            y = sum;
        }

        // 获取最小步数
        System.out.println(Math.min(n - prev, sum - n));
//        if (n - prev < sum - n) {
//            System.out.println(n - prev);
//        } else {
//            System.out.println(sum - n);
//        }
    }


    /*
        描述
            给出一个二维字符数组和一个单词，判断单词是否在数组中出现，
            单词由相邻单元格的字母连接而成，相邻单元指的是上下左右相邻。同一单元格的字母不能多次使用。
        数据范围：
            0 < 行长度 <= 100
            0 < 列长度 <= 100
            0 < 单词长度 <= 1000
        链接: https://www.nowcoder.com/practice/987f2981769048abaf6180ed63266bb2?tpId=196&tqId=39583&ru=/exam/oj
     */
    public boolean exist(String[] board, String word) {
        // 行长度
        int rowSize = board.length;
        // 列长度
        int colSize = board[0].length();
        // 用一个mask数组表示是否被访问过
        boolean[][] mask = new boolean[rowSize][colSize];
        // 遍历不同的起点
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                // 只要有一个起点的递归满足了条件就结束，全部起点都找不到路径就返回false
                if (ifExits(board, word, mask, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    /**
     * 思路分析: 深度优先搜索
     * 时间复杂度: O(N^3)
     * 空间复杂度: O(N)
     */
    private boolean ifExits(String[] board, String word, boolean[][] mask, int i, int j, int index) {
        // 先判断边界条件
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length() || mask[i][j])
            return false;
        // 判断当前字符是否是相等的
        if (board[i].charAt(j) == word.charAt(index)) {
            // 如果相等并且已经到模式串的边界了，直接返回true
            if (index == word.length() - 1) {
                return true;
            }
            // 否则进行一个标记
            mask[i][j] = true;
            // 继续去探索其他的几个方向，不用处理边界，边界在下一次递归开始处理了
            if (ifExits(board, word, mask, i + 1, j, index + 1) ||
                    ifExits(board, word, mask, i, j + 1, index + 1) ||
                    ifExits(board, word, mask, i - 1, j, index + 1) ||
                    ifExits(board, word, mask, i, j - 1, index + 1)) {
                return true;
            }
            // 四个方向都没成功，回退一格，取消此次路径的标记
            mask[i][j] = false;
            // 到这一步说明没找到，返回false
            return false;
        }
        return false;
    }



    /*
        描述
            KiKi知道什么叫杨辉三角之后对杨辉三角产生了浓厚的兴趣，他想知道杨辉三角的前n行，
            请编程帮他解答。杨辉三角，本质上是二项式(a+b)的n次方展开后各项的系数排成的三角形。
            其性质包括：每行的端点数为1， 一个数也为1；每个数等于它左上方和上方的两数之和。
        输入描述：
            第一行包含一个整数数n。 (1≤n≤30)
        输出描述：
            包含n行，为杨辉三角的前n行，每个数输出域宽为5。
        链接: https://www.nowcoder.com/practice/e671c6a913d448318a49be87850adbcc?tpId=290&tqId=39928&ru=/exam/oj
     */

    /**
     * 思路分析: 模拟 + 动态规划
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(N)
     * @param args
     */
    public static void main2(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] triangle = new int[n][];

        // 当只有一个数的时候
//        if (n == 1) {
//            System.out.printf("%5d", 1);
//            return;
//        }

        // 给每列进行开辟空间
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
        }

        // 第一行和第二行
//        triangle[0][0] = triangle[1][0] = triangle[1][1] = 1;

        // 从第二行开始
        for (int i = 0; i < n; i++) {
            // 第一个数为1
            triangle[i][0] = 1;

            // 列从第2个数开始, 到行数-1的位置
            for (int j = 1; j < i; j++) {
                // 获取当前的值
                triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
            }
            // 最后一个数为1
            triangle[i][i] = 1;
        }

        // 打印
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.printf("%5d", triangle[i][j]);
            }
            System.out.println();
        }
    }


    // 法二: 动态规划
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 开辟空间
        int[][] dp = new int[n + 1][n + 1];
        // 第一个数赋值
        dp[1][1] = 1;

        // 获取其他数
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 为上一行左右下标值之和
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        // 打印
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%5d", dp[i][j]);
            }
            System.out.println();
        }
    }
}

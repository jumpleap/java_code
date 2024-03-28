package practice;

// 题目练习
public class Demo9 {
    /*
        一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
        问总共有多少条不同的路径？
        链接: https://leetcode.cn/problems/unique-paths/description/
     */

    /**
     * 思路分析: 需要推导出当m或n为1时的路径数只有1, 其他情况: f(m,n) = f(m-1, n) + f(m, n-1)
     * 法一: 递归
     * 时间复杂度: O(2^m*n)
     * 空间复杂度: O(N)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        // 当有值到达1后, 返回1, 说明只有一种方式到达
        if (m == 1 || n == 1) {
            return 1;
        }
        // return uniquePaths(m-1, n) + uniquePaths(m, n-1);
        // m向上走一步
        int ret1 = uniquePaths(m-1, n);
        // n向下走一步
        int ret2 = uniquePaths(m, n-1);
        // 获取ret1和ret2的总结果数
        return ret1 + ret2;
    }

    /**
     * 法二: 动态规划
     * 时间复杂度: O(M*N)
     * 空间复杂度: O(M*N)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        // 申请数组
        int[][] ans = new int[m][n];

        // 第一行都赋予1
        for (int i = 0; i < m; i++) {
            ans[i][0] = 1;
        }

        // 第一列都赋予1
        for (int i = 0; i < n; i++) {
            ans[0][i] = 1;
        }

        // 两个for循环推导, 对于(i,j)来说, 从左上方向右下方进行推导
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = ans[i-1][j] + ans[i][j-1];
            }
        }
        // 返回终点总数的结果
        return ans[m-1][n-1];
    }
}

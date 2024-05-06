package practice;

import java.util.Arrays;
import java.util.Scanner;

// 笔试题 - day7
public class Demo7 {
    /*
        描述
            读入一个字符串str，输出字符串str中的连续最长的数字串
        输入描述：
            个测试输入包含1个测试用例，一个字符串str，长度不超过255。
        输出描述：
            在一行内输出str中里连续最长的数字串。
        链接: https://www.nowcoder.com/practice/bd891093881d4ddf9e56e7cc8416562d?tpId=182&tqId=34785&ru=/exam/oj
     */

    /**
     * 思路分析: 双指针模拟
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     */
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入
        String str = in.next();
        // 定义数字串的最大长度
        int max = 0;
        // 左右指针
        // 左指针定左边界
        int left = -1;
        // 右指针找数字串
        int right = 0;
        // 把最长的数字串添加到字符串中
        StringBuffer s = new StringBuffer();

        // 遍历
        while (right < str.length()) {
            // 查找数字串
            while (right < str.length() && str.charAt(right) >= '0' && str.charAt(right) <= '9') {
                right++;
            }

            // 判断当前遍历的数字串是否比上次的数字串长
            if (right - left > max) {
                // 更新, 防止里面存储了上次的数字串
                s = new StringBuffer();
                // 获取最大值
                max = right - left;
                // 截取数字串保存在字符串中
                s.append(str.substring(left + 1, right));
            }
            // 重新定义左边界
            left = right;
            // 从左边界的第一个数开始遍历
            right++;

        }
        // 返回数字串
        System.out.println(s.toString());
    }

    /**
     * 建议写法
     */
    public static void main2(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        // 把字符串转为字符数组
        char[] s = in.next().toCharArray();

        // 获取最长子串的起点和终点
        int begin = 0, max = 0;

        // 遍历
        for (int left = 0; left < s.length; left++) {
            // 遇到数字
            if (s[left] >= '0' && s[left] <= '9') {
                // 固定left为起点, right找终点
                int right = left;

                // 找终点
                while (right < s.length && s[right] >= '0' && s[right] <= '9') right++;

                // 判断当前的数字串是不是最长的
                if (right - left > max) {
                    // 当前数字串是最长的, 获取起点和终点
                    begin = left;
                    max = right - left;
                }
                // 不是最长的, 那么跳过当前数字串
                left = right;
            }
        }

        // 遍历最长的数字串
        for (int i = begin; i < begin + max; i++) {
            System.out.print(s[i]);
        }
    }


    /*
        描述
            给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
            岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
            例如：
            输入
            [
            [1,1,0,0,0],
            [0,1,0,1,1],
            [0,0,0,1,1],
            [0,0,0,0,0],
            [0,0,1,1,1]
            ]
            对应的输出为3
            (注：存储的01数据其实是字符'0','1')
        链接: https://www.nowcoder.com/practice/0c9664d1554e466aa107d899418e814e?tpId=196&tqId=37167&ru=/exam/oj
     */

    /**
     * 思路分析: dfs
     */
    // 长度
    int m, n;
    // 定义上下左右
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    // 标记数组
    boolean[][] vis = new boolean[210][210];

    public int solve (char[][] grid) {
        // dfs
        // 获取长度
        m = grid.length;
        n = grid[0].length;

        // 用于统计岛屿数量
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    // 岛屿
                    ret++;
                    dfs(grid, i, j);
                }
            }
        }
        return ret;
    }

    private void dfs(char[][] grid, int i, int j) {
        // 标记为查找过了
        vis[i][j] = true;
        // 进行上下左右四个方向遍历,查找陆地
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1' && !vis[x][y]) {
                // 遍历
                dfs(grid, x, y);
            }
        }
    }


    /*
        题目描述
            给出6根棍子，能否在选出3根拼成一个三角形的同时剩下的3根也能组成一个三角形？
        输入描述:
            首先在一行中给出一个 1 ≤ t ≤ 10^3，代表测试数据的组数
            接下来t行，每行给出6个数字代表棍子长度，棍子长度为正且小于10^9
        输出描述:
            在一行中输出 “Yes” or “No”
        链接：https://ac.nowcoder.com/acm/contest/11163/A
     */

    /**
     * 思路分析: 排序后,枚举
     * 时间复杂度: O(NlogN)
     * 空间复杂度: O(1)
     * @param args
     */
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[6];

        while(n-- != 0) {
            for (int i = 0; i < 6; i++) {
                arr[i] = in.nextInt();
            }

            // 排序
            Arrays.sort(arr);
            boolean ret = isTriangle(arr);
            if (ret) System.out.println("Yes");
            else System.out.println("No");

        }
    }


    private static boolean isTriangle(int[] arr) {
        // 当有其中一个为true, 返回true
        // 列举情况: 0,1,2 and 3,4,5; 0,2,3 and 1,4,5; 0,3,4 and 1,2,5; 0,4,5 and 1,2,3
        if (arr[0] + arr[1] > arr[2] && arr[3] + arr[4] > arr[5]
                || arr[0] + arr[2] > arr[3] && arr[1] + arr[4] > arr[5]
                || arr[0] + arr[3] > arr[4] && arr[1] + arr[2] > arr[5]
                || arr[1] + arr[2] > arr[3] && arr[0] + arr[4] > arr[5]) {
            return true;
        }
        return false;
    }
}
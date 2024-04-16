package practice;

import java.util.Scanner;

// day2 - 笔试题
public class Demo2 {
    /*
        牛牛正在寄快递，他了解到快递在 1kg 以内的按起步价 20 元计算，超出部分按每 kg 1元计算，不足 1kg 部分按 1kg计算。
        如果加急的话要额外付五元，请问牛牛总共要支付多少快递费
        输入描述：
        第一行输入一个单精度浮点数 a 和一个字符 b ，a 表示牛牛要寄的快递的重量，b表示牛牛是否选择加急，
        'y' 表示加急 ，'n' 表示不加急。
        输出描述：
        输出牛牛总共要支付的快递费用
        链接: https://www.nowcoder.com/practice/41b42e7b3c3547e3acf8e90c41d98270?tpId=290&tqId=39852&ru=/exam/oj
     */

    /**
     * 思路分析: 模拟
     * 时间复杂度: O(1)
     * 空间复杂度: O(1)
     * @param args
     */
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 获取数据
        double weight = in.nextDouble();
        int kg = (int) (weight + 0.9);
        char hurry = in.next().charAt(0);

        // 起步价(1kg)
        int sum = 20;
        // 判断是否加急
        if (hurry == 'y') {
            // 加急的需要加上加急的价格
            sum = sum + 5 + kg - 1;
        } else {
            // 无需加急
            sum = sum + kg - 1;
        }
        System.out.println(sum);
    }


    /*
        给定一个字符串数组strs，再给定两个字符串str1和str2，返回在strs中str1和str2的最小距离，
        如果str1或str2为null，或不在strs中，返回-1。
        链接: https://www.nowcoder.com/questionTerminal/2c6a0a8e1d20492f92941400036e0890?page=1&onlyReference=false
     */

    /**
     * 思路分析: 模拟
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param args
     */
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) {
            // 获取s数组的长度
            int n = in.nextInt();
            // s1和s2数组
            String s1 = in.next();
            String s2 = in.next();
            // 往s数组中填充值
            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = in.next();
            }

            // n1记录s1在s数组中的下标
            int n1 = -1;
            // n2记录s2在s数组中的下标
            int n2 = -1;
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                // 获取s1在s数组中的下标
                if (s[i].equals(s1)) {
                    n1 = i;
                    // 获取最小值
                    ans = Math.min(ans, n2 == -1 ? ans : n1 - n2);
                }
                // 获取s2在s数组中的下标
                if (s[i].equals(s2)) {
                    n2 = i;
                    // 获取两个字符串的最小值
                    ans = Math.min(ans, n1 == -1 ? ans : n2 - n1);
                }

                // if(n1 != -1 && n2 != -1 && n2 - n1 < ans) {
                //     ans = Math.min(Math.abs(n2 - n1), ans);
                // }
            }
            // 没有最小距离的两个字符串情况
            if (ans == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                // if (ans == -1) ans = -ans;
                System.out.println(ans);
            }
        }
    }


    /*
        描述
            给定一个整数数组 cost  ，其中 cost[i]  是从楼梯第 i 个台阶向上爬需要支付的费用，下标从0开始。
            一旦你支付此费用，即可选择向上爬一个或者两个台阶。
            你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
            请你计算并返回达到楼梯顶部的最低花费。
            数据范围：数组长度满足 1≤n≤10^5，数组中的值满足 1≤cost[i]≤10^4
        输入描述：
            第一行输入一个正整数 n ，表示数组 cost 的长度。
            第二行输入 n 个正整数，表示数组 cost 的值。
        输出描述：
            输出最低花费
        链接: https://www.nowcoder.com/practice/9b969a3ec20149e3b870b256ad40844e?tpId=230&tqId=39751&ru=/exam/oj
     */
    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] cost = new int[n];

            for (int i = 0; i < n; i++) {
                cost[i] = in.nextInt();
            }
            System.out.println(minCostClimbingStairs(cost));
        }
    }

    /**
     * 思路分析: 动态规划 -> 斐波那契的变种
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param cost
     * @return
     */
    private static int minCostClimbingStairs(int[] cost) {
        // 起始位置, 两个都在
        int first = 0;
        int second = 0;
        // 结果值
        int ans = 0;

        // 从2开始, 因为可以用0,1作为第一起始位置
        for (int i = 2; i <= cost.length; i++) {
            // 获取最小花费
            ans = Math.min(cost[i - 2] + first, cost[i - 1] + second);
            // 迭代
            first = second;
            second = ans;
        }
        // 获取到最小花费
        return ans;
    }
}

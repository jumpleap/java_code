package prefix_sum;

import java.util.Scanner;

// 前缀和
public class Demo1 {
    /*
        描述
            给定一个长度为n的数组 𝑎1,𝑎2,...𝑎𝑛
            接下来有q次查询, 每次查询有两个参数l, r.对于每个询问, 请输出𝑎𝑙+𝑎𝑙+1+...+𝑎𝑟
        输入描述：
            第一行包含两个整数n和q.
            第二行包含n个整数, 表示 𝑎1,𝑎2,...𝑎𝑛
            接下来q行,每行包含两个整数   l和r.
            1≤n,q≤10^5; 1≤l≤r≤n
        输出描述：
            输出q行,每行代表一次查询的结果.
        链接: https://www.nowcoder.com/practice/acead2f4c28c401889915da98ecdc6bf?tpId=230&tqId=2021480&ru=/exam/oj&qru=/ta/dynamic-programming/question-ranking&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196
     */

    /**
     * 思路分析: 前缀和
     *      使用一个数组, 把之前的数全部累加到当前数, 然后通过区间查询
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param args
     */
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] nums = new int[n];
        // 前缀和数组
        long[] ans = new long[n + 1];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            // 累加前面的数
            ans[i + 1] = ans[i] + nums[i];
        }

        // 查询次数
        while (q-- != 0) {
            // 区间
            int l = in.nextInt();
            int r = in.nextInt();

            // 输出结果
            System.out.println(ans[r] - ans[l - 1]);
        }
    }

}

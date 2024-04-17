package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// day3 - 笔试题

/*
    考察知识点:
        1) 快速输入输出的操作
        2) 堆 -> 堆的建立和常用方法
        3) 动态规划(同向双指针)
        4) 字符串分割为字符串数组
 */
public class Demo3 {
    /*
        描述
            规定一种对于复合词的简写方式为只保留每个组成单词的首字母，并将首字母大写后再连接在一起
            比如 “College English Test”可以简写成“CET”，“Computer Science”可以简写为“CS”，“I am Bob”简写为“IAB”
            输入一个长复合词（组成单词数 sum≥1且sum≤100,每个单词长度len≥1且len≤50），请你输出它的简写
        输入描述：
            输入一个复合词
        输出描述：
            输出一行，表示复合词的简写
        链接: https://www.nowcoder.com/practice/0cfa856bf0d649b88f6260d878f35bb4?tpId=290&tqId=39937&ru=/exam/oj
     */
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(spiltStr(s));
    }

    /**
     * 思路分析: 模拟, 把字符串分割成字符串数组, 然后获取第一个单词即可, 小写转大写即可
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param s
     * @return
     */
    private static String spiltStr(String s) {
        // 分割单词
        String[] str = s.split(" ");
        // 用于添加字符串
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            // 获取每个单词的首字母
            char ch = str[i].charAt(0);
            // 大写字母
            if (ch >= 'A' && ch <= 'Z') {
                // 添加到字符串中
                sb.append(ch);
            } else {
                // 小写字母
                ch = (char) (ch - 32);
                sb.append(ch);
            }
        }
        return sb.toString();
        // return sb.toString().toUpperCase();
    }

    /**
     * 推荐写法: 简单
     * @param args
     */
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        // 读取单词(读取的一行有多个单词, 以空格隔开)
        while (in.hasNext()) {
            // 获取单词的第一个字母
            char ch = in.next().charAt(0);
            // 判断是不是小写字母
            if (ch >= 'a' && ch <= 'z') {
                // 转为大写字母
                System.out.print((char) (ch - 32));
            } else {
                // 就是大写字母
                System.out.print(ch);
            }
        }
    }


    /*
        题目描述
            读入n，x,给出n个数a[1],a[2],……,a[n],求最小的区间[l,r]，使a[l]+a[l+1]+……+a[r]≥x，
            若存在相同长度区间，输出l最小的那个
        输入描述:
            第一行两个数，n(1≤n≤10000000),x(1≤x≤10000)
            第二行n个数a[i](1≤a[i]≤1000)
        输出描述:
            输出符合条件l,r(保证有解)
        链接：https://ac.nowcoder.com/acm/contest/11211/F
     */

    // 快速写数据
    public static Read in = new Read();

    /**
     * 思路分析: 滑动窗口(同向双指针)
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param args
     * @throws IOException
     */
    public static void main4(String[] args) throws IOException {
        // 输入数据
        int n = in.nextInt();
        int x = in.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }

        // 定义双指针
        int left = 1, right = 1, sum = 0;
        // 维护最短的区间变量 和 最短区间的值
        int retLeft = -1, retRight = -1, retLen = n;

        while (right <= n) {
            // 进窗口
            sum += arr[right];

            // 判断
            while (sum >= x) {
                // 更新结果
                if (right - left + 1 < retLen) {
                    // 获取最短区间的下标
                    retLeft = left;
                    retRight = right;
                    // 最短区间下标的差值
                    retLen = right - left + 1;
                }
                // 出窗口
                sum -= arr[left++];
            }
            right++;
        }

        System.out.println(retLeft + " " + retRight);
    }


    /*
        题目描述
            给一个数组，一共有 n 个数。
            你能进行最多 k 次操作。每次操作可以进行以下步骤：
            选择数组中的一个偶数 ai，将其变成 ai/2 。
            现在你进行不超过 k 次操作后，让数组中所有数之和尽可能小。请输出这个最小的和。
        链接：https://ac.nowcoder.com/acm/contest/8563/A
     */
    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(modTwo(arr, k));
    }

    /**
     * 思路分析: 优先级队列(大根堆) + 最大数除2
     * 时间复杂度: O(NlogN); logN: 方法offer和poll的时间复杂度
     * 空间复杂度: O(N)
     * @param arr
     * @param k
     * @return
     */
    private static long modTwo(int[] arr, int k) {
        long sum = 0;
        // 建立大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 把偶数都入堆, 奇数累计和
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                sum += arr[i];
            } else {
                queue.offer(arr[i]);
            }
        }

        // 判断k不为0 且 堆不为空
        while (!queue.isEmpty() && k != 0) {
            // 获取堆中最大的值
            int num = queue.poll();
            // /2
            num /= 2;
            // 判断/2后是不是奇数
            if (num % 2 != 0) {
                // 累加到sum中
                sum += num;
            } else {
                // 偶数, 放到堆中
                queue.offer(num);
            }
            // /2次数减1
            k--;
        }

        // 此时, 没有除2的次数了, 累计堆中的所有元素
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }
        // 返回结果
        return sum;
    }
}


class Read {// 自定义快速读入
    StringTokenizer st = new StringTokenizer("");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    String nextLine() throws IOException {
        return bf.readLine();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
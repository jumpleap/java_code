package practice;

import java.util.*;

// day1 - 笔试题
/*
    考察知识点: 栈, 哈希表, 字符串, 多个输入
 */
public class Demo1 {
    /*
        请统计某个给定范围[L, R]的所有整数中，数字2出现的次数。
        比如给定范围[2, 22]，数字2在数2中出现了1次，在数12中出现1次，在数20中出现1次，
        在数21中出现1次，在数22中出现2次，所以数字2在该范围内一共出现了6次。
        链接: https://www.nowcoder.com/practice/179d9754eeaf48a1b9a49dc1d438525a?tpId=290&tqId=39941&ru=/exam/oj
     */
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            // 获取两个数字
            int leftNum = in.nextInt();
            int rightNum = in.nextInt();
            // 进行2的计数
            int ret = getTwoNumber(leftNum, rightNum);
            System.out.println(ret);
        }
    }

    /**
     * 2的计数
     * 思路: 模拟
     * 时间复杂度: O(NlogN) logN为位数
     * 空间复杂度: O(1)
     */
    private static int getTwoNumber(int leftNum, int rightNum) {
        // 计数
        int count = 0;

        // 遍历
        while (leftNum <= rightNum) {
            // 获取当前数
            int tmp = leftNum;
            // 判断当前数中是否含有2, 有则计数
            while (tmp != 0) {
                // 含有2
                if (tmp % 10 == 2) {
                    count++;
                }
                // 获取下一位
                tmp /= 10;
            }
            // 遍历
            leftNum++;
        }
        // 返回2的个数
        return count;
    }


    /*
        给定两个整数数组分别为nums1,nums2，找到它们的公共元素并按返回。
        数据范围：1≤nums1.length,nums2.length≤1000
                1≤nums1[i],nums2[i]≤1000
        链接: https://www.nowcoder.com/practice/56ea71d1f4e94de2aaec10e985874cce?tpId=196&tqId=40269&ru=/exam/oj
     */

    /**
     * 思路分析: 双哈希, 两个哈希表, 第一个用来把nums1去重入元素, 第二个在第一个的基础上比较nums2中的元素是否在第一个哈希表中
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     */
    public ArrayList<Integer> intersection(ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        // 初始化两个哈希表
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // 把nums1的值全部入到set1(去重)
        for (int num : nums1) {
            set1.add(num);
        }
        // 上述循环和下述代码一致
//        Set<Integer> set1 = new HashSet<>(nums1);

        // 遍历: 判断nums2中的元素是否在set1中
        for (int num : nums2) {
            // set1包含nums2中的元素, 说明两个值是两个数组中都有的值
            if (set1.contains(num)) {
                // 保存到set2中, 防止有重复元素, 进行去重
                set2.add(num);
            }
        }

//        ArrayList<Integer> ans = new ArrayList<>(set2);
        // 返回结果
        return new ArrayList<>(set2);
    }


    /*
        牛牛拿到了一个字符串。
        他每次“点击”，可以把字符串中相邻两个相同字母消除，例如，字符串"abbc"点击后可以生成"ac"。
        但相同而不相邻、不相同的相邻字母都是不可以被消除的。
        牛牛想把字符串变得尽可能短。他想知道，当他点击了足够多次之后，字符串的最终形态是什么？
        链接: https://www.nowcoder.com/practice/8d3643ec29654cf8908b5cf3a0479fd5?tpId=308&tqId=40462&ru=/exam/oj
     */
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            // 获取字符串
            String s = in.next();

            // 对字符串进行判断
            s = clickOnDispear(s);
            // 结果判断
            if ("".equals(s)) {
                System.out.println("0");
            } else {
                System.out.println(s);
            }
        }
    }

    /**
     * 思路分析: 辅助栈, 相邻两个元素之间相同则要消除
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     */
    private static String clickOnDispear(String s) {
        // 初始化栈
        Stack<Character> stack = new Stack<>();

        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            // 获取当前字符
            char ch = s.charAt(i);
            // 判断栈空
            if (stack.isEmpty()) {
                // 栈空把元素入栈
                stack.push(ch);
                // 进行下一轮循环
                continue;
            }

            // 栈非空
            // 获取栈顶元素
            char tmp = stack.peek();
            // 判断栈顶元素和当前元素是否相同
            if (tmp == ch) {
                // 相同, 弹出栈顶元素
                stack.pop();
            } else {
                // 不同,入栈
                stack.push(ch);
            }
        }

        // 初始化字符串
        StringBuilder str = new StringBuilder();

        // 栈非空
        while (!stack.isEmpty()) {
            // 把栈中的元素全部放入字符串中
            str.append(stack.pop());
        }
        // 逆置后转为字符串
        return str.reverse().toString();
    }
}

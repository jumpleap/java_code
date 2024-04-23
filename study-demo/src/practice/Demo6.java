package practice;

import util.ListNode;

// day6 - 笔试题
public class Demo6 {
    /*
        以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
        数据范围：s.length,t.length≤100000，字符串仅由'0'~‘9’构成
        要求：时间复杂度O(n)
        链接: https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475?tpId=196&tqId=37176&ru=/exam/oj
     */

    /**
     * 思路分析: 模拟, 注意点: 进位判断, 如何获取字符串中的数字, 最后的进位入字符串
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     */
    public String solve(String s, String t) {
        // 获取字符串长度
        int len1 = s.length() - 1;
        int len2 = t.length() - 1;

        // 初始化可变字符串, 用于存储相加后的字符
        StringBuilder str = new StringBuilder();
        // 用于累计和, 且进位判断
        int sum = 0;
        // 获取当前字符串的数字
        int num = 0;

        // 当字符串均遍历结束跳出循环
        while (len1 >= 0 || len2 >= 0) {
            if (len1 == -1) { // s字符串为空
                // 获取t字符串中的数字
                num = t.charAt(len2) - '0';
                len2--;
            } else if (len2 == -1) { // t字符串为空
                // 获取s字符串中数字
                num = s.charAt(len1) - '0';
                len1--;
            } else { // 均不为空
                // 获取两个字符串中数字之和
                num = s.charAt(len1) - '0' + t.charAt(len2) - '0';
                len1--;
                len2--;
            }
            // 相加,存储到字符串中, 并且进位判断
            sum += num;
            str.append(sum % 10);
            sum /= 10;

        }

        // 还有进位没有入字符串
        if (sum != 0) {
            str.append(sum);
        }
        // 返回结果, 结果需要翻转
        return str.reverse().toString();
    }


    /*
        假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
        给定两个这种链表，请生成代表两个整数相加值的结果链表。
        数据范围：0≤n,m≤1000000，链表任意值 0≤val≤9
        要求：空间复杂度 O(n)，时间复杂度 O(n)
        例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
        链接: https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=196&tqId=37147&ru=/exam/oj
     */

    /**
     * 思路分析: 模拟, 先反转, 再进行相加, 最后再进行反转
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 进行链表翻转
        l1 = reverse(l1);
        l2 = reverse(l2);
        // 连接节点
        ListNode dummy = new ListNode();
        // 新的头节点
        ListNode newHead = dummy;

        // 计算和及其进位
        int sum = 0;
        // 获取链表节点的值
        int num = 0;

        // 当两个链表均为空跳出循环
        while (l1 != null || l2 != null) {
            if (l1 == null) { // l1为空
                // 获取l2的节点值累加
                num = l2.val;
                sum += num;
                l2 = l2.next;
            } else if (l2 == null) { // l2为空
                // 获取l1的节点值累加
                num = l1.val;
                sum += num;
                l1 = l1.next;
            } else { // 均不为空
                // 计算两个节点的值
                num = l1.val + l2.val;
                sum += num;
                l1 = l1.next;
                l2 = l2.next;
            }
            // 把结果添加到新节点中
            ListNode node = new ListNode(sum % 10);
            sum /= 10;
            // 连接新节点, 并跳到新节点的位置
            dummy.next = node;
            dummy = dummy.next;
        }

        // 当还有进位值
        if (sum != 0) {
            // 申请节点并连接
            ListNode node = new ListNode(sum);
            dummy.next = node;
        }
        // 翻转后返回头节点
        return reverse(newHead.next);

    }

    // 链表翻转
    private ListNode reverse(ListNode head) {
        // 判空
        if (head == null) return null;

        // 获取头节点的下一个节点
        ListNode cur = head.next;
        // 头节点后置空, 防止形成环
        head.next = null;
        // 遍历头插
        while (cur != null) {
            // 获取cur的下一个节点
            ListNode tmp = cur.next;
            // 头插
            cur.next = head;
            head = cur;
            // 获取下一个节点
            cur = tmp;
        }
        // 返回反转后的节点
        return head;
    }


    /*
        以字符串的形式读入两个数字，编写一个函数计算它们的乘积，以字符串形式返回。
        数据范围： 读入的数字大小满足0≤n≤10^1000
        要求：空间复杂度 O(m)，时间复杂度O(m^2)（假设m是n的长度）
        链接: https://www.nowcoder.com/practice/c4c488d4d40d4c4e9824c3650f7d5571?tpId=196&tqId=37177&ru=/exam/oj
     */

    /**
     * 思路分析: 模拟; 无进位相乘然后相加, 处理进位, 删除前导0, 翻转后返回字符串
     * 时间复杂度: O(N)
     * 空间复杂度: O(M+N)
     */
    public String solveMultiply(String s, String t) {
        // 把字符串转为字符数组
        char[] ch1 = new StringBuffer(s).reverse().toString().toCharArray();
        char[] ch2 = new StringBuffer(t).reverse().toString().toCharArray();
        // 数字长度
        int m = ch1.length, n = ch2.length;
        // 获取累计和, 保存在数组中
        int[] sum = new int[m + n];

        // 无进位相乘然后相加
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + j] += (ch1[i] - '0') * (ch2[j] - '0');
            }
        }

        // 处理进位
        StringBuffer str = new StringBuffer();
        int c = 0;
        for (int num : sum) {
            c += num;
            str.append(c % 10);
            c /= 10;
        }
        if (c != 0) {
            str.append(c % 10);
            c /= 10;
        }

        // 处理前导0
        while (str.length() > 1 && str.charAt(str.length() - 1) == '0') {
            // 删除前导0
            str.deleteCharAt(str.length() - 1);
        }

        // 翻转后返回
        return str.reverse().toString();
    }
}
